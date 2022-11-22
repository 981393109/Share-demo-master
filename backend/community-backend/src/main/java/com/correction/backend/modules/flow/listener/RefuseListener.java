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
 * 拒绝任务监听器
 */
@Slf4j
@Component
public class RefuseListener implements ExecutionListener {


    @Override
    public void notify(DelegateExecution execution) {
        TaskService taskService = SpringUtil.getBean(TaskService.class);
        Task task = taskService.createTaskQuery().executionId(execution.getId())
                .active().singleResult();
        System.out.println(task);
        String processInstanceBusinessKey = execution.getProcessInstanceBusinessKey();
        log.info("businessKey:{}", processInstanceBusinessKey);
        final List<String> list = Arrays.asList(StrUtil.split(processInstanceBusinessKey, ":"));
        // 获取业务类型
        final String businessType = CollUtil.getFirst(list);
        log.info("业务id：" + businessType);
        log.info("流程实例id：" + execution.getProcessInstanceId());
        // 获取主键id
        final String id = CollUtil.getLast(list);
        Map<String, Object> map = new HashMap<>();
        map.put("reportId", id);
        map.put("processInstanceId", execution.getProcessInstanceId());
        //处理业务结果
        String[] split = processInstanceBusinessKey.split(":");
        //获取变量
        Object completeStatus = execution.getVariable("completeStatus");
        Object progress = execution.getVariable("progress");
        //todo 推送邮件审批之类
        FlowComplete byFlowType = FlowCompleteFactory.getByFlowType(split[0]);
        //结束了
        byFlowType.doEnd(split[1],split[2],String.valueOf(progress),String.valueOf(completeStatus));
    }


}
