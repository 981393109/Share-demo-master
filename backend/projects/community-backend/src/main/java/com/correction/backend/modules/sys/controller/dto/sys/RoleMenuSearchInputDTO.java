package com.correction.backend.modules.sys.controller.dto.sys;

import com.correction.framework.common.pojo.PageParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.util.Date;
/**
 * <p>
 * 角色-菜单表
 * </p>
 *
 * @author yao
 * @since 2022-11-12
 */
@Getter
@Setter
@ApiModel(value="RoleMenuSearchInputDTO", description="角色-菜单表查询表单")
public class RoleMenuSearchInputDTO extends PageParam {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "角色id")
    private Long roleId;

    @ApiModelProperty(value = "菜单id")
    private Long menuId;

}
