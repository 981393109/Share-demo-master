package com.correction.backend.modules.sys.mapper;

import com.correction.backend.modules.sys.controller.dto.sys.RoleSearchInputDTO;
import com.correction.backend.modules.sys.entity.Role;
import com.correction.framework.common.enums.CommonStatusEnum;
import com.correction.framework.common.pojo.PageResult;
import com.correction.frameworks.mybatis.mybatis.core.mapper.BaseMapperX;
import com.correction.frameworks.mybatis.mybatis.core.query.QueryWrapperX;

import java.util.List;
//import com.baomidou.mybatisplus.core.mapper.BaseMapperX;

/**
 * <p>
 * 角色-用户关联表 Mapper 接口
 * </p>
 *
 * @author yao
 * @since 2022-11-12
 */
public interface RoleMapper extends BaseMapperX<Role> {

    default List<Role> selectList(RoleSearchInputDTO reqDTO) {
        return selectList(new QueryWrapperX<Role>()
                .likeIfPresent("role_name", reqDTO.getRoleName())
                .eq("deleted", CommonStatusEnum.ENABLE.getStatus()));
    }

    default PageResult<Role> selectPage(RoleSearchInputDTO reqDTO) {
        return selectPage(reqDTO,new QueryWrapperX<Role>()
                .likeIfPresent("role_name", reqDTO.getRoleName())
                .eq("deleted", CommonStatusEnum.ENABLE.getStatus()));
    }

}
