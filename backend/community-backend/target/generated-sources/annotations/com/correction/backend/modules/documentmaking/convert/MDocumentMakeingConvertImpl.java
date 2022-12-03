package com.correction.backend.modules.documentmaking.convert;

import com.correction.backend.modules.documentmaking.controller.dto.DocumentMakingDTO;
import com.correction.backend.modules.documentmaking.entity.DocumentMakeing;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-03T15:42:12+0800",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 1.8.0_211 (Oracle Corporation)"
)
public class MDocumentMakeingConvertImpl implements MDocumentMakeingConvert {

    @Override
    public DocumentMakeing toMakeing(DocumentMakingDTO dto) {
        if ( dto == null ) {
            return null;
        }

        DocumentMakeing documentMakeing = new DocumentMakeing();

        documentMakeing.setDataId( dto.getDataId() );
        documentMakeing.setDataType( dto.getDataType() );

        return documentMakeing;
    }
}
