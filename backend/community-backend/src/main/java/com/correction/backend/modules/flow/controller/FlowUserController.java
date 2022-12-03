package com.correction.backend.modules.flow.controller;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.BetweenFormatter;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.PageUtil;
import cn.hutool.core.util.StrUtil;
import com.correction.backend.modules.flow.controller.dto.*;
import com.correction.backend.modules.flow.service.FlowUserService;
import com.correction.framework.common.pojo.CommonResult;
import com.correction.framework.common.pojo.PageParam;
import com.correction.framework.web.web.core.util.WebFrameworkUtils;
import com.correction.framework.workflow.dto.ActivityInstanceListOutputDTO;
import com.correction.framework.workflow.service.impl.ActTaskService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.flowable.engine.HistoryService;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.engine.history.HistoricProcessInstance;
import org.flowable.engine.repository.ProcessDefinition;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.task.api.Task;
import org.flowable.task.api.TaskQuery;
import org.flowable.task.api.history.HistoricTaskInstance;
import org.flowable.task.api.history.HistoricTaskInstanceQuery;
import org.flowable.variable.api.history.HistoricVariableInstance;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static com.correction.framework.common.pojo.CommonResult.success;

/**
 * 提交流程选择对应用户相关接口
 */

@Api(tags = "审批-提交审批用户相关接口")
@RestController
@RequestMapping("/survey-flow")
@Validated
public class FlowUserController {


    @Resource
    private FlowUserService flowUserService;


    @GetMapping("/getFlowNode")
    @ApiOperation("获取流程审批节点")
    @ApiImplicitParam(name = "flowType", value = "flowType", required = true, example = "调查评估：SURVEY_FLOW,入矫办理：HANDLE_CORRECTION_FLOW", dataTypeClass = String.class)
    public CommonResult<List<FlowNodeListDTO>> getFlowNode(@RequestParam("flowType") String flowType) throws Exception {
        List<FlowNodeListDTO> flowNodeUserList = flowUserService.getFlowNode(flowType);
        return success(flowNodeUserList);
    }


    /*@GetMapping("/getFlowUser")
    @ApiOperation("获取审批数据：  组织、角色、人员，基于用户当前组织平级以及上级组织")
    public CommonResult<Map<FlowNodeListDTO, List<FlowOrgRoleDTO>>> getFlowUser(@RequestParam("flowType") String flowType) throws Exception {
        Map<FlowNodeListDTO, List<FlowOrgRoleDTO>> flowOrgInfo = flowUserService.getFlowOrgInfo(flowType);
        return success(flowOrgInfo);
    }*/


    @Resource
    RuntimeService runtimeService;

    @Resource
    TaskService taskService;

    @Resource
    RepositoryService repositoryService;

    @Resource
    HistoryService historyService;

    @Resource
    ActTaskService actTaskService;


    @ApiOperation(value = "获取该用户的代办任务(测试)")
    @GetMapping(value = "/getRunTaskList")
    public CommonResult<List<TaskListOutputDTO>> getRunTaskList(PageParam pageParam) {
        List<TaskListOutputDTO> result = new ArrayList<>();
        Long userId = WebFrameworkUtils.getLoginUserId();
        // 查看user的所有组
        final TaskQuery taskQuery = taskService.createTaskQuery()
                // 候选组
                //.taskCandidateGroupIn(new ArrayList<>())
                // 候选用户 or Assigned
                .taskCandidateOrAssigned(String.valueOf(userId))
                .orderByTaskCreateTime().desc()
                .active();
        // 查询总数
        final long count = taskQuery.count();
        if (count <= 0) {
            return success(new ArrayList<>());
        }
        PageUtil.setFirstPageNo(1);
        final List<Task> list = taskQuery.list();
        List<TaskListOutputDTO> taskListOutputDTOS = new ArrayList<>();
        list.forEach(task -> {
            final ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery()
                    .processDefinitionId(task.getProcessDefinitionId())
                    .singleResult();
            final ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId(task.getProcessInstanceId()).singleResult();
            final TaskListOutputDTO taskListOutputDTO = new TaskListOutputDTO();
            String startUserName = null,
                    curTaskUserName = null;
            /*if (StrUtil.isNotBlank(processInstance.getStartUserId())) {
                startUserName = actUserService.getNickNameByUserId(processInstance.getStartUserId());
            }
            if (StrUtil.isNotBlank(task.getAssignee())) {
                curTaskUserName = actUserService.getNickNameByUserId(task.getAssignee());
            }*/
            final String businessKey = taskService.getVariable(task.getId(), "businessKey", String.class);
            if (StrUtil.isNotBlank(businessKey)) {
                taskListOutputDTO.setBusinessKey(businessKey);
                final List<String> businessKeyAsList = Arrays.asList(StrUtil.split(businessKey, ":"));
                // 获取表名
                final String tableName = CollUtil.getFirst(businessKeyAsList);
                taskListOutputDTO.setTableName(tableName);
                // 获取主键id
                final String id = CollUtil.getLast(businessKeyAsList);
                taskListOutputDTO.setFormId(id);
            }
            taskListOutputDTOS.add(taskListOutputDTO
                    .setTaskId(task.getId())
                    .setProcessInstanceId(task.getProcessInstanceId())
                    .setProcessInstanceName(processInstance.getName())
                    .setProcessDefinitionName(processDefinition.getName())
                    .setStartUserId(processInstance.getStartUserId())
                    .setStartUserName(startUserName)
                    .setStartTime(processInstance.getStartTime())
                    .setClaimTime(task.getClaimTime())
                    .setDueDate(task.getDueDate())
                    .setTaskName(task.getName())
                    .setCurTaskUserId(task.getAssignee())
                    .setCurTaskUserName(curTaskUserName)
                    .setPriority(task.getPriority())
            );
        });
        return CommonResult.success(taskListOutputDTOS);
    }


    @ApiOperation(value = "获取已办任务(测试)")
    @GetMapping(value = "/getHisTaskList")
    public CommonResult<List<HisTaskListOutputDTO>> getHisTaskList() {
        List<HisTaskListOutputDTO> pageResult = new ArrayList<>();
        Long userId = WebFrameworkUtils.getLoginUserId();
        final HistoricTaskInstanceQuery taskInstanceQuery = historyService.createHistoricTaskInstanceQuery()
                .taskAssignee(String.valueOf(userId))
                .orderByHistoricTaskInstanceStartTime().desc()
                .finished();
        // 查询总数
        final long count = taskInstanceQuery.count();
        if (count <= 0) {
            return success(pageResult);
        }
        PageUtil.setFirstPageNo(1);
        final List<HistoricTaskInstance> list = taskInstanceQuery
                .list();
        List<HisTaskListOutputDTO> hisTaskListOutputDTOS = new ArrayList<>();
        list.forEach(historicTaskInstance -> {
            final ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery()
                    .processDefinitionId(historicTaskInstance.getProcessDefinitionId())
                    .singleResult();
            final HistoricProcessInstance historicProcessInstance = historyService.createHistoricProcessInstanceQuery().processInstanceId(historicTaskInstance.getProcessInstanceId()).singleResult();
            final String nickName = "";
                    //actUserService.getNickNameByUserId(historicProcessInstance.getStartUserId());

            final HisTaskListOutputDTO hisTaskListOutputDTO = new HisTaskListOutputDTO();
            // 查询流程变量
            final HistoricVariableInstance historicVariableInstance = historyService.createHistoricVariableInstanceQuery().processInstanceId(historicTaskInstance.getProcessInstanceId())
                    .variableName("businessKey").singleResult();
            if (historicVariableInstance != null) {
                final String businessKey = (String) historicVariableInstance.getValue();
                hisTaskListOutputDTO.setBusinessKey(businessKey);
                final List<String> businessKeyAsList = Arrays.asList(StrUtil.split(businessKey, ":"));
                // 获取表名
                final String tableName = CollUtil.getFirst(businessKeyAsList);
                hisTaskListOutputDTO.setTableName(tableName);
                // 获取主键id
                final String id = CollUtil.getLast(businessKeyAsList);
                hisTaskListOutputDTO.setFormId(id);
            }
            hisTaskListOutputDTOS.add(hisTaskListOutputDTO
                    .setTaskId(historicTaskInstance.getId())
                    .setProcessInstanceId(historicTaskInstance.getProcessInstanceId())
                    .setProcessInstanceName(historicProcessInstance.getName())
                    .setTaskName(historicTaskInstance.getName())
                    .setProcessDefinitionName(processDefinition.getName())
                    .setStartUserId(historicProcessInstance.getStartUserId())
                    .setStartUserName(nickName)
                    .setStartTime(historicProcessInstance.getStartTime())
                    .setEndTime(historicTaskInstance.getEndTime())
                    .setDuration(DateUtil.formatBetween(historicTaskInstance.getCreateTime(), historicTaskInstance.getEndTime(), BetweenFormatter.Level.SECOND)));
        });
        return CommonResult.success(hisTaskListOutputDTOS);
    }


    @ApiOperation(value = "根据流程实例id获取历史任务节点信息")
    @ApiImplicitParam(name = "processInstanceId", value = "流程实例id", dataType = "String", paramType = "query")
    @GetMapping(value = "/getHisTaskInsListByProInsId")
    public CommonResult<List<ActivityInstanceListOutputDTO>> getHisTaskInsListByProInsId(@NotBlank(message = "流程实例id不能为空") String processInstanceId) {
        return success(actTaskService.getHisTaskInsListByProInsId(processInstanceId));
    }


}
