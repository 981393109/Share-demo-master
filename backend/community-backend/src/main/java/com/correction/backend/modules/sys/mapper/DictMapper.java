package com.correction.backend.modules.sys.mapper;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.correction.backend.modules.sys.entity.Dict;
import com.correction.frameworks.mybatis.mybatis.core.mapper.BaseMapperX;

import java.util.List;

/**
 * <p>
 * 全局字典表 Mapper 接口
 * </p>
 *
 * @author yao
 * @since 2022-11-12
 */
public interface DictMapper extends BaseMapperX<Dict> {

    default List<Dict> selectDictByType (Integer type) {
        return selectList(Wrappers.<Dict>lambdaQuery().eq(Dict::getDictType,type));
    }

}
