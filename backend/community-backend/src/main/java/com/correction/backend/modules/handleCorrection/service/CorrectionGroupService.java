package com.correction.backend.modules.handleCorrection.service;

import com.correction.backend.modules.handleCorrection.controller.dto.*;
import com.correction.backend.modules.handleCorrection.entity.CorrectionGroup;
import com.baomidou.mybatisplus.extension.service.IService;
import com.correction.backend.modules.handleCorrection.entity.CorrectionUser;
import com.correction.framework.common.pojo.PageResult;

import java.util.List;

/**
 * <p>
 * 矫正小组 服务类
 * </p>
 *
 * @author yao
 * @since 2022-11-23
 */
public interface CorrectionGroupService extends IService<CorrectionGroup> {


    /**
     * 新建矫正档案
     */
    CorrectionGroup createCorrectionGroup (CorrectionGroupCreateInputDTO reqDTO);


    /**
     * 编辑矫正档案
     */
    CorrectionGroup updateCorrectionGroup (CorrectionGroupUpdateInputDTO reqDTO);

    CorrectionGroup get (Long id );


    List<CorrectionGroup> getByCorrectionId (Long id );


    /**
     * 删除矫正档案信息
     */
    void delete ( Long id );

    /**
     * 获取矫正档案列表
     */
    PageResult<CorrectionGroup> getPageList (CorrectionGroupSearchInputDTO searchInputDTO);


    List<CorrectionGroup> getList (CorrectionGroupSearchDTO searchInputDTO);


    List<Long> batchCreate(List<CorrectionGroupUpdateInputDTO> reqDTO);
}
