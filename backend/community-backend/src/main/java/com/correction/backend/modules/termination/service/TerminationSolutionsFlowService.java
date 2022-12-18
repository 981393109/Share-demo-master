package com.correction.backend.modules.termination.service;

import com.correction.backend.modules.termination.controller.dto.TerminationSolutionsFlowDTO;
import com.correction.backend.modules.termination.controller.dto.TerminationSolutionsStartFlowDTO;
import com.correction.framework.workflow.factory.ActProcessInstance;

/**
 * 流程相关接口
 */
public interface TerminationSolutionsFlowService {


    ActProcessInstance startFlow(TerminationSolutionsStartFlowDTO reqDTO) throws Exception;

    void doFlowComplete(TerminationSolutionsFlowDTO reqDTO);

}
