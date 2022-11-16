package com.correction.backend.modules.sys.controller.dto.sys;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@ApiModel(value="SaveRoleMenuDTO", description="保存角色菜单对象")
public class SaveRoleMenuDTO {

    @ApiModelProperty("roleId")
    Long roleId;

    @ApiModelProperty("menuIds")
    List<Long> menuIds;

}
