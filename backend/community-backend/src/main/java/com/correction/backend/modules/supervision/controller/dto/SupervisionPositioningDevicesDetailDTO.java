package com.correction.backend.modules.supervision.controller.dto;

import com.correction.backend.modules.survey.controller.dto.SurveyDocumentsFilesDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SupervisionPositioningDevicesDetailDTO {

    @ApiModelProperty(value = "电子定位装置审批详情")
    SupervisionPositioningDevicesListOutputDTO detail;

    @ApiModelProperty(value = "申请-使用电子定位专职审批申请材料")
    List<SurveyDocumentsFilesDTO> approvalMaterials;

    @ApiModelProperty(value = "申请-司法行政审批材料")
    List<SurveyDocumentsFilesDTO> justiceMaterials;

    @ApiModelProperty(value = "申请-告知矫正对象材料")
    List<SurveyDocumentsFilesDTO> informMaterials;

    @ApiModelProperty(value = "延迟-延迟电子定位装置审批申请材料")
    List<SurveyDocumentsFilesDTO> delayMaterials;

    @ApiModelProperty(value = "延迟-司法行政审批材料")
    List<SurveyDocumentsFilesDTO> delayJusticeMaterials;

    @ApiModelProperty(value = "延迟-告知矫正对象审批材料")
    List<SurveyDocumentsFilesDTO> delayIformMaterials;

    @ApiModelProperty(value = "解除-解除电子定位装置审批申请材料")
    List<SurveyDocumentsFilesDTO> removeMaterials;

    @ApiModelProperty(value = "解除-司法行政审批材料")
    List<SurveyDocumentsFilesDTO> removeJusticeMaterials;

    @ApiModelProperty(value = "解除-告知矫正对象审批材料")
    List<SurveyDocumentsFilesDTO> removeIformMaterials;

    @ApiModelProperty(value = "免除-免除电子定位装置审批申请材料")
    List<SurveyDocumentsFilesDTO> fromMaterials;

    @ApiModelProperty(value = "免除-司法行政审批材料")
    List<SurveyDocumentsFilesDTO> fromJusticeMaterials;

    @ApiModelProperty(value = "免除-告知矫正对象审批材料")
    List<SurveyDocumentsFilesDTO> fromIformMaterials;

    @ApiModelProperty(value = "查访小组")
    private List<SupervisionVisitGroupListOutputDTO> userGroupList;



}
