package com.correction.backend.modules.flow.factory.complete;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.correction.backend.modules.cases.entity.RewardRecord;
import com.correction.backend.modules.flow.constant.FlowConstant;
import com.correction.backend.modules.handleCorrection.entity.CorrectionUser;
import com.correction.backend.modules.handleCorrection.service.CorrectionUserService;
import com.correction.backend.modules.survey.constant.SurveyConstant;
import com.correction.backend.modules.termination.entity.TerminationSolutions;
import com.correction.backend.modules.termination.service.TerminationSolutionsService;
import com.correction.framework.workflow.constant.WorkFlowConstant;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class TerminationSolutionFlowCompleteImpl implements FlowComplete{

    @Resource
    TerminationSolutionsService terminationSolutionsService;

    @Resource
    CorrectionUserService correctionUserService;

    @Override
    public void doUpdateData(String dataId, String ref, String progress, String status) {
        TerminationSolutions byId = terminationSolutionsService.getById(Long.parseLong(dataId));
        if(WorkFlowConstant.TASK_SUCCESS.equals(status)){
            //成功！
            if(StringUtils.isNotBlank(progress)){
                byId.setProgress(Integer.parseInt(progress) + 1);
                byId.setApplyStatus(Integer.parseInt(progress) + 1);
                byId.setEndFlowTime(LocalDateTime.now().toString());
            }
        } else {
            //驳回
            if(StringUtils.isNotBlank(progress)){
                byId.setProgress(Integer.parseInt(progress) -1);
                byId.setApplyStatus(Integer.parseInt(progress) - 1);
            }
        }
        terminationSolutionsService.updateById(byId);
    }

    @Override
    public void doEnd(String dataId, String ref, String progress, String status) {
        TerminationSolutions byId = terminationSolutionsService.getById(Long.parseLong(dataId));
        if(WorkFlowConstant.TASK_SUCCESS.equals(status)){
            byId.setProgress(99);
            byId.setApplyStatus(99);
            //处理矫正档案中的对象
            CorrectionUser correctionUser = correctionUserService.getById(byId.getUserId());
            correctionUser.setIsHistory(1);
            correctionUserService.updateById(correctionUser);
        } else {
            byId.setApplyStatus(SurveyConstant.FLOW_STATUS_u1);
        }
        terminationSolutionsService.updateById(byId);
    }

    @PostConstruct
    public void afterPropertiesSet() throws Exception {
        // 注册到Map中
        FlowCompleteFactory.register(FlowConstant.TERMINATION_SOLUTIONS_FLOW, this);
    }
}
