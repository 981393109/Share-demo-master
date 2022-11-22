package com.correction.backend.modules.survey.controller.dto;

import com.correction.backend.modules.flow.controller.dto.FlowNodeUserCreateInputDTO;
import com.correction.backend.modules.flow.entity.FlowNodeUser;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 调查评估+审批流程
 */
@Setter
@Getter
public class SurveryEvaluationFlowDTO {

    @ApiModelProperty(value = "详情信息")
    SurveyEvaluationCreateInputDTO detail;

    @ApiModelProperty(value = "流程信息")
    List<FlowNodeUserCreateInputDTO> flowInfo;

}
