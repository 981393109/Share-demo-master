package com.correction.backend.modules.home.controller.dto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import liquibase.pro.packaged.S;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@ToString
@Getter
@Setter
@Accessors(chain = true)
public class UserRunTaskDTO {

    @ApiModelProperty("用户id")
    private Long userId;

    @ApiModelProperty("流程类型：")
    private String flowType;

    @ApiModelProperty("taskId")
    private String taskId;

    @ApiModelProperty("TaskName")
    private String taskName;

    @ApiModelProperty("processInstanceId")
    private String processInstanceId;

    @ApiModelProperty("dataId")
    private Long dataId;

    @ApiModelProperty("BusinessKey")
    private String businessKey;

    @ApiModelProperty("发起人id")
    private Long startUserId;

    @ApiModelProperty("发起人名称")
    private String startUserName;

    @ApiModelProperty("startTime")
    private String startTime;

}
