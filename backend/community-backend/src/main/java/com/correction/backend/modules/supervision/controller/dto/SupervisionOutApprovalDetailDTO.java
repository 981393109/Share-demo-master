package com.correction.backend.modules.supervision.controller.dto;

import com.correction.backend.modules.survey.controller.dto.SurveyDocumentsFilesDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SupervisionOutApprovalDetailDTO {


    @ApiModelProperty(value = "外出审批详情")
    SupervisionOutApprovalListOutputDTO detail;

    @ApiModelProperty(value = "外出审批申请材料")
    List<SurveyDocumentsFilesDTO> approvalMaterials;

    @ApiModelProperty(value = "文书告知材料")
    List<SurveyDocumentsFilesDTO> noticeMaterials;

    @ApiModelProperty(value = "司法所审批材料")
    List<SurveyDocumentsFilesDTO> placeApplyMaterials;

    @ApiModelProperty(value = "区司法局审批材料")
    List<SurveyDocumentsFilesDTO> areaApplyMaterials;

    @ApiModelProperty(value = "市司法局审批材料")
    List<SurveyDocumentsFilesDTO> cityApplyMaterials;

}
