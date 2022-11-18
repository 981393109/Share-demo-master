package com.correction.backend.modules.survey.controller.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * 调查评估详情数据以及文书信息
 */
@Getter
@Setter
public class SurveyEvaluationFilesDTO implements Serializable {

    @ApiModelProperty(value = "详情信息")
    SurveyEvaluationListOutputDTO detail;

    @ApiModelProperty(value = "委托检查材料")
    List<SurveyDocumentsFilesDTO> materials;

    @ApiModelProperty(value = "调查实施材料")
    List<SurveyDocumentsFilesDTO> implement;

    @ApiModelProperty(value = "审核实施材料")
    List<SurveyDocumentsFilesDTO> assessment;

}
