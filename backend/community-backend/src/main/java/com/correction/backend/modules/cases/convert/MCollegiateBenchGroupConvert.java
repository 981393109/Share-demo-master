package com.correction.backend.modules.cases.convert;

import com.correction.backend.modules.cases.controller.dto.CollegiateBenchGroupCreateInputDTO;
import com.correction.backend.modules.cases.controller.dto.CollegiateBenchGroupListOutputDTO;
import com.correction.backend.modules.cases.controller.dto.CollegiateBenchGroupSearchInputDTO;
import com.correction.backend.modules.cases.controller.dto.CollegiateBenchGroupUpdateInputDTO;
import com.correction.backend.modules.cases.entity.CollegiateBenchGroup;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Author：yao
 * @Description: 合议小组/评议小组/相关小组表 转换类
 * @Date: 2022-12-17
 */

@Mapper
public interface MCollegiateBenchGroupConvert {

    MCollegiateBenchGroupConvert INSTANCE = Mappers.getMapper(MCollegiateBenchGroupConvert.class);

    CollegiateBenchGroup toCollegiateBenchGroup(CollegiateBenchGroupSearchInputDTO collegiateBenchGroupSearchInputDTO);

    CollegiateBenchGroup toCollegiateBenchGroup(CollegiateBenchGroupCreateInputDTO collegiateBenchGroupCreateInputDTO);

    CollegiateBenchGroup toCollegiateBenchGroup(CollegiateBenchGroupUpdateInputDTO collegiateBenchGroupUpdateInputDTO);

    CollegiateBenchGroupListOutputDTO toList(CollegiateBenchGroup collegiateBenchGroup);

    List<CollegiateBenchGroupListOutputDTO> toList(List<CollegiateBenchGroup> collegiateBenchGroups);
}