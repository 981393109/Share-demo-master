package com.correction.backend.modules.cases.controller.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@ApiModel(value="CasesPunishmentPageListDTO", description="处罚案件列表")
public class CasesPunishmentPageListDTO {

    private Long id;

    @ApiModelProperty(value = "矫正单位")
    private String correctionUnit;

    @ApiModelProperty(value = "矫正单位Id")
    private Long correctionUnitId;

    @ApiModelProperty(value = "服刑人员")
    private String userName;

    @ApiModelProperty(value = "服刑人员id")
    private Long userId;

    @ApiModelProperty(value = "违规类型 1:不按规定时间报到。。。2违反关于报告、会客、外出。。。3不按规定参加教育学习 4思保外就医无正当理由。。。5违反禁止令。。6其他违反有关法律。。。")
    private Integer violationsType;

    @ApiModelProperty(value = "701-707 处罚类型建议")
    private Integer violationsTypeAdvice;

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

    @ApiModelProperty(value = "创建时间")
    private Date createTime;


}
