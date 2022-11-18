package com.correction.backend.modules.sys.convert.sys;

import com.correction.backend.modules.sys.controller.dto.sys.*;
import com.correction.backend.modules.sys.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Author：yao
 * @Description: 角色表 转换类
 * @Date: 2022-11-12
 */

@Mapper
public interface MRoleConvert {

    MRoleConvert INSTANCE = Mappers.getMapper(MRoleConvert.class);

    Role toRole(RoleSearchInputDTO roleSearchInputDTO);

    Role toRole(RoleCreateInputDTO roleCreateInputDTO);

    Role toRole(RoleUpdateInputDTO roleUpdateInputDTO);

    RoleListOutputDTO toList(Role role);

    List<RoleListOutputDTO> toList(List<Role> roles);


    List<RoleUserOutpuDTO> toRoleUserList(List<Role> roles);
}