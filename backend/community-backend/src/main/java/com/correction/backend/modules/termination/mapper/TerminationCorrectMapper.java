package com.correction.backend.modules.termination.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.correction.backend.modules.termination.controller.dto.TerminationCorrectPageListDTO;
import com.correction.backend.modules.termination.controller.dto.TerminationCorrectSearchInputDTO;
import com.correction.backend.modules.termination.entity.TerminationCorrect;
import com.correction.frameworks.mybatis.mybatis.core.mapper.BaseMapperX;
import org.apache.ibatis.annotations.Param;
//import com.baomidou.mybatisplus.core.mapper.BaseMapperX;

/**
 * <p>
 * 矫正终止 Mapper 接口
 * </p>
 *
 * @author yao
 * @since 2022-12-18
 */
public interface TerminationCorrectMapper extends BaseMapperX<TerminationCorrect> {

    IPage<TerminationCorrectPageListDTO> getPageListFlow(@Param("page") IPage<TerminationCorrectPageListDTO> page,@Param("query") TerminationCorrectSearchInputDTO query);

    IPage<TerminationCorrectPageListDTO> getPageAllListFlow(@Param("page") IPage<TerminationCorrectPageListDTO> page,@Param("query") TerminationCorrectSearchInputDTO query);
}
