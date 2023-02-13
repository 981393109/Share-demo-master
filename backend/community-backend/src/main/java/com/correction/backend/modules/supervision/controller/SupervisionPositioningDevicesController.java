package com.correction.backend.modules.supervision.controller;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.correction.backend.modules.supervision.controller.dto.*;
import com.correction.backend.modules.supervision.entity.SupervisionPositioningDevices;
import com.correction.backend.modules.supervision.service.SupervisionPositioningDevicesService;
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

@Api(tags = "监督-使用电子定位装置新增操作相关接口")
@RestController
@RequestMapping("/supervisionPositioningDevices")
@Validated
public class SupervisionPositioningDevicesController {

    @Resource
    SupervisionPositioningDevicesService supervisionPositioningDevicesService;

    @Resource
    SurveyDocumentsFilesService surveyDocumentsFilesService;

    @PostMapping("/create")
    @ApiOperation("新增申请")
    public CommonResult<Boolean> createSupervisionPositiongDevices(@Valid @RequestBody SupervisionPositioningDevicesCreateInputDTO reqDTO) throws Exception {
        supervisionPositioningDevicesService.createSupervisionPositiongDevices(reqDTO);
        return success(true);
    }

    @PostMapping("/update")
    @ApiOperation("修改申请")
    public CommonResult<Boolean> createSupervisionOutApproval(@Valid @RequestBody SupervisionPositioningDevicesUpdateInputDTO reqDTO) throws Exception {
        supervisionPositioningDevicesService.updateSupervisionPositiongDevices(reqDTO);
        return success(true);
    }

    @PostMapping("delete")
    @ApiOperation("删除")
    public CommonResult<Boolean> delete(@Valid @RequestParam Long id) {
        supervisionPositioningDevicesService.delete(id);
        return success(true);
    }


    @GetMapping("/get")
    @ApiOperation("获取详情")
    @ApiImplicitParam(name = "id", value = "id", required = true, example = "1024", dataTypeClass = Long.class)
    public CommonResult<SupervisionPositioningDevicesDetailDTO> getInfo(@RequestParam("id") Long id) {
        SupervisionPositioningDevicesDetailDTO detailById = supervisionPositioningDevicesService.getDetailById(id);
        return success(detailById);
    }


    @GetMapping("/page")
    @ApiOperation("分页获取所有列表记录")
    public CommonResult<PageResult<SupervisionPositioningDevicesFlowDTO>> getPageList(@Valid SupervisionPositioningDevicesSearchInputDTO reqVO) {
        IPage<SupervisionPositioningDevicesFlowDTO> pageList = supervisionPositioningDevicesService.getPageList(reqVO);
        return success(new PageResult<SupervisionPositioningDevicesFlowDTO>(pageList.getRecords(), pageList.getTotal()));
    }

    @GetMapping("/pageAll")
    @ApiOperation("分页获取所有列表记录(组织下所有)")
    public CommonResult<PageResult<SupervisionPositioningDevicesFlowDTO>> getPageAllList(@Valid SupervisionPositioningDevicesSearchInputDTO reqVO) {
        IPage<SupervisionPositioningDevicesFlowDTO> pageList = supervisionPositioningDevicesService.getPageAllList(reqVO);
        return success(new PageResult<SupervisionPositioningDevicesFlowDTO>(pageList.getRecords(), pageList.getTotal()));
    }

    @GetMapping("/supervisionDocFilePage")
    @ApiOperation("获取所有文书附件")
    public CommonResult<PageResult<SurveyDocumentsFilesDTO>> supervisionDocFilePage(@Valid SurveyDocumentsFilesQuery reqVO) {
        // 获得用户分页列表
        SupervisionPositioningDevices byId = supervisionPositioningDevicesService.getById(reqVO.getDataId());
        Integer type = byId.getType();
        if(1 == type ){
            reqVO.setDictTypeList(Arrays.asList(301,302,303));
        } else if (2 == type) {
            reqVO.setDictTypeList(Arrays.asList(304,305,306));
        } else if (3 == type){
            reqVO.setDictTypeList(Arrays.asList(307,308,309));
        } else {
            reqVO.setDictTypeList(Arrays.asList(310,311,312));
        }
        PageResult<SurveyDocumentsFilesDTO> pageResult = surveyDocumentsFilesService.surveyDocFilePage(reqVO);
        if (CollUtil.isEmpty(pageResult.getList())) {
            return success(new PageResult<>(pageResult.getTotal())); // 返回空
        }
        return success(pageResult);
    }



}
