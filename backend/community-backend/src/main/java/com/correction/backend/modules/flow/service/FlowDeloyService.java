package com.correction.backend.modules.flow.service;

import com.correction.backend.modules.flow.controller.dto.FlowCenterDTO;

/**
 * 流程部署相关接口
 */
public interface FlowDeloyService {


    /**
     * 部署流程并启动
     * @param flowCenterDTO
     * @throws Exception
     */
    void saveFlowCenter(FlowCenterDTO flowCenterDTO) throws Exception;



}
