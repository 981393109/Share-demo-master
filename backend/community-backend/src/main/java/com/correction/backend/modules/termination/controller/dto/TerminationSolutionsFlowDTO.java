package com.correction.backend.modules.termination.controller.dto;

import com.correction.backend.modules.supervision.controller.dto.SupervisionOutApprovalUpdateInputDTO;
import com.correction.framework.workflow.dto.FlowCompleteDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class TerminationSolutionsFlowDTO {

    @ApiModelProperty(value = "详情信息")
    TerminationSolutionsUpdateInputDTO detail;

    @ApiModelProperty(value = "审批信息")
    FlowCompleteDTO flowInfo;



}
