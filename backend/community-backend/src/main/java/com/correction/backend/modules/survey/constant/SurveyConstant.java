package com.correction.backend.modules.survey.constant;

public class SurveyConstant {

    /**
     * 0:未提交，1待指派，2待指派,3待调查，4调查中,5待评估，6评估中，7已评估, -1 拒绝
     *
     */
    public static final Integer FLOW_STATUS_u1 = -1;
    public static final Integer FLOW_STATUS_0 = 0;
    public static final Integer FLOW_STATUS_1 = 1;
    public static final Integer FLOW_STATUS_2 = 2;
    public static final Integer FLOW_STATUS_3 = 3;
    public static final Integer FLOW_STATUS_4 = 4;
    public static final Integer FLOW_STATUS_5 = 5;
    public static final Integer FLOW_STATUS_6 = 6;
    public static final Integer FLOW_STATUS_7 = 7;
    public static final Integer FLOW_STATUS_8 = 8;
    public static final Integer FLOW_STATUS_9 = 9;
    public static final Integer FLOW_STATUS_10 = 10;

    /**
     * 流程过程
     */
    public static final Integer PROGRESS_u1 = -1;
    public static final Integer PROGRESS_0 = 0;
    public static final Integer PROGRESS_1 = 1;
    public static final Integer PROGRESS_2 = 2;
    public static final Integer PROGRESS_3 = 3;
    public static final Integer PROGRESS_4 = 4;
    public static final Integer PROGRESS_5 = 5;
    public static final Integer PROGRESS_6 = 6;
    public static final Integer PROGRESS_7 = 7;
    public static final Integer PROGRESS_8 = 8;
    public static final Integer PROGRESS_9 = 9;
    public static final Integer PROGRESS_10 = 10;
    public static final Integer PROGRESS_11 = 11;
    public static final Integer PROGRESS_12 = 12;


    /**
     * 文档状态
     */
    public static final Integer DOC_NORMAL = 0;
    public static final Integer DOC_SUC = 1;
    public static final Integer DOC_ERR = 2;

    /**
     * 文书大类
     */
    public static final Integer DICT_TYPE_SURVEY = 2;
    public static final Integer DICT_TYPE_SURVEY_IMPLEMENT = 3;
    public static final Integer DICT_TYPE_SURVEY_ASSESSMENT = 4;

    /**
     * 办理入矫的字典大类
     */
    public static final Integer DICT_TYPE_docSupplement = 5;//文书补充
    public static final Integer DICT_TYPE_userReports = 6; //人员报到
    public static final Integer DICT_TYPE_informationCollection = 7; //信息采集
    public static final Integer DICT_TYPE_reporting = 8; //报备手续材料
    public static final Integer DICT_TYPE_letterNotice = 9; //告知书
    public static final Integer DICT_TYPE_group = 10; //矫正小组
    public static final Integer DICT_TYPE_ways = 11; //矫正方案
    public static final Integer DICT_TYPE_say = 12; //矫正宣告书





}
