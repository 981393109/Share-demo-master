package com.correction.backend.modules.education.controller;

import com.correction.backend.modules.education.controller.dto.*;
import com.correction.backend.modules.education.convert.MEducationSupportConvert;
import com.correction.backend.modules.education.entity.EducationSupport;
import com.correction.backend.modules.education.service.EducationSupportService;
import com.correction.backend.modules.supervision.controller.dto.SupervisionDailyReportListOutputDTO;
import com.correction.backend.modules.supervision.controller.dto.SupervisionDailyReportSearchInputDTO;
import com.correction.backend.modules.supervision.controller.dto.SupervisionDailyReportUpdateInputDTO;
import com.correction.backend.modules.supervision.controller.dto.SupervisionDailyReportUserDTO;
import com.correction.backend.modules.supervision.convert.MSupervisionDailyReportConvert;
import com.correction.backend.modules.supervision.entity.SupervisionDailyReport;
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

@Api(tags = "教育-集中教育相关接口")
@RestController
@RequestMapping("/educationSupport")
@Validated
public class EducationSupportController {

    @Resource
    EducationSupportService educationSupportService;


    @PostMapping("/create")
    @ApiOperation("新增")
    public CommonResult<Boolean> createEducationSupport(@Valid @RequestBody EducationSupportUserDTO reqDTO) {
        educationSupportService.createEducationSupport(reqDTO);
        return success(true);
    }

    @PostMapping("/update")
    @ApiOperation("修改")
    public CommonResult<Boolean> updateHandleCorrection(@Valid @RequestBody EducationSupportUpdateInputDTO reqDTO) {
        educationSupportService.updateEducationSupport(reqDTO);
        return success(true);
    }

    @PostMapping("delete")
    @ApiOperation("删除")
    public CommonResult<Boolean> delete(@Valid @RequestParam Long id) {
        educationSupportService.delete(id);
        return success(true);
    }


    @GetMapping("/get")
    @ApiOperation("获取详情")
    @ApiImplicitParam(name = "id", value = "id", required = true, example = "1024", dataTypeClass = Long.class)
    public CommonResult<EducationSupportListOutputDTO> getInfo(@RequestParam("id") Long id) {
        EducationSupportListOutputDTO detail = educationSupportService.getDetail(id);
        return success(detail);
    }

    @GetMapping("/page")
    @ApiOperation("分页获取所有列表记录")
    public CommonResult<PageResult<EducationSupportListOutputDTO>> getPageList(@Valid EducationSupportSearchInputDTO reqVO) {
        PageResult<EducationSupport> pageList = educationSupportService.getPageList(reqVO);
        List<EducationSupport> list = pageList.getList();
        List<EducationSupportListOutputDTO> supervisionDailyReportListOutputDTOS = MEducationSupportConvert.INSTANCE.toList(list);
        return success(new PageResult<EducationSupportListOutputDTO>(supervisionDailyReportListOutputDTOS, pageList.getTotal()));
    }

    @GetMapping("/list")
    @ApiOperation("分页获取所有列表记录")
    public CommonResult<List<EducationSupportListOutputDTO>> list(@Valid EducationSupportInputDTO reqVO) {
        List<EducationSupport> list = educationSupportService.getList(reqVO);
        List<EducationSupportListOutputDTO> supervisionDailyReportListOutputDTOS = MEducationSupportConvert.INSTANCE.toList(list);
        return success(supervisionDailyReportListOutputDTOS);
    }

}
