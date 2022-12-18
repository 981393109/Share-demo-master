package com.correction.backend.modules.cases.controller.dto;

import com.correction.backend.modules.cases.entity.CollegiateBenchGroup;
import com.correction.backend.modules.survey.controller.dto.SurveyDocumentsFilesDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class RewardRecordDetailDTO {

    @ApiModelProperty(value = "详情信息")
    RewardRecordListOutputDTO detail;

    @ApiModelProperty(value = "合议结果材料")
    List<SurveyDocumentsFilesDTO> collegiateBenchFiles;

    @ApiModelProperty(value = "评议审核材料")
    List<SurveyDocumentsFilesDTO> reviewFiles;

    @ApiModelProperty(value = "评议审核签字材料")
    List<SurveyDocumentsFilesDTO> reviewApplyFiles;

    @ApiModelProperty(value = "文书制作材料")
    List<SurveyDocumentsFilesDTO> docMakingFiles;

    @ApiModelProperty(value = "文书送达材料")
    List<SurveyDocumentsFilesDTO> docSendFiles;

    @ApiModelProperty(value = "文书补全材料")
    List<SurveyDocumentsFilesDTO> docAddFiles;

    @ApiModelProperty(value = "合议小组")
    List<CollegiateBenchGroup> collegiateBenchGroups;

    @ApiModelProperty(value = "评议小组")
    List<CollegiateBenchGroup> reviewGroups;
}
