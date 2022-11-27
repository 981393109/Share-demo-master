package com.correction.backend.modules.documentmaking.convert;

import com.correction.backend.modules.documentmaking.controller.dto.DocumentMakingDTO;
import com.correction.backend.modules.documentmaking.entity.DocumentMakeing;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Author：yao
 * @Description: 制作文书 转换类
 * @Date: 2022-11-26
 */

@Mapper
public interface MDocumentMakeingConvert {

    MDocumentMakeingConvert INSTANCE = Mappers.getMapper(MDocumentMakeingConvert.class);

    DocumentMakeing toMakeing (DocumentMakingDTO dto);
}