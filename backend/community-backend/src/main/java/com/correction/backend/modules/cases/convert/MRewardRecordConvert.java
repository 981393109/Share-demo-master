package com.correction.backend.modules.cases.convert;

import com.correction.backend.modules.cases.controller.dto.RewardRecordCreateInputDTO;
import com.correction.backend.modules.cases.controller.dto.RewardRecordListOutputDTO;
import com.correction.backend.modules.cases.controller.dto.RewardRecordSearchInputDTO;
import com.correction.backend.modules.cases.controller.dto.RewardRecordUpdateInputDTO;
import com.correction.backend.modules.cases.entity.RewardRecord;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Author：yao
 * @Description: 奖励记录 转换类
 * @Date: 2022-12-17
 */

@Mapper
public interface MRewardRecordConvert {

    MRewardRecordConvert INSTANCE = Mappers.getMapper(MRewardRecordConvert.class);

    RewardRecord toRewardRecord(RewardRecordSearchInputDTO rewardRecordSearchInputDTO);

    RewardRecord toRewardRecord(RewardRecordCreateInputDTO rewardRecordCreateInputDTO);

    RewardRecord toRewardRecord(RewardRecordUpdateInputDTO rewardRecordUpdateInputDTO);

    RewardRecordListOutputDTO toList(RewardRecord rewardRecord);

    List<RewardRecordListOutputDTO> toList(List<RewardRecord> rewardRecords);
}