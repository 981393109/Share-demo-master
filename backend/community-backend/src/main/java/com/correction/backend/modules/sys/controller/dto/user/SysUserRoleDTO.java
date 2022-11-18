package com.correction.backend.modules.sys.controller.dto.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class SysUserRoleDTO {

    private Long id ;

    @ApiModelProperty(value = "工号", required = true, example = "工号")
    private String userNumber;

    @ApiModelProperty(value = "用户名", required = true, example = "用户名")
    private String userName;

    @ApiModelProperty(value = "用户状态", example = "0")
    private String status;

    @ApiModelProperty(value = "岗位", example = "0")
    private String userJobs;

    @ApiModelProperty(value = "组织信息", example = "xxxx-xxx-xxxx")
    private String orgInfo;

}
