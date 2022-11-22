package com.correction.backend.modules.flow.convert;

import com.correction.backend.modules.flow.controller.dto.FlowNodeUserCreateInputDTO;
import com.correction.backend.modules.flow.controller.dto.FlowNodeUserListOutputDTO;
import com.correction.backend.modules.flow.entity.FlowNodeUser;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Author：yao
 * @Description: 审批流程节点与用户关联关系 转换类
 * @Date: 2022-11-19
 */

@Mapper
public interface MFlowNodeUserConvert {

    MFlowNodeUserConvert INSTANCE = Mappers.getMapper(MFlowNodeUserConvert.class);

    List<FlowNodeUser> toFlowNodeUser(List<FlowNodeUserCreateInputDTO> flowNodeUserCreateInputDTOList);
    FlowNodeUser toFlowNodeUser(FlowNodeUserCreateInputDTO flowNodeUserCreateInputDTO);

    FlowNodeUserListOutputDTO toList(FlowNodeUser flowNodeUser);

    List<FlowNodeUserListOutputDTO> toList(List<FlowNodeUser> flowNodeUsers);
}