package com.correction.backend.modules.cases.entity;

import com.correction.frameworks.mybatis.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import java.io.Serializable;

/**
 * <p>
 * 处罚案件
 * </p>
 *
 * @author yao
 * @since 2022-12-17
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("cases_punishment")
public class CasesPunishment extends BaseDO {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 矫正单位
     */
    private String correctionUnit;

    /**
     * 矫正单位Id
     */
    private Long correctionUnitId;

    /**
     * 服刑人员
     */
    private String userName;

    /**
     * 服刑人员id
     */
    private Long userId;

    /**
     * 违规类型 1:不按规定时间报到。。。2违反关于报告、会客、外出。。。3不按规定参加教育学习 4思保外就医无正当理由。。。5违反禁止令。。6其他违反有关法律。。。
     */
    private Integer violationsType;

    /**
     * 1是 2否  七日内是否立案
     */
    private Integer sevenDaysRecord;

    /**
     * 相关说明
     */
    private String relatedInformation;

    /**
     * 1是 2 否 是否完成合议
     */
    private Integer collegiateBench;

    /**
     * 701-707 处罚类型建议
     */
    private Integer violationsTypeAdvice;

    /**
     * 1是2否 是否完成相关和议意见表、审批表。。。
     */
    private Integer pushRequestComplete;

    /**
     * 是否重新取证
     */
    private Integer reInvestigationEvidence;

    /**
     * 是否重新组织合议论
     */
    private Integer reOrganizeDiscuss;

    /**
     * 初审结论 1 通过 2 不通过
     */
    private Integer trialResult;

    /**
     * 退回理由
     */
    private String backInfo;

    /**
     * 是否完成评议1 2
     */
    private Integer reviewComplete;

    /**
     * 1通过 2 不通过 负责人审批结果
     */
    private Integer chargeApplyResult;

    /**
     * 是否完成文书草拟
     */
    private Integer draftingInstrumentComplete;

    /**
     * 是否完成草拟后的文书送矫正机构法制部门审核
     */
    private Integer sendDraftingInstrumentComplete;

    /**
     * 法制部门审核通过后，由矫正机构负责人盛审核
     */
    private Integer applyDraftingInstrumentComplete;

    /**
     * 统一编号制作并打印文书
     */
    private Integer printDraftingInstrumentComplete;

    /**
     * 是否完成三日内将决定书送达至社区矫正对象家人
     */
    private Integer threeDaysSendCorrection;

    /**
     * 抄送执法地同地级人民检察院
     */
    private Integer sendDuplicate;

    /**
     * 区级社区矫正机构或司法所完成对受处罚矫正对象的线下教育
     */
    private Integer educationComplete;

    /**
     * 是否完成“提请治安管理处罚“ 相关建议书...
     */
    private Integer deliveryComplete;

    /**
     * 完成抄送执行地同级人民检察院
     */
    private Integer sendDuplicateComplete;

    /**
     * 整个处罚案件流程中所有的相关文书已全部上传
     */
    private Integer allDraftingInstrumentUpload;

    /**
     * 是否完成确认完成收监执行的线下流程
     */
    private Integer putPrisonComplete;

    /**
     * 1：立案决定，2组织合议，3推送提请 98：退回重查 4 初审  5评议审核  6负责人审批  7文书制作 8 文书送达 9教育 ，10提请报送 11组卷存单， 12 收监执行 99 结束
     */
    private Integer progress;

    /**
     * 进度 0 未审批   1待立案 2待立案 3待立案 98已退回 4已提起  5已提起 6已提起 7已提起 8已提起 9已审批 10已审批 11已审批  12已执行 99结束
     */
    private Integer applyStatus;

    /**
     * 申请人code
     */
    private Long applyUser;

    /**
     * 申请人名称
     */
    private String applyName;

    /**
     * 申请时间
     */
    private String applyTime;

    /**
     * ref
     */
    private String ref;

    /**
     * 流程实例id
     */
    private String processInstanceId;

    /**
     * ref
     */
    private String nextRef;

    /**
     * 流程实例id
     */
    private String nextProcessInstanceId;

    /**
     * 组织id
     */
    private Long orgNum;

    private String endFlowTime;

    private Integer isBack;

    public static final String ID = "id";

    public static final String CORRECTION_UNIT = "correction_unit";

    public static final String CORRECTION_UNIT_ID = "correction_unit_id";

    public static final String USER_NAME = "user_name";

    public static final String USER_ID = "user_id";

    public static final String VIOLATIONS_TYPE = "violations_type";

    public static final String SEVEN_DAYS_RECORD = "seven_days_record";

    public static final String RELATED_INFORMATION = "related_information";

    public static final String COLLEGIATE_BENCH = "collegiate_bench";

    public static final String VIOLATIONS_TYPE_ADVICE = "violations_type_advice";

    public static final String PUSH_REQUEST_COMPLETE = "push_request_complete";

    public static final String RE_INVESTIGATION_EVIDENCE = "re_investigation_evidence";

    public static final String RE_ORGANIZE_DISCUSS = "re_organize_discuss";

    public static final String TRIAL_RESULT = "trial_result";

    public static final String BACK_INFO = "back_info";

    public static final String REVIEW_COMPLETE = "review_complete";

    public static final String CHARGE_APPLY_RESULT = "charge_apply_result";

    public static final String DRAFTING_INSTRUMENT_COMPLETE = "drafting_instrument_complete";

    public static final String SEND_DRAFTING_INSTRUMENT_COMPLETE = "send_drafting_instrument_complete";

    public static final String APPLY_DRAFTING_INSTRUMENT_COMPLETE = "apply_drafting_instrument_complete";

    public static final String PRINT_DRAFTING_INSTRUMENT_COMPLETE = "print_drafting_instrument_complete";

    public static final String THREE_DAYS_SEND_CORRECTION = "three_days_send_correction";

    public static final String SEND_DUPLICATE = "send_duplicate";

    public static final String EDUCATION_COMPLETE = "education_complete";

    public static final String DELIVERY_COMPLETE = "delivery_complete";

    public static final String SEND_DUPLICATE_COMPLETE = "send_duplicate_complete";

    public static final String ALL_DRAFTING_INSTRUMENT_UPLOAD = "all_drafting_instrument_upload";

    public static final String PUT_PRISON_COMPLETE = "put_prison_complete";

    public static final String PROGRESS = "progress";

    public static final String APPLY_STATUS = "apply_status";

    public static final String APPLY_USER = "apply_user";

    public static final String APPLY_NAME = "apply_name";

    public static final String APPLY_TIME = "apply_time";

    public static final String REF = "ref";

    public static final String PROCESS_INSTANCE_ID = "process_instance_id";

    public static final String NEXT_REF = "next_ref";

    public static final String NEXT_PROCESS_INSTANCE_ID = "next_process_instance_id";

    public static final String ORG_NUM = "org_num";

    public static final String CREATE_TIME = "create_time";

    public static final String UPDATE_TIME = "update_time";

    public static final String CREATOR = "creator";

    public static final String UPDATER = "updater";

    public static final String DELETED = "deleted";

}
