package com.correction.backend.modules.sys.mapper;

import com.correction.backend.modules.sys.entity.Menu;
import com.correction.backend.modules.sys.entity.RoleMenu;
import com.correction.frameworks.mybatis.mybatis.core.mapper.BaseMapperX;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 角色-菜单表 Mapper 接口
 * </p>
 *
 * @author yao
 * @since 2022-11-12
 */
public interface RoleMenuMapper extends BaseMapperX<RoleMenu> {

    List<Menu> getMenuByRoleId(@Param("roleId") Long roleId);


}
