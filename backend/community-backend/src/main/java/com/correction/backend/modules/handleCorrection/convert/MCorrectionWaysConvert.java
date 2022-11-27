package com.correction.backend.modules.handleCorrection.convert;

import com.correction.backend.modules.handleCorrection.controller.dto.CorrectionWaysCreateInputDTO;
import com.correction.backend.modules.handleCorrection.controller.dto.CorrectionWaysListOutputDTO;
import com.correction.backend.modules.handleCorrection.controller.dto.CorrectionWaysSearchInputDTO;
import com.correction.backend.modules.handleCorrection.controller.dto.CorrectionWaysUpdateInputDTO;
import com.correction.backend.modules.handleCorrection.entity.CorrectionWays;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Author：yao
 * @Description: 矫正方案 转换类
 * @Date: 2022-11-23
 */

@Mapper
public interface MCorrectionWaysConvert {

    MCorrectionWaysConvert INSTANCE = Mappers.getMapper(MCorrectionWaysConvert.class);

    CorrectionWays toCorrectionWays(CorrectionWaysSearchInputDTO correctionWaysSearchInputDTO);

    CorrectionWays toCorrectionWays(CorrectionWaysCreateInputDTO correctionWaysCreateInputDTO);

    CorrectionWays toCorrectionWays(CorrectionWaysUpdateInputDTO correctionWaysUpdateInputDTO);

    CorrectionWaysListOutputDTO toList(CorrectionWays correctionWays);

    List<CorrectionWaysListOutputDTO> toList(List<CorrectionWays> correctionWayss);
}