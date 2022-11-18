package com.correction.backend.modules.sys.controller.dto.sys;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(value="SysAreaDTO", description="地区级联查询对象")
public class SysAreaDTO {

    @ApiModelProperty(value = "省市区级联id,不传默认给定浙江省下所有市级数据、给定市级id返回区级数据。。。")
    private Long areaId;

    @ApiModelProperty(value = "type : 省：1  市：2 区：3")
    private Integer type;

}
