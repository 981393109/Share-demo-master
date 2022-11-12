package com.correction.backend.modules.sys.controller.dto.sys;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.util.Date;
/**
 * <p>
 * 角色-用户关联表
 * </p>
 *
 * @author yao
 * @since 2022-11-12
 */
@Getter
@Setter
@ApiModel(value="RoleUserUpdateInputDTO", description="角色-用户关联表修改表单")
public class RoleUserUpdateInputDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    @ApiModelProperty(value = "用户id")
    private Long userId;

    @ApiModelProperty(value = "角色id")
    private Long roleId;

}
