package com.correction.backend.modules.handleCorrection.service;


import com.correction.backend.modules.handleCorrection.controller.dto.HandleCorrectionFlowDTO;
import com.correction.backend.modules.handleCorrection.controller.dto.HandleCorrectionFlowListDTO;
import com.correction.framework.workflow.dto.FlowCompleteDTO;
import com.correction.framework.workflow.factory.ActProcessInstance;

public interface HandleCorrectionFlowService {


    ActProcessInstance startFlow(HandleCorrectionFlowListDTO reqDTO) throws Exception;

    void doComplete(FlowCompleteDTO reqDTO);

    void doFlowComplete(HandleCorrectionFlowDTO reqDTO);
}
