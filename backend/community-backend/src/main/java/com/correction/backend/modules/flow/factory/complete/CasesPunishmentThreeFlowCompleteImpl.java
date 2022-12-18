package com.correction.backend.modules.flow.factory.complete;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.correction.backend.modules.cases.entity.CasesPunishment;
import com.correction.backend.modules.cases.service.CasesPunishmentService;
import com.correction.backend.modules.flow.constant.FlowConstant;
import com.correction.backend.modules.survey.constant.SurveyConstant;
import com.correction.framework.workflow.constant.WorkFlowConstant;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class CasesPunishmentThreeFlowCompleteImpl implements FlowComplete{

    @Resource
    CasesPunishmentService casesPunishmentService;

    @Override
    public void doUpdateData(String dataId, String ref, String progress, String status) {
        CasesPunishment byId = casesPunishmentService.getById(Long.parseLong(dataId));
        if(WorkFlowConstant.TASK_SUCCESS.equals(status)){
            //成功！
            if(StringUtils.isNotBlank(progress)){
                if(7 == Integer.parseInt(progress)) {
                    byId.setProgress(10);
                    byId.setApplyStatus(10);
                } else {
                    byId.setProgress(Integer.parseInt(progress) + 1);
                    byId.setApplyStatus(Integer.parseInt(progress) + 1);
                }
            }
        } else {
            //驳回
            if(StringUtils.isNotBlank(progress)){
                byId.setProgress(Integer.parseInt(progress) -1);
                byId.setApplyStatus(Integer.parseInt(progress) - 1);
            }
        }
        casesPunishmentService.updateById(byId);
    }

    @Override
    public void doEnd(String dataId, String ref, String progress, String status) {
        CasesPunishment byId = casesPunishmentService.getById(Long.parseLong(dataId));
        if(WorkFlowConstant.TASK_SUCCESS.equals(status)){
            byId.setProgress(99);
            byId.setApplyStatus(99);
            byId.setEndFlowTime(LocalDateTime.now().toString());
        } else {
            byId.setApplyStatus(SurveyConstant.FLOW_STATUS_u1);
        }
        casesPunishmentService.updateById(byId);
    }

    @PostConstruct
    public void afterPropertiesSet() throws Exception {
        // 注册到Map中
        FlowCompleteFactory.register(FlowConstant.CASESPUNISHMENT_FLOW_THREE, this);
    }

}
