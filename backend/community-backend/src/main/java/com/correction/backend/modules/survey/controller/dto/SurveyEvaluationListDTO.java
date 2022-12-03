package com.correction.backend.modules.survey.controller.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@ApiModel(value="SurveyEvaluationListDTO", description="调查评估记录列表")
public class SurveyEvaluationListDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    @ApiModelProperty(value = "委托类型")
    private Integer entrustType;

    @ApiModelProperty(value = "委托单位")
    private String entrustUnit;

    @ApiModelProperty(value = "所属辖区")
    private String areaJurisdiction;

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "委托时间")
    private String entrustDate;

    @ApiModelProperty(value = "最后意见")
    private Integer assessmentLastOpinion;

    @ApiModelProperty(value = "接收时间")
    private String receptionDate;

    @ApiModelProperty(value = "进度 0:未提交，1登记备案，2上传文书附件，3调查指派，4调查实施，5调查评估，6文书寄送，7一人一档，8流程归档")
    private Integer progress;

    @ApiModelProperty(value = "进度 0:未提交，1待指派，2待指派,3待调查，4调查中,5待评估，6评估中，7已评估")
    private Integer applyStatus;

    @ApiModelProperty(value = "applyUser")
    private Long applyUser;

    @ApiModelProperty(value = "flowStatus")
    private Integer flowStatus;

    @ApiModelProperty(value = "待操作人")
    private String nextUser;

    @ApiModelProperty(value = "矫正机构")
    private String jurisdictionOffice;

    @ApiModelProperty(value = "待操作人")
    private String nextUserName;

    @ApiModelProperty(value = "taskId")
    private String taskId;

}
