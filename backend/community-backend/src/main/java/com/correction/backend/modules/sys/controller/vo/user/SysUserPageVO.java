package com.correction.backend.modules.sys.controller.vo.user;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;

@ApiModel("用户集合返回对象")
@Data
public class SysUserPageVO {

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

    @ApiModelProperty(value = "组织信息", example = "0")
    private String parentNames;

    @ApiModelProperty(value = "联系方式", example = "15672677262")
    private String contactInformation;

    @ApiModelProperty(value = "组织信息", example = "xxxx-xxx-xxxx")
    private String orgInfo;

    @ApiModelProperty(value = "所属组织", example = "orgId")
    private Long orgId;

    @ApiModelProperty(value = "组织信息", example = "xxxx-xxx-xxxx")
    private String orgParentInfo;


}
