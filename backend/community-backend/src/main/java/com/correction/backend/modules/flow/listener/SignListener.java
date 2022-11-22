package com.correction.backend.modules.flow.listener;

import cn.hutool.extra.spring.SpringUtil;
import com.correction.backend.modules.flow.constant.FlowConstant;
import com.correction.backend.modules.flow.entity.FlowCenter;
import com.correction.backend.modules.flow.factory.complete.FlowComplete;
import com.correction.backend.modules.flow.factory.complete.FlowCompleteFactory;
import com.correction.backend.modules.flow.service.FlowCenterService;
import lombok.extern.slf4j.Slf4j;
import org.flowable.engine.TaskService;
import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.ExecutionListener;
import org.flowable.task.api.Task;

import java.util.List;

/**
 * 会签监听器 流程任务分发
 */
@Slf4j
public class SignListener implements ExecutionListener {


    @Override
    public void notify(DelegateExecution delegateExecution) {
        log.info("进入SignListener");
        TaskService taskService = SpringUtil.getBean(TaskService.class);
        String processInstanceBusinessKey = delegateExecution.getProcessInstanceBusinessKey();
        String currentActivityId = delegateExecution.getCurrentActivityId();
        FlowCenterService flowCenterService = SpringUtil.getBean(FlowCenterService.class);
        //根据activityId 得到关联节点信息
        FlowCenter flowCenter = flowCenterService.getFlowCenterByActivityId(currentActivityId);
        List<String> userIdList = flowCenterService.getUserIdListByFlow(currentActivityId, processInstanceBusinessKey,flowCenter);
        Object completeStatus = delegateExecution.getVariable("completeStatus");
        Object progress = delegateExecution.getVariable("progress");
        delegateExecution.setVariable("assigneeList",userIdList);
        delegateExecution.setVariable("totalCount",userIdList.size());
        //将通过人数，未通过人数，总数，重新置为0，退回的时候才能重新计算
        delegateExecution.setVariable("passCount", "0");
        delegateExecution.setVariable("refusedCount", "0");
        delegateExecution.setVariable("rejectedCount", "0");
        Task task = taskService.createTaskQuery().executionId(delegateExecution.getId())
                .active().singleResult();
        String[] split = processInstanceBusinessKey.split(":");
        //todo 推送邮件审批之类
        FlowComplete byFlowType = FlowCompleteFactory.getByFlowType(split[0]);
        byFlowType.doUpdateData(split[1],split[2],String.valueOf(progress),completeStatus==null?"success":String.valueOf(completeStatus));
    }
}
