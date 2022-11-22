package com.correction.backend.modules.flow.convert;

import com.correction.backend.modules.flow.controller.dto.FlowNodeDTO;
import com.correction.backend.modules.flow.controller.vo.FlowCenterListOutputDTO;
import com.correction.backend.modules.flow.entity.FlowCenter;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Author：yao
 * @Description:  转换类
 * @Date: 2022-11-16
 */

@Mapper
public interface MFlowCenterConvert {

    MFlowCenterConvert INSTANCE = Mappers.getMapper(MFlowCenterConvert.class);

    List<FlowCenter> toFlowCenterList(List<FlowNodeDTO> flowNodes);


    List<FlowCenterListOutputDTO> toList(List<FlowCenter> flowCenters);
}