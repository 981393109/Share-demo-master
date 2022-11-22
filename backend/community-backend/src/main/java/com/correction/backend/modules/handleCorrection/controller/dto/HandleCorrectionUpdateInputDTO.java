package com.correction.backend.modules.handleCorrection.controller.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.util.Date;
/**
 * <p>
 * 办理入矫表
 * </p>
 *
 * @author yao
 * @since 2022-11-21
 */
@Getter
@Setter
@ApiModel(value="HandleCorrectionUpdateInputDTO", description="办理入矫表修改表单")
public class HandleCorrectionUpdateInputDTO implements Serializable {

    private static final long serialVersionUID = 1L;

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

    @ApiModelProperty(value = "是否开始办理 1 是 0 否")
    private Integer isHandle;

    @ApiModelProperty(value = "报到类型")
    private Integer reportsType;

    @ApiModelProperty(value = "情况说明")
    private String factSheet;

    @ApiModelProperty(value = "是否核对文书")
    private Integer isCheckDocuments;

    @ApiModelProperty(value = "是否核对身份")
    private Integer isCheckIdentity;

    @ApiModelProperty(value = "报到超时")
    private Integer reportsOvertime;

    @ApiModelProperty(value = "超时备注")
    private String reportsRemark;

    @ApiModelProperty(value = "是否填写")
    private Integer isTabfill;

    @ApiModelProperty(value = "是否采集生物特征")
    private Integer isCollect;

    @ApiModelProperty(value = "矫正对象确认并签字确认")
    private Integer isSignature;

    @ApiModelProperty(value = "核查设备身份")
    private Integer checkSysIdentity;

    @ApiModelProperty(value = "备注")
    private String checkSysRemark;

    @ApiModelProperty(value = "是否线下填写报备案通知书")
    private Integer isFillBelow;

    @ApiModelProperty(value = "是否送达县xx公安局出入境")
    private Integer isSendOrg;

    @ApiModelProperty(value = "是否完成出入境管理部门确认后存入社区矫正对象档案")
    private Integer isSubmitDoc;

    @ApiModelProperty(value = "线下开具告知书")
    private Integer isFillBelowOpen;

    @ApiModelProperty(value = "确认告知书内容，完成签字确认")
    private Integer isCommitt;

    @ApiModelProperty(value = "线下文书送达至接受的司法所")
    private Integer isFillBelowSend;

    @ApiModelProperty(value = "确认将矫正档案信息相关文件推送至接受的司法所")
    private Integer isAttmentSend;

    @ApiModelProperty(value = "进度 0:未提交，1：文书补充，2人员报到，3：材料核实，4信息采集，5位置信息核查手续，6报备手续，7告知书，8矫正档案")
    private Integer progress;

    @ApiModelProperty(value = "进度 0:未提交，1文书补充中，2办理中，3办理中，4办理中，5办理中，6办理中，7办理中8 办理中，9已结案")
    private Integer applyStatus;

    @ApiModelProperty(value = "申请人code")
    private Long applyUser;

    @ApiModelProperty(value = "申请人名称")
    private String applyName;

    @ApiModelProperty(value = "申请时间")
    private String applyTime;

    @ApiModelProperty(value = "组织架构num")
    private String orgNum;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "修改时间")
    private Date updateTime;

    @ApiModelProperty(value = "创建人")
    private String creator;

    @ApiModelProperty(value = "修改人")
    private String updater;

    @ApiModelProperty(value = "是否删除")
    private Boolean deleted;

}
