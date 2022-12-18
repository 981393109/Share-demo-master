package com.correction.backend.modules.cases.convert;

import com.correction.backend.modules.cases.controller.dto.CasesPunishmentCreateInputDTO;
import com.correction.backend.modules.cases.controller.dto.CasesPunishmentListOutputDTO;
import com.correction.backend.modules.cases.controller.dto.CasesPunishmentSearchInputDTO;
import com.correction.backend.modules.cases.controller.dto.CasesPunishmentUpdateInputDTO;
import com.correction.backend.modules.cases.entity.CasesPunishment;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Author：yao
 * @Description: 处罚案件 转换类
 * @Date: 2022-12-17
 */

@Mapper
public interface MCasesPunishmentConvert {

    MCasesPunishmentConvert INSTANCE = Mappers.getMapper(MCasesPunishmentConvert.class);

    CasesPunishment toCasesPunishment(CasesPunishmentSearchInputDTO casesPunishmentSearchInputDTO);

    CasesPunishment toCasesPunishment(CasesPunishmentCreateInputDTO casesPunishmentCreateInputDTO);

    CasesPunishment toCasesPunishment(CasesPunishmentUpdateInputDTO casesPunishmentUpdateInputDTO);

    CasesPunishmentListOutputDTO toList(CasesPunishment casesPunishment);

    List<CasesPunishmentListOutputDTO> toList(List<CasesPunishment> casesPunishments);
}