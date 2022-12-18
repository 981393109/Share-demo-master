package com.correction.backend.modules.termination.controller.dto;

import com.correction.framework.workflow.dto.FlowCompleteDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class TerminationCorrectFlowDTO {

    @ApiModelProperty(value = "详情信息")
    TerminationCorrectUpdateInputDTO detail;

    @ApiModelProperty(value = "审批信息")
    FlowCompleteDTO flowInfo;

}
