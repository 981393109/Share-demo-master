package com.correction.framework.workflow.constant;

/**
 * 状态
 */
public class WorkFlowConstant {

    public static final String TASK_BUSINESS_KEY = "businessKey";

    public static final String TASK_STATUS = "status";

    public static final String TASK_COMMENT = "comment";

    /*通过*/
    public static final String TASK_SUCCESS = "success";

    /*拒绝*/
    public static final String TASK_REJECT = "reject";

    /*驳回*/
    public static final String TASK_REJECTED = "rejected";


    public static final Integer TASK_MU_1 = 1;
    public static final Integer TASK_MU_2 = 2;
    public static final Integer TASK_MU_3 = 3;

    /**
     * adopt 是否通过: 1通过 2:拒绝 3:驳回
     */
    public static final Integer PASS = 1;
    public static final Integer REJECT = 2;
    public static final Integer REJECTED = 3;

}
