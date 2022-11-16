package com.correction.backend.modules.sys.controller;


import com.correction.backend.modules.sys.controller.dto.sys.DictOutDTO;
import com.correction.backend.modules.sys.convert.sys.MDictConvert;
import com.correction.backend.modules.sys.service.DictService;
import com.correction.framework.common.pojo.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import java.util.List;

import static com.correction.framework.common.pojo.CommonResult.success;

@Api(tags = "系统模块-字典相关接口")
@RestController
@RequestMapping("/dict")
@Validated
public class DictController {

    @Resource
    private DictService dictService;

    @GetMapping("/get")
    @ApiOperation("获取字典数据")
    @ApiImplicitParam(name = "type", value = "type", required = true, example = "1:组织类型，2: ", dataTypeClass = Integer.class)
    public CommonResult<List<DictOutDTO>> selectDictByType(@RequestParam("type") Integer type){
        return success(MDictConvert.INSTANCE.convertList(dictService.selectDictByType(type)));
    }


}
