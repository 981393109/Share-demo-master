package com.correction.backend.modules.cases.controller.dto;

import com.correction.backend.modules.flow.controller.dto.FlowNodeUserCreateInputDTO;
import com.correction.backend.modules.handleCorrection.controller.dto.HandleCorrectionCreateInputDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class CasesPunishmentFlowCreateDTO {

    @ApiModelProperty(value = "详情信息")
    CasesPunishmentCreateInputDTO  detail;

    @ApiModelProperty(value = "流程信息")
    List<FlowNodeUserCreateInputDTO> flowInfo;

    @ApiModelProperty(value = "taskId")
    String taskId;

}
