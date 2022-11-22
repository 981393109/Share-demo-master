package com.correction.backend.modules.flow.listener;

import lombok.extern.slf4j.Slf4j;
import org.flowable.task.service.delegate.DelegateTask;
import org.flowable.task.service.delegate.TaskListener;

/**
 * 任务监听，判断流程节点是单人通过还是多人通过
 */
@Slf4j
public class TaskFilterListener implements TaskListener {


    @Override
    public void notify(DelegateTask delegateTask) {
        log.info("进入TaskFilterListener");
       log.info("assignee:"+delegateTask.getAssignee());
       log.info("name:"+delegateTask.getName());
       log.info("processDefinitionId:"+delegateTask.getProcessDefinitionId());
       log.info("processInstanceId:"+delegateTask.getProcessInstanceId());
       log.info("taskDefinitionKey:"+delegateTask.getTaskDefinitionKey());
       log.info("passCount"+delegateTask.getVariable("passCount"));
       log.info("totalCount"+delegateTask.getVariable("totalCount"));
       log.info("refusedCount"+delegateTask.getVariable("refusedCount"));

    }


}
