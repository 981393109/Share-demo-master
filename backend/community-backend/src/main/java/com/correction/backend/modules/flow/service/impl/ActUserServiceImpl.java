package com.correction.backend.modules.flow.service.impl;

import com.correction.backend.modules.sys.entity.SysUserDO;
import com.correction.backend.modules.sys.mapper.SysUserMapper;
import com.correction.framework.workflow.service.ActUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class ActUserServiceImpl implements ActUserService {

    @Resource
    private SysUserMapper sysUserMapper;

    @Override
    public String getNickNameByUserId(String userId) {
        SysUserDO userDO = sysUserMapper.selectById(Long.parseLong(userId));
        return userDO.getUserName();
    }

    @Override
    public List<String> getRoleIdsAndDeptId(String userId) {
        return null;
    }

}
