package com.correction.backend.modules.survey.mapper;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.correction.backend.modules.survey.controller.dto.SurveyEntrustUnitSearchInputDTO;
import com.correction.backend.modules.survey.entity.SurveyEntrustUnit;
import com.correction.backend.modules.survey.entity.SurveyEvaluation;
import com.correction.framework.common.pojo.PageResult;
import com.correction.frameworks.mybatis.mybatis.core.mapper.BaseMapperX;
import com.correction.frameworks.mybatis.mybatis.core.query.QueryWrapperX;

/**
 * <p>
 * 委托单位表 Mapper 接口
 * </p>
 *
 * @author yao
 * @since 2022-11-17
 */
public interface SurveyEntrustUnitMapper extends BaseMapperX<SurveyEntrustUnit> {

    default PageResult<SurveyEntrustUnit> getPageList(SurveyEntrustUnitSearchInputDTO searchInputDTO) {
        return selectPage(searchInputDTO, new QueryWrapperX<SurveyEntrustUnit>()
        .likeIfPresent("unit_name",searchInputDTO.getUnitName())
        .likeIfPresent("mobile",searchInputDTO.getMobile())
        .likeIfPresent("unit_address",searchInputDTO.getUnitAddress())
        .eqIfPresent("unit_type",searchInputDTO.getUnitType()));
    }
}
