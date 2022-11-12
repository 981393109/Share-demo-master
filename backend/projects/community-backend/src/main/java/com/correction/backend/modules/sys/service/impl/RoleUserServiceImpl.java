package com.correction.backend.modules.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.correction.backend.modules.sys.service.RoleUserService;
import com.correction.backend.modules.sys.entity.RoleUser;
import com.correction.backend.modules.sys.mapper.RoleUserMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色-用户关联表 服务实现类
 * </p>
 *
 * @author yao
 * @since 2022-11-12
 */
@Service
public class RoleUserServiceImpl extends ServiceImpl<RoleUserMapper, RoleUser> implements RoleUserService {



}
