package com.correction.backend.modules.information.convert;

import com.correction.backend.modules.information.controller.dto.InformationAnnouncementMessageDTO;
import com.correction.backend.modules.information.entity.InformationAnnouncementMessage;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-19T02:18:58+0800",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 1.8.0_211 (Oracle Corporation)"
)
public class MInformationAnnouncementMessageConvertImpl implements MInformationAnnouncementMessageConvert {

    @Override
    public InformationAnnouncementMessage toEntity(InformationAnnouncementMessageDTO dto) {
        if ( dto == null ) {
            return null;
        }

        InformationAnnouncementMessage informationAnnouncementMessage = new InformationAnnouncementMessage();

        informationAnnouncementMessage.setCreateTime( dto.getCreateTime() );
        informationAnnouncementMessage.setUpdateTime( dto.getUpdateTime() );
        informationAnnouncementMessage.setCreator( dto.getCreator() );
        informationAnnouncementMessage.setUpdater( dto.getUpdater() );
        informationAnnouncementMessage.setDeleted( dto.getDeleted() );
        informationAnnouncementMessage.setId( dto.getId() );
        informationAnnouncementMessage.setMsgTitle( dto.getMsgTitle() );
        informationAnnouncementMessage.setMsgInfo( dto.getMsgInfo() );
        informationAnnouncementMessage.setOriginator( dto.getOriginator() );
        informationAnnouncementMessage.setOriginatorId( dto.getOriginatorId() );
        informationAnnouncementMessage.setStatus( dto.getStatus() );
        informationAnnouncementMessage.setMsgDate( dto.getMsgDate() );

        return informationAnnouncementMessage;
    }
}
