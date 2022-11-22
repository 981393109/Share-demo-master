package com.correction.backend.modules.sys.service.impl;

import cn.hutool.core.util.IdUtil;
import com.correction.backend.modules.sys.dal.redis.SysLoginUserRedisDAO;
import com.correction.backend.modules.sys.service.SysUserSessionService;
import com.correction.framework.security.config.SecurityProperties;
import com.correction.framework.web.web.LoginUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
@Slf4j
public class SysUserSessionServiceImpl implements SysUserSessionService {


    @Resource
    private SysLoginUserRedisDAO loginUserRedisDAO;

    @Resource
    private SecurityProperties securityProperties;


    @Override
    public String createUserSession(LoginUser loginUser, String userIp, String userAgent) {
        // 生成 Session 编号
        String sessionId = generateSessionId();
        // 写入 Redis 缓存
        loginUser.setUpdateTime(new Date());
        loginUserRedisDAO.set(sessionId, loginUser);
        // 写入 DB 中 ?
        // 返回 Session 编号
        return sessionId;

    }

    @Override
    public LoginUser getLoginUser(String token) {
        return loginUserRedisDAO.get(token);
    }

    @Override
    public void deleteUserSession(String token) {
        // 删除 Redis 缓存
        loginUserRedisDAO.delete(token);
    }

    @Override
    public long getSessionTimeoutMillis() {
        return securityProperties.getSessionTimeout().toMillis();
    }

    @Override
    public void refreshUserSession(String token, LoginUser loginUser) {
        // 写入 Redis 缓存
        loginUser.setUpdateTime(new Date());
        loginUserRedisDAO.set(token, loginUser);
    }

    /**
     * 生成 Session 编号，目前采用 UUID 算法
     *
     * @return Session 编号
     */
    private static String generateSessionId() {
        return IdUtil.fastSimpleUUID();
    }
}
