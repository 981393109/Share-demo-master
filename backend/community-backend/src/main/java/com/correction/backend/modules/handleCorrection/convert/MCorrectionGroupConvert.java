package com.correction.backend.modules.handleCorrection.convert;

import com.correction.backend.modules.handleCorrection.controller.dto.CorrectionGroupCreateInputDTO;
import com.correction.backend.modules.handleCorrection.controller.dto.CorrectionGroupListOutputDTO;
import com.correction.backend.modules.handleCorrection.controller.dto.CorrectionGroupSearchInputDTO;
import com.correction.backend.modules.handleCorrection.controller.dto.CorrectionGroupUpdateInputDTO;
import com.correction.backend.modules.handleCorrection.entity.CorrectionGroup;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Author：yao
 * @Description: 矫正小组 转换类
 * @Date: 2022-11-23
 */

@Mapper
public interface MCorrectionGroupConvert {

    MCorrectionGroupConvert INSTANCE = Mappers.getMapper(MCorrectionGroupConvert.class);

    CorrectionGroup toCorrectionGroup(CorrectionGroupSearchInputDTO correctionGroupSearchInputDTO);

    CorrectionGroup toCorrectionGroup(CorrectionGroupCreateInputDTO correctionGroupCreateInputDTO);

    CorrectionGroup toCorrectionGroup(CorrectionGroupUpdateInputDTO correctionGroupUpdateInputDTO);

    CorrectionGroupListOutputDTO toList(CorrectionGroup correctionGroup);

    List<CorrectionGroupListOutputDTO> toList(List<CorrectionGroup> correctionGroups);
}