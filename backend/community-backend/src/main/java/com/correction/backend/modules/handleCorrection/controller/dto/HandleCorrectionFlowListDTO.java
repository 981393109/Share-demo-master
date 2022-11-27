package com.correction.backend.modules.handleCorrection.controller.dto;

import com.correction.backend.modules.flow.controller.dto.FlowNodeUserCreateInputDTO;
import com.correction.backend.modules.survey.controller.dto.SurveyEvaluationCreateInputDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class HandleCorrectionFlowListDTO {

    @ApiModelProperty(value = "详情信息")
    HandleCorrectionCreateInputDTO detail;

    @ApiModelProperty(value = "流程信息")
    List<FlowNodeUserCreateInputDTO> flowInfo;


}
