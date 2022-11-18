package com.correction.backend.modules.survey.mapper;

import com.correction.backend.modules.survey.controller.dto.SurveyEvaluationSearchInputDTO;
import com.correction.backend.modules.survey.entity.SurveyEvaluation;
import com.correction.framework.common.pojo.PageResult;
import com.correction.frameworks.mybatis.mybatis.core.mapper.BaseMapperX;
import com.correction.frameworks.mybatis.mybatis.core.query.QueryWrapperX;
//import com.baomidou.mybatisplus.core.mapper.BaseMapperX;

/**
 * <p>
 * 调查评估记录 Mapper 接口
 * </p>
 *
 * @author yao
 * @since 2022-11-17
 */
public interface SurveyEvaluationMapper extends BaseMapperX<SurveyEvaluation> {

    default PageResult<SurveyEvaluation> selectPage(SurveyEvaluationSearchInputDTO searchInputDTO) {
        return selectPage(searchInputDTO,new QueryWrapperX<SurveyEvaluation>()
        .eqIfPresent("entrust_type",searchInputDTO.getEntrustType())
        .likeIfPresent("name",searchInputDTO.getName())
        .likeIfPresent("entrust_unit",searchInputDTO.getEntrustUnit())
        .likeIfPresent("area_jurisdiction",searchInputDTO.getAreaJurisdiction())
        );
    }
}
