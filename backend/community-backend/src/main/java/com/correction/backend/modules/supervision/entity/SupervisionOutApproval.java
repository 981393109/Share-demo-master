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
 * 外出审批流程
 * </p>
 *
 * @author yao
 * @since 2022-12-02
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("supervision_out_approval")
public class SupervisionOutApproval extends BaseDO {

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
     * 用户名
     */
    private String userName;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 目的地
     */
    private String destination;

    /**
     * 出发地
     */
    private String departure;

    /**
     * 请假事由
     */
    private String reasonsForLeave;

    /**
     * 起始日期
     */
    private String startDate;

    /**
     * 截至日期
     */
    private String endDate;

    /**
     * 请假天数
     */
    private String leaveDay;

    /**
     * 两个月内外出时间累计天数
     */
    private Integer monthLeaveDay;

    /**
     * 请假程序(审批程序) 0：所级审批  1：区级审批  2 市级审批  请假程序不同对应的进度也有所差别
     */
    private Integer leaveType;

    /**
     * 0严格管理社区矫正对象  1非严格管理社区矫正对象
     */
    private Integer strictType;

    /**
     * 确认核查核实社区矫正对象外出审批申请理由
     */
    private Integer investigationCommitOne;

    /**
     * 确认核查核实社区矫正对象外出审批申请的相关材料
     */
    private Integer investigationCommitTwo;

    /**
     * 确认书面告知准予外出的时限
     */
    private Integer noticeCommitOne;

    /**
     * 确认书面告知准予外出的目的地
     */
    private Integer noticeCommitTwo;

    /**
     * 确认书面告知准予外出需遵守的规定
     */
    private Integer noticeCommitThree;

    /**
     * 确认完成上报执行地县级社区矫正机构备案
     */
    private Integer noticeCommitFour;

    /**
     * 确认书面告知社区矫正对象外出审批申请不通过
     */
    private Integer noticeCommitFive;

    /**
     * 司法所审批意见 1通过 2 不通过
     */
    private Integer placeApplyOpinion;

    /**
     * 司法区审批意见 1通过 2 不通过
     */
    private Integer areaApplyOpinion;

    /**
     * 司法区审批意见 1通过 2 不通过
     */
    private Integer cityApplyOpinion;

    /**
     * 确认通报同级检察院
     */
    private Integer reportProcuratorate;

    /**
     * 检察院单位名称
     */
    private String procuratorateName;

    /**
     * 进度0未提交 1核查核实 2 司法所审批 3 书面告知/1核查核实 2司法所审批 3区司法局审批 4书面告知 /1核查核实 2司法所审批 3区司法局审批 4市司法局审批 5书面告知  6通报检察院  7结束
     */
    private Integer progress;

    /**
     * 进度 0 未审批 1处理中  6结束
     */
    private Integer applyStatus;

    /**
     * orgNum
     */
    private String orgNum;

    /**
     * Ref
     */
    private String ref;

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
     * 流程实例ID
     */
    private String processInstanceId;

    /**
     * 是否销假 0 否 1 是
     */
    private Integer terminateLeave;

    /**
     * terminate_delay 是否延期  2 否  1 是
     */
    private Integer terminateDelay;

    /**
     * terminateCommit 是否确认核实司法所相关材料
     */
    private Integer terminateCommit;

    /**
     * terminateDelayDeturn 是否由于特殊原因无法按期返回
     */
    private Integer terminateDelayDeturn;

    /**
     * terminateDelayDate 延期日期
     */
    private String terminateDelayDate;

    /**
     * terminate_return_report 矫正对象返回居住地后，在24小时内向区司法局或司法所报告
     */
    private Integer terminateReturnReport;

    /**
     * terminateMaterials 延期销假材料
     */
    private String terminateMaterials;


    public static final String ID = "id";

    public static final String CORRECTION_UNIT = "correction_unit";

    public static final String CORRECTION_UNIT_ID = "correction_unit_id";

    public static final String USER_NAME = "user_name";

    public static final String USER_ID = "user_id";

    public static final String DESTINATION = "destination";

    public static final String DEPARTURE = "departure";

    public static final String REASONS_FOR_LEAVE = "reasons_for_leave";

    public static final String START_DATE = "start_date";

    public static final String END_DATE = "end_date";

    public static final String LEAVE_DAY = "leave_day";

    public static final String MONTH_LEAVE_DAY = "month_leave_day";

    public static final String LEAVE_TYPE = "leave_type";

    public static final String STRICT_TYPE = "strict_type";

    public static final String INVESTIGATION_COMMIT_ONE = "investigation_commit_one";

    public static final String INVESTIGATION_COMMIT_TWO = "investigation_commit_two";

    public static final String NOTICE_COMMIT_ONE = "notice_commit_one";

    public static final String NOTICE_COMMIT_TWO = "notice_commit_two";

    public static final String NOTICE_COMMIT_THREE = "notice_commit_three";

    public static final String NOTICE_COMMIT_FOUR = "notice_commit_four";

    public static final String NOTICE_COMMIT_FIVE = "notice_commit_five";

    public static final String PLACE_APPLY_OPINION = "place_apply_opinion";

    public static final String AREA_APPLY_OPINION = "area_apply_opinion";

    public static final String CITY_APPLY_OPINION = "city_apply_opinion";

    public static final String REPORT_PROCURATORATE = "report_procuratorate";

    public static final String PROCURATORATE_NAME = "procuratorate_name";

    public static final String PROGRESS = "progress";

    public static final String APPLY_STATUS = "apply_status";

    public static final String APPLY_USER = "apply_user";

    public static final String APPLY_NAME = "apply_name";

    public static final String APPLY_TIME = "apply_time";

}
