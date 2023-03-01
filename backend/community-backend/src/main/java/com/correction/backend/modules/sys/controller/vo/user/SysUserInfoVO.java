package com.correction.backend.modules.sys.controller.vo.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SysUserInfoVO {

    @ApiModelProperty(value = "ID", example = "123")
    private Long id;

    @ApiModelProperty(value = "工号", required = true, example = "工号")
    private String userNumber;

    @ApiModelProperty(value = "用户名", required = true, example = "用户名")
    private String userName;

    @ApiModelProperty(value = "用户状态", example = "0")
    private String status;

    @ApiModelProperty(value = "岗位", example = "0")
    private String userJobs;

    @ApiModelProperty(value = "联系方式", example = "15672677262")
    private String contactInformation;

    @ApiModelProperty(value = "组织信息", example = "xxxx-xxx-xxxx")
    private String orgInfo;

    @ApiModelProperty(value = "所属组织", example = "orgId")
    private Long orgId;

    @ApiModelProperty(value = "用户类型", example = "0普通  1超管")
    private Integer userType;

    @ApiModelProperty(value = "password", example = "password")
    private String password;

    @ApiModelProperty(value = "roleId")
    private Long roleId;

    @ApiModelProperty(value = "relationUserId")
    private Long relationUserId;



}
