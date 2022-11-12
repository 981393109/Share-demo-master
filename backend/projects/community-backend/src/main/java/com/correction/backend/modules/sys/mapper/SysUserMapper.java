package com.correction.backend.modules.sys.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.correction.backend.modules.sys.controller.dto.user.SysUserSearchDTO;
import com.correction.backend.modules.sys.entity.SysUserDO;
import com.correction.framework.common.enums.CommonStatusEnum;
import com.correction.framework.common.pojo.PageResult;
import com.correction.frameworks.mybatis.mybatis.core.mapper.BaseMapperX;
import com.correction.frameworks.mybatis.mybatis.core.query.QueryWrapperX;
import org.apache.ibatis.annotations.Mapper;

import java.util.Collection;

@Mapper
public interface SysUserMapper  extends BaseMapperX<SysUserDO> {

    default SysUserDO selectByUserName(String username) {
        return selectOne(new QueryWrapper<SysUserDO>().eq("username", username));
    }

    default SysUserDO selectByUserCode(String usercode) {
        return selectOne(new QueryWrapper<SysUserDO>().eq("user_code", usercode));
    }

    default SysUserDO selectByUserNumber(String userNumber) {
        return selectOne(new QueryWrapper<SysUserDO>().eq("user_number", userNumber));
    }

    default PageResult<SysUserDO> selectPage(SysUserSearchDTO reqDTO) {
        return selectPage(reqDTO, new QueryWrapperX<SysUserDO>()
                .likeIfPresent("user_name", reqDTO.getUserName())
                .likeIfPresent("user_number", reqDTO.getUserNumber())
                .likeIfPresent("contact_information", reqDTO.getContactInformation())
                .likeIfPresent("user_jobs", reqDTO.getUserJobs())
                .eqIfPresent("org_id", reqDTO.getOrgId())
                .eqIfPresent("status", reqDTO.getStatus())
                .eq("deleted", CommonStatusEnum.ENABLE.getStatus()));
    }


}
