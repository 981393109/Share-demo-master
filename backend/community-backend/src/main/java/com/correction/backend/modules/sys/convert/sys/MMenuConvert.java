package com.correction.backend.modules.sys.convert.sys;

import com.correction.backend.modules.sys.constant.SysConstant;
import com.correction.backend.modules.sys.controller.dto.sys.*;
import com.correction.backend.modules.sys.entity.Menu;
import com.correction.framework.common.util.collection.CollectionUtils;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.slf4j.LoggerFactory;

import java.util.*;

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

    /**
     * 树结构
     */
    MenuTreeDTO convertTreeNode(Menu menu);


    default List<MenuTreeDTO> buildMenuTree(Collection<Menu> menuList) {
        // 排序，保证菜单的有序性
        menuList.stream().sorted(Comparator.comparing(Menu::getSort));
        // 构建菜单树
        Map<Long, MenuTreeDTO> treeNodeMap = new LinkedHashMap<>();
        menuList.forEach(orgDO -> treeNodeMap.put(orgDO.getId(), MMenuConvert.INSTANCE.convertTreeNode(orgDO)));
        // 处理父子关系
        treeNodeMap.values().stream().filter(node -> !node.getPid().equals(SysConstant.ROOT_TOP)).forEach(childNode -> {
            // 获得父节点
            MenuTreeDTO parentNode = treeNodeMap.get(childNode.getPid());
            if (parentNode == null) {
                LoggerFactory.getLogger(getClass()).error("[buildRouterTree][resource({}) 找不到父资源({})]",
                        childNode.getId(), childNode.getPid());
                return;
            }
            // 将自己添加到父节点中
            if (parentNode.getChildren() == null) {
                parentNode.setChildren(new ArrayList<>());
            }
            parentNode.getChildren().add(childNode);
        });
        // 获得到所有的根节点
        return CollectionUtils.filterList(treeNodeMap.values(), node -> SysConstant.ROOT_TOP.equals(node.getPid()));
    }

}