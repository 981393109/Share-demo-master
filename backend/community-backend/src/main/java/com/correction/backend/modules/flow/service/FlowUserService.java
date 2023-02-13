package com.correction.backend.modules.flow.service;

import com.correction.backend.modules.flow.controller.dto.FlowNodeListDTO;
import com.correction.backend.modules.flow.controller.dto.FlowOrgRoleDTO;
import com.correction.backend.modules.flow.controller.dto.FlowUserListDTO;
import com.correction.backend.modules.flow.entity.FlowNodeUser;
import com.correction.backend.modules.sys.entity.OrgDO;

import java.util.List;
import java.util.Map;

/**
 * 流程用户相关接口
 */
public interface FlowUserService {

    /**
     * 获取审批级联    机构     角色
     */
    Map<FlowNodeListDTO,List<FlowOrgRoleDTO>> getFlowOrgInfo (String type);


    List<FlowNodeListDTO> getFlowNode(String flowType,Long dataId);


    List<FlowOrgRoleDTO> getOrgRoleInfo(List<OrgDO> list);

    List<FlowUserListDTO> getFlowNodeLink(String flowType, Long dataId);
}
