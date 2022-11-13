package com.correction.backend.modules.sys.service;

import com.correction.backend.modules.sys.controller.dto.sys.RoleCreateInputDTO;
import com.correction.backend.modules.sys.controller.dto.sys.RoleSearchInputDTO;
import com.correction.backend.modules.sys.controller.dto.sys.RoleUpdateInputDTO;
import com.correction.backend.modules.sys.entity.Menu;
import com.correction.backend.modules.sys.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;
import com.correction.backend.modules.sys.entity.SysUserDO;
import com.correction.framework.common.pojo.PageResult;

import java.util.List;

/**
 * <p>
 * 角色-用户关联表 服务类
 * </p>
 *
 * @author yao
 * @since 2022-11-12
 */
public interface RoleService extends IService<Role> {

    /**
     * 新增角色
     */
    Long createRole (RoleCreateInputDTO reqDTO);

    /**
     * 修改角色
     */
    Role updateRole (RoleUpdateInputDTO reqDTO);

    /**
     * 查看详情
     */
    Role get (Long id);

    /**
     * 删除角色
     */
    void delete (Long id );

    /**
     * 获取所有角色列表(未分页)
     */
    List<Role>  getList (RoleSearchInputDTO searchInputDTO);

    /**
     * 分页获取列表
     */
    PageResult<Role> getPageList (RoleSearchInputDTO searchInputDTO);

    /**
     * 得到角色下所有用户信息
     */
    List<SysUserDO> getUserInfoByRoleId (Long id );

    /**
     * 得到角色下所有菜单信息
     */
    List<Menu> getMenuByRoleId (Long id);

}
