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
 * 
 * </p>
 *
 * @author yao
 * @since 2022-11-12
 */
@Getter
@Setter
@ApiModel(value="MenuSearchInputDTO", description="查询表单")
public class MenuSearchInputDTO extends PageParam {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "菜单名称")
    private String menuName;

    @ApiModelProperty(value = "权限标识 例如：system:admin:add   ${系统}:${模块}:${操作}")
    private String permission;

    @ApiModelProperty(value = "菜单类型")
    private Integer type;

    @ApiModelProperty(value = "显示顺序")
    private Integer sort;

    @ApiModelProperty(value = "父id")
    private Long parentid;

    @ApiModelProperty(value = "路由地址")
    private String path;

    @ApiModelProperty(value = "icon")
    private String icon;

    @ApiModelProperty(value = "状态")
    private Integer status;

}
