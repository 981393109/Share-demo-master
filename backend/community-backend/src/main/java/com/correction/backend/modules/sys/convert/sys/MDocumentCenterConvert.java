package com.correction.backend.modules.sys.convert.sys;

import com.correction.backend.modules.sys.controller.dto.sys.DocumentCenterCreateInputDTO;
import com.correction.backend.modules.sys.controller.dto.sys.DocumentCenterListOutputDTO;
import com.correction.backend.modules.sys.controller.dto.sys.DocumentCenterSearchInputDTO;
import com.correction.backend.modules.sys.controller.dto.sys.DocumentCenterUpdateInputDTO;
import com.correction.backend.modules.sys.entity.DocumentCenter;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Author：yao
 * @Description: 文书参考 转换类
 * @Date: 2023-02-04
 */

@Mapper
public interface MDocumentCenterConvert {

    MDocumentCenterConvert INSTANCE = Mappers.getMapper(MDocumentCenterConvert.class);

    DocumentCenter toDocumentCenter(DocumentCenterSearchInputDTO documentCenterSearchInputDTO);

    DocumentCenter toDocumentCenter(DocumentCenterCreateInputDTO documentCenterCreateInputDTO);

    DocumentCenter toDocumentCenter(DocumentCenterUpdateInputDTO documentCenterUpdateInputDTO);

    DocumentCenterListOutputDTO toList(DocumentCenter documentCenter);

    List<DocumentCenterListOutputDTO> toList(List<DocumentCenter> documentCenters);
}