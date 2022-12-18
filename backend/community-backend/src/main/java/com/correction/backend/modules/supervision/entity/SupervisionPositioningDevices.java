package com.correction.backend.modules.supervision.entity;

import com.correction.frameworks.mybatis.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import java.io.Serializable;

/**
 * <p>
 * 电子定位装置审批
 * </p>
 *
 * @author yao
 * @since 2022-12-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("supervision_positioning_devices")
public class SupervisionPositioningDevices extends BaseDO {

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
     * 姓名
     */
    private String userName;

    /**
     * 1 提出建议  2延长流程 3 解除流程  4免除流程
     */
    private Integer type;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 使用情形
     */
    private Integer caseUse;

    /**
     * 合议意见
     */
    private String consensusOpinion;

    /**
     * 司法区审批意见 1通过 2 不通过
     */
    private Integer areaApplyOpinion;

    /**
     * 司法行政审批结果 1通过 2 不通过
     */
    private Integer justiceApplyOpinion;

    /**
     * 确认书面告知矫正对象使用电子定位装置 /确认书面告知矫正对象延长电子定位装置/确认书面告知矫正对象解除电子定位装置/确认书面告知矫正对象免除电子定位装置
     */
    private Integer informCommitOne;

    /**
     * 确认抄送县级人民检查院
     */
    private Integer informCommitTwo;

    /**
     * 叫做对象确认签收《使用电子腕带等得装置告知书》
     */
    private Integer informCommitThree;

    /**
     * 确认已给社区矫正对象佩戴电子腕带等定位装置
     */
    private Integer wearDevice;

    /**
     * 确认书面告知矫正对象免除电子定位装置申请不通过
     */
    private Integer informCommitFour;

    /**
     * 确认抄送县级人民检察院
     */
    private Integer informCommitFive;

    /**
     * 0 - 4
     */
    private Integer progress;

    /**
     * 进度 0 未审批 1处理中  4结束
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


    private String orgNum;


    private String ref;

    /**
     * 流程实例ID
     */
    private String processInstanceId;

    private Long sourceId;

    public static final String ID = "id";

    public static final String CORRECTION_UNIT = "correction_unit";

    public static final String CORRECTION_UNIT_ID = "correction_unit_id";

    public static final String USER_NAME = "user_name";

    public static final String TYPE = "type";

    public static final String USER_ID = "user_id";

    public static final String CASE_USE = "case_use";

    public static final String CONSENSUS_OPINION = "consensus_opinion";

    public static final String AREA_APPLY_OPINION = "area_apply_opinion";

    public static final String JUSTICE_APPLY_OPINION = "justice_apply_opinion";

    public static final String INFORM_COMMIT_ONE = "inform_commit_one";

    public static final String INFORM_COMMIT_TWO = "inform_commit_two";

    public static final String INFORM_COMMIT_THREE = "inform_commit_three";

    public static final String WEAR_DEVICE = "wear_device";

    public static final String INFORM_COMMIT_FOUR = "inform_commit_four";

    public static final String INFORM_COMMIT_FIVE = "inform_commit_five";

    public static final String PROGRESS = "progress";

    public static final String APPLY_STATUS = "apply_status";

    public static final String APPLY_USER = "apply_user";

    public static final String APPLY_NAME = "apply_name";

    public static final String APPLY_TIME = "apply_time";

}
