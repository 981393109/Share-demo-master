package com.correction.backend.modules.survey.constant;

public class SurveyConstant {

    /**
     * 0:未提交，1待指派，2待指派,3待调查，4调查中,5待评估，6评估中，7已评估
     *
     */
    public static final Integer FLOW_STATUS_0 = 0;
    public static final Integer FLOW_STATUS_1 = 1;
    public static final Integer FLOW_STATUS_2 = 2;
    public static final Integer FLOW_STATUS_3 = 3;
    public static final Integer FLOW_STATUS_4 = 4;
    public static final Integer FLOW_STATUS_5 = 5;
    public static final Integer FLOW_STATUS_6 = 6;
    public static final Integer FLOW_STATUS_7 = 7;

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



}
