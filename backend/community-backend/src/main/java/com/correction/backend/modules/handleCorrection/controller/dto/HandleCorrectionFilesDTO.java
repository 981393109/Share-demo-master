package com.correction.backend.modules.handleCorrection.controller.dto;

import com.correction.backend.modules.survey.controller.dto.SurveyDocumentsFilesDTO;
import com.correction.backend.modules.survey.controller.dto.SurveyEvaluationListOutputDTO;
import com.correction.backend.modules.survey.entity.SurveyEvaluation;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class HandleCorrectionFilesDTO implements Serializable {

    @ApiModelProperty(value = "详情信息")
    HandleCorrectionListOutputDTO detail;

    @ApiModelProperty(value = "调查评估对象")
    SurveyEvaluation surveyEvaluation;

    @ApiModelProperty(value = "文书补充")
    List<SurveyDocumentsFilesDTO> docSupplementFiles;

    @ApiModelProperty(value = "人员报到")
    List<SurveyDocumentsFilesDTO> userReportsFiles;

    @ApiModelProperty(value = "信息采集")
    List<SurveyDocumentsFilesDTO> informationCollectionFiles;

    @ApiModelProperty(value = "报备手续材料")
    List<SurveyDocumentsFilesDTO> reportingFiles;

    @ApiModelProperty(value = "告知书")
    List<SurveyDocumentsFilesDTO> letterNoticeFiles;

    @ApiModelProperty(value = "报备手续材料")
    List<SurveyDocumentsFilesDTO> materialsFiles;

    @ApiModelProperty(value = "小组材料")
    List<SurveyDocumentsFilesDTO> groupFiles;

    @ApiModelProperty(value = "方案材料")
    List<SurveyDocumentsFilesDTO> waysFiles;

    @ApiModelProperty(value = "宣言材料")
    List<SurveyDocumentsFilesDTO> saysFiles;

    @ApiModelProperty(value = "回执材料")
    List<SurveyDocumentsFilesDTO> receiptMaterialsFiles;

}
