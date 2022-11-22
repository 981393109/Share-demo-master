package com.correction.backend.modules.flow.controller;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.PageUtil;
import com.correction.backend.modules.flow.controller.dto.ProcessDefinitionListOutputDTO;
import com.correction.framework.common.pojo.CommonResult;
import com.correction.framework.common.pojo.PageResult;
import com.correction.framework.workflow.service.impl.ActTaskService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.repository.Deployment;
import org.flowable.engine.repository.ProcessDefinition;
import org.flowable.engine.repository.ProcessDefinitionQuery;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

import static com.correction.framework.common.pojo.CommonResult.success;

/**
 * @Author：Suyuan
 * @Description:
 * @Date: 2021/6/7 10:24
 */
@RequiredArgsConstructor
@Validated
@Slf4j
@RestController
@RequestMapping("/flow/process")
@Api(value = "ProcessController", tags = {"流程-流程操作接口"})
public class ProcessController  {

    private final RepositoryService repositoryService;
    private final ActTaskService actTaskService;


    @ApiOperation(value = "获取流程定义列表")
    @GetMapping(value = "/page")
    public CommonResult<PageResult<ProcessDefinitionListOutputDTO>> getProcessDefinitionList() {
        PageResult<ProcessDefinitionListOutputDTO> pageResult = new PageResult<>();
        ProcessDefinitionQuery processDefinitionQuery = repositoryService.createProcessDefinitionQuery().orderByProcessDefinitionId().orderByProcessDefinitionVersion().desc();
        List<ProcessDefinitionListOutputDTO> list = new ArrayList<>();
        // 设置首页页码
        PageUtil.setFirstPageNo(1);
        List<ProcessDefinition> processDefinitionList = processDefinitionQuery.listPage(PageUtil.getStart(Convert.toInt("1"), Convert.toInt("100")), Convert.toInt("100"));
        long count = processDefinitionQuery.count();
        for (ProcessDefinition processDefinition : processDefinitionList) {
            String deploymentId = processDefinition.getDeploymentId();
            Deployment deployment = repositoryService.createDeploymentQuery().deploymentId(deploymentId).singleResult();
            list.add(new ProcessDefinitionListOutputDTO(processDefinition, deployment));
        }
        // 赋值
        pageResult.setList(list);
        pageResult.setTotal(count);
        return success(pageResult);
    }

    @ApiOperation(value = "删除部署的流程，级联删除流程实例")
    @ApiImplicitParam(name = "deploymentId", value = "流程部署id", dataType = "String", paramType = "query")
    @PostMapping(value = "/delete")
    public CommonResult<Boolean> delete(@NotBlank(message = "流程部署id不能为空") String deploymentId) {
        repositoryService.deleteDeployment(deploymentId, true);
        return success(true);
    }

    @ApiOperation(value = "删除流程实例")
    @ApiImplicitParam(name = "processInstanceId", value = "流程实例id", dataType = "String", paramType = "query")
    @PostMapping(value = "/deleteProcIns")
    public CommonResult<Boolean> deleteProcIns(@NotBlank(message = "流程实例id不能为空") String processInstanceId) {
        actTaskService.deleteProcess(processInstanceId);
        return success(true);
    }



}

