package com.correction.backend.modules.zhjiao.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.correction.backend.modules.cases.controller.dto.CasesPunishmentPageListDTO;
import com.correction.backend.modules.cases.controller.dto.CasesPunishmentSearchInputDTO;
import com.correction.backend.modules.zhjiao.dto.*;
import com.correction.backend.modules.zhjiao.service.AssmberService;
import com.correction.framework.common.pojo.CommonResult;
import com.correction.framework.common.pojo.PageResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

import java.util.List;

import static com.correction.framework.common.pojo.CommonResult.success;

@RestController
@RequestMapping("/zhihuijiao")
@Api(tags = "智慧矫-智慧矫相关接口")
@Validated
public class AssmberController {

    @Resource
    AssmberService assmberService;

    @PostMapping("/getPsychologicalAssmber")
    @ApiOperation("获取心理评估列表")
    public CommonResult<PageResult<JSONObject>> getPsychologicalAssmber(@Valid PsychologicalQueryDTO reqVO) throws Exception {
        PageResult<JSONObject> pageList = assmberService.getPsychologicalAssmber(reqVO);
        return success(pageList);
    }


    @PostMapping("/getPositioningPersonnel")
    @ApiOperation("获取人员定位列表")
    public CommonResult<JSONObject> getPositioningPersonnel(@Valid PositioningPersonnelQueryDTO reqVO) throws Exception {
        JSONObject list = assmberService.getPositioningPersonnel(reqVO);
        return success(list);
    }

    @PostMapping("/getElectronicFence")
    @ApiOperation("获取电子围栏列表")
    public CommonResult<PageResult<JSONObject>> getElectronicFence(@Valid ElectronicFenceQueryDTO reqVO) throws Exception {
        PageResult<JSONObject> pageList = assmberService.getElectronicFence(reqVO);
        return success(pageList);
    }

    @PostMapping("/getSignRecord")
    @ApiOperation("获取签到列表")
    public CommonResult<PageResult<JSONObject>> getSignRecord(@Valid SignRecordDTO reqVO) throws Exception {
        PageResult<JSONObject> pageList = assmberService.getSignRecord(reqVO);
        return success(pageList);
    }

    @PostMapping("/getViolationAlert")
    @ApiOperation("获取违规提醒列表")
    public CommonResult<PageResult<JSONObject>> getViolationAlert(@Valid ViolationAlertQueryDTO reqVO) throws Exception {
        PageResult<JSONObject> pageList = assmberService.getViolationAlert(reqVO);
        return success(pageList);
    }

    @GetMapping("/getPositioningUserDetail")
    @ApiOperation("获取动态定位人员详情信息")
    public CommonResult<JSONObject> getPositioningUserDetail(@Valid @RequestParam("apperId") Long apperId) throws Exception {
        JSONObject result = assmberService.getPositioningUserDetail(apperId);
        return success(result);
    }


    @GetMapping("/listStreetByPerson")
    @ApiOperation("获取动态定位街道列表")
    public CommonResult<List<JSONObject>> listStreetByPerson() throws Exception {
        List<JSONObject> result = assmberService.listStreetByPerson();
        return success(result);
    }

    @GetMapping("/getToken")
    @ApiOperation("获取Token")
    public CommonResult<JSONObject> getToken() throws Exception {
        JSONObject result = assmberService.getToken();
        return success(result);
    }


    @PostMapping("/listApper")
    @ApiOperation("获取视频抽查用户列表")
    public CommonResult<PageResult<JSONObject>> listApper(@Valid VideoUserDTO reqVO) throws Exception {
        PageResult<JSONObject> pageList = assmberService.listApper(reqVO);
        return success(pageList);
    }


    @PostMapping("/getElectronicFenceUserList")
    @ApiOperation("电子围栏-人员列表详情")
    public CommonResult<List<JSONObject>> getElectronicFenceUserList(@Valid ElectronicFenceUserQueryDTO reqVO) throws Exception {
        List<JSONObject> result = assmberService.getElectronicFenceUserList(reqVO);
        return success(result);
    }

    @PostMapping("/getPsychologicalAssmberReport")
    @ApiOperation("心理评估-查看报告")
    public CommonResult<JSONObject> getPsychologicalAssmberReport(@Valid PsychologicalAssmberReportQueryDTO reqVO) throws Exception {
        JSONObject result = assmberService.getPsychologicalAssmberReport(reqVO);
        return success(result);
    }






}
