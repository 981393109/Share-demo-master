package com.correction.backend.modules.sys.convert.sys;

import com.correction.backend.modules.sys.controller.dto.sys.DictOutDTO;
import com.correction.backend.modules.sys.entity.Dict;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MDictConvert {

    MDictConvert INSTANCE = Mappers.getMapper(MDictConvert.class);

    List<DictOutDTO> convertList (List<Dict> list);

}
