package com.correction.backend.modules.flow.service.impl;

import com.correction.backend.modules.cases.entity.CasesPunishment;
import com.correction.backend.modules.cases.entity.RewardRecord;
import com.correction.backend.modules.cases.mapper.CasesPunishmentMapper;
import com.correction.backend.modules.cases.mapper.RewardRecordMapper;
import com.correction.backend.modules.cases.service.RewardRecordService;
import com.correction.backend.modules.flow.constant.FlowConstant;
import com.correction.backend.modules.flow.controller.dto.FlowNodeListDTO;
import com.correction.backend.modules.flow.controller.dto.FlowOrgRoleDTO;
import com.correction.backend.modules.flow.controller.dto.FlowUserListDTO;
import com.correction.backend.modules.flow.mapper.FlowCenterMapper;
import com.correction.backend.modules.flow.service.FlowUserService;
import com.correction.backend.modules.handleCorrection.entity.HandleCorrection;
import com.correction.backend.modules.handleCorrection.service.HandleCorrectionService;
import com.correction.backend.modules.sys.constant.SysConstant;
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
import com.correction.framework.web.web.core.util.WebFrameworkUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

import static com.correction.backend.modules.flow.constant.FlowConstant.*;

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

    @Resource
    FlowCenterMapper flowCenterMapper;

    @Resource
    HandleCorrectionService handleCorrectionService;

    @Resource
    RewardRecordMapper rewardRecordMapper;

    @Resource
    CasesPunishmentMapper casesPunishmentMapper;

    @Override
    public Map<FlowNodeListDTO,List<FlowOrgRoleDTO>> getFlowOrgInfo(String type) {
        Long loginOrgId = WebFrameworkUtils.getLoginOrgId();
        Map<FlowNodeListDTO,List<FlowOrgRoleDTO>> result = new LinkedHashMap<>();
        List<FlowOrgRoleDTO> flowOrgRoleDTOS = new ArrayList<>();
        List<FlowNodeListDTO> flowNode = getFlowNode(type,null);
        //得到组织以及组织下所有子组织数据
        Set<OrgDO> set = orgService.getTreeByUserOrgId(loginOrgId);
        List<OrgDO> list = new ArrayList<>();
        list.addAll(set);
        extracted(flowOrgRoleDTOS, list);
        List<FlowOrgRoleDTO> topOrg = flowOrgRoleDTOS.stream().filter(e -> SysConstant.ORG_0.equals(e.getOrgType()) || SysConstant.ORG_1.equals(e.getOrgType())).collect(Collectors.toList());
        List<FlowOrgRoleDTO> lowOrg = flowOrgRoleDTOS.stream().filter(e -> SysConstant.ORG_2.equals(e.getOrgType())).collect(Collectors.toList());
        switch (type) {
            case SURVEY_FLOW:
                for (int i = 0; i < flowNode.size(); i++) {
                    if (i == 0 || i == 1) {
                        result.put(flowNode.get(i),topOrg);
                    } else {
                        result.put(flowNode.get(i),lowOrg);
                    }
                }
            break;
            case HANDLE_CORRECTION_FLOW:
                for (int i = 0; i < flowNode.size(); i++) {
                    if (i < 8) {
                        result.put(flowNode.get(i),topOrg);
                    } else {
                        result.put(flowNode.get(i),lowOrg);
                    }
                }
            break;
        }
        return result;
    }

    private void extracted(List<FlowOrgRoleDTO> flowOrgRoleDTOS, List<OrgDO> list) {
        for (OrgDO orgDO : list) {
            FlowOrgRoleDTO flowOrgRoleDTO = new FlowOrgRoleDTO();
            //得到orgDO下的角色
            Long id = orgDO.getId();
            //得到org下的角色信息
            List<Role> roleByOrgId = roleMapper.findRoleByOrgId(id);
            List<RoleUserOutpuDTO> roleUserOutpuDTOS = MRoleConvert.INSTANCE.toRoleUserList(roleByOrgId);
            flowOrgRoleDTO.setOrgId(id);
            flowOrgRoleDTO.setOrgType(orgDO.getOrgType());
            flowOrgRoleDTO.setOrgName(orgDO.getOrgName());
            flowOrgRoleDTO.setRoleList(roleUserOutpuDTOS);
            flowOrgRoleDTOS.add(flowOrgRoleDTO);
            for (RoleUserOutpuDTO roleUserOutpuDTO : roleUserOutpuDTOS) {
                List<SysUserDO> sysUserDOS = roleUserMapper.getUserByRoleId(roleUserOutpuDTO.getId());
                List<SysUserRoleDTO> sysUserRoleDTOS = SysUserConvert.INSTANCE.convertUserInfo(sysUserDOS);
                roleUserOutpuDTO.setUserList(sysUserRoleDTOS);
            }
        }
    }

    @Override
    public List<FlowNodeListDTO> getFlowNode(String flowType,Long dataId) {
        Long loginOrgId = WebFrameworkUtils.getLoginOrgId();
        List<FlowNodeListDTO> nodeList = flowCenterMapper.getNodeList(flowType);
        List<FlowOrgRoleDTO> flowOrgRoleDTOS = new ArrayList<>();
        Set<OrgDO> set = orgService.getTreeByUserOrgId(loginOrgId);
        List<OrgDO> list = new ArrayList<>();
        list.addAll(set);
        extracted(flowOrgRoleDTOS, list);
        List<FlowOrgRoleDTO> topOrg = flowOrgRoleDTOS.stream().filter(e -> SysConstant.ORG_0.equals(e.getOrgType()) || SysConstant.ORG_1.equals(e.getOrgType())).collect(Collectors.toList());
        List<FlowOrgRoleDTO> areaOrg = flowOrgRoleDTOS.stream().filter(e -> SysConstant.ORG_1.equals(e.getOrgType()) || SysConstant.ORG_1.equals(e.getOrgType())).collect(Collectors.toList());
        List<FlowOrgRoleDTO> lowOrg = flowOrgRoleDTOS.stream().filter(e -> SysConstant.ORG_2.equals(e.getOrgType())).collect(Collectors.toList());
        for (int i = 0; i < nodeList.size(); i++) {
            switch (flowType) {
                case SURVEY_FLOW:
                        if (i == 0 || i == 1) {
                            nodeList.get(i).setNodeUserGroup(topOrg);
                        } else {
                            nodeList.get(i).setNodeUserGroup(lowOrg);
                        }
                    break;
                case HANDLE_CORRECTION_FLOW:
                    if (i < 7) {
                            nodeList.get(i).setNodeUserGroup(topOrg);
                        } else {
                            //得到办理入矫对象
                            if(dataId!=null){
                                HandleCorrection byId = handleCorrectionService.getById(dataId);
                                Long jurisdictionOfficeId = byId.getJurisdictionOfficeId();
                                List<FlowOrgRoleDTO> collect = lowOrg.stream().filter(e -> e.getOrgId().equals(jurisdictionOfficeId)).collect(Collectors.toList());
                                nodeList.get(i).setNodeUserGroup(collect);
                            } else {
                                nodeList.get(i).setNodeUserGroup(lowOrg);
                            }
                        }
                    break;
                case SUPERVISION_OUT_FLOW_ONE:
                    nodeList.get(i).setNodeUserGroup(lowOrg);
                    break;
                case SUPERVISION_OUT_FLOW_TWO:
                    if (i < 2) {
                        nodeList.get(i).setNodeUserGroup(lowOrg);
                    } else {
                        nodeList.get(i).setNodeUserGroup(areaOrg);
                    }
                    break;
                case SUPERVISION_OUT_FLOW_THREE:
                    if (i < 2) {
                        nodeList.get(i).setNodeUserGroup(lowOrg);
                    } else if (i == 2){
                        nodeList.get(i).setNodeUserGroup(areaOrg);
                    } else if (i ==3 ||i==4){
                        nodeList.get(i).setNodeUserGroup(topOrg);
                    } else {
                        nodeList.get(i).setNodeUserGroup(areaOrg);
                    }
                    break;
                case SUPERVISION_POSITION_FLOW_ONE:
                        nodeList.get(i).setNodeUserGroup(areaOrg);
                    break;
                case SUPERVISION_POSITION_FLOW_TWO:
                    nodeList.get(i).setNodeUserGroup(areaOrg);
                    break;
                case SUPERVISION_POSITION_FLOW_THREE:
                    nodeList.get(i).setNodeUserGroup(areaOrg);
                    break;
                case SUPERVISION_POSITION_FLOW_FOUR:
                    nodeList.get(i).setNodeUserGroup(areaOrg);
                    break;

                case CASESPUNISHMENT_FLOW_FIRST:
                    nodeList.get(i).setNodeUserGroup(areaOrg);
                    break;
                case CASESPUNISHMENT_FLOW_ONE:
                    nodeList.get(i).setNodeUserGroup(areaOrg);
                    break;
                case CASESPUNISHMENT_FLOW_TWO:
                    nodeList.get(i).setNodeUserGroup(areaOrg);
                    break;
                case CASESPUNISHMENT_FLOW_THREE:
                    nodeList.get(i).setNodeUserGroup(areaOrg);
                    break;

                case REWARDRECORD_FLOW_FIRST:
                    nodeList.get(i).setNodeUserGroup(areaOrg);
                    break;
                case REWARDRECORD_FLOW_ONE:
                    nodeList.get(i).setNodeUserGroup(areaOrg);
                    break;
                case REWARDRECORD_FLOW_TWO:
                    nodeList.get(i).setNodeUserGroup(areaOrg);
                    break;

                case TERMINATION_SOLUTIONS_FLOW:
                    nodeList.get(i).setNodeUserGroup(areaOrg);
                    break;
                case TERMINATION_CORRECT_FLOW:
                    nodeList.get(i).setNodeUserGroup(areaOrg);
                    break;
            }
        }
        return nodeList;
    }

    @Override
    public List<FlowOrgRoleDTO> getOrgRoleInfo(List<OrgDO> list) {
        List<FlowOrgRoleDTO> flowOrgRoleDTOS = new ArrayList<>();
        for (OrgDO orgDO : list) {
            FlowOrgRoleDTO flowOrgRoleDTO = new FlowOrgRoleDTO();
            //得到orgDO下的角色
            Long id = orgDO.getId();
            //得到org下的角色信息
            List<Role> roleByOrgId = roleMapper.findRoleByOrgId(id);
            List<RoleUserOutpuDTO> roleUserOutpuDTOS = MRoleConvert.INSTANCE.toRoleUserList(roleByOrgId);
            flowOrgRoleDTO.setOrgId(id);
            flowOrgRoleDTO.setOrgType(orgDO.getOrgType());
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

    @Override
    public List<FlowUserListDTO> getFlowNodeLink(String flowType, Long dataId) {
        List<FlowUserListDTO> nodeList = flowCenterMapper.getFlowUserListLink(flowType,dataId);
        if (REWARDRECORD_FLOW_FIRST.equals(flowType)) {
            RewardRecord rewardRecord = rewardRecordMapper.selectById(dataId);
            if (rewardRecord.getRewardTypeAdvice()!=null  ){
                List<FlowUserListDTO> nextNodeList = flowCenterMapper.getFlowUserListLink(801==rewardRecord.getRewardTypeAdvice()?REWARDRECORD_FLOW_ONE:REWARDRECORD_FLOW_TWO,dataId);
                nodeList.addAll(nextNodeList);
            }
        } else if (CASESPUNISHMENT_FLOW_FIRST.equals(flowType)) {
            CasesPunishment casesPunishment = casesPunishmentMapper.selectById(dataId);
            Integer violationsTypeAdvice = casesPunishment.getViolationsTypeAdvice();
            if (casesPunishment.getViolationsTypeAdvice()!=null  ){
                List<FlowUserListDTO> nextNodeList = new ArrayList<>();
                if(701 == violationsTypeAdvice || 702 == violationsTypeAdvice) {
                    nextNodeList = flowCenterMapper.getFlowUserListLink(CASESPUNISHMENT_FLOW_ONE,dataId);
                } else if (703 == violationsTypeAdvice || 707 == violationsTypeAdvice){
                    nextNodeList = flowCenterMapper.getFlowUserListLink(CASESPUNISHMENT_FLOW_TWO,dataId);
                } else {
                    nextNodeList = flowCenterMapper.getFlowUserListLink(CASESPUNISHMENT_FLOW_THREE,dataId);
                }
                nodeList.addAll(nextNodeList);
            }
        }
        return nodeList;
    }


}
