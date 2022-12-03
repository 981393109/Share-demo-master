package com.correction.backend.modules.information.constant;

import com.correction.backend.modules.flow.constant.FlowConstant;
import com.google.common.collect.ImmutableMap;

import java.util.Map;

public class InformationConstant {

    public static final Integer READ = 1;
    public static final Integer UN_READ = 0;

    /**
     * 1：审批 2：通告 3：其他
     */
    public static final Integer FLOW = 1;
    public static final Integer INFO = 2;

    /**
     * 根据流程类型得到信息模板名称
     */
    public static final Map<String,String> flowTitle = ImmutableMap.of(
            FlowConstant.SURVEY_FLOW , "发起了调查评估流程审批",
            FlowConstant.HANDLE_CORRECTION_FLOW ,"发起了矫正接收流程审批"
    );

}
