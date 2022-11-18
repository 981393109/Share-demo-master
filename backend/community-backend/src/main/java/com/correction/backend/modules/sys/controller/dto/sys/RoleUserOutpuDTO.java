package com.correction.backend.modules.sys.controller.dto.sys;

import com.correction.backend.modules.sys.controller.dto.user.SysUserRoleDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class RoleUserOutpuDTO implements Serializable {

    private Long id;

    @ApiModelProperty(value = "角色名称")
    private String roleName;

    @ApiModelProperty(value = "组织id")
    private Long orgId;

    @ApiModelProperty(value = "组织信息")
    private String orgInfo;

    @ApiModelProperty(value = "userList")
    private List<SysUserRoleDTO> userList;


}
