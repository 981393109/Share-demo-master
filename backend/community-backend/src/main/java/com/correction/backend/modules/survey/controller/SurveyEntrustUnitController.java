package com.correction.backend.modules.survey.controller;

import cn.hutool.core.collection.CollUtil;
import com.correction.backend.modules.survey.controller.dto.SurveyEntrustUnitCreateInputDTO;
import com.correction.backend.modules.survey.controller.dto.SurveyEntrustUnitListOutputDTO;
import com.correction.backend.modules.survey.controller.dto.SurveyEntrustUnitSearchInputDTO;
import com.correction.backend.modules.survey.controller.dto.SurveyEntrustUnitUpdateInputDTO;
import com.correction.backend.modules.survey.convert.MSurveyEntrustUnitConvert;
import com.correction.backend.modules.survey.entity.SurveyEntrustUnit;
import com.correction.backend.modules.survey.service.SurveyEntrustUnitService;
import com.correction.backend.modules.sys.controller.dto.sys.OrgCreateInputDTO;
import com.correction.backend.modules.sys.controller.dto.sys.OrgListOutputDTO;
import com.correction.backend.modules.sys.controller.dto.sys.OrgSearchInputDTO;
import com.correction.backend.modules.sys.convert.sys.MOrgConvert;
import com.correction.backend.modules.sys.entity.OrgDO;
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

@Api(tags = "调查评估-委托单位相关接口")
@RestController
@RequestMapping("/survey-unit")
@Validated
public class SurveyEntrustUnitController {

    @Resource
    private SurveyEntrustUnitService surveyEntrustUnitService;

    @PostMapping("/create")
    @ApiOperation("新增委托单位")
    public CommonResult<Long> createSurveyEntrustUnit(@Valid @RequestBody SurveyEntrustUnitCreateInputDTO reqDTO) {
        Long id = surveyEntrustUnitService.createSurveyEntrustUnit(reqDTO);
        return success(id);
    }

    @PostMapping("/update")
    @ApiOperation("编辑委托单位")
    public CommonResult<Boolean> updateSurveyEntrustUnit(@Valid @RequestBody SurveyEntrustUnitUpdateInputDTO reqDTO) {
        surveyEntrustUnitService.updateSurveyEntrustUnit(reqDTO);
        return success(true);
    }

    @GetMapping("/get")
    @ApiOperation("获取详情信息")
    @ApiImplicitParam(name = "id", value = "id", required = true, example = "1024", dataTypeClass = Long.class)
    public CommonResult<SurveyEntrustUnitListOutputDTO> getInfo(@RequestParam("id") Long id) {
        return success(MSurveyEntrustUnitConvert.INSTANCE.toList(surveyEntrustUnitService.get(id)));
    }

    @PostMapping("delete")
    @ApiOperation("删除委托单位")
    public CommonResult<Boolean> delete(@Valid @RequestParam Long id) {
        surveyEntrustUnitService.delete(id);
        return success(true);
    }

    @GetMapping("/page")
    @ApiOperation("获取分页列表")
    public CommonResult<PageResult<SurveyEntrustUnitListOutputDTO>> getPageList(@Valid SurveyEntrustUnitSearchInputDTO reqVO) {
        // 获得用户分页列表
        PageResult<SurveyEntrustUnit> pageResult = surveyEntrustUnitService.getPageList(reqVO);
        if (CollUtil.isEmpty(pageResult.getList())) {
            return success(new PageResult<>(pageResult.getTotal())); // 返回空
        }
        // 拼接结果返回
        List<SurveyEntrustUnitListOutputDTO> outList = new ArrayList<>(pageResult.getList().size());
        pageResult.getList().forEach(surveyEntrustUnit -> {
            SurveyEntrustUnitListOutputDTO respVO = MSurveyEntrustUnitConvert.INSTANCE.toList(surveyEntrustUnit);
            outList.add(respVO);
        });
        return success(new PageResult<>(outList, pageResult.getTotal()));
    }


    @GetMapping("/getList")
    @ApiOperation("获取列表(不分页)")
    public CommonResult<List<SurveyEntrustUnitListOutputDTO>> getList(@Valid SurveyEntrustUnitSearchInputDTO reqVO) {
        // 获得用户分页列表
        List<SurveyEntrustUnit> list = surveyEntrustUnitService.getList(reqVO);
        return success(MSurveyEntrustUnitConvert.INSTANCE.toList(list));
    }

}
