package com.correction.backend.modules.education.controller;


import com.correction.backend.modules.education.controller.dto.*;
import com.correction.backend.modules.education.convert.MEducationIdeologyConvert;
import com.correction.backend.modules.education.convert.MEducationIndividualConvert;
import com.correction.backend.modules.education.entity.EducationIdeology;
import com.correction.backend.modules.education.entity.EducationIndividual;
import com.correction.backend.modules.education.service.EducationIdeologyService;
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

/**
 * <p>
 * 思想汇报 前端控制器
 * </p>
 *
 * @author yao
 * @since 2022-12-12
 */
@Api(tags = "教育-思想汇报相关接口")
@RestController
@RequestMapping("/education-ideology")
@Validated
public class EducationIdeologyController {


    @Resource
    EducationIdeologyService educationIdeologyService;

    @PostMapping("/create")
    @ApiOperation("新增")
    public CommonResult<Boolean> createEducationIdeology(@Valid @RequestBody EducationIdeologyCreateInputDTO reqDTO) {
        educationIdeologyService.createEducationIdeology(reqDTO);
        return success(true);
    }

    @PostMapping("/update")
    @ApiOperation("修改")
    public CommonResult<Boolean> updateEducationIdeology(@Valid @RequestBody EducationIdeologyUpdateInputDTO reqDTO) {
        educationIdeologyService.updateEducationIdeology(reqDTO);
        return success(true);
    }

    @PostMapping("delete")
    @ApiOperation("删除")
    public CommonResult<Boolean> delete(@Valid @RequestParam Long id) {
        educationIdeologyService.delete(id);
        return success(true);
    }


    @GetMapping("/get")
    @ApiOperation("获取详情")
    @ApiImplicitParam(name = "id", value = "id", required = true, example = "1024", dataTypeClass = Long.class)
    public CommonResult<EducationIdeologyFileDTO> getInfo(@RequestParam("id") Long id) {
        EducationIdeologyFileDTO detail = educationIdeologyService.getDetail(id);
        return success(detail);
    }

    @GetMapping("/page")
    @ApiOperation("分页获取所有列表记录")
    public CommonResult<PageResult<EducationIdeologyListOutputDTO>> getPageList(@Valid EducationIdeologySearchInputDTO reqVO) {
        PageResult<EducationIdeology> pageList = educationIdeologyService.getPageList(reqVO);
        List<EducationIdeology> list = pageList.getList();
        List<EducationIdeologyListOutputDTO> supervisionDailyReportListOutputDTOS = MEducationIdeologyConvert.INSTANCE.toList(list);
        return success(new PageResult<EducationIdeologyListOutputDTO>(supervisionDailyReportListOutputDTOS, pageList.getTotal()));
    }

    @GetMapping("/list")
    @ApiOperation("分页获取所有列表记录")
    public CommonResult<List<EducationIdeologyListOutputDTO>> list(@Valid EducationIdeologyListOutputDTO reqVO) {
        List<EducationIdeology> list = educationIdeologyService.getList(reqVO);
        List<EducationIdeologyListOutputDTO> supervisionDailyReportListOutputDTOS = MEducationIdeologyConvert.INSTANCE.toList(list);
        return success(supervisionDailyReportListOutputDTOS);
    }




}
