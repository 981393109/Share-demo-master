package com.correction.backend.modules.handleCorrection.service;

import com.correction.backend.modules.handleCorrection.controller.dto.CorrectionUserCreateInputDTO;
import com.correction.backend.modules.handleCorrection.controller.dto.CorrectionUserSearchDTO;
import com.correction.backend.modules.handleCorrection.controller.dto.CorrectionUserSearchInputDTO;
import com.correction.backend.modules.handleCorrection.controller.dto.CorrectionUserUpdateInputDTO;
import com.correction.backend.modules.handleCorrection.entity.CorrectionUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.correction.framework.common.pojo.PageResult;

import java.util.List;

/**
 * <p>
 * 矫正人员 服务类
 * </p>
 *
 * @author yao
 * @since 2022-11-23
 */
public interface CorrectionUserService extends IService<CorrectionUser> {


    /**
     * 新建矫正档案
     */
    CorrectionUser createCorrectionUser (CorrectionUserCreateInputDTO reqDTO);


    /**
     * 编辑矫正档案
     */
    CorrectionUser updateCorrectionUser (CorrectionUserUpdateInputDTO reqDTO);


    CorrectionUser get (Long id );


    CorrectionUser getByCorrectionId (Long id );

    /**
     * 删除矫正档案信息
     */
    void delete ( Long id );

    /**
     * 获取矫正档案列表
     */
    PageResult<CorrectionUser> getPageList (CorrectionUserSearchInputDTO searchInputDTO);

    List<CorrectionUser> getList (CorrectionUserSearchDTO searchInputDTO);


}
