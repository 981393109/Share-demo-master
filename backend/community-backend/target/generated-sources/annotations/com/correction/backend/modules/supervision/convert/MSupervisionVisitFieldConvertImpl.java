package com.correction.backend.modules.supervision.convert;

import com.correction.backend.modules.supervision.controller.dto.SupervisionVisitFieldCreateInputDTO;
import com.correction.backend.modules.supervision.controller.dto.SupervisionVisitFieldDTO;
import com.correction.backend.modules.supervision.controller.dto.SupervisionVisitFieldListOutputDTO;
import com.correction.backend.modules.supervision.controller.dto.SupervisionVisitFieldSearchInputDTO;
import com.correction.backend.modules.supervision.controller.dto.SupervisionVisitFieldUpdateInputDTO;
import com.correction.backend.modules.supervision.entity.SupervisionVisitField;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-13T01:51:15+0800",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 1.8.0_211 (Oracle Corporation)"
)
public class MSupervisionVisitFieldConvertImpl implements MSupervisionVisitFieldConvert {

    @Override
    public SupervisionVisitField toSupervisionVisitField(SupervisionVisitFieldSearchInputDTO supervisionVisitFieldSearchInputDTO) {
        if ( supervisionVisitFieldSearchInputDTO == null ) {
            return null;
        }

        SupervisionVisitField supervisionVisitField = new SupervisionVisitField();

        supervisionVisitField.setCreateTime( supervisionVisitFieldSearchInputDTO.getCreateTime() );
        supervisionVisitField.setUpdateTime( supervisionVisitFieldSearchInputDTO.getUpdateTime() );
        supervisionVisitField.setCreator( supervisionVisitFieldSearchInputDTO.getCreator() );
        supervisionVisitField.setUpdater( supervisionVisitFieldSearchInputDTO.getUpdater() );
        supervisionVisitField.setDeleted( supervisionVisitFieldSearchInputDTO.getDeleted() );
        supervisionVisitField.setCorrectionUnit( supervisionVisitFieldSearchInputDTO.getCorrectionUnit() );
        supervisionVisitField.setCorrectionUnitId( supervisionVisitFieldSearchInputDTO.getCorrectionUnitId() );
        supervisionVisitField.setUserName( supervisionVisitFieldSearchInputDTO.getUserName() );
        supervisionVisitField.setUserId( supervisionVisitFieldSearchInputDTO.getUserId() );
        supervisionVisitField.setVisitDate( supervisionVisitFieldSearchInputDTO.getVisitDate() );
        supervisionVisitField.setVisitAddress( supervisionVisitFieldSearchInputDTO.getVisitAddress() );
        supervisionVisitField.setVisitPurpose( supervisionVisitFieldSearchInputDTO.getVisitPurpose() );
        supervisionVisitField.setVisitOpinion( supervisionVisitFieldSearchInputDTO.getVisitOpinion() );
        supervisionVisitField.setOrgNum( supervisionVisitFieldSearchInputDTO.getOrgNum() );

        return supervisionVisitField;
    }

    @Override
    public SupervisionVisitField toSupervisionVisitField(SupervisionVisitFieldCreateInputDTO supervisionVisitFieldCreateInputDTO) {
        if ( supervisionVisitFieldCreateInputDTO == null ) {
            return null;
        }

        SupervisionVisitField supervisionVisitField = new SupervisionVisitField();

        supervisionVisitField.setCreateTime( supervisionVisitFieldCreateInputDTO.getCreateTime() );
        supervisionVisitField.setUpdateTime( supervisionVisitFieldCreateInputDTO.getUpdateTime() );
        supervisionVisitField.setCreator( supervisionVisitFieldCreateInputDTO.getCreator() );
        supervisionVisitField.setUpdater( supervisionVisitFieldCreateInputDTO.getUpdater() );
        supervisionVisitField.setDeleted( supervisionVisitFieldCreateInputDTO.getDeleted() );
        supervisionVisitField.setCorrectionUnit( supervisionVisitFieldCreateInputDTO.getCorrectionUnit() );
        supervisionVisitField.setCorrectionUnitId( supervisionVisitFieldCreateInputDTO.getCorrectionUnitId() );
        supervisionVisitField.setUserName( supervisionVisitFieldCreateInputDTO.getUserName() );
        supervisionVisitField.setUserId( supervisionVisitFieldCreateInputDTO.getUserId() );
        supervisionVisitField.setVisitDate( supervisionVisitFieldCreateInputDTO.getVisitDate() );
        supervisionVisitField.setVisitAddress( supervisionVisitFieldCreateInputDTO.getVisitAddress() );
        supervisionVisitField.setVisitPurpose( supervisionVisitFieldCreateInputDTO.getVisitPurpose() );
        supervisionVisitField.setVisitOpinion( supervisionVisitFieldCreateInputDTO.getVisitOpinion() );
        supervisionVisitField.setOrgNum( supervisionVisitFieldCreateInputDTO.getOrgNum() );

        return supervisionVisitField;
    }

    @Override
    public SupervisionVisitField toSupervisionVisitField(SupervisionVisitFieldUpdateInputDTO supervisionVisitFieldUpdateInputDTO) {
        if ( supervisionVisitFieldUpdateInputDTO == null ) {
            return null;
        }

        SupervisionVisitField supervisionVisitField = new SupervisionVisitField();

        supervisionVisitField.setCreateTime( supervisionVisitFieldUpdateInputDTO.getCreateTime() );
        supervisionVisitField.setUpdateTime( supervisionVisitFieldUpdateInputDTO.getUpdateTime() );
        supervisionVisitField.setCreator( supervisionVisitFieldUpdateInputDTO.getCreator() );
        supervisionVisitField.setUpdater( supervisionVisitFieldUpdateInputDTO.getUpdater() );
        supervisionVisitField.setDeleted( supervisionVisitFieldUpdateInputDTO.getDeleted() );
        supervisionVisitField.setId( supervisionVisitFieldUpdateInputDTO.getId() );
        supervisionVisitField.setCorrectionUnit( supervisionVisitFieldUpdateInputDTO.getCorrectionUnit() );
        supervisionVisitField.setCorrectionUnitId( supervisionVisitFieldUpdateInputDTO.getCorrectionUnitId() );
        supervisionVisitField.setUserName( supervisionVisitFieldUpdateInputDTO.getUserName() );
        supervisionVisitField.setUserId( supervisionVisitFieldUpdateInputDTO.getUserId() );
        supervisionVisitField.setVisitDate( supervisionVisitFieldUpdateInputDTO.getVisitDate() );
        supervisionVisitField.setVisitAddress( supervisionVisitFieldUpdateInputDTO.getVisitAddress() );
        supervisionVisitField.setVisitPurpose( supervisionVisitFieldUpdateInputDTO.getVisitPurpose() );
        supervisionVisitField.setVisitOpinion( supervisionVisitFieldUpdateInputDTO.getVisitOpinion() );
        supervisionVisitField.setOrgNum( supervisionVisitFieldUpdateInputDTO.getOrgNum() );

        return supervisionVisitField;
    }

    @Override
    public SupervisionVisitFieldListOutputDTO toList(SupervisionVisitField supervisionVisitField) {
        if ( supervisionVisitField == null ) {
            return null;
        }

        SupervisionVisitFieldListOutputDTO supervisionVisitFieldListOutputDTO = new SupervisionVisitFieldListOutputDTO();

        supervisionVisitFieldListOutputDTO.setId( supervisionVisitField.getId() );
        supervisionVisitFieldListOutputDTO.setCorrectionUnit( supervisionVisitField.getCorrectionUnit() );
        supervisionVisitFieldListOutputDTO.setCorrectionUnitId( supervisionVisitField.getCorrectionUnitId() );
        supervisionVisitFieldListOutputDTO.setUserName( supervisionVisitField.getUserName() );
        supervisionVisitFieldListOutputDTO.setUserId( supervisionVisitField.getUserId() );
        supervisionVisitFieldListOutputDTO.setVisitDate( supervisionVisitField.getVisitDate() );
        supervisionVisitFieldListOutputDTO.setVisitAddress( supervisionVisitField.getVisitAddress() );
        supervisionVisitFieldListOutputDTO.setVisitPurpose( supervisionVisitField.getVisitPurpose() );
        supervisionVisitFieldListOutputDTO.setVisitOpinion( supervisionVisitField.getVisitOpinion() );
        supervisionVisitFieldListOutputDTO.setOrgNum( supervisionVisitField.getOrgNum() );
        supervisionVisitFieldListOutputDTO.setCreateTime( supervisionVisitField.getCreateTime() );
        supervisionVisitFieldListOutputDTO.setUpdateTime( supervisionVisitField.getUpdateTime() );
        supervisionVisitFieldListOutputDTO.setCreator( supervisionVisitField.getCreator() );
        supervisionVisitFieldListOutputDTO.setUpdater( supervisionVisitField.getUpdater() );
        supervisionVisitFieldListOutputDTO.setDeleted( supervisionVisitField.getDeleted() );

        return supervisionVisitFieldListOutputDTO;
    }

    @Override
    public List<SupervisionVisitFieldListOutputDTO> toList(List<SupervisionVisitField> supervisionVisitFields) {
        if ( supervisionVisitFields == null ) {
            return null;
        }

        List<SupervisionVisitFieldListOutputDTO> list = new ArrayList<SupervisionVisitFieldListOutputDTO>( supervisionVisitFields.size() );
        for ( SupervisionVisitField supervisionVisitField : supervisionVisitFields ) {
            list.add( toList( supervisionVisitField ) );
        }

        return list;
    }

    @Override
    public SupervisionVisitFieldDTO toSupervisionVisitFieldDTO(SupervisionVisitField supervisionVisitField) {
        if ( supervisionVisitField == null ) {
            return null;
        }

        SupervisionVisitFieldDTO supervisionVisitFieldDTO = new SupervisionVisitFieldDTO();

        return supervisionVisitFieldDTO;
    }
}
