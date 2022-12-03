package com.correction.backend.modules.supervision.convert;

import com.correction.backend.modules.supervision.controller.dto.SupervisionVisitGroupCreateInputDTO;
import com.correction.backend.modules.supervision.controller.dto.SupervisionVisitGroupListOutputDTO;
import com.correction.backend.modules.supervision.controller.dto.SupervisionVisitGroupSearchInputDTO;
import com.correction.backend.modules.supervision.controller.dto.SupervisionVisitGroupUpdateInputDTO;
import com.correction.backend.modules.supervision.entity.SupervisionVisitGroup;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Author：yao
 * @Description: 走访小组 转换类
 * @Date: 2022-12-03
 */

@Mapper
public interface MSupervisionVisitGroupConvert {

    MSupervisionVisitGroupConvert INSTANCE = Mappers.getMapper(MSupervisionVisitGroupConvert.class);

    SupervisionVisitGroup toSupervisionVisitGroup(SupervisionVisitGroupSearchInputDTO supervisionVisitGroupSearchInputDTO);

    SupervisionVisitGroup toSupervisionVisitGroup(SupervisionVisitGroupCreateInputDTO supervisionVisitGroupCreateInputDTO);

    SupervisionVisitGroup toSupervisionVisitGroup(SupervisionVisitGroupUpdateInputDTO supervisionVisitGroupUpdateInputDTO);

    SupervisionVisitGroupListOutputDTO toList(SupervisionVisitGroup supervisionVisitGroup);

    List<SupervisionVisitGroupListOutputDTO> toList(List<SupervisionVisitGroup> supervisionVisitGroups);

    List<SupervisionVisitGroup> toVisitGroup (List<SupervisionVisitGroupCreateInputDTO> createInputDTO);
}