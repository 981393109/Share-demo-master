package com.correction.backend.modules.sys.dal.redis;

import com.correction.backend.modules.sys.service.SysUserSessionService;
import com.correction.framework.common.util.json.JsonUtils;
import com.correction.framework.web.web.LoginUser;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.time.Duration;

import static com.correction.backend.modules.sys.enums.SysRedisKeyConstants.LOGIN_USER;


/**
 * {@link LoginUser} 的 RedisDAO
 *
 */
@Repository
public class SysLoginUserRedisDAO {

    @Resource
    private StringRedisTemplate stringRedisTemplate;
    @Resource
    private SysUserSessionService sysUserSessionService;

    public LoginUser get(String sessionId) {
        String redisKey = formatKey(sessionId);
        return JsonUtils.parseObject(stringRedisTemplate.opsForValue().get(redisKey), LoginUser.class);
    }

    public void set(String sessionId, LoginUser loginUser) {
        String redisKey = formatKey(sessionId);
        stringRedisTemplate.opsForValue().set(redisKey, JsonUtils.toJsonString(loginUser),
                Duration.ofMillis(sysUserSessionService.getSessionTimeoutMillis()));
    }

    public void delete(String sessionId) {
        String redisKey = formatKey(sessionId);
        stringRedisTemplate.delete(redisKey);
    }

    private static String formatKey(String sessionId) {
        return String.format(LOGIN_USER.getKeyTemplate(), sessionId);
    }

}
