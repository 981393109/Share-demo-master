package com.correction.backend.modules.sys.controller;

import cn.hutool.json.JSONObject;
import com.correction.backend.modules.sys.controller.dto.auth.SysAuthLoginReqDTO;
import com.correction.backend.modules.sys.controller.dto.auth.SysAuthLoginRespDTO;
import com.correction.backend.modules.sys.entity.SysUserDO;
import com.correction.backend.modules.sys.service.SysAuthService;
import com.correction.backend.modules.sys.service.SysUserService;
import com.correction.framework.common.pojo.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

import static com.correction.framework.common.pojo.CommonResult.success;
import static com.correction.framework.common.util.servlet.ServletUtils.getClientIP;
import static com.correction.framework.common.util.servlet.ServletUtils.getUserAgent;
import static com.correction.framework.web.web.core.util.WebFrameworkUtils.getLoginUserId;

/**
 * 登录相关接口
 */
@Api(tags = "系统模块-登入模块")
@RestController
@RequestMapping("/")
@Validated
public class LoginController {

    @Resource
    private SysAuthService authService;

    @Resource
    private SysUserService sysUserService;



    @PostMapping("login")
    @ApiOperation("使用账号密码登录")
    public CommonResult<SysAuthLoginRespDTO> login (@RequestBody @Valid SysAuthLoginReqDTO reqVO) {
        String token = authService.login(reqVO, getClientIP(), getUserAgent());
        // 返回结果
        return success(SysAuthLoginRespDTO.builder().token(token).build());
    }


    @GetMapping("/get-permission-info")
    @ApiOperation("获取登陆用户的权限信息")
    public CommonResult getPermissionInfo() {
        // 获得用户信息
        SysUserDO user = sysUserService.getUser(getLoginUserId());
        if (user == null) {
            return null;
        }
        JSONObject permissionInfo = authService.getPermissionInfo(user);
        return success(permissionInfo);
    }


}
