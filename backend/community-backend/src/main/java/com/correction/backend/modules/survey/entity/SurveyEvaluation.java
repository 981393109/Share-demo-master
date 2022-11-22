package com.correction.backend.modules.survey.entity;

import com.correction.frameworks.mybatis.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import java.io.Serializable;

/**
 * <p>
 * 调查评估记录
 * </p>
 *
 * @author yao
 * @since 2022-11-17
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("survey_evaluation")
public class SurveyEvaluation extends BaseDO {

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
     * 所属辖区
     */
    private String areaJurisdiction;

    /**
     * 所属街道
     */
    private String streetJurisdiction;

    /**
     * 委托时间
     */
    private String entrustDate;

    /**
     * 案由
     */
    private String causeAction;

    /**
     * 性别 0:男 1女
     */
    private Integer sex;

    /**
     * 姓名
     */
    private String name;

    /**
     * 出生日期
     */
    private String birthday;

    /**
     * 身份证号
     */
    private String idCard;

    /**
     * 户籍
     */
    private String household;

    /**
     * 籍贯
     */
    private String nativePlace;

    /**
     * 联系电话
     */
    private String mobile;

    /**
     * 居住地
     */
    private String placeResidence;

    /**
     * 婚姻状况
     */
    private String maritalStatus;

    /**
     * 职业
     */
    private String professional;

    /**
     * 经济状况
     */
    private String economyState;

    /**
     * 其他需要说明事项
     */
    private String ortherInfo;

    /**
     * 委托单位联系人
     */
    private String entrustLinkman;

    /**
     * 联系电话
     */
    private String entrustMobile;

    /**
     * 是否通知执行地县级人民检察院
     */
    private Integer isNotice;

    /**
     * 确认辖区司法所
     */
    private Integer isJurisdictionOffice;


    private String  jurisdictionOffice;

    private Long  jurisdictionOfficeId;


    /**
     * 当前操作人
     */
    private String jurisdictionUser;

    /**
     * 是否开始调查
     */
    private Integer implementStatus;

    /**
     * 调查小组格式：json  [{userCode:xxx,userName:xxx },{}]
     */
    private String implementUserGroup;

    /**
     * 调查类型(完成组织调查)
     */
    private Integer implementType;

    /**
     * 调查评估笔录文件
     */
    private String implementFileRecord;

    /**
     * 调查评估小组合议表
     */
    private String implementFileBench;

    /**
     * 调查评估初步报告
     */
    private String implementFileReport;

    /**
     * 当前操作人
     */
    private String implementUser;

    /**
     * 是否开始评估
     */
    private Integer assessmentStatus;

    /**
     * 完成召开案件评审会
     */
    private Integer assessmentMeeting;

    /**
     * 集体评议审核意见表
     */
    private String assessmentFileBench;

    /**
     * 调查评估意见书
     */
    private String assessmentFileOpinion;

    /**
     * 调查评估表
     */
    private String assessmentFileSurvey;

    /**
     * 最后意见
     */
    private String assessmentLastOpinion;

    /**
     * 当前操作人
     */
    private String assessmentUser;

    /**
     * 文书递送是否完成
     */
    private Integer surveySendStatus;

    /**
     * 当前操作人
     */
    private String surveySendUser;

    /**
     * 是否完成一人一档
     */
    private Integer surveyNoticeStatus;

    /**
     * 当前操作人
     */
    private String surveyNoticeUser;

    /**
     * 进度 0:未提交，1登记备案，2上传文书附件，3调查指派，4调查实施，5调查评估，6文书寄送，7一人一档，8流程归档
     */
    private Integer progress;

    /**
     * 进度 0:未提交，1待指派，2待指派,3待调查，4调查中,5待评估，6评估中，7已评估
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
     * 组织架构num
     */
    private String orgNum;

    private String opinion;

    /**
     * 接受时间
     */
    private String receptionDate;

    private String ref;

    /**
     * 流程实例id
     */
    private String processInstanceId;


    public static final String ID = "id";

    public static final String ENTRUST_TYPE = "entrust_type";

    public static final String ENTRUST_UNIT = "entrust_unit";

    public static final String AREA_JURISDICTION = "area_jurisdiction";

    public static final String STREET_JURISDICTION = "street_jurisdiction";

    public static final String ENTRUST_DATE = "entrust_date";

    public static final String CAUSE_ACTION = "cause_action";

    public static final String SEX = "sex";

    public static final String NAME = "name";

    public static final String BIRTHDAY = "birthday";

    public static final String ID_CARD = "id_card";

    public static final String HOUSEHOLD = "household";

    public static final String NATIVE_PLACE = "native_place";

    public static final String MOBILE = "mobile";

    public static final String PLACE_RESIDENCE = "place_residence";

    public static final String MARITAL_STATUS = "marital_status";

    public static final String PROFESSIONAL = "professional";

    public static final String ECONOMY_STATE = "economy_state";

    public static final String ORTHER_INFO = "orther_info";

    public static final String ENTRUST_LINKMAN = "entrust_linkman";

    public static final String ENTRUST_MOBILE = "entrust_mobile";

    public static final String IS_NOTICE = "is_notice";

    public static final String IS_JURISDICTION_OFFICE = "is_jurisdiction_office";

    public static final String JURISDICTION_USER = "jurisdiction_user";

    public static final String IMPLEMENT_STATUS = "implement_status";

    public static final String IMPLEMENT_USER_GROUP = "implement_user_group";

    public static final String IMPLEMENT_TYPE = "implement_type";

    public static final String IMPLEMENT_FILE_RECORD = "implement_file_record";

    public static final String IMPLEMENT_FILE_BENCH = "implement_file_bench";

    public static final String IMPLEMENT_FILE_REPORT = "implement_file_report";

    public static final String IMPLEMENT_USER = "implement_user";

    public static final String ASSESSMENT_STATUS = "assessment_status";

    public static final String ASSESSMENT_MEETING = "assessment_meeting";

    public static final String ASSESSMENT_FILE_BENCH = "assessment_file_bench";

    public static final String ASSESSMENT_FILE_OPINION = "assessment_file_opinion";

    public static final String ASSESSMENT_FILE_SURVEY = "assessment_file_survey";

    public static final String ASSESSMENT_LAST_OPINION = "assessment_last_opinion";

    public static final String ASSESSMENT_USER = "assessment_user";

    public static final String SURVEY_SEND_STATUS = "survey_send_status";

    public static final String SURVEY_SEND_USER = "survey_send_user";

    public static final String SURVEY_NOTICE_STATUS = "survey_notice_status";

    public static final String SURVEY_NOTICE_USER = "survey_notice_user";

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
