package com.correction.backend.modules.sys.controller;

import com.correction.backend.modules.sys.controller.dto.sys.AreaOutDTO;
import com.correction.backend.modules.sys.controller.dto.sys.SysAreaDTO;
import com.correction.backend.modules.sys.convert.sys.MDictConvert;
import com.correction.backend.modules.sys.entity.SysArea;
import com.correction.backend.modules.sys.service.SysAreaService;
import com.correction.framework.common.pojo.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

import static com.correction.framework.common.pojo.CommonResult.success;

/**
 * 地区级联相关接口
 */
@Api(tags = "地区级联-地区级联相关接口")
@RestController
@RequestMapping("/area")
@Validated
public class SysAreaController {

    @Autowired
    private SysAreaService sysAreaService;

    @GetMapping("/getZHEJ")
    @ApiOperation("获取浙江省级联数据")
    public CommonResult<List<SysArea>> getZHEJ(@Valid SysAreaDTO dto) {
        return success(sysAreaService.getSysArea(dto));
    }


    @GetMapping("/getHZ")
    @ApiOperation("获取杭州区街道级联信息")
    public CommonResult<List<SysArea>> getHZ(@Valid SysAreaDTO dto) {
        return success(sysAreaService.getSysArea(dto));
    }


    @GetMapping("/getHZArea")
    @ApiOperation("获取杭州区域以及街道信息")
    public CommonResult<List<AreaOutDTO>> getHZArea (){
        return success(sysAreaService.getHZArea());
    }

}
