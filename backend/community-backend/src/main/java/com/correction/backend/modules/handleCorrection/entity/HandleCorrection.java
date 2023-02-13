package com.correction.backend.modules.handleCorrection.entity;

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
 * 办理入矫表
 * </p>
 *
 * @author yao
 * @since 2022-11-21
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("handle_correction")
public class HandleCorrection extends BaseDO {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 委托类型
     */
    private Integer entrustType;

    /**
     * 委托单位
     */
    private String entrustUnit;

    /**
     * 矫正机关
     */
    private String jurisdictionOffice;

    private Long  jurisdictionOfficeId;


    /**
     * 姓名
     */
    private String name;

    /**
     * 委托时间
     */
    private String entrustDate;

    /**
     * 接收时间
     */
    private String receptionDate;

    /**
     * 调查评估id
     */
    private Long surveyEvaluationId;

    /**
     * 是否开始办理 1 是 0 否
     */
    private Integer isHandle;

    /**
     * 报到类型
     */
    private Integer reportsType;

    /**
     * 情况说明
     */
    private String factSheet;

    /**
     * 是否核对文书
     */
    private Integer isCheckDocuments;

    /**
     * 是否核对身份
     */
    private Integer isCheckIdentity;

    /**
     * 报到超时
     */
    private Integer reportsOvertime;

    /**
     * 超时备注
     */
    private String reportsRemark;

    /**
     * 是否填写
     */
    private Integer isTabfill;

    /**
     * 是否采集生物特征
     */
    private Integer isCollect;

    /**
     * 矫正对象确认并签字确认
     */
    private Integer isSignature;

    /**
     * 核查设备身份
     */
    private Integer checkSysIdentity;

    /**
     * 备注
     */
    private String checkSysRemark;

    /**
     * 是否线下填写报备案通知书
     */
    private Integer isFillBelow;

    /**
     * 是否送达县xx公安局出入境
     */
    private Integer isSendOrg;

    /**
     * 是否完成出入境管理部门确认后存入社区矫正对象档案
     */
    private Integer isSubmitDoc;

    /**
     * 线下开具告知书
     */
    private Integer isFillBelowOpen;

    /**
     * 确认告知书内容，完成签字确认
     */
    private Integer isCommitt;

    /**
     * 线下文书送达至接受的司法所
     */
    private Integer isFillBelowSend;

    /**
     * 确认将矫正档案信息相关文件推送至接受的司法所
     */
    private Integer isAttmentSend;

    /**
     * 进度 0:未提交，1：文书补充，2人员报到，3：材料核实，4信息采集，5位置信息核查手续，6报备手续，7告知书，8矫正档案
     */
    private Integer progress;

    /**
     * 进度 0:未提交，1文书补充中，2办理中，3办理中，4办理中，5办理中，6办理中，7办理中8 办理中，9已结案
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

    private String ref;

    private String processInstanceId;

    /**
     * 组织架构num
     */
    private Long orgNum;

    private String endFlowTime;


    public static final String ID = "id";

    public static final String ENTRUST_TYPE = "entrust_type";

    public static final String ENTRUST_UNIT = "entrust_unit";

    public static final String NAME = "name";

    public static final String ENTRUST_DATE = "entrust_date";

    public static final String RECEPTION_DATE = "reception_date";

    public static final String SURVEY_EVALUATION_ID = "survey_evaluation_id";

    public static final String IS_HANDLE = "is_handle";

    public static final String REPORTS_TYPE = "reports_type";

    public static final String FACT_SHEET = "fact_sheet";

    public static final String IS_CHECK_DOCUMENTS = "is_check_documents";

    public static final String IS_CHECK_IDENTITY = "is_check_identity";

    public static final String REPORTS_OVERTIME = "reports_overtime";

    public static final String REPORTS_REMARK = "reports_remark";

    public static final String IS_TABFILL = "is_tabfill";

    public static final String IS_COLLECT = "is_collect";

    public static final String IS_SIGNATURE = "is_signature";

    public static final String CHECK_SYS_IDENTITY = "check_sys_identity";

    public static final String CHECK_SYS_REMARK = "check_sys_remark";

    public static final String IS_FILL_BELOW = "is_fill_below";

    public static final String IS_SEND_ORG = "is_send_org";

    public static final String IS_SUBMIT_DOC = "is_submit_doc";

    public static final String IS_FILL_BELOW_OPEN = "is_fill_below_open";

    public static final String IS_COMMITT = "is_committ";

    public static final String IS_FILL_BELOW_SEND = "is_fill_below_send";

    public static final String IS_ATTMENT_SEND = "is_attment_send";

    public static final String PROGRESS = "progress";

    public static final String APPLY_STATUS = "apply_status";

    public static final String APPLY_USER = "apply_user";

    public static final String APPLY_NAME = "apply_name";

    public static final String APPLY_TIME = "apply_time";

    public static final String ORG_NUM = "org_num";

    public static final String CREATE_TIME = "create_time";

    public static final String UPDATE_TIME = "update_time";

    public static final String CREATOR = "creator";

    public static final String UPDATER = "updater";

    public static final String DELETED = "deleted";

}
