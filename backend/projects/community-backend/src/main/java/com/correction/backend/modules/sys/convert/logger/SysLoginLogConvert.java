package com.correction.backend.modules.sys.convert.logger;

import com.correction.backend.modules.sys.controller.dto.logger.SysLoginLogCreateReqDTO;
import com.correction.backend.modules.sys.entity.SysLoginLogDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SysLoginLogConvert {

    SysLoginLogConvert INSTANCE = Mappers.getMapper(SysLoginLogConvert.class);

    SysLoginLogDO convert(SysLoginLogCreateReqDTO bean);


}
