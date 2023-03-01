package com.correction.backend.modules.survey.convert;

import com.correction.backend.modules.survey.controller.dto.SurveyEntrustUnitCreateInputDTO;
import com.correction.backend.modules.survey.controller.dto.SurveyEntrustUnitListOutputDTO;
import com.correction.backend.modules.survey.controller.dto.SurveyEntrustUnitSearchInputDTO;
import com.correction.backend.modules.survey.controller.dto.SurveyEntrustUnitUpdateInputDTO;
import com.correction.backend.modules.survey.entity.SurveyEntrustUnit;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-24T23:49:00+0800",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 1.8.0_211 (Oracle Corporation)"
)
public class MSurveyEntrustUnitConvertImpl implements MSurveyEntrustUnitConvert {

    @Override
    public SurveyEntrustUnit toSurveyEntrustUnit(SurveyEntrustUnitSearchInputDTO surveyEntrustUnitSearchInputDTO) {
        if ( surveyEntrustUnitSearchInputDTO == null ) {
            return null;
        }

        SurveyEntrustUnit surveyEntrustUnit = new SurveyEntrustUnit();

        surveyEntrustUnit.setCreateTime( surveyEntrustUnitSearchInputDTO.getCreateTime() );
        surveyEntrustUnit.setUpdateTime( surveyEntrustUnitSearchInputDTO.getUpdateTime() );
        surveyEntrustUnit.setCreator( surveyEntrustUnitSearchInputDTO.getCreator() );
        surveyEntrustUnit.setUpdater( surveyEntrustUnitSearchInputDTO.getUpdater() );
        surveyEntrustUnit.setDeleted( surveyEntrustUnitSearchInputDTO.getDeleted() );
        surveyEntrustUnit.setUnitType( surveyEntrustUnitSearchInputDTO.getUnitType() );
        surveyEntrustUnit.setUnitName( surveyEntrustUnitSearchInputDTO.getUnitName() );
        surveyEntrustUnit.setMobile( surveyEntrustUnitSearchInputDTO.getMobile() );
        surveyEntrustUnit.setUnitAddress( surveyEntrustUnitSearchInputDTO.getUnitAddress() );
        surveyEntrustUnit.setOrgNum( surveyEntrustUnitSearchInputDTO.getOrgNum() );

        return surveyEntrustUnit;
    }

    @Override
    public SurveyEntrustUnit toSurveyEntrustUnit(SurveyEntrustUnitCreateInputDTO surveyEntrustUnitCreateInputDTO) {
        if ( surveyEntrustUnitCreateInputDTO == null ) {
            return null;
        }

        SurveyEntrustUnit surveyEntrustUnit = new SurveyEntrustUnit();

        surveyEntrustUnit.setCreateTime( surveyEntrustUnitCreateInputDTO.getCreateTime() );
        surveyEntrustUnit.setUpdateTime( surveyEntrustUnitCreateInputDTO.getUpdateTime() );
        surveyEntrustUnit.setCreator( surveyEntrustUnitCreateInputDTO.getCreator() );
        surveyEntrustUnit.setUpdater( surveyEntrustUnitCreateInputDTO.getUpdater() );
        surveyEntrustUnit.setDeleted( surveyEntrustUnitCreateInputDTO.getDeleted() );
        surveyEntrustUnit.setId( surveyEntrustUnitCreateInputDTO.getId() );
        surveyEntrustUnit.setUnitType( surveyEntrustUnitCreateInputDTO.getUnitType() );
        surveyEntrustUnit.setUnitName( surveyEntrustUnitCreateInputDTO.getUnitName() );
        surveyEntrustUnit.setMobile( surveyEntrustUnitCreateInputDTO.getMobile() );
        surveyEntrustUnit.setUnitAddress( surveyEntrustUnitCreateInputDTO.getUnitAddress() );
        surveyEntrustUnit.setOrgNum( surveyEntrustUnitCreateInputDTO.getOrgNum() );

        return surveyEntrustUnit;
    }

    @Override
    public SurveyEntrustUnit toSurveyEntrustUnit(SurveyEntrustUnitUpdateInputDTO surveyEntrustUnitUpdateInputDTO) {
        if ( surveyEntrustUnitUpdateInputDTO == null ) {
            return null;
        }

        SurveyEntrustUnit surveyEntrustUnit = new SurveyEntrustUnit();

        surveyEntrustUnit.setCreateTime( surveyEntrustUnitUpdateInputDTO.getCreateTime() );
        surveyEntrustUnit.setUpdateTime( surveyEntrustUnitUpdateInputDTO.getUpdateTime() );
        surveyEntrustUnit.setCreator( surveyEntrustUnitUpdateInputDTO.getCreator() );
        surveyEntrustUnit.setUpdater( surveyEntrustUnitUpdateInputDTO.getUpdater() );
        surveyEntrustUnit.setDeleted( surveyEntrustUnitUpdateInputDTO.getDeleted() );
        surveyEntrustUnit.setId( surveyEntrustUnitUpdateInputDTO.getId() );
        surveyEntrustUnit.setUnitType( surveyEntrustUnitUpdateInputDTO.getUnitType() );
        surveyEntrustUnit.setUnitName( surveyEntrustUnitUpdateInputDTO.getUnitName() );
        surveyEntrustUnit.setMobile( surveyEntrustUnitUpdateInputDTO.getMobile() );
        surveyEntrustUnit.setUnitAddress( surveyEntrustUnitUpdateInputDTO.getUnitAddress() );
        surveyEntrustUnit.setOrgNum( surveyEntrustUnitUpdateInputDTO.getOrgNum() );

        return surveyEntrustUnit;
    }

    @Override
    public SurveyEntrustUnitListOutputDTO toList(SurveyEntrustUnit surveyEntrustUnit) {
        if ( surveyEntrustUnit == null ) {
            return null;
        }

        SurveyEntrustUnitListOutputDTO surveyEntrustUnitListOutputDTO = new SurveyEntrustUnitListOutputDTO();

        surveyEntrustUnitListOutputDTO.setId( surveyEntrustUnit.getId() );
        surveyEntrustUnitListOutputDTO.setUnitType( surveyEntrustUnit.getUnitType() );
        surveyEntrustUnitListOutputDTO.setUnitName( surveyEntrustUnit.getUnitName() );
        surveyEntrustUnitListOutputDTO.setMobile( surveyEntrustUnit.getMobile() );
        surveyEntrustUnitListOutputDTO.setUnitAddress( surveyEntrustUnit.getUnitAddress() );
        surveyEntrustUnitListOutputDTO.setOrgNum( surveyEntrustUnit.getOrgNum() );
        surveyEntrustUnitListOutputDTO.setCreateTime( surveyEntrustUnit.getCreateTime() );
        surveyEntrustUnitListOutputDTO.setUpdateTime( surveyEntrustUnit.getUpdateTime() );
        surveyEntrustUnitListOutputDTO.setCreator( surveyEntrustUnit.getCreator() );
        surveyEntrustUnitListOutputDTO.setUpdater( surveyEntrustUnit.getUpdater() );
        surveyEntrustUnitListOutputDTO.setDeleted( surveyEntrustUnit.getDeleted() );

        return surveyEntrustUnitListOutputDTO;
    }

    @Override
    public List<SurveyEntrustUnitListOutputDTO> toList(List<SurveyEntrustUnit> surveyEntrustUnits) {
        if ( surveyEntrustUnits == null ) {
            return null;
        }

        List<SurveyEntrustUnitListOutputDTO> list = new ArrayList<SurveyEntrustUnitListOutputDTO>( surveyEntrustUnits.size() );
        for ( SurveyEntrustUnit surveyEntrustUnit : surveyEntrustUnits ) {
            list.add( toList( surveyEntrustUnit ) );
        }

        return list;
    }
}
