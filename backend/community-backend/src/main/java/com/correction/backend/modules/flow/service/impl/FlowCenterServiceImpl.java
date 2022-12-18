package com.correction.backend.modules.flow.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.correction.backend.modules.flow.entity.FlowNodeRelation;
import com.correction.backend.modules.flow.entity.FlowNodeUser;
import com.correction.backend.modules.flow.mapper.FlowNodeRelationMapper;
import com.correction.backend.modules.flow.mapper.FlowNodeUserMapper;
import com.correction.backend.modules.flow.service.FlowCenterService;
import com.correction.backend.modules.flow.entity.FlowCenter;
import com.correction.backend.modules.flow.mapper.FlowCenterMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.correction.framework.workflow.service.ActFlowableTaskService;
import com.correction.framework.workflow.service.FlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yao
 * @since 2022-11-16
 */
@Service
public class FlowCenterServiceImpl extends ServiceImpl<FlowCenterMapper, FlowCenter> implements FlowCenterService {

    @Resource
    FlowService flowService;

    @Resource
    FlowNodeRelationMapper flowNodeRelationMapper;

    @Resource
    FlowNodeUserMapper flowNodeUserMapper;


    @Override
    public FlowCenter create(FlowCenter flowCenter) {
        baseMapper.insert(flowCenter);
        return flowCenter;
    }

    @Override
    public List<FlowCenter> getList(FlowCenter flowCenter) {

        return null;
    }

    @Override
    public FlowCenter getFlowCenterByActivityId(String activityId) {
        FlowNodeRelation flowNodeRelation = flowNodeRelationMapper.selectOne(Wrappers.<FlowNodeRelation>lambdaQuery()
                .eq(FlowNodeRelation::getNodeId, activityId).last(" limit 1"));
        //根据关联找到FlowCenter数据
        FlowCenter flowCenter = baseMapper.selectById(flowNodeRelation.getFlowId());
        return flowCenter;
    }

    @Override
    public List<String> getUserIdListByFlowCenter(FlowCenter flowCenter) {
        Long id = flowCenter.getId();

        return null;
    }

    @Override
    public List<String> getUserIdListByFlow(String currentActivityId, String busKey,FlowCenter flowCenter) {
        String[] split = busKey.split(":");
        List<FlowNodeUser> flowNodeUsers = flowNodeUserMapper.selectList(Wrappers.<FlowNodeUser>lambdaQuery()
                .eq(FlowNodeUser::getNodeId, currentActivityId)
                .eq(FlowNodeUser::getFlowId, flowCenter.getId())
                .eq(FlowNodeUser::getDataId, split[1])
                .eq(FlowNodeUser::getRef, split[2])
        );
        List<String> collect = flowNodeUsers.stream().map(e -> String.valueOf(e.getUserId())).collect(Collectors.toList());
        return collect;
    }

    @Override
    public FlowCenter getFlowRejectedFlowCenter(String documentation) {
        //当前id
        FlowCenter flowCenter = baseMapper.selectById(Long.parseLong(documentation));
        //找上一级节点
        Long beforeNode = flowCenter.getBeforeNode();
        if(beforeNode == null){
            return  null;
        }
        FlowCenter beforeCenter = baseMapper.selectById(beforeNode);
        return beforeCenter;
    }

    @Override
    public List<String> getUserIdListByFlow(String processInstanceBusinessKey, FlowCenter flowCenter) {
        //根据flowId找到node
        FlowNodeRelation flowNodeRelation = flowNodeRelationMapper.selectOne(Wrappers.<FlowNodeRelation>lambdaQuery().eq(FlowNodeRelation::getFlowId, flowCenter.getId()));
        String[] split = processInstanceBusinessKey.split(":");
        List<FlowNodeUser> flowNodeUsers = flowNodeUserMapper.selectList(Wrappers.<FlowNodeUser>lambdaQuery()
                .eq(FlowNodeUser::getNodeId, flowNodeRelation.getNodeId())
                .eq(FlowNodeUser::getFlowId, flowCenter.getId())
                .eq(FlowNodeUser::getDataId, split[1])
                .eq(FlowNodeUser::getRef, split[2])
        );
        List<String> collect = flowNodeUsers.stream().map(e -> String.valueOf(e.getUserId())).collect(Collectors.toList());
        return collect;
    }


}
