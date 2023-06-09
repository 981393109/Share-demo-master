package com.correction.backend.modules.survey.controller;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.correction.backend.modules.flow.controller.dto.FlowOrgRoleDTO;
import com.correction.backend.modules.survey.controller.dto.*;
import com.correction.backend.modules.survey.convert.MSurveyEvaluationConvert;
import com.correction.backend.modules.survey.entity.SurveyEvaluation;
import com.correction.backend.modules.survey.service.SurveyDocumentsFilesService;
import com.correction.backend.modules.survey.service.SurveyEvaluationService;
import com.correction.backend.modules.sys.controller.dto.user.SysUserSearchDTO;
import com.correction.backend.modules.sys.controller.vo.user.SysUserPageVO;
import com.correction.backend.modules.sys.convert.user.SysUserConvert;
import com.correction.backend.modules.sys.entity.SysUserDO;
import com.correction.backend.modules.sys.service.SysUserService;
import com.correction.framework.common.pojo.CommonResult;
import com.correction.framework.common.pojo.PageResult;
import com.correction.framework.web.web.core.util.WebFrameworkUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.correction.framework.common.pojo.CommonResult.success;

@Api(tags = "调查评估-调查评估相关接口")
@RestController
@RequestMapping("/survey")
@Validated
public class SurveyEvaluationController {

    @Resource
    SurveyEvaluationService surveyEvaluationService;

    @Resource
    SurveyDocumentsFilesService surveyDocumentsFilesService;

    @Resource
    SysUserService sysUserService;

    @PostMapping("/create")
    @ApiOperation("新增调查评估")
    public CommonResult<SurveyEvaluation> createSurveyEvaluation(@Valid @RequestBody SurveyEvaluationCreateInputDTO reqDTO) {
        SurveyEvaluation entity = surveyEvaluationService.createSurveyEvaluation(reqDTO);
        return success(entity);
    }

    @PostMapping("/update")
    @ApiOperation("修改调查评估")
    public CommonResult<Boolean> updateSurveyEvaluation(@Valid @RequestBody SurveyEvaluationUpdateInputDTO reqDTO) {
        surveyEvaluationService.updateSurveyEvaluation(reqDTO);
        return success(true);
    }

    @PostMapping("delete")
    @ApiOperation("删除调查评估")
    public CommonResult<Boolean> delete(@Valid @RequestParam Long id) {
        surveyEvaluationService.delete(id);
        return success(true);
    }


    @GetMapping("/get")
    @ApiOperation("获取调查评估详情")
    @ApiImplicitParam(name = "id", value = "id", required = true, example = "1024", dataTypeClass = Long.class)
    public CommonResult<SurveyEvaluationFilesDTO> getInfo(@RequestParam("id") Long id) {
        return success(surveyEvaluationService.get(id));
    }

    @GetMapping("/page")
    @ApiOperation("获取所有调查评估列表记录")
    public CommonResult<PageResult<SurveyEvaluationListDTO>> page(@Valid SurveyEvaluationSearchInputDTO reqVO) {
        IPage<SurveyEvaluationListDTO> pageResult = surveyEvaluationService.getPageListFlow(reqVO);
        return success(new PageResult<SurveyEvaluationListDTO>(pageResult.getRecords(), pageResult.getTotal()));
    }


    @GetMapping("/surveyDocFilePage")
    @ApiOperation("获取所有文书附件")
    public CommonResult<PageResult<SurveyDocumentsFilesDTO>> surveyDocFilePage(@Valid SurveyDocumentsFilesQuery reqVO) {
        // 获得用户分页列表
        reqVO.setDictTypeList(Arrays.asList(2,3,4));
        PageResult<SurveyDocumentsFilesDTO> pageResult = surveyDocumentsFilesService.surveyDocFilePage(reqVO);
        if (CollUtil.isEmpty(pageResult.getList())) {
            return success(new PageResult<>(pageResult.getTotal())); // 返回空
        }
        return success(pageResult);
    }

    @GetMapping("/getOrgUserList")
    @ApiOperation("得到用户部门下的所有用户信息")
    public CommonResult<List<SysUserPageVO>> getOrgUserList(@RequestParam("orgId") Long orgId) {
        // 获得用户列表
        if(orgId == null){
            orgId = WebFrameworkUtils.getLoginOrgId();
        }
        SysUserSearchDTO reqVO = new SysUserSearchDTO();
        reqVO.setOrgId(orgId);
        List<SysUserDO> result = sysUserService.getOrgUserList(reqVO);
        List<SysUserPageVO> sysUserPageVOS = SysUserConvert.INSTANCE.convertList(result);
        return success(sysUserPageVOS);
    }


    @GetMapping("/getOrgInfoList")
    @ApiOperation("获取区，市组织角色下拉")
    public CommonResult<List<FlowOrgRoleDTO>> getOrgInfoList() {
        List<FlowOrgRoleDTO> orgRoleInfoList = surveyEvaluationService.getOrgRoleInfoList();
        return success(orgRoleInfoList);
    }


    @GetMapping("/pageAll")
    @ApiOperation("获取所有调查评估记录列表")
    public CommonResult<PageResult<SurveyEvaluationListDTO>> pageAll(@Valid SurveyEvaluationSearchInputDTO reqVO) {
        IPage<SurveyEvaluationListDTO> pageResult = surveyEvaluationService.getPageAllListFlow(reqVO);
        return success(new PageResult<SurveyEvaluationListDTO>(pageResult.getRecords(), pageResult.getTotal()));
    }


    @PostMapping("/updateApplyStatus")
    @ApiOperation("修改ApplyStatus")
    public CommonResult<Boolean> updateApplyStatus(@RequestParam("id") Long id ,@RequestParam("applyStatus") Integer applyStatus) {
        surveyEvaluationService.updateApplyStatus(id,applyStatus);
        return success(true);
    }

}
