package com.correction.backend.modules.handleCorrection.service.impl;

import com.correction.backend.modules.flow.constant.FlowConstant;
import com.correction.backend.modules.flow.controller.dto.FlowNodeUserCreateInputDTO;
import com.correction.backend.modules.flow.convert.MFlowNodeUserConvert;
import com.correction.backend.modules.flow.entity.FlowNodeUser;
import com.correction.backend.modules.flow.mapper.FlowNodeUserMapper;
import com.correction.backend.modules.handleCorrection.controller.dto.HandleCorrectionFlowDTO;
import com.correction.backend.modules.handleCorrection.controller.dto.HandleCorrectionFlowListDTO;
import com.correction.backend.modules.handleCorrection.controller.dto.HandleCorrectionUpdateInputDTO;
import com.correction.backend.modules.handleCorrection.convert.MHandleCorrectionConvert;
import com.correction.backend.modules.handleCorrection.entity.HandleCorrection;
import com.correction.backend.modules.handleCorrection.service.HandleCorrectionFlowService;
import com.correction.backend.modules.handleCorrection.service.HandleCorrectionService;
import com.correction.backend.modules.survey.constant.SurveyConstant;
import com.correction.backend.modules.survey.controller.dto.SurveryEvaluationFlowDTO;
import com.correction.backend.modules.survey.controller.dto.SurveyEvaluationUpdateInputDTO;
import com.correction.backend.modules.survey.convert.MSurveyEvaluationConvert;
import com.correction.backend.modules.survey.entity.SurveyEvaluation;
import com.correction.backend.modules.sys.entity.OrgDO;
import com.correction.backend.modules.sys.mapper.OrgMapper;
import com.correction.framework.web.web.LoginUser;
import com.correction.framework.web.web.core.util.WebFrameworkUtils;
import com.correction.framework.workflow.dto.FlowCompleteDTO;
import com.correction.framework.workflow.dto.FlowStartDTO;
import com.correction.framework.workflow.factory.ActProcessInstance;
import com.correction.framework.workflow.factory.Flow;
import com.correction.framework.workflow.factory.FlowFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.time.LocalDateTime;
import java.util.List;

import static com.correction.backend.modules.sys.enums.SysErrorCodeConstants.*;
import static com.correction.backend.modules.sys.enums.SysErrorCodeConstants.FLOW_TASKID_ISNULL;
import static com.correction.framework.common.exception.util.ServiceExceptionUtil.exception;

@Service
@Slf4j
public class HandleCorrectionFlowServiceImpl implements HandleCorrectionFlowService {

    @Resource
    FlowNodeUserMapper flowNodeUserMapper;

    @Resource
    OrgMapper orgMapper;

    @Resource
    HandleCorrectionService handleCorrectionService;


    @Override
    public ActProcessInstance startFlow(HandleCorrectionFlowListDTO reqDTO) throws Exception {
        checkData(reqDTO);
        HandleCorrectionUpdateInputDTO detail = reqDTO.getDetail();
        List<FlowNodeUserCreateInputDTO> flowInfo = reqDTO.getFlowInfo();
        HandleCorrection handleCorrection = MHandleCorrectionConvert.INSTANCE.toHandleCorrection(detail);
        //保存流程节点与用户的关联关系：
        handleCorrection.setRef(String.valueOf(System.currentTimeMillis()));
        assmberUserNode(flowInfo,handleCorrection);
        //启动流程：
        LoginUser loginUser = WebFrameworkUtils.getLoginUser();
        Flow surveyFlow = FlowFactory.getByFlows(FlowConstant.HANDLE_CORRECTION_FLOW);
        ActProcessInstance actProcessInstance = surveyFlow.startFlow(FlowStartDTO.builder().userId(loginUser.getId()).flowType(FlowConstant.HANDLE_CORRECTION_FLOW).dataId(handleCorrection.getId()).ref(handleCorrection.getRef()).progress(String.valueOf(handleCorrection.getProgress())).build());
        handleCorrection.setApplyTime(LocalDateTime.now().toString());
        handleCorrection.setProgress(SurveyConstant.PROGRESS_1);
        handleCorrection.setApplyStatus(SurveyConstant.FLOW_STATUS_1);
        handleCorrection.setApplyUser(loginUser.getId());
        handleCorrection.setApplyName(loginUser.getUsername());
        handleCorrection.setProcessInstanceId(actProcessInstance.getProcessInstanceId());
        handleCorrectionService.updateById(handleCorrection);
        return null;
    }

    private List<FlowNodeUser> assmberUserNode(List<FlowNodeUserCreateInputDTO> flowInfo, HandleCorrection handleCorrection) {
        List<FlowNodeUser> flowNodeUsers = MFlowNodeUserConvert.INSTANCE.toFlowNodeUser(flowInfo);
        for (int i = 0; i < flowNodeUsers.size(); i++) {
            FlowNodeUser flowNodeUser = flowNodeUsers.get(i);
            flowNodeUser.setDataId(handleCorrection.getId());
            flowNodeUser.setRef(handleCorrection.getRef());
            flowNodeUserMapper.insert(flowNodeUser);
        }
        return flowNodeUsers;
    }

    @Override
    public void doComplete(FlowCompleteDTO reqDTO) {
        Flow surveyFlow = FlowFactory.getByFlows(FlowConstant.HANDLE_CORRECTION_FLOW);
        surveyFlow.complete(WebFrameworkUtils.getLoginUserId(),reqDTO);
    }

    @Override
    public void doFlowComplete(HandleCorrectionFlowDTO reqDTO) {
        HandleCorrectionUpdateInputDTO detail = reqDTO.getDetail();
        HandleCorrection updateHandleCorrection = handleCorrectionService.updateHandleCorrection(detail);
        FlowCompleteDTO flowInfo = reqDTO.getFlowInfo();
        if(flowInfo.getAdopt() == null){
            throw exception(FLOW_AUDIT_ISNULL);
        }
        if(flowInfo.getTaskId() == null){
            throw exception(FLOW_TASKID_ISNULL);
        }
        Integer progress = updateHandleCorrection.getProgress();
        flowInfo.setProgress(progress);
        doComplete(flowInfo);
    }


    /**
     * 校验是否正常数据
     * @param reqDTO
     */
    private void checkData(HandleCorrectionFlowListDTO reqDTO) {
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



}
