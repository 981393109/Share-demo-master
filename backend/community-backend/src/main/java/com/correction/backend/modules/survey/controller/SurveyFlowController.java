package com.correction.backend.modules.survey.controller;

import com.correction.backend.modules.survey.controller.dto.SurveryCompaleFlowDTO;
import com.correction.backend.modules.survey.controller.dto.SurveryEvaluationFlowDTO;
import com.correction.backend.modules.survey.service.SurveyFlowService;
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

import java.util.List;

import static com.correction.framework.common.pojo.CommonResult.success;

/**
 * 调查评估流程相关接口
 */
@Api(tags = "调查评估-审批流程")
@RestController
@RequestMapping("/survey-flow")
@Validated
public class SurveyFlowController {

    @Resource
    private SurveyFlowService surveyFlowService;

    @PostMapping("/startFlow")
    @ApiOperation("保存并提交审批 保存提交")
    public CommonResult<ActProcessInstance> startFlow(@Valid @RequestBody SurveryEvaluationFlowDTO reqDTO) throws Exception {
        ActProcessInstance actProcessInstance = surveyFlowService.startSurveyFlow(reqDTO);
        return success(actProcessInstance);
    }

    @PostMapping("/doComplete")
    @ApiOperation("通过、拒绝、驳回操作")
    public CommonResult<Boolean> doComplete(@Valid @RequestBody FlowCompleteDTO reqDTO) throws Exception {
        surveyFlowService.doComplete(reqDTO);
        return success(true);
    }

    @PostMapping("/doFlowComplete")
    @ApiOperation("通过、拒绝、驳回操作,并保存结果")
    public CommonResult<Boolean> doFlowComplete(@Valid @RequestBody SurveryCompaleFlowDTO reqDTO) throws Exception {
        surveyFlowService.doFlowComplete(reqDTO);
        return success(true);
    }

}
