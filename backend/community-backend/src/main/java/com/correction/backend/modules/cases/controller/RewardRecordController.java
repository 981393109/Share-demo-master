package com.correction.backend.modules.cases.controller;


import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.correction.backend.modules.cases.controller.dto.*;
import com.correction.backend.modules.cases.entity.CasesPunishment;
import com.correction.backend.modules.cases.entity.RewardRecord;
import com.correction.backend.modules.cases.service.RewardRecordService;
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

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Arrays;

import static com.correction.framework.common.pojo.CommonResult.success;

/**
 * <p>
 * 奖励记录 前端控制器
 * </p>
 *
 * @author yao
 * @since 2022-12-17
 */
@RestController
@RequestMapping("/reward-record")
@Api(tags = "奖罚-奖励记录相关接口")
@Validated
public class RewardRecordController {

    @Resource
    private RewardRecordService rewardRecordService;

    @Resource
    private SurveyDocumentsFilesService surveyDocumentsFilesService;

    @PostMapping("/create")
    @ApiOperation("新增")
    public CommonResult<RewardRecord> createCorrectionGroup(@Valid @RequestBody RewardRecordCreateInputDTO reqDTO) {
        RewardRecord rewardRecord = rewardRecordService.createRewardRecord(reqDTO);
        return success(rewardRecord);
    }

    @PostMapping("/update")
    @ApiOperation("修改")
    public CommonResult<RewardRecord> update(@Valid @RequestBody RewardRecordUpdateInputDTO reqDTO) {
        RewardRecord rewardRecord = rewardRecordService.updateRewardRecord(reqDTO);
        return success(rewardRecord);
    }

    @PostMapping("/delete")
    @ApiOperation("删除")
    public CommonResult<Boolean> delete(@Valid @RequestParam Long id) {
        rewardRecordService.delete(id);
        return success(true);
    }


    @GetMapping("/getDetail")
    @ApiOperation("获取详情信息")
    @ApiImplicitParam(name = "id", value = "id", required = true, example = "1024", dataTypeClass = Long.class)
    public CommonResult<RewardRecordDetailDTO> getDetail(@RequestParam("id") Long id) {
        return success(rewardRecordService.getDetail(id));
    }

    @GetMapping("/page")
    @ApiOperation("分页获取所有列表记录")
    public CommonResult<PageResult<RewardRecordPageListDTO>> getPageList(@Valid RewardRecordSearchInputDTO reqVO) {
        IPage<RewardRecordPageListDTO> pageList = rewardRecordService.getPageList(reqVO);
        return success(new PageResult<RewardRecordPageListDTO>(pageList.getRecords(), pageList.getTotal()));
    }
    @GetMapping("/pageAll")
    @ApiOperation("分页获取所有列表记录")
    public CommonResult<PageResult<RewardRecordPageListDTO>> getPageAllList(@Valid RewardRecordSearchInputDTO reqVO) {
        IPage<RewardRecordPageListDTO> pageList = rewardRecordService.getPageAllList(reqVO);
        return success(new PageResult<RewardRecordPageListDTO>(pageList.getRecords(), pageList.getTotal()));
    }


    @GetMapping("/handleDocFilePage")
    @ApiOperation("获取所有文书附件")
    public CommonResult<PageResult<SurveyDocumentsFilesDTO>> handleDocFilePage(@Valid SurveyDocumentsFilesQuery reqVO) {
        // 获得用户分页列表
        reqVO.setDictTypeList(Arrays.asList(801,802,810,811,812,813,814,815));
        PageResult<SurveyDocumentsFilesDTO> pageResult = surveyDocumentsFilesService.surveyDocFilePage(reqVO);
        if (CollUtil.isEmpty(pageResult.getList())) {
            return success(new PageResult<>(pageResult.getTotal())); // 返回空
        }
        return success(pageResult);
    }



}
