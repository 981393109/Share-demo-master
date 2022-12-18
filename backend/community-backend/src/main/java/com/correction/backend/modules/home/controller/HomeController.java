package com.correction.backend.modules.home.controller;


import com.correction.backend.modules.flow.controller.dto.FlowNodeListDTO;
import com.correction.backend.modules.home.controller.dto.HomeReportDTO;
import com.correction.backend.modules.home.controller.dto.UserRunTaskDTO;
import com.correction.backend.modules.home.service.HomeService;
import com.correction.backend.modules.sys.controller.dto.notes.SysNotesCreateInputDTO;
import com.correction.backend.modules.sys.controller.dto.notes.SysNotesStatusUpdateDTO;
import com.correction.backend.modules.sys.entity.SysNotes;
import com.correction.framework.common.pojo.CommonResult;
import com.correction.framework.web.web.core.util.WebFrameworkUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

import static com.correction.framework.common.pojo.CommonResult.success;

@Api(tags = "首页-控制台相关接口")
@RestController
@RequestMapping("/home")
@Validated
public class HomeController {


    @Resource
    HomeService homeService;

    /**
     * 获取所有代办任务列表
     */
    @GetMapping("/getRunTaskList")
    @ApiOperation("获取用户所有代办任务列表")
    public CommonResult<List> getFlowNode() throws Exception {
        List<UserRunTaskDTO> userRunTask = homeService.getUserRunTask(WebFrameworkUtils.getLoginUserId());
        return success(userRunTask);
    }


    /**
     * 获取今日便签
     */
    @GetMapping("/getNotes")
    @ApiOperation("获取今日便签(不传默认为今日)")
    public CommonResult<List<SysNotes>> getNotes(@RequestParam("date")String date) throws Exception {
        List<SysNotes> userRunTask = homeService.getNotes(WebFrameworkUtils.getLoginUserId());
        return success(userRunTask);
    }

    /**
     * 新增便签
     */
    @PostMapping("/addNotes")
    @ApiOperation("新增便签")
    public CommonResult<SysNotes> createNotes (@RequestBody SysNotesCreateInputDTO createInputDTO) throws Exception {
        SysNotes sysNotes = homeService.createNotes(createInputDTO);
        return success(sysNotes);
    }

    /**
     * 更改便签状态
     */
    @PostMapping("/updateStatus")
    @ApiOperation("修改便签状态")
    public CommonResult<SysNotes> updateStatus (@RequestBody SysNotesStatusUpdateDTO updateDTO) throws Exception {
        SysNotes sysNotes = homeService.updateStatus(updateDTO);
        return success(sysNotes);
    }


    /**
     * 获取报表数据
     */
    @GetMapping("/getReports")
    @ApiOperation("获取报表数据")
    public CommonResult<HomeReportDTO> getReports() throws Exception {
        HomeReportDTO homeReportDTO = homeService.getReports();
        return success(homeReportDTO);
    }


}
