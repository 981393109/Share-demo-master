package com.correction.backend.modules.handleCorrection.controller;

import com.correction.backend.modules.handleCorrection.controller.dto.*;
import com.correction.backend.modules.handleCorrection.convert.MCorrectionGroupConvert;
import com.correction.backend.modules.handleCorrection.convert.MCorrectionWaysConvert;
import com.correction.backend.modules.handleCorrection.entity.CorrectionGroup;
import com.correction.backend.modules.handleCorrection.entity.CorrectionWays;
import com.correction.backend.modules.handleCorrection.service.CorrectionGroupService;
import com.correction.backend.modules.handleCorrection.service.CorrectionWaysService;
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

@Api(tags = "入矫申请-矫正方案相关接口")
@RestController
@RequestMapping("/correctionWays")
@Validated
public class CorrectionWaysController {

    @Resource
    private CorrectionWaysService correctionWaysService;

    @PostMapping("/create")
    @ApiOperation("新增矫正方案")
    public CommonResult<CorrectionWays> createCorrectionWays(@Valid @RequestBody CorrectionWaysCreateInputDTO reqDTO) {
        CorrectionWays correctionWays = correctionWaysService.createCorrectionWays(reqDTO);
        return success(correctionWays);
    }

    @PostMapping("/createAndGroup")
    @ApiOperation("保存方案以及矫正小组")
    public CommonResult<CorrectionWaysGroupOutDTO> createAndGroup(@Valid @RequestBody CorrectionWaysAndGroupCreate reqDTO) {
        CorrectionWaysGroupOutDTO andGroup = correctionWaysService.createAndGroup(reqDTO);
        return success(andGroup);
    }

    @PostMapping("/update")
    @ApiOperation("修改矫正方案")
    public CommonResult<CorrectionWays> updateCorrectionWays(@Valid @RequestBody CorrectionWaysUpdateInputDTO reqDTO) {
        CorrectionWays correctionWays = correctionWaysService.updateCorrectionWays(reqDTO);
        return success(correctionWays);
    }

    @PostMapping("delete")
    @ApiOperation("删除")
    public CommonResult<Boolean> delete(@Valid @RequestParam Long id) {
        correctionWaysService.delete(id);
        return success(true);
    }


    @GetMapping("/get")
    @ApiOperation("获取方案详情信息")
    @ApiImplicitParam(name = "id", value = "id", required = true, example = "1024", dataTypeClass = Long.class)
    public CommonResult<CorrectionWaysListOutputDTO> getInfo(@RequestParam("id") Long id) {
        return success(MCorrectionWaysConvert.INSTANCE.toList(correctionWaysService.get(id)));
    }

    @GetMapping("/getByCorrectionId")
    @ApiOperation("根据矫正id获取矫正小组数据")
    @ApiImplicitParam(name = "id", value = "id", required = true, example = "1024", dataTypeClass = Long.class)
    public CommonResult<CorrectionWaysListOutputDTO> getByCorrectionId(@RequestParam("id") Long id) {
        return success(MCorrectionWaysConvert.INSTANCE.toList(correctionWaysService.getByCorrectionId(id)));
    }

    @GetMapping("/page")
    @ApiOperation("获取所有矫正档案列表(分页)")
    public CommonResult<PageResult<CorrectionWaysListOutputDTO>> getPageList(@Valid CorrectionWaysSearchInputDTO reqVO) {
        PageResult<CorrectionWays> pageList = correctionWaysService.getPageList(reqVO);
        List<CorrectionWaysListOutputDTO> list = new ArrayList<>();
        for (CorrectionWays correctionWays : pageList.getList()) {
            list.add(MCorrectionWaysConvert.INSTANCE.toList(correctionWays));
        }
        return success(new PageResult<CorrectionWaysListOutputDTO>(list, pageList.getTotal()));
    }

    @GetMapping("/getList")
    @ApiOperation("获取所有矫正档案列表(不分页)")
    public CommonResult<List<CorrectionWaysListOutputDTO>> getList(@Valid CorrectionWaysSearchDTO reqVO) {
        List<CorrectionWays> list = correctionWaysService.getList(reqVO);
        return success(MCorrectionWaysConvert.INSTANCE.toList(list));
    }



}
