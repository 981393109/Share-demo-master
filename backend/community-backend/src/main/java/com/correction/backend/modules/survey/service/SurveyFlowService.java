package com.correction.backend.modules.survey.service;

import com.correction.backend.modules.flow.entity.FlowNodeUser;
import com.correction.backend.modules.survey.controller.dto.SurveryCompaleFlowDTO;
import com.correction.backend.modules.survey.controller.dto.SurveryEvaluationFlowDTO;
import com.correction.framework.workflow.dto.FlowCompleteDTO;
import com.correction.framework.workflow.factory.ActProcessInstance;

import java.util.List;

/**
 * 调查评估流程接口
 */
public interface SurveyFlowService {


    /**
     * 提交调查评估
     */
    ActProcessInstance startSurveyFlow (SurveryEvaluationFlowDTO reqDTO) throws Exception;


    /**
     * 通过、拒绝、驳回
     */
    void doComplete (FlowCompleteDTO flowCompleteDTO);

    void doFlowComplete(SurveryCompaleFlowDTO reqDTO);
}
