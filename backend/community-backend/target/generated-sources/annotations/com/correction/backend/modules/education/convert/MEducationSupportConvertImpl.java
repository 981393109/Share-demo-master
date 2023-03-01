package com.correction.backend.modules.education.convert;

import com.correction.backend.modules.education.controller.dto.EducationSupportCreateInputDTO;
import com.correction.backend.modules.education.controller.dto.EducationSupportListOutputDTO;
import com.correction.backend.modules.education.controller.dto.EducationSupportSearchInputDTO;
import com.correction.backend.modules.education.controller.dto.EducationSupportUpdateInputDTO;
import com.correction.backend.modules.education.entity.EducationSupport;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-24T23:49:00+0800",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 1.8.0_211 (Oracle Corporation)"
)
public class MEducationSupportConvertImpl implements MEducationSupportConvert {

    @Override
    public EducationSupport toEducationSupport(EducationSupportSearchInputDTO educationSupportSearchInputDTO) {
        if ( educationSupportSearchInputDTO == null ) {
            return null;
        }

        EducationSupport educationSupport = new EducationSupport();

        educationSupport.setCreateTime( educationSupportSearchInputDTO.getCreateTime() );
        educationSupport.setUpdateTime( educationSupportSearchInputDTO.getUpdateTime() );
        educationSupport.setCreator( educationSupportSearchInputDTO.getCreator() );
        educationSupport.setUpdater( educationSupportSearchInputDTO.getUpdater() );
        educationSupport.setDeleted( educationSupportSearchInputDTO.getDeleted() );
        educationSupport.setCorrectionUnit( educationSupportSearchInputDTO.getCorrectionUnit() );
        educationSupport.setCorrectionUnitId( educationSupportSearchInputDTO.getCorrectionUnitId() );
        educationSupport.setUserName( educationSupportSearchInputDTO.getUserName() );
        educationSupport.setUserId( educationSupportSearchInputDTO.getUserId() );
        educationSupport.setLearningDate( educationSupportSearchInputDTO.getLearningDate() );
        educationSupport.setEducationWay( educationSupportSearchInputDTO.getEducationWay() );
        educationSupport.setBenchmarkScore( educationSupportSearchInputDTO.getBenchmarkScore() );
        educationSupport.setEducationContent( educationSupportSearchInputDTO.getEducationContent() );
        educationSupport.setAffiliatedUnit( educationSupportSearchInputDTO.getAffiliatedUnit() );
        educationSupport.setRegistrationView( educationSupportSearchInputDTO.getRegistrationView() );
        educationSupport.setScore( educationSupportSearchInputDTO.getScore() );
        educationSupport.setRemark( educationSupportSearchInputDTO.getRemark() );
        educationSupport.setOrgNum( educationSupportSearchInputDTO.getOrgNum() );

        return educationSupport;
    }

    @Override
    public EducationSupport toEducationSupport(EducationSupportCreateInputDTO educationSupportCreateInputDTO) {
        if ( educationSupportCreateInputDTO == null ) {
            return null;
        }

        EducationSupport educationSupport = new EducationSupport();

        educationSupport.setCreateTime( educationSupportCreateInputDTO.getCreateTime() );
        educationSupport.setUpdateTime( educationSupportCreateInputDTO.getUpdateTime() );
        educationSupport.setCreator( educationSupportCreateInputDTO.getCreator() );
        educationSupport.setUpdater( educationSupportCreateInputDTO.getUpdater() );
        educationSupport.setDeleted( educationSupportCreateInputDTO.getDeleted() );
        educationSupport.setCorrectionUnit( educationSupportCreateInputDTO.getCorrectionUnit() );
        educationSupport.setCorrectionUnitId( educationSupportCreateInputDTO.getCorrectionUnitId() );
        educationSupport.setUserName( educationSupportCreateInputDTO.getUserName() );
        educationSupport.setUserId( educationSupportCreateInputDTO.getUserId() );
        educationSupport.setLearningDate( educationSupportCreateInputDTO.getLearningDate() );
        educationSupport.setEducationWay( educationSupportCreateInputDTO.getEducationWay() );
        educationSupport.setBenchmarkScore( educationSupportCreateInputDTO.getBenchmarkScore() );
        educationSupport.setEducationContent( educationSupportCreateInputDTO.getEducationContent() );
        educationSupport.setAffiliatedUnit( educationSupportCreateInputDTO.getAffiliatedUnit() );
        educationSupport.setRegistrationView( educationSupportCreateInputDTO.getRegistrationView() );
        educationSupport.setScore( educationSupportCreateInputDTO.getScore() );
        educationSupport.setRemark( educationSupportCreateInputDTO.getRemark() );
        educationSupport.setOrgNum( educationSupportCreateInputDTO.getOrgNum() );

        return educationSupport;
    }

    @Override
    public EducationSupport toEducationSupport(EducationSupportUpdateInputDTO educationSupportUpdateInputDTO) {
        if ( educationSupportUpdateInputDTO == null ) {
            return null;
        }

        EducationSupport educationSupport = new EducationSupport();

        educationSupport.setCreateTime( educationSupportUpdateInputDTO.getCreateTime() );
        educationSupport.setUpdateTime( educationSupportUpdateInputDTO.getUpdateTime() );
        educationSupport.setCreator( educationSupportUpdateInputDTO.getCreator() );
        educationSupport.setUpdater( educationSupportUpdateInputDTO.getUpdater() );
        educationSupport.setDeleted( educationSupportUpdateInputDTO.getDeleted() );
        educationSupport.setId( educationSupportUpdateInputDTO.getId() );
        educationSupport.setCorrectionUnit( educationSupportUpdateInputDTO.getCorrectionUnit() );
        educationSupport.setCorrectionUnitId( educationSupportUpdateInputDTO.getCorrectionUnitId() );
        educationSupport.setUserName( educationSupportUpdateInputDTO.getUserName() );
        educationSupport.setUserId( educationSupportUpdateInputDTO.getUserId() );
        educationSupport.setLearningDate( educationSupportUpdateInputDTO.getLearningDate() );
        educationSupport.setEducationWay( educationSupportUpdateInputDTO.getEducationWay() );
        educationSupport.setBenchmarkScore( educationSupportUpdateInputDTO.getBenchmarkScore() );
        educationSupport.setEducationContent( educationSupportUpdateInputDTO.getEducationContent() );
        educationSupport.setAffiliatedUnit( educationSupportUpdateInputDTO.getAffiliatedUnit() );
        educationSupport.setRegistrationView( educationSupportUpdateInputDTO.getRegistrationView() );
        educationSupport.setScore( educationSupportUpdateInputDTO.getScore() );
        educationSupport.setRemark( educationSupportUpdateInputDTO.getRemark() );
        educationSupport.setOrgNum( educationSupportUpdateInputDTO.getOrgNum() );

        return educationSupport;
    }

    @Override
    public EducationSupportListOutputDTO toList(EducationSupport educationSupport) {
        if ( educationSupport == null ) {
            return null;
        }

        EducationSupportListOutputDTO educationSupportListOutputDTO = new EducationSupportListOutputDTO();

        educationSupportListOutputDTO.setId( educationSupport.getId() );
        educationSupportListOutputDTO.setCorrectionUnit( educationSupport.getCorrectionUnit() );
        educationSupportListOutputDTO.setCorrectionUnitId( educationSupport.getCorrectionUnitId() );
        educationSupportListOutputDTO.setUserName( educationSupport.getUserName() );
        educationSupportListOutputDTO.setUserId( educationSupport.getUserId() );
        educationSupportListOutputDTO.setLearningDate( educationSupport.getLearningDate() );
        educationSupportListOutputDTO.setEducationWay( educationSupport.getEducationWay() );
        educationSupportListOutputDTO.setBenchmarkScore( educationSupport.getBenchmarkScore() );
        educationSupportListOutputDTO.setEducationContent( educationSupport.getEducationContent() );
        educationSupportListOutputDTO.setAffiliatedUnit( educationSupport.getAffiliatedUnit() );
        educationSupportListOutputDTO.setRegistrationView( educationSupport.getRegistrationView() );
        educationSupportListOutputDTO.setScore( educationSupport.getScore() );
        educationSupportListOutputDTO.setRemark( educationSupport.getRemark() );
        educationSupportListOutputDTO.setOrgNum( educationSupport.getOrgNum() );
        educationSupportListOutputDTO.setCreateTime( educationSupport.getCreateTime() );
        educationSupportListOutputDTO.setUpdateTime( educationSupport.getUpdateTime() );
        educationSupportListOutputDTO.setCreator( educationSupport.getCreator() );
        educationSupportListOutputDTO.setUpdater( educationSupport.getUpdater() );
        educationSupportListOutputDTO.setDeleted( educationSupport.getDeleted() );

        return educationSupportListOutputDTO;
    }

    @Override
    public List<EducationSupportListOutputDTO> toList(List<EducationSupport> educationSupports) {
        if ( educationSupports == null ) {
            return null;
        }

        List<EducationSupportListOutputDTO> list = new ArrayList<EducationSupportListOutputDTO>( educationSupports.size() );
        for ( EducationSupport educationSupport : educationSupports ) {
            list.add( toList( educationSupport ) );
        }

        return list;
    }
}
