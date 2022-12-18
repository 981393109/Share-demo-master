package com.correction.backend.modules.flow.constant;

public class FlowConstant {


    public static final String NORMAL = "0";
    public static final String DELETE = "1";

    /**
     * 流程节点名称 KEY _ INDEX
     */
    public static final String FLOW_NODE_START = "FLOW_NODE_START";
    public static final String FLOW_NODE_USER = "FLOW_NODE_USER";
    public static final String FLOW_NODE_GATEWAY = "FLOW_NODE_GATEWAY";
    public static final String FLOW_NODE_END = "FLOW_NODE_END";


    /**
     * 连接线节点 KEY _ START _ END _ INDEX
     */
    public static final String FLOW_LINE = "FLOW_LINE";

    /**
     * Event
     */
    public static final String EXECUTION_EVENT_START = "start";
    public static final String EXECUTION_EVENT_TAKE = "take";
    public static final String EXECUTION_EVENT_END = "end";


    public static final String TASK_EVENT_CREATE = "create";
    public static final String TASK_EVENT_ASSIGNMENT = "assignment";
    public static final String TASK_EVENT_COMPLETE = "complete";
    public static final String TASK_EVENT_DELETE = "delete";


    /**
     * 多实例
     */
    public static final String ASSIGNEELIST = "assigneeList";
    public static final String ASSIGNEE = "assignee";
    public static final String ASSIGNEEMENT_ASSIGNEE = "${assignee}";
    //默认发起人assignee
    public static final String DEFAULT_START_ASSIGNEE = "${userId}";

    /**
     * 监听器：默认
     */
    public static final String DEFAULT_TASK_LISTENER = "com.correction.backend.modules.flow.listener.TaskFilterListener";
    public static final String DEFAULT_EXECUTION_LISTENER = "com.correction.backend.modules.flow.listener.SignListener";
    public static final String DEFAULT_EXECUTION_PASS = "com.correction.backend.modules.flow.listener.SignPassListener";
    public static final String DEFAULT_EXECUTION_REFUSED = "com.correction.backend.modules.flow.listener.RefuseListener";

    /**
     * 默认通过表达式
     */
    public static final String FLOW_ONE_PASS = "${passCount>0 or refusedCount>0}";
    public static final String FLOW_ALL_PASS = "${passCount/totalCount==1 or refusedCount>0}";
    public static final String FLOW_ALL_PASS_LINK = "${passCount/totalCount==1}";

    public static final String FLOW_ONE_PASS_LINK = "${passCount>0}";
    public static final String FLOW_ONE_REJECTED_LINK = "${rejectedCount>0}";
    public static final String FLOW_ONE_REFUSE = "${refusedCount>0}";

    public static final String PASS_TYPE_ONE = "0";
    public static final String PASS_TYPE_ALL = "1";

    /**
     * 工作流相关
     */
    public static final String TASK_STATUS = "status";
    public static final String TASK_USER_ID = "userId";
    public static final String TASK_BUSINESS_KEY = "businessKey";
    public static final String TASK_COMMENT = "comment";
    public static final String TASK_SUCCESS = "success";
    public static final String TASK_REJECT = "reject";
    public static final String TASK_REJECTED = "rejected";


    /**
     * 流程类型
     */
    public static final String SURVEY_FLOW = "SURVEY_FLOW"; //调查评估
    public static final String HANDLE_CORRECTION_FLOW = "HANDLE_CORRECTION_FLOW"; //办理入矫
    public static final String SUPERVISION_OUT_FLOW_ONE = "SUPERVISION_OUT_FLOW_ONE"; //外出审批1
    public static final String SUPERVISION_OUT_FLOW_TWO = "SUPERVISION_OUT_FLOW_TWO"; //外出审批2
    public static final String SUPERVISION_OUT_FLOW_THREE = "SUPERVISION_OUT_FLOW_THREE"; //外出审批3

    public static final String SUPERVISION_POSITION_FLOW_ONE = "SUPERVISION_POSITION_FLOW_ONE"; //电子定位装置审批1
    public static final String SUPERVISION_POSITION_FLOW_TWO = "SUPERVISION_POSITION_FLOW_TWO"; //电子定位装置审批2
    public static final String SUPERVISION_POSITION_FLOW_THREE = "SUPERVISION_POSITION_FLOW_THREE"; //电子定位装置审批3
    public static final String SUPERVISION_POSITION_FLOW_FOUR = "SUPERVISION_POSITION_FLOW_FOUR"; //电子定位装置审批4


    public static final String CASESPUNISHMENT_FLOW_FIRST = "CASESPUNISHMENT_FLOW_FIRST"; //处罚流程1
    public static final String CASESPUNISHMENT_FLOW_ONE = "CASESPUNISHMENT_FLOW_ONE"; //处罚流程
    public static final String CASESPUNISHMENT_FLOW_TWO = "CASESPUNISHMENT_FLOW_TWO"; //处罚流程
    public static final String CASESPUNISHMENT_FLOW_THREE = "CASESPUNISHMENT_FLOW_THREE"; //处罚流程


    public static final String REWARDRECORD_FLOW_FIRST = "REWARDRECORD_FLOW_FIRST"; //奖励流程
    public static final String REWARDRECORD_FLOW_ONE = "REWARDRECORD_FLOW_ONE"; //奖励流程
    public static final String REWARDRECORD_FLOW_TWO = "REWARDRECORD_FLOW_TWO"; //奖励流程


    public static final String TERMINATION_SOLUTIONS_FLOW = "TERMINATION_SOLUTIONS_FLOW"; //解矫
    public static final String TERMINATION_CORRECT_FLOW = "TERMINATION_CORRECT_FLOW"; //解矫


    /**
     * 提交工程类
     * handle_correction
     */
    public static final String SURVEY_COMPLETE_FLOW = "SURVEY_COMPLETE_FLOW";
    public static final String HANDLE_CORRECTION_COMPLETE_FLOW = "HANDLE_CORRECTION_COMPLETE_FLOW";
    public static final String SUPERVISION_OUT_ONE_COMPLETE_FLOW = "SUPERVISION_OUT_ONE_COMPLETE_FLOW";
    public static final String SUPERVISION_OUT_TWO_COMPLETE_FLOW = "SUPERVISION_OUT_TWO_COMPLETE_FLOW";
    public static final String SUPERVISION_OUT_THREE_COMPLETE_FLOW = "SUPERVISION_OUT_THREE_COMPLETE_FLOW";


    /**
     * 制作文书类
     */
    public static final String DOCUMENT_MAKING_CORRECTION = "DOCUMENT_MAKING_CORRECTION";
}
