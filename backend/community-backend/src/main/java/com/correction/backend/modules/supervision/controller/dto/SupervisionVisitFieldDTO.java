package com.correction.backend.modules.supervision.controller.dto;

import com.correction.backend.modules.supervision.entity.SupervisionVisitField;
import com.correction.backend.modules.survey.controller.dto.SurveyDocumentsFilesDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@ApiModel(value="SupervisionVisitFieldDTO", description="查访登记明细")
public class SupervisionVisitFieldDTO implements Serializable {

    private static final long serialVersionUID = 1L;

   @ApiModelProperty(value = "查访登记详情")
   private SupervisionVisitFieldListOutputDTO detail;

    @ApiModelProperty(value = "查访小组")
    private List<SupervisionVisitGroupListOutputDTO> userGroupList;

    @ApiModelProperty(value = "材料")
    private List<SurveyDocumentsFilesDTO> surveyDocumentsFiles;

}
