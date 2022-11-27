package com.correction.backend.modules.handleCorrection.controller;

import com.correction.backend.modules.handleCorrection.controller.dto.HandleCorrectionFlowDTO;
import com.correction.backend.modules.handleCorrection.controller.dto.HandleCorrectionFlowListDTO;
import com.correction.backend.modules.handleCorrection.service.HandleCorrectionFlowService;
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

@Api(tags = "入矫申请-入矫申请流程相关接口")
@RestController
@RequestMapping("/handleCorrection-flow")
@Validated
public class HandleCorrectionFlowController {


    @Resource
    HandleCorrectionFlowService handleCorrectionFlowService;


    @PostMapping("/startFlow")
    @ApiOperation("提交审批")
    public CommonResult<ActProcessInstance> startFlow(@Valid @RequestBody HandleCorrectionFlowListDTO reqDTO) throws Exception {
        ActProcessInstance actProcessInstance = handleCorrectionFlowService.startFlow(reqDTO);
        return success(actProcessInstance);
    }

    @PostMapping("/doComplete")
    @ApiOperation("通过、拒绝、驳回操作")
    public CommonResult<Boolean> doComplete(@Valid @RequestBody FlowCompleteDTO reqDTO) throws Exception {
        handleCorrectionFlowService.doComplete(reqDTO);
        return success(true);
    }

    @PostMapping("/doFlowComplete")
    @ApiOperation("通过、拒绝、驳回操作,并保存结果")
    public CommonResult<Boolean> doFlowComplete(@Valid @RequestBody HandleCorrectionFlowDTO reqDTO) throws Exception {
        handleCorrectionFlowService.doFlowComplete(reqDTO);
        return success(true);
    }


}
