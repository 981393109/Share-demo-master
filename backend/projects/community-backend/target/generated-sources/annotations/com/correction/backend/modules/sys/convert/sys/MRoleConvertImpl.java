package com.correction.backend.modules.sys.convert.sys;

import com.correction.backend.modules.sys.controller.dto.sys.RoleCreateInputDTO;
import com.correction.backend.modules.sys.controller.dto.sys.RoleListOutputDTO;
import com.correction.backend.modules.sys.controller.dto.sys.RoleSearchInputDTO;
import com.correction.backend.modules.sys.controller.dto.sys.RoleUpdateInputDTO;
import com.correction.backend.modules.sys.entity.Role;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-13T00:07:31+0800",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 1.8.0_211 (Oracle Corporation)"
)
public class MRoleConvertImpl implements MRoleConvert {

    @Override
    public Role toRole(RoleSearchInputDTO roleSearchInputDTO) {
        if ( roleSearchInputDTO == null ) {
            return null;
        }

        Role role = new Role();

        role.setCreateTime( roleSearchInputDTO.getCreateTime() );
        role.setUpdateTime( roleSearchInputDTO.getUpdateTime() );
        role.setCreator( roleSearchInputDTO.getCreator() );
        role.setUpdater( roleSearchInputDTO.getUpdater() );
        role.setDeleted( roleSearchInputDTO.getDeleted() );
        role.setRoleName( roleSearchInputDTO.getRoleName() );
        role.setDescription( roleSearchInputDTO.getDescription() );

        return role;
    }

    @Override
    public Role toRole(RoleCreateInputDTO roleCreateInputDTO) {
        if ( roleCreateInputDTO == null ) {
            return null;
        }

        Role role = new Role();

        role.setCreateTime( roleCreateInputDTO.getCreateTime() );
        role.setUpdateTime( roleCreateInputDTO.getUpdateTime() );
        role.setCreator( roleCreateInputDTO.getCreator() );
        role.setUpdater( roleCreateInputDTO.getUpdater() );
        role.setDeleted( roleCreateInputDTO.getDeleted() );
        role.setRoleName( roleCreateInputDTO.getRoleName() );
        role.setDescription( roleCreateInputDTO.getDescription() );

        return role;
    }

    @Override
    public Role toRole(RoleUpdateInputDTO roleUpdateInputDTO) {
        if ( roleUpdateInputDTO == null ) {
            return null;
        }

        Role role = new Role();

        role.setCreateTime( roleUpdateInputDTO.getCreateTime() );
        role.setUpdateTime( roleUpdateInputDTO.getUpdateTime() );
        role.setCreator( roleUpdateInputDTO.getCreator() );
        role.setUpdater( roleUpdateInputDTO.getUpdater() );
        role.setDeleted( roleUpdateInputDTO.getDeleted() );
        role.setId( roleUpdateInputDTO.getId() );
        role.setRoleName( roleUpdateInputDTO.getRoleName() );
        role.setDescription( roleUpdateInputDTO.getDescription() );

        return role;
    }

    @Override
    public RoleListOutputDTO toList(Role role) {
        if ( role == null ) {
            return null;
        }

        RoleListOutputDTO roleListOutputDTO = new RoleListOutputDTO();

        roleListOutputDTO.setId( role.getId() );
        roleListOutputDTO.setRoleName( role.getRoleName() );
        roleListOutputDTO.setDescription( role.getDescription() );
        roleListOutputDTO.setCreateTime( role.getCreateTime() );
        roleListOutputDTO.setUpdateTime( role.getUpdateTime() );
        roleListOutputDTO.setCreator( role.getCreator() );
        roleListOutputDTO.setUpdater( role.getUpdater() );
        roleListOutputDTO.setDeleted( role.getDeleted() );

        return roleListOutputDTO;
    }

    @Override
    public List<RoleListOutputDTO> toList(List<Role> roles) {
        if ( roles == null ) {
            return null;
        }

        List<RoleListOutputDTO> list = new ArrayList<RoleListOutputDTO>( roles.size() );
        for ( Role role : roles ) {
            list.add( toList( role ) );
        }

        return list;
    }
}
