package com.correction.backend.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.correction.frameworks.mybatis.mybatis.core.dataobject.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 登陆日志表
 */
@TableName("sys_login_log")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class SysLoginLogDO extends BaseDO {

    /**
     * 日志主键
     */
    private Long id;
    /**
     * 日志类型
     */
    private Integer logType;
    /**
     * 链路追踪编号
     */
    private String traceId;
    /**
     * 用户账号
     *
     * 冗余，因为账号可以变更
     */
    private String username;
    /**
     * 登陆结果
     */
    private Integer result;
    /**
     * 用户 IP
     */
    private String userIp;
    /**
     * 浏览器 UA
     */
    private String userAgent;

}
