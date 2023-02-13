package com.correction.backend.modules.cases.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.correction.backend.modules.cases.controller.dto.*;
import com.correction.backend.modules.cases.entity.CasesPunishment;
import com.correction.backend.modules.cases.entity.RewardRecord;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 奖励记录 服务类
 * </p>
 *
 * @author yao
 * @since 2022-12-17
 */
public interface RewardRecordService extends IService<RewardRecord> {

    /**
     * 新增处罚案件
     */
    RewardRecord createRewardRecord (RewardRecordCreateInputDTO createInputDTO);

    /**
     * 修改处罚案件
     */
    RewardRecord updateRewardRecord (RewardRecordUpdateInputDTO updateInputDTO);

    /**
     * 修改
     */
    RewardRecord updateRewardRecord (RewardRecord rewardRecord);

    /**
     * 获取详情
     */
    RewardRecordDetailDTO getDetail (Long id );

    /**
     * 删除
     */
    void delete (Long id );

    /**
     * 获取列表
     */
    IPage<RewardRecordPageListDTO> getPageList (RewardRecordSearchInputDTO searchInputDTO);

    IPage<RewardRecordPageListDTO> getPageAllList (RewardRecordSearchInputDTO searchInputDTO);




}
