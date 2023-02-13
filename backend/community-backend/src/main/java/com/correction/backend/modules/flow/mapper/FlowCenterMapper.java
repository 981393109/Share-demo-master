package com.correction.backend.modules.flow.mapper;

import com.correction.backend.modules.flow.controller.dto.FlowNodeListDTO;
import com.correction.backend.modules.flow.controller.dto.FlowUserListDTO;
import com.correction.backend.modules.flow.entity.FlowCenter;
import com.correction.frameworks.mybatis.mybatis.core.mapper.BaseMapperX;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yao
 * @since 2022-11-16
 */
public interface FlowCenterMapper extends BaseMapperX<FlowCenter> {


    List<FlowNodeListDTO>  getNodeList (@Param("type") String flowType);

    List<FlowUserListDTO> getFlowUserListLink (@Param("flowType") String flowType,@Param("dataId") Long dataId);
}
