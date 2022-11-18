package com.correction.backend.modules.survey.controller;

import cn.hutool.core.collection.CollUtil;
import com.correction.backend.modules.survey.controller.dto.*;
import com.correction.backend.modules.survey.convert.MSurveyEvaluationConvert;
import com.correction.backend.modules.survey.entity.SurveyEvaluation;
import com.correction.backend.modules.survey.service.SurveyEvaluationService;
import com.correction.framework.common.pojo.CommonResult;
import com.correction.framework.common.pojo.PageResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

import java.util.ArrayList;
import java.util.List;

import static com.correction.framework.common.pojo.CommonResult.success;

@Api(tags = "调查评估-调查评估相关接口")
@RestController
@RequestMapping("/survey")
@Validated
public class SurveyEvaluationController {

    @Resource
    SurveyEvaluationService surveyEvaluationService;

    @PostMapping("/create")
    @ApiOperation("新增调查评估")
    public CommonResult<Long> createSurveyEvaluation(@Valid @RequestBody SurveyEvaluationCreateInputDTO reqDTO) {
        Long id = surveyEvaluationService.createSurveyEvaluation(reqDTO);
        return success(id);
    }

    @PostMapping("/update")
    @ApiOperation("修改调查评估")
    public CommonResult<Boolean> updateSurveyEvaluation(@Valid @RequestBody SurveyEvaluationUpdateInputDTO reqDTO) {
        surveyEvaluationService.updateSurveyEvaluation(reqDTO);
        return success(true);
    }

    @PostMapping("delete")
    @ApiOperation("删除调查评估")
    public CommonResult<Boolean> delete(@Valid @RequestParam Long id) {
        surveyEvaluationService.delete(id);
        return success(true);
    }


    @GetMapping("/get")
    @ApiOperation("获取调查评估详情")
    @ApiImplicitParam(name = "id", value = "id", required = true, example = "1024", dataTypeClass = Long.class)
    public CommonResult<SurveyEvaluationFilesDTO> getInfo(@RequestParam("id") Long id) {
        return success(surveyEvaluationService.get(id));
    }

    @GetMapping("/page")
    @ApiOperation("获取所有调查评估列表记录")
    public CommonResult<PageResult<SurveyEvaluationListDTO>> getUserPage(@Valid SurveyEvaluationSearchInputDTO reqVO) {
        // 获得用户分页列表
        PageResult<SurveyEvaluation> pageResult = surveyEvaluationService.getPageList(reqVO);
        if (CollUtil.isEmpty(pageResult.getList())) {
            return success(new PageResult<>(pageResult.getTotal())); // 返回空
        }
        // 拼接结果返回
        List<SurveyEvaluationListDTO> surveyEvaluationListOutputDTOS = new ArrayList<>(pageResult.getList().size());
        pageResult.getList().forEach(surveyEvaluation -> {
            SurveyEvaluationListDTO surveyEvaluationListDTO = MSurveyEvaluationConvert.INSTANCE.toEsyList(surveyEvaluation);
            surveyEvaluationListOutputDTOS.add(surveyEvaluationListDTO);
        });
        return success(new PageResult<>(surveyEvaluationListOutputDTOS, pageResult.getTotal()));
    }




}
