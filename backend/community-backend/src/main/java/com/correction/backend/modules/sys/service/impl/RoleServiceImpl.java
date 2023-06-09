package com.correction.backend.modules.sys.service.impl;


import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.correction.backend.modules.sys.controller.dto.sys.RoleCreateInputDTO;
import com.correction.backend.modules.sys.controller.dto.sys.RoleSearchInputDTO;
import com.correction.backend.modules.sys.controller.dto.sys.RoleUpdateInputDTO;
import com.correction.backend.modules.sys.controller.dto.sys.SaveRoleMenuDTO;
import com.correction.backend.modules.sys.convert.sys.MRoleConvert;
import com.correction.backend.modules.sys.entity.*;
import com.correction.backend.modules.sys.mapper.OrgMapper;
import com.correction.backend.modules.sys.mapper.RoleMenuMapper;
import com.correction.backend.modules.sys.mapper.RoleUserMapper;
import com.correction.backend.modules.sys.service.RoleService;
import com.correction.backend.modules.sys.mapper.RoleMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.correction.framework.common.pojo.PageResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import static com.correction.backend.modules.sys.enums.SysErrorCodeConstants.ORG_NOT_FOUND;
import static com.correction.backend.modules.sys.enums.SysErrorCodeConstants.ROLE_NAME_DUPLICATE;
import static com.correction.framework.common.exception.util.ServiceExceptionUtil.exception;

/**
 * <p>
 * 角色-用户关联表 服务实现类
 * </p>
 *
 * @author yao
 * @since 2022-11-12
 */
@Service
@Slf4j
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {


    @Resource
    private RoleUserMapper roleUserMapper;

    @Resource
    private RoleMenuMapper roleMenuMapper;

    @Resource
    private OrgMapper orgMapper;

    @Override
    public Long createRole(RoleCreateInputDTO reqDTO) {
        //校验
        checkCreateOrUpdate(null,reqDTO.getRoleName(),reqDTO.getOrgId());
        Role role = MRoleConvert.INSTANCE.toRole(reqDTO);
        OrgDO orgDO = orgMapper.selectById(role.getOrgId());
        role.setOrgInfo(orgDO.getParentNames());
        baseMapper.insert(role);
        return role.getId();
    }

    @Override
    public Role updateRole(RoleUpdateInputDTO reqDTO) {
        checkCreateOrUpdate(reqDTO.getId(),reqDTO.getRoleName(),reqDTO.getOrgId());
        Role role = MRoleConvert.INSTANCE.toRole(reqDTO);
        OrgDO orgDO = orgMapper.selectById(role.getOrgId());
        role.setOrgInfo(orgDO.getParentNames());
        baseMapper.updateById(role);
        return role;
    }

    @Override
    public Role get(Long id) {
        Role role = baseMapper.selectById(id);
        return role;
    }

    @Override
    public void delete(Long id) {
        int i = baseMapper.deleteById(id);
    }

    @Override
    public List<Role> getList(RoleSearchInputDTO searchInputDTO) {
        List<Role> roles = baseMapper.selectList(searchInputDTO);
        return roles;
    }

    @Override
    public PageResult<Role> getPageList(RoleSearchInputDTO searchInputDTO) {
        PageResult<Role> rolePageResult = baseMapper.selectPage(searchInputDTO);
        return rolePageResult;
    }

    @Override
    public List<SysUserDO> getUserInfoByRoleId(Long id) {
        List<SysUserDO> sysUserDOS = roleUserMapper.getUserByRoleId(id);
        return sysUserDOS;
    }

    @Override
    public List<Menu> getMenuByRoleId(Long id) {
        List<Menu> menuByRoleId = roleMenuMapper.getMenuByRoleId(id);
        return menuByRoleId;
    }

    @Override
    public void saveRoleMenu(SaveRoleMenuDTO reqDTO) {
        Long roleId = reqDTO.getRoleId();
        //删除角色下所有关系
        roleMenuMapper.delete(Wrappers.<RoleMenu>lambdaQuery().eq(RoleMenu::getRoleId,roleId));
        //保存
        for (Long menuId : reqDTO.getMenuIds()) {
            RoleMenu roleMenu = new RoleMenu();
            roleMenu.setMenuId(menuId);
            roleMenu.setRoleId(roleId);
            roleMenuMapper.insert(roleMenu);
        }
    }


    /**
     * 校验必填项
     */
    private void checkCreateOrUpdate(Long id ,String roleName,Long orgId) {
        // 校验角色名称是否唯一
        this.checkRoleNameUnique(id, roleName);

        //org是否为空
        if(orgId == null){
            throw exception(ORG_NOT_FOUND,roleName);
        }
    }

    private void checkRoleNameUnique(Long id, String roleName) {
        if (StrUtil.isBlank(roleName)) {
            return;
        }
        Role role = baseMapper.selectOne("role_name",roleName);
        if (role == null) {
            return;
        }
        if (id == null) {
            throw exception(ROLE_NAME_DUPLICATE,roleName);
        }
        if (!role.getId().equals(id)) {
            throw exception(ROLE_NAME_DUPLICATE,roleName);
        }
    }


}
