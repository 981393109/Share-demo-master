package com.correction.backend.modules.termination.convert;

import com.correction.backend.modules.termination.controller.dto.TerminationCorrectCreateInputDTO;
import com.correction.backend.modules.termination.controller.dto.TerminationCorrectListOutputDTO;
import com.correction.backend.modules.termination.controller.dto.TerminationCorrectSearchInputDTO;
import com.correction.backend.modules.termination.controller.dto.TerminationCorrectUpdateInputDTO;
import com.correction.backend.modules.termination.entity.TerminationCorrect;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Author：yao
 * @Description: 矫正终止 转换类
 * @Date: 2022-12-18
 */

@Mapper
public interface MTerminationCorrectConvert {

    MTerminationCorrectConvert INSTANCE = Mappers.getMapper(MTerminationCorrectConvert.class);

    TerminationCorrect toTerminationCorrect(TerminationCorrectSearchInputDTO terminationCorrectSearchInputDTO);

    TerminationCorrect toTerminationCorrect(TerminationCorrectCreateInputDTO terminationCorrectCreateInputDTO);

    TerminationCorrect toTerminationCorrect(TerminationCorrectUpdateInputDTO terminationCorrectUpdateInputDTO);

    TerminationCorrectListOutputDTO toList(TerminationCorrect terminationCorrect);

    List<TerminationCorrectListOutputDTO> toList(List<TerminationCorrect> terminationCorrects);
}