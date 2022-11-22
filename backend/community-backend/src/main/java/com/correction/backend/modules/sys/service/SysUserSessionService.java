package com.correction.backend.modules.sys.service;

import com.correction.framework.web.web.LoginUser;

public interface SysUserSessionService {


    /**
     * 缓存用户信息，返回token
     * @param loginUser
     * @param userIp
     * @param userAgent
     * @return
     */
    String createUserSession(LoginUser loginUser, String userIp, String userAgent);

    /**
     * 根据token得到缓存对象
     * @param token
     * @return
     */
    LoginUser getLoginUser(String token);

    /**
     * 根据token删除缓存对象
     * @param token
     */
    void deleteUserSession(String token);


    long getSessionTimeoutMillis();

    void refreshUserSession(String token, LoginUser loginUser);
}
