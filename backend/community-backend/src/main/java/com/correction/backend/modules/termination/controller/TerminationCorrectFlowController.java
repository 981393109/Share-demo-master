package com.correction.backend.modules.termination.controller;


import com.correction.backend.modules.termination.controller.dto.TerminationCorrectFlowDTO;
import com.correction.backend.modules.termination.controller.dto.TerminationCorrectStartFlowDTO;
import com.correction.backend.modules.termination.controller.dto.TerminationSolutionsFlowDTO;
import com.correction.backend.modules.termination.controller.dto.TerminationSolutionsStartFlowDTO;
import com.correction.backend.modules.termination.service.TerminationCorrectFlowService;
import com.correction.backend.modules.termination.service.TerminationCorrectService;
import com.correction.framework.common.pojo.CommonResult;
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

@RestController
@RequestMapping("/termination-correct-flow")
@Api(tags = "解除与终止-矫正终止流程相关接口")
@Validated
public class TerminationCorrectFlowController {

    @Resource
    TerminationCorrectFlowService terminationCorrectFlowService;


    @PostMapping("/startFlow")
    @ApiOperation("提交审批")
    public CommonResult<ActProcessInstance> startFlow(@Valid @RequestBody TerminationCorrectStartFlowDTO reqDTO) throws Exception {
        ActProcessInstance actProcessInstance = terminationCorrectFlowService.startFlow(reqDTO);
        return success(actProcessInstance);
    }

    @PostMapping("/doFlowComplete")
    @ApiOperation("通过、拒绝、驳回操作,并保存结果")
    public CommonResult<Boolean> doFlowComplete(@Valid @RequestBody TerminationCorrectFlowDTO reqDTO) throws Exception {
        terminationCorrectFlowService.doFlowComplete(reqDTO);
        return success(true);
    }


}
