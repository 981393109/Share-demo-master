package com.correction.backend.modules.supervision.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.correction.backend.modules.supervision.controller.dto.*;
import com.correction.backend.modules.supervision.entity.SupervisionVisitField;
import com.correction.backend.modules.supervision.service.SupervisionVisitFieldService;
import com.correction.backend.modules.supervision.service.SupervisionVisitGroupService;
import com.correction.framework.common.pojo.CommonResult;
import com.correction.framework.common.pojo.PageResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

import static com.correction.framework.common.pojo.CommonResult.success;

@Api(tags = "监督-实地查访相关接口")
@RestController
@RequestMapping("/supervisonVisitField")
@Validated
public class SupervisonVisitFieldController {


    @Resource
    private SupervisionVisitFieldService supervisionVisitFieldService;


    @PostMapping("/create")
    @ApiOperation("新增日常报告")
    public CommonResult<Boolean> createSupervisionOutApproval(@Valid @RequestBody SupervisionVisitFieldCreateInputDTO reqDTO) {
        supervisionVisitFieldService.createSupervisionVisitField(reqDTO);
        return success(true);
    }

    @PostMapping("/update")
    @ApiOperation("修改外出申请")
    public CommonResult<Boolean> updateSupervisionOutApproval(@Valid @RequestBody SupervisionVisitFieldUpdateInputDTO reqDTO) {
        supervisionVisitFieldService.updateSupervisionVisitField(reqDTO);
        return success(true);
    }

    @PostMapping("delete")
    @ApiOperation("删除")
    public CommonResult<Boolean> delete(@Valid @RequestParam Long id) {
        supervisionVisitFieldService.delete(id);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获取详情")
    @ApiImplicitParam(name = "id", value = "id", required = true, example = "1024", dataTypeClass = Long.class)
    public CommonResult<SupervisionVisitFieldDTO> getInfo(@RequestParam("id") Long id) {
        SupervisionVisitFieldDTO detailDTO = supervisionVisitFieldService.getDetailDTO(id);
        return success(detailDTO);
    }

    @GetMapping("/page")
    @ApiOperation("分页获取所有列表记录")
    public CommonResult<PageResult<SupervisionVisitField>> getPageList(@Valid SupervisionVisitFieldSearchInputDTO reqVO) {
        PageResult<SupervisionVisitField> pageList = supervisionVisitFieldService.getPageList(reqVO);
        return success(pageList);
    }


}
