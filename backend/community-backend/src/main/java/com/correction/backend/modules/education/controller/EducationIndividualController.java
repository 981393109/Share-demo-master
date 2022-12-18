package com.correction.backend.modules.education.controller;


import com.correction.backend.modules.education.controller.dto.*;
import com.correction.backend.modules.education.convert.MEducationIndividualConvert;
import com.correction.backend.modules.education.convert.MEducationSupportConvert;
import com.correction.backend.modules.education.entity.EducationIndividual;
import com.correction.backend.modules.education.entity.EducationSupport;
import com.correction.backend.modules.education.service.EducationIndividualService;
import com.correction.framework.common.pojo.CommonResult;
import com.correction.framework.common.pojo.PageResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

import static com.correction.framework.common.pojo.CommonResult.success;

@Api(tags = "教育-个别教育相关接口")
@RestController
@RequestMapping("/educationIndividual")
@Validated
public class EducationIndividualController {

    @Resource
    EducationIndividualService educationIndividualService;

    @PostMapping("/create")
    @ApiOperation("新增")
    public CommonResult<Boolean> createEducationIndividua(@Valid @RequestBody EducationIndividualCreateInputDTO reqDTO) {
        educationIndividualService.createEducationIndividua(reqDTO);
        return success(true);
    }

    @PostMapping("/update")
    @ApiOperation("修改")
    public CommonResult<Boolean> updateEducationIndividua(@Valid @RequestBody EducationIndividualUpdateInputDTO reqDTO) {
        educationIndividualService.updateEducationIndividua(reqDTO);
        return success(true);
    }

    @PostMapping("delete")
    @ApiOperation("删除")
    public CommonResult<Boolean> delete(@Valid @RequestParam Long id) {
        educationIndividualService.delete(id);
        return success(true);
    }


    @GetMapping("/get")
    @ApiOperation("获取详情")
    @ApiImplicitParam(name = "id", value = "id", required = true, example = "1024", dataTypeClass = Long.class)
    public CommonResult<EducationIndividualListOutputDTO> getInfo(@RequestParam("id") Long id) {
        EducationIndividual detail = educationIndividualService.getDetail(id);
        return success(MEducationIndividualConvert.INSTANCE.toList(detail));
    }

    @GetMapping("/page")
    @ApiOperation("分页获取所有列表记录")
    public CommonResult<PageResult<EducationIndividualListOutputDTO>> getPageList(@Valid EducationIndividualSearchInputDTO reqVO) {
        PageResult<EducationIndividual> pageList = educationIndividualService.getPageList(reqVO);
        List<EducationIndividual> list = pageList.getList();
        List<EducationIndividualListOutputDTO> supervisionDailyReportListOutputDTOS = MEducationIndividualConvert.INSTANCE.toList(list);
        return success(new PageResult<EducationIndividualListOutputDTO>(supervisionDailyReportListOutputDTOS, pageList.getTotal()));
    }

    @GetMapping("/list")
    @ApiOperation("分页获取所有列表记录")
    public CommonResult<List<EducationIndividualListOutputDTO>> list(@Valid EducationIndividualUpdateInputDTO reqVO) {
        List<EducationIndividual> list = educationIndividualService.getList(reqVO);
        List<EducationIndividualListOutputDTO> supervisionDailyReportListOutputDTOS = MEducationIndividualConvert.INSTANCE.toList(list);
        return success(supervisionDailyReportListOutputDTOS);
    }



}
