package com.correction.backend.modules.sys.convert.user;

import com.correction.backend.modules.sys.controller.dto.user.SysUserCreateReqDTO;
import com.correction.backend.modules.sys.controller.dto.user.SysUserUpdateReqDTO;
import com.correction.backend.modules.sys.controller.vo.user.SysUserInfoVO;
import com.correction.backend.modules.sys.controller.vo.user.SysUserPageVO;
import com.correction.backend.modules.sys.entity.SysUserDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SysUserConvert {

    SysUserConvert INSTANCE = Mappers.getMapper(SysUserConvert.class);

    SysUserDO convert(SysUserCreateReqDTO bean);

    SysUserDO convert(SysUserUpdateReqDTO bean);

    SysUserPageVO convertPage(SysUserDO bean);

    SysUserInfoVO convertInfo(SysUserDO bean);

    List<SysUserPageVO> convertList(List<SysUserDO> beans);

}
