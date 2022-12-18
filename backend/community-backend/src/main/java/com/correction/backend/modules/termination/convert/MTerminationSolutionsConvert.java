package com.correction.backend.modules.termination.convert;

import com.correction.backend.modules.termination.controller.dto.TerminationSolutionsCreateInputDTO;
import com.correction.backend.modules.termination.controller.dto.TerminationSolutionsListOutputDTO;
import com.correction.backend.modules.termination.controller.dto.TerminationSolutionsSearchInputDTO;
import com.correction.backend.modules.termination.controller.dto.TerminationSolutionsUpdateInputDTO;
import com.correction.backend.modules.termination.entity.TerminationSolutions;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Author：yao
 * @Description: 期满解矫 转换类
 * @Date: 2022-12-18
 */

@Mapper
public interface MTerminationSolutionsConvert {

    MTerminationSolutionsConvert INSTANCE = Mappers.getMapper(MTerminationSolutionsConvert.class);

    TerminationSolutions toTerminationSolutions(TerminationSolutionsSearchInputDTO terminationSolutionsSearchInputDTO);

    TerminationSolutions toTerminationSolutions(TerminationSolutionsCreateInputDTO terminationSolutionsCreateInputDTO);

    TerminationSolutions toTerminationSolutions(TerminationSolutionsUpdateInputDTO terminationSolutionsUpdateInputDTO);

    TerminationSolutionsListOutputDTO toList(TerminationSolutions terminationSolutions);

    List<TerminationSolutionsListOutputDTO> toList(List<TerminationSolutions> terminationSolutionss);
}