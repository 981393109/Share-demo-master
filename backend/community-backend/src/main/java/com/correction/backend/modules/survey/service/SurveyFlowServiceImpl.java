package com.correction.backend.modules.survey.service;

import com.correction.backend.modules.flow.constant.FlowConstant;
import com.correction.backend.modules.flow.controller.dto.FlowNodeUserCreateInputDTO;
import com.correction.backend.modules.flow.convert.MFlowNodeUserConvert;
import com.correction.backend.modules.flow.entity.FlowNodeUser;
import com.correction.backend.modules.flow.mapper.FlowNodeUserMapper;
import com.correction.backend.modules.survey.constant.SurveyConstant;
import com.correction.backend.modules.survey.controller.dto.*;
import com.correction.backend.modules.survey.convert.MSurveyEvaluationConvert;
import com.correction.backend.modules.survey.entity.SurveyEvaluation;
import com.correction.backend.modules.sys.entity.OrgDO;
import com.correction.backend.modules.sys.mapper.OrgMapper;
import com.correction.framework.common.util.date.DateUtils;
import com.correction.framework.web.web.LoginUser;
import com.correction.framework.web.web.core.util.WebFrameworkUtils;
import com.correction.framework.workflow.constant.WorkFlowConstant;
import com.correction.framework.workflow.dto.FlowCompleteDTO;
import com.correction.framework.workflow.dto.FlowStartDTO;
import com.correction.framework.workflow.factory.ActProcessInstance;
import com.correction.framework.workflow.factory.Flow;
import com.correction.framework.workflow.factory.FlowFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import static com.correction.backend.modules.sys.enums.SysErrorCodeConstants.*;
import static com.correction.framework.common.exception.util.ServiceExceptionUtil.exception;

@Service
@Slf4j
public class SurveyFlowServiceImpl implements SurveyFlowService {

    @Resource
    SurveyEvaluationService surveyEvaluationService;

    @Resource
    FlowNodeUserMapper flowNodeUserMapper;

    @Resource
    OrgMapper orgMapper;

    @Override
    public ActProcessInstance startSurveyFlow(SurveryEvaluationFlowDTO reqDTO) throws Exception {
        checkData(reqDTO);
        SurveyEvaluationCreateInputDTO detail = reqDTO.getDetail();
        List<FlowNodeUserCreateInputDTO> flowInfo = reqDTO.getFlowInfo();
        //判断表单数据是否存在
        SurveyEvaluation surveyEvaluation = MSurveyEvaluationConvert.INSTANCE.toSurveyEvaluation(detail);
        if(surveyEvaluation.getId() == null){
            surveyEvaluation = surveyEvaluationService.createSurveyEvaluation(detail);
        } else {
            surveyEvaluation = surveyEvaluationService.updateSurveyEvaluation(surveyEvaluation);
        }
        //保存流程节点与用户的关联关系：
        surveyEvaluation.setRef(String.valueOf(System.currentTimeMillis()));
        assmberUserNode(flowInfo,surveyEvaluation);
        //启动流程：
        LoginUser loginUser = WebFrameworkUtils.getLoginUser();
        surveyEvaluation.setApplyTime(DateUtils.formatDate(new Date()));
        surveyEvaluation.setApplyUser(loginUser.getId());
        surveyEvaluation.setApplyName(loginUser.getUsername());
        Flow surveyFlow = FlowFactory.getByFlows(FlowConstant.SURVEY_FLOW);
        ActProcessInstance actProcessInstance = surveyFlow.startFlow(FlowStartDTO.builder().userId(loginUser.getId()).flowType(FlowConstant.SURVEY_FLOW).dataId(surveyEvaluation.getId()).ref(surveyEvaluation.getRef()).progress(String.valueOf(surveyEvaluation.getProgress())).build());
        surveyEvaluation.setProgress(SurveyConstant.PROGRESS_2);//补充材料
        surveyEvaluation.setApplyStatus(SurveyConstant.FLOW_STATUS_2);
        surveyEvaluation.setProcessInstanceId(actProcessInstance.getProcessInstanceId());
        surveyEvaluationService.updateById(surveyEvaluation);
        return actProcessInstance;
    }

    private List<FlowNodeUser> assmberUserNode (List<FlowNodeUserCreateInputDTO> flowInfo,SurveyEvaluation surveyEvaluation){
        List<FlowNodeUser> flowNodeUsers = MFlowNodeUserConvert.INSTANCE.toFlowNodeUser(flowInfo);
        for (int i = 0; i < flowNodeUsers.size(); i++) {
            FlowNodeUser flowNodeUser = flowNodeUsers.get(i);
            flowNodeUser.setDataId(surveyEvaluation.getId());
            flowNodeUser.setRef(surveyEvaluation.getRef());
            //保存辖区司法所数据
            if(i == 2){
                OrgDO orgDO = orgMapper.selectById(flowNodeUser.getOrgId());
                surveyEvaluation.setJurisdictionOffice(orgDO.getParentNames());
                surveyEvaluation.setJurisdictionOfficeId(orgDO.getId());
            }
            flowNodeUserMapper.insert(flowNodeUser);
        }
        return flowNodeUsers;
    }


    /**
     * 校验是否正常数据
     * @param reqDTO
     */
    private void checkData(SurveryEvaluationFlowDTO reqDTO) {
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


    @Override
    public void doComplete(FlowCompleteDTO flowCompleteDTO) {
        Flow surveyFlow = FlowFactory.getByFlows(FlowConstant.SURVEY_FLOW);
        surveyFlow.complete(WebFrameworkUtils.getLoginUserId(),flowCompleteDTO);
    }

    @Override
    public void doFlowComplete(SurveryCompaleFlowDTO reqDTO) {
        SurveyEvaluationUpdateInputDTO detail = reqDTO.getDetail();
        FlowCompleteDTO flowInfo = reqDTO.getFlowInfo();
        if ("3".equals(detail.getAssessmentLastOpinion())){
            //直接拒绝审批
            flowInfo.setAdopt(WorkFlowConstant.TASK_MU_2);
        }
        SurveyEvaluation surveyEvaluation = surveyEvaluationService.updateSurveyEvaluation(detail);
        if(flowInfo.getAdopt() == null){
            throw exception(FLOW_AUDIT_ISNULL);
        }
        if(flowInfo.getTaskId() == null){
            throw exception(FLOW_TASKID_ISNULL);
        }
        Integer progress = surveyEvaluation.getProgress();
        flowInfo.setProgress(progress);
        doComplete(flowInfo);
    }


}
