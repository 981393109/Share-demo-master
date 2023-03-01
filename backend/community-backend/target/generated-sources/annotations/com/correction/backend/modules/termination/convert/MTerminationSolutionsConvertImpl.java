package com.correction.backend.modules.termination.convert;

import com.correction.backend.modules.termination.controller.dto.TerminationSolutionsCreateInputDTO;
import com.correction.backend.modules.termination.controller.dto.TerminationSolutionsListOutputDTO;
import com.correction.backend.modules.termination.controller.dto.TerminationSolutionsSearchInputDTO;
import com.correction.backend.modules.termination.controller.dto.TerminationSolutionsUpdateInputDTO;
import com.correction.backend.modules.termination.entity.TerminationSolutions;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-24T23:49:00+0800",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 1.8.0_211 (Oracle Corporation)"
)
public class MTerminationSolutionsConvertImpl implements MTerminationSolutionsConvert {

    @Override
    public TerminationSolutions toTerminationSolutions(TerminationSolutionsSearchInputDTO terminationSolutionsSearchInputDTO) {
        if ( terminationSolutionsSearchInputDTO == null ) {
            return null;
        }

        TerminationSolutions terminationSolutions = new TerminationSolutions();

        terminationSolutions.setCreateTime( terminationSolutionsSearchInputDTO.getCreateTime() );
        terminationSolutions.setUpdateTime( terminationSolutionsSearchInputDTO.getUpdateTime() );
        terminationSolutions.setCreator( terminationSolutionsSearchInputDTO.getCreator() );
        terminationSolutions.setUpdater( terminationSolutionsSearchInputDTO.getUpdater() );
        terminationSolutions.setDeleted( terminationSolutionsSearchInputDTO.getDeleted() );
        terminationSolutions.setCorrectionUnit( terminationSolutionsSearchInputDTO.getCorrectionUnit() );
        terminationSolutions.setCorrectionUnitId( terminationSolutionsSearchInputDTO.getCorrectionUnitId() );
        terminationSolutions.setUserName( terminationSolutionsSearchInputDTO.getUserName() );
        terminationSolutions.setUserId( terminationSolutionsSearchInputDTO.getUserId() );
        terminationSolutions.setSupervisionLevel( terminationSolutionsSearchInputDTO.getSupervisionLevel() );
        terminationSolutions.setPerformType( terminationSolutionsSearchInputDTO.getPerformType() );
        terminationSolutions.setSolutionsComplete( terminationSolutionsSearchInputDTO.getSolutionsComplete() );
        terminationSolutions.setApprovalResult( terminationSolutionsSearchInputDTO.getApprovalResult() );
        terminationSolutions.setDeclareComplete( terminationSolutionsSearchInputDTO.getDeclareComplete() );
        terminationSolutions.setSignatureComplete( terminationSolutionsSearchInputDTO.getSignatureComplete() );
        terminationSolutions.setCohesionComplete( terminationSolutionsSearchInputDTO.getCohesionComplete() );
        terminationSolutions.setProgress( terminationSolutionsSearchInputDTO.getProgress() );
        terminationSolutions.setApplyStatus( terminationSolutionsSearchInputDTO.getApplyStatus() );
        terminationSolutions.setApplyUser( terminationSolutionsSearchInputDTO.getApplyUser() );
        terminationSolutions.setApplyName( terminationSolutionsSearchInputDTO.getApplyName() );
        terminationSolutions.setApplyTime( terminationSolutionsSearchInputDTO.getApplyTime() );
        terminationSolutions.setRef( terminationSolutionsSearchInputDTO.getRef() );
        terminationSolutions.setProcessInstanceId( terminationSolutionsSearchInputDTO.getProcessInstanceId() );
        terminationSolutions.setOrgNum( terminationSolutionsSearchInputDTO.getOrgNum() );

        return terminationSolutions;
    }

    @Override
    public TerminationSolutions toTerminationSolutions(TerminationSolutionsCreateInputDTO terminationSolutionsCreateInputDTO) {
        if ( terminationSolutionsCreateInputDTO == null ) {
            return null;
        }

        TerminationSolutions terminationSolutions = new TerminationSolutions();

        terminationSolutions.setCreateTime( terminationSolutionsCreateInputDTO.getCreateTime() );
        terminationSolutions.setUpdateTime( terminationSolutionsCreateInputDTO.getUpdateTime() );
        terminationSolutions.setCreator( terminationSolutionsCreateInputDTO.getCreator() );
        terminationSolutions.setUpdater( terminationSolutionsCreateInputDTO.getUpdater() );
        terminationSolutions.setDeleted( terminationSolutionsCreateInputDTO.getDeleted() );
        terminationSolutions.setCorrectionUnit( terminationSolutionsCreateInputDTO.getCorrectionUnit() );
        terminationSolutions.setCorrectionUnitId( terminationSolutionsCreateInputDTO.getCorrectionUnitId() );
        terminationSolutions.setUserName( terminationSolutionsCreateInputDTO.getUserName() );
        terminationSolutions.setUserId( terminationSolutionsCreateInputDTO.getUserId() );
        terminationSolutions.setSupervisionLevel( terminationSolutionsCreateInputDTO.getSupervisionLevel() );
        terminationSolutions.setPerformType( terminationSolutionsCreateInputDTO.getPerformType() );
        terminationSolutions.setSolutionsComplete( terminationSolutionsCreateInputDTO.getSolutionsComplete() );
        terminationSolutions.setApprovalResult( terminationSolutionsCreateInputDTO.getApprovalResult() );
        terminationSolutions.setDeclareComplete( terminationSolutionsCreateInputDTO.getDeclareComplete() );
        terminationSolutions.setSignatureComplete( terminationSolutionsCreateInputDTO.getSignatureComplete() );
        terminationSolutions.setCohesionComplete( terminationSolutionsCreateInputDTO.getCohesionComplete() );
        terminationSolutions.setProgress( terminationSolutionsCreateInputDTO.getProgress() );
        terminationSolutions.setApplyStatus( terminationSolutionsCreateInputDTO.getApplyStatus() );
        terminationSolutions.setApplyUser( terminationSolutionsCreateInputDTO.getApplyUser() );
        terminationSolutions.setApplyName( terminationSolutionsCreateInputDTO.getApplyName() );
        terminationSolutions.setApplyTime( terminationSolutionsCreateInputDTO.getApplyTime() );
        terminationSolutions.setRef( terminationSolutionsCreateInputDTO.getRef() );
        terminationSolutions.setProcessInstanceId( terminationSolutionsCreateInputDTO.getProcessInstanceId() );
        terminationSolutions.setOrgNum( terminationSolutionsCreateInputDTO.getOrgNum() );
        terminationSolutions.setSendProveComplete( terminationSolutionsCreateInputDTO.getSendProveComplete() );

        return terminationSolutions;
    }

    @Override
    public TerminationSolutions toTerminationSolutions(TerminationSolutionsUpdateInputDTO terminationSolutionsUpdateInputDTO) {
        if ( terminationSolutionsUpdateInputDTO == null ) {
            return null;
        }

        TerminationSolutions terminationSolutions = new TerminationSolutions();

        terminationSolutions.setCreateTime( terminationSolutionsUpdateInputDTO.getCreateTime() );
        terminationSolutions.setUpdateTime( terminationSolutionsUpdateInputDTO.getUpdateTime() );
        terminationSolutions.setCreator( terminationSolutionsUpdateInputDTO.getCreator() );
        terminationSolutions.setUpdater( terminationSolutionsUpdateInputDTO.getUpdater() );
        terminationSolutions.setDeleted( terminationSolutionsUpdateInputDTO.getDeleted() );
        terminationSolutions.setId( terminationSolutionsUpdateInputDTO.getId() );
        terminationSolutions.setCorrectionUnit( terminationSolutionsUpdateInputDTO.getCorrectionUnit() );
        terminationSolutions.setCorrectionUnitId( terminationSolutionsUpdateInputDTO.getCorrectionUnitId() );
        terminationSolutions.setUserName( terminationSolutionsUpdateInputDTO.getUserName() );
        terminationSolutions.setUserId( terminationSolutionsUpdateInputDTO.getUserId() );
        terminationSolutions.setSupervisionLevel( terminationSolutionsUpdateInputDTO.getSupervisionLevel() );
        terminationSolutions.setPerformType( terminationSolutionsUpdateInputDTO.getPerformType() );
        terminationSolutions.setSolutionsComplete( terminationSolutionsUpdateInputDTO.getSolutionsComplete() );
        terminationSolutions.setApprovalResult( terminationSolutionsUpdateInputDTO.getApprovalResult() );
        terminationSolutions.setDeclareComplete( terminationSolutionsUpdateInputDTO.getDeclareComplete() );
        terminationSolutions.setSignatureComplete( terminationSolutionsUpdateInputDTO.getSignatureComplete() );
        terminationSolutions.setCohesionComplete( terminationSolutionsUpdateInputDTO.getCohesionComplete() );
        terminationSolutions.setProgress( terminationSolutionsUpdateInputDTO.getProgress() );
        terminationSolutions.setApplyStatus( terminationSolutionsUpdateInputDTO.getApplyStatus() );
        terminationSolutions.setApplyUser( terminationSolutionsUpdateInputDTO.getApplyUser() );
        terminationSolutions.setApplyName( terminationSolutionsUpdateInputDTO.getApplyName() );
        terminationSolutions.setApplyTime( terminationSolutionsUpdateInputDTO.getApplyTime() );
        terminationSolutions.setRef( terminationSolutionsUpdateInputDTO.getRef() );
        terminationSolutions.setProcessInstanceId( terminationSolutionsUpdateInputDTO.getProcessInstanceId() );
        terminationSolutions.setOrgNum( terminationSolutionsUpdateInputDTO.getOrgNum() );
        terminationSolutions.setSendProveComplete( terminationSolutionsUpdateInputDTO.getSendProveComplete() );

        return terminationSolutions;
    }

    @Override
    public TerminationSolutionsListOutputDTO toList(TerminationSolutions terminationSolutions) {
        if ( terminationSolutions == null ) {
            return null;
        }

        TerminationSolutionsListOutputDTO terminationSolutionsListOutputDTO = new TerminationSolutionsListOutputDTO();

        terminationSolutionsListOutputDTO.setId( terminationSolutions.getId() );
        terminationSolutionsListOutputDTO.setCorrectionUnit( terminationSolutions.getCorrectionUnit() );
        terminationSolutionsListOutputDTO.setCorrectionUnitId( terminationSolutions.getCorrectionUnitId() );
        terminationSolutionsListOutputDTO.setUserName( terminationSolutions.getUserName() );
        terminationSolutionsListOutputDTO.setUserId( terminationSolutions.getUserId() );
        terminationSolutionsListOutputDTO.setSupervisionLevel( terminationSolutions.getSupervisionLevel() );
        terminationSolutionsListOutputDTO.setPerformType( terminationSolutions.getPerformType() );
        terminationSolutionsListOutputDTO.setSolutionsComplete( terminationSolutions.getSolutionsComplete() );
        terminationSolutionsListOutputDTO.setApprovalResult( terminationSolutions.getApprovalResult() );
        terminationSolutionsListOutputDTO.setDeclareComplete( terminationSolutions.getDeclareComplete() );
        terminationSolutionsListOutputDTO.setSignatureComplete( terminationSolutions.getSignatureComplete() );
        terminationSolutionsListOutputDTO.setCohesionComplete( terminationSolutions.getCohesionComplete() );
        terminationSolutionsListOutputDTO.setProgress( terminationSolutions.getProgress() );
        terminationSolutionsListOutputDTO.setApplyStatus( terminationSolutions.getApplyStatus() );
        terminationSolutionsListOutputDTO.setApplyUser( terminationSolutions.getApplyUser() );
        terminationSolutionsListOutputDTO.setApplyName( terminationSolutions.getApplyName() );
        terminationSolutionsListOutputDTO.setApplyTime( terminationSolutions.getApplyTime() );
        terminationSolutionsListOutputDTO.setRef( terminationSolutions.getRef() );
        terminationSolutionsListOutputDTO.setProcessInstanceId( terminationSolutions.getProcessInstanceId() );
        terminationSolutionsListOutputDTO.setOrgNum( terminationSolutions.getOrgNum() );
        terminationSolutionsListOutputDTO.setCreateTime( terminationSolutions.getCreateTime() );
        terminationSolutionsListOutputDTO.setUpdateTime( terminationSolutions.getUpdateTime() );
        terminationSolutionsListOutputDTO.setCreator( terminationSolutions.getCreator() );
        terminationSolutionsListOutputDTO.setUpdater( terminationSolutions.getUpdater() );
        terminationSolutionsListOutputDTO.setDeleted( terminationSolutions.getDeleted() );
        terminationSolutionsListOutputDTO.setSendProveComplete( terminationSolutions.getSendProveComplete() );

        return terminationSolutionsListOutputDTO;
    }

    @Override
    public List<TerminationSolutionsListOutputDTO> toList(List<TerminationSolutions> terminationSolutionss) {
        if ( terminationSolutionss == null ) {
            return null;
        }

        List<TerminationSolutionsListOutputDTO> list = new ArrayList<TerminationSolutionsListOutputDTO>( terminationSolutionss.size() );
        for ( TerminationSolutions terminationSolutions : terminationSolutionss ) {
            list.add( toList( terminationSolutions ) );
        }

        return list;
    }
}
