package com.correction.framework.workflow.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.BetweenFormatter;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.PageUtil;
import cn.hutool.core.util.StrUtil;
import com.correction.framework.workflow.constant.WorkFlowConstant;
import com.correction.framework.workflow.factory.ActProcessInstance;
import com.correction.framework.workflow.service.ActFlowableTaskService;
import com.correction.framework.workflow.service.ActUserService;
import com.google.common.collect.ImmutableMap;
import lombok.extern.slf4j.Slf4j;
import org.flowable.engine.*;
import org.flowable.engine.history.HistoricProcessInstance;
import org.flowable.engine.repository.ProcessDefinition;
import org.flowable.engine.runtime.ActivityInstance;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.engine.task.Comment;
import org.flowable.task.api.Task;
import org.flowable.task.api.TaskInfo;
import org.flowable.task.api.TaskQuery;
import org.flowable.task.api.history.HistoricTaskInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;



/**
 * @Author：Suyuan
 * @Description:
 * @Date: 2021/6/7 10:48
 */
@Service
@Slf4j
public class ActTaskService implements ActFlowableTaskService {

    @Autowired
    private IdentityService identityService;

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private HistoryService historyService;

    @Autowired
    private ActUserService actUserService;
    @Autowired
    private RepositoryService repositoryService;


    /**
     * 启动流程
     *
     * @param processDefinitionKey 流程定义key
     * @param businessKey          业务key（格式：表名:主键id）
     * @param userId               用户id
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public ActProcessInstance startProcess(String processDefinitionKey, String businessKey, String userId) {
        // 设置发起人
        identityService.setAuthenticatedUserId(userId);
        final ImmutableMap<String, Object> variables = ImmutableMap.of(WorkFlowConstant.TASK_BUSINESS_KEY, businessKey, "userId", userId);
        // 根据流程 key 启动流程
        final ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(processDefinitionKey, businessKey, variables);
        // 流程实例设置名称
        final String nickName = actUserService.getNickNameByUserId(userId);
        runtimeService.setProcessInstanceName(processInstance.getId(),
                StrUtil.format("{}在{}发起了{}", nickName, DateUtil.formatDateTime(processInstance.getStartTime()), processInstance.getProcessDefinitionName()));
        return new ActProcessInstance()
                .setProcessInstanceId(processInstance.getId())
                .setProcessDefinitionId(processInstance.getId())
                .setProcessDefinitionId(processInstance.getProcessDefinitionId())
                .setProcessDefinitionName(processInstance.getProcessDefinitionName())
                .setProcessDefinitionKey(processInstance.getProcessDefinitionKey())
                .setBusinessKey(processInstance.getBusinessKey())
                .setName(processInstance.getName())
                .setStartTime(processInstance.getStartTime())
                .setStartUserId(processInstance.getStartUserId());
    }

    /**
     * 启动任务并且完成首个任务
     *
     * @param processDefinitionKey 流程定义key
     * @param businessKey          业务key（格式：表名:主键id）
     * @param userId               用户id
     * @return
     */
    @Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_UNCOMMITTED)
    @Override
    public ActProcessInstance startProcessAndCompleteFirstTask(String processDefinitionKey, String businessKey, String userId) {
        // 设置发起人
        log.info("processDefinitionKey:{}", processDefinitionKey);
        log.info("businessKey:{}", businessKey);
        log.info("userId:{}", userId);
        identityService.setAuthenticatedUserId(userId);
        final ImmutableMap<String, Object> variables = ImmutableMap.of(WorkFlowConstant.TASK_BUSINESS_KEY, businessKey, "userId", userId);
        log.info("得到申请人：" + variables);
        // 根据流程 key 启动流程
        final ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(processDefinitionKey, businessKey, variables);
        // 流程实例设置名称
        final String nickName = actUserService.getNickNameByUserId(userId);
        runtimeService.setProcessInstanceName(processInstance.getId(),
                StrUtil.format("{}在{}发起了{}", nickName, DateUtil.formatDateTime(processInstance.getStartTime()), processInstance.getProcessDefinitionName()));
        final Task task = taskService.createTaskQuery()
                .processDefinitionId(processInstance.getProcessDefinitionId())
                .processDefinitionKey(processInstance.getProcessDefinitionKey())
                .processInstanceId(processInstance.getProcessInstanceId())
                .processInstanceBusinessKey(businessKey)
                .taskAssignee(userId)
                .singleResult();
        log.info("得到变量结果：" + task.getProcessVariables());

        // 完成第一个任务
        taskService.complete(task.getId());
        return new ActProcessInstance()
                .setProcessInstanceId(processInstance.getId())
                .setProcessDefinitionId(processInstance.getId())
                .setProcessDefinitionId(processInstance.getProcessDefinitionId())
                .setProcessDefinitionName(processInstance.getProcessDefinitionName())
                .setProcessDefinitionKey(processInstance.getProcessDefinitionKey())
                .setBusinessKey(processInstance.getBusinessKey())
                .setName(processInstance.getName())
                .setStartTime(processInstance.getStartTime())
                .setStartUserId(processInstance.getStartUserId());
    }

    /**
     * 签收任务
     *
     * @param taskId
     * @param userId
     */
    public void claim(String taskId, String userId) {
        taskService.claim(taskId, userId);
    }


    /**
     * 完成任务
     *
     * @param taskId
     * @param userId
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void complete(String taskId, String userId) {
        Task task = getTaskByTaskIdAndUserId(taskId, userId);
        if (task != null && StrUtil.isNotBlank(userId)) {
            // 签收任务
            taskService.claim(task.getId(), userId);
            // 设置完成人
            taskService.setAssignee(task.getId(), userId);
        }
        taskService.complete(taskId);
    }

    /**
     * 完成任务
     *
     * @param taskId
     * @param userId
     * @param comment
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void complete(String taskId, String userId, String comment) {
        Task task = getTaskByTaskIdAndUserId(taskId, userId);
        if (task != null && StrUtil.isNotBlank(userId)) {
            // 签收任务
            taskService.claim(task.getId(), userId);
            // 设置完成人
            taskService.setAssignee(task.getId(), userId);
        }
        if (task != null && StrUtil.isNotBlank(task.getProcessInstanceId()) && StrUtil.isNotBlank(comment)) {
            // 保存意见
            taskService.addComment(task.getId(), task.getProcessInstanceId(), WorkFlowConstant.TASK_STATUS, WorkFlowConstant.TASK_SUCCESS);
            taskService.addComment(task.getId(), task.getProcessInstanceId(), WorkFlowConstant.TASK_COMMENT, comment);
        }
        taskService.complete(taskId);
    }

    /**
     * 完成任务
     *
     * @param taskId
     * @param userId
     * @param comment
     * @param variables
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void complete(String taskId, String userId, String comment, Map<String, Object> variables) {
        Task task = getTaskByTaskIdAndUserId(taskId, userId);
        if (task != null && StrUtil.isNotBlank(userId)) {
            // 签收任务
            taskService.claim(task.getId(), userId);
            // 设置完成人
            taskService.setAssignee(task.getId(), userId);
        }
        if (task != null && StrUtil.isNotBlank(task.getProcessInstanceId()) && StrUtil.isNotBlank(comment)) {
            // 保存意见
            taskService.addComment(task.getId(), task.getProcessInstanceId(), WorkFlowConstant.TASK_STATUS, WorkFlowConstant.TASK_SUCCESS);
            taskService.addComment(task.getId(), task.getProcessInstanceId(), WorkFlowConstant.TASK_COMMENT, comment);
        }
        if (CollUtil.isNotEmpty(variables)) {
            taskService.complete(taskId, variables);
        } else {
            taskService.complete(taskId);
        }

    }

    /**
     * 完成任务
     *
     * @param taskId
     * @param userId
     * @param comment
     * @param adopt
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void complete(String taskId, String userId, String comment, Boolean adopt) {
        Task task = getTaskByTaskIdAndUserId(taskId, userId);
        if (task != null && StrUtil.isNotBlank(userId)) {
            // 签收任务
            taskService.claim(task.getId(), userId);
            // 设置完成人
            taskService.setAssignee(task.getId(), userId);
        }
        if (task != null && StrUtil.isNotBlank(task.getProcessInstanceId()) && StrUtil.isNotBlank(comment)) {
            // 保存意见
            taskService.addComment(task.getId(), task.getProcessInstanceId(), WorkFlowConstant.TASK_STATUS, adopt ? WorkFlowConstant.TASK_SUCCESS : WorkFlowConstant.TASK_REJECT);
            taskService.addComment(task.getId(), task.getProcessInstanceId(), WorkFlowConstant.TASK_COMMENT, comment);
        }
        taskService.complete(taskId);
    }

    /**
     * 完成任务并且设置流程变量
     *
     * @param taskId
     * @param userId
     * @param comment
     * @param adopt
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void completeAndSetVar(String taskId, String userId, String comment, Boolean adopt) {
        complete(taskId, userId, comment, adopt, ImmutableMap.of(WorkFlowConstant.TASK_STATUS, adopt ? WorkFlowConstant.TASK_SUCCESS : WorkFlowConstant.TASK_REJECT));
    }

    /**
     * 完成任务
     *
     * @param taskId
     * @param userId
     * @param comment
     * @param adopt
     * @param variables
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void complete(String taskId, String userId, String comment, Boolean adopt, Map<String, Object> variables) {
        Task task = getTaskByTaskIdAndUserId(taskId, userId);
        if (task != null && StrUtil.isNotBlank(userId)) {
            // 签收任务
            taskService.claim(task.getId(), userId);
            // 设置完成人
            taskService.setAssignee(task.getId(), userId);
        }
        if (task != null && StrUtil.isNotBlank(task.getProcessInstanceId()) && StrUtil.isNotBlank(comment)) {
            // 保存意见
            taskService.addComment(task.getId(), task.getProcessInstanceId(), WorkFlowConstant.TASK_STATUS, adopt ? WorkFlowConstant.TASK_SUCCESS : WorkFlowConstant.TASK_REJECT);
            taskService.addComment(task.getId(), task.getProcessInstanceId(), WorkFlowConstant.TASK_COMMENT, comment);
        }
        //统计完成情况：
        Integer taskPassCount = !"null".equals(taskService.getVariable(task.getId(), "passCount") + "") ? Integer.parseInt(taskService.getVariable(task.getId(), "passCount") + "") : 0;
        Integer taskRefusedCount = !"null".equals(taskService.getVariable(task.getId(), "refusedCount") + "") ? Integer.parseInt(taskService.getVariable(task.getId(), "refusedCount") + "") : 0;
        Integer taskTotalCount = !"null".equals(taskService.getVariable(task.getId(), "totalCount") + "") ? Integer.parseInt(taskService.getVariable(task.getId(), "totalCount") + "") : 0;
        System.out.println("taskPassCount:" + taskPassCount);
        System.out.println("taskRefusedCount:" + taskRefusedCount);
        System.out.println("taskTotalCount:" + taskTotalCount);
        //得到当前流程变量数据：
        if (adopt) {
            taskPassCount += 1;
        } else {
            taskRefusedCount += 1;
        }
        variables.put("passCount", taskPassCount);
        variables.put("refusedCount", taskRefusedCount);
        variables.put("totalCount", taskTotalCount);
        if (CollUtil.isNotEmpty(variables)) {
            taskService.complete(taskId, variables);
        } else {
            taskService.complete(taskId);
        }
    }

    /**
     * 查询任务
     *
     * @param taskId
     * @param userId
     * @return
     */
    private Task getTaskByTaskIdAndUserId(String taskId, String userId) {
        Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
        if (task.isSuspended()) {
            return null;
        }
        if (StrUtil.isBlank(task.getAssignee()) && StrUtil.isBlank(userId)) {
            return null;
        }
        return task;
    }

    /**
     * 根据用户获取代表列表流程实例ids
     *
     * @param userId
     * @return
     */
    public List<String> getRunProInsIdList(String userId, Collection<String> groupIds) {
        // =============== 已签收和未签收同时查询 ===============
        TaskQuery taskQuery = taskService.createTaskQuery();
        if (StrUtil.isNotBlank(userId)) {
            taskQuery.taskCandidateOrAssigned(userId);
        }
        if (CollUtil.isNotEmpty(groupIds)) {
            taskQuery.taskCandidateGroupIn(groupIds);
        }
        return taskQuery.active().list().stream().map(TaskInfo::getProcessInstanceId).distinct().collect(Collectors.toList());
    }

    /**
     * 根据用户Id获取历史任务流程实例ids
     *
     * @param userId
     * @return
     */
    public List<String> getHisProInsIdList(String userId) {
        return historyService.createHistoricTaskInstanceQuery()
                .taskAssignee(userId).finished()
                .list().stream().map(TaskInfo::getProcessInstanceId).distinct().collect(Collectors.toList());
    }

    /**
     * 根据流程实例id删除流程实例
     *
     * @param processInstanceId
     */
    @Override
    public void deleteProcess(String processInstanceId) {
        final long count = runtimeService.createProcessInstanceQuery().processInstanceId(processInstanceId).count();
        if (count > 0) {
            runtimeService.deleteProcessInstance(processInstanceId, "删除流程");
        }
        final long hisCount = historyService.createHistoricProcessInstanceQuery().processInstanceId(processInstanceId).count();
        if (hisCount > 0) {
            historyService.deleteHistoricProcessInstance(processInstanceId);
        }
    }

    @Override
    public String getTaskIdByProcessInstanceId(String processInstanceId, String userId) {
        final Task task = taskService.createTaskQuery()
                .processInstanceId(processInstanceId)
                .taskAssignee(userId)
                .active()
                .singleResult();
        if (task != null) {
            return task.getId();
        }
        return null;
    }

    @Override
    public void delete(String businessKey) {
        Optional.ofNullable(runtimeService.createProcessInstanceQuery()
                .processInstanceBusinessKey(businessKey)
                .singleResult())
                .ifPresent(processInstance -> runtimeService.deleteProcessInstance(processInstance.getId(), "删除流程"));

        Optional.ofNullable(historyService.createHistoricProcessInstanceQuery()
                .processInstanceBusinessKey(businessKey)
                .singleResult())
                .ifPresent(historicProcessInstance -> historyService.deleteHistoricProcessInstance(historicProcessInstance.getId()));
    }


    



}
