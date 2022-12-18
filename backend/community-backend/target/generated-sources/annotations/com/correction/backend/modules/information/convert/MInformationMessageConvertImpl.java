package com.correction.backend.modules.information.convert;

import com.correction.backend.modules.information.controller.dto.InformationMessageCreateInputDTO;
import com.correction.backend.modules.information.controller.dto.InformationMessageListOutputDTO;
import com.correction.backend.modules.information.controller.dto.InformationMessageSearchInputDTO;
import com.correction.backend.modules.information.controller.dto.InformationMessageUpdateInputDTO;
import com.correction.backend.modules.information.entity.InformationMessage;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-19T02:18:58+0800",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 1.8.0_211 (Oracle Corporation)"
)
public class MInformationMessageConvertImpl implements MInformationMessageConvert {

    @Override
    public InformationMessage toInformationMessage(InformationMessageSearchInputDTO informationMessageSearchInputDTO) {
        if ( informationMessageSearchInputDTO == null ) {
            return null;
        }

        InformationMessage informationMessage = new InformationMessage();

        informationMessage.setCreateTime( informationMessageSearchInputDTO.getCreateTime() );
        informationMessage.setUpdateTime( informationMessageSearchInputDTO.getUpdateTime() );
        informationMessage.setCreator( informationMessageSearchInputDTO.getCreator() );
        informationMessage.setUpdater( informationMessageSearchInputDTO.getUpdater() );
        informationMessage.setDeleted( informationMessageSearchInputDTO.getDeleted() );
        informationMessage.setUserId( informationMessageSearchInputDTO.getUserId() );
        informationMessage.setMsgType( informationMessageSearchInputDTO.getMsgType() );
        informationMessage.setMsgTitle( informationMessageSearchInputDTO.getMsgTitle() );
        informationMessage.setMsgInfo( informationMessageSearchInputDTO.getMsgInfo() );
        informationMessage.setOriginator( informationMessageSearchInputDTO.getOriginator() );
        informationMessage.setOriginatorId( informationMessageSearchInputDTO.getOriginatorId() );
        informationMessage.setDataId( informationMessageSearchInputDTO.getDataId() );
        informationMessage.setDataType( informationMessageSearchInputDTO.getDataType() );
        informationMessage.setStatus( informationMessageSearchInputDTO.getStatus() );
        informationMessage.setTaskId( informationMessageSearchInputDTO.getTaskId() );

        return informationMessage;
    }

    @Override
    public InformationMessage toInformationMessage(InformationMessageCreateInputDTO informationMessageCreateInputDTO) {
        if ( informationMessageCreateInputDTO == null ) {
            return null;
        }

        InformationMessage informationMessage = new InformationMessage();

        informationMessage.setCreateTime( informationMessageCreateInputDTO.getCreateTime() );
        informationMessage.setUpdateTime( informationMessageCreateInputDTO.getUpdateTime() );
        informationMessage.setCreator( informationMessageCreateInputDTO.getCreator() );
        informationMessage.setUpdater( informationMessageCreateInputDTO.getUpdater() );
        informationMessage.setDeleted( informationMessageCreateInputDTO.getDeleted() );
        informationMessage.setUserId( informationMessageCreateInputDTO.getUserId() );
        informationMessage.setMsgType( informationMessageCreateInputDTO.getMsgType() );
        informationMessage.setMsgTitle( informationMessageCreateInputDTO.getMsgTitle() );
        informationMessage.setMsgInfo( informationMessageCreateInputDTO.getMsgInfo() );
        informationMessage.setOriginator( informationMessageCreateInputDTO.getOriginator() );
        informationMessage.setOriginatorId( informationMessageCreateInputDTO.getOriginatorId() );
        informationMessage.setDataId( informationMessageCreateInputDTO.getDataId() );
        informationMessage.setDataType( informationMessageCreateInputDTO.getDataType() );
        informationMessage.setStatus( informationMessageCreateInputDTO.getStatus() );
        informationMessage.setTaskId( informationMessageCreateInputDTO.getTaskId() );

        return informationMessage;
    }

    @Override
    public InformationMessage toInformationMessage(InformationMessageUpdateInputDTO informationMessageUpdateInputDTO) {
        if ( informationMessageUpdateInputDTO == null ) {
            return null;
        }

        InformationMessage informationMessage = new InformationMessage();

        informationMessage.setCreateTime( informationMessageUpdateInputDTO.getCreateTime() );
        informationMessage.setUpdateTime( informationMessageUpdateInputDTO.getUpdateTime() );
        informationMessage.setCreator( informationMessageUpdateInputDTO.getCreator() );
        informationMessage.setUpdater( informationMessageUpdateInputDTO.getUpdater() );
        informationMessage.setDeleted( informationMessageUpdateInputDTO.getDeleted() );
        informationMessage.setId( informationMessageUpdateInputDTO.getId() );
        informationMessage.setUserId( informationMessageUpdateInputDTO.getUserId() );
        informationMessage.setMsgType( informationMessageUpdateInputDTO.getMsgType() );
        informationMessage.setMsgTitle( informationMessageUpdateInputDTO.getMsgTitle() );
        informationMessage.setMsgInfo( informationMessageUpdateInputDTO.getMsgInfo() );
        informationMessage.setOriginator( informationMessageUpdateInputDTO.getOriginator() );
        informationMessage.setOriginatorId( informationMessageUpdateInputDTO.getOriginatorId() );
        informationMessage.setDataId( informationMessageUpdateInputDTO.getDataId() );
        informationMessage.setDataType( informationMessageUpdateInputDTO.getDataType() );
        informationMessage.setStatus( informationMessageUpdateInputDTO.getStatus() );
        informationMessage.setTaskId( informationMessageUpdateInputDTO.getTaskId() );

        return informationMessage;
    }

    @Override
    public InformationMessageListOutputDTO toList(InformationMessage informationMessage) {
        if ( informationMessage == null ) {
            return null;
        }

        InformationMessageListOutputDTO informationMessageListOutputDTO = new InformationMessageListOutputDTO();

        informationMessageListOutputDTO.setId( informationMessage.getId() );
        informationMessageListOutputDTO.setUserId( informationMessage.getUserId() );
        informationMessageListOutputDTO.setMsgType( informationMessage.getMsgType() );
        informationMessageListOutputDTO.setMsgTitle( informationMessage.getMsgTitle() );
        informationMessageListOutputDTO.setMsgInfo( informationMessage.getMsgInfo() );
        informationMessageListOutputDTO.setOriginator( informationMessage.getOriginator() );
        informationMessageListOutputDTO.setOriginatorId( informationMessage.getOriginatorId() );
        informationMessageListOutputDTO.setDataId( informationMessage.getDataId() );
        informationMessageListOutputDTO.setDataType( informationMessage.getDataType() );
        informationMessageListOutputDTO.setStatus( informationMessage.getStatus() );
        informationMessageListOutputDTO.setTaskId( informationMessage.getTaskId() );
        informationMessageListOutputDTO.setCreateTime( informationMessage.getCreateTime() );
        informationMessageListOutputDTO.setUpdateTime( informationMessage.getUpdateTime() );
        informationMessageListOutputDTO.setCreator( informationMessage.getCreator() );
        informationMessageListOutputDTO.setUpdater( informationMessage.getUpdater() );
        informationMessageListOutputDTO.setDeleted( informationMessage.getDeleted() );

        return informationMessageListOutputDTO;
    }

    @Override
    public List<InformationMessageListOutputDTO> toList(List<InformationMessage> informationMessages) {
        if ( informationMessages == null ) {
            return null;
        }

        List<InformationMessageListOutputDTO> list = new ArrayList<InformationMessageListOutputDTO>( informationMessages.size() );
        for ( InformationMessage informationMessage : informationMessages ) {
            list.add( toList( informationMessage ) );
        }

        return list;
    }
}
