package com.correction.backend.modules.handleCorrection.convert;

import com.correction.backend.modules.handleCorrection.controller.dto.CorrectionUserCreateInputDTO;
import com.correction.backend.modules.handleCorrection.controller.dto.CorrectionUserListOutputDTO;
import com.correction.backend.modules.handleCorrection.controller.dto.CorrectionUserSearchInputDTO;
import com.correction.backend.modules.handleCorrection.controller.dto.CorrectionUserUpdateInputDTO;
import com.correction.backend.modules.handleCorrection.entity.CorrectionUser;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Author：yao
 * @Description: 矫正人员 转换类
 * @Date: 2022-11-23
 */

@Mapper
public interface MCorrectionUserConvert {

    MCorrectionUserConvert INSTANCE = Mappers.getMapper(MCorrectionUserConvert.class);

    CorrectionUser toCorrectionUser(CorrectionUserSearchInputDTO correctionUserSearchInputDTO);

    CorrectionUser toCorrectionUser(CorrectionUserCreateInputDTO correctionUserCreateInputDTO);

    CorrectionUser toCorrectionUser(CorrectionUserUpdateInputDTO correctionUserUpdateInputDTO);

    CorrectionUserListOutputDTO toList(CorrectionUser correctionUser);

    List<CorrectionUserListOutputDTO> toList(List<CorrectionUser> correctionUsers);
}