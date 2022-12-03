package com.correction.backend.modules.supervision.controller.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.util.Date;
/**
 * <p>
 * 外出审批流程
 * </p>
 *
 * @author yao
 * @since 2022-12-02
 */
@Getter
@Setter
@ApiModel(value="SupervisionOutApprovalListOutputDTO", description="外出审批流程列表")
public class SupervisionOutApprovalListOutputDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    @ApiModelProperty(value = "矫正单位")
    private String correctionUnit;

    @ApiModelProperty(value = "矫正单位Id")
    private String correctionUnitId;

    @ApiModelProperty(value = "用户名")
    private String userName;

    @ApiModelProperty(value = "用户id")
    private Long userId;

    @ApiModelProperty(value = "目的地")
    private String destination;

    @ApiModelProperty(value = "出发地")
    private String departure;

    @ApiModelProperty(value = "请假事由")
    private String reasonsForLeave;

    @ApiModelProperty(value = "起始日期")
    private String startDate;

    @ApiModelProperty(value = "截至日期")
    private String endDate;

    @ApiModelProperty(value = "请假天数")
    private String leaveDay;

    @ApiModelProperty(value = "两个月内外出时间累计天数")
    private Integer monthLeaveDay;

    @ApiModelProperty(value = "请假程序(审批程序) 0：所级审批  1：区级审批  2 市级审批  请假程序不同对应的进度也有所差别")
    private Integer leaveType;

    @ApiModelProperty(value = "0严格管理社区矫正对象  1非严格管理社区矫正对象")
    private Integer strictType;

    @ApiModelProperty(value = "确认核查核实社区矫正对象外出审批申请理由")
    private Integer investigationCommitOne;

    @ApiModelProperty(value = "确认核查核实社区矫正对象外出审批申请的相关材料")
    private Integer investigationCommitTwo;

    @ApiModelProperty(value = "确认书面告知准予外出的时限")
    private Integer noticeCommitOne;

    @ApiModelProperty(value = "确认书面告知准予外出的目的地")
    private Integer noticeCommitTwo;

    @ApiModelProperty(value = "确认书面告知准予外出需遵守的规定")
    private Integer noticeCommitThree;

    @ApiModelProperty(value = "确认完成上报执行地县级社区矫正机构备案")
    private Integer noticeCommitFour;

    @ApiModelProperty(value = "确认书面告知社区矫正对象外出审批申请不通过")
    private Integer noticeCommitFive;

    @ApiModelProperty(value = "司法所审批意见 1通过 2 不通过")
    private Integer placeApplyOpinion;

    @ApiModelProperty(value = "司法区审批意见 1通过 2 不通过")
    private Integer areaApplyOpinion;

    @ApiModelProperty(value = "司法区审批意见 1通过 2 不通过")
    private Integer cityApplyOpinion;

    @ApiModelProperty(value = "确认通报同级检察院")
    private Integer reportProcuratorate;

    @ApiModelProperty(value = "检察院单位名称")
    private String procuratorateName;

    @ApiModelProperty(value = "进度0未提交 1核查核实 2 司法所审批 3 书面告知/1核查核实 2司法所审批 3区司法局审批 4书面告知 /1核查核实 2司法所审批 3区司法局审批 4市司法局审批 5书面告知  6通报检察院  7结束")
    private Integer progress;

    @ApiModelProperty(value = "进度 0 未审批 1处理中  6结束")
    private Integer applyStatus;

    @ApiModelProperty(value = "申请人code")
    private Long applyUser;

    @ApiModelProperty(value = "申请人名称")
    private String applyName;

    @ApiModelProperty(value = "申请时间")
    private String applyTime;

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
