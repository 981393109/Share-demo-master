package com.correction.backend.modules.termination.entity;

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
 * 期满解矫
 * </p>
 *
 * @author yao
 * @since 2022-12-18
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("termination_solutions")
public class TerminationSolutions extends BaseDO {

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
     * 监管类型， 暂时默认普管
     */
    private String supervisionLevel;

    /**
     * 执行类别
     */
    private String performType;

    /**
     * 完成对矫正对象的解除矫正审核
     */
    private Integer solutionsComplete;

    /**
     * 批准结果
     */
    private Integer approvalResult;

    /**
     * 完成矫正对象在矫正中心解矫宣告仪式
     */
    private Integer declareComplete;

    /**
     * 矫正对象在《解除社区矫正宣告书》上签字
     */
    private Integer signatureComplete;

    /**
     * 完成与安置帮教部门的衔接工作
     */
    private Integer cohesionComplete;

    /**
     * 1：立案决定，99 结束
     */
    private Integer progress;

    /**
     * 进度 0 未审批  99结束
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
     * 组织id
     */
    private Long orgNum;

    private String endFlowTime;

    private Integer sendProveComplete;

    private String solutionsTime;

    private String correctionTime;

    public static final String ID = "id";

    public static final String CORRECTION_UNIT = "correction_unit";

    public static final String CORRECTION_UNIT_ID = "correction_unit_id";

    public static final String USER_NAME = "user_name";

    public static final String USER_ID = "user_id";

    public static final String SUPERVISION_LEVEL = "supervision_level";

    public static final String PERFORM_TYPE = "perform_type";

    public static final String SOLUTIONS_COMPLETE = "solutions_complete";

    public static final String APPROVAL_RESULT = "approval_result";

    public static final String DECLARE_COMPLETE = "declare_complete";

    public static final String SIGNATURE_COMPLETE = "signature_complete";

    public static final String COHESION_COMPLETE = "cohesion_complete";

    public static final String PROGRESS = "progress";

    public static final String APPLY_STATUS = "apply_status";

    public static final String APPLY_USER = "apply_user";

    public static final String APPLY_NAME = "apply_name";

    public static final String APPLY_TIME = "apply_time";

    public static final String REF = "ref";

    public static final String PROCESS_INSTANCE_ID = "process_instance_id";

    public static final String ORG_NUM = "org_num";

    public static final String CREATE_TIME = "create_time";

    public static final String UPDATE_TIME = "update_time";

    public static final String CREATOR = "creator";

    public static final String UPDATER = "updater";

    public static final String DELETED = "deleted";

}
