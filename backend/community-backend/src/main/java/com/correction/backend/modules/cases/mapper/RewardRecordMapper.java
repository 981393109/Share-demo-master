package com.correction.backend.modules.cases.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.correction.backend.modules.cases.controller.dto.RewardRecordPageListDTO;
import com.correction.backend.modules.cases.controller.dto.RewardRecordSearchInputDTO;
import com.correction.backend.modules.cases.entity.RewardRecord;
import com.correction.frameworks.mybatis.mybatis.core.mapper.BaseMapperX;
import org.apache.ibatis.annotations.Param;
//import com.baomidou.mybatisplus.core.mapper.BaseMapperX;

/**
 * <p>
 * 奖励记录 Mapper 接口
 * </p>
 *
 * @author yao
 * @since 2022-12-17
 */
public interface RewardRecordMapper extends BaseMapperX<RewardRecord> {

    IPage<RewardRecordPageListDTO> getPageListFlow(@Param("page")IPage<RewardRecordPageListDTO> mpPage, @Param("query") RewardRecordSearchInputDTO query);
}
