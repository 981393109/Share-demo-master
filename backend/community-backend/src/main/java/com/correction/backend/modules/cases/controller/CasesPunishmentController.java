package com.correction.backend.modules.cases.controller;


import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.correction.backend.modules.cases.controller.dto.*;
import com.correction.backend.modules.cases.entity.CasesPunishment;
import com.correction.backend.modules.cases.service.CasesPunishmentService;
import com.correction.backend.modules.handleCorrection.controller.dto.*;
import com.correction.backend.modules.handleCorrection.convert.MCorrectionGroupConvert;
import com.correction.backend.modules.handleCorrection.entity.CorrectionGroup;
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
 * <p>
 * 处罚案件 前端控制器
 * </p>
 *
 * @author yao
 * @since 2022-12-17
 */
@RestController
@RequestMapping("/cases-punishment")
@Api(tags = "奖罚-处罚案件相关接口")
@Validated
public class CasesPunishmentController {


    @Resource
    CasesPunishmentService casesPunishmentService;

    @Resource
    SurveyDocumentsFilesService surveyDocumentsFilesService;

    @PostMapping("/create")
    @ApiOperation("新增处罚案件")
    public CommonResult<CasesPunishment> createCorrectionGroup(@Valid @RequestBody CasesPunishmentCreateInputDTO reqDTO) {
        CasesPunishment casesPunishment = casesPunishmentService.createCasesPunishment(reqDTO);
        return success(casesPunishment);
    }

    @PostMapping("/update")
    @ApiOperation("修改处罚案件")
    public CommonResult<CasesPunishment> update(@Valid @RequestBody CasesPunishmentUpdateInputDTO reqDTO) {
        CasesPunishment casesPunishment = casesPunishmentService.updatePunishment(reqDTO);
        return success(casesPunishment);
    }

    @PostMapping("/delete")
    @ApiOperation("删除")
    public CommonResult<Boolean> delete(@Valid @RequestParam Long id) {
        casesPunishmentService.delete(id);
        return success(true);
    }


    @GetMapping("/getDetail")
    @ApiOperation("获取详情信息")
    @ApiImplicitParam(name = "id", value = "id", required = true, example = "1024", dataTypeClass = Long.class)
    public CommonResult<CasesPunishmentDetailDTO> getDetail(@RequestParam("id") Long id) {
        return success(casesPunishmentService.getDetail(id));
    }

    @GetMapping("/page")
    @ApiOperation("分页获取所有列表记录")
    public CommonResult<PageResult<CasesPunishmentPageListDTO>> getPageList(@Valid CasesPunishmentSearchInputDTO reqVO) {
        IPage<CasesPunishmentPageListDTO> pageList = casesPunishmentService.getPageList(reqVO);
        return success(new PageResult<CasesPunishmentPageListDTO>(pageList.getRecords(), pageList.getTotal()));
    }


    @GetMapping("/handleDocFilePage")
    @ApiOperation("获取所有文书附件")
    public CommonResult<PageResult<SurveyDocumentsFilesDTO>> handleDocFilePage(@Valid SurveyDocumentsFilesQuery reqVO) {
        // 获得用户分页列表
        reqVO.setDictTypeList(Arrays.asList(701,702,703,704,705,706,707,710,711,712,713,714,715));
        PageResult<SurveyDocumentsFilesDTO> pageResult = surveyDocumentsFilesService.surveyDocFilePage(reqVO);
        if (CollUtil.isEmpty(pageResult.getList())) {
            return success(new PageResult<>(pageResult.getTotal())); // 返回空
        }
        return success(pageResult);
    }


}
