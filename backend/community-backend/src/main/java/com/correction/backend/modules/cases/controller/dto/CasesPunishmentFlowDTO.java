package com.correction.backend.modules.cases.controller.dto;

import com.correction.backend.modules.handleCorrection.controller.dto.HandleCorrectionUpdateInputDTO;
import com.correction.framework.workflow.dto.FlowCompleteDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CasesPunishmentFlowDTO {

    @ApiModelProperty(value = "详情信息")
    CasesPunishmentUpdateInputDTO detail;

    @ApiModelProperty(value = "审批信息")
    FlowCompleteDTO flowInfo;


}
