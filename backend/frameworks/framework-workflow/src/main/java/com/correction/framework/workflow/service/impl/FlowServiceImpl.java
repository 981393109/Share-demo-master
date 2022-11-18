package com.correction.framework.workflow.service.impl;

import cn.hutool.core.util.StrUtil;
import com.correction.framework.workflow.constant.WorkFlowConstant;
import com.correction.framework.workflow.dto.FlowCompleteDTO;
import com.correction.framework.workflow.dto.FlowStartDTO;
import com.correction.framework.workflow.factory.ActProcessInstance;
import com.correction.framework.workflow.service.ActFlowableTaskService;
import com.correction.framework.workflow.service.FlowService;
import lombok.extern.slf4j.Slf4j;
import org.flowable.engine.RepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class FlowServiceImpl implements FlowService {

    @Autowired
    RepositoryService repositoryService;

    @Autowired
    ActFlowableTaskService actFlowableTaskService;


    @Override
    public ActProcessInstance startFlow(FlowStartDTO startDTO) {
        log.info("开始启动流程:"+startDTO.getFlowType());
        // 拼装 业务key
        String businessKey = StrUtil.builder()
                .append(startDTO.getFlowType())
                .append(":")
                .append(startDTO.getDataId()).toString();
        // 启动流程 并且 完成首个任务
        final ActProcessInstance actProcessInstance = actFlowableTaskService.startProcessAndCompleteFirstTask(startDTO.getFlowType(), businessKey, String.valueOf(startDTO.getUserId()));
        return actProcessInstance;
    }


    @Override
    public void complete(Long userId, FlowCompleteDTO flowCompleteDTO) {
        Map<String,Object> map = new HashMap<>();
        map.put(WorkFlowConstant.TASK_STATUS, WorkFlowConstant.TASK_MU_1.equals(flowCompleteDTO.getAdopt()) ? WorkFlowConstant.TASK_SUCCESS : (WorkFlowConstant.TASK_MU_2.equals(flowCompleteDTO.getAdopt()) ?WorkFlowConstant.TASK_REJECT:WorkFlowConstant.TASK_REJECTED));
        actFlowableTaskService.complete(flowCompleteDTO.getTaskId(),String.valueOf(userId),flowCompleteDTO.getComment(),map);
    }

}
