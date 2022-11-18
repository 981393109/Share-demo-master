package com.correction.backend.modules.flow.service.impl;

import com.correction.backend.modules.flow.controller.dto.FlowOrgRoleDTO;
import com.correction.backend.modules.flow.service.FlowUserService;
import com.correction.backend.modules.sys.controller.dto.sys.RoleListOutputDTO;
import com.correction.backend.modules.sys.controller.dto.sys.RoleUserOutpuDTO;
import com.correction.backend.modules.sys.controller.dto.user.SysUserRoleDTO;
import com.correction.backend.modules.sys.convert.sys.MRoleConvert;
import com.correction.backend.modules.sys.convert.user.SysUserConvert;
import com.correction.backend.modules.sys.dal.redis.SysLoginUserRedisDAO;
import com.correction.backend.modules.sys.entity.OrgDO;
import com.correction.backend.modules.sys.entity.Role;
import com.correction.backend.modules.sys.entity.SysUserDO;
import com.correction.backend.modules.sys.mapper.RoleMapper;
import com.correction.backend.modules.sys.mapper.RoleUserMapper;
import com.correction.backend.modules.sys.service.OrgService;
import com.correction.framework.security.core.LoginUser;
import com.correction.framework.web.web.core.util.WebFrameworkUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class FlowUserServiceImpl implements FlowUserService {

    @Resource
    SysLoginUserRedisDAO sysLoginUserRedisDAO;

    @Resource
    OrgService orgService;

    @Resource
    RoleMapper roleMapper;

    @Resource
    RoleUserMapper roleUserMapper;

    @Override
    public List<FlowOrgRoleDTO> getFlowOrgInfo() {
        //得到当前登录用户信息：
        //得到当前用户所在组织
        Long orgId = WebFrameworkUtils.getLoginOrgId();
        List<FlowOrgRoleDTO> flowOrgRoleDTOS = new ArrayList<>();
        //得到组织以及组织下所有子组织数据
        List<OrgDO> orgChildsList = orgService.getOrgParentList(orgId);
        for (OrgDO orgDO : orgChildsList) {
            FlowOrgRoleDTO flowOrgRoleDTO = new FlowOrgRoleDTO();
            //得到orgDO下的角色
            Long id = orgDO.getId();
            //得到org下的角色信息
            List<Role> roleByOrgId = roleMapper.findRoleByOrgId(id);
            List<RoleUserOutpuDTO> roleUserOutpuDTOS = MRoleConvert.INSTANCE.toRoleUserList(roleByOrgId);
            flowOrgRoleDTO.setOrgId(id);
            flowOrgRoleDTO.setOrgName(orgDO.getOrgName());
            flowOrgRoleDTO.setRoleList(roleUserOutpuDTOS);
            flowOrgRoleDTOS.add(flowOrgRoleDTO);
            for (RoleUserOutpuDTO roleUserOutpuDTO : roleUserOutpuDTOS) {
                List<SysUserDO> sysUserDOS = roleUserMapper.getUserByRoleId(roleUserOutpuDTO.getId());
                List<SysUserRoleDTO> sysUserRoleDTOS = SysUserConvert.INSTANCE.convertUserInfo(sysUserDOS);
                roleUserOutpuDTO.setUserList(sysUserRoleDTOS);
            }
        }
        return flowOrgRoleDTOS;
    }



}
