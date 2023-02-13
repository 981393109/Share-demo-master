package com.correction.backend.modules.termination.service.impl;

import com.correction.backend.modules.flow.constant.FlowConstant;
import com.correction.backend.modules.flow.controller.dto.FlowNodeUserCreateInputDTO;
import com.correction.backend.modules.flow.convert.MFlowNodeUserConvert;
import com.correction.backend.modules.flow.entity.FlowNodeUser;
import com.correction.backend.modules.flow.mapper.FlowNodeUserMapper;
import com.correction.backend.modules.survey.constant.SurveyConstant;
import com.correction.backend.modules.termination.controller.dto.TerminationSolutionsCreateInputDTO;
import com.correction.backend.modules.termination.controller.dto.TerminationSolutionsFlowDTO;
import com.correction.backend.modules.termination.controller.dto.TerminationSolutionsStartFlowDTO;
import com.correction.backend.modules.termination.controller.dto.TerminationSolutionsUpdateInputDTO;
import com.correction.backend.modules.termination.convert.MTerminationSolutionsConvert;
import com.correction.backend.modules.termination.entity.TerminationSolutions;
import com.correction.backend.modules.termination.service.TerminationSolutionsFlowService;
import com.correction.backend.modules.termination.service.TerminationSolutionsService;
import com.correction.framework.common.util.date.DateUtils;
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
import java.util.Date;
import java.util.List;

import static com.correction.backend.modules.sys.enums.SysErrorCodeConstants.*;
import static com.correction.backend.modules.sys.enums.SysErrorCodeConstants.FLOW_TASKID_ISNULL;
import static com.correction.framework.common.exception.util.ServiceExceptionUtil.exception;

@Service
public class TerminationSolutionsFlowServiceImpl implements TerminationSolutionsFlowService {

    @Resource
    FlowNodeUserMapper flowNodeUserMapper;

    @Resource
    TerminationSolutionsService terminationSolutionsService;


    @Override
    public ActProcessInstance startFlow(TerminationSolutionsStartFlowDTO reqDTO) throws Exception {
        checkData(reqDTO);
        TerminationSolutionsCreateInputDTO detail = reqDTO.getDetail();
        List<FlowNodeUserCreateInputDTO> flowInfo = reqDTO.getFlowInfo();
        TerminationSolutions terminationSolutions = MTerminationSolutionsConvert.INSTANCE.toTerminationSolutions(detail);
        if(terminationSolutions.getId() == null){
            terminationSolutions = terminationSolutionsService.create(detail);
        } else {
            terminationSolutions = terminationSolutionsService.update(terminationSolutions);
        }
        //保存流程节点与用户的关联关系：
        terminationSolutions.setRef(String.valueOf(System.currentTimeMillis()));
        assmberUserNode(flowInfo,terminationSolutions);
        //启动流程：
        LoginUser loginUser = WebFrameworkUtils.getLoginUser();
        String flowType = FlowConstant.TERMINATION_SOLUTIONS_FLOW;
        Flow surveyFlow =  FlowFactory.getByFlows(FlowConstant.TERMINATION_SOLUTIONS_FLOW);
        ActProcessInstance actProcessInstance = surveyFlow.startFlow(FlowStartDTO.builder().userId(loginUser.getId()).flowType(flowType).dataId(terminationSolutions.getId()).ref(terminationSolutions.getRef()).progress(String.valueOf(terminationSolutions.getProgress())).build());
        terminationSolutions.setProgress(SurveyConstant.PROGRESS_2);
        terminationSolutions.setApplyStatus(SurveyConstant.FLOW_STATUS_2);
        terminationSolutions.setApplyTime(DateUtils.formatDate(new Date()));
        terminationSolutions.setApplyUser(loginUser.getId());
        terminationSolutions.setApplyName(loginUser.getUsername());
        terminationSolutions.setProcessInstanceId(actProcessInstance.getProcessInstanceId());
        terminationSolutionsService.updateById(terminationSolutions);
        return actProcessInstance;
    }

    public void doComplete(FlowCompleteDTO reqDTO, String type) {
        Flow surveyFlow = FlowFactory.getByFlows(type);
        surveyFlow.complete(WebFrameworkUtils.getLoginUserId(),reqDTO);
    }

    @Override
    public void doFlowComplete(TerminationSolutionsFlowDTO reqDTO) {
        TerminationSolutionsUpdateInputDTO detail = reqDTO.getDetail();
        TerminationSolutions terminationSolutions = terminationSolutionsService.update(detail);
        FlowCompleteDTO flowInfo = reqDTO.getFlowInfo();
        if(flowInfo.getAdopt() == null){
            throw exception(FLOW_AUDIT_ISNULL);
        }
        if(flowInfo.getTaskId() == null){
            throw exception(FLOW_TASKID_ISNULL);
        }
        //0：所级审批  1：区级审批  2 市级审批  请假程序不同对应的进度也有所差别
        Integer progress = terminationSolutions.getProgress();
        flowInfo.setProgress(progress);
        doComplete(flowInfo, FlowConstant.TERMINATION_SOLUTIONS_FLOW);
    }


    private void checkData(TerminationSolutionsStartFlowDTO reqDTO) {
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

    private List<FlowNodeUser> assmberUserNode(List<FlowNodeUserCreateInputDTO> flowInfo, TerminationSolutions terminationSolutions) {
        List<FlowNodeUser> flowNodeUsers = MFlowNodeUserConvert.INSTANCE.toFlowNodeUser(flowInfo);
        for (int i = 0; i < flowNodeUsers.size(); i++) {
            FlowNodeUser flowNodeUser = flowNodeUsers.get(i);
            flowNodeUser.setDataId(terminationSolutions.getId());
            flowNodeUser.setRef(terminationSolutions.getRef());
            flowNodeUserMapper.insert(flowNodeUser);
        }
        return flowNodeUsers;
    }

}
