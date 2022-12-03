package com.correction.backend.modules.supervision.convert;

import com.correction.backend.modules.supervision.controller.dto.SupervisionOutApprovalCreateInputDTO;
import com.correction.backend.modules.supervision.controller.dto.SupervisionOutApprovalListOutputDTO;
import com.correction.backend.modules.supervision.controller.dto.SupervisionOutApprovalSearchInputDTO;
import com.correction.backend.modules.supervision.controller.dto.SupervisionOutApprovalUpdateInputDTO;
import com.correction.backend.modules.supervision.controller.dto.TerminateLeaveDTO;
import com.correction.backend.modules.supervision.entity.SupervisionOutApproval;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-03T15:42:12+0800",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 1.8.0_211 (Oracle Corporation)"
)
public class MSupervisionOutApprovalConvertImpl implements MSupervisionOutApprovalConvert {

    @Override
    public SupervisionOutApproval toSupervisionOutApproval(SupervisionOutApprovalSearchInputDTO supervisionOutApprovalSearchInputDTO) {
        if ( supervisionOutApprovalSearchInputDTO == null ) {
            return null;
        }

        SupervisionOutApproval supervisionOutApproval = new SupervisionOutApproval();

        supervisionOutApproval.setCorrectionUnit( supervisionOutApprovalSearchInputDTO.getCorrectionUnit() );
        supervisionOutApproval.setCorrectionUnitId( supervisionOutApprovalSearchInputDTO.getCorrectionUnitId() );
        supervisionOutApproval.setUserName( supervisionOutApprovalSearchInputDTO.getUserName() );
        supervisionOutApproval.setUserId( supervisionOutApprovalSearchInputDTO.getUserId() );
        supervisionOutApproval.setDestination( supervisionOutApprovalSearchInputDTO.getDestination() );
        supervisionOutApproval.setDeparture( supervisionOutApprovalSearchInputDTO.getDeparture() );
        supervisionOutApproval.setReasonsForLeave( supervisionOutApprovalSearchInputDTO.getReasonsForLeave() );
        supervisionOutApproval.setStartDate( supervisionOutApprovalSearchInputDTO.getStartDate() );
        supervisionOutApproval.setEndDate( supervisionOutApprovalSearchInputDTO.getEndDate() );
        supervisionOutApproval.setLeaveDay( supervisionOutApprovalSearchInputDTO.getLeaveDay() );
        supervisionOutApproval.setMonthLeaveDay( supervisionOutApprovalSearchInputDTO.getMonthLeaveDay() );
        supervisionOutApproval.setLeaveType( supervisionOutApprovalSearchInputDTO.getLeaveType() );
        supervisionOutApproval.setStrictType( supervisionOutApprovalSearchInputDTO.getStrictType() );
        supervisionOutApproval.setInvestigationCommitOne( supervisionOutApprovalSearchInputDTO.getInvestigationCommitOne() );
        supervisionOutApproval.setInvestigationCommitTwo( supervisionOutApprovalSearchInputDTO.getInvestigationCommitTwo() );
        supervisionOutApproval.setNoticeCommitOne( supervisionOutApprovalSearchInputDTO.getNoticeCommitOne() );
        supervisionOutApproval.setNoticeCommitTwo( supervisionOutApprovalSearchInputDTO.getNoticeCommitTwo() );
        supervisionOutApproval.setNoticeCommitThree( supervisionOutApprovalSearchInputDTO.getNoticeCommitThree() );
        supervisionOutApproval.setNoticeCommitFour( supervisionOutApprovalSearchInputDTO.getNoticeCommitFour() );
        supervisionOutApproval.setNoticeCommitFive( supervisionOutApprovalSearchInputDTO.getNoticeCommitFive() );
        supervisionOutApproval.setPlaceApplyOpinion( supervisionOutApprovalSearchInputDTO.getPlaceApplyOpinion() );
        supervisionOutApproval.setAreaApplyOpinion( supervisionOutApprovalSearchInputDTO.getAreaApplyOpinion() );
        supervisionOutApproval.setCityApplyOpinion( supervisionOutApprovalSearchInputDTO.getCityApplyOpinion() );
        supervisionOutApproval.setReportProcuratorate( supervisionOutApprovalSearchInputDTO.getReportProcuratorate() );
        supervisionOutApproval.setProcuratorateName( supervisionOutApprovalSearchInputDTO.getProcuratorateName() );
        supervisionOutApproval.setProgress( supervisionOutApprovalSearchInputDTO.getProgress() );
        supervisionOutApproval.setApplyStatus( supervisionOutApprovalSearchInputDTO.getApplyStatus() );
        supervisionOutApproval.setApplyUser( supervisionOutApprovalSearchInputDTO.getApplyUser() );
        supervisionOutApproval.setApplyName( supervisionOutApprovalSearchInputDTO.getApplyName() );
        supervisionOutApproval.setApplyTime( supervisionOutApprovalSearchInputDTO.getApplyTime() );
        supervisionOutApproval.setTerminateLeave( supervisionOutApprovalSearchInputDTO.getTerminateLeave() );
        supervisionOutApproval.setTerminateDelay( supervisionOutApprovalSearchInputDTO.getTerminateDelay() );
        supervisionOutApproval.setTerminateCommit( supervisionOutApprovalSearchInputDTO.getTerminateCommit() );
        supervisionOutApproval.setTerminateDelayDeturn( supervisionOutApprovalSearchInputDTO.getTerminateDelayDeturn() );
        supervisionOutApproval.setTerminateDelayDate( supervisionOutApprovalSearchInputDTO.getTerminateDelayDate() );
        supervisionOutApproval.setTerminateReturnReport( supervisionOutApprovalSearchInputDTO.getTerminateReturnReport() );
        supervisionOutApproval.setTerminateMaterials( supervisionOutApprovalSearchInputDTO.getTerminateMaterials() );

        return supervisionOutApproval;
    }

    @Override
    public SupervisionOutApproval toSupervisionOutApproval(SupervisionOutApprovalCreateInputDTO supervisionOutApprovalCreateInputDTO) {
        if ( supervisionOutApprovalCreateInputDTO == null ) {
            return null;
        }

        SupervisionOutApproval supervisionOutApproval = new SupervisionOutApproval();

        supervisionOutApproval.setId( supervisionOutApprovalCreateInputDTO.getId() );
        supervisionOutApproval.setCorrectionUnit( supervisionOutApprovalCreateInputDTO.getCorrectionUnit() );
        supervisionOutApproval.setCorrectionUnitId( supervisionOutApprovalCreateInputDTO.getCorrectionUnitId() );
        supervisionOutApproval.setUserName( supervisionOutApprovalCreateInputDTO.getUserName() );
        supervisionOutApproval.setUserId( supervisionOutApprovalCreateInputDTO.getUserId() );
        supervisionOutApproval.setDestination( supervisionOutApprovalCreateInputDTO.getDestination() );
        supervisionOutApproval.setDeparture( supervisionOutApprovalCreateInputDTO.getDeparture() );
        supervisionOutApproval.setReasonsForLeave( supervisionOutApprovalCreateInputDTO.getReasonsForLeave() );
        supervisionOutApproval.setStartDate( supervisionOutApprovalCreateInputDTO.getStartDate() );
        supervisionOutApproval.setEndDate( supervisionOutApprovalCreateInputDTO.getEndDate() );
        supervisionOutApproval.setLeaveDay( supervisionOutApprovalCreateInputDTO.getLeaveDay() );
        supervisionOutApproval.setMonthLeaveDay( supervisionOutApprovalCreateInputDTO.getMonthLeaveDay() );
        supervisionOutApproval.setLeaveType( supervisionOutApprovalCreateInputDTO.getLeaveType() );
        supervisionOutApproval.setStrictType( supervisionOutApprovalCreateInputDTO.getStrictType() );
        supervisionOutApproval.setInvestigationCommitOne( supervisionOutApprovalCreateInputDTO.getInvestigationCommitOne() );
        supervisionOutApproval.setInvestigationCommitTwo( supervisionOutApprovalCreateInputDTO.getInvestigationCommitTwo() );
        supervisionOutApproval.setNoticeCommitOne( supervisionOutApprovalCreateInputDTO.getNoticeCommitOne() );
        supervisionOutApproval.setNoticeCommitTwo( supervisionOutApprovalCreateInputDTO.getNoticeCommitTwo() );
        supervisionOutApproval.setNoticeCommitThree( supervisionOutApprovalCreateInputDTO.getNoticeCommitThree() );
        supervisionOutApproval.setNoticeCommitFour( supervisionOutApprovalCreateInputDTO.getNoticeCommitFour() );
        supervisionOutApproval.setNoticeCommitFive( supervisionOutApprovalCreateInputDTO.getNoticeCommitFive() );
        supervisionOutApproval.setPlaceApplyOpinion( supervisionOutApprovalCreateInputDTO.getPlaceApplyOpinion() );
        supervisionOutApproval.setAreaApplyOpinion( supervisionOutApprovalCreateInputDTO.getAreaApplyOpinion() );
        supervisionOutApproval.setCityApplyOpinion( supervisionOutApprovalCreateInputDTO.getCityApplyOpinion() );
        supervisionOutApproval.setReportProcuratorate( supervisionOutApprovalCreateInputDTO.getReportProcuratorate() );
        supervisionOutApproval.setProcuratorateName( supervisionOutApprovalCreateInputDTO.getProcuratorateName() );
        supervisionOutApproval.setProgress( supervisionOutApprovalCreateInputDTO.getProgress() );
        supervisionOutApproval.setApplyStatus( supervisionOutApprovalCreateInputDTO.getApplyStatus() );
        supervisionOutApproval.setApplyUser( supervisionOutApprovalCreateInputDTO.getApplyUser() );
        supervisionOutApproval.setApplyName( supervisionOutApprovalCreateInputDTO.getApplyName() );
        supervisionOutApproval.setApplyTime( supervisionOutApprovalCreateInputDTO.getApplyTime() );
        supervisionOutApproval.setTerminateLeave( supervisionOutApprovalCreateInputDTO.getTerminateLeave() );
        supervisionOutApproval.setTerminateDelay( supervisionOutApprovalCreateInputDTO.getTerminateDelay() );
        supervisionOutApproval.setTerminateCommit( supervisionOutApprovalCreateInputDTO.getTerminateCommit() );
        supervisionOutApproval.setTerminateDelayDeturn( supervisionOutApprovalCreateInputDTO.getTerminateDelayDeturn() );
        supervisionOutApproval.setTerminateDelayDate( supervisionOutApprovalCreateInputDTO.getTerminateDelayDate() );
        supervisionOutApproval.setTerminateReturnReport( supervisionOutApprovalCreateInputDTO.getTerminateReturnReport() );
        supervisionOutApproval.setTerminateMaterials( supervisionOutApprovalCreateInputDTO.getTerminateMaterials() );

        return supervisionOutApproval;
    }

    @Override
    public SupervisionOutApproval toSupervisionOutApproval(SupervisionOutApprovalUpdateInputDTO supervisionOutApprovalUpdateInputDTO) {
        if ( supervisionOutApprovalUpdateInputDTO == null ) {
            return null;
        }

        SupervisionOutApproval supervisionOutApproval = new SupervisionOutApproval();

        supervisionOutApproval.setId( supervisionOutApprovalUpdateInputDTO.getId() );
        supervisionOutApproval.setCorrectionUnit( supervisionOutApprovalUpdateInputDTO.getCorrectionUnit() );
        supervisionOutApproval.setCorrectionUnitId( supervisionOutApprovalUpdateInputDTO.getCorrectionUnitId() );
        supervisionOutApproval.setUserName( supervisionOutApprovalUpdateInputDTO.getUserName() );
        supervisionOutApproval.setUserId( supervisionOutApprovalUpdateInputDTO.getUserId() );
        supervisionOutApproval.setDestination( supervisionOutApprovalUpdateInputDTO.getDestination() );
        supervisionOutApproval.setDeparture( supervisionOutApprovalUpdateInputDTO.getDeparture() );
        supervisionOutApproval.setReasonsForLeave( supervisionOutApprovalUpdateInputDTO.getReasonsForLeave() );
        supervisionOutApproval.setStartDate( supervisionOutApprovalUpdateInputDTO.getStartDate() );
        supervisionOutApproval.setEndDate( supervisionOutApprovalUpdateInputDTO.getEndDate() );
        supervisionOutApproval.setLeaveDay( supervisionOutApprovalUpdateInputDTO.getLeaveDay() );
        supervisionOutApproval.setMonthLeaveDay( supervisionOutApprovalUpdateInputDTO.getMonthLeaveDay() );
        supervisionOutApproval.setLeaveType( supervisionOutApprovalUpdateInputDTO.getLeaveType() );
        supervisionOutApproval.setStrictType( supervisionOutApprovalUpdateInputDTO.getStrictType() );
        supervisionOutApproval.setInvestigationCommitOne( supervisionOutApprovalUpdateInputDTO.getInvestigationCommitOne() );
        supervisionOutApproval.setInvestigationCommitTwo( supervisionOutApprovalUpdateInputDTO.getInvestigationCommitTwo() );
        supervisionOutApproval.setNoticeCommitOne( supervisionOutApprovalUpdateInputDTO.getNoticeCommitOne() );
        supervisionOutApproval.setNoticeCommitTwo( supervisionOutApprovalUpdateInputDTO.getNoticeCommitTwo() );
        supervisionOutApproval.setNoticeCommitThree( supervisionOutApprovalUpdateInputDTO.getNoticeCommitThree() );
        supervisionOutApproval.setNoticeCommitFour( supervisionOutApprovalUpdateInputDTO.getNoticeCommitFour() );
        supervisionOutApproval.setNoticeCommitFive( supervisionOutApprovalUpdateInputDTO.getNoticeCommitFive() );
        supervisionOutApproval.setPlaceApplyOpinion( supervisionOutApprovalUpdateInputDTO.getPlaceApplyOpinion() );
        supervisionOutApproval.setAreaApplyOpinion( supervisionOutApprovalUpdateInputDTO.getAreaApplyOpinion() );
        supervisionOutApproval.setCityApplyOpinion( supervisionOutApprovalUpdateInputDTO.getCityApplyOpinion() );
        supervisionOutApproval.setReportProcuratorate( supervisionOutApprovalUpdateInputDTO.getReportProcuratorate() );
        supervisionOutApproval.setProcuratorateName( supervisionOutApprovalUpdateInputDTO.getProcuratorateName() );
        supervisionOutApproval.setProgress( supervisionOutApprovalUpdateInputDTO.getProgress() );
        supervisionOutApproval.setApplyStatus( supervisionOutApprovalUpdateInputDTO.getApplyStatus() );
        supervisionOutApproval.setApplyUser( supervisionOutApprovalUpdateInputDTO.getApplyUser() );
        supervisionOutApproval.setApplyName( supervisionOutApprovalUpdateInputDTO.getApplyName() );
        supervisionOutApproval.setApplyTime( supervisionOutApprovalUpdateInputDTO.getApplyTime() );
        supervisionOutApproval.setTerminateLeave( supervisionOutApprovalUpdateInputDTO.getTerminateLeave() );
        supervisionOutApproval.setTerminateDelay( supervisionOutApprovalUpdateInputDTO.getTerminateDelay() );
        supervisionOutApproval.setTerminateCommit( supervisionOutApprovalUpdateInputDTO.getTerminateCommit() );
        supervisionOutApproval.setTerminateDelayDeturn( supervisionOutApprovalUpdateInputDTO.getTerminateDelayDeturn() );
        supervisionOutApproval.setTerminateDelayDate( supervisionOutApprovalUpdateInputDTO.getTerminateDelayDate() );
        supervisionOutApproval.setTerminateReturnReport( supervisionOutApprovalUpdateInputDTO.getTerminateReturnReport() );
        supervisionOutApproval.setTerminateMaterials( supervisionOutApprovalUpdateInputDTO.getTerminateMaterials() );

        return supervisionOutApproval;
    }

    @Override
    public SupervisionOutApprovalListOutputDTO toList(SupervisionOutApproval supervisionOutApproval) {
        if ( supervisionOutApproval == null ) {
            return null;
        }

        SupervisionOutApprovalListOutputDTO supervisionOutApprovalListOutputDTO = new SupervisionOutApprovalListOutputDTO();

        supervisionOutApprovalListOutputDTO.setId( supervisionOutApproval.getId() );
        supervisionOutApprovalListOutputDTO.setCorrectionUnit( supervisionOutApproval.getCorrectionUnit() );
        supervisionOutApprovalListOutputDTO.setCorrectionUnitId( supervisionOutApproval.getCorrectionUnitId() );
        supervisionOutApprovalListOutputDTO.setUserName( supervisionOutApproval.getUserName() );
        supervisionOutApprovalListOutputDTO.setUserId( supervisionOutApproval.getUserId() );
        supervisionOutApprovalListOutputDTO.setDestination( supervisionOutApproval.getDestination() );
        supervisionOutApprovalListOutputDTO.setDeparture( supervisionOutApproval.getDeparture() );
        supervisionOutApprovalListOutputDTO.setReasonsForLeave( supervisionOutApproval.getReasonsForLeave() );
        supervisionOutApprovalListOutputDTO.setStartDate( supervisionOutApproval.getStartDate() );
        supervisionOutApprovalListOutputDTO.setEndDate( supervisionOutApproval.getEndDate() );
        supervisionOutApprovalListOutputDTO.setLeaveDay( supervisionOutApproval.getLeaveDay() );
        supervisionOutApprovalListOutputDTO.setMonthLeaveDay( supervisionOutApproval.getMonthLeaveDay() );
        supervisionOutApprovalListOutputDTO.setLeaveType( supervisionOutApproval.getLeaveType() );
        supervisionOutApprovalListOutputDTO.setStrictType( supervisionOutApproval.getStrictType() );
        supervisionOutApprovalListOutputDTO.setInvestigationCommitOne( supervisionOutApproval.getInvestigationCommitOne() );
        supervisionOutApprovalListOutputDTO.setInvestigationCommitTwo( supervisionOutApproval.getInvestigationCommitTwo() );
        supervisionOutApprovalListOutputDTO.setNoticeCommitOne( supervisionOutApproval.getNoticeCommitOne() );
        supervisionOutApprovalListOutputDTO.setNoticeCommitTwo( supervisionOutApproval.getNoticeCommitTwo() );
        supervisionOutApprovalListOutputDTO.setNoticeCommitThree( supervisionOutApproval.getNoticeCommitThree() );
        supervisionOutApprovalListOutputDTO.setNoticeCommitFour( supervisionOutApproval.getNoticeCommitFour() );
        supervisionOutApprovalListOutputDTO.setNoticeCommitFive( supervisionOutApproval.getNoticeCommitFive() );
        supervisionOutApprovalListOutputDTO.setPlaceApplyOpinion( supervisionOutApproval.getPlaceApplyOpinion() );
        supervisionOutApprovalListOutputDTO.setAreaApplyOpinion( supervisionOutApproval.getAreaApplyOpinion() );
        supervisionOutApprovalListOutputDTO.setCityApplyOpinion( supervisionOutApproval.getCityApplyOpinion() );
        supervisionOutApprovalListOutputDTO.setReportProcuratorate( supervisionOutApproval.getReportProcuratorate() );
        supervisionOutApprovalListOutputDTO.setProcuratorateName( supervisionOutApproval.getProcuratorateName() );
        supervisionOutApprovalListOutputDTO.setProgress( supervisionOutApproval.getProgress() );
        supervisionOutApprovalListOutputDTO.setApplyStatus( supervisionOutApproval.getApplyStatus() );
        supervisionOutApprovalListOutputDTO.setApplyUser( supervisionOutApproval.getApplyUser() );
        supervisionOutApprovalListOutputDTO.setApplyName( supervisionOutApproval.getApplyName() );
        supervisionOutApprovalListOutputDTO.setApplyTime( supervisionOutApproval.getApplyTime() );
        supervisionOutApprovalListOutputDTO.setTerminateLeave( supervisionOutApproval.getTerminateLeave() );
        supervisionOutApprovalListOutputDTO.setTerminateDelay( supervisionOutApproval.getTerminateDelay() );
        supervisionOutApprovalListOutputDTO.setTerminateCommit( supervisionOutApproval.getTerminateCommit() );
        supervisionOutApprovalListOutputDTO.setTerminateDelayDeturn( supervisionOutApproval.getTerminateDelayDeturn() );
        supervisionOutApprovalListOutputDTO.setTerminateDelayDate( supervisionOutApproval.getTerminateDelayDate() );
        supervisionOutApprovalListOutputDTO.setTerminateReturnReport( supervisionOutApproval.getTerminateReturnReport() );
        supervisionOutApprovalListOutputDTO.setTerminateMaterials( supervisionOutApproval.getTerminateMaterials() );

        return supervisionOutApprovalListOutputDTO;
    }

    @Override
    public List<SupervisionOutApprovalListOutputDTO> toList(List<SupervisionOutApproval> supervisionOutApprovals) {
        if ( supervisionOutApprovals == null ) {
            return null;
        }

        List<SupervisionOutApprovalListOutputDTO> list = new ArrayList<SupervisionOutApprovalListOutputDTO>( supervisionOutApprovals.size() );
        for ( SupervisionOutApproval supervisionOutApproval : supervisionOutApprovals ) {
            list.add( toList( supervisionOutApproval ) );
        }

        return list;
    }

    @Override
    public TerminateLeaveDTO toTerminateLeaveDTO(SupervisionOutApproval supervisionOutApproval) {
        if ( supervisionOutApproval == null ) {
            return null;
        }

        TerminateLeaveDTO terminateLeaveDTO = new TerminateLeaveDTO();

        terminateLeaveDTO.setId( supervisionOutApproval.getId() );
        terminateLeaveDTO.setTerminateLeave( supervisionOutApproval.getTerminateLeave() );
        terminateLeaveDTO.setTerminateDelay( supervisionOutApproval.getTerminateDelay() );
        terminateLeaveDTO.setTerminateCommit( supervisionOutApproval.getTerminateCommit() );
        terminateLeaveDTO.setTerminateDelayDeturn( supervisionOutApproval.getTerminateDelayDeturn() );
        terminateLeaveDTO.setTerminateDelayDate( supervisionOutApproval.getTerminateDelayDate() );
        terminateLeaveDTO.setTerminateReturnReport( supervisionOutApproval.getTerminateReturnReport() );
        terminateLeaveDTO.setTerminateMaterials( supervisionOutApproval.getTerminateMaterials() );

        return terminateLeaveDTO;
    }
}
