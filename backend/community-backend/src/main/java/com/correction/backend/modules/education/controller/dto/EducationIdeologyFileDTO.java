package com.correction.backend.modules.education.controller.dto;


import com.correction.backend.modules.survey.controller.dto.SurveyDocumentsFilesDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@ApiModel(value="EducationIdeologyFileDTO", description="思想汇报详情消息")
public class EducationIdeologyFileDTO {

    @ApiModelProperty(value = "思想汇报详情")
    EducationIdeologyListOutputDTO detail;

    @ApiModelProperty(value = "思想汇报材料")
    List<SurveyDocumentsFilesDTO> materials;

}
