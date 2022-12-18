package com.correction.backend.modules.cases.controller.dto;

import com.correction.backend.modules.cases.entity.CollegiateBenchGroup;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 处罚案件
 * </p>
 *
 * @author yao
 * @since 2022-12-17
 */
@Getter
@Setter
@ApiModel(value="CasesPunishmentUpdateInputDTO", description="处罚案件修改表单")
public class CasesPunishmentUpdateInputDTO implements Serializable {

    private static final long serialVersionUID = 1L;

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

    @ApiModelProperty(value = "1是 2否  七日内是否立案")
    private Integer sevenDaysRecord;

    @ApiModelProperty(value = "相关说明")
    private String relatedInformation;

    @ApiModelProperty(value = "1是 2 否 是否完成合议")
    private Integer collegiateBench;

    @ApiModelProperty(value = "701-707 处罚类型建议")
    private Integer violationsTypeAdvice;

    @ApiModelProperty(value = "1是2否 是否完成相关和议意见表、审批表。。。")
    private Integer pushRequestComplete;

    @ApiModelProperty(value = "是否重新取证")
    private Integer reInvestigationEvidence;

    @ApiModelProperty(value = "是否重新组织合议论")
    private Integer reOrganizeDiscuss;

    @ApiModelProperty(value = "初审结论 1 通过 2 不通过")
    private Integer trialResult;

    @ApiModelProperty(value = "退回理由")
    private String backInfo;

    @ApiModelProperty(value = "是否完成评议1 2")
    private Integer reviewComplete;

    @ApiModelProperty(value = "1通过 2 不通过 负责人审批结果")
    private Integer chargeApplyResult;

    @ApiModelProperty(value = "是否完成文书草拟")
    private Integer draftingInstrumentComplete;

    @ApiModelProperty(value = "是否完成草拟后的文书送矫正机构法制部门审核")
    private Integer sendDraftingInstrumentComplete;

    @ApiModelProperty(value = "法制部门审核通过后，由矫正机构负责人盛审核")
    private Integer applyDraftingInstrumentComplete;

    @ApiModelProperty(value = "统一编号制作并打印文书")
    private Integer printDraftingInstrumentComplete;

    @ApiModelProperty(value = "是否完成三日内将决定书送达至社区矫正对象家人")
    private Integer threeDaysSendCorrection;

    @ApiModelProperty(value = "抄送执法地同地级人民检察院")
    private Integer sendDuplicate;

    @ApiModelProperty(value = "区级社区矫正机构或司法所完成对受处罚矫正对象的线下教育")
    private Integer educationComplete;

    @ApiModelProperty(value = "是否完成“提请治安管理处罚“ 相关建议书...")
    private Integer deliveryComplete;

    @ApiModelProperty(value = "完成抄送执行地同级人民检察院")
    private Integer sendDuplicateComplete;

    @ApiModelProperty(value = "整个处罚案件流程中所有的相关文书已全部上传")
    private Integer allDraftingInstrumentUpload;

    @ApiModelProperty(value = "是否完成确认完成收监执行的线下流程")
    private Integer putPrisonComplete;

    @ApiModelProperty(value = "1：立案决定，2组织合议，3推送提请 98：退回重查 4 初审  5评议审核  6负责人审批  7文书制作 8 文书送达 9教育 ，10提请报送 11组卷存单， 12 收监执行 99 结束")
    private Integer progress;

    @ApiModelProperty(value = "进度 0 未审批   1待立案 2待立案 3待立案 98已退回 4已提起  5已提起 6已提起 7已提起 8已提起 9已审批 10已审批 11已审批  12已执行 99结束")
    private Integer applyStatus;

    @ApiModelProperty(value = "申请人code")
    private Long applyUser;

    @ApiModelProperty(value = "申请人名称")
    private String applyName;

    @ApiModelProperty(value = "申请时间")
    private String applyTime;

    @ApiModelProperty(value = "ref")
    private String ref;

    @ApiModelProperty(value = "流程实例id")
    private String processInstanceId;

    @ApiModelProperty(value = "ref")
    private String nextRef;

    @ApiModelProperty(value = "流程实例id")
    private String nextProcessInstanceId;

    @ApiModelProperty(value = "组织id")
    private Long orgNum;

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

    @ApiModelProperty(value = "合议小组")
    List<CollegiateBenchGroup> collegiateBenchGroups;

    @ApiModelProperty(value = "评议小组")
    List<CollegiateBenchGroup> reviewGroups;

}
