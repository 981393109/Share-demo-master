package com.correction.backend.modules.sys.controller.dto.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 用户 Base VO，提供给添加、修改、详细的子 VO 使用
 * 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
 */
@Data
public class SysUserBaseDTO {

    @ApiModelProperty(value = "工号", required = true, example = "工号")
    @NotBlank(message = "用户工号不能为空")
    private String userNumber;

    @ApiModelProperty(value = "用户名", required = true, example = "用户名")
    @NotBlank(message = "用户名称不能为空")
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

}
