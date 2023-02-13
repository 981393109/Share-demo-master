package com.correction.backend.modules.flow.factory.complete;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.correction.backend.modules.flow.constant.FlowConstant;
import com.correction.backend.modules.handleCorrection.entity.HandleCorrection;
import com.correction.backend.modules.handleCorrection.service.HandleCorrectionService;
import com.correction.backend.modules.survey.constant.SurveyConstant;
import com.correction.framework.workflow.constant.WorkFlowConstant;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class HandleCorrectionFlowCompleteServiceImp implements FlowComplete{

    @Resource
    HandleCorrectionService handleCorrectionService;

    @Override
    public void doUpdateData(String dataId, String ref, String progress, String status) {
        HandleCorrection byId = handleCorrectionService.getById(Long.parseLong(dataId));
        if(WorkFlowConstant.TASK_SUCCESS.equals(status)){
            //成功！
            if(StringUtils.isNotBlank(progress)){
                byId.setProgress(Integer.parseInt(progress) + 1);
                byId.setApplyStatus(switchProgree(progress) + 1);
            }
        } else {
            //驳回
            if(StringUtils.isNotBlank(progress)){
                byId.setProgress(Integer.parseInt(progress) -1);
                byId.setApplyStatus(switchProgree(progress) -1);
            }
        }
        handleCorrectionService.updateById(byId);
    }

    @Override
    public void doEnd(String dataId, String ref, String progress, String status) {
        HandleCorrection byId = handleCorrectionService.getById(Long.parseLong(dataId));
        if(WorkFlowConstant.TASK_SUCCESS.equals(status)){
            byId.setProgress(99);
            byId.setApplyStatus(99);
            byId.setEndFlowTime(LocalDateTime.now().toString());
        } else {
            byId.setApplyStatus(SurveyConstant.FLOW_STATUS_u1);
        }
        handleCorrectionService.updateById(byId);
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
            case "8":
                result = 8;
                break;
            case "9":
                result = 9;
                break;
            case "10":
                result = 10;
                break;
            case "11":
                result = 11;
                break;
        }
        return result;
    }




    @PostConstruct
    public void afterPropertiesSet() throws Exception {
        // 注册到Map中
        FlowCompleteFactory.register(FlowConstant.HANDLE_CORRECTION_COMPLETE_FLOW, this);
    }



}
