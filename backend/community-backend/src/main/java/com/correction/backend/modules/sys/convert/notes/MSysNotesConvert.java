package com.correction.backend.modules.sys.convert.notes;

import com.correction.backend.modules.sys.controller.dto.notes.SysNotesCreateInputDTO;
import com.correction.backend.modules.sys.entity.SysNotes;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Author：yao
 * @Description:  转换类
 * @Date: 2022-12-18
 */

@Mapper
public interface MSysNotesConvert {

    MSysNotesConvert INSTANCE = Mappers.getMapper(MSysNotesConvert.class);

    SysNotes toSysNotes(SysNotesCreateInputDTO sysNotesSearchInputDTO);


}