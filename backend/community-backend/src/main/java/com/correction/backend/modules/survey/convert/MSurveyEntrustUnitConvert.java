package com.correction.backend.modules.survey.convert;

import com.correction.backend.modules.survey.controller.dto.SurveyEntrustUnitCreateInputDTO;
import com.correction.backend.modules.survey.controller.dto.SurveyEntrustUnitListOutputDTO;
import com.correction.backend.modules.survey.controller.dto.SurveyEntrustUnitSearchInputDTO;
import com.correction.backend.modules.survey.controller.dto.SurveyEntrustUnitUpdateInputDTO;
import com.correction.backend.modules.survey.entity.SurveyEntrustUnit;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Author：yao
 * @Description: 委托单位表 转换类
 * @Date: 2022-11-17
 */

@Mapper
public interface MSurveyEntrustUnitConvert {

    MSurveyEntrustUnitConvert INSTANCE = Mappers.getMapper(MSurveyEntrustUnitConvert.class);

    SurveyEntrustUnit toSurveyEntrustUnit(SurveyEntrustUnitSearchInputDTO surveyEntrustUnitSearchInputDTO);

    SurveyEntrustUnit toSurveyEntrustUnit(SurveyEntrustUnitCreateInputDTO surveyEntrustUnitCreateInputDTO);

    SurveyEntrustUnit toSurveyEntrustUnit(SurveyEntrustUnitUpdateInputDTO surveyEntrustUnitUpdateInputDTO);

    SurveyEntrustUnitListOutputDTO toList(SurveyEntrustUnit surveyEntrustUnit);

    List<SurveyEntrustUnitListOutputDTO> toList(List<SurveyEntrustUnit> surveyEntrustUnits);
}