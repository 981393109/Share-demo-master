package com.correction.backend.modules.sys.convert.sys;

import com.correction.backend.modules.sys.controller.dto.sys.RoleMenuCreateInputDTO;
import com.correction.backend.modules.sys.controller.dto.sys.RoleMenuListOutputDTO;
import com.correction.backend.modules.sys.controller.dto.sys.RoleMenuSearchInputDTO;
import com.correction.backend.modules.sys.controller.dto.sys.RoleMenuUpdateInputDTO;
import com.correction.backend.modules.sys.entity.RoleMenu;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Author：yao
 * @Description: 角色-菜单表 转换类
 * @Date: 2022-11-12
 */

@Mapper
public interface MRoleMenuConvert {

    MRoleMenuConvert INSTANCE = Mappers.getMapper(MRoleMenuConvert.class);

    RoleMenu toRoleMenu(RoleMenuSearchInputDTO roleMenuSearchInputDTO);

    RoleMenu toRoleMenu(RoleMenuCreateInputDTO roleMenuCreateInputDTO);

    RoleMenu toRoleMenu(RoleMenuUpdateInputDTO roleMenuUpdateInputDTO);

    RoleMenuListOutputDTO toList(RoleMenu roleMenu);

    List<RoleMenuListOutputDTO> toList(List<RoleMenu> roleMenus);
}