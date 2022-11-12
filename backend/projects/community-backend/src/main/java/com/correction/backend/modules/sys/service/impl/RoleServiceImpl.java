package com.correction.backend.modules.sys.service.impl;


import com.correction.backend.modules.sys.service.RoleService;
import com.correction.backend.modules.sys.entity.Role;
import com.correction.backend.modules.sys.mapper.RoleMapper;
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
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {



}
