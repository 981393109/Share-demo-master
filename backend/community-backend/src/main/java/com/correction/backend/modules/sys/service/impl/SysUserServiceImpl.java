package com.correction.backend.modules.sys.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.correction.backend.modules.sys.constant.SysConstant;
import com.correction.backend.modules.sys.controller.dto.user.SysUserCreateReqDTO;
import com.correction.backend.modules.sys.controller.dto.user.SysUserSearchDTO;
import com.correction.backend.modules.sys.controller.dto.user.SysUserUpdateReqDTO;
import com.correction.backend.modules.sys.convert.user.SysUserConvert;
import com.correction.backend.modules.sys.entity.OrgDO;
import com.correction.backend.modules.sys.entity.Role;
import com.correction.backend.modules.sys.entity.RoleUser;
import com.correction.backend.modules.sys.entity.SysUserDO;
import com.correction.backend.modules.sys.mapper.OrgMapper;
import com.correction.backend.modules.sys.mapper.RoleMapper;
import com.correction.backend.modules.sys.mapper.RoleUserMapper;
import com.correction.backend.modules.sys.mapper.SysUserMapper;
import com.correction.backend.modules.sys.service.SysUserService;
import com.correction.framework.common.enums.CommonStatusEnum;
import com.correction.framework.common.pojo.PageResult;
import com.google.common.annotations.VisibleForTesting;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.List;

import static com.correction.backend.modules.sys.enums.SysErrorCodeConstants.*;
import static com.correction.framework.common.exception.util.ServiceExceptionUtil.exception;

@Service
@Slf4j
public class SysUserServiceImpl implements SysUserService {

    @Resource
    private SysUserMapper userMapper;

    @Resource
    private OrgMapper orgMapper;

    @Resource
    private RoleMapper roleMapper;

    @Resource
    private RoleUserMapper roleUserMapper;

    @Resource
    private PasswordEncoder passwordEncoder;


    @Override
    public SysUserDO getUser(Long id) {
        return userMapper.selectById(id);
    }

    @Override
    public SysUserDO getUserByUsername(String username) {
        return userMapper.selectByUserName(username);
    }

    @Override
    public SysUserDO getUserByUserNumber(String userNumber) {
        return userMapper.selectByUserNumber(userNumber);
    }

    @Override
    public Long createUser(SysUserCreateReqDTO reqVO) {
        // 校验正确性
        this.checkCreateOrUpdate(null,reqVO.getOrgId(),reqVO.getRoleId(),reqVO.getUserName());
        // 插入用户
        SysUserDO user = SysUserConvert.INSTANCE.convert(reqVO);
        user.setStatus(CommonStatusEnum.ENABLE.getStatus()); // 默认开启
        user.setPassword(passwordEncoder.encode(reqVO.getPassword())); // 加密密码
        OrgDO orgDO = orgMapper.selectById(reqVO.getOrgId());
        user.setOrgParentInfo(orgDO.getParentNames());
        //新增用户和角色关联关系表：
        userMapper.insert(user);
        saveRoleUser(user);
        return user.getId();
    }

    @Override
    public void updateUser(SysUserUpdateReqDTO reqDTO) {
        // 校验正确性
        this.checkCreateOrUpdate(reqDTO.getId(),reqDTO.getOrgId(),reqDTO.getRoleId(),reqDTO.getUserName());
        // 修改用户
        SysUserDO user = SysUserConvert.INSTANCE.convert(reqDTO);
        OrgDO orgDO = orgMapper.selectById(reqDTO.getOrgId());
        user.setOrgParentInfo(orgDO.getParentNames());
        saveRoleUser(user);
        userMapper.updateById(user);
    }


    @Override
    public void deleteUser(Long id) {
        //删除用户
        userMapper.deleteById(id);
        //删除角色关联关系
        roleUserMapper.delete(Wrappers.<RoleUser>lambdaQuery().eq(RoleUser::getUserId,id));
    }

    @Override
    public PageResult<SysUserDO> getUserPage(SysUserSearchDTO reqVO) {
        return userMapper.selectPage(reqVO);
    }

    @Override
    public List<SysUserDO> getOrgUserList(SysUserSearchDTO reqVO) {
        Long orgId = reqVO.getOrgId();
        //得到org下的用户
        List<SysUserDO> sysUserDOS = userMapper.selectList(Wrappers.<SysUserDO>lambdaQuery().eq(SysUserDO::getOrgId, orgId));
        return sysUserDOS;
    }


    private void saveRoleUser (SysUserDO userDO){
        //删除用户下所有角色
        roleUserMapper.delete(Wrappers.<RoleUser>lambdaQuery().eq(RoleUser::getUserId,userDO.getId()));
        //新增关联关系
        RoleUser roleUser = new RoleUser();
        roleUser.setUserId(userDO.getId());
        roleUser.setRoleId(userDO.getRoleId());
        roleUserMapper.insert(roleUser);
    }


    private void checkCreateOrUpdate(Long id, Long orgId,Long roleId,String userNumber) {
        // 校验工号唯一
        checkUserNumUnique(id ,userNumber);
        //校验是否有选择组织架构
        checkUserOrg(orgId);
        //校验是否有选择角色
        checkUserRole(roleId);
    }

    private void checkUserRole(Long roleId) {
        if(roleId == null) {
            throw exception(USER_ROLE_IS_NOT_EXSIT);
        }
        Role role = roleMapper.selectById(roleId);
        if (role == null) {
            throw exception(USER_ROLE_IS_NOT_EXSIT);
        }
    }

    @VisibleForTesting
    private void checkUserOrg(Long orgId) {
        if(orgId == null) {
            throw exception(USER_ORG_IS_NOT_EXSIT);
        }
        OrgDO orgDO = orgMapper.selectById(orgId);
        if (orgDO == null) {
            throw exception(USER_ORG_IS_NOT_EXSIT);
        }
    }


    @VisibleForTesting
    void checkUserNumUnique(Long id, String userNumber) {
        if (StrUtil.isBlank(userNumber)) {
            return;
        }
        SysUserDO userDO = userMapper.selectOne("user_number",userNumber);
        if (userDO == null) {
            return;
        }
        // 如果 id 为空，说明不用比较是否为相同 id 的用户
        if (id == null) {
            throw exception(USER_USERNAME_EXISTS);
        }
        if (!userDO.getId().equals(id)) {
            throw exception(USER_USERNAME_EXISTS);
        }
    }


}
