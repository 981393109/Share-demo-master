package com.correction.backend.modules.termination.controller.dto;


import com.correction.backend.modules.cases.controller.dto.CasesPunishmentListOutputDTO;
import com.correction.backend.modules.survey.controller.dto.SurveyDocumentsFilesDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@ApiModel(value="TerminationSolutionDetailDTO", description="详情表单")
public class TerminationSolutionDetailDTO implements Serializable {

    @ApiModelProperty(value = "详情信息")
    TerminationSolutionsListOutputDTO detail;

    @ApiModelProperty(value = "上报材料")
    List<SurveyDocumentsFilesDTO> reportFiles;

    @ApiModelProperty(value = "解矫宣告材料")
    List<SurveyDocumentsFilesDTO> signatureFiles;

}
