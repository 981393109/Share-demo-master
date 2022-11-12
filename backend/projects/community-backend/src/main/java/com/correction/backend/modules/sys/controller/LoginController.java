package com.correction.backend.modules.sys.controller;

import com.correction.backend.modules.sys.controller.dto.auth.SysAuthLoginReqDTO;
import com.correction.backend.modules.sys.controller.dto.auth.SysAuthLoginRespDTO;
import com.correction.backend.modules.sys.service.SysAuthService;
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

/**
 * 登录相关接口
 */
@Api(tags = "登入模块")
@RestController
@RequestMapping("/")
@Validated
public class LoginController {

    @Resource
    private SysAuthService authService;


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
        return null;
    }


    @GetMapping("list-menus")
    @ApiOperation("获得登陆用户的菜单列表")
    public CommonResult getMenus() {
        return null;
    }


}
