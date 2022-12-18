package com.correction.backend.modules.education.convert;

import com.correction.backend.modules.education.controller.dto.EducationIndividualCreateInputDTO;
import com.correction.backend.modules.education.controller.dto.EducationIndividualListOutputDTO;
import com.correction.backend.modules.education.controller.dto.EducationIndividualSearchInputDTO;
import com.correction.backend.modules.education.controller.dto.EducationIndividualUpdateInputDTO;
import com.correction.backend.modules.education.entity.EducationIndividual;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Author：yao
 * @Description: 个别教育 转换类
 * @Date: 2022-12-06
 */

@Mapper
public interface MEducationIndividualConvert {

    MEducationIndividualConvert INSTANCE = Mappers.getMapper(MEducationIndividualConvert.class);

    EducationIndividual toEducationIndividual(EducationIndividualSearchInputDTO educationIndividualSearchInputDTO);

    EducationIndividual toEducationIndividual(EducationIndividualCreateInputDTO educationIndividualCreateInputDTO);

    EducationIndividual toEducationIndividual(EducationIndividualUpdateInputDTO educationIndividualUpdateInputDTO);

    EducationIndividualListOutputDTO toList(EducationIndividual educationIndividual);

    List<EducationIndividualListOutputDTO> toList(List<EducationIndividual> educationIndividuals);
}