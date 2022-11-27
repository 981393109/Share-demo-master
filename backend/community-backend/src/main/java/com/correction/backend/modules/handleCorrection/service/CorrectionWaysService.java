package com.correction.backend.modules.handleCorrection.service;

import com.correction.backend.modules.handleCorrection.controller.dto.*;
import com.correction.backend.modules.handleCorrection.entity.CorrectionGroup;
import com.correction.backend.modules.handleCorrection.entity.CorrectionWays;
import com.baomidou.mybatisplus.extension.service.IService;
import com.correction.framework.common.pojo.PageResult;

import java.util.List;

/**
 * <p>
 * 矫正方案 服务类
 * </p>
 *
 * @author yao
 * @since 2022-11-23
 */
public interface CorrectionWaysService extends IService<CorrectionWays> {


    /**
     * 新建矫正档案
     */
    CorrectionWays createCorrectionWays (CorrectionWaysCreateInputDTO reqDTO);


    /**
     * 编辑矫正档案
     */
    CorrectionWays updateCorrectionWays (CorrectionWaysUpdateInputDTO reqDTO);

    CorrectionWays get (Long id );


    CorrectionWays getByCorrectionId (Long id );


    /**
     * 删除矫正档案信息
     */
    void delete ( Long id );

    /**
     * 获取矫正档案列表
     */
    PageResult<CorrectionWays> getPageList (CorrectionWaysSearchInputDTO searchInputDTO);


    List<CorrectionWays> getList (CorrectionWaysSearchDTO searchInputDTO);


    CorrectionWaysGroupOutDTO createAndGroup(CorrectionWaysAndGroupCreate reqDTO);
}
