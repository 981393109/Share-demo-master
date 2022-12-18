package com.correction.backend.modules.termination.controller;


import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.correction.backend.modules.cases.controller.dto.*;
import com.correction.backend.modules.cases.entity.RewardRecord;
import com.correction.backend.modules.survey.controller.dto.SurveyDocumentsFilesDTO;
import com.correction.backend.modules.survey.controller.dto.SurveyDocumentsFilesQuery;
import com.correction.backend.modules.survey.service.SurveyDocumentsFilesService;
import com.correction.backend.modules.termination.controller.dto.*;
import com.correction.backend.modules.termination.entity.TerminationSolutions;
import com.correction.backend.modules.termination.service.TerminationSolutionsService;
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

/**
 * <p>
 * 期满解矫 前端控制器
 * </p>
 *
 * @author yao
 * @since 2022-12-18
 */
@RestController
@RequestMapping("/termination-solutions")
@Api(tags = "解除与终止-期满解矫相关接口")
@Validated
public class TerminationSolutionsController {


    @Resource
    TerminationSolutionsService terminationSolutionsService;

    @Resource
    SurveyDocumentsFilesService surveyDocumentsFilesService;

    @PostMapping("/create")
    @ApiOperation("新增")
    public CommonResult<TerminationSolutions> create(@Valid @RequestBody TerminationSolutionsCreateInputDTO reqDTO) {
        TerminationSolutions rewardRecord = terminationSolutionsService.create(reqDTO);
        return success(rewardRecord);
    }

    @PostMapping("/update")
    @ApiOperation("修改")
    public CommonResult<TerminationSolutions> update(@Valid @RequestBody TerminationSolutionsUpdateInputDTO reqDTO) {
        TerminationSolutions rewardRecord = terminationSolutionsService.update(reqDTO);
        return success(rewardRecord);
    }

    @PostMapping("/delete")
    @ApiOperation("删除")
    public CommonResult<Boolean> delete(@Valid @RequestParam Long id) {
        terminationSolutionsService.delete(id);
        return success(true);
    }


    @GetMapping("/getDetail")
    @ApiOperation("获取详情信息")
    @ApiImplicitParam(name = "id", value = "id", required = true, example = "1024", dataTypeClass = Long.class)
    public CommonResult<TerminationSolutionDetailDTO> getDetail(@RequestParam("id") Long id) {
        return success(terminationSolutionsService.getDetail(id));
    }

    @GetMapping("/page")
    @ApiOperation("分页获取所有列表记录")
    public CommonResult<PageResult<TerminationSolutionsPageListDTO>> getPageList(@Valid TerminationSolutionsSearchInputDTO reqVO) {
        IPage<TerminationSolutionsPageListDTO> pageList = terminationSolutionsService.getPageList(reqVO);
        return success(new PageResult<TerminationSolutionsPageListDTO>(pageList.getRecords(), pageList.getTotal()));
    }


    @GetMapping("/handleDocFilePage")
    @ApiOperation("获取所有文书附件")
    public CommonResult<PageResult<SurveyDocumentsFilesDTO>> handleDocFilePage(@Valid SurveyDocumentsFilesQuery reqVO) {
        // 获得用户分页列表
        reqVO.setDictTypeList(Arrays.asList(901,902));
        PageResult<SurveyDocumentsFilesDTO> pageResult = surveyDocumentsFilesService.surveyDocFilePage(reqVO);
        if (CollUtil.isEmpty(pageResult.getList())) {
            return success(new PageResult<>(pageResult.getTotal())); // 返回空
        }
        return success(pageResult);
    }



}
