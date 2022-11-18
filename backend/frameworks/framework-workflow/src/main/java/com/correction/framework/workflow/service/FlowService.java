package com.correction.framework.workflow.service;

import com.correction.framework.workflow.dto.FlowCompleteDTO;
import com.correction.framework.workflow.dto.FlowStartDTO;
import com.correction.framework.workflow.factory.ActProcessInstance;


public interface FlowService {

    /**
     * 启动流程、并完成自身节点
     */
    ActProcessInstance startFlow ( FlowStartDTO startDTO );

    /**
     * 完成任务
     * @param userId    用户id
     */
    void complete ( Long userId , FlowCompleteDTO flowCompleteDTO );

}
