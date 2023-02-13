package com.correction.backend.modules.supervision.service.impl;

import com.correction.backend.modules.flow.constant.FlowConstant;
import com.correction.backend.modules.flow.controller.dto.FlowNodeUserCreateInputDTO;
import com.correction.backend.modules.flow.convert.MFlowNodeUserConvert;
import com.correction.backend.modules.flow.entity.FlowNodeUser;
import com.correction.backend.modules.flow.mapper.FlowNodeUserMapper;
import com.correction.backend.modules.handleCorrection.controller.dto.HandleCorrectionCreateInputDTO;
import com.correction.backend.modules.handleCorrection.controller.dto.HandleCorrectionFlowDTO;
import com.correction.backend.modules.handleCorrection.controller.dto.HandleCorrectionFlowListDTO;
import com.correction.backend.modules.handleCorrection.controller.dto.HandleCorrectionUpdateInputDTO;
import com.correction.backend.modules.handleCorrection.convert.MHandleCorrectionConvert;
import com.correction.backend.modules.handleCorrection.entity.HandleCorrection;
import com.correction.backend.modules.supervision.controller.dto.SupervisionFlowDTO;
import com.correction.backend.modules.supervision.controller.dto.SupervisionOutApprovalCreateInputDTO;
import com.correction.backend.modules.supervision.controller.dto.SupervisionOutApprovalUpdateInputDTO;
import com.correction.backend.modules.supervision.controller.dto.SupervisionStartFlowDTO;
import com.correction.backend.modules.supervision.convert.MSupervisionOutApprovalConvert;
import com.correction.backend.modules.supervision.entity.SupervisionOutApproval;
import com.correction.backend.modules.supervision.service.SupervisionFlowService;
import com.correction.backend.modules.supervision.service.SupervisionOutApprovalService;
import com.correction.backend.modules.survey.constant.SurveyConstant;
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
public class SupervisionFlowServiceImpl implements SupervisionFlowService {


    @Resource
    FlowNodeUserMapper flowNodeUserMapper;

    @Resource
    SupervisionOutApprovalService supervisionOutApprovalService;


    @Override
    public ActProcessInstance startFlow(SupervisionStartFlowDTO reqDTO) throws Exception {
        checkData(reqDTO);
        SupervisionOutApprovalCreateInputDTO detail = reqDTO.getDetail();
        List<FlowNodeUserCreateInputDTO> flowInfo = reqDTO.getFlowInfo();
        SupervisionOutApproval supervisionOutApproval = MSupervisionOutApprovalConvert.INSTANCE.toSupervisionOutApproval(detail);
        if(supervisionOutApproval.getId() == null){
            supervisionOutApproval = supervisionOutApprovalService.createSupervisionOutApproval(detail);
        } else {
            supervisionOutApproval = supervisionOutApprovalService.updateSupervisionOutApproval(supervisionOutApproval);
        }
        //保存流程节点与用户的关联关系：
        supervisionOutApproval.setRef(String.valueOf(System.currentTimeMillis()));
        assmberUserNode(flowInfo,supervisionOutApproval);
        //启动流程：
        LoginUser loginUser = WebFrameworkUtils.getLoginUser();
        Flow surveyFlow = null;
        String flowType = "";
        if(1 == supervisionOutApproval.getLeaveType()){
            flowType = FlowConstant.SUPERVISION_OUT_FLOW_ONE;
            surveyFlow =  FlowFactory.getByFlows(FlowConstant.SUPERVISION_OUT_FLOW_ONE);
        } else if (2 == supervisionOutApproval.getLeaveType()){
            flowType = FlowConstant.SUPERVISION_OUT_FLOW_TWO;
            surveyFlow =  FlowFactory.getByFlows(FlowConstant.SUPERVISION_OUT_FLOW_TWO);
        } else {
            flowType = FlowConstant.SUPERVISION_OUT_FLOW_THREE;
            surveyFlow =  FlowFactory.getByFlows(FlowConstant.SUPERVISION_OUT_FLOW_THREE);
        }
        ActProcessInstance actProcessInstance = surveyFlow.startFlow(FlowStartDTO.builder().userId(loginUser.getId()).flowType(flowType).dataId(supervisionOutApproval.getId()).ref(supervisionOutApproval.getRef()).progress(String.valueOf(supervisionOutApproval.getProgress())).build());
        supervisionOutApproval.setProgress(SurveyConstant.PROGRESS_2);
        supervisionOutApproval.setApplyStatus(SurveyConstant.FLOW_STATUS_2);
        supervisionOutApproval.setApplyTime(DateUtils.formatDate(new Date()));
        supervisionOutApproval.setApplyUser(loginUser.getId());
        supervisionOutApproval.setApplyName(loginUser.getUsername());
        supervisionOutApproval.setProcessInstanceId(actProcessInstance.getProcessInstanceId());
        supervisionOutApprovalService.updateById(supervisionOutApproval);
        return actProcessInstance;
    }

    private List<FlowNodeUser> assmberUserNode(List<FlowNodeUserCreateInputDTO> flowInfo, SupervisionOutApproval supervisionOutApproval) {
        List<FlowNodeUser> flowNodeUsers = MFlowNodeUserConvert.INSTANCE.toFlowNodeUser(flowInfo);
        for (int i = 0; i < flowNodeUsers.size(); i++) {
            FlowNodeUser flowNodeUser = flowNodeUsers.get(i);
            flowNodeUser.setDataId(supervisionOutApproval.getId());
            flowNodeUser.setRef(supervisionOutApproval.getRef());
            flowNodeUserMapper.insert(flowNodeUser);
        }
        return flowNodeUsers;
    }


    @Override
    public void doComplete(FlowCompleteDTO reqDTO,String type) {
        Flow surveyFlow = FlowFactory.getByFlows(type);
        surveyFlow.complete(WebFrameworkUtils.getLoginUserId(),reqDTO);
    }

    @Override
    public void doFlowComplete(SupervisionFlowDTO reqDTO) {
        SupervisionOutApprovalUpdateInputDTO detail = reqDTO.getDetail();
        SupervisionOutApproval updateSupervisionOutApproval = supervisionOutApprovalService.updateSupervisionOutApproval(detail);
        FlowCompleteDTO flowInfo = reqDTO.getFlowInfo();
        if(flowInfo.getAdopt() == null){
            throw exception(FLOW_AUDIT_ISNULL);
        }
        if(flowInfo.getTaskId() == null){
            throw exception(FLOW_TASKID_ISNULL);
        }
        //0：所级审批  1：区级审批  2 市级审批  请假程序不同对应的进度也有所差别
        Integer progress = updateSupervisionOutApproval.getProgress();
        flowInfo.setProgress(progress);
        if(1 == updateSupervisionOutApproval.getLeaveType()) {
            doComplete(flowInfo,FlowConstant.SUPERVISION_OUT_FLOW_ONE);
        } else if (2 ==updateSupervisionOutApproval.getLeaveType() ) {
            doComplete(flowInfo,FlowConstant.SUPERVISION_OUT_FLOW_TWO);
        } else {
            doComplete(flowInfo,FlowConstant.SUPERVISION_OUT_FLOW_THREE);
        }
    }


    private void checkData(SupervisionStartFlowDTO reqDTO) {
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
