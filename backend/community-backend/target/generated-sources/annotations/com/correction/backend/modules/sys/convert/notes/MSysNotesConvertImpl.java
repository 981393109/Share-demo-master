package com.correction.backend.modules.sys.convert.notes;

import com.correction.backend.modules.sys.controller.dto.notes.SysNotesCreateInputDTO;
import com.correction.backend.modules.sys.entity.SysNotes;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-13T01:51:14+0800",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 1.8.0_211 (Oracle Corporation)"
)
public class MSysNotesConvertImpl implements MSysNotesConvert {

    @Override
    public SysNotes toSysNotes(SysNotesCreateInputDTO sysNotesSearchInputDTO) {
        if ( sysNotesSearchInputDTO == null ) {
            return null;
        }

        SysNotes sysNotes = new SysNotes();

        sysNotes.setCreateTime( sysNotesSearchInputDTO.getCreateTime() );
        sysNotes.setUpdateTime( sysNotesSearchInputDTO.getUpdateTime() );
        sysNotes.setCreator( sysNotesSearchInputDTO.getCreator() );
        sysNotes.setUpdater( sysNotesSearchInputDTO.getUpdater() );
        sysNotes.setDeleted( sysNotesSearchInputDTO.getDeleted() );
        sysNotes.setUseDate( sysNotesSearchInputDTO.getUseDate() );
        sysNotes.setUserId( sysNotesSearchInputDTO.getUserId() );
        sysNotes.setContent( sysNotesSearchInputDTO.getContent() );
        sysNotes.setStatus( sysNotesSearchInputDTO.getStatus() );

        return sysNotes;
    }
}
