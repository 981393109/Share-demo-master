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

    /**
     * 提交工程类
     * handle_correction
     */
    public static final String SURVEY_COMPLETE_FLOW = "SURVEY_COMPLETE_FLOW";
    public static final String HANDLE_CORRECTION_COMPLETE_FLOW = "HANDLE_CORRECTION_COMPLETE_FLOW";
}
