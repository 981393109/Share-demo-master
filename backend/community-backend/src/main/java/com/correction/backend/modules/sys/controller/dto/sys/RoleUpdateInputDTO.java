package com.correction.backend.modules.sys.controller.dto.sys;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.util.Date;
/**
 * <p>
 * 角色表
 * </p>
 *
 * @author yao
 * @since 2022-11-12
 */
@Getter
@Setter
@ApiModel(value="RoleUpdateInputDTO", description="角色表修改表单")
public class RoleUpdateInputDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    @ApiModelProperty(value = "角色名称")
    private String roleName;

    @ApiModelProperty(value = "角色描述")
    private String description;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "修改时间")
    private Date updateTime;

    @ApiModelProperty(value = "创建人")
    private String creator;

    @ApiModelProperty(value = "修改人")
    private String updater;

    @ApiModelProperty(value = "是否删除")
    private Boolean deleted;

    @ApiModelProperty(value = "orgId")
    private Long orgId;

    @ApiModelProperty(value = "orgInfo")
    private String  orgInfo;
}
