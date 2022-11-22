package com.correction.backend.modules.flow.service;

import com.correction.backend.modules.flow.controller.dto.FlowNodeListDTO;
import com.correction.backend.modules.flow.controller.dto.FlowOrgRoleDTO;
import com.correction.backend.modules.flow.entity.FlowNodeUser;

import java.util.List;

/**
 * 流程用户相关接口
 */
public interface FlowUserService {

    /**
     * 获取审批级联    机构     角色
     */
    List<FlowOrgRoleDTO> getFlowOrgInfo ();


    List<FlowNodeListDTO> getFlowNode(String flowType);
}
