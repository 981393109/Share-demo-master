package com.correction.backend.modules.sys.mapper;

import com.correction.backend.modules.sys.entity.Role;
import com.correction.backend.modules.sys.entity.RoleUser;
import com.correction.backend.modules.sys.entity.SysUserDO;
import com.correction.frameworks.mybatis.mybatis.core.mapper.BaseMapperX;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 角色-用户关联表 Mapper 接口
 * </p>
 *
 * @author yao
 * @since 2022-11-12
 */
public interface RoleUserMapper extends BaseMapperX<RoleUser> {

    List<SysUserDO> getUserByRoleId (@Param("roleId") Long roleId);

    List<Role> getRoleByUserId (@Param("userId") Long userId);
}
