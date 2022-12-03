package com.correction.backend.modules.flow.controller.dto;

import com.correction.backend.modules.sys.controller.dto.sys.RoleListOutputDTO;
import com.correction.backend.modules.sys.controller.dto.sys.RoleUserOutpuDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FlowOrgRoleDTO {

    @ApiModelProperty("组织信息")
    private String orgName;

    @ApiModelProperty("组织级别")
    private Integer orgType;

    @ApiModelProperty("组织id")
    private Long orgId;

    @ApiModelProperty("角色信息")
    private List<RoleUserOutpuDTO> roleList;

}
