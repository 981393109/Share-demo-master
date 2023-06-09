package com.correction.backend.modules.termination.controller.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(value="TerminationSolutionsPageListDTO", description="列表")
public class TerminationSolutionsPageListDTO {

    private Long id;

    @ApiModelProperty(value = "矫正单位")
    private String correctionUnit;

    @ApiModelProperty(value = "矫正单位Id")
    private Long correctionUnitId;

    @ApiModelProperty(value = "服刑人员")
    private String userName;

    @ApiModelProperty(value = "服刑人员id")
    private Long userId;

    @ApiModelProperty(value = "监管类型， 暂时默认普管")
    private String supervisionLevel;

    @ApiModelProperty(value = "执行类别")
    private String performType;

    @ApiModelProperty(value = "ref")
    private String ref;

    @ApiModelProperty(value = "流程实例id(第一个流程的)")
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

    private String solutionsTime;

    private String correctionTime;

    @ApiModelProperty(value = "终止原因")
    private Integer terminationReason;

}
