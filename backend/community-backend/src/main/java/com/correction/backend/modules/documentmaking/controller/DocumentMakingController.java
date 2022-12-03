package com.correction.backend.modules.documentmaking.controller;

import com.correction.backend.modules.documentmaking.controller.dto.DocumentMakingDTO;
import com.correction.backend.modules.documentmaking.entity.DocumentMakeing;
import com.correction.backend.modules.documentmaking.service.DocumentMakeingService;
import com.correction.backend.modules.handleCorrection.controller.dto.HandleCorrectionFlowListDTO;
import com.correction.framework.common.pojo.CommonResult;
import com.correction.framework.workflow.factory.ActProcessInstance;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

import static com.correction.framework.common.pojo.CommonResult.success;


@Api(tags = "制作文书-制作文书相关接口")
@RestController
@RequestMapping("/documentMaking")
@Validated
public class DocumentMakingController {

    @Resource
    private DocumentMakeingService documentMakeingService;


    @PostMapping("/doMaking")
    @ApiOperation("制作文书(传入dataId 以及dataType)")
    public CommonResult<String> doMaking(@Valid @RequestBody DocumentMakingDTO reqDTO) throws Exception {
        String filePath = documentMakeingService.makingDocFile(reqDTO);
        return success(filePath);
    }

    @GetMapping("/getMaking")
    @ApiOperation("获取文书信息(传入dataId 以及dataType)")
    public CommonResult<DocumentMakeing> getMaking(@Valid DocumentMakingDTO reqDTO) throws Exception {
        DocumentMakeing making = documentMakeingService.getMaking(reqDTO);
        return success(making);
    }


}
