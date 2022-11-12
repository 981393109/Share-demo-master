package com.correction.backend.modules.sys.convert.sys;

import com.correction.backend.modules.sys.controller.dto.sys.RoleUserCreateInputDTO;
import com.correction.backend.modules.sys.controller.dto.sys.RoleUserListOutputDTO;
import com.correction.backend.modules.sys.controller.dto.sys.RoleUserSearchInputDTO;
import com.correction.backend.modules.sys.controller.dto.sys.RoleUserUpdateInputDTO;
import com.correction.backend.modules.sys.entity.RoleUser;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Author：yao
 * @Description: 角色-用户关联表 转换类
 * @Date: 2022-11-12
 */

@Mapper
public interface MRoleUserConvert {

    MRoleUserConvert INSTANCE = Mappers.getMapper(MRoleUserConvert.class);

    RoleUser toRoleUser(RoleUserSearchInputDTO roleUserSearchInputDTO);

    RoleUser toRoleUser(RoleUserCreateInputDTO roleUserCreateInputDTO);

    RoleUser toRoleUser(RoleUserUpdateInputDTO roleUserUpdateInputDTO);

    RoleUserListOutputDTO toList(RoleUser roleUser);

    List<RoleUserListOutputDTO> toList(List<RoleUser> roleUsers);
}