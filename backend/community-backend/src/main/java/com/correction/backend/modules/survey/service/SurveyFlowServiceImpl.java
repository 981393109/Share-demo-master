package com.correction.backend.modules.survey.service;

import com.correction.backend.modules.flow.constant.FlowConstant;
import com.correction.framework.web.web.core.util.WebFrameworkUtils;
import com.correction.framework.workflow.dto.FlowCompleteDTO;
import com.correction.framework.workflow.dto.FlowStartDTO;
import com.correction.framework.workflow.factory.ActProcessInstance;
import com.correction.framework.workflow.factory.Flow;
import com.correction.framework.workflow.factory.FlowFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class SurveyFlowServiceImpl implements SurveyFlowService {

    @Resource
    SurveyEvaluationService surveyEvaluationService;

    @Override
    public ActProcessInstance startSurveyFlow( Long dataId) throws Exception {
        Flow surveyFlow = FlowFactory.getByFlows(FlowConstant.SURVEY_FLOW);
        ActProcessInstance actProcessInstance = surveyFlow.startFlow(FlowStartDTO.builder().userId(WebFrameworkUtils.getLoginUserId()).flowType(FlowConstant.SURVEY_FLOW).dataId(dataId).build());
        return actProcessInstance;
    }


    @Override
    public void doComplete(FlowCompleteDTO flowCompleteDTO) {
        Flow surveyFlow = FlowFactory.getByFlows(FlowConstant.SURVEY_FLOW);
        surveyFlow.complete(WebFrameworkUtils.getLoginUserId(),flowCompleteDTO);
    }


}
