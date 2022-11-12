package com.correction.backend.modules.sys.entity;

import com.correction.frameworks.mybatis.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author yao
 * @since 2022-11-12
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("sys_menu")
public class Menu extends BaseDO {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 菜单名称
     */
    private String menuName;

    /**
     * 权限标识 例如：system:admin:add   ${系统}:${模块}:${操作}
     */
    private String permission;

    /**
     * 菜单类型
     */
    private Integer type;

    /**
     * 显示顺序
     */
    private Integer sort;

    /**
     * 父id
     */
    @TableField("parentId")
    private Long parentid;

    /**
     * 路由地址
     */
    private String path;

    /**
     * icon
     */
    private String icon;

    /**
     * 状态
     */
    private Integer status;


    public static final String ID = "id";

    public static final String MENU_NAME = "menu_name";

    public static final String PERMISSION = "permission";

    public static final String TYPE = "type";

    public static final String SORT = "sort";

    public static final String PARENTID = "parentId";

    public static final String PATH = "path";

    public static final String ICON = "icon";

    public static final String STATUS = "status";

}
