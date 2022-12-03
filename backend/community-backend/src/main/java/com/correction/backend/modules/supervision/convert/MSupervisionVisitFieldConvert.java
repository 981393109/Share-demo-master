package com.correction.backend.modules.supervision.convert;

import com.correction.backend.modules.supervision.controller.dto.*;
import com.correction.backend.modules.supervision.entity.SupervisionVisitField;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Author：yao
 * @Description: 查访登记 转换类
 * @Date: 2022-12-03
 */

@Mapper
public interface MSupervisionVisitFieldConvert {

    MSupervisionVisitFieldConvert INSTANCE = Mappers.getMapper(MSupervisionVisitFieldConvert.class);

    SupervisionVisitField toSupervisionVisitField(SupervisionVisitFieldSearchInputDTO supervisionVisitFieldSearchInputDTO);

    SupervisionVisitField toSupervisionVisitField(SupervisionVisitFieldCreateInputDTO supervisionVisitFieldCreateInputDTO);

    SupervisionVisitField toSupervisionVisitField(SupervisionVisitFieldUpdateInputDTO supervisionVisitFieldUpdateInputDTO);

    SupervisionVisitFieldListOutputDTO toList(SupervisionVisitField supervisionVisitField);

    List<SupervisionVisitFieldListOutputDTO> toList(List<SupervisionVisitField> supervisionVisitFields);

    SupervisionVisitFieldDTO toSupervisionVisitFieldDTO(SupervisionVisitField supervisionVisitField);
}