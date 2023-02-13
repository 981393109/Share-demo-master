package com.correction.backend.modules.supervision.service.impl;

import com.correction.backend.modules.flow.constant.FlowConstant;
import com.correction.backend.modules.flow.controller.dto.FlowNodeUserCreateInputDTO;
import com.correction.backend.modules.flow.convert.MFlowNodeUserConvert;
import com.correction.backend.modules.flow.entity.FlowNodeUser;
import com.correction.backend.modules.flow.mapper.FlowNodeUserMapper;
import com.correction.backend.modules.supervision.controller.dto.*;
import com.correction.backend.modules.supervision.convert.MSupervisionOutApprovalConvert;
import com.correction.backend.modules.supervision.convert.MSupervisionPositioningDevicesConvert;
import com.correction.backend.modules.supervision.entity.SupervisionOutApproval;
import com.correction.backend.modules.supervision.entity.SupervisionPositioningDevices;
import com.correction.backend.modules.supervision.service.SupervisionOutApprovalService;
import com.correction.backend.modules.supervision.service.SupervisionPositioningDevicesService;
import com.correction.backend.modules.supervision.service.SupervisionPositioningFlowService;
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
public class SupervisionPositioningFlowServiceImpl implements SupervisionPositioningFlowService {


    @Resource
    FlowNodeUserMapper flowNodeUserMapper;

    @Resource
    SupervisionPositioningDevicesService supervisionPositioningDevicesService;

    @Override
    public ActProcessInstance startFlow(SupervisionPositioningStartFlowDTO reqDTO) throws Exception {
        checkData(reqDTO);
        SupervisionPositioningDevicesCreateInputDTO detail = reqDTO.getDetail();
        List<FlowNodeUserCreateInputDTO> flowInfo = reqDTO.getFlowInfo();
        SupervisionPositioningDevices supervisionPositioningDevices = MSupervisionPositioningDevicesConvert.INSTANCE.toSupervisionPositioningDevices(detail);
        if(supervisionPositioningDevices.getId() == null){
            supervisionPositioningDevices = supervisionPositioningDevicesService.createSupervisionPositiongDevices(detail);
        } else {
            supervisionPositioningDevices = supervisionPositioningDevicesService.updateSupervisionPositiongDevices(supervisionPositioningDevices);
        }
        //保存流程节点与用户的关联关系：
        supervisionPositioningDevices.setRef(String.valueOf(System.currentTimeMillis()));
        assmberUserNode(flowInfo,supervisionPositioningDevices);
        //启动流程：
        LoginUser loginUser = WebFrameworkUtils.getLoginUser();
        Flow surveyFlow = null;
        String flowType = "";
        if(1 == supervisionPositioningDevices.getType()){
            flowType = FlowConstant.SUPERVISION_POSITION_FLOW_ONE;
            surveyFlow =  FlowFactory.getByFlows(FlowConstant.SUPERVISION_POSITION_FLOW_ONE);
        } else if (2 == supervisionPositioningDevices.getType()){
            flowType = FlowConstant.SUPERVISION_POSITION_FLOW_TWO;
            surveyFlow =  FlowFactory.getByFlows(FlowConstant.SUPERVISION_POSITION_FLOW_TWO);
        } else if (3 == supervisionPositioningDevices.getType()) {
            flowType = FlowConstant.SUPERVISION_POSITION_FLOW_THREE;
            surveyFlow =  FlowFactory.getByFlows(FlowConstant.SUPERVISION_POSITION_FLOW_THREE);
        } else {
            flowType = FlowConstant.SUPERVISION_POSITION_FLOW_FOUR;
            surveyFlow =  FlowFactory.getByFlows(FlowConstant.SUPERVISION_POSITION_FLOW_FOUR);
        }
        ActProcessInstance actProcessInstance = surveyFlow.startFlow(FlowStartDTO.builder().userId(loginUser.getId()).flowType(flowType).dataId(supervisionPositioningDevices.getId()).ref(supervisionPositioningDevices.getRef()).progress(String.valueOf(supervisionPositioningDevices.getProgress())).build());
        supervisionPositioningDevices.setProgress(SurveyConstant.PROGRESS_2);
        supervisionPositioningDevices.setApplyStatus(SurveyConstant.FLOW_STATUS_2);
        supervisionPositioningDevices.setApplyTime(DateUtils.formatDate(new Date()));
        supervisionPositioningDevices.setApplyUser(loginUser.getId());
        supervisionPositioningDevices.setApplyName(loginUser.getUsername());
        supervisionPositioningDevices.setProcessInstanceId(actProcessInstance.getProcessInstanceId());
        supervisionPositioningDevicesService.updateById(supervisionPositioningDevices);
        return actProcessInstance;
    }

    private List<FlowNodeUser> assmberUserNode(List<FlowNodeUserCreateInputDTO> flowInfo, SupervisionPositioningDevices supervisionPositioningDevices) {
        List<FlowNodeUser> flowNodeUsers = MFlowNodeUserConvert.INSTANCE.toFlowNodeUser(flowInfo);
        for (int i = 0; i < flowNodeUsers.size(); i++) {
            FlowNodeUser flowNodeUser = flowNodeUsers.get(i);
            flowNodeUser.setDataId(supervisionPositioningDevices.getId());
            flowNodeUser.setRef(supervisionPositioningDevices.getRef());
            flowNodeUserMapper.insert(flowNodeUser);
        }
        return flowNodeUsers;
    }

    public void doComplete(FlowCompleteDTO reqDTO,String type) {
        Flow surveyFlow = FlowFactory.getByFlows(type);
        surveyFlow.complete(WebFrameworkUtils.getLoginUserId(),reqDTO);
    }


    @Override
    public void doFlowComplete(SupervisionPositioningFlowDTO reqDTO) throws Exception {
        SupervisionPositioningDevicesUpdateInputDTO detail = reqDTO.getDetail();
        SupervisionPositioningDevices supervisionPositioningDevices = supervisionPositioningDevicesService.updateSupervisionPositiongDevices(detail);
        FlowCompleteDTO flowInfo = reqDTO.getFlowInfo();
        if(flowInfo.getAdopt() == null){
            throw exception(FLOW_AUDIT_ISNULL);
        }
        if(flowInfo.getTaskId() == null){
            throw exception(FLOW_TASKID_ISNULL);
        }
        //0：所级审批  1：区级审批  2 市级审批  请假程序不同对应的进度也有所差别
        Integer progress = supervisionPositioningDevices.getProgress();
        flowInfo.setProgress(progress);
        if(1 == supervisionPositioningDevices.getType()) {
            doComplete(flowInfo,FlowConstant.SUPERVISION_POSITION_FLOW_ONE);
        } else if (2 ==supervisionPositioningDevices.getType() ) {
            doComplete(flowInfo,FlowConstant.SUPERVISION_POSITION_FLOW_TWO);
        } else if (3 == supervisionPositioningDevices.getType()){
            doComplete(flowInfo,FlowConstant.SUPERVISION_POSITION_FLOW_THREE);
        } else {
            doComplete(flowInfo,FlowConstant.SUPERVISION_POSITION_FLOW_FOUR);
        }
    }


    private void checkData(SupervisionPositioningStartFlowDTO reqDTO) {
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
