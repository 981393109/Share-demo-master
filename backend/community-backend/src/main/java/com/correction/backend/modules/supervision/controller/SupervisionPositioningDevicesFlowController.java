package com.correction.backend.modules.supervision.controller;

import com.correction.backend.modules.supervision.controller.dto.SupervisionFlowDTO;
import com.correction.backend.modules.supervision.controller.dto.SupervisionPositioningFlowDTO;
import com.correction.backend.modules.supervision.controller.dto.SupervisionPositioningStartFlowDTO;
import com.correction.backend.modules.supervision.controller.dto.SupervisionStartFlowDTO;
import com.correction.backend.modules.supervision.service.SupervisionPositioningFlowService;
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

@Api(tags = "监督-使用电子定位装置审批流相关接口")
@RestController
@RequestMapping("/supervisionPositioningDevicesFlow")
@Validated
public class SupervisionPositioningDevicesFlowController {

    @Resource
    SupervisionPositioningFlowService supervisionPositioningFlowService;

    @PostMapping("/startFlow")
    @ApiOperation("提交审批")
    public CommonResult<ActProcessInstance> startFlow(@Valid @RequestBody SupervisionPositioningStartFlowDTO reqDTO) throws Exception {
        ActProcessInstance actProcessInstance = supervisionPositioningFlowService.startFlow(reqDTO);
        return success(actProcessInstance);
    }


    @PostMapping("/doFlowComplete")
    @ApiOperation("通过、拒绝、驳回操作,并保存结果")
    public CommonResult<Boolean> doFlowComplete(@Valid @RequestBody SupervisionPositioningFlowDTO reqDTO) throws Exception {
        supervisionPositioningFlowService.doFlowComplete(reqDTO);
        return success(true);
    }





}
