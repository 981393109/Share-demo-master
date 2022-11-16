package com.correction.backend.modules.survey.convert;

import com.correction.backend.modules.survey.controller.dto.SurveyDocumentsFilesCreateInputDTO;
import com.correction.backend.modules.survey.controller.dto.SurveyDocumentsFilesListOutputDTO;
import com.correction.backend.modules.survey.controller.dto.SurveyDocumentsFilesSearchInputDTO;
import com.correction.backend.modules.survey.controller.dto.SurveyDocumentsFilesUpdateInputDTO;
import com.correction.backend.modules.survey.entity.SurveyDocumentsFiles;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Author：yao
 * @Description: 文书附件上传 转换类
 * @Date: 2022-11-15
 */

@Mapper
public interface MSurveyDocumentsFilesConvert {

    MSurveyDocumentsFilesConvert INSTANCE = Mappers.getMapper(MSurveyDocumentsFilesConvert.class);

    SurveyDocumentsFiles toSurveyDocumentsFiles(SurveyDocumentsFilesSearchInputDTO surveyDocumentsFilesSearchInputDTO);

    SurveyDocumentsFiles toSurveyDocumentsFiles(SurveyDocumentsFilesCreateInputDTO surveyDocumentsFilesCreateInputDTO);

    SurveyDocumentsFiles toSurveyDocumentsFiles(SurveyDocumentsFilesUpdateInputDTO surveyDocumentsFilesUpdateInputDTO);

    SurveyDocumentsFilesListOutputDTO toList(SurveyDocumentsFiles surveyDocumentsFiles);

    List<SurveyDocumentsFilesListOutputDTO> toList(List<SurveyDocumentsFiles> surveyDocumentsFiless);
}