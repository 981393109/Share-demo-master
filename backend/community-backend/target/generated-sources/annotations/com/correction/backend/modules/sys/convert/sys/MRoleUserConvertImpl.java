package com.correction.backend.modules.sys.convert.sys;

import com.correction.backend.modules.sys.controller.dto.sys.RoleUserCreateInputDTO;
import com.correction.backend.modules.sys.controller.dto.sys.RoleUserListOutputDTO;
import com.correction.backend.modules.sys.controller.dto.sys.RoleUserSearchInputDTO;
import com.correction.backend.modules.sys.controller.dto.sys.RoleUserUpdateInputDTO;
import com.correction.backend.modules.sys.entity.RoleUser;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-22T03:43:43+0800",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 1.8.0_211 (Oracle Corporation)"
)
public class MRoleUserConvertImpl implements MRoleUserConvert {

    @Override
    public RoleUser toRoleUser(RoleUserSearchInputDTO roleUserSearchInputDTO) {
        if ( roleUserSearchInputDTO == null ) {
            return null;
        }

        RoleUser roleUser = new RoleUser();

        roleUser.setUserId( roleUserSearchInputDTO.getUserId() );
        roleUser.setRoleId( roleUserSearchInputDTO.getRoleId() );

        return roleUser;
    }

    @Override
    public RoleUser toRoleUser(RoleUserCreateInputDTO roleUserCreateInputDTO) {
        if ( roleUserCreateInputDTO == null ) {
            return null;
        }

        RoleUser roleUser = new RoleUser();

        roleUser.setUserId( roleUserCreateInputDTO.getUserId() );
        roleUser.setRoleId( roleUserCreateInputDTO.getRoleId() );

        return roleUser;
    }

    @Override
    public RoleUser toRoleUser(RoleUserUpdateInputDTO roleUserUpdateInputDTO) {
        if ( roleUserUpdateInputDTO == null ) {
            return null;
        }

        RoleUser roleUser = new RoleUser();

        roleUser.setId( roleUserUpdateInputDTO.getId() );
        roleUser.setUserId( roleUserUpdateInputDTO.getUserId() );
        roleUser.setRoleId( roleUserUpdateInputDTO.getRoleId() );

        return roleUser;
    }

    @Override
    public RoleUserListOutputDTO toList(RoleUser roleUser) {
        if ( roleUser == null ) {
            return null;
        }

        RoleUserListOutputDTO roleUserListOutputDTO = new RoleUserListOutputDTO();

        roleUserListOutputDTO.setId( roleUser.getId() );
        roleUserListOutputDTO.setUserId( roleUser.getUserId() );
        roleUserListOutputDTO.setRoleId( roleUser.getRoleId() );

        return roleUserListOutputDTO;
    }

    @Override
    public List<RoleUserListOutputDTO> toList(List<RoleUser> roleUsers) {
        if ( roleUsers == null ) {
            return null;
        }

        List<RoleUserListOutputDTO> list = new ArrayList<RoleUserListOutputDTO>( roleUsers.size() );
        for ( RoleUser roleUser : roleUsers ) {
            list.add( toList( roleUser ) );
        }

        return list;
    }
}
