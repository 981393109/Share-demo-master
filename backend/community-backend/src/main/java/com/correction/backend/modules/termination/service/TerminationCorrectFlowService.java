package com.correction.backend.modules.termination.service;

import com.correction.backend.modules.termination.controller.dto.TerminationCorrectFlowDTO;
import com.correction.backend.modules.termination.controller.dto.TerminationCorrectStartFlowDTO;
import com.correction.framework.workflow.factory.ActProcessInstance;

public interface TerminationCorrectFlowService {


    ActProcessInstance startFlow(TerminationCorrectStartFlowDTO reqDTO) throws Exception;

    void doFlowComplete(TerminationCorrectFlowDTO reqDTO);

}
