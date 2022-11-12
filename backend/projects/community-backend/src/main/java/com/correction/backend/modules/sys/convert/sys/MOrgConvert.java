package com.correction.backend.modules.sys.convert.sys;

import com.correction.backend.modules.sys.controller.dto.sys.OrgCreateInputDTO;
import com.correction.backend.modules.sys.controller.dto.sys.OrgListOutputDTO;
import com.correction.backend.modules.sys.controller.dto.sys.OrgSearchInputDTO;
import com.correction.backend.modules.sys.controller.dto.sys.OrgUpdateInputDTO;
import com.correction.backend.modules.sys.entity.OrgDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Primary;

import java.util.List;

/**
 * @Author：yao
 * @Description: 组织表 转换类
 * @Date: 2022-11-12
 */
@Mapper
public interface MOrgConvert {

    MOrgConvert INSTANCE = Mappers.getMapper(MOrgConvert.class);

    OrgDO toOrg(OrgSearchInputDTO orgSearchInputDTO);

    OrgDO toOrg(OrgCreateInputDTO orgCreateInputDTO);

    OrgDO toOrg(OrgUpdateInputDTO orgUpdateInputDTO);

    OrgListOutputDTO toList(OrgDO org);

    List<OrgListOutputDTO> toList(List<OrgDO> orgs);
}