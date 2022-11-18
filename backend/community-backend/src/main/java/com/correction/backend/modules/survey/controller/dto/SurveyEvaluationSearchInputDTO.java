package com.correction.backend.modules.survey.controller.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.correction.framework.common.pojo.PageParam;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.util.Date;
/**
 * <p>
 * 调查评估记录
 * </p>
 *
 * @author yao
 * @since 2022-11-17
 */
@Getter
@Setter
@ApiModel(value="SurveyEvaluationSearchInputDTO", description="调查评估记录查询表单")
public class SurveyEvaluationSearchInputDTO  extends PageParam  {


    @ApiModelProperty(value = "委托类型")
    private Integer entrustType;

    @ApiModelProperty(value = "委托单位")
    private String entrustUnit;

    @ApiModelProperty(value = "所属辖区")
    private String areaJurisdiction;

    @ApiModelProperty(value = "所属街道")
    private String streetJurisdiction;

    @ApiModelProperty(value = "委托时间")
    private String entrustDate;

    @ApiModelProperty(value = "案由")
    private String causeAction;

    @ApiModelProperty(value = "性别 0:男 1女")
    private Integer sex;

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "出生日期")
    private String birthday;

    @ApiModelProperty(value = "身份证号")
    private String idCard;

    @ApiModelProperty(value = "户籍")
    private String household;

    @ApiModelProperty(value = "籍贯")
    private String nativePlace;

    @ApiModelProperty(value = "联系电话")
    private String mobile;

    @ApiModelProperty(value = "居住地")
    private String placeResidence;

    @ApiModelProperty(value = "婚姻状况")
    private String maritalStatus;

    @ApiModelProperty(value = "职业")
    private String professional;

    @ApiModelProperty(value = "经济状况")
    private String economyState;

    @ApiModelProperty(value = "其他需要说明事项")
    private String ortherInfo;

    @ApiModelProperty(value = "委托单位联系人")
    private String entrustLinkman;

    @ApiModelProperty(value = "联系电话")
    private String entrustMobile;

    @ApiModelProperty(value = "是否通知执行地县级人民检察院")
    private Integer isNotice;

    @ApiModelProperty(value = "确认辖区司法所")
    private Integer isJurisdictionOffice;

    @ApiModelProperty(value = "当前操作人")
    private String jurisdictionUser;

    @ApiModelProperty(value = "是否开始调查")
    private Integer implementStatus;

    @ApiModelProperty(value = "调查小组格式：json  [{userCode:xxx,userName:xxx },{}]")
    private String implementUserGroup;

    @ApiModelProperty(value = "调查类型(完成组织调查)")
    private Integer implementType;

    @ApiModelProperty(value = "调查评估笔录文件")
    private String implementFileRecord;

    @ApiModelProperty(value = "调查评估小组合议表")
    private String implementFileBench;

    @ApiModelProperty(value = "调查评估初步报告")
    private String implementFileReport;

    @ApiModelProperty(value = "当前操作人")
    private String implementUser;

    @ApiModelProperty(value = "是否开始评估")
    private Integer assessmentStatus;

    @ApiModelProperty(value = "完成召开案件评审会")
    private Integer assessmentMeeting;

    @ApiModelProperty(value = "集体评议审核意见表")
    private String assessmentFileBench;

    @ApiModelProperty(value = "调查评估意见书")
    private String assessmentFileOpinion;

    @ApiModelProperty(value = "调查评估表")
    private String assessmentFileSurvey;

    @ApiModelProperty(value = "最后意见")
    private String assessmentLastOpinion;

    @ApiModelProperty(value = "当前操作人")
    private String assessmentUser;

    @ApiModelProperty(value = "文书递送是否完成")
    private Integer surveySendStatus;

    @ApiModelProperty(value = "当前操作人")
    private String surveySendUser;

    @ApiModelProperty(value = "是否完成一人一档")
    private Integer surveyNoticeStatus;

    @ApiModelProperty(value = "当前操作人")
    private String surveyNoticeUser;

    @ApiModelProperty(value = "进度 0:未提交，1登记备案，2上传文书附件，3调查指派，4调查实施，5调查评估，6文书寄送，7一人一档，8流程归档")
    private Integer progress;

    @ApiModelProperty(value = "进度 0:未提交，1待指派，2待指派,3待调查，4调查中,5待评估，6评估中，7已评估")
    private Integer applyStatus;

    @ApiModelProperty(value = "申请人code")
    private String applyUser;

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
