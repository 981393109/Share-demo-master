package com.correction.framework.workflow.factory;


import com.correction.framework.workflow.dto.FlowStartDTO;

/**
 * 流程启动
 */
public interface Flow {

    /**
     * 启动流程
     */
    ActProcessInstance startFlow(FlowStartDTO flowStartDTO) throws Exception;


}
