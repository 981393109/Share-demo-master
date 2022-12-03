package com.correction.backend.modules.flow.factory.complete;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.correction.backend.modules.flow.constant.FlowConstant;
import com.correction.backend.modules.handleCorrection.controller.dto.HandleCorrectionCreateInputDTO;
import com.correction.backend.modules.handleCorrection.service.HandleCorrectionService;
import com.correction.backend.modules.survey.constant.SurveyConstant;
import com.correction.backend.modules.survey.entity.SurveyEvaluation;
import com.correction.backend.modules.survey.service.SurveyEvaluationService;
import com.correction.framework.workflow.constant.WorkFlowConstant;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.time.LocalDateTime;

@Component
public class SurveyFlowCompleteServiceImp implements FlowComplete{

    @Resource
    private SurveyEvaluationService surveyEvaluationService;

    @Resource
    private HandleCorrectionService handleCorrectionService;

    @Override
    public void doUpdateData(String dataId, String ref, String progress, String status) {
        SurveyEvaluation byId = surveyEvaluationService.getById(Long.parseLong(dataId));
        if(WorkFlowConstant.TASK_SUCCESS.equals(status)){
            //成功！
            if(StringUtils.isNotBlank(progress)){
                byId.setProgress(Integer.parseInt(progress) + 1);
                byId.setApplyStatus(switchProgree(progress) +1);
            }
        } else {
            //驳回
            if(StringUtils.isNotBlank(progress)){
                byId.setProgress(Integer.parseInt(progress) -1);
                byId.setApplyStatus(switchProgree(progress) -1);
            }
        }
        surveyEvaluationService.updateById(byId);
    }

    @Override
    public void doEnd(String dataId, String ref, String progress,String status) {
        SurveyEvaluation byId = surveyEvaluationService.getById(Long.parseLong(dataId));
        if(WorkFlowConstant.TASK_SUCCESS.equals(status)){
            byId.setProgress(SurveyConstant.PROGRESS_8);
            byId.setApplyStatus(SurveyConstant.FLOW_STATUS_7);
            //添加入矫申请
            handleCorrectionService.createHandleCorrection(assmberHandleCorrection(byId));
        } else {
            byId.setApplyStatus(SurveyConstant.FLOW_STATUS_u1);
        }
        surveyEvaluationService.updateById(byId);
    }

    private HandleCorrectionCreateInputDTO assmberHandleCorrection(SurveyEvaluation surveyEvaluation){
        HandleCorrectionCreateInputDTO dto = new HandleCorrectionCreateInputDTO();
        dto.setName(surveyEvaluation.getName());
        dto.setSurveyEvaluationId(surveyEvaluation.getId());
        dto.setEntrustType(surveyEvaluation.getEntrustType());
        dto.setEntrustDate(surveyEvaluation.getEntrustDate());
        dto.setEntrustUnit(surveyEvaluation.getEntrustUnit());
        dto.setApplyUser(surveyEvaluation.getHandleCorrectionUserId());
        dto.setApplyTime(surveyEvaluation.getApplyTime());
        dto.setReceptionDate(surveyEvaluation.getReceptionDate());
        dto.setProgress(SurveyConstant.PROGRESS_0);
        dto.setApplyStatus(SurveyConstant.FLOW_STATUS_0);
        dto.setJurisdictionOffice(surveyEvaluation.getJurisdictionOffice());
        dto.setJurisdictionOfficeId(surveyEvaluation.getJurisdictionOfficeId());
        return dto;
    }



    private static Integer  switchProgree(String progress){
        Integer result = null;
        switch (progress) {
            case "1":
                result = 1;
                break;
            case "2":
                result = 2;
                break;
            case "3":
                result = 3;
                break;
            case "4":
                result = 4;
                break;
            case "5":
                result = 5;
                break;
            case "6":
                result = 6;
                break;
            case "7":
                result = 7;
                break;
        }
        return result;
    }




    @PostConstruct
    public void afterPropertiesSet() throws Exception {
        // 注册到Map中
        FlowCompleteFactory.register(FlowConstant.SURVEY_COMPLETE_FLOW, this);
    }
}
