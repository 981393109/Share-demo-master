package com.correction.backend.modules.home.controller.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class HomeReportDTO {

    @ApiModelProperty("调查评估")
    private ReportDTO surveyEvaluation;

    @ApiModelProperty("办理入矫")
    private ReportDTO handleCorrection;

    @ApiModelProperty("矫正对象")
    private ReportDTO correctionUser;

    @ApiModelProperty("期满解矫")
    private ReportDTO terminationSolutions;

}
