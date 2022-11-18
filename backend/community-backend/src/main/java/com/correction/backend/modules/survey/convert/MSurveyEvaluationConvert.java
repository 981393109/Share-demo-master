package com.correction.backend.modules.survey.convert;

import com.correction.backend.modules.survey.controller.dto.*;
import com.correction.backend.modules.survey.entity.SurveyEvaluation;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Author：yao
 * @Description: 调查评估记录 转换类
 * @Date: 2022-11-15
 */

@Mapper
public interface MSurveyEvaluationConvert {

    MSurveyEvaluationConvert INSTANCE = Mappers.getMapper(MSurveyEvaluationConvert.class);

    SurveyEvaluation toSurveyEvaluation(SurveyEvaluationSearchInputDTO surveyEvaluationSearchInputDTO);

    SurveyEvaluation toSurveyEvaluation(SurveyEvaluationCreateInputDTO surveyEvaluationCreateInputDTO);

    SurveyEvaluation toSurveyEvaluation(SurveyEvaluationUpdateInputDTO surveyEvaluationUpdateInputDTO);

    SurveyEvaluationListOutputDTO toList(SurveyEvaluation surveyEvaluation);

    SurveyEvaluationListDTO toEsyList(SurveyEvaluation surveyEvaluation);

    List<SurveyEvaluationListOutputDTO> toList(List<SurveyEvaluation> surveyEvaluations);
}