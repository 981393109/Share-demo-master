package com.correction.backend.modules.supervision.controller;

import com.correction.backend.modules.handleCorrection.controller.dto.HandleCorrectionFlowDTO;
import com.correction.backend.modules.handleCorrection.controller.dto.HandleCorrectionFlowListDTO;
import com.correction.backend.modules.handleCorrection.service.HandleCorrectionFlowService;
import com.correction.backend.modules.supervision.controller.dto.SupervisionFlowDTO;
import com.correction.backend.modules.supervision.controller.dto.SupervisionStartFlowDTO;
import com.correction.backend.modules.supervision.service.SupervisionFlowService;
import com.correction.framework.common.pojo.CommonResult;
import com.correction.framework.workflow.dto.FlowCompleteDTO;
import com.correction.framework.workflow.factory.ActProcessInstance;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

import static com.correction.framework.common.pojo.CommonResult.success;

@Api(tags = "监督-外出申请流程相关接口")
@RestController
@RequestMapping("/supervisionOutApprovalFlow")
@Validated
public class SupervisionFlowController {

    @Resource
    SupervisionFlowService supervisionFlowService;


    @PostMapping("/startFlow")
    @ApiOperation("提交审批")
    public CommonResult<ActProcessInstance> startFlow(@Valid @RequestBody SupervisionStartFlowDTO reqDTO) throws Exception {
        ActProcessInstance actProcessInstance = supervisionFlowService.startFlow(reqDTO);
        return success(actProcessInstance);
    }

    @PostMapping("/doComplete")
    @ApiOperation("通过、拒绝、驳回操作")
    public CommonResult<Boolean> doComplete(@Valid @RequestBody FlowCompleteDTO reqDTO) throws Exception {
        supervisionFlowService.doComplete(reqDTO,null);
        return success(true);
    }

    @PostMapping("/doFlowComplete")
    @ApiOperation("通过、拒绝、驳回操作,并保存结果")
    public CommonResult<Boolean> doFlowComplete(@Valid @RequestBody SupervisionFlowDTO reqDTO) throws Exception {
        supervisionFlowService.doFlowComplete(reqDTO);
        return success(true);
    }


}
