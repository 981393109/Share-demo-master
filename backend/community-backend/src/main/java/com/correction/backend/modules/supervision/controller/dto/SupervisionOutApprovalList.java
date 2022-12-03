package com.correction.backend.modules.supervision.controller.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SupervisionOutApprovalList {


    @ApiModelProperty(value = "矫正单位")
    private String correctionUnit;

    @ApiModelProperty(value = "用户名")
    private String userName;

    @ApiModelProperty(value = "请假事由")
    private String reasonsForLeave;

    @ApiModelProperty(value = "目的地")
    private String destination;

    @ApiModelProperty(value = "出发地")
    private String departure;

    @ApiModelProperty(value = "起始日期")
    private String startDate;

    @ApiModelProperty(value = "截至日期")
    private String endDate;

    @ApiModelProperty(value = "请假天数")
    private String leaveDay;

    @ApiModelProperty(value = "请假程序(审批程序) 0：所级审批  1：区级审批  2 市级审批  请假程序不同对应的进度也有所差别")
    private Integer leaveType;

    private String ref;

    @ApiModelProperty(value =  " 司法所审批意见 1通过 2 不通过")
    private Integer placeApplyOpinion;

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
     * 是否销假 2 否 1 是
     */
    @ApiModelProperty(value = "是否销假 2 否 1 是")
    private Integer terminateLeave;

    /**
     * terminate_delay 是否延期  2 否  1 是
     */
    @ApiModelProperty(value = "是否延期  2 否  1 是")
    private Integer terminateDelay;

    /**
     * terminateCommit 是否确认核实司法所相关材料
     */
    @ApiModelProperty(value = "是否确认核实司法所相关材料")
    private Integer terminateCommit;

    /**
     * terminateDelayDeturn 是否由于特殊原因无法按期返回
     */
    @ApiModelProperty(value = "是否由于特殊原因无法按期返回")
    private Integer terminateDelayDeturn;

    /**
     * terminateDelayDate 延期日期
     */
    @ApiModelProperty(value = "延期日期")
    private String terminateDelayDate;

    /**
     * terminate_return_report 矫正对象返回居住地后，在24小时内向区司法局或司法所报告
     */
    @ApiModelProperty(value = "矫正对象返回居住地后，在24小时内向区司法局或司法所报告")
    private Integer terminateReturnReport;

    /**
     * terminateMaterials 延期销假材料
     */
    @ApiModelProperty(value = "延期销假材料")
    private String terminateMaterials;

}
