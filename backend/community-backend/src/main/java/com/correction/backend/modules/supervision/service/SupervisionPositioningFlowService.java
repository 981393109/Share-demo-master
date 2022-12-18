package com.correction.backend.modules.supervision.service;

import com.correction.backend.modules.supervision.controller.dto.SupervisionPositioningFlowDTO;
import com.correction.backend.modules.supervision.controller.dto.SupervisionPositioningStartFlowDTO;
import com.correction.framework.workflow.factory.ActProcessInstance;

public interface SupervisionPositioningFlowService {

    /**
     * 启动流程
     * @param reqDTO
     * @return
     * @throws Exception
     */
    ActProcessInstance startFlow(SupervisionPositioningStartFlowDTO reqDTO) throws Exception;

    void doFlowComplete(SupervisionPositioningFlowDTO reqDTO) throws Exception;

}
