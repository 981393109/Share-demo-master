package com.correction.backend.modules.education.convert;

import com.correction.backend.modules.education.controller.dto.EducationSupportCreateInputDTO;
import com.correction.backend.modules.education.controller.dto.EducationSupportListOutputDTO;
import com.correction.backend.modules.education.controller.dto.EducationSupportSearchInputDTO;
import com.correction.backend.modules.education.controller.dto.EducationSupportUpdateInputDTO;
import com.correction.backend.modules.education.entity.EducationSupport;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Author：yao
 * @Description: 教育帮扶表 转换类
 * @Date: 2022-12-06
 */

@Mapper
public interface MEducationSupportConvert {

    MEducationSupportConvert INSTANCE = Mappers.getMapper(MEducationSupportConvert.class);

    EducationSupport toEducationSupport(EducationSupportSearchInputDTO educationSupportSearchInputDTO);

    EducationSupport toEducationSupport(EducationSupportCreateInputDTO educationSupportCreateInputDTO);

    EducationSupport toEducationSupport(EducationSupportUpdateInputDTO educationSupportUpdateInputDTO);

    EducationSupportListOutputDTO toList(EducationSupport educationSupport);

    List<EducationSupportListOutputDTO> toList(List<EducationSupport> educationSupports);
}