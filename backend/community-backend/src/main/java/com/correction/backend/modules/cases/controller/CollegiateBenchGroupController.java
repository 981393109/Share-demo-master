package com.correction.backend.modules.cases.controller;


import com.correction.backend.modules.cases.controller.dto.*;
import com.correction.backend.modules.cases.convert.MCollegiateBenchGroupConvert;
import com.correction.backend.modules.cases.entity.CasesPunishment;
import com.correction.backend.modules.cases.entity.CollegiateBenchGroup;
import com.correction.backend.modules.cases.service.CollegiateBenchGroupService;
import com.correction.framework.common.pojo.CommonResult;
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
 * 合议小组/评议小组/相关小组表 前端控制器
 * </p>
 *
 * @author yao
 * @since 2022-12-17
 */
@RestController
@RequestMapping("/collegiate-bench-group")
@Api(tags = "奖罚-组织小组相关接口")
@Validated
public class CollegiateBenchGroupController {


    @Resource
    CollegiateBenchGroupService collegiateBenchGroupService;


    @PostMapping("/create")
    @ApiOperation("新增 (需传入dataId 以及对应的type)")
    public CommonResult<CollegiateBenchGroup> createCollegiateBenchGroup(@Valid @RequestBody CollegiateBenchGroupCreateInputDTO reqDTO) {
        CollegiateBenchGroup casesPunishment = collegiateBenchGroupService.createCollegiateBenchGroup(reqDTO);
        return success(casesPunishment);
    }

    @PostMapping("/update")
    @ApiOperation("修改")
    public CommonResult<CollegiateBenchGroup> updateCollegiateBenchGroup(@Valid @RequestBody CollegiateBenchGroupUpdateInputDTO reqDTO) {
        CollegiateBenchGroup casesPunishment = collegiateBenchGroupService.updateCollegiateBenchGroup(reqDTO);
        return success(casesPunishment);
    }

    @PostMapping("/delete")
    @ApiOperation("删除")
    public CommonResult<Boolean> delete(@Valid @RequestParam Long id) {
        collegiateBenchGroupService.delete(id);
        return success(true);
    }


    @GetMapping("/getDetail")
    @ApiOperation("获取详情信息")
    @ApiImplicitParam(name = "id", value = "id", required = true, example = "1024", dataTypeClass = Long.class)
    public CommonResult<CollegiateBenchGroupListOutputDTO> getDetail(@RequestParam("id") Long id) {
        return success(MCollegiateBenchGroupConvert.INSTANCE.toList(collegiateBenchGroupService.getDetail(id)));
    }

    @GetMapping("getList")
    @ApiOperation("获取列表")
    public CommonResult<List<CollegiateBenchGroupListOutputDTO>> getDetail(@RequestParam("dataId") Long dataId, @RequestParam("type") Integer type) {
        return success(MCollegiateBenchGroupConvert.INSTANCE.toList(collegiateBenchGroupService.getList(dataId,type)));
    }


}
