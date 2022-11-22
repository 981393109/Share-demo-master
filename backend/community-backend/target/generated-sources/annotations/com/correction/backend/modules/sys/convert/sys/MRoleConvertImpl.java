package com.correction.backend.modules.sys.convert.sys;

import com.correction.backend.modules.sys.controller.dto.sys.RoleCreateInputDTO;
import com.correction.backend.modules.sys.controller.dto.sys.RoleListOutputDTO;
import com.correction.backend.modules.sys.controller.dto.sys.RoleSearchInputDTO;
import com.correction.backend.modules.sys.controller.dto.sys.RoleUpdateInputDTO;
import com.correction.backend.modules.sys.controller.dto.sys.RoleUserOutpuDTO;
import com.correction.backend.modules.sys.entity.Role;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-22T03:43:43+0800",
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
        role.setOrgId( roleSearchInputDTO.getOrgId() );
        if ( roleSearchInputDTO.getOrgInfo() != null ) {
            role.setOrgInfo( String.valueOf( roleSearchInputDTO.getOrgInfo() ) );
        }

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
        role.setOrgId( roleCreateInputDTO.getOrgId() );
        role.setOrgInfo( roleCreateInputDTO.getOrgInfo() );

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
        role.setOrgId( roleUpdateInputDTO.getOrgId() );
        role.setOrgInfo( roleUpdateInputDTO.getOrgInfo() );

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
        roleListOutputDTO.setOrgId( role.getOrgId() );
        roleListOutputDTO.setOrgInfo( role.getOrgInfo() );

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

    @Override
    public List<RoleUserOutpuDTO> toRoleUserList(List<Role> roles) {
        if ( roles == null ) {
            return null;
        }

        List<RoleUserOutpuDTO> list = new ArrayList<RoleUserOutpuDTO>( roles.size() );
        for ( Role role : roles ) {
            list.add( roleToRoleUserOutpuDTO( role ) );
        }

        return list;
    }

    protected RoleUserOutpuDTO roleToRoleUserOutpuDTO(Role role) {
        if ( role == null ) {
            return null;
        }

        RoleUserOutpuDTO roleUserOutpuDTO = new RoleUserOutpuDTO();

        roleUserOutpuDTO.setId( role.getId() );
        roleUserOutpuDTO.setRoleName( role.getRoleName() );
        roleUserOutpuDTO.setOrgId( role.getOrgId() );
        roleUserOutpuDTO.setOrgInfo( role.getOrgInfo() );

        return roleUserOutpuDTO;
    }
}
