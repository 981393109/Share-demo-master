package com.correction.backend.modules.education.convert;

import com.correction.backend.modules.education.controller.dto.EducationIdeologyCreateInputDTO;
import com.correction.backend.modules.education.controller.dto.EducationIdeologyListOutputDTO;
import com.correction.backend.modules.education.controller.dto.EducationIdeologySearchInputDTO;
import com.correction.backend.modules.education.controller.dto.EducationIdeologyUpdateInputDTO;
import com.correction.backend.modules.education.entity.EducationIdeology;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Author：yao
 * @Description: 思想汇报 转换类
 * @Date: 2022-12-12
 */

@Mapper
public interface MEducationIdeologyConvert {

    MEducationIdeologyConvert INSTANCE = Mappers.getMapper(MEducationIdeologyConvert.class);

    EducationIdeology toEducationIdeology(EducationIdeologySearchInputDTO educationIdeologySearchInputDTO);

    EducationIdeology toEducationIdeology(EducationIdeologyCreateInputDTO educationIdeologyCreateInputDTO);

    EducationIdeology toEducationIdeology(EducationIdeologyUpdateInputDTO educationIdeologyUpdateInputDTO);

    EducationIdeologyListOutputDTO toList(EducationIdeology educationIdeology);

    List<EducationIdeologyListOutputDTO> toList(List<EducationIdeology> educationIdeologys);
}