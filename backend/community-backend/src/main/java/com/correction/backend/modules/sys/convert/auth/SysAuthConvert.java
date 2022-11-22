package com.correction.backend.modules.sys.convert.auth;


import com.correction.backend.modules.sys.entity.SysUserDO;
import com.correction.framework.web.web.LoginUser;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


@Mapper
public interface SysAuthConvert {

    SysAuthConvert INSTANCE = Mappers.getMapper(SysAuthConvert.class);

    @Mapping(source = "updateTime", target = "updateTime", ignore = true)
    LoginUser convert(SysUserDO bean);



}
