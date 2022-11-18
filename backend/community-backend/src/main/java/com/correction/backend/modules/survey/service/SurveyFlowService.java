package com.correction.backend.modules.survey.service;

import com.correction.framework.workflow.dto.FlowCompleteDTO;
import com.correction.framework.workflow.factory.ActProcessInstance;

/**
 * 调查评估流程接口
 */
public interface SurveyFlowService {


    /**
     * 提交调查评估
     */
    ActProcessInstance startSurveyFlow (Long dataId) throws Exception;


    /**
     * 通过、拒绝、驳回
     */
    void doComplete (FlowCompleteDTO flowCompleteDTO);

}
