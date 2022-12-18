package com.correction.backend.modules.flow.service;

import com.correction.backend.modules.flow.entity.FlowCenter;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yao
 * @since 2022-11-16
 */
public interface FlowCenterService extends IService<FlowCenter> {

    /**
     * 新增流程中心服务类
     */
    FlowCenter create (FlowCenter flowCenter);

    /**
     * 获取列表
     */
    List<FlowCenter> getList (FlowCenter flowCenter);

    FlowCenter getFlowCenterByActivityId(String currentActivityId);

    List<String> getUserIdListByFlowCenter(FlowCenter flowCenter);

    List<String> getUserIdListByFlow (String currentActivityId,String busKey,FlowCenter flowCenter);

    FlowCenter getFlowRejectedFlowCenter(String documentation);

    List<String> getUserIdListByFlow(String processInstanceBusinessKey, FlowCenter flowCenter);
}
