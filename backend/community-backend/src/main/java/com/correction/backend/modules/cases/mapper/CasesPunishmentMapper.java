package com.correction.backend.modules.cases.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.correction.backend.modules.cases.controller.dto.CasesPunishmentPageListDTO;
import com.correction.backend.modules.cases.controller.dto.CasesPunishmentSearchInputDTO;
import com.correction.backend.modules.cases.entity.CasesPunishment;
import com.correction.frameworks.mybatis.mybatis.core.mapper.BaseMapperX;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 处罚案件 Mapper 接口
 * </p>
 *
 * @author yao
 * @since 2022-12-17
 */
public interface CasesPunishmentMapper extends BaseMapperX<CasesPunishment> {

    IPage<CasesPunishmentPageListDTO> getPageListFlow(@Param("page")IPage<CasesPunishmentPageListDTO> page,@Param("query") CasesPunishmentSearchInputDTO query);


    IPage<CasesPunishmentPageListDTO> getPageAllListFlow(@Param("page")IPage<CasesPunishmentPageListDTO> page,@Param("query") CasesPunishmentSearchInputDTO query);
}
