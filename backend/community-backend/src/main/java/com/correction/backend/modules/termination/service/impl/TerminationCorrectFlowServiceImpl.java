package com.correction.backend.modules.termination.service.impl;

import com.correction.backend.modules.flow.constant.FlowConstant;
import com.correction.backend.modules.flow.controller.dto.FlowNodeUserCreateInputDTO;
import com.correction.backend.modules.flow.convert.MFlowNodeUserConvert;
import com.correction.backend.modules.flow.entity.FlowNodeUser;
import com.correction.backend.modules.flow.mapper.FlowNodeUserMapper;
import com.correction.backend.modules.survey.constant.SurveyConstant;
import com.correction.backend.modules.termination.controller.dto.*;
import com.correction.backend.modules.termination.convert.MTerminationCorrectConvert;
import com.correction.backend.modules.termination.convert.MTerminationSolutionsConvert;
import com.correction.backend.modules.termination.entity.TerminationCorrect;
import com.correction.backend.modules.termination.entity.TerminationSolutions;
import com.correction.backend.modules.termination.service.TerminationCorrectFlowService;
import com.correction.backend.modules.termination.service.TerminationCorrectService;
import com.correction.framework.web.web.LoginUser;
import com.correction.framework.web.web.core.util.WebFrameworkUtils;
import com.correction.framework.workflow.dto.FlowCompleteDTO;
import com.correction.framework.workflow.dto.FlowStartDTO;
import com.correction.framework.workflow.factory.ActProcessInstance;
import com.correction.framework.workflow.factory.Flow;
import com.correction.framework.workflow.factory.FlowFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

import static com.correction.backend.modules.sys.enums.SysErrorCodeConstants.*;
import static com.correction.backend.modules.sys.enums.SysErrorCodeConstants.FLOW_TASKID_ISNULL;
import static com.correction.framework.common.exception.util.ServiceExceptionUtil.exception;

@Service
public class TerminationCorrectFlowServiceImpl implements TerminationCorrectFlowService {

    @Resource
    FlowNodeUserMapper flowNodeUserMapper;

    @Resource
    TerminationCorrectService terminationCorrectService;


    @Override
    public ActProcessInstance startFlow(TerminationCorrectStartFlowDTO reqDTO) throws Exception {
        checkData(reqDTO);
        TerminationCorrectCreateInputDTO detail = reqDTO.getDetail();
        List<FlowNodeUserCreateInputDTO> flowInfo = reqDTO.getFlowInfo();
        TerminationCorrect terminationCorrect = MTerminationCorrectConvert.INSTANCE.toTerminationCorrect(detail);
        if(terminationCorrect.getId() == null){
            terminationCorrect = terminationCorrectService.create(detail);
        } else {
            terminationCorrect = terminationCorrectService.update(terminationCorrect);
        }
        //保存流程节点与用户的关联关系：
        terminationCorrect.setRef(String.valueOf(System.currentTimeMillis()));
        assmberUserNode(flowInfo,terminationCorrect);
        //启动流程：
        LoginUser loginUser = WebFrameworkUtils.getLoginUser();
        String flowType = FlowConstant.TERMINATION_CORRECT_FLOW;
        Flow surveyFlow =  FlowFactory.getByFlows(FlowConstant.TERMINATION_CORRECT_FLOW);
        ActProcessInstance actProcessInstance = surveyFlow.startFlow(FlowStartDTO.builder().userId(loginUser.getId()).flowType(flowType).dataId(terminationCorrect.getId()).ref(terminationCorrect.getRef()).progress(String.valueOf(terminationCorrect.getProgress())).build());
        terminationCorrect.setProgress(SurveyConstant.PROGRESS_2);
        terminationCorrect.setApplyStatus(SurveyConstant.FLOW_STATUS_2);
        terminationCorrect.setApplyTime(LocalDateTime.now().toString());
        terminationCorrect.setApplyUser(loginUser.getId());
        terminationCorrect.setApplyName(loginUser.getUsername());
        terminationCorrect.setProcessInstanceId(actProcessInstance.getProcessInstanceId());
        terminationCorrectService.updateById(terminationCorrect);
        return actProcessInstance;
    }

    @Override
    public void doFlowComplete(TerminationCorrectFlowDTO reqDTO) {
        TerminationCorrectUpdateInputDTO detail = reqDTO.getDetail();
        TerminationCorrect terminationCorrect = terminationCorrectService.update(detail);
        FlowCompleteDTO flowInfo = reqDTO.getFlowInfo();
        if(flowInfo.getAdopt() == null){
            throw exception(FLOW_AUDIT_ISNULL);
        }
        if(flowInfo.getTaskId() == null){
            throw exception(FLOW_TASKID_ISNULL);
        }
        Integer progress = terminationCorrect.getProgress();
        flowInfo.setProgress(progress);
        doComplete(flowInfo, FlowConstant.TERMINATION_CORRECT_FLOW);
    }

    public void doComplete(FlowCompleteDTO reqDTO, String type) {
        Flow surveyFlow = FlowFactory.getByFlows(type);
        surveyFlow.complete(WebFrameworkUtils.getLoginUserId(),reqDTO);
    }

    private void checkData(TerminationCorrectStartFlowDTO reqDTO) {
        if(reqDTO.getDetail()==null){
            throw exception(SURVEY_FLOW_FROM_NOT_FOUND);
        }
        if(reqDTO.getFlowInfo()==null){
            throw exception(SURVEY_FLOW_FROM_NOT_FOUND);
        }
        for (FlowNodeUserCreateInputDTO flowNodeUserCreateInputDTO : reqDTO.getFlowInfo()) {
            if(flowNodeUserCreateInputDTO.getUserId() == null){
                throw exception(SURVEY_FLOW_FROM_NODE_NOT_FOUND);
            }
        }
    }

    private List<FlowNodeUser> assmberUserNode(List<FlowNodeUserCreateInputDTO> flowInfo, TerminationCorrect terminationCorrect) {
        List<FlowNodeUser> flowNodeUsers = MFlowNodeUserConvert.INSTANCE.toFlowNodeUser(flowInfo);
        for (int i = 0; i < flowNodeUsers.size(); i++) {
            FlowNodeUser flowNodeUser = flowNodeUsers.get(i);
            flowNodeUser.setDataId(terminationCorrect.getId());
            flowNodeUser.setRef(terminationCorrect.getRef());
            flowNodeUserMapper.insert(flowNodeUser);
        }
        return flowNodeUsers;
    }
}
