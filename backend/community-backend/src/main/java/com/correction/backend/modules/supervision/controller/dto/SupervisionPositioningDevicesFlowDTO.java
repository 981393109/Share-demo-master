package com.correction.backend.modules.supervision.controller.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value="SupervisionPositioningDevicesFlowDTO", description="电子定位装置审批列表")
public class SupervisionPositioningDevicesFlowDTO {

    private Long id;

    @ApiModelProperty(value = "矫正单位")
    private String correctionUnit;

    @ApiModelProperty(value = "矫正单位Id")
    private Long correctionUnitId;

    @ApiModelProperty(value = "姓名")
    private String userName;

    @ApiModelProperty(value = "1 提出建议  2延长流程 3 解除流程  4免除流程")
    private Integer type;

    @ApiModelProperty(value = "用户id")
    private Long userId;

    @ApiModelProperty(value = "使用情形")
    private Integer caseUse;

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

    @ApiModelProperty(value = "申请日期")
    private String applyTime;

    private String ref;

    @ApiModelProperty(value = "司法区审批意见 1通过 2 不通过")
    private Integer areaApplyOpinion;

    @ApiModelProperty(value = "司法行政审批结果 1通过 2 不通过")
    private Integer justiceApplyOpinion;

}
