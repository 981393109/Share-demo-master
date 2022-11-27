package com.correction.backend.modules.handleCorrection.convert;

import com.correction.backend.modules.handleCorrection.controller.dto.CorrectionWaysCreateInputDTO;
import com.correction.backend.modules.handleCorrection.controller.dto.CorrectionWaysListOutputDTO;
import com.correction.backend.modules.handleCorrection.controller.dto.CorrectionWaysSearchInputDTO;
import com.correction.backend.modules.handleCorrection.controller.dto.CorrectionWaysUpdateInputDTO;
import com.correction.backend.modules.handleCorrection.entity.CorrectionWays;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-27T12:07:08+0800",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 1.8.0_211 (Oracle Corporation)"
)
public class MCorrectionWaysConvertImpl implements MCorrectionWaysConvert {

    @Override
    public CorrectionWays toCorrectionWays(CorrectionWaysSearchInputDTO correctionWaysSearchInputDTO) {
        if ( correctionWaysSearchInputDTO == null ) {
            return null;
        }

        CorrectionWays correctionWays = new CorrectionWays();

        correctionWays.setCreateTime( correctionWaysSearchInputDTO.getCreateTime() );
        correctionWays.setUpdateTime( correctionWaysSearchInputDTO.getUpdateTime() );
        correctionWays.setCreator( correctionWaysSearchInputDTO.getCreator() );
        correctionWays.setUpdater( correctionWaysSearchInputDTO.getUpdater() );
        correctionWays.setDeleted( correctionWaysSearchInputDTO.getDeleted() );
        correctionWays.setCorrectionUnit( correctionWaysSearchInputDTO.getCorrectionUnit() );
        correctionWays.setSentenceUser( correctionWaysSearchInputDTO.getSentenceUser() );
        correctionWays.setSentenceUserId( correctionWaysSearchInputDTO.getSentenceUserId() );
        correctionWays.setWaysDate( correctionWaysSearchInputDTO.getWaysDate() );
        correctionWays.setAnalysisSituation( correctionWaysSearchInputDTO.getAnalysisSituation() );
        correctionWays.setCorrectionOpinion( correctionWaysSearchInputDTO.getCorrectionOpinion() );
        correctionWays.setRemark( correctionWaysSearchInputDTO.getRemark() );
        correctionWays.setHandleCorrectionId( correctionWaysSearchInputDTO.getHandleCorrectionId() );
        correctionWays.setOrgNum( correctionWaysSearchInputDTO.getOrgNum() );

        return correctionWays;
    }

    @Override
    public CorrectionWays toCorrectionWays(CorrectionWaysCreateInputDTO correctionWaysCreateInputDTO) {
        if ( correctionWaysCreateInputDTO == null ) {
            return null;
        }

        CorrectionWays correctionWays = new CorrectionWays();

        correctionWays.setCreateTime( correctionWaysCreateInputDTO.getCreateTime() );
        correctionWays.setUpdateTime( correctionWaysCreateInputDTO.getUpdateTime() );
        correctionWays.setCreator( correctionWaysCreateInputDTO.getCreator() );
        correctionWays.setUpdater( correctionWaysCreateInputDTO.getUpdater() );
        correctionWays.setDeleted( correctionWaysCreateInputDTO.getDeleted() );
        correctionWays.setCorrectionUnit( correctionWaysCreateInputDTO.getCorrectionUnit() );
        correctionWays.setSentenceUser( correctionWaysCreateInputDTO.getSentenceUser() );
        correctionWays.setSentenceUserId( correctionWaysCreateInputDTO.getSentenceUserId() );
        correctionWays.setWaysDate( correctionWaysCreateInputDTO.getWaysDate() );
        correctionWays.setAnalysisSituation( correctionWaysCreateInputDTO.getAnalysisSituation() );
        correctionWays.setCorrectionOpinion( correctionWaysCreateInputDTO.getCorrectionOpinion() );
        correctionWays.setRemark( correctionWaysCreateInputDTO.getRemark() );
        correctionWays.setHandleCorrectionId( correctionWaysCreateInputDTO.getHandleCorrectionId() );
        correctionWays.setOrgNum( correctionWaysCreateInputDTO.getOrgNum() );

        return correctionWays;
    }

    @Override
    public CorrectionWays toCorrectionWays(CorrectionWaysUpdateInputDTO correctionWaysUpdateInputDTO) {
        if ( correctionWaysUpdateInputDTO == null ) {
            return null;
        }

        CorrectionWays correctionWays = new CorrectionWays();

        correctionWays.setCreateTime( correctionWaysUpdateInputDTO.getCreateTime() );
        correctionWays.setUpdateTime( correctionWaysUpdateInputDTO.getUpdateTime() );
        correctionWays.setCreator( correctionWaysUpdateInputDTO.getCreator() );
        correctionWays.setUpdater( correctionWaysUpdateInputDTO.getUpdater() );
        correctionWays.setDeleted( correctionWaysUpdateInputDTO.getDeleted() );
        correctionWays.setId( correctionWaysUpdateInputDTO.getId() );
        correctionWays.setCorrectionUnit( correctionWaysUpdateInputDTO.getCorrectionUnit() );
        correctionWays.setSentenceUser( correctionWaysUpdateInputDTO.getSentenceUser() );
        correctionWays.setSentenceUserId( correctionWaysUpdateInputDTO.getSentenceUserId() );
        correctionWays.setWaysDate( correctionWaysUpdateInputDTO.getWaysDate() );
        correctionWays.setAnalysisSituation( correctionWaysUpdateInputDTO.getAnalysisSituation() );
        correctionWays.setCorrectionOpinion( correctionWaysUpdateInputDTO.getCorrectionOpinion() );
        correctionWays.setRemark( correctionWaysUpdateInputDTO.getRemark() );
        correctionWays.setHandleCorrectionId( correctionWaysUpdateInputDTO.getHandleCorrectionId() );
        correctionWays.setOrgNum( correctionWaysUpdateInputDTO.getOrgNum() );

        return correctionWays;
    }

    @Override
    public CorrectionWaysListOutputDTO toList(CorrectionWays correctionWays) {
        if ( correctionWays == null ) {
            return null;
        }

        CorrectionWaysListOutputDTO correctionWaysListOutputDTO = new CorrectionWaysListOutputDTO();

        correctionWaysListOutputDTO.setId( correctionWays.getId() );
        correctionWaysListOutputDTO.setCorrectionUnit( correctionWays.getCorrectionUnit() );
        correctionWaysListOutputDTO.setSentenceUser( correctionWays.getSentenceUser() );
        correctionWaysListOutputDTO.setSentenceUserId( correctionWays.getSentenceUserId() );
        correctionWaysListOutputDTO.setWaysDate( correctionWays.getWaysDate() );
        correctionWaysListOutputDTO.setAnalysisSituation( correctionWays.getAnalysisSituation() );
        correctionWaysListOutputDTO.setCorrectionOpinion( correctionWays.getCorrectionOpinion() );
        correctionWaysListOutputDTO.setRemark( correctionWays.getRemark() );
        correctionWaysListOutputDTO.setHandleCorrectionId( correctionWays.getHandleCorrectionId() );
        correctionWaysListOutputDTO.setOrgNum( correctionWays.getOrgNum() );
        correctionWaysListOutputDTO.setCreateTime( correctionWays.getCreateTime() );
        correctionWaysListOutputDTO.setUpdateTime( correctionWays.getUpdateTime() );
        correctionWaysListOutputDTO.setCreator( correctionWays.getCreator() );
        correctionWaysListOutputDTO.setUpdater( correctionWays.getUpdater() );
        correctionWaysListOutputDTO.setDeleted( correctionWays.getDeleted() );

        return correctionWaysListOutputDTO;
    }

    @Override
    public List<CorrectionWaysListOutputDTO> toList(List<CorrectionWays> correctionWayss) {
        if ( correctionWayss == null ) {
            return null;
        }

        List<CorrectionWaysListOutputDTO> list = new ArrayList<CorrectionWaysListOutputDTO>( correctionWayss.size() );
        for ( CorrectionWays correctionWays : correctionWayss ) {
            list.add( toList( correctionWays ) );
        }

        return list;
    }
}
