package com.correction.framework.schedule.entity;



import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.correction.frameworks.mybatis.mybatis.core.dataobject.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;


@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("scheduled_task_instance")
public class ScheduledTaskInstance extends BaseDO {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String code;

    private String cron;

    private String global;

    private String implementation;

    private LocalDateTime lastTime;

    private String message;

    private String name;

    private String operator;

    private String status = "0";


}
