package com.correction.backend.modules.sys.convert.sys;

import com.correction.backend.modules.sys.controller.dto.sys.MenuCreateInputDTO;
import com.correction.backend.modules.sys.controller.dto.sys.MenuListOutputDTO;
import com.correction.backend.modules.sys.controller.dto.sys.MenuSearchInputDTO;
import com.correction.backend.modules.sys.controller.dto.sys.MenuUpdateInputDTO;
import com.correction.backend.modules.sys.entity.Menu;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-13T00:07:31+0800",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 1.8.0_211 (Oracle Corporation)"
)
public class MMenuConvertImpl implements MMenuConvert {

    @Override
    public Menu toMenu(MenuSearchInputDTO menuSearchInputDTO) {
        if ( menuSearchInputDTO == null ) {
            return null;
        }

        Menu menu = new Menu();

        menu.setMenuName( menuSearchInputDTO.getMenuName() );
        menu.setPermission( menuSearchInputDTO.getPermission() );
        menu.setType( menuSearchInputDTO.getType() );
        menu.setSort( menuSearchInputDTO.getSort() );
        menu.setParentid( menuSearchInputDTO.getParentid() );
        menu.setPath( menuSearchInputDTO.getPath() );
        menu.setIcon( menuSearchInputDTO.getIcon() );
        menu.setStatus( menuSearchInputDTO.getStatus() );

        return menu;
    }

    @Override
    public Menu toMenu(MenuCreateInputDTO menuCreateInputDTO) {
        if ( menuCreateInputDTO == null ) {
            return null;
        }

        Menu menu = new Menu();

        menu.setMenuName( menuCreateInputDTO.getMenuName() );
        menu.setPermission( menuCreateInputDTO.getPermission() );
        menu.setType( menuCreateInputDTO.getType() );
        menu.setSort( menuCreateInputDTO.getSort() );
        menu.setParentid( menuCreateInputDTO.getParentid() );
        menu.setPath( menuCreateInputDTO.getPath() );
        menu.setIcon( menuCreateInputDTO.getIcon() );
        menu.setStatus( menuCreateInputDTO.getStatus() );

        return menu;
    }

    @Override
    public Menu toMenu(MenuUpdateInputDTO menuUpdateInputDTO) {
        if ( menuUpdateInputDTO == null ) {
            return null;
        }

        Menu menu = new Menu();

        menu.setId( menuUpdateInputDTO.getId() );
        menu.setMenuName( menuUpdateInputDTO.getMenuName() );
        menu.setPermission( menuUpdateInputDTO.getPermission() );
        menu.setType( menuUpdateInputDTO.getType() );
        menu.setSort( menuUpdateInputDTO.getSort() );
        menu.setParentid( menuUpdateInputDTO.getParentid() );
        menu.setPath( menuUpdateInputDTO.getPath() );
        menu.setIcon( menuUpdateInputDTO.getIcon() );
        menu.setStatus( menuUpdateInputDTO.getStatus() );

        return menu;
    }

    @Override
    public MenuListOutputDTO toList(Menu menu) {
        if ( menu == null ) {
            return null;
        }

        MenuListOutputDTO menuListOutputDTO = new MenuListOutputDTO();

        menuListOutputDTO.setId( menu.getId() );
        menuListOutputDTO.setMenuName( menu.getMenuName() );
        menuListOutputDTO.setPermission( menu.getPermission() );
        menuListOutputDTO.setType( menu.getType() );
        menuListOutputDTO.setSort( menu.getSort() );
        menuListOutputDTO.setParentid( menu.getParentid() );
        menuListOutputDTO.setPath( menu.getPath() );
        menuListOutputDTO.setIcon( menu.getIcon() );
        menuListOutputDTO.setStatus( menu.getStatus() );

        return menuListOutputDTO;
    }

    @Override
    public List<MenuListOutputDTO> toList(List<Menu> menus) {
        if ( menus == null ) {
            return null;
        }

        List<MenuListOutputDTO> list = new ArrayList<MenuListOutputDTO>( menus.size() );
        for ( Menu menu : menus ) {
            list.add( toList( menu ) );
        }

        return list;
    }
}
