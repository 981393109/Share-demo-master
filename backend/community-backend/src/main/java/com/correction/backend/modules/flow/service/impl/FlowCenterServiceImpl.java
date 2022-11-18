package com.correction.backend.modules.flow.service.impl;

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

    @Override
    public FlowCenter create(FlowCenter flowCenter) {
        baseMapper.insert(flowCenter);
        return flowCenter;
    }

    @Override
    public List<FlowCenter> getList(FlowCenter flowCenter) {

        return null;
    }


}
