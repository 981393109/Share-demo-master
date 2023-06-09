package com.correction.backend.modules.sys.service;

import cn.hutool.json.JSONObject;
import com.correction.backend.modules.sys.controller.dto.auth.SysAuthLoginReqDTO;
import com.correction.backend.modules.sys.entity.SysUserDO;
import com.correction.framework.security.core.service.SecurityAuthFrameworkService;

/**
 * 登录相关接口
 */
public interface SysAuthService extends SecurityAuthFrameworkService {

    /**
     * 登陆用户
     *
     * @param reqVO 登陆信息
     * @param userIp 用户 IP
     * @param userAgent 用户 UA
     * @return 身份令牌，使用 JWT 方式
     */
    String login (SysAuthLoginReqDTO reqVO, String userIp, String userAgent);


    /**
     * 获取登录用户的菜单权限
     */
    JSONObject getPermissionInfo(SysUserDO user);
}
