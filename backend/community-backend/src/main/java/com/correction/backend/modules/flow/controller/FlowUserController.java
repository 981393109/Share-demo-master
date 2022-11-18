package com.correction.backend.modules.flow.controller;

import com.correction.backend.modules.flow.controller.dto.FlowOrgRoleDTO;
import com.correction.backend.modules.flow.service.FlowUserService;
import com.correction.backend.modules.survey.controller.dto.SurveyFlowDTO;
import com.correction.framework.common.pojo.CommonResult;
import com.correction.framework.workflow.factory.ActProcessInstance;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

import java.util.List;

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


    @GetMapping("/getFlowUser")
    @ApiOperation("获取审批数据：  组织、角色、人员，基于用户当前组织平级以及上级组织")
    public CommonResult<List<FlowOrgRoleDTO>> getFlowUser() throws Exception {
        List<FlowOrgRoleDTO> flowOrgInfo = flowUserService.getFlowOrgInfo();
        return success(flowOrgInfo);
    }


}
