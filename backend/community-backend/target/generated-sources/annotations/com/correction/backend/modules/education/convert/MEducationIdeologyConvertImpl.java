package com.correction.backend.modules.education.convert;

import com.correction.backend.modules.education.controller.dto.EducationIdeologyCreateInputDTO;
import com.correction.backend.modules.education.controller.dto.EducationIdeologyListOutputDTO;
import com.correction.backend.modules.education.controller.dto.EducationIdeologySearchInputDTO;
import com.correction.backend.modules.education.controller.dto.EducationIdeologyUpdateInputDTO;
import com.correction.backend.modules.education.entity.EducationIdeology;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-24T23:49:00+0800",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 1.8.0_211 (Oracle Corporation)"
)
public class MEducationIdeologyConvertImpl implements MEducationIdeologyConvert {

    @Override
    public EducationIdeology toEducationIdeology(EducationIdeologySearchInputDTO educationIdeologySearchInputDTO) {
        if ( educationIdeologySearchInputDTO == null ) {
            return null;
        }

        EducationIdeology educationIdeology = new EducationIdeology();

        educationIdeology.setCreateTime( educationIdeologySearchInputDTO.getCreateTime() );
        educationIdeology.setUpdateTime( educationIdeologySearchInputDTO.getUpdateTime() );
        educationIdeology.setCreator( educationIdeologySearchInputDTO.getCreator() );
        educationIdeology.setUpdater( educationIdeologySearchInputDTO.getUpdater() );
        educationIdeology.setDeleted( educationIdeologySearchInputDTO.getDeleted() );
        educationIdeology.setCorrectionUnit( educationIdeologySearchInputDTO.getCorrectionUnit() );
        educationIdeology.setCorrectionUnitId( educationIdeologySearchInputDTO.getCorrectionUnitId() );
        educationIdeology.setUserName( educationIdeologySearchInputDTO.getUserName() );
        educationIdeology.setUserId( educationIdeologySearchInputDTO.getUserId() );
        educationIdeology.setReportDate( educationIdeologySearchInputDTO.getReportDate() );
        educationIdeology.setPerformanceInformation( educationIdeologySearchInputDTO.getPerformanceInformation() );
        educationIdeology.setBenchmarkScore( educationIdeologySearchInputDTO.getBenchmarkScore() );
        educationIdeology.setScore( educationIdeologySearchInputDTO.getScore() );
        educationIdeology.setOrgNum( educationIdeologySearchInputDTO.getOrgNum() );

        return educationIdeology;
    }

    @Override
    public EducationIdeology toEducationIdeology(EducationIdeologyCreateInputDTO educationIdeologyCreateInputDTO) {
        if ( educationIdeologyCreateInputDTO == null ) {
            return null;
        }

        EducationIdeology educationIdeology = new EducationIdeology();

        educationIdeology.setCreateTime( educationIdeologyCreateInputDTO.getCreateTime() );
        educationIdeology.setUpdateTime( educationIdeologyCreateInputDTO.getUpdateTime() );
        educationIdeology.setCreator( educationIdeologyCreateInputDTO.getCreator() );
        educationIdeology.setUpdater( educationIdeologyCreateInputDTO.getUpdater() );
        educationIdeology.setDeleted( educationIdeologyCreateInputDTO.getDeleted() );
        educationIdeology.setCorrectionUnit( educationIdeologyCreateInputDTO.getCorrectionUnit() );
        educationIdeology.setCorrectionUnitId( educationIdeologyCreateInputDTO.getCorrectionUnitId() );
        educationIdeology.setUserName( educationIdeologyCreateInputDTO.getUserName() );
        educationIdeology.setUserId( educationIdeologyCreateInputDTO.getUserId() );
        educationIdeology.setReportDate( educationIdeologyCreateInputDTO.getReportDate() );
        educationIdeology.setPerformanceInformation( educationIdeologyCreateInputDTO.getPerformanceInformation() );
        educationIdeology.setBenchmarkScore( educationIdeologyCreateInputDTO.getBenchmarkScore() );
        educationIdeology.setScore( educationIdeologyCreateInputDTO.getScore() );
        educationIdeology.setOrgNum( educationIdeologyCreateInputDTO.getOrgNum() );

        return educationIdeology;
    }

    @Override
    public EducationIdeology toEducationIdeology(EducationIdeologyUpdateInputDTO educationIdeologyUpdateInputDTO) {
        if ( educationIdeologyUpdateInputDTO == null ) {
            return null;
        }

        EducationIdeology educationIdeology = new EducationIdeology();

        educationIdeology.setCreateTime( educationIdeologyUpdateInputDTO.getCreateTime() );
        educationIdeology.setUpdateTime( educationIdeologyUpdateInputDTO.getUpdateTime() );
        educationIdeology.setCreator( educationIdeologyUpdateInputDTO.getCreator() );
        educationIdeology.setUpdater( educationIdeologyUpdateInputDTO.getUpdater() );
        educationIdeology.setDeleted( educationIdeologyUpdateInputDTO.getDeleted() );
        educationIdeology.setId( educationIdeologyUpdateInputDTO.getId() );
        educationIdeology.setCorrectionUnit( educationIdeologyUpdateInputDTO.getCorrectionUnit() );
        educationIdeology.setCorrectionUnitId( educationIdeologyUpdateInputDTO.getCorrectionUnitId() );
        educationIdeology.setUserName( educationIdeologyUpdateInputDTO.getUserName() );
        educationIdeology.setUserId( educationIdeologyUpdateInputDTO.getUserId() );
        educationIdeology.setReportDate( educationIdeologyUpdateInputDTO.getReportDate() );
        educationIdeology.setPerformanceInformation( educationIdeologyUpdateInputDTO.getPerformanceInformation() );
        educationIdeology.setBenchmarkScore( educationIdeologyUpdateInputDTO.getBenchmarkScore() );
        educationIdeology.setScore( educationIdeologyUpdateInputDTO.getScore() );
        educationIdeology.setOrgNum( educationIdeologyUpdateInputDTO.getOrgNum() );

        return educationIdeology;
    }

    @Override
    public EducationIdeologyListOutputDTO toList(EducationIdeology educationIdeology) {
        if ( educationIdeology == null ) {
            return null;
        }

        EducationIdeologyListOutputDTO educationIdeologyListOutputDTO = new EducationIdeologyListOutputDTO();

        educationIdeologyListOutputDTO.setId( educationIdeology.getId() );
        educationIdeologyListOutputDTO.setCorrectionUnit( educationIdeology.getCorrectionUnit() );
        educationIdeologyListOutputDTO.setCorrectionUnitId( educationIdeology.getCorrectionUnitId() );
        educationIdeologyListOutputDTO.setUserName( educationIdeology.getUserName() );
        educationIdeologyListOutputDTO.setUserId( educationIdeology.getUserId() );
        educationIdeologyListOutputDTO.setReportDate( educationIdeology.getReportDate() );
        educationIdeologyListOutputDTO.setPerformanceInformation( educationIdeology.getPerformanceInformation() );
        educationIdeologyListOutputDTO.setBenchmarkScore( educationIdeology.getBenchmarkScore() );
        educationIdeologyListOutputDTO.setScore( educationIdeology.getScore() );
        educationIdeologyListOutputDTO.setOrgNum( educationIdeology.getOrgNum() );
        educationIdeologyListOutputDTO.setCreateTime( educationIdeology.getCreateTime() );
        educationIdeologyListOutputDTO.setUpdateTime( educationIdeology.getUpdateTime() );
        educationIdeologyListOutputDTO.setCreator( educationIdeology.getCreator() );
        educationIdeologyListOutputDTO.setUpdater( educationIdeology.getUpdater() );
        educationIdeologyListOutputDTO.setDeleted( educationIdeology.getDeleted() );

        return educationIdeologyListOutputDTO;
    }

    @Override
    public List<EducationIdeologyListOutputDTO> toList(List<EducationIdeology> educationIdeologys) {
        if ( educationIdeologys == null ) {
            return null;
        }

        List<EducationIdeologyListOutputDTO> list = new ArrayList<EducationIdeologyListOutputDTO>( educationIdeologys.size() );
        for ( EducationIdeology educationIdeology : educationIdeologys ) {
            list.add( toList( educationIdeology ) );
        }

        return list;
    }
}
