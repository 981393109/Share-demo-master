package com.correction.backend.modules.flow.listener;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.spring.SpringUtil;
import com.correction.backend.modules.flow.factory.complete.FlowComplete;
import com.correction.backend.modules.flow.factory.complete.FlowCompleteFactory;
import lombok.extern.slf4j.Slf4j;
import org.flowable.engine.TaskService;
import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.ExecutionListener;
import org.flowable.task.api.Task;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 流程通过监听器
 */
@Slf4j
@Component
public class SignPassListener implements ExecutionListener {


    @Override
    public void notify(DelegateExecution execution) {
        TaskService taskService = SpringUtil.getBean(TaskService.class);
        Task task = taskService.createTaskQuery().executionId(execution.getId())
                .active().singleResult();
        String processInstanceBusinessKey = execution.getProcessInstanceBusinessKey();
        //处理业务结果
        String[] split = processInstanceBusinessKey.split(":");
        //获取变量
        Object completeStatus = execution.getVariable("completeStatus");
        Object progress = execution.getVariable("progress");
        FlowComplete byFlowType = FlowCompleteFactory.getByFlowType(split[0]);
        byFlowType.doEnd(split[1],split[2],String.valueOf(progress),String.valueOf(completeStatus));

    }

}
