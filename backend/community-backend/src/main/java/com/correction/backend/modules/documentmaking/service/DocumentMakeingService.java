package com.correction.backend.modules.documentmaking.service;

import com.correction.backend.modules.documentmaking.controller.dto.DocumentMakingDTO;
import com.correction.backend.modules.documentmaking.entity.DocumentMakeing;
import com.baomidou.mybatisplus.extension.service.IService;

import java.io.IOException;

/**
 * <p>
 * 制作文书 服务类
 * </p>
 *
 * @author yao
 * @since 2022-11-26
 */
public interface DocumentMakeingService extends IService<DocumentMakeing> {


    /**
     * 制作文书
     */
    String makingDocFile (DocumentMakingDTO dto) throws Exception;


    DocumentMakeing getMaking(DocumentMakingDTO reqDTO);
}
