package com.correction.backend.modules.sys.convert.sys;

import com.correction.backend.modules.sys.controller.dto.sys.RoleMenuCreateInputDTO;
import com.correction.backend.modules.sys.controller.dto.sys.RoleMenuListOutputDTO;
import com.correction.backend.modules.sys.controller.dto.sys.RoleMenuSearchInputDTO;
import com.correction.backend.modules.sys.controller.dto.sys.RoleMenuUpdateInputDTO;
import com.correction.backend.modules.sys.entity.RoleMenu;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-24T23:49:00+0800",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 1.8.0_211 (Oracle Corporation)"
)
public class MRoleMenuConvertImpl implements MRoleMenuConvert {

    @Override
    public RoleMenu toRoleMenu(RoleMenuSearchInputDTO roleMenuSearchInputDTO) {
        if ( roleMenuSearchInputDTO == null ) {
            return null;
        }

        RoleMenu roleMenu = new RoleMenu();

        roleMenu.setRoleId( roleMenuSearchInputDTO.getRoleId() );
        roleMenu.setMenuId( roleMenuSearchInputDTO.getMenuId() );

        return roleMenu;
    }

    @Override
    public RoleMenu toRoleMenu(RoleMenuCreateInputDTO roleMenuCreateInputDTO) {
        if ( roleMenuCreateInputDTO == null ) {
            return null;
        }

        RoleMenu roleMenu = new RoleMenu();

        roleMenu.setRoleId( roleMenuCreateInputDTO.getRoleId() );
        roleMenu.setMenuId( roleMenuCreateInputDTO.getMenuId() );

        return roleMenu;
    }

    @Override
    public RoleMenu toRoleMenu(RoleMenuUpdateInputDTO roleMenuUpdateInputDTO) {
        if ( roleMenuUpdateInputDTO == null ) {
            return null;
        }

        RoleMenu roleMenu = new RoleMenu();

        roleMenu.setId( roleMenuUpdateInputDTO.getId() );
        roleMenu.setRoleId( roleMenuUpdateInputDTO.getRoleId() );
        roleMenu.setMenuId( roleMenuUpdateInputDTO.getMenuId() );

        return roleMenu;
    }

    @Override
    public RoleMenuListOutputDTO toList(RoleMenu roleMenu) {
        if ( roleMenu == null ) {
            return null;
        }

        RoleMenuListOutputDTO roleMenuListOutputDTO = new RoleMenuListOutputDTO();

        roleMenuListOutputDTO.setId( roleMenu.getId() );
        roleMenuListOutputDTO.setRoleId( roleMenu.getRoleId() );
        roleMenuListOutputDTO.setMenuId( roleMenu.getMenuId() );

        return roleMenuListOutputDTO;
    }

    @Override
    public List<RoleMenuListOutputDTO> toList(List<RoleMenu> roleMenus) {
        if ( roleMenus == null ) {
            return null;
        }

        List<RoleMenuListOutputDTO> list = new ArrayList<RoleMenuListOutputDTO>( roleMenus.size() );
        for ( RoleMenu roleMenu : roleMenus ) {
            list.add( toList( roleMenu ) );
        }

        return list;
    }
}
