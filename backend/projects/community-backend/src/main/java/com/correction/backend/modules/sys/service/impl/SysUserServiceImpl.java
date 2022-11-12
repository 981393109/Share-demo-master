package com.correction.backend.modules.sys.service.impl;

import com.correction.backend.modules.sys.controller.dto.user.SysUserCreateReqDTO;
import com.correction.backend.modules.sys.controller.dto.user.SysUserSearchDTO;
import com.correction.backend.modules.sys.controller.dto.user.SysUserUpdateReqDTO;
import com.correction.backend.modules.sys.convert.user.SysUserConvert;
import com.correction.backend.modules.sys.entity.SysUserDO;
import com.correction.backend.modules.sys.mapper.SysUserMapper;
import com.correction.backend.modules.sys.service.SysUserService;
import com.correction.framework.common.enums.CommonStatusEnum;
import com.correction.framework.common.pojo.PageResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class SysUserServiceImpl implements SysUserService {

    @Resource
    private SysUserMapper userMapper;

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
        this.checkCreateOrUpdate(null,reqVO.getUserName());
        // 插入用户
        SysUserDO user = SysUserConvert.INSTANCE.convert(reqVO);
        user.setStatus(CommonStatusEnum.ENABLE.getStatus()); // 默认开启
        user.setPassword(passwordEncoder.encode(reqVO.getPassword())); // 加密密码
        userMapper.insert(user);
        return user.getId();
    }

    @Override
    public void updateUser(SysUserUpdateReqDTO reqDTO) {
        // 校验正确性
        this.checkCreateOrUpdate(null,reqDTO.getUserName());
        // 修改用户
        SysUserDO user = SysUserConvert.INSTANCE.convert(reqDTO);
        userMapper.updateById(user);
    }


    @Override
    public void deleteUser(Long id) {
        // 删除用户
        userMapper.deleteById(id);
        // 删除用户关联数据
//        permissionService.processUserDeleted(id);
    }

    @Override
    public PageResult<SysUserDO> getUserPage(SysUserSearchDTO reqVO) {
        return userMapper.selectPage(reqVO);
    }

    private void checkCreateOrUpdate(Long id, String username) {
        // 校验用户存在
        // 校验用户名唯一
        // 校验手机号唯一
        // 校验邮箱唯一
    }


}
