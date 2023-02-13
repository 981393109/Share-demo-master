package com.correction.backend.modules.flow.factory.complete;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.correction.backend.modules.cases.entity.RewardRecord;
import com.correction.backend.modules.cases.service.RewardRecordService;
import com.correction.backend.modules.flow.constant.FlowConstant;
import com.correction.backend.modules.supervision.entity.SupervisionOutApproval;
import com.correction.backend.modules.survey.constant.SurveyConstant;
import com.correction.framework.workflow.constant.WorkFlowConstant;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

@Component
public class RewardRecordFirstFlowCompleteImpl implements FlowComplete{

    @Resource
    RewardRecordService rewardRecordService;

    @Override
    public void doUpdateData(String dataId, String ref, String progress, String status) {
        RewardRecord byId = rewardRecordService.getById(Long.parseLong(dataId));
        if(WorkFlowConstant.TASK_SUCCESS.equals(status)){
            //成功！
            if(StringUtils.isNotBlank(progress)){
                if (Integer.parseInt(progress) == 98) {
                    byId.setProgress(4);
                    byId.setApplyStatus(4);
                } else {
                    byId.setProgress(Integer.parseInt(progress) + 1);
                    byId.setApplyStatus(Integer.parseInt(progress) + 1);
                }
            }
        } else {
            //驳回
            if(StringUtils.isNotBlank(progress)){
                byId.setProgress(98);
                byId.setApplyStatus(98);
                byId.setIsBack(1);
            }
        }
        rewardRecordService.updateById(byId);
    }

    @Override
    public void doEnd(String dataId, String ref, String progress, String status) {
        RewardRecord byId = rewardRecordService.getById(Long.parseLong(dataId));
        if(WorkFlowConstant.TASK_SUCCESS.equals(status)){
            byId.setProgress(5);
            byId.setApplyStatus(5);
        } else {
            byId.setApplyStatus(SurveyConstant.FLOW_STATUS_u1);
        }
        rewardRecordService.updateById(byId);
    }



    @PostConstruct
    public void afterPropertiesSet() throws Exception {
        // 注册到Map中
        FlowCompleteFactory.register(FlowConstant.REWARDRECORD_FLOW_FIRST, this);
    }
}
