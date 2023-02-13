package com.correction.backend.modules.handleCorrection.controller;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.correction.backend.modules.handleCorrection.controller.dto.*;
import com.correction.backend.modules.handleCorrection.convert.MCorrectionUserConvert;
import com.correction.backend.modules.handleCorrection.entity.CorrectionUser;
import com.correction.backend.modules.handleCorrection.entity.HandleCorrection;
import com.correction.backend.modules.handleCorrection.service.CorrectionUserService;
import com.correction.backend.modules.survey.controller.dto.SurveyDocumentsFilesDTO;
import com.correction.backend.modules.survey.controller.dto.SurveyDocumentsFilesQuery;
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

@Api(tags = "入矫申请-矫正档案相关接口")
@RestController
@RequestMapping("/correctionUser")
@Validated
public class CorrectionUserController {

    @Resource
    private CorrectionUserService correctionUserService;

    @PostMapping("/create")
    @ApiOperation("新增矫正档案")
    public CommonResult<CorrectionUser> createCorrectionUser(@Valid @RequestBody CorrectionUserCreateInputDTO reqDTO) {
        CorrectionUser correctionUser = correctionUserService.createCorrectionUser(reqDTO);
        return success(correctionUser);
    }

    @PostMapping("/update")
    @ApiOperation("修改矫正档案")
    public CommonResult<CorrectionUser> updateCorrectionUser(@Valid @RequestBody CorrectionUserUpdateInputDTO reqDTO) {
        CorrectionUser correctionUser = correctionUserService.updateCorrectionUser(reqDTO);
        return success(correctionUser);
    }

    @PostMapping("delete")
    @ApiOperation("删除档案")
    public CommonResult<Boolean> delete(@Valid @RequestParam Long id) {
        correctionUserService.delete(id);
        return success(true);
    }


    @GetMapping("/get")
    @ApiOperation("获取档案详情信息")
    @ApiImplicitParam(name = "id", value = "id", required = true, example = "1024", dataTypeClass = Long.class)
    public CommonResult<CorrectionUserListOutputDTO> getInfo(@RequestParam("id") Long id) {
        return success(MCorrectionUserConvert.INSTANCE.toList(correctionUserService.get(id)));
    }

    @GetMapping("/getByCorrectionId")
    @ApiOperation("根据矫正id获取矫正档案数据")
    @ApiImplicitParam(name = "id", value = "id", required = true, example = "1024", dataTypeClass = Long.class)
    public CommonResult<CorrectionUserListOutputDTO> getByCorrectionId(@RequestParam("id") Long id) {
        return success(MCorrectionUserConvert.INSTANCE.toList(correctionUserService.getByCorrectionId(id)));
    }

    @GetMapping("/page")
    @ApiOperation("获取所有矫正档案列表(分页)")
    public CommonResult<PageResult<CorrectionUserListOutputDTO>> getPageList(@Valid CorrectionUserSearchInputDTO reqVO) {
        PageResult<CorrectionUser> pageList = correctionUserService.getPageList(reqVO);
        List<CorrectionUserListOutputDTO> list = new ArrayList<>();
        for (CorrectionUser correctionUser : pageList.getList()) {
            list.add(MCorrectionUserConvert.INSTANCE.toList(correctionUser));
        }
        return success(new PageResult<CorrectionUserListOutputDTO>(list, pageList.getTotal()));
    }

    @GetMapping("/getList")
    @ApiOperation("获取所有矫正档案列表(不分页)")
    public CommonResult<List<CorrectionUserListOutputDTO>> getList(@Valid CorrectionUserSearchDTO reqVO) {
        List<CorrectionUser> list = correctionUserService.getList(reqVO);
        return success(MCorrectionUserConvert.INSTANCE.toList(list));
    }


}
