package com.correction.backend.modules.documentmaking.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.correction.backend.modules.documentmaking.constant.DocumentMakingConstant;
import com.correction.backend.modules.documentmaking.controller.dto.DocumentMakingDTO;
import com.correction.backend.modules.documentmaking.convert.MDocumentMakeingConvert;
import com.correction.backend.modules.documentmaking.entity.DocumentMakeing;
import com.correction.backend.modules.documentmaking.factory.DocumentMakingFactory;
import com.correction.backend.modules.documentmaking.factory.DocumentService;
import com.correction.backend.modules.documentmaking.mapper.DocumentMakeingMapper;
import com.correction.backend.modules.documentmaking.service.DocumentMakeingService;
import com.correction.backend.modules.flow.constant.FlowConstant;
import com.correction.backend.modules.flow.entity.FlowCenter;
import com.correction.backend.modules.flow.mapper.FlowCenterMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@Slf4j
public class DocumentMakeingServiceImpl extends ServiceImpl<DocumentMakeingMapper, DocumentMakeing> implements DocumentMakeingService {




    @Override
    public String makingDocFile(DocumentMakingDTO dto) throws Exception {
        DocumentService byMaking = DocumentMakingFactory.getByMaking(dto.getDataType());
        String fileUrl = byMaking.makingDoc(dto.getDataId());
        return fileUrl;
    }

    @Override
    public DocumentMakeing getMaking(DocumentMakingDTO reqDTO) {
        DocumentMakeing documentMakeing = baseMapper.selectOne(Wrappers.<DocumentMakeing>lambdaQuery().eq(DocumentMakeing::getDataId, reqDTO.getDataId()).eq(DocumentMakeing::getDataType, reqDTO.getDataType()).last(" limit 1"));
        return documentMakeing;
    }


}
