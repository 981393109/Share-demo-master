package com.correction.framework.workflow.factory;


import com.correction.framework.workflow.dto.FlowCompleteDTO;
import com.correction.framework.workflow.dto.FlowStartDTO;

/**
 * 流程启动
 */
public interface Flow {

    /**
     * 启动流程,完成自身节点
     */
    ActProcessInstance startFlow(FlowStartDTO flowStartDTO) throws Exception;

    /**
     * 完成任务
     * @param userId
     */
    void complete(Long userId, FlowCompleteDTO flowCompleteDTO);
}
