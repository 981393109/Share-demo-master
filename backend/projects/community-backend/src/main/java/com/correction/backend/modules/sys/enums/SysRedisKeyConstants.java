package com.correction.backend.modules.sys.enums;


import com.correction.framework.redis.core.RedisKeyDefine;
import com.correction.framework.security.core.LoginUser;

import static com.correction.framework.redis.core.RedisKeyDefine.KeyTypeEnum.STRING;

/**
 * System Redis Key 枚举类
 */
public interface SysRedisKeyConstants {

    RedisKeyDefine LOGIN_USER = new RedisKeyDefine("登陆用户的缓存",
            "login_user:%s", // 参数为 sessionId
            STRING, LoginUser.class, RedisKeyDefine.TimeoutTypeEnum.DYNAMIC);

    RedisKeyDefine CAPTCHA_CODE = new RedisKeyDefine("验证码的缓存",
            "captcha_code:%s", // 参数为 uuid
            STRING, String.class, RedisKeyDefine.TimeoutTypeEnum.DYNAMIC);

}
