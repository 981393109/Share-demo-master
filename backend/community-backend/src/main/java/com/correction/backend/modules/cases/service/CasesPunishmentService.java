package com.correction.backend.modules.cases.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.correction.backend.modules.cases.controller.dto.*;
import com.correction.backend.modules.cases.entity.CasesPunishment;
import com.baomidou.mybatisplus.extension.service.IService;
import com.correction.framework.common.pojo.PageResult;

/**
 * <p>
 * 处罚案件 服务类
 * </p>
 *
 * @author yao
 * @since 2022-12-17
 */
public interface CasesPunishmentService extends IService<CasesPunishment> {


    /**
     * 新增处罚案件
     */
    CasesPunishment createCasesPunishment (CasesPunishmentCreateInputDTO casesPunishmentCreateInputDTO);

    /**
     * 修改处罚案件
     */
    CasesPunishment updatePunishment (CasesPunishmentUpdateInputDTO updateInputDTO);

    /**
     * 修改
     */
    CasesPunishment updatePunishment (CasesPunishment casesPunishment);

    /**
     * 获取详情
     */
    CasesPunishmentDetailDTO getDetail (Long id );

    /**
     * 删除
     */
    void delete (Long id );

    /**
     * 获取列表
     */
    IPage<CasesPunishmentPageListDTO> getPageList (CasesPunishmentSearchInputDTO searchInputDTO);


}
