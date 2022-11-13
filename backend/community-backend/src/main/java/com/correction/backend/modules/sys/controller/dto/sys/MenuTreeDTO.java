package com.correction.backend.modules.sys.controller.dto.sys;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@ApiModel("菜单树结构 Response VO")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MenuTreeDTO {

    @ApiModelProperty(value = "菜单名称", required = true, example = "")
    private Long id;

    @ApiModelProperty(value = "父菜单 ID", required = true, example = "1024")
    private Long pid;

    @ApiModelProperty(value = "菜单名称", required = true, example = "")
    private String menuName;

    @ApiModelProperty(value = "code", required = true, example = "")
    private String code;

    @ApiModelProperty(value = "路由地址", example = "post", notes = "仅菜单类型为菜单或者目录时，才需要传")
    private String path;

    @ApiModelProperty(value = "菜单图标", example = "/menu/list", notes = "仅菜单类型为菜单或者目录时，才需要传")
    private String icon;

    /**
     * 子路由
     */
    private List<MenuTreeDTO> children;


}
