package com.correction.backend.modules.handleCorrection.convert;

import com.correction.backend.modules.handleCorrection.controller.dto.HandleCorrectionCreateInputDTO;
import com.correction.backend.modules.handleCorrection.controller.dto.HandleCorrectionListOutputDTO;
import com.correction.backend.modules.handleCorrection.controller.dto.HandleCorrectionSearchInputDTO;
import com.correction.backend.modules.handleCorrection.controller.dto.HandleCorrectionUpdateInputDTO;
import com.correction.backend.modules.handleCorrection.entity.HandleCorrection;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Author：yao
 * @Description: 办理入矫表 转换类
 * @Date: 2022-11-21
 */

@Mapper
public interface MHandleCorrectionConvert {

    MHandleCorrectionConvert INSTANCE = Mappers.getMapper(MHandleCorrectionConvert.class);

    HandleCorrection toHandleCorrection(HandleCorrectionSearchInputDTO handleCorrectionSearchInputDTO);

    HandleCorrection toHandleCorrection(HandleCorrectionCreateInputDTO handleCorrectionCreateInputDTO);

    HandleCorrection toHandleCorrection(HandleCorrectionUpdateInputDTO handleCorrectionUpdateInputDTO);

    HandleCorrectionListOutputDTO toList(HandleCorrection handleCorrection);

    List<HandleCorrectionListOutputDTO> toList(List<HandleCorrection> handleCorrections);

}