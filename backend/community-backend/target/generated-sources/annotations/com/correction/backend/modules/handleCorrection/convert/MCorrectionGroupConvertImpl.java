package com.correction.backend.modules.handleCorrection.convert;

import com.correction.backend.modules.handleCorrection.controller.dto.CorrectionGroupCreateInputDTO;
import com.correction.backend.modules.handleCorrection.controller.dto.CorrectionGroupListOutputDTO;
import com.correction.backend.modules.handleCorrection.controller.dto.CorrectionGroupSearchInputDTO;
import com.correction.backend.modules.handleCorrection.controller.dto.CorrectionGroupUpdateInputDTO;
import com.correction.backend.modules.handleCorrection.entity.CorrectionGroup;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-27T12:07:08+0800",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 1.8.0_211 (Oracle Corporation)"
)
public class MCorrectionGroupConvertImpl implements MCorrectionGroupConvert {

    @Override
    public CorrectionGroup toCorrectionGroup(CorrectionGroupSearchInputDTO correctionGroupSearchInputDTO) {
        if ( correctionGroupSearchInputDTO == null ) {
            return null;
        }

        CorrectionGroup correctionGroup = new CorrectionGroup();

        correctionGroup.setUserName( correctionGroupSearchInputDTO.getUserName() );
        correctionGroup.setUserId( correctionGroupSearchInputDTO.getUserId() );
        correctionGroup.setCorrectionUnit( correctionGroupSearchInputDTO.getCorrectionUnit() );
        correctionGroup.setUserType( correctionGroupSearchInputDTO.getUserType() );
        correctionGroup.setSex( correctionGroupSearchInputDTO.getSex() );
        correctionGroup.setIdCard( correctionGroupSearchInputDTO.getIdCard() );
        correctionGroup.setJob( correctionGroupSearchInputDTO.getJob() );
        correctionGroup.setHandleCorrectionId( correctionGroupSearchInputDTO.getHandleCorrectionId() );

        return correctionGroup;
    }

    @Override
    public CorrectionGroup toCorrectionGroup(CorrectionGroupCreateInputDTO correctionGroupCreateInputDTO) {
        if ( correctionGroupCreateInputDTO == null ) {
            return null;
        }

        CorrectionGroup correctionGroup = new CorrectionGroup();

        correctionGroup.setUserName( correctionGroupCreateInputDTO.getUserName() );
        correctionGroup.setUserId( correctionGroupCreateInputDTO.getUserId() );
        correctionGroup.setCorrectionUnit( correctionGroupCreateInputDTO.getCorrectionUnit() );
        correctionGroup.setUserType( correctionGroupCreateInputDTO.getUserType() );
        correctionGroup.setSex( correctionGroupCreateInputDTO.getSex() );
        correctionGroup.setIdCard( correctionGroupCreateInputDTO.getIdCard() );
        correctionGroup.setJob( correctionGroupCreateInputDTO.getJob() );
        correctionGroup.setHandleCorrectionId( correctionGroupCreateInputDTO.getHandleCorrectionId() );

        return correctionGroup;
    }

    @Override
    public CorrectionGroup toCorrectionGroup(CorrectionGroupUpdateInputDTO correctionGroupUpdateInputDTO) {
        if ( correctionGroupUpdateInputDTO == null ) {
            return null;
        }

        CorrectionGroup correctionGroup = new CorrectionGroup();

        correctionGroup.setId( correctionGroupUpdateInputDTO.getId() );
        correctionGroup.setUserName( correctionGroupUpdateInputDTO.getUserName() );
        correctionGroup.setUserId( correctionGroupUpdateInputDTO.getUserId() );
        correctionGroup.setCorrectionUnit( correctionGroupUpdateInputDTO.getCorrectionUnit() );
        correctionGroup.setUserType( correctionGroupUpdateInputDTO.getUserType() );
        correctionGroup.setSex( correctionGroupUpdateInputDTO.getSex() );
        correctionGroup.setIdCard( correctionGroupUpdateInputDTO.getIdCard() );
        correctionGroup.setJob( correctionGroupUpdateInputDTO.getJob() );
        correctionGroup.setHandleCorrectionId( correctionGroupUpdateInputDTO.getHandleCorrectionId() );

        return correctionGroup;
    }

    @Override
    public CorrectionGroupListOutputDTO toList(CorrectionGroup correctionGroup) {
        if ( correctionGroup == null ) {
            return null;
        }

        CorrectionGroupListOutputDTO correctionGroupListOutputDTO = new CorrectionGroupListOutputDTO();

        correctionGroupListOutputDTO.setId( correctionGroup.getId() );
        correctionGroupListOutputDTO.setUserName( correctionGroup.getUserName() );
        correctionGroupListOutputDTO.setUserId( correctionGroup.getUserId() );
        correctionGroupListOutputDTO.setCorrectionUnit( correctionGroup.getCorrectionUnit() );
        correctionGroupListOutputDTO.setUserType( correctionGroup.getUserType() );
        correctionGroupListOutputDTO.setSex( correctionGroup.getSex() );
        correctionGroupListOutputDTO.setIdCard( correctionGroup.getIdCard() );
        correctionGroupListOutputDTO.setJob( correctionGroup.getJob() );
        correctionGroupListOutputDTO.setHandleCorrectionId( correctionGroup.getHandleCorrectionId() );

        return correctionGroupListOutputDTO;
    }

    @Override
    public List<CorrectionGroupListOutputDTO> toList(List<CorrectionGroup> correctionGroups) {
        if ( correctionGroups == null ) {
            return null;
        }

        List<CorrectionGroupListOutputDTO> list = new ArrayList<CorrectionGroupListOutputDTO>( correctionGroups.size() );
        for ( CorrectionGroup correctionGroup : correctionGroups ) {
            list.add( toList( correctionGroup ) );
        }

        return list;
    }
}
