package com.correction.backend.modules.handleCorrection.controller;

import com.correction.backend.modules.handleCorrection.controller.dto.*;
import com.correction.backend.modules.handleCorrection.convert.MCorrectionGroupConvert;
import com.correction.backend.modules.handleCorrection.convert.MCorrectionUserConvert;
import com.correction.backend.modules.handleCorrection.entity.CorrectionGroup;
import com.correction.backend.modules.handleCorrection.entity.CorrectionUser;
import com.correction.backend.modules.handleCorrection.service.CorrectionGroupService;
import com.correction.backend.modules.handleCorrection.service.CorrectionUserService;
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

@Api(tags = "入矫申请-矫正小组相关接口")
@RestController
@RequestMapping("/correctionGroup")
@Validated
public class CorrectionGroupController {


    @Resource
    private CorrectionGroupService correctionGroupService;

    @PostMapping("/create")
    @ApiOperation("新增矫正小组")
    public CommonResult<CorrectionGroup> createCorrectionGroup(@Valid @RequestBody CorrectionGroupCreateInputDTO reqDTO) {
        CorrectionGroup correctionGroup = correctionGroupService.createCorrectionGroup(reqDTO);
        return success(correctionGroup);
    }

    @PostMapping("/batchCreate")
    @ApiOperation("批量保存矫正小组数据")
    public CommonResult<List<Long>> batchCreate(@Valid @RequestBody List<CorrectionGroupUpdateInputDTO> reqDTO) {
        List<Long> idList =  correctionGroupService.batchCreate(reqDTO);
        return success(idList);
    }



    @PostMapping("/update")
    @ApiOperation("修改矫正小组")
    public CommonResult<CorrectionGroup> updateCorrectionUser(@Valid @RequestBody CorrectionGroupUpdateInputDTO reqDTO) {
        CorrectionGroup correctionGroup = correctionGroupService.updateCorrectionGroup(reqDTO);
        return success(correctionGroup);
    }

    @PostMapping("delete")
    @ApiOperation("删除档案")
    public CommonResult<Boolean> delete(@Valid @RequestParam Long id) {
        correctionGroupService.delete(id);
        return success(true);
    }


    @GetMapping("/get")
    @ApiOperation("获取小组详情信息")
    @ApiImplicitParam(name = "id", value = "id", required = true, example = "1024", dataTypeClass = Long.class)
    public CommonResult<CorrectionGroupListOutputDTO> getInfo(@RequestParam("id") Long id) {
        return success(MCorrectionGroupConvert.INSTANCE.toList(correctionGroupService.get(id)));
    }

    @GetMapping("/getByCorrectionId")
    @ApiOperation("根据矫正id获取矫正小组数据")
    @ApiImplicitParam(name = "id", value = "id", required = true, example = "1024", dataTypeClass = Long.class)
    public CommonResult<List<CorrectionGroupListOutputDTO>> getByCorrectionId(@RequestParam("id") Long id) {
        return success(MCorrectionGroupConvert.INSTANCE.toList(correctionGroupService.getByCorrectionId(id)));
    }

    @GetMapping("/page")
    @ApiOperation("获取所有矫正档案列表(分页)")
    public CommonResult<PageResult<CorrectionGroupListOutputDTO>> getPageList(@Valid CorrectionGroupSearchInputDTO reqVO) {
        PageResult<CorrectionGroup> pageList = correctionGroupService.getPageList(reqVO);
        List<CorrectionGroupListOutputDTO> list = new ArrayList<>();
        for (CorrectionGroup correctionGroup : pageList.getList()) {
            list.add(MCorrectionGroupConvert.INSTANCE.toList(correctionGroup));
        }
        return success(new PageResult<CorrectionGroupListOutputDTO>(list, pageList.getTotal()));
    }

    @GetMapping("/getList")
    @ApiOperation("获取所有矫正档案列表(不分页)")
    public CommonResult<List<CorrectionGroupListOutputDTO>> getList(@Valid CorrectionGroupSearchDTO reqVO) {
        List<CorrectionGroup> list = correctionGroupService.getList(reqVO);
        return success(MCorrectionGroupConvert.INSTANCE.toList(list));
    }


}
