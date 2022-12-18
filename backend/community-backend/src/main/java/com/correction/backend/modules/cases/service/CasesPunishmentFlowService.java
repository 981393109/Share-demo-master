package com.correction.backend.modules.cases.service;

import com.correction.backend.modules.cases.controller.dto.CasesPunishmentFlowCreateDTO;
import com.correction.backend.modules.cases.controller.dto.CasesPunishmentFlowDTO;
import com.correction.framework.workflow.factory.ActProcessInstance;

/**
 * 处罚流程相关接口
 */
public interface CasesPunishmentFlowService {


    ActProcessInstance startFlowFirst(CasesPunishmentFlowCreateDTO reqDTO) throws Exception;

    ActProcessInstance startFlow(CasesPunishmentFlowCreateDTO reqDTO) throws Exception;

    void doFlowCompleteFirst(CasesPunishmentFlowDTO reqDTO);

    void doFlowComplete(CasesPunishmentFlowDTO reqDTO);
}
