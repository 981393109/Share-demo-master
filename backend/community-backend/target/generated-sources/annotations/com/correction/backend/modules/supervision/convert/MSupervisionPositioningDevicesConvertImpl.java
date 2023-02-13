package com.correction.backend.modules.supervision.convert;

import com.correction.backend.modules.supervision.controller.dto.SupervisionPositioningDevicesCreateInputDTO;
import com.correction.backend.modules.supervision.controller.dto.SupervisionPositioningDevicesListOutputDTO;
import com.correction.backend.modules.supervision.controller.dto.SupervisionPositioningDevicesSearchInputDTO;
import com.correction.backend.modules.supervision.controller.dto.SupervisionPositioningDevicesUpdateInputDTO;
import com.correction.backend.modules.supervision.entity.SupervisionPositioningDevices;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-13T01:51:15+0800",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 1.8.0_211 (Oracle Corporation)"
)
public class MSupervisionPositioningDevicesConvertImpl implements MSupervisionPositioningDevicesConvert {

    @Override
    public SupervisionPositioningDevices toSupervisionPositioningDevices(SupervisionPositioningDevicesSearchInputDTO supervisionPositioningDevicesSearchInputDTO) {
        if ( supervisionPositioningDevicesSearchInputDTO == null ) {
            return null;
        }

        SupervisionPositioningDevices supervisionPositioningDevices = new SupervisionPositioningDevices();

        supervisionPositioningDevices.setCorrectionUnit( supervisionPositioningDevicesSearchInputDTO.getCorrectionUnit() );
        supervisionPositioningDevices.setCorrectionUnitId( supervisionPositioningDevicesSearchInputDTO.getCorrectionUnitId() );
        supervisionPositioningDevices.setUserName( supervisionPositioningDevicesSearchInputDTO.getUserName() );
        supervisionPositioningDevices.setType( supervisionPositioningDevicesSearchInputDTO.getType() );
        supervisionPositioningDevices.setUserId( supervisionPositioningDevicesSearchInputDTO.getUserId() );
        supervisionPositioningDevices.setCaseUse( supervisionPositioningDevicesSearchInputDTO.getCaseUse() );
        supervisionPositioningDevices.setConsensusOpinion( supervisionPositioningDevicesSearchInputDTO.getConsensusOpinion() );
        supervisionPositioningDevices.setAreaApplyOpinion( supervisionPositioningDevicesSearchInputDTO.getAreaApplyOpinion() );
        supervisionPositioningDevices.setJusticeApplyOpinion( supervisionPositioningDevicesSearchInputDTO.getJusticeApplyOpinion() );
        supervisionPositioningDevices.setInformCommitOne( supervisionPositioningDevicesSearchInputDTO.getInformCommitOne() );
        supervisionPositioningDevices.setInformCommitTwo( supervisionPositioningDevicesSearchInputDTO.getInformCommitTwo() );
        supervisionPositioningDevices.setInformCommitThree( supervisionPositioningDevicesSearchInputDTO.getInformCommitThree() );
        supervisionPositioningDevices.setWearDevice( supervisionPositioningDevicesSearchInputDTO.getWearDevice() );
        supervisionPositioningDevices.setInformCommitFour( supervisionPositioningDevicesSearchInputDTO.getInformCommitFour() );
        supervisionPositioningDevices.setInformCommitFive( supervisionPositioningDevicesSearchInputDTO.getInformCommitFive() );
        supervisionPositioningDevices.setProgress( supervisionPositioningDevicesSearchInputDTO.getProgress() );
        supervisionPositioningDevices.setApplyStatus( supervisionPositioningDevicesSearchInputDTO.getApplyStatus() );
        supervisionPositioningDevices.setApplyUser( supervisionPositioningDevicesSearchInputDTO.getApplyUser() );
        supervisionPositioningDevices.setApplyName( supervisionPositioningDevicesSearchInputDTO.getApplyName() );
        supervisionPositioningDevices.setApplyTime( supervisionPositioningDevicesSearchInputDTO.getApplyTime() );
        supervisionPositioningDevices.setSourceId( supervisionPositioningDevicesSearchInputDTO.getSourceId() );

        return supervisionPositioningDevices;
    }

    @Override
    public SupervisionPositioningDevices toSupervisionPositioningDevices(SupervisionPositioningDevicesCreateInputDTO supervisionPositioningDevicesCreateInputDTO) {
        if ( supervisionPositioningDevicesCreateInputDTO == null ) {
            return null;
        }

        SupervisionPositioningDevices supervisionPositioningDevices = new SupervisionPositioningDevices();

        supervisionPositioningDevices.setId( supervisionPositioningDevicesCreateInputDTO.getId() );
        supervisionPositioningDevices.setCorrectionUnit( supervisionPositioningDevicesCreateInputDTO.getCorrectionUnit() );
        supervisionPositioningDevices.setCorrectionUnitId( supervisionPositioningDevicesCreateInputDTO.getCorrectionUnitId() );
        supervisionPositioningDevices.setUserName( supervisionPositioningDevicesCreateInputDTO.getUserName() );
        supervisionPositioningDevices.setType( supervisionPositioningDevicesCreateInputDTO.getType() );
        supervisionPositioningDevices.setUserId( supervisionPositioningDevicesCreateInputDTO.getUserId() );
        supervisionPositioningDevices.setCaseUse( supervisionPositioningDevicesCreateInputDTO.getCaseUse() );
        supervisionPositioningDevices.setConsensusOpinion( supervisionPositioningDevicesCreateInputDTO.getConsensusOpinion() );
        supervisionPositioningDevices.setAreaApplyOpinion( supervisionPositioningDevicesCreateInputDTO.getAreaApplyOpinion() );
        supervisionPositioningDevices.setJusticeApplyOpinion( supervisionPositioningDevicesCreateInputDTO.getJusticeApplyOpinion() );
        supervisionPositioningDevices.setInformCommitOne( supervisionPositioningDevicesCreateInputDTO.getInformCommitOne() );
        supervisionPositioningDevices.setInformCommitTwo( supervisionPositioningDevicesCreateInputDTO.getInformCommitTwo() );
        supervisionPositioningDevices.setInformCommitThree( supervisionPositioningDevicesCreateInputDTO.getInformCommitThree() );
        supervisionPositioningDevices.setWearDevice( supervisionPositioningDevicesCreateInputDTO.getWearDevice() );
        supervisionPositioningDevices.setInformCommitFour( supervisionPositioningDevicesCreateInputDTO.getInformCommitFour() );
        supervisionPositioningDevices.setInformCommitFive( supervisionPositioningDevicesCreateInputDTO.getInformCommitFive() );
        supervisionPositioningDevices.setProgress( supervisionPositioningDevicesCreateInputDTO.getProgress() );
        supervisionPositioningDevices.setApplyStatus( supervisionPositioningDevicesCreateInputDTO.getApplyStatus() );
        supervisionPositioningDevices.setApplyUser( supervisionPositioningDevicesCreateInputDTO.getApplyUser() );
        supervisionPositioningDevices.setApplyName( supervisionPositioningDevicesCreateInputDTO.getApplyName() );
        supervisionPositioningDevices.setApplyTime( supervisionPositioningDevicesCreateInputDTO.getApplyTime() );

        return supervisionPositioningDevices;
    }

    @Override
    public SupervisionPositioningDevices toSupervisionPositioningDevices(SupervisionPositioningDevicesUpdateInputDTO supervisionPositioningDevicesUpdateInputDTO) {
        if ( supervisionPositioningDevicesUpdateInputDTO == null ) {
            return null;
        }

        SupervisionPositioningDevices supervisionPositioningDevices = new SupervisionPositioningDevices();

        supervisionPositioningDevices.setId( supervisionPositioningDevicesUpdateInputDTO.getId() );
        supervisionPositioningDevices.setCorrectionUnit( supervisionPositioningDevicesUpdateInputDTO.getCorrectionUnit() );
        supervisionPositioningDevices.setCorrectionUnitId( supervisionPositioningDevicesUpdateInputDTO.getCorrectionUnitId() );
        supervisionPositioningDevices.setUserName( supervisionPositioningDevicesUpdateInputDTO.getUserName() );
        supervisionPositioningDevices.setType( supervisionPositioningDevicesUpdateInputDTO.getType() );
        supervisionPositioningDevices.setUserId( supervisionPositioningDevicesUpdateInputDTO.getUserId() );
        supervisionPositioningDevices.setCaseUse( supervisionPositioningDevicesUpdateInputDTO.getCaseUse() );
        supervisionPositioningDevices.setConsensusOpinion( supervisionPositioningDevicesUpdateInputDTO.getConsensusOpinion() );
        supervisionPositioningDevices.setAreaApplyOpinion( supervisionPositioningDevicesUpdateInputDTO.getAreaApplyOpinion() );
        supervisionPositioningDevices.setJusticeApplyOpinion( supervisionPositioningDevicesUpdateInputDTO.getJusticeApplyOpinion() );
        supervisionPositioningDevices.setInformCommitOne( supervisionPositioningDevicesUpdateInputDTO.getInformCommitOne() );
        supervisionPositioningDevices.setInformCommitTwo( supervisionPositioningDevicesUpdateInputDTO.getInformCommitTwo() );
        supervisionPositioningDevices.setInformCommitThree( supervisionPositioningDevicesUpdateInputDTO.getInformCommitThree() );
        supervisionPositioningDevices.setWearDevice( supervisionPositioningDevicesUpdateInputDTO.getWearDevice() );
        supervisionPositioningDevices.setInformCommitFour( supervisionPositioningDevicesUpdateInputDTO.getInformCommitFour() );
        supervisionPositioningDevices.setInformCommitFive( supervisionPositioningDevicesUpdateInputDTO.getInformCommitFive() );
        supervisionPositioningDevices.setProgress( supervisionPositioningDevicesUpdateInputDTO.getProgress() );
        supervisionPositioningDevices.setApplyStatus( supervisionPositioningDevicesUpdateInputDTO.getApplyStatus() );
        supervisionPositioningDevices.setApplyUser( supervisionPositioningDevicesUpdateInputDTO.getApplyUser() );
        supervisionPositioningDevices.setApplyName( supervisionPositioningDevicesUpdateInputDTO.getApplyName() );
        supervisionPositioningDevices.setApplyTime( supervisionPositioningDevicesUpdateInputDTO.getApplyTime() );

        return supervisionPositioningDevices;
    }

    @Override
    public SupervisionPositioningDevicesListOutputDTO toList(SupervisionPositioningDevices supervisionPositioningDevices) {
        if ( supervisionPositioningDevices == null ) {
            return null;
        }

        SupervisionPositioningDevicesListOutputDTO supervisionPositioningDevicesListOutputDTO = new SupervisionPositioningDevicesListOutputDTO();

        supervisionPositioningDevicesListOutputDTO.setId( supervisionPositioningDevices.getId() );
        supervisionPositioningDevicesListOutputDTO.setCorrectionUnit( supervisionPositioningDevices.getCorrectionUnit() );
        supervisionPositioningDevicesListOutputDTO.setCorrectionUnitId( supervisionPositioningDevices.getCorrectionUnitId() );
        supervisionPositioningDevicesListOutputDTO.setUserName( supervisionPositioningDevices.getUserName() );
        supervisionPositioningDevicesListOutputDTO.setType( supervisionPositioningDevices.getType() );
        supervisionPositioningDevicesListOutputDTO.setUserId( supervisionPositioningDevices.getUserId() );
        supervisionPositioningDevicesListOutputDTO.setCaseUse( supervisionPositioningDevices.getCaseUse() );
        supervisionPositioningDevicesListOutputDTO.setConsensusOpinion( supervisionPositioningDevices.getConsensusOpinion() );
        supervisionPositioningDevicesListOutputDTO.setAreaApplyOpinion( supervisionPositioningDevices.getAreaApplyOpinion() );
        supervisionPositioningDevicesListOutputDTO.setJusticeApplyOpinion( supervisionPositioningDevices.getJusticeApplyOpinion() );
        supervisionPositioningDevicesListOutputDTO.setInformCommitOne( supervisionPositioningDevices.getInformCommitOne() );
        supervisionPositioningDevicesListOutputDTO.setInformCommitTwo( supervisionPositioningDevices.getInformCommitTwo() );
        supervisionPositioningDevicesListOutputDTO.setInformCommitThree( supervisionPositioningDevices.getInformCommitThree() );
        supervisionPositioningDevicesListOutputDTO.setWearDevice( supervisionPositioningDevices.getWearDevice() );
        supervisionPositioningDevicesListOutputDTO.setInformCommitFour( supervisionPositioningDevices.getInformCommitFour() );
        supervisionPositioningDevicesListOutputDTO.setInformCommitFive( supervisionPositioningDevices.getInformCommitFive() );
        supervisionPositioningDevicesListOutputDTO.setProgress( supervisionPositioningDevices.getProgress() );
        supervisionPositioningDevicesListOutputDTO.setApplyStatus( supervisionPositioningDevices.getApplyStatus() );
        supervisionPositioningDevicesListOutputDTO.setApplyUser( supervisionPositioningDevices.getApplyUser() );
        supervisionPositioningDevicesListOutputDTO.setApplyName( supervisionPositioningDevices.getApplyName() );
        supervisionPositioningDevicesListOutputDTO.setApplyTime( supervisionPositioningDevices.getApplyTime() );
        supervisionPositioningDevicesListOutputDTO.setProcessInstanceId( supervisionPositioningDevices.getProcessInstanceId() );

        return supervisionPositioningDevicesListOutputDTO;
    }

    @Override
    public List<SupervisionPositioningDevicesListOutputDTO> toList(List<SupervisionPositioningDevices> supervisionPositioningDevicess) {
        if ( supervisionPositioningDevicess == null ) {
            return null;
        }

        List<SupervisionPositioningDevicesListOutputDTO> list = new ArrayList<SupervisionPositioningDevicesListOutputDTO>( supervisionPositioningDevicess.size() );
        for ( SupervisionPositioningDevices supervisionPositioningDevices : supervisionPositioningDevicess ) {
            list.add( toList( supervisionPositioningDevices ) );
        }

        return list;
    }
}
