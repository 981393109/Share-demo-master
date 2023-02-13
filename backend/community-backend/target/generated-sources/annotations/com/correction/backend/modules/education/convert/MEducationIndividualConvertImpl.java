package com.correction.backend.modules.education.convert;

import com.correction.backend.modules.education.controller.dto.EducationIndividualCreateInputDTO;
import com.correction.backend.modules.education.controller.dto.EducationIndividualListOutputDTO;
import com.correction.backend.modules.education.controller.dto.EducationIndividualSearchInputDTO;
import com.correction.backend.modules.education.controller.dto.EducationIndividualUpdateInputDTO;
import com.correction.backend.modules.education.entity.EducationIndividual;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-13T01:51:15+0800",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 1.8.0_211 (Oracle Corporation)"
)
public class MEducationIndividualConvertImpl implements MEducationIndividualConvert {

    @Override
    public EducationIndividual toEducationIndividual(EducationIndividualSearchInputDTO educationIndividualSearchInputDTO) {
        if ( educationIndividualSearchInputDTO == null ) {
            return null;
        }

        EducationIndividual educationIndividual = new EducationIndividual();

        educationIndividual.setCreateTime( educationIndividualSearchInputDTO.getCreateTime() );
        educationIndividual.setUpdateTime( educationIndividualSearchInputDTO.getUpdateTime() );
        educationIndividual.setCreator( educationIndividualSearchInputDTO.getCreator() );
        educationIndividual.setUpdater( educationIndividualSearchInputDTO.getUpdater() );
        educationIndividual.setDeleted( educationIndividualSearchInputDTO.getDeleted() );
        educationIndividual.setCorrectionUnit( educationIndividualSearchInputDTO.getCorrectionUnit() );
        educationIndividual.setCorrectionUnitId( educationIndividualSearchInputDTO.getCorrectionUnitId() );
        educationIndividual.setUserName( educationIndividualSearchInputDTO.getUserName() );
        educationIndividual.setUserId( educationIndividualSearchInputDTO.getUserId() );
        educationIndividual.setTalkDate( educationIndividualSearchInputDTO.getTalkDate() );
        educationIndividual.setTalkUser( educationIndividualSearchInputDTO.getTalkUser() );
        educationIndividual.setRecordUser( educationIndividualSearchInputDTO.getRecordUser() );
        educationIndividual.setTalkAddress( educationIndividualSearchInputDTO.getTalkAddress() );
        educationIndividual.setTalkContent( educationIndividualSearchInputDTO.getTalkContent() );
        educationIndividual.setRemark( educationIndividualSearchInputDTO.getRemark() );
        educationIndividual.setOrgNum( educationIndividualSearchInputDTO.getOrgNum() );

        return educationIndividual;
    }

    @Override
    public EducationIndividual toEducationIndividual(EducationIndividualCreateInputDTO educationIndividualCreateInputDTO) {
        if ( educationIndividualCreateInputDTO == null ) {
            return null;
        }

        EducationIndividual educationIndividual = new EducationIndividual();

        educationIndividual.setCreateTime( educationIndividualCreateInputDTO.getCreateTime() );
        educationIndividual.setUpdateTime( educationIndividualCreateInputDTO.getUpdateTime() );
        educationIndividual.setCreator( educationIndividualCreateInputDTO.getCreator() );
        educationIndividual.setUpdater( educationIndividualCreateInputDTO.getUpdater() );
        educationIndividual.setDeleted( educationIndividualCreateInputDTO.getDeleted() );
        educationIndividual.setCorrectionUnit( educationIndividualCreateInputDTO.getCorrectionUnit() );
        educationIndividual.setCorrectionUnitId( educationIndividualCreateInputDTO.getCorrectionUnitId() );
        educationIndividual.setUserName( educationIndividualCreateInputDTO.getUserName() );
        educationIndividual.setUserId( educationIndividualCreateInputDTO.getUserId() );
        educationIndividual.setTalkDate( educationIndividualCreateInputDTO.getTalkDate() );
        educationIndividual.setTalkUser( educationIndividualCreateInputDTO.getTalkUser() );
        educationIndividual.setRecordUser( educationIndividualCreateInputDTO.getRecordUser() );
        educationIndividual.setTalkAddress( educationIndividualCreateInputDTO.getTalkAddress() );
        educationIndividual.setTalkContent( educationIndividualCreateInputDTO.getTalkContent() );
        educationIndividual.setRemark( educationIndividualCreateInputDTO.getRemark() );
        educationIndividual.setOrgNum( educationIndividualCreateInputDTO.getOrgNum() );

        return educationIndividual;
    }

    @Override
    public EducationIndividual toEducationIndividual(EducationIndividualUpdateInputDTO educationIndividualUpdateInputDTO) {
        if ( educationIndividualUpdateInputDTO == null ) {
            return null;
        }

        EducationIndividual educationIndividual = new EducationIndividual();

        educationIndividual.setCreateTime( educationIndividualUpdateInputDTO.getCreateTime() );
        educationIndividual.setUpdateTime( educationIndividualUpdateInputDTO.getUpdateTime() );
        educationIndividual.setCreator( educationIndividualUpdateInputDTO.getCreator() );
        educationIndividual.setUpdater( educationIndividualUpdateInputDTO.getUpdater() );
        educationIndividual.setDeleted( educationIndividualUpdateInputDTO.getDeleted() );
        educationIndividual.setId( educationIndividualUpdateInputDTO.getId() );
        educationIndividual.setCorrectionUnit( educationIndividualUpdateInputDTO.getCorrectionUnit() );
        educationIndividual.setCorrectionUnitId( educationIndividualUpdateInputDTO.getCorrectionUnitId() );
        educationIndividual.setUserName( educationIndividualUpdateInputDTO.getUserName() );
        educationIndividual.setUserId( educationIndividualUpdateInputDTO.getUserId() );
        educationIndividual.setTalkDate( educationIndividualUpdateInputDTO.getTalkDate() );
        educationIndividual.setTalkUser( educationIndividualUpdateInputDTO.getTalkUser() );
        educationIndividual.setRecordUser( educationIndividualUpdateInputDTO.getRecordUser() );
        educationIndividual.setTalkAddress( educationIndividualUpdateInputDTO.getTalkAddress() );
        educationIndividual.setTalkContent( educationIndividualUpdateInputDTO.getTalkContent() );
        educationIndividual.setRemark( educationIndividualUpdateInputDTO.getRemark() );
        educationIndividual.setOrgNum( educationIndividualUpdateInputDTO.getOrgNum() );

        return educationIndividual;
    }

    @Override
    public EducationIndividualListOutputDTO toList(EducationIndividual educationIndividual) {
        if ( educationIndividual == null ) {
            return null;
        }

        EducationIndividualListOutputDTO educationIndividualListOutputDTO = new EducationIndividualListOutputDTO();

        educationIndividualListOutputDTO.setId( educationIndividual.getId() );
        educationIndividualListOutputDTO.setCorrectionUnit( educationIndividual.getCorrectionUnit() );
        educationIndividualListOutputDTO.setCorrectionUnitId( educationIndividual.getCorrectionUnitId() );
        educationIndividualListOutputDTO.setUserName( educationIndividual.getUserName() );
        educationIndividualListOutputDTO.setUserId( educationIndividual.getUserId() );
        educationIndividualListOutputDTO.setTalkDate( educationIndividual.getTalkDate() );
        educationIndividualListOutputDTO.setTalkUser( educationIndividual.getTalkUser() );
        educationIndividualListOutputDTO.setRecordUser( educationIndividual.getRecordUser() );
        educationIndividualListOutputDTO.setTalkAddress( educationIndividual.getTalkAddress() );
        educationIndividualListOutputDTO.setTalkContent( educationIndividual.getTalkContent() );
        educationIndividualListOutputDTO.setRemark( educationIndividual.getRemark() );
        educationIndividualListOutputDTO.setOrgNum( educationIndividual.getOrgNum() );
        educationIndividualListOutputDTO.setCreateTime( educationIndividual.getCreateTime() );
        educationIndividualListOutputDTO.setUpdateTime( educationIndividual.getUpdateTime() );
        educationIndividualListOutputDTO.setCreator( educationIndividual.getCreator() );
        educationIndividualListOutputDTO.setUpdater( educationIndividual.getUpdater() );
        educationIndividualListOutputDTO.setDeleted( educationIndividual.getDeleted() );

        return educationIndividualListOutputDTO;
    }

    @Override
    public List<EducationIndividualListOutputDTO> toList(List<EducationIndividual> educationIndividuals) {
        if ( educationIndividuals == null ) {
            return null;
        }

        List<EducationIndividualListOutputDTO> list = new ArrayList<EducationIndividualListOutputDTO>( educationIndividuals.size() );
        for ( EducationIndividual educationIndividual : educationIndividuals ) {
            list.add( toList( educationIndividual ) );
        }

        return list;
    }
}
