package com.correction.backend.modules.supervision.service;

import com.correction.backend.modules.supervision.controller.dto.SupervisionFlowDTO;
import com.correction.backend.modules.supervision.controller.dto.SupervisionStartFlowDTO;
import com.correction.framework.workflow.dto.FlowCompleteDTO;
import com.correction.framework.workflow.factory.ActProcessInstance;

public interface SupervisionFlowService {

    /**
     * 启动流程
     * @param reqDTO
     * @return
     * @throws Exception
     */
    ActProcessInstance startFlow(SupervisionStartFlowDTO reqDTO) throws Exception;

    void doComplete(FlowCompleteDTO reqDTO,String type);

    void doFlowComplete(SupervisionFlowDTO reqDTO);


}
