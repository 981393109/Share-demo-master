package com.correction.backend.modules.handleCorrection.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.correction.backend.modules.handleCorrection.controller.dto.HandleCorrectionListDTO;
import com.correction.backend.modules.handleCorrection.controller.dto.HandleCorrectionSearchInputDTO;
import com.correction.backend.modules.handleCorrection.entity.HandleCorrection;
import com.correction.frameworks.mybatis.mybatis.core.mapper.BaseMapperX;
import org.apache.ibatis.annotations.Param;
//import com.baomidou.mybatisplus.core.mapper.BaseMapperX;

/**
 * <p>
 * 办理入矫表 Mapper 接口
 * </p>
 *
 * @author yao
 * @since 2022-11-21
 */
public interface HandleCorrectionMapper extends BaseMapperX<HandleCorrection> {

    IPage<HandleCorrectionListDTO> getPageListFlow(@Param("page") IPage page,@Param("query") HandleCorrectionSearchInputDTO query);

    IPage<HandleCorrectionListDTO> getPageAllListFlow(@Param("page") IPage page,@Param("query") HandleCorrectionSearchInputDTO query);


}
