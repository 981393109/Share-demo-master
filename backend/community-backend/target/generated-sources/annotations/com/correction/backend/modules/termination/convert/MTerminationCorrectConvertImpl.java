package com.correction.backend.modules.termination.convert;

import com.correction.backend.modules.termination.controller.dto.TerminationCorrectCreateInputDTO;
import com.correction.backend.modules.termination.controller.dto.TerminationCorrectListOutputDTO;
import com.correction.backend.modules.termination.controller.dto.TerminationCorrectSearchInputDTO;
import com.correction.backend.modules.termination.controller.dto.TerminationCorrectUpdateInputDTO;
import com.correction.backend.modules.termination.entity.TerminationCorrect;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-24T23:49:00+0800",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 1.8.0_211 (Oracle Corporation)"
)
public class MTerminationCorrectConvertImpl implements MTerminationCorrectConvert {

    @Override
    public TerminationCorrect toTerminationCorrect(TerminationCorrectSearchInputDTO terminationCorrectSearchInputDTO) {
        if ( terminationCorrectSearchInputDTO == null ) {
            return null;
        }

        TerminationCorrect terminationCorrect = new TerminationCorrect();

        terminationCorrect.setCreateTime( terminationCorrectSearchInputDTO.getCreateTime() );
        terminationCorrect.setUpdateTime( terminationCorrectSearchInputDTO.getUpdateTime() );
        terminationCorrect.setCreator( terminationCorrectSearchInputDTO.getCreator() );
        terminationCorrect.setUpdater( terminationCorrectSearchInputDTO.getUpdater() );
        terminationCorrect.setDeleted( terminationCorrectSearchInputDTO.getDeleted() );
        terminationCorrect.setCorrectionUnit( terminationCorrectSearchInputDTO.getCorrectionUnit() );
        terminationCorrect.setCorrectionUnitId( terminationCorrectSearchInputDTO.getCorrectionUnitId() );
        terminationCorrect.setUserName( terminationCorrectSearchInputDTO.getUserName() );
        terminationCorrect.setUserId( terminationCorrectSearchInputDTO.getUserId() );
        terminationCorrect.setSupervisionLevel( terminationCorrectSearchInputDTO.getSupervisionLevel() );
        terminationCorrect.setPerformType( terminationCorrectSearchInputDTO.getPerformType() );
        terminationCorrect.setTerminationReason( terminationCorrectSearchInputDTO.getTerminationReason() );
        terminationCorrect.setApprovalResult( terminationCorrectSearchInputDTO.getApprovalResult() );
        terminationCorrect.setSendDuplicateComplete( terminationCorrectSearchInputDTO.getSendDuplicateComplete() );
        terminationCorrect.setRemoveComplete( terminationCorrectSearchInputDTO.getRemoveComplete() );
        terminationCorrect.setProgress( terminationCorrectSearchInputDTO.getProgress() );
        terminationCorrect.setApplyStatus( terminationCorrectSearchInputDTO.getApplyStatus() );
        terminationCorrect.setApplyUser( terminationCorrectSearchInputDTO.getApplyUser() );
        terminationCorrect.setApplyName( terminationCorrectSearchInputDTO.getApplyName() );
        terminationCorrect.setApplyTime( terminationCorrectSearchInputDTO.getApplyTime() );
        terminationCorrect.setRef( terminationCorrectSearchInputDTO.getRef() );
        terminationCorrect.setProcessInstanceId( terminationCorrectSearchInputDTO.getProcessInstanceId() );
        terminationCorrect.setOrgNum( terminationCorrectSearchInputDTO.getOrgNum() );

        return terminationCorrect;
    }

    @Override
    public TerminationCorrect toTerminationCorrect(TerminationCorrectCreateInputDTO terminationCorrectCreateInputDTO) {
        if ( terminationCorrectCreateInputDTO == null ) {
            return null;
        }

        TerminationCorrect terminationCorrect = new TerminationCorrect();

        terminationCorrect.setCreateTime( terminationCorrectCreateInputDTO.getCreateTime() );
        terminationCorrect.setUpdateTime( terminationCorrectCreateInputDTO.getUpdateTime() );
        terminationCorrect.setCreator( terminationCorrectCreateInputDTO.getCreator() );
        terminationCorrect.setUpdater( terminationCorrectCreateInputDTO.getUpdater() );
        terminationCorrect.setDeleted( terminationCorrectCreateInputDTO.getDeleted() );
        terminationCorrect.setCorrectionUnit( terminationCorrectCreateInputDTO.getCorrectionUnit() );
        terminationCorrect.setCorrectionUnitId( terminationCorrectCreateInputDTO.getCorrectionUnitId() );
        terminationCorrect.setUserName( terminationCorrectCreateInputDTO.getUserName() );
        terminationCorrect.setUserId( terminationCorrectCreateInputDTO.getUserId() );
        terminationCorrect.setSupervisionLevel( terminationCorrectCreateInputDTO.getSupervisionLevel() );
        terminationCorrect.setPerformType( terminationCorrectCreateInputDTO.getPerformType() );
        terminationCorrect.setTerminationReason( terminationCorrectCreateInputDTO.getTerminationReason() );
        terminationCorrect.setApprovalResult( terminationCorrectCreateInputDTO.getApprovalResult() );
        terminationCorrect.setSendDuplicateComplete( terminationCorrectCreateInputDTO.getSendDuplicateComplete() );
        terminationCorrect.setRemoveComplete( terminationCorrectCreateInputDTO.getRemoveComplete() );
        terminationCorrect.setProgress( terminationCorrectCreateInputDTO.getProgress() );
        terminationCorrect.setApplyStatus( terminationCorrectCreateInputDTO.getApplyStatus() );
        terminationCorrect.setApplyUser( terminationCorrectCreateInputDTO.getApplyUser() );
        terminationCorrect.setApplyName( terminationCorrectCreateInputDTO.getApplyName() );
        terminationCorrect.setApplyTime( terminationCorrectCreateInputDTO.getApplyTime() );
        terminationCorrect.setRef( terminationCorrectCreateInputDTO.getRef() );
        terminationCorrect.setProcessInstanceId( terminationCorrectCreateInputDTO.getProcessInstanceId() );
        terminationCorrect.setOrgNum( terminationCorrectCreateInputDTO.getOrgNum() );

        return terminationCorrect;
    }

    @Override
    public TerminationCorrect toTerminationCorrect(TerminationCorrectUpdateInputDTO terminationCorrectUpdateInputDTO) {
        if ( terminationCorrectUpdateInputDTO == null ) {
            return null;
        }

        TerminationCorrect terminationCorrect = new TerminationCorrect();

        terminationCorrect.setCreateTime( terminationCorrectUpdateInputDTO.getCreateTime() );
        terminationCorrect.setUpdateTime( terminationCorrectUpdateInputDTO.getUpdateTime() );
        terminationCorrect.setCreator( terminationCorrectUpdateInputDTO.getCreator() );
        terminationCorrect.setUpdater( terminationCorrectUpdateInputDTO.getUpdater() );
        terminationCorrect.setDeleted( terminationCorrectUpdateInputDTO.getDeleted() );
        terminationCorrect.setId( terminationCorrectUpdateInputDTO.getId() );
        terminationCorrect.setCorrectionUnit( terminationCorrectUpdateInputDTO.getCorrectionUnit() );
        terminationCorrect.setCorrectionUnitId( terminationCorrectUpdateInputDTO.getCorrectionUnitId() );
        terminationCorrect.setUserName( terminationCorrectUpdateInputDTO.getUserName() );
        terminationCorrect.setUserId( terminationCorrectUpdateInputDTO.getUserId() );
        terminationCorrect.setSupervisionLevel( terminationCorrectUpdateInputDTO.getSupervisionLevel() );
        terminationCorrect.setPerformType( terminationCorrectUpdateInputDTO.getPerformType() );
        terminationCorrect.setTerminationReason( terminationCorrectUpdateInputDTO.getTerminationReason() );
        terminationCorrect.setApprovalResult( terminationCorrectUpdateInputDTO.getApprovalResult() );
        terminationCorrect.setSendDuplicateComplete( terminationCorrectUpdateInputDTO.getSendDuplicateComplete() );
        terminationCorrect.setRemoveComplete( terminationCorrectUpdateInputDTO.getRemoveComplete() );
        terminationCorrect.setProgress( terminationCorrectUpdateInputDTO.getProgress() );
        terminationCorrect.setApplyStatus( terminationCorrectUpdateInputDTO.getApplyStatus() );
        terminationCorrect.setApplyUser( terminationCorrectUpdateInputDTO.getApplyUser() );
        terminationCorrect.setApplyName( terminationCorrectUpdateInputDTO.getApplyName() );
        terminationCorrect.setApplyTime( terminationCorrectUpdateInputDTO.getApplyTime() );
        terminationCorrect.setRef( terminationCorrectUpdateInputDTO.getRef() );
        terminationCorrect.setProcessInstanceId( terminationCorrectUpdateInputDTO.getProcessInstanceId() );
        terminationCorrect.setOrgNum( terminationCorrectUpdateInputDTO.getOrgNum() );

        return terminationCorrect;
    }

    @Override
    public TerminationCorrectListOutputDTO toList(TerminationCorrect terminationCorrect) {
        if ( terminationCorrect == null ) {
            return null;
        }

        TerminationCorrectListOutputDTO terminationCorrectListOutputDTO = new TerminationCorrectListOutputDTO();

        terminationCorrectListOutputDTO.setId( terminationCorrect.getId() );
        terminationCorrectListOutputDTO.setCorrectionUnit( terminationCorrect.getCorrectionUnit() );
        terminationCorrectListOutputDTO.setCorrectionUnitId( terminationCorrect.getCorrectionUnitId() );
        terminationCorrectListOutputDTO.setUserName( terminationCorrect.getUserName() );
        terminationCorrectListOutputDTO.setUserId( terminationCorrect.getUserId() );
        terminationCorrectListOutputDTO.setSupervisionLevel( terminationCorrect.getSupervisionLevel() );
        terminationCorrectListOutputDTO.setPerformType( terminationCorrect.getPerformType() );
        terminationCorrectListOutputDTO.setTerminationReason( terminationCorrect.getTerminationReason() );
        terminationCorrectListOutputDTO.setApprovalResult( terminationCorrect.getApprovalResult() );
        terminationCorrectListOutputDTO.setSendDuplicateComplete( terminationCorrect.getSendDuplicateComplete() );
        terminationCorrectListOutputDTO.setRemoveComplete( terminationCorrect.getRemoveComplete() );
        terminationCorrectListOutputDTO.setProgress( terminationCorrect.getProgress() );
        terminationCorrectListOutputDTO.setApplyStatus( terminationCorrect.getApplyStatus() );
        terminationCorrectListOutputDTO.setApplyUser( terminationCorrect.getApplyUser() );
        terminationCorrectListOutputDTO.setApplyName( terminationCorrect.getApplyName() );
        terminationCorrectListOutputDTO.setApplyTime( terminationCorrect.getApplyTime() );
        terminationCorrectListOutputDTO.setRef( terminationCorrect.getRef() );
        terminationCorrectListOutputDTO.setProcessInstanceId( terminationCorrect.getProcessInstanceId() );
        terminationCorrectListOutputDTO.setOrgNum( terminationCorrect.getOrgNum() );
        terminationCorrectListOutputDTO.setCreateTime( terminationCorrect.getCreateTime() );
        terminationCorrectListOutputDTO.setUpdateTime( terminationCorrect.getUpdateTime() );
        terminationCorrectListOutputDTO.setCreator( terminationCorrect.getCreator() );
        terminationCorrectListOutputDTO.setUpdater( terminationCorrect.getUpdater() );
        terminationCorrectListOutputDTO.setDeleted( terminationCorrect.getDeleted() );

        return terminationCorrectListOutputDTO;
    }

    @Override
    public List<TerminationCorrectListOutputDTO> toList(List<TerminationCorrect> terminationCorrects) {
        if ( terminationCorrects == null ) {
            return null;
        }

        List<TerminationCorrectListOutputDTO> list = new ArrayList<TerminationCorrectListOutputDTO>( terminationCorrects.size() );
        for ( TerminationCorrect terminationCorrect : terminationCorrects ) {
            list.add( toList( terminationCorrect ) );
        }

        return list;
    }
}
