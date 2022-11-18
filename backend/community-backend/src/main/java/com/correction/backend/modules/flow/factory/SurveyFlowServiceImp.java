package com.correction.backend.modules.flow.factory;

import com.correction.backend.modules.flow.constant.FlowConstant;
import com.correction.framework.workflow.dto.FlowCompleteDTO;
import com.correction.framework.workflow.dto.FlowStartDTO;
import com.correction.framework.workflow.factory.ActProcessInstance;
import com.correction.framework.workflow.factory.Flow;
import com.correction.framework.workflow.factory.FlowFactory;
import com.correction.framework.workflow.service.ActFlowableTaskService;
import com.correction.framework.workflow.service.FlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * 调查评估审批流程
 */
@Component
public class SurveyFlowServiceImp implements Flow {

    @Resource
    private FlowService flowService;


    @Override
    public ActProcessInstance startFlow(FlowStartDTO flowStartDTO) throws Exception {
        ActProcessInstance actProcessInstance = flowService.startFlow(flowStartDTO);
        return actProcessInstance;
    }

    @Override
    public void complete(Long userId, FlowCompleteDTO flowCompleteDTO) {
        flowService.complete(userId,flowCompleteDTO);
    }

    @PostConstruct
    public void afterPropertiesSet() throws Exception {
        // 注册到Map中
        FlowFactory.register(FlowConstant.SURVEY_FLOW, this);
    }
}
