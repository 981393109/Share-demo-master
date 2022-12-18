package com.correction.backend.modules.termination.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.correction.backend.modules.termination.controller.dto.TerminationSolutionsPageListDTO;
import com.correction.backend.modules.termination.controller.dto.TerminationSolutionsSearchInputDTO;
import com.correction.backend.modules.termination.entity.TerminationSolutions;
import com.correction.frameworks.mybatis.mybatis.core.mapper.BaseMapperX;
import org.apache.ibatis.annotations.Param;
//import com.baomidou.mybatisplus.core.mapper.BaseMapperX;

/**
 * <p>
 * 期满解矫 Mapper 接口
 * </p>
 *
 * @author yao
 * @since 2022-12-18
 */
public interface TerminationSolutionsMapper extends BaseMapperX<TerminationSolutions> {

    IPage<TerminationSolutionsPageListDTO> getPageListFlow(@Param("page") IPage<TerminationSolutionsPageListDTO> mpPage, @Param("query") TerminationSolutionsSearchInputDTO query);
}
