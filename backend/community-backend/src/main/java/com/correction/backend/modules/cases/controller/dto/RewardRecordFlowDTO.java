package com.correction.backend.modules.cases.controller.dto;

import com.correction.framework.workflow.dto.FlowCompleteDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class RewardRecordFlowDTO {

    @ApiModelProperty(value = "详情信息")
    RewardRecordUpdateInputDTO detail;

    @ApiModelProperty(value = "审批信息")
    FlowCompleteDTO flowInfo;

}
