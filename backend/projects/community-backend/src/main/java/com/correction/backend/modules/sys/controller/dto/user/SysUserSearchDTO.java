package com.correction.backend.modules.sys.controller.dto.user;

import com.correction.framework.common.pojo.PageParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@ApiModel("用户查询对象")
@Data
@EqualsAndHashCode(callSuper = true)
public class SysUserSearchDTO extends PageParam {

    @ApiModelProperty(value = "工号", example = "工号")
    private String userNumber;

    @ApiModelProperty(value = "用户名", example = "用户名")
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
