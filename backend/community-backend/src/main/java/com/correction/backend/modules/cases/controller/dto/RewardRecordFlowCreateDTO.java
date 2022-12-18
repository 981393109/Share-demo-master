package com.correction.backend.modules.cases.controller.dto;

import com.correction.backend.modules.flow.controller.dto.FlowNodeUserCreateInputDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class RewardRecordFlowCreateDTO {

    @ApiModelProperty(value = "详情信息")
    RewardRecordCreateInputDTO  detail;

    @ApiModelProperty(value = "流程信息")
    List<FlowNodeUserCreateInputDTO> flowInfo;

    @ApiModelProperty(value = "taskId")
    String taskId;

}
