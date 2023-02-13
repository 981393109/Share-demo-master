package com.correction.backend.modules.sys.convert.sys;

import com.correction.backend.modules.sys.controller.dto.sys.DocumentCenterCreateInputDTO;
import com.correction.backend.modules.sys.controller.dto.sys.DocumentCenterListOutputDTO;
import com.correction.backend.modules.sys.controller.dto.sys.DocumentCenterSearchInputDTO;
import com.correction.backend.modules.sys.controller.dto.sys.DocumentCenterUpdateInputDTO;
import com.correction.backend.modules.sys.entity.DocumentCenter;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-13T01:51:15+0800",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 1.8.0_211 (Oracle Corporation)"
)
public class MDocumentCenterConvertImpl implements MDocumentCenterConvert {

    @Override
    public DocumentCenter toDocumentCenter(DocumentCenterSearchInputDTO documentCenterSearchInputDTO) {
        if ( documentCenterSearchInputDTO == null ) {
            return null;
        }

        DocumentCenter documentCenter = new DocumentCenter();

        documentCenter.setCreateTime( documentCenterSearchInputDTO.getCreateTime() );
        documentCenter.setUpdateTime( documentCenterSearchInputDTO.getUpdateTime() );
        documentCenter.setCreator( documentCenterSearchInputDTO.getCreator() );
        documentCenter.setUpdater( documentCenterSearchInputDTO.getUpdater() );
        documentCenter.setDeleted( documentCenterSearchInputDTO.getDeleted() );
        documentCenter.setUseType( documentCenterSearchInputDTO.getUseType() );
        documentCenter.setStatus( documentCenterSearchInputDTO.getStatus() );
        documentCenter.setFileName( documentCenterSearchInputDTO.getFileName() );
        documentCenter.setFilePath( documentCenterSearchInputDTO.getFilePath() );

        return documentCenter;
    }

    @Override
    public DocumentCenter toDocumentCenter(DocumentCenterCreateInputDTO documentCenterCreateInputDTO) {
        if ( documentCenterCreateInputDTO == null ) {
            return null;
        }

        DocumentCenter documentCenter = new DocumentCenter();

        documentCenter.setCreateTime( documentCenterCreateInputDTO.getCreateTime() );
        documentCenter.setUpdateTime( documentCenterCreateInputDTO.getUpdateTime() );
        documentCenter.setCreator( documentCenterCreateInputDTO.getCreator() );
        documentCenter.setUpdater( documentCenterCreateInputDTO.getUpdater() );
        documentCenter.setDeleted( documentCenterCreateInputDTO.getDeleted() );
        documentCenter.setUseType( documentCenterCreateInputDTO.getUseType() );
        documentCenter.setStatus( documentCenterCreateInputDTO.getStatus() );
        documentCenter.setFileName( documentCenterCreateInputDTO.getFileName() );
        documentCenter.setFilePath( documentCenterCreateInputDTO.getFilePath() );

        return documentCenter;
    }

    @Override
    public DocumentCenter toDocumentCenter(DocumentCenterUpdateInputDTO documentCenterUpdateInputDTO) {
        if ( documentCenterUpdateInputDTO == null ) {
            return null;
        }

        DocumentCenter documentCenter = new DocumentCenter();

        documentCenter.setCreateTime( documentCenterUpdateInputDTO.getCreateTime() );
        documentCenter.setUpdateTime( documentCenterUpdateInputDTO.getUpdateTime() );
        documentCenter.setCreator( documentCenterUpdateInputDTO.getCreator() );
        documentCenter.setUpdater( documentCenterUpdateInputDTO.getUpdater() );
        documentCenter.setDeleted( documentCenterUpdateInputDTO.getDeleted() );
        documentCenter.setId( documentCenterUpdateInputDTO.getId() );
        documentCenter.setUseType( documentCenterUpdateInputDTO.getUseType() );
        documentCenter.setStatus( documentCenterUpdateInputDTO.getStatus() );
        documentCenter.setFileName( documentCenterUpdateInputDTO.getFileName() );
        documentCenter.setFilePath( documentCenterUpdateInputDTO.getFilePath() );

        return documentCenter;
    }

    @Override
    public DocumentCenterListOutputDTO toList(DocumentCenter documentCenter) {
        if ( documentCenter == null ) {
            return null;
        }

        DocumentCenterListOutputDTO documentCenterListOutputDTO = new DocumentCenterListOutputDTO();

        documentCenterListOutputDTO.setId( documentCenter.getId() );
        documentCenterListOutputDTO.setUseType( documentCenter.getUseType() );
        documentCenterListOutputDTO.setStatus( documentCenter.getStatus() );
        documentCenterListOutputDTO.setFileName( documentCenter.getFileName() );
        documentCenterListOutputDTO.setFilePath( documentCenter.getFilePath() );
        documentCenterListOutputDTO.setCreateTime( documentCenter.getCreateTime() );
        documentCenterListOutputDTO.setUpdateTime( documentCenter.getUpdateTime() );
        documentCenterListOutputDTO.setCreator( documentCenter.getCreator() );
        documentCenterListOutputDTO.setUpdater( documentCenter.getUpdater() );
        documentCenterListOutputDTO.setDeleted( documentCenter.getDeleted() );

        return documentCenterListOutputDTO;
    }

    @Override
    public List<DocumentCenterListOutputDTO> toList(List<DocumentCenter> documentCenters) {
        if ( documentCenters == null ) {
            return null;
        }

        List<DocumentCenterListOutputDTO> list = new ArrayList<DocumentCenterListOutputDTO>( documentCenters.size() );
        for ( DocumentCenter documentCenter : documentCenters ) {
            list.add( toList( documentCenter ) );
        }

        return list;
    }
}
