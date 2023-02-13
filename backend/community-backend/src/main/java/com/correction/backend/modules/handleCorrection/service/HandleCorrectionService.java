package com.correction.backend.modules.handleCorrection.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.correction.backend.modules.handleCorrection.controller.dto.*;
import com.correction.backend.modules.handleCorrection.entity.HandleCorrection;
import com.baomidou.mybatisplus.extension.service.IService;
import com.correction.framework.common.pojo.PageResult;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * <p>
 * 办理入矫表 服务类
 * </p>
 *
 * @author yao
 * @since 2022-11-21
 */
public interface HandleCorrectionService extends IService<HandleCorrection> {

    HandleCorrection createHandleCorrection (HandleCorrectionCreateInputDTO correctionCreateInputDTO);

    HandleCorrection updateHandleCorrection (HandleCorrectionUpdateInputDTO correctionUpdateInputDTO);

    HandleCorrection updateHandleCorrection (HandleCorrection correction);

    void delete ( Long id );

    HandleCorrectionFilesDTO getDetail(Long id );

    List<HandleCorrection> getList (HandleCorrectionSearchInputDTO searchInputDTO);

    IPage<HandleCorrectionListDTO> getPageList (HandleCorrectionSearchInputDTO searchInputDTO);

    IPage<HandleCorrectionListDTO> getPageAllList(HandleCorrectionSearchInputDTO reqVO);
}
