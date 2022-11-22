package com.correction.backend.modules.sys.service.impl;

import cn.hutool.json.JSONObject;
import com.correction.backend.modules.sys.controller.dto.auth.SysAuthLoginReqDTO;
import com.correction.backend.modules.sys.controller.dto.logger.SysLoginLogCreateReqDTO;
import com.correction.backend.modules.sys.convert.auth.SysAuthConvert;
import com.correction.backend.modules.sys.convert.sys.MMenuConvert;
import com.correction.backend.modules.sys.convert.user.SysUserConvert;
import com.correction.backend.modules.sys.entity.Menu;
import com.correction.backend.modules.sys.entity.Role;
import com.correction.backend.modules.sys.entity.SysUserDO;
import com.correction.backend.modules.sys.enums.logger.SysLoginLogTypeEnum;
import com.correction.backend.modules.sys.enums.logger.SysLoginResultEnum;
import com.correction.backend.modules.sys.mapper.RoleMenuMapper;
import com.correction.backend.modules.sys.mapper.RoleUserMapper;
import com.correction.backend.modules.sys.service.SysAuthService;
import com.correction.backend.modules.sys.service.SysLoginLogService;
import com.correction.backend.modules.sys.service.SysUserService;
import com.correction.backend.modules.sys.service.SysUserSessionService;
import com.correction.framework.common.enums.CommonStatusEnum;
import com.correction.framework.common.util.servlet.ServletUtils;
import com.correction.framework.web.web.LoginUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.Resource;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.correction.backend.modules.sys.enums.SysErrorCodeConstants.*;
import static com.correction.framework.common.exception.util.ServiceExceptionUtil.exception;

@Service
@Slf4j
public class SysAuthServiceImpl implements SysAuthService {

    @Resource
    @Lazy // 延迟加载，因为存在相互依赖的问题
    private AuthenticationManager authenticationManager;

    @Resource
    private SysUserService userService;

    @Resource
    private SysLoginLogService loginLogService;

    @Resource
    private SysUserSessionService userSessionService;

    @Resource
    private RoleUserMapper roleUserMapper;

    @Resource
    private RoleMenuMapper roleMenuMapper;


    @Override
    public String login(SysAuthLoginReqDTO reqVO, String userIp, String userAgent) {

        // 使用账号密码，进行登陆。
        LoginUser loginUser = this.login0(reqVO.getUsername(), reqVO.getPassword());
        loginUser.setRoleIds(this.getUserRoleIds(loginUser.getId())); // 获取用户角色列表
        // 缓存登陆用户到 Redis 中，返回 sessionId 编号
        return userSessionService.createUserSession(loginUser, userIp, userAgent);
    }

    @Override
    public JSONObject getPermissionInfo(SysUserDO user) {
        //得到用户关联的角色
        List<Role> roleList = roleUserMapper.getRoleByUserId(user.getId());
        //得到角色关联的菜单
        Set<Menu> menuSet = new HashSet<>();
        Set<String> menuCodes = new HashSet<>();
        for (Role role : roleList) {
            List<Menu> menuByRoleId = roleMenuMapper.getMenuByRoleId(role.getId());
            List<String> collect = menuByRoleId.stream().map(e -> e.getCode()).collect(Collectors.toList());
            menuCodes.addAll(collect);
            menuSet.addAll(menuByRoleId);
        }
        JSONObject result = new JSONObject();
        result.put("userInfo", SysUserConvert.INSTANCE.convertInfo(user));
        result.put("codes",menuCodes);
        result.put("menuTree", MMenuConvert.INSTANCE.buildMenuTree(menuSet));
        return result;
    }



    @Override
    public LoginUser verifyTokenAndRefresh(String token) {
// 获得 LoginUser
        LoginUser loginUser = userSessionService.getLoginUser(token);
        if (loginUser == null) {
            return null;
        }
        // 刷新 LoginUser 缓存
        this.refreshLoginUserCache(token, loginUser);
        return loginUser;
    }

    private void refreshLoginUserCache(String token, LoginUser loginUser) {
        // 每 1/3 的 Session 超时时间，刷新 LoginUser 缓存
        if (System.currentTimeMillis() - loginUser.getUpdateTime().getTime() <
                userSessionService.getSessionTimeoutMillis() / 3) {
            return;
        }
        // 重新加载 SysUserDO 信息
        SysUserDO user = userService.getUser(loginUser.getId());
        if (user == null || CommonStatusEnum.DISABLE.getStatus().equals(user.getStatus())) {
            throw exception(TOKEN_EXPIRED); // 校验 token 时，用户被禁用的情况下，也认为 token 过期，方便前端跳转到登陆界面
        }
        // 刷新 LoginUser 缓存
        loginUser.setRoleIds(this.getUserRoleIds(loginUser.getId()));
        userSessionService.refreshUserSession(token, loginUser);
    }



    @Override
    public LoginUser mockLogin(Long userId) {
        // 获取用户编号对应的 SysUserDO
        SysUserDO user = userService.getUser(userId);
        if (user == null) {
            throw new UsernameNotFoundException(String.valueOf(userId));
        }
        // 创建 LoginUser 对象
        LoginUser loginUser = SysAuthConvert.INSTANCE.convert(user);
        loginUser.setRoleIds(this.getUserRoleIds(loginUser.getId())); // 获取用户角色列表
        return loginUser;
    }

    @Override
    public void logout(String token) {
        // 查询用户信息
        LoginUser loginUser = userSessionService.getLoginUser(token);
        if (loginUser == null) {
            return;
        }
        // 删除 session
        userSessionService.deleteUserSession(token);
        // 记录登出日子和
        this.createLogoutLog(loginUser.getUsername());
    }

    @Override
    public UserDetails loadUserByUsername(String userNumber) throws UsernameNotFoundException {
        SysUserDO userByUserNumber = userService.getUserByUserNumber(userNumber);
        if (userByUserNumber == null) {
            throw new UsernameNotFoundException(userNumber);
        }
        if(CommonStatusEnum.DISABLE.getStatus().equals(userByUserNumber.getStatus())) {
            throw new DisabledException(userNumber);
        }
        // 创建 LoginUser 对象
        return SysAuthConvert.INSTANCE.convert(userByUserNumber);
    }

    private LoginUser login0(String username, String password) {
        // 用户验证
        Authentication authentication;
        try {
            // 调用 Spring Security 的 AuthenticationManager#authenticate(...) 方法，使用账号密码进行认证
            // 在其内部，会调用到 loadUserByUsername 方法，获取 User 信息
            authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (BadCredentialsException badCredentialsException) {
            this.createLoginLog(username, SysLoginResultEnum.BAD_CREDENTIALS);
            throw exception(AUTH_LOGIN_BAD_CREDENTIALS);
        } catch (DisabledException disabledException) {
            this.createLoginLog(username, SysLoginResultEnum.USER_DISABLED);
            throw exception(AUTH_LOGIN_USER_DISABLED);
        } catch (AuthenticationException authenticationException) {
            log.error("[login0][username({}) 发生未知异常]", username, authenticationException);
            this.createLoginLog(username, SysLoginResultEnum.UNKNOWN_ERROR);
            throw exception(AUTH_LOGIN_FAIL_UNKNOWN);
        }
        // 登陆成功
        Assert.notNull(authentication.getPrincipal(), "Principal 不会为空");
        this.createLoginLog(username, SysLoginResultEnum.SUCCESS);
        return (LoginUser) authentication.getPrincipal();
    }


    private void createLoginLog(String username, SysLoginResultEnum loginResult) {
        SysLoginLogCreateReqDTO reqVO = new SysLoginLogCreateReqDTO();
        reqVO.setLogType(SysLoginLogTypeEnum.LOGIN_USERNAME.getType());
        reqVO.setUserNumber(username);
        reqVO.setUserAgent(ServletUtils.getUserAgent());
        reqVO.setUserIp(ServletUtils.getClientIP());
        reqVO.setResult(loginResult.getResult());
        loginLogService.createLoginLog(reqVO);
    }

    private void createLogoutLog(String username) {
        SysLoginLogCreateReqDTO reqVO = new SysLoginLogCreateReqDTO();
        reqVO.setLogType(SysLoginLogTypeEnum.LOGOUT_SELF.getType());
        reqVO.setUserNumber(username);
        reqVO.setUserAgent(ServletUtils.getUserAgent());
        reqVO.setUserIp(ServletUtils.getClientIP());
        reqVO.setResult(SysLoginResultEnum.SUCCESS.getResult());
        loginLogService.createLoginLog(reqVO);
    }

    private Set<Long> getUserRoleIds(Long id) {

        return new HashSet<>();
    }

}
