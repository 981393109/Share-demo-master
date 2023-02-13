package com.correction.backend.modules.information.constant;

import com.correction.backend.modules.flow.constant.FlowConstant;
import com.google.common.collect.ImmutableMap;

import java.util.HashMap;
import java.util.Map;

public class InformationConstant {

    public static final Integer READ = 2;
    public static final Integer UN_READ = 1;

    /**
     * 1：审批 2：通告 3：其他
     */
    public static final Integer FLOW = 1;
    public static final Integer INFO = 2;

    /**
     * 根据流程类型得到信息模板名称
     */
    public static final Map<String,String> flowTitle = new HashMap(){{
        put(FlowConstant.SURVEY_FLOW,"发起了调查评估流程审批");
        put(FlowConstant.HANDLE_CORRECTION_FLOW ,"发起了矫正接收流程审批");
        put(FlowConstant.SUPERVISION_OUT_FLOW_ONE ,"发起了外出申请(7天内)流程审批");
        put(FlowConstant.SUPERVISION_OUT_FLOW_TWO ,"发起了外出申请(8~30天内)流程审批");
        put(FlowConstant.SUPERVISION_OUT_FLOW_THREE ,"发起了外出申请(30天以上)流程审批");
        put(FlowConstant.SUPERVISION_POSITION_FLOW_ONE ,"发起了使用电子定位装置申请流程审批");
        put(FlowConstant.SUPERVISION_POSITION_FLOW_TWO ,"发起了延长电子定位装置申请流程审批");
        put(FlowConstant.SUPERVISION_POSITION_FLOW_THREE ,"发起了解除电子定位装置申请流程审批");
        put(FlowConstant.SUPERVISION_POSITION_FLOW_FOUR ,"发起了免除电子定位装置申请流程审批");
        put(FlowConstant.CASESPUNISHMENT_FLOW_FIRST ,"发起了处罚案件流程审批");
        put(FlowConstant.CASESPUNISHMENT_FLOW_ONE ,"发起了处罚案件流程审批");
        put(FlowConstant.CASESPUNISHMENT_FLOW_TWO ,"发起了处罚案件流程审批");
        put(FlowConstant.CASESPUNISHMENT_FLOW_THREE ,"发起了处罚案件流程审批");
        put(FlowConstant.REWARDRECORD_FLOW_FIRST ,"发起了奖励流程审批");
        put(FlowConstant.REWARDRECORD_FLOW_ONE ,"发起了奖励流程审批");
        put(FlowConstant.REWARDRECORD_FLOW_TWO ,"发起了奖励流程审批");
        put(FlowConstant.TERMINATION_SOLUTIONS_FLOW ,"发起了期满解矫流程审批");
        put(FlowConstant.TERMINATION_CORRECT_FLOW ,"发起了矫正终止流程审批");
    }};

    public static final Integer ENABLE = 1;
    public static final Integer UNENABLE = 2;
}
