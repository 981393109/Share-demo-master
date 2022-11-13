package com.correction.backend.modules.sys.service.impl;

import com.correction.backend.modules.sys.controller.dto.sys.MenuSearchInputDTO;
import com.correction.backend.modules.sys.service.MenuService;
import com.correction.backend.modules.sys.entity.Menu;
import com.correction.backend.modules.sys.mapper.MenuMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yao
 * @since 2022-11-12
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {


    @Override
    public List<Menu> getList(MenuSearchInputDTO searchInputDTO) {
        List<Menu> menus = baseMapper.selectList();
        return menus;
    }
}
