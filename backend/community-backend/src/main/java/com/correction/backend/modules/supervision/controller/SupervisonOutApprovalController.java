package com.correction.backend.modules.supervision.controller;


import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.correction.backend.modules.supervision.controller.dto.*;
import com.correction.backend.modules.supervision.service.SupervisionOutApprovalService;
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
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.validation.Valid;

import java.util.Arrays;

import static com.correction.framework.common.pojo.CommonResult.success;

/**
 * 外出申请
 */
@Api(tags = "监督-外出申请相关接口")
@RestController
@RequestMapping("/supervisionOutApproval")
@Validated
public class SupervisonOutApprovalController {

    @Resource
    private SupervisionOutApprovalService supervisionOutApprovalService;

    @Resource
    private SurveyDocumentsFilesService surveyDocumentsFilesService;

    @PostMapping("/create")
    @ApiOperation("新增外出申请")
    public CommonResult<Boolean> createSupervisionOutApproval(@Valid @RequestBody SupervisionOutApprovalCreateInputDTO reqDTO) {
        supervisionOutApprovalService.createSupervisionOutApproval(reqDTO);
        return success(true);
    }

    @PostMapping("/update")
    @ApiOperation("修改外出申请")
    public CommonResult<Boolean> createSupervisionOutApproval(@Valid @RequestBody SupervisionOutApprovalUpdateInputDTO reqDTO) {
        supervisionOutApprovalService.updateSupervisionOutApproval(reqDTO);
        return success(true);
    }

    @PostMapping("delete")
    @ApiOperation("删除")
    public CommonResult<Boolean> delete(@Valid @RequestParam Long id) {
        supervisionOutApprovalService.delete(id);
        return success(true);
    }


    @GetMapping("/get")
    @ApiOperation("获取详情")
    @ApiImplicitParam(name = "id", value = "id", required = true, example = "1024", dataTypeClass = Long.class)
    public CommonResult<SupervisionOutApprovalDetailDTO> getInfo(@RequestParam("id") Long id) {
        SupervisionOutApprovalDetailDTO detail = supervisionOutApprovalService.getDetail(id);
        return success(detail);
    }

    @GetMapping("/page")
    @ApiOperation("分页获取所有列表记录")
    public CommonResult<PageResult<SupervisionOutApprovalList>> getPageList(@Valid SupervisionOutApprovalSearchInputDTO reqVO) {
        IPage<SupervisionOutApprovalList> pageList = supervisionOutApprovalService.getPageList(reqVO);
        return success(new PageResult<SupervisionOutApprovalList>(pageList.getRecords(), pageList.getTotal()));
    }


    @GetMapping("/supervisionDocFilePage")
    @ApiOperation("获取所有文书附件")
    public CommonResult<PageResult<SurveyDocumentsFilesDTO>> supervisionDocFilePage(@Valid SurveyDocumentsFilesQuery reqVO) {
        // 获得用户分页列表
        reqVO.setDictTypeList(Arrays.asList(201,202,203,204));
        PageResult<SurveyDocumentsFilesDTO> pageResult = surveyDocumentsFilesService.surveyDocFilePage(reqVO);
        if (CollUtil.isEmpty(pageResult.getList())) {
            return success(new PageResult<>(pageResult.getTotal())); // 返回空
        }
        return success(pageResult);
    }

    @GetMapping("/getLeaveCount")
    @ApiImplicitParam(name = "id", value = "id", required = true, example = "矫正对象Id", dataTypeClass = Long.class)
    @ApiOperation("获取用户近两个月的请假天数")
    public CommonResult<Integer> getLeaveCount(@RequestParam Long id) {
        Integer count =  supervisionOutApprovalService.getLeaveCount(id);
        return success(count);
    }

    @PostMapping("/noneTerminate")
    @ApiOperation("正常销假")
    public CommonResult<Boolean> noneTerminate(@Valid @RequestBody TerminateLeaveDTO reqDTO) throws Exception {
        supervisionOutApprovalService.noneTerminate(reqDTO);
        return success(true);
    }

    @PostMapping("/delay")
    @ApiOperation("延期")
    public CommonResult<Boolean> delay(@Valid @RequestBody TerminateLeaveDTO reqDTO)  throws Exception{
        supervisionOutApprovalService.delay(reqDTO);
        return success(true);
    }

    @PostMapping("/delayTerminate")
    @ApiOperation("延期销假")
    public CommonResult<Boolean> delayTerminate(TerminateLeaveDTO reqDTO, @RequestParam("files") MultipartFile[] files)  throws Exception{
        supervisionOutApprovalService.delayTerminate(reqDTO,files);
        return success(true);
    }

    @GetMapping("/getTerinateLeaveDetail")
    @ApiImplicitParam(name = "id", value = "id", required = true, example = "矫正对象Id", dataTypeClass = Long.class)
    @ApiOperation("获取销假详情")
    public CommonResult<TerminateLeaveDTO> getTerinateLeaveDetail(@RequestParam Long id) throws Exception {
        TerminateLeaveDTO terinateLeaveDetail = supervisionOutApprovalService.getTerinateLeaveDetail(id);
        return success(terinateLeaveDetail);
    }

}
