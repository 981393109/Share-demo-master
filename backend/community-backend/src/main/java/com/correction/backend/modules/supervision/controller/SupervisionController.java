package com.correction.backend.modules.supervision.controller;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.correction.backend.modules.handleCorrection.controller.dto.*;
import com.correction.backend.modules.handleCorrection.entity.HandleCorrection;
import com.correction.backend.modules.supervision.controller.dto.*;
import com.correction.backend.modules.supervision.convert.MSupervisionDailyReportConvert;
import com.correction.backend.modules.supervision.entity.SupervisionDailyReport;
import com.correction.backend.modules.supervision.service.SupervisionDailyReportService;
import com.correction.backend.modules.survey.controller.dto.SurveyDocumentsFilesDTO;
import com.correction.backend.modules.survey.controller.dto.SurveyDocumentsFilesQuery;
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
import java.util.List;

import static com.correction.framework.common.pojo.CommonResult.success;

/**
 * 日常报到相关接口
 */

@Api(tags = "监督-日常报到相关接口")
@RestController
@RequestMapping("/supervisionDaily")
@Validated
public class SupervisionController {

    @Resource
    private SupervisionDailyReportService supervisionDailyReportService;

    @Resource
    private SurveyDocumentsFilesService surveyDocumentsFilesService;

    @PostMapping("/create")
    @ApiOperation("新增日常报到")
    public CommonResult<Boolean> createSupervisionDailyReport(@Valid @RequestBody SupervisionDailyReportUserDTO reqDTO) {
        supervisionDailyReportService.createSupervisionDailyReport(reqDTO);
        return success(true);
    }

    @PostMapping("/update")
    @ApiOperation("修改日常报到")
    public CommonResult<Boolean> updateHandleCorrection(@Valid @RequestBody SupervisionDailyReportUpdateInputDTO reqDTO) {
        supervisionDailyReportService.updateSupervisionDailyReport(reqDTO);
        return success(true);
    }

    @PostMapping("delete")
    @ApiOperation("删除")
    public CommonResult<Boolean> delete(@Valid @RequestParam Long id) {
        supervisionDailyReportService.delete(id);
        return success(true);
    }


    @GetMapping("/get")
    @ApiOperation("获取详情")
    @ApiImplicitParam(name = "id", value = "id", required = true, example = "1024", dataTypeClass = Long.class)
    public CommonResult<SupervisionDailyReportListOutputDTO> getInfo(@RequestParam("id") Long id) {
        SupervisionDailyReport detail = supervisionDailyReportService.getDetail(id);
        return success(MSupervisionDailyReportConvert.INSTANCE.toList(detail));
    }

    @GetMapping("/page")
    @ApiOperation("分页获取所有列表记录")
    public CommonResult<PageResult<SupervisionDailyReportListOutputDTO>> getPageList(@Valid SupervisionDailyReportSearchInputDTO reqVO) {
        PageResult<SupervisionDailyReport> pageList = supervisionDailyReportService.getPageList(reqVO);
        List<SupervisionDailyReport> list = pageList.getList();
        List<SupervisionDailyReportListOutputDTO> supervisionDailyReportListOutputDTOS = MSupervisionDailyReportConvert.INSTANCE.toList(list);
        return success(new PageResult<SupervisionDailyReportListOutputDTO>(supervisionDailyReportListOutputDTOS, pageList.getTotal()));
    }


    /*@GetMapping("/supervisionDocFilePage")
    @ApiOperation("获取所有文书附件")
    public CommonResult<PageResult<SurveyDocumentsFilesDTO>> supervisionDocFilePage(@Valid SurveyDocumentsFilesQuery reqVO) {
        // 获得用户分页列表
        reqVO.setDictTypeList(Arrays.asList(201,202,203,204));
        PageResult<SurveyDocumentsFilesDTO> pageResult = surveyDocumentsFilesService.surveyDocFilePage(reqVO);
        if (CollUtil.isEmpty(pageResult.getList())) {
            return success(new PageResult<>(pageResult.getTotal())); // 返回空
        }
        return success(pageResult);
    }*/


}
