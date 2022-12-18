package com.correction.backend.modules.termination.controller.dto;

import com.correction.backend.modules.survey.controller.dto.SurveyDocumentsFilesDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class TerminationCorrectDetailDTO {

    @ApiModelProperty(value = "详情信息")
    TerminationCorrectListOutputDTO detail;

    @ApiModelProperty(value = "文书制作材料")
    List<SurveyDocumentsFilesDTO> reportFiles;

}
