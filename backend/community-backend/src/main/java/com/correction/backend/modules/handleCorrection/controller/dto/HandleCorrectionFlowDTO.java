package com.correction.backend.modules.handleCorrection.controller.dto;

import com.correction.backend.modules.survey.controller.dto.SurveyEvaluationUpdateInputDTO;
import com.correction.framework.workflow.dto.FlowCompleteDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class HandleCorrectionFlowDTO {

    @ApiModelProperty(value = "详情信息")
    HandleCorrectionUpdateInputDTO detail;

    @ApiModelProperty(value = "审批信息")
    FlowCompleteDTO flowInfo;

}
