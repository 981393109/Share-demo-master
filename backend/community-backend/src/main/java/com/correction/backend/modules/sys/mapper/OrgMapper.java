package com.correction.backend.modules.sys.mapper;


import com.correction.backend.modules.sys.controller.dto.sys.OrgSearchInputDTO;
import com.correction.backend.modules.sys.entity.OrgDO;
import com.correction.framework.common.enums.CommonStatusEnum;
import com.correction.framework.common.pojo.PageResult;
import com.correction.frameworks.mybatis.mybatis.core.mapper.BaseMapperX;
import com.correction.frameworks.mybatis.mybatis.core.query.QueryWrapperX;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 组织表 Mapper 接口
 * </p>
 *
 * @author yao
 * @since 2022-11-12
 */
@Mapper
public interface OrgMapper extends BaseMapperX<OrgDO> {

    default PageResult<OrgDO> selectPage(OrgSearchInputDTO reqDTO) {
        return selectPage(reqDTO, new QueryWrapperX<OrgDO>()
                .likeIfPresent("org_name", reqDTO.getOrgName())
                .likeIfPresent("org_num", reqDTO.getOrgNum())
                .likeIfPresent("org_code", reqDTO.getOrgCode())
                .eqIfPresent("org_type", reqDTO.getOrgType())
                .eq("deleted", CommonStatusEnum.ENABLE.getStatus()));
    }


}
