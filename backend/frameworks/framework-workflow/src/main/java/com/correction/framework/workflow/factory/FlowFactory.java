package com.correction.framework.workflow.factory;


import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 初始化流程工厂
 */
@Slf4j
public class FlowFactory {

    // 用map来保存使用的流程的策略类
    private static Map<String , Flow> strategyMap
            = new ConcurrentHashMap<>();

    // 通过模板名称查找对应的使用策略
    public static Flow getByFlows(String flowName){
        return strategyMap.get(flowName);
    }

    // 将模板和对应的使用策略注册到map里
    public static void register(String flowName, Flow flow) throws Exception {
        log.info("注入流程模板："+flowName);
        if(StringUtils.isBlank(flowName))
            throw new Exception("流程名称不能为空");
        strategyMap.put(flowName, flow);
    }


}
