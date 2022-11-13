package com.correction.backend.modules.sys.service;

import com.correction.backend.modules.sys.controller.dto.sys.MenuSearchInputDTO;
import com.correction.backend.modules.sys.entity.Menu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yao
 * @since 2022-11-12
 */
public interface MenuService extends IService<Menu> {

    /**
     * 获取所有菜单集合
     */
    List<Menu> getList (MenuSearchInputDTO searchInputDTO);

}
