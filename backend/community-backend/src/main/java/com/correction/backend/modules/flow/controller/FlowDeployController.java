package com.correction.backend.modules.flow.controller;

import com.correction.backend.modules.flow.controller.dto.FlowCenterDTO;
import com.correction.backend.modules.flow.service.FlowDeloyService;
import com.correction.backend.modules.flow.service.FlowUserService;
import com.correction.backend.modules.survey.controller.dto.SurveyEvaluationCreateInputDTO;
import com.correction.backend.modules.survey.entity.SurveyEvaluation;
import com.correction.framework.common.pojo.CommonResult;
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

/**
 * 审批流程，
 */

@Api(tags = "审批-流程部署相关接口")
@RestController
@RequestMapping("/flow-deploy")
@Validated
public class FlowDeployController {

    @Resource
    private FlowDeloyService flowDeloyService;

    @PostMapping("/deploy")
    @ApiOperation("部署流程")
    public CommonResult<Boolean> createSurveyEvaluation(@Valid @RequestBody FlowCenterDTO reqDTO) throws Exception {
        flowDeloyService.saveFlowCenter(reqDTO);
        return success(true);
    }


}
