package com.correction.backend.modules.flow.factory.complete;


import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static com.correction.backend.modules.flow.constant.FlowConstant.SURVEY_COMPLETE_FLOW;
import static com.correction.backend.modules.flow.constant.FlowConstant.SURVEY_FLOW;

/**
 * 初始化流程工厂
 */
@Slf4j
public class FlowCompleteFactory {

    // 用map来保存使用的流程的策略类
    private static Map<String , FlowComplete> strategyMap
            = new ConcurrentHashMap<>();

    // 通过模板名称查找对应的使用策略
    public static FlowComplete getByFlows(String flowName){
        return strategyMap.get(flowName);
    }

    // 将模板和对应的使用策略注册到map里
    public static void register(String flowName, FlowComplete flow) throws Exception {
        log.info("注入流程操作模板："+flowName);
        if (!StringUtils.isBlank(flowName)) {
            strategyMap.put(flowName, flow);
        } else {
            throw new Exception("流程操作不能为空");
        }
    }

    public static FlowComplete getByFlowType(String flowType){
        switch (flowType){
            case SURVEY_FLOW:
                return strategyMap.get(SURVEY_COMPLETE_FLOW);
        }
        return null;
    }


}
