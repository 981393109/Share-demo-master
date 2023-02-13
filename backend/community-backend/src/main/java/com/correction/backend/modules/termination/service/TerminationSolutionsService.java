package com.correction.backend.modules.termination.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.correction.backend.modules.termination.controller.dto.*;
import com.correction.backend.modules.termination.entity.TerminationSolutions;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 期满解矫 服务类
 * </p>
 *
 * @author yao
 * @since 2022-12-18
 */
public interface TerminationSolutionsService extends IService<TerminationSolutions> {

    /**
     * 新增
     */
    TerminationSolutions create (TerminationSolutionsCreateInputDTO createInputDTO);

    /**
     * 修改
     */
    TerminationSolutions update (TerminationSolutionsUpdateInputDTO updateInputDTO);


    TerminationSolutions update (TerminationSolutions updateInputDTO);

    /**
     * 获取详情
     */
    TerminationSolutionDetailDTO getDetail (Long id);

    /**
     * 删除
     */
    void delete (Long id );

    /**
     * 获取列表
     */
    IPage<TerminationSolutionsPageListDTO> getPageList (TerminationSolutionsSearchInputDTO solutionsSearchInputDTO);


    IPage<TerminationSolutionsPageListDTO> getPageAllList (TerminationSolutionsSearchInputDTO solutionsSearchInputDTO);

    void autoCreateTerminationRecord();
}
