package com.correction.backend.modules.cases.controller.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class RewardRecordPageListDTO {


    private Long id;

    @ApiModelProperty(value = "矫正单位")
    private String correctionUnit;

    @ApiModelProperty(value = "矫正单位Id")
    private Long correctionUnitId;

    @ApiModelProperty(value = "服刑人员")
    private String userName;

    @ApiModelProperty(value = "服刑人员id")
    private Long userId;

    @ApiModelProperty(value = "表现类型 1 -6")
    private Integer rewardType;

    @ApiModelProperty(value = "801-802 表扬类型类型建议")
    private Integer rewardTypeAdvice;

    @ApiModelProperty(value = "ref")
    private String ref;

    @ApiModelProperty(value = "流程实例id(第一个流程的)")
    private String processInstanceId;

    @ApiModelProperty(value = "ref")
    private String nextRef;

    @ApiModelProperty(value = "流程实例id(第二个流程的)")
    private String nextProcessInstanceId;

    @ApiModelProperty(value = "待操作人")
    private String nextUser;

    @ApiModelProperty(value = "申请人Id")
    private Long applyUser;

    @ApiModelProperty(value = "待操作人")
    private String nextUserName;

    @ApiModelProperty(value = "taskId")
    private String taskId;

    @ApiModelProperty(value = "progress")
    private Integer progress;

    @ApiModelProperty(value = "applyStatus")
    private Integer applyStatus;

    @ApiModelProperty(value = "flowStatus")
    private Integer flowStatus;
}
