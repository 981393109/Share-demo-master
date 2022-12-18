package com.correction.backend.modules.cases.controller;


import com.correction.backend.modules.cases.controller.dto.CasesPunishmentFlowCreateDTO;
import com.correction.backend.modules.cases.controller.dto.CasesPunishmentFlowDTO;
import com.correction.backend.modules.cases.service.CasesPunishmentFlowService;
import com.correction.backend.modules.handleCorrection.controller.dto.HandleCorrectionFlowDTO;
import com.correction.backend.modules.handleCorrection.controller.dto.HandleCorrectionFlowListDTO;
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
@RequestMapping("/cases-punishment-flow")
@Api(tags = "奖罚-处罚案件流程相关接口")
@Validated
public class CasesPunishmentFlowController {


    @Resource
    CasesPunishmentFlowService casesPunishmentFlowService;


    @PostMapping("/startFlowFirst")
    @ApiOperation("发起立案决定流程")
    public CommonResult<ActProcessInstance> startFlowFirst(@Valid @RequestBody CasesPunishmentFlowCreateDTO reqDTO) throws Exception {
        ActProcessInstance actProcessInstance = casesPunishmentFlowService.startFlowFirst(reqDTO);
        return success(actProcessInstance);
    }

    @PostMapping("/doFlowCompleteFirst")
    @ApiOperation("通过、拒绝、驳回操作,并保存结果(立案决定流程)")
    public CommonResult<Boolean> doFlowCompleteFirst(@Valid @RequestBody CasesPunishmentFlowDTO reqDTO) throws Exception {
        casesPunishmentFlowService.doFlowCompleteFirst(reqDTO);
        return success(true);
    }

    @PostMapping("/startFlow")
    @ApiOperation("发起流程（需传入第一个流程的taskId）")
    public CommonResult<ActProcessInstance> startFlow(@Valid @RequestBody CasesPunishmentFlowCreateDTO reqDTO) throws Exception {
        ActProcessInstance actProcessInstance = casesPunishmentFlowService.startFlow(reqDTO);
        return success(actProcessInstance);
    }

    @PostMapping("/doFlowComplete")
    @ApiOperation("通过、拒绝、驳回操作,并保存结果(第二个流程)")
    public CommonResult<Boolean> doFlowComplete(@Valid @RequestBody CasesPunishmentFlowDTO reqDTO) throws Exception {
        casesPunishmentFlowService.doFlowComplete(reqDTO);
        return success(true);
    }



}
