package com.correction.backend.modules.sys.controller.dto.sys;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AreaOutDTO {

    @ApiModelProperty("区域名称")
    String areaName;

    @ApiModelProperty("id")
    Long areaId;

    @ApiModelProperty("父id")
    Long parentId;

    @ApiModelProperty("子区域数据")
    List<AreaOutDTO> childen;


}
