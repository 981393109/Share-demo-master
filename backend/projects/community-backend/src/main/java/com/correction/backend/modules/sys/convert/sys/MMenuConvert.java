package com.correction.backend.modules.sys.convert.sys;

import com.correction.backend.modules.sys.controller.dto.sys.MenuCreateInputDTO;
import com.correction.backend.modules.sys.controller.dto.sys.MenuListOutputDTO;
import com.correction.backend.modules.sys.controller.dto.sys.MenuSearchInputDTO;
import com.correction.backend.modules.sys.controller.dto.sys.MenuUpdateInputDTO;
import com.correction.backend.modules.sys.entity.Menu;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Author：yao
 * @Description:  转换类
 * @Date: 2022-11-12
 */

@Mapper
public interface MMenuConvert {

    MMenuConvert INSTANCE = Mappers.getMapper(MMenuConvert.class);

    Menu toMenu(MenuSearchInputDTO menuSearchInputDTO);

    Menu toMenu(MenuCreateInputDTO menuCreateInputDTO);

    Menu toMenu(MenuUpdateInputDTO menuUpdateInputDTO);

    MenuListOutputDTO toList(Menu menu);

    List<MenuListOutputDTO> toList(List<Menu> menus);
}