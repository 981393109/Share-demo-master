package com.correction.backend.modules.sys.convert.sys;

import com.correction.backend.modules.sys.constant.SysConstant;
import com.correction.backend.modules.sys.controller.dto.sys.*;
import com.correction.backend.modules.sys.entity.OrgDO;
import com.correction.framework.common.util.collection.CollectionUtils;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author：yao
 * @Description: 组织表 转换类
 * @Date: 2022-11-12
 */
@Mapper
public interface MOrgConvert {

    MOrgConvert INSTANCE = Mappers.getMapper(MOrgConvert.class);

    OrgDO toOrg(OrgSearchInputDTO orgSearchInputDTO);

    OrgDO toOrg(OrgCreateInputDTO orgCreateInputDTO);

    OrgDO toOrg(OrgUpdateInputDTO orgUpdateInputDTO);

    OrgListOutputDTO toList(OrgDO org);

    List<OrgListOutputDTO> toList(List<OrgDO> orgs);

    OrgTreeDTO convertTreeNode(OrgDO orgDO);


    default List<OrgTreeDTO> buildMenuTree(List<OrgDO> orgDOList) {
        // 排序，保证菜单的有序性
        orgDOList.sort(Comparator.comparing(OrgDO::getPid));
        // 构建菜单树
        Map<Long, OrgTreeDTO> treeNodeMap = new LinkedHashMap<>();
        orgDOList.forEach(orgDO -> treeNodeMap.put(orgDO.getId(), MOrgConvert.INSTANCE.convertTreeNode(orgDO)));
        // 处理父子关系
        treeNodeMap.values().stream().filter(node -> !node.getPid().equals(SysConstant.ROOT_TOP)).forEach(childNode -> {
            // 获得父节点
            OrgTreeDTO parentNode = treeNodeMap.get(childNode.getPid());
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

    default List<OrgTreeDTO> buildMenuTreeV2(List<OrgDO> orgDOList) {
        // 排序，保证菜单的有序性
        orgDOList.sort(Comparator.comparing(OrgDO::getPid));
        // 构建菜单树
        Map<Long, OrgTreeDTO> treeNodeMap = new LinkedHashMap<>();
        orgDOList.forEach(orgDO -> treeNodeMap.put(orgDO.getId(), MOrgConvert.INSTANCE.convertTreeNode(orgDO)));
        // 处理父子关系
        treeNodeMap.values().stream().filter(node -> !node.getPid().equals(SysConstant.ROOT_TOP)).forEach(childNode -> {
            // 获得父节点
            OrgTreeDTO parentNode = treeNodeMap.get(childNode.getPid());
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
        Collection<OrgTreeDTO> values = treeNodeMap.values();
        return values.stream().collect(Collectors.toList());

    }

}