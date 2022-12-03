package com.correction.backend.modules.handleCorrection.controller.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class HandleCorrectionListDTO implements Serializable {


    private Long id;

    @ApiModelProperty(value = "委托类型")
    private Integer entrustType;

    @ApiModelProperty(value = "委托单位")
    private String entrustUnit;

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "委托时间")
    private String entrustDate;

    @ApiModelProperty(value = "接收时间")
    private String receptionDate;

    @ApiModelProperty(value = "调查评估id")
    private Long surveyEvaluationId;

    private String ref;

    @ApiModelProperty(value = "流程实例ID")
    private String processInstanceId;

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

    /**
     * 矫正机关
     */
    @ApiModelProperty(value = "jurisdictionOffice")
    private String jurisdictionOffice;

    @ApiModelProperty(value = "jurisdictionOfficeId")
    private Long  jurisdictionOfficeId;

}
