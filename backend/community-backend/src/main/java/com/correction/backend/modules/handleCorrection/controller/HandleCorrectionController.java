package com.correction.backend.modules.handleCorrection.controller;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.correction.backend.modules.handleCorrection.controller.dto.*;
import com.correction.backend.modules.handleCorrection.entity.HandleCorrection;
import com.correction.backend.modules.handleCorrection.service.HandleCorrectionService;
import com.correction.backend.modules.survey.controller.dto.*;
import com.correction.backend.modules.survey.entity.SurveyEvaluation;
import com.correction.backend.modules.survey.service.SurveyDocumentsFilesService;
import com.correction.framework.common.pojo.CommonResult;
import com.correction.framework.common.pojo.PageResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

import java.util.Arrays;

import static com.correction.framework.common.pojo.CommonResult.success;


@Api(tags = "入矫申请-入矫申请相关接口")
@RestController
@RequestMapping("/handleCorrection")
@Validated
public class HandleCorrectionController {

    @Resource
    private HandleCorrectionService handleCorrectionService;

    @Resource
    private SurveyDocumentsFilesService surveyDocumentsFilesService;


    @PostMapping("/create")
    @ApiOperation("新增办理入矫")
    public CommonResult<HandleCorrection> createHandleCorrection(@Valid @RequestBody HandleCorrectionCreateInputDTO reqDTO) {
        HandleCorrection handleCorrection = handleCorrectionService.createHandleCorrection(reqDTO);
        return success(handleCorrection);
    }

    @PostMapping("/update")
    @ApiOperation("修改入矫")
    public CommonResult<Boolean> updateHandleCorrection(@Valid @RequestBody HandleCorrectionUpdateInputDTO reqDTO) {
        handleCorrectionService.updateHandleCorrection(reqDTO);
        return success(true);
    }

    @PostMapping("delete")
    @ApiOperation("删除入矫")
    public CommonResult<Boolean> delete(@Valid @RequestParam Long id) {
        handleCorrectionService.delete(id);
        return success(true);
    }


    @GetMapping("/get")
    @ApiOperation("获取入矫申请详情")
    @ApiImplicitParam(name = "id", value = "id", required = true, example = "1024", dataTypeClass = Long.class)
    public CommonResult<HandleCorrectionFilesDTO> getInfo(@RequestParam("id") Long id) {
        return success(handleCorrectionService.getDetail(id));
    }

    @GetMapping("/page")
    @ApiOperation("获取所有调查评估列表记录")
    public CommonResult<PageResult<HandleCorrectionListDTO>> getPageList(@Valid HandleCorrectionSearchInputDTO reqVO) {
        IPage<HandleCorrectionListDTO> pageList = handleCorrectionService.getPageList(reqVO);
        return success(new PageResult<HandleCorrectionListDTO>(pageList.getRecords(), pageList.getTotal()));
    }


    @GetMapping("/handleDocFilePage")
    @ApiOperation("获取所有文书附件")
    public CommonResult<PageResult<SurveyDocumentsFilesDTO>> handleDocFilePage(@Valid SurveyDocumentsFilesQuery reqVO) {
        // 获得用户分页列表
        reqVO.setDictTypeList(Arrays.asList(5,6,7,8,9,10));
        PageResult<SurveyDocumentsFilesDTO> pageResult = surveyDocumentsFilesService.surveyDocFilePage(reqVO);
        if (CollUtil.isEmpty(pageResult.getList())) {
            return success(new PageResult<>(pageResult.getTotal())); // 返回空
        }
        return success(pageResult);
    }


}
