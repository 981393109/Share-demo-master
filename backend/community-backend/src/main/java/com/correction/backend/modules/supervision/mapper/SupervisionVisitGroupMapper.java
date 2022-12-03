package com.correction.backend.modules.supervision.mapper;

import com.correction.backend.modules.supervision.entity.SupervisionVisitGroup;
import com.correction.frameworks.mybatis.mybatis.core.mapper.BaseMapperX;
import org.apache.ibatis.annotations.Param;
//import com.baomidou.mybatisplus.core.mapper.BaseMapperX;

/**
 * <p>
 * 走访小组 Mapper 接口
 * </p>
 *
 * @author yao
 * @since 2022-12-03
 */
public interface SupervisionVisitGroupMapper extends BaseMapperX<SupervisionVisitGroup> {

    void deleteByDataId(@Param("dataId") Long dataId);
}
