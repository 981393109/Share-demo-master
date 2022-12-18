package com.correction.backend.modules.cases.service;

import com.correction.backend.modules.cases.controller.dto.RewardRecordFlowCreateDTO;
import com.correction.backend.modules.cases.controller.dto.RewardRecordFlowDTO;
import com.correction.framework.workflow.factory.ActProcessInstance;

public interface RewardRecordFlowService {

    ActProcessInstance startFlowFirst(RewardRecordFlowCreateDTO reqDTO) throws Exception;

    ActProcessInstance startFlow(RewardRecordFlowCreateDTO reqDTO) throws Exception;

    void doFlowCompleteFirst(RewardRecordFlowDTO reqDTO);

    void doFlowComplete(RewardRecordFlowDTO reqDTO);


}
