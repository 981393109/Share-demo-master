package com.correction.backend.modules.termination.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.correction.backend.modules.termination.controller.dto.*;
import com.correction.backend.modules.termination.entity.TerminationCorrect;
import com.baomidou.mybatisplus.extension.service.IService;
import com.correction.backend.modules.termination.entity.TerminationSolutions;

/**
 * <p>
 * 矫正终止 服务类
 * </p>
 *
 * @author yao
 * @since 2022-12-18
 */
public interface TerminationCorrectService extends IService<TerminationCorrect> {

    /**
     * 新增
     */
    TerminationCorrect create (TerminationCorrectCreateInputDTO createInputDTO);

    /**
     * 修改
     */
    TerminationCorrect update (TerminationCorrectUpdateInputDTO updateInputDTO);


    TerminationCorrect update (TerminationCorrect updateInputDTO);

    /**
     * 获取详情
     */
    TerminationCorrectDetailDTO getDetail (Long id);

    /**
     * 删除
     */
    void delete (Long id );

    /**
     * 获取列表
     */
    IPage<TerminationCorrectPageListDTO> getPageList (TerminationCorrectSearchInputDTO searchInputDTO);


}
