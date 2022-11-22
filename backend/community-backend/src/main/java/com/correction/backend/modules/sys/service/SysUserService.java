package com.correction.backend.modules.sys.service;

import com.correction.backend.modules.sys.controller.dto.user.SysUserCreateReqDTO;
import com.correction.backend.modules.sys.controller.dto.user.SysUserSearchDTO;
import com.correction.backend.modules.sys.controller.dto.user.SysUserUpdateReqDTO;
import com.correction.backend.modules.sys.entity.SysUserDO;
import com.correction.framework.common.pojo.PageResult;

import java.util.List;

public interface SysUserService {

    SysUserDO getUser(Long id);

    SysUserDO getUserByUsername(String username);

    /**
     * 根据工号查询用户信息
     */
    SysUserDO getUserByUserNumber(String userNumber);

    /**
     * 创建用户
     *
     * @param reqVO 用户信息
     * @return 用户编号
     */
    Long createUser(SysUserCreateReqDTO reqVO);


    /**
     * 修改用户
     *
     * @param reqVO 用户信息
     * @return 用户编号
     */
    void updateUser(SysUserUpdateReqDTO reqVO);

    /**
     * 删除用户
     *
     * @param id 用户编号
     */
    void deleteUser(Long id);


    /**
     * 分页查询用户信息
     * @param reqVO
     * @return
     */
    PageResult<SysUserDO> getUserPage(SysUserSearchDTO reqVO);

    /**
     * 列表
     * @param reqVO
     * @return
     */
    List<SysUserDO> getOrgUserList(SysUserSearchDTO reqVO);



}
