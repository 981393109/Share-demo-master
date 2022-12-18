package com.correction.backend.modules.cases.service.impl;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.correction.backend.modules.cases.controller.dto.CasesPunishmentCreateInputDTO;
import com.correction.backend.modules.cases.controller.dto.CasesPunishmentFlowCreateDTO;
import com.correction.backend.modules.cases.controller.dto.CasesPunishmentFlowDTO;
import com.correction.backend.modules.cases.controller.dto.CasesPunishmentUpdateInputDTO;
import com.correction.backend.modules.cases.convert.MCasesPunishmentConvert;
import com.correction.backend.modules.cases.entity.CasesPunishment;
import com.correction.backend.modules.cases.service.CasesPunishmentFlowService;
import com.correction.backend.modules.cases.service.CasesPunishmentService;
import com.correction.backend.modules.flow.constant.FlowConstant;
import com.correction.backend.modules.flow.controller.dto.FlowNodeUserCreateInputDTO;
import com.correction.backend.modules.flow.convert.MFlowNodeUserConvert;
import com.correction.backend.modules.flow.entity.FlowNodeUser;
import com.correction.backend.modules.flow.mapper.FlowNodeUserMapper;
import com.correction.backend.modules.handleCorrection.controller.dto.HandleCorrectionCreateInputDTO;
import com.correction.backend.modules.handleCorrection.controller.dto.HandleCorrectionFlowListDTO;
import com.correction.backend.modules.handleCorrection.controller.dto.HandleCorrectionUpdateInputDTO;
import com.correction.backend.modules.handleCorrection.convert.MHandleCorrectionConvert;
import com.correction.backend.modules.handleCorrection.entity.HandleCorrection;
import com.correction.backend.modules.survey.constant.SurveyConstant;
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
public class CasesPunishmentFlowServiceImpl implements CasesPunishmentFlowService {

    @Resource
    CasesPunishmentService casesPunishmentService;

    @Resource
    FlowNodeUserMapper flowNodeUserMapper;


    @Override
    public ActProcessInstance startFlowFirst(CasesPunishmentFlowCreateDTO reqDTO) throws Exception {
        checkData(reqDTO);
        CasesPunishmentCreateInputDTO detail = reqDTO.getDetail();
        List<FlowNodeUserCreateInputDTO> flowInfo = reqDTO.getFlowInfo();
        CasesPunishment casesPunishment = MCasesPunishmentConvert.INSTANCE.toCasesPunishment(detail);
        if(casesPunishment.getId() == null){
            casesPunishment = casesPunishmentService.createCasesPunishment(detail);
        } else {
            casesPunishment = casesPunishmentService.updatePunishment(casesPunishment);
        }
        //保存流程节点与用户的关联关系：
        casesPunishment.setRef(String.valueOf(System.currentTimeMillis()));
        assmberUserNode(flowInfo,casesPunishment.getId(),casesPunishment.getRef());
        //启动流程：
        LoginUser loginUser = WebFrameworkUtils.getLoginUser();
        Flow surveyFlow = FlowFactory.getByFlows(FlowConstant.CASESPUNISHMENT_FLOW_FIRST);
        ActProcessInstance actProcessInstance = surveyFlow.startFlow(FlowStartDTO.builder().userId(loginUser.getId()).flowType(FlowConstant.CASESPUNISHMENT_FLOW_FIRST).dataId(casesPunishment.getId()).ref(casesPunishment.getRef()).progress(String.valueOf(casesPunishment.getProgress())).build());
        casesPunishment.setProgress(SurveyConstant.PROGRESS_2);
        casesPunishment.setApplyStatus(SurveyConstant.FLOW_STATUS_2);
        casesPunishment.setApplyTime(LocalDateTime.now().toString());
        casesPunishment.setApplyUser(loginUser.getId());
        casesPunishment.setApplyName(loginUser.getUsername());
        casesPunishment.setProcessInstanceId(actProcessInstance.getProcessInstanceId());
        casesPunishment.setNextProcessInstanceId(actProcessInstance.getProcessInstanceId());
        casesPunishmentService.updateById(casesPunishment);
        return actProcessInstance;
    }

    @Override
    public ActProcessInstance startFlow(CasesPunishmentFlowCreateDTO reqDTO) throws Exception {
        LoginUser loginUser = WebFrameworkUtils.getLoginUser();
        if(StringUtils.isNotBlank(reqDTO.getTaskId())){
            //结束第一个流程
            FlowCompleteDTO flowCompleteDTO = new FlowCompleteDTO();
            flowCompleteDTO.setAdopt(1);
            flowCompleteDTO.setProgress(4);
            flowCompleteDTO.setTaskId(reqDTO.getTaskId());
            flowCompleteDTO.setUserId(loginUser.getId());
            doComplete(flowCompleteDTO);
        }
        //进行第二个流程
        checkData(reqDTO);
        CasesPunishmentCreateInputDTO detail = reqDTO.getDetail();
        List<FlowNodeUserCreateInputDTO> flowInfo = reqDTO.getFlowInfo();
        CasesPunishment casesPunishment = MCasesPunishmentConvert.INSTANCE.toCasesPunishment(detail);
        casesPunishment = casesPunishmentService.updatePunishment(casesPunishment);
        Integer violationsTypeAdvice = casesPunishment.getViolationsTypeAdvice();
        //保存流程节点与用户的关联关系：
        casesPunishment.setNextRef(String.valueOf(System.currentTimeMillis()));
        assmberUserNode(flowInfo,casesPunishment.getId(),casesPunishment.getNextRef());
        Flow surveyFlow = null;
        String flowType = "";
        if (701 == violationsTypeAdvice || 702 == violationsTypeAdvice){
            flowType = FlowConstant.CASESPUNISHMENT_FLOW_ONE;
            surveyFlow =  FlowFactory.getByFlows(FlowConstant.CASESPUNISHMENT_FLOW_ONE);
        } else if (703 == violationsTypeAdvice || 707 == violationsTypeAdvice) {
            flowType = FlowConstant.CASESPUNISHMENT_FLOW_TWO;
            surveyFlow =  FlowFactory.getByFlows(FlowConstant.CASESPUNISHMENT_FLOW_TWO);
        } else {
            flowType = FlowConstant.CASESPUNISHMENT_FLOW_THREE;
            surveyFlow =  FlowFactory.getByFlows(FlowConstant.CASESPUNISHMENT_FLOW_THREE);
        }
        ActProcessInstance actProcessInstance = surveyFlow.startFlow(FlowStartDTO.builder().userId(loginUser.getId()).flowType(flowType).dataId(casesPunishment.getId()).ref(casesPunishment.getNextRef()).progress(String.valueOf(casesPunishment.getProgress())).build());
        casesPunishment.setProgress(SurveyConstant.PROGRESS_5);
        casesPunishment.setApplyStatus(SurveyConstant.FLOW_STATUS_5);
        casesPunishment.setApplyTime(LocalDateTime.now().toString());
        casesPunishment.setApplyUser(loginUser.getId());
        casesPunishment.setApplyName(loginUser.getUsername());
        casesPunishment.setNextProcessInstanceId(actProcessInstance.getProcessInstanceId());
        casesPunishmentService.updateById(casesPunishment);
        return actProcessInstance;
    }






    public void doComplete(FlowCompleteDTO reqDTO) {
        Flow byFlows = FlowFactory.getByFlows(FlowConstant.CASESPUNISHMENT_FLOW_FIRST);
        byFlows.complete(WebFrameworkUtils.getLoginUserId(),reqDTO);
    }

    @Override
    public void doFlowCompleteFirst(CasesPunishmentFlowDTO reqDTO) {
        CasesPunishmentUpdateInputDTO detail = reqDTO.getDetail();
        CasesPunishment casesPunishment = casesPunishmentService.updatePunishment(detail);
        FlowCompleteDTO flowInfo = reqDTO.getFlowInfo();
        if(flowInfo.getAdopt() == null){
            throw exception(FLOW_AUDIT_ISNULL);
        }
        if(flowInfo.getTaskId() == null){
            throw exception(FLOW_TASKID_ISNULL);
        }
        Integer progress = casesPunishment.getProgress();
        flowInfo.setProgress(progress);
        doComplete(flowInfo);
    }

    @Override
    public void doFlowComplete(CasesPunishmentFlowDTO reqDTO) {
        CasesPunishmentUpdateInputDTO detail = reqDTO.getDetail();
        CasesPunishment casesPunishment = casesPunishmentService.updatePunishment(detail);
        FlowCompleteDTO flowInfo = reqDTO.getFlowInfo();
        if(flowInfo.getAdopt() == null){
            throw exception(FLOW_AUDIT_ISNULL);
        }
        if(flowInfo.getTaskId() == null){
            throw exception(FLOW_TASKID_ISNULL);
        }
        Integer progress = casesPunishment.getProgress();
        Integer violationsTypeAdvice = casesPunishment.getViolationsTypeAdvice();
        flowInfo.setProgress(progress);
        if (701 == violationsTypeAdvice || 702 == violationsTypeAdvice){
            doComplete(flowInfo,FlowConstant.CASESPUNISHMENT_FLOW_ONE);
        } else if (703 == violationsTypeAdvice || 707 == violationsTypeAdvice) {
            doComplete(flowInfo,FlowConstant.CASESPUNISHMENT_FLOW_TWO);
        } else {
            doComplete(flowInfo,FlowConstant.CASESPUNISHMENT_FLOW_THREE);
        }
    }

    public void doComplete(FlowCompleteDTO reqDTO,String type) {
        Flow surveyFlow = FlowFactory.getByFlows(type);
        surveyFlow.complete(WebFrameworkUtils.getLoginUserId(),reqDTO);
    }



    private List<FlowNodeUser> assmberUserNode(List<FlowNodeUserCreateInputDTO> flowInfo, Long id ,String ref) {
        List<FlowNodeUser> flowNodeUsers = MFlowNodeUserConvert.INSTANCE.toFlowNodeUser(flowInfo);
        for (int i = 0; i < flowNodeUsers.size(); i++) {
            FlowNodeUser flowNodeUser = flowNodeUsers.get(i);
            flowNodeUser.setDataId(id);
            flowNodeUser.setRef(ref);
            flowNodeUserMapper.insert(flowNodeUser);
        }
        return flowNodeUsers;
    }


    /**
     * 校验是否正常数据
     * @param reqDTO
     */
    private void checkData(CasesPunishmentFlowCreateDTO reqDTO) {
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
