package com.correction.backend.modules.flow.factory.complete;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.correction.backend.modules.flow.constant.FlowConstant;
import com.correction.backend.modules.supervision.entity.SupervisionPositioningDevices;
import com.correction.backend.modules.supervision.service.SupervisionPositioningDevicesService;
import com.correction.backend.modules.survey.constant.SurveyConstant;
import com.correction.framework.workflow.constant.WorkFlowConstant;
import com.correction.framework.workflow.factory.Flow;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

@Component
public class SupervisionPositioningTwoCompleteServiceImpl implements FlowComplete {

    @Resource
    SupervisionPositioningDevicesService supervisionPositioningDevicesService;



    @Override
    public void doUpdateData(String dataId, String ref, String progress, String status) {
        SupervisionPositioningDevices byId = supervisionPositioningDevicesService.getById(Long.parseLong(dataId));
        if(WorkFlowConstant.TASK_SUCCESS.equals(status)){
            //成功！
            if(StringUtils.isNotBlank(progress)){
                byId.setProgress(Integer.parseInt(progress) + 1);
                byId.setApplyStatus(Integer.parseInt(progress) + 1);
            }
        } else {
            //驳回
            if(StringUtils.isNotBlank(progress)){
                byId.setProgress(Integer.parseInt(progress) -1);
                byId.setApplyStatus(Integer.parseInt(progress) - 1);
            }
        }
        supervisionPositioningDevicesService.updateById(byId);
    }

    @Override
    public void doEnd(String dataId, String ref, String progress, String status) {
        SupervisionPositioningDevices byId = supervisionPositioningDevicesService.getById(Long.parseLong(dataId));
        if(WorkFlowConstant.TASK_SUCCESS.equals(status)){
            byId.setProgress(SurveyConstant.PROGRESS_6);
            byId.setApplyStatus(SurveyConstant.PROGRESS_6);
        } else {
            byId.setApplyStatus(SurveyConstant.FLOW_STATUS_u1);
        }
        supervisionPositioningDevicesService.updateById(byId);
    }



    @PostConstruct
    public void afterPropertiesSet() throws Exception {
        // 注册到Map中
        FlowCompleteFactory.register(FlowConstant.SUPERVISION_POSITION_FLOW_TWO, this);
    }


}
