package com.correction.backend.modules.handleCorrection.convert;

import com.correction.backend.modules.handleCorrection.controller.dto.HandleCorrectionCreateInputDTO;
import com.correction.backend.modules.handleCorrection.controller.dto.HandleCorrectionListOutputDTO;
import com.correction.backend.modules.handleCorrection.controller.dto.HandleCorrectionSearchInputDTO;
import com.correction.backend.modules.handleCorrection.controller.dto.HandleCorrectionUpdateInputDTO;
import com.correction.backend.modules.handleCorrection.entity.HandleCorrection;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-19T02:18:58+0800",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 1.8.0_211 (Oracle Corporation)"
)
public class MHandleCorrectionConvertImpl implements MHandleCorrectionConvert {

    @Override
    public HandleCorrection toHandleCorrection(HandleCorrectionSearchInputDTO handleCorrectionSearchInputDTO) {
        if ( handleCorrectionSearchInputDTO == null ) {
            return null;
        }

        HandleCorrection handleCorrection = new HandleCorrection();

        handleCorrection.setCreateTime( handleCorrectionSearchInputDTO.getCreateTime() );
        handleCorrection.setUpdateTime( handleCorrectionSearchInputDTO.getUpdateTime() );
        handleCorrection.setCreator( handleCorrectionSearchInputDTO.getCreator() );
        handleCorrection.setUpdater( handleCorrectionSearchInputDTO.getUpdater() );
        handleCorrection.setDeleted( handleCorrectionSearchInputDTO.getDeleted() );
        handleCorrection.setEntrustType( handleCorrectionSearchInputDTO.getEntrustType() );
        handleCorrection.setEntrustUnit( handleCorrectionSearchInputDTO.getEntrustUnit() );
        handleCorrection.setName( handleCorrectionSearchInputDTO.getName() );
        handleCorrection.setEntrustDate( handleCorrectionSearchInputDTO.getEntrustDate() );
        handleCorrection.setReceptionDate( handleCorrectionSearchInputDTO.getReceptionDate() );
        handleCorrection.setSurveyEvaluationId( handleCorrectionSearchInputDTO.getSurveyEvaluationId() );
        handleCorrection.setIsHandle( handleCorrectionSearchInputDTO.getIsHandle() );
        handleCorrection.setReportsType( handleCorrectionSearchInputDTO.getReportsType() );
        handleCorrection.setFactSheet( handleCorrectionSearchInputDTO.getFactSheet() );
        handleCorrection.setIsCheckDocuments( handleCorrectionSearchInputDTO.getIsCheckDocuments() );
        handleCorrection.setIsCheckIdentity( handleCorrectionSearchInputDTO.getIsCheckIdentity() );
        handleCorrection.setReportsOvertime( handleCorrectionSearchInputDTO.getReportsOvertime() );
        handleCorrection.setReportsRemark( handleCorrectionSearchInputDTO.getReportsRemark() );
        handleCorrection.setIsTabfill( handleCorrectionSearchInputDTO.getIsTabfill() );
        handleCorrection.setIsCollect( handleCorrectionSearchInputDTO.getIsCollect() );
        handleCorrection.setIsSignature( handleCorrectionSearchInputDTO.getIsSignature() );
        handleCorrection.setCheckSysIdentity( handleCorrectionSearchInputDTO.getCheckSysIdentity() );
        handleCorrection.setCheckSysRemark( handleCorrectionSearchInputDTO.getCheckSysRemark() );
        handleCorrection.setIsFillBelow( handleCorrectionSearchInputDTO.getIsFillBelow() );
        handleCorrection.setIsSendOrg( handleCorrectionSearchInputDTO.getIsSendOrg() );
        handleCorrection.setIsSubmitDoc( handleCorrectionSearchInputDTO.getIsSubmitDoc() );
        handleCorrection.setIsFillBelowOpen( handleCorrectionSearchInputDTO.getIsFillBelowOpen() );
        handleCorrection.setIsCommitt( handleCorrectionSearchInputDTO.getIsCommitt() );
        handleCorrection.setIsFillBelowSend( handleCorrectionSearchInputDTO.getIsFillBelowSend() );
        handleCorrection.setIsAttmentSend( handleCorrectionSearchInputDTO.getIsAttmentSend() );
        handleCorrection.setProgress( handleCorrectionSearchInputDTO.getProgress() );
        handleCorrection.setApplyStatus( handleCorrectionSearchInputDTO.getApplyStatus() );
        handleCorrection.setApplyUser( handleCorrectionSearchInputDTO.getApplyUser() );
        handleCorrection.setApplyName( handleCorrectionSearchInputDTO.getApplyName() );
        handleCorrection.setApplyTime( handleCorrectionSearchInputDTO.getApplyTime() );
        handleCorrection.setOrgNum( handleCorrectionSearchInputDTO.getOrgNum() );

        return handleCorrection;
    }

    @Override
    public HandleCorrection toHandleCorrection(HandleCorrectionCreateInputDTO handleCorrectionCreateInputDTO) {
        if ( handleCorrectionCreateInputDTO == null ) {
            return null;
        }

        HandleCorrection handleCorrection = new HandleCorrection();

        handleCorrection.setCreateTime( handleCorrectionCreateInputDTO.getCreateTime() );
        handleCorrection.setUpdateTime( handleCorrectionCreateInputDTO.getUpdateTime() );
        handleCorrection.setCreator( handleCorrectionCreateInputDTO.getCreator() );
        handleCorrection.setUpdater( handleCorrectionCreateInputDTO.getUpdater() );
        handleCorrection.setDeleted( handleCorrectionCreateInputDTO.getDeleted() );
        handleCorrection.setId( handleCorrectionCreateInputDTO.getId() );
        handleCorrection.setEntrustType( handleCorrectionCreateInputDTO.getEntrustType() );
        handleCorrection.setEntrustUnit( handleCorrectionCreateInputDTO.getEntrustUnit() );
        handleCorrection.setJurisdictionOffice( handleCorrectionCreateInputDTO.getJurisdictionOffice() );
        handleCorrection.setJurisdictionOfficeId( handleCorrectionCreateInputDTO.getJurisdictionOfficeId() );
        handleCorrection.setName( handleCorrectionCreateInputDTO.getName() );
        handleCorrection.setEntrustDate( handleCorrectionCreateInputDTO.getEntrustDate() );
        handleCorrection.setReceptionDate( handleCorrectionCreateInputDTO.getReceptionDate() );
        handleCorrection.setSurveyEvaluationId( handleCorrectionCreateInputDTO.getSurveyEvaluationId() );
        handleCorrection.setIsHandle( handleCorrectionCreateInputDTO.getIsHandle() );
        handleCorrection.setReportsType( handleCorrectionCreateInputDTO.getReportsType() );
        handleCorrection.setFactSheet( handleCorrectionCreateInputDTO.getFactSheet() );
        handleCorrection.setIsCheckDocuments( handleCorrectionCreateInputDTO.getIsCheckDocuments() );
        handleCorrection.setIsCheckIdentity( handleCorrectionCreateInputDTO.getIsCheckIdentity() );
        handleCorrection.setReportsOvertime( handleCorrectionCreateInputDTO.getReportsOvertime() );
        handleCorrection.setReportsRemark( handleCorrectionCreateInputDTO.getReportsRemark() );
        handleCorrection.setIsTabfill( handleCorrectionCreateInputDTO.getIsTabfill() );
        handleCorrection.setIsCollect( handleCorrectionCreateInputDTO.getIsCollect() );
        handleCorrection.setIsSignature( handleCorrectionCreateInputDTO.getIsSignature() );
        handleCorrection.setCheckSysIdentity( handleCorrectionCreateInputDTO.getCheckSysIdentity() );
        handleCorrection.setCheckSysRemark( handleCorrectionCreateInputDTO.getCheckSysRemark() );
        handleCorrection.setIsFillBelow( handleCorrectionCreateInputDTO.getIsFillBelow() );
        handleCorrection.setIsSendOrg( handleCorrectionCreateInputDTO.getIsSendOrg() );
        handleCorrection.setIsSubmitDoc( handleCorrectionCreateInputDTO.getIsSubmitDoc() );
        handleCorrection.setIsFillBelowOpen( handleCorrectionCreateInputDTO.getIsFillBelowOpen() );
        handleCorrection.setIsCommitt( handleCorrectionCreateInputDTO.getIsCommitt() );
        handleCorrection.setIsFillBelowSend( handleCorrectionCreateInputDTO.getIsFillBelowSend() );
        handleCorrection.setIsAttmentSend( handleCorrectionCreateInputDTO.getIsAttmentSend() );
        handleCorrection.setProgress( handleCorrectionCreateInputDTO.getProgress() );
        handleCorrection.setApplyStatus( handleCorrectionCreateInputDTO.getApplyStatus() );
        handleCorrection.setApplyUser( handleCorrectionCreateInputDTO.getApplyUser() );
        handleCorrection.setApplyName( handleCorrectionCreateInputDTO.getApplyName() );
        handleCorrection.setApplyTime( handleCorrectionCreateInputDTO.getApplyTime() );
        handleCorrection.setOrgNum( handleCorrectionCreateInputDTO.getOrgNum() );

        return handleCorrection;
    }

    @Override
    public HandleCorrection toHandleCorrection(HandleCorrectionUpdateInputDTO handleCorrectionUpdateInputDTO) {
        if ( handleCorrectionUpdateInputDTO == null ) {
            return null;
        }

        HandleCorrection handleCorrection = new HandleCorrection();

        handleCorrection.setCreateTime( handleCorrectionUpdateInputDTO.getCreateTime() );
        handleCorrection.setUpdateTime( handleCorrectionUpdateInputDTO.getUpdateTime() );
        handleCorrection.setCreator( handleCorrectionUpdateInputDTO.getCreator() );
        handleCorrection.setUpdater( handleCorrectionUpdateInputDTO.getUpdater() );
        handleCorrection.setDeleted( handleCorrectionUpdateInputDTO.getDeleted() );
        handleCorrection.setId( handleCorrectionUpdateInputDTO.getId() );
        handleCorrection.setEntrustType( handleCorrectionUpdateInputDTO.getEntrustType() );
        handleCorrection.setEntrustUnit( handleCorrectionUpdateInputDTO.getEntrustUnit() );
        handleCorrection.setName( handleCorrectionUpdateInputDTO.getName() );
        handleCorrection.setEntrustDate( handleCorrectionUpdateInputDTO.getEntrustDate() );
        handleCorrection.setReceptionDate( handleCorrectionUpdateInputDTO.getReceptionDate() );
        handleCorrection.setSurveyEvaluationId( handleCorrectionUpdateInputDTO.getSurveyEvaluationId() );
        handleCorrection.setIsHandle( handleCorrectionUpdateInputDTO.getIsHandle() );
        handleCorrection.setReportsType( handleCorrectionUpdateInputDTO.getReportsType() );
        handleCorrection.setFactSheet( handleCorrectionUpdateInputDTO.getFactSheet() );
        handleCorrection.setIsCheckDocuments( handleCorrectionUpdateInputDTO.getIsCheckDocuments() );
        handleCorrection.setIsCheckIdentity( handleCorrectionUpdateInputDTO.getIsCheckIdentity() );
        handleCorrection.setReportsOvertime( handleCorrectionUpdateInputDTO.getReportsOvertime() );
        handleCorrection.setReportsRemark( handleCorrectionUpdateInputDTO.getReportsRemark() );
        handleCorrection.setIsTabfill( handleCorrectionUpdateInputDTO.getIsTabfill() );
        handleCorrection.setIsCollect( handleCorrectionUpdateInputDTO.getIsCollect() );
        handleCorrection.setIsSignature( handleCorrectionUpdateInputDTO.getIsSignature() );
        handleCorrection.setCheckSysIdentity( handleCorrectionUpdateInputDTO.getCheckSysIdentity() );
        handleCorrection.setCheckSysRemark( handleCorrectionUpdateInputDTO.getCheckSysRemark() );
        handleCorrection.setIsFillBelow( handleCorrectionUpdateInputDTO.getIsFillBelow() );
        handleCorrection.setIsSendOrg( handleCorrectionUpdateInputDTO.getIsSendOrg() );
        handleCorrection.setIsSubmitDoc( handleCorrectionUpdateInputDTO.getIsSubmitDoc() );
        handleCorrection.setIsFillBelowOpen( handleCorrectionUpdateInputDTO.getIsFillBelowOpen() );
        handleCorrection.setIsCommitt( handleCorrectionUpdateInputDTO.getIsCommitt() );
        handleCorrection.setIsFillBelowSend( handleCorrectionUpdateInputDTO.getIsFillBelowSend() );
        handleCorrection.setIsAttmentSend( handleCorrectionUpdateInputDTO.getIsAttmentSend() );
        handleCorrection.setProgress( handleCorrectionUpdateInputDTO.getProgress() );
        handleCorrection.setApplyStatus( handleCorrectionUpdateInputDTO.getApplyStatus() );
        handleCorrection.setApplyUser( handleCorrectionUpdateInputDTO.getApplyUser() );
        handleCorrection.setApplyName( handleCorrectionUpdateInputDTO.getApplyName() );
        handleCorrection.setApplyTime( handleCorrectionUpdateInputDTO.getApplyTime() );
        handleCorrection.setOrgNum( handleCorrectionUpdateInputDTO.getOrgNum() );

        return handleCorrection;
    }

    @Override
    public HandleCorrectionListOutputDTO toList(HandleCorrection handleCorrection) {
        if ( handleCorrection == null ) {
            return null;
        }

        HandleCorrectionListOutputDTO handleCorrectionListOutputDTO = new HandleCorrectionListOutputDTO();

        handleCorrectionListOutputDTO.setId( handleCorrection.getId() );
        handleCorrectionListOutputDTO.setEntrustType( handleCorrection.getEntrustType() );
        handleCorrectionListOutputDTO.setEntrustUnit( handleCorrection.getEntrustUnit() );
        handleCorrectionListOutputDTO.setName( handleCorrection.getName() );
        handleCorrectionListOutputDTO.setEntrustDate( handleCorrection.getEntrustDate() );
        handleCorrectionListOutputDTO.setReceptionDate( handleCorrection.getReceptionDate() );
        handleCorrectionListOutputDTO.setSurveyEvaluationId( handleCorrection.getSurveyEvaluationId() );
        handleCorrectionListOutputDTO.setIsHandle( handleCorrection.getIsHandle() );
        handleCorrectionListOutputDTO.setReportsType( handleCorrection.getReportsType() );
        handleCorrectionListOutputDTO.setFactSheet( handleCorrection.getFactSheet() );
        handleCorrectionListOutputDTO.setIsCheckDocuments( handleCorrection.getIsCheckDocuments() );
        handleCorrectionListOutputDTO.setIsCheckIdentity( handleCorrection.getIsCheckIdentity() );
        handleCorrectionListOutputDTO.setReportsOvertime( handleCorrection.getReportsOvertime() );
        handleCorrectionListOutputDTO.setReportsRemark( handleCorrection.getReportsRemark() );
        handleCorrectionListOutputDTO.setIsTabfill( handleCorrection.getIsTabfill() );
        handleCorrectionListOutputDTO.setIsCollect( handleCorrection.getIsCollect() );
        handleCorrectionListOutputDTO.setIsSignature( handleCorrection.getIsSignature() );
        handleCorrectionListOutputDTO.setCheckSysIdentity( handleCorrection.getCheckSysIdentity() );
        handleCorrectionListOutputDTO.setCheckSysRemark( handleCorrection.getCheckSysRemark() );
        handleCorrectionListOutputDTO.setIsFillBelow( handleCorrection.getIsFillBelow() );
        handleCorrectionListOutputDTO.setIsSendOrg( handleCorrection.getIsSendOrg() );
        handleCorrectionListOutputDTO.setIsSubmitDoc( handleCorrection.getIsSubmitDoc() );
        handleCorrectionListOutputDTO.setIsFillBelowOpen( handleCorrection.getIsFillBelowOpen() );
        handleCorrectionListOutputDTO.setIsCommitt( handleCorrection.getIsCommitt() );
        handleCorrectionListOutputDTO.setIsFillBelowSend( handleCorrection.getIsFillBelowSend() );
        handleCorrectionListOutputDTO.setIsAttmentSend( handleCorrection.getIsAttmentSend() );
        handleCorrectionListOutputDTO.setProgress( handleCorrection.getProgress() );
        handleCorrectionListOutputDTO.setApplyStatus( handleCorrection.getApplyStatus() );
        handleCorrectionListOutputDTO.setApplyUser( handleCorrection.getApplyUser() );
        handleCorrectionListOutputDTO.setApplyName( handleCorrection.getApplyName() );
        handleCorrectionListOutputDTO.setApplyTime( handleCorrection.getApplyTime() );
        handleCorrectionListOutputDTO.setOrgNum( handleCorrection.getOrgNum() );
        handleCorrectionListOutputDTO.setCreateTime( handleCorrection.getCreateTime() );
        handleCorrectionListOutputDTO.setUpdateTime( handleCorrection.getUpdateTime() );
        handleCorrectionListOutputDTO.setCreator( handleCorrection.getCreator() );
        handleCorrectionListOutputDTO.setUpdater( handleCorrection.getUpdater() );
        handleCorrectionListOutputDTO.setDeleted( handleCorrection.getDeleted() );
        handleCorrectionListOutputDTO.setRef( handleCorrection.getRef() );
        handleCorrectionListOutputDTO.setProcessInstanceId( handleCorrection.getProcessInstanceId() );
        handleCorrectionListOutputDTO.setJurisdictionOffice( handleCorrection.getJurisdictionOffice() );
        if ( handleCorrection.getJurisdictionOfficeId() != null ) {
            handleCorrectionListOutputDTO.setJurisdictionOfficeId( String.valueOf( handleCorrection.getJurisdictionOfficeId() ) );
        }

        return handleCorrectionListOutputDTO;
    }

    @Override
    public List<HandleCorrectionListOutputDTO> toList(List<HandleCorrection> handleCorrections) {
        if ( handleCorrections == null ) {
            return null;
        }

        List<HandleCorrectionListOutputDTO> list = new ArrayList<HandleCorrectionListOutputDTO>( handleCorrections.size() );
        for ( HandleCorrection handleCorrection : handleCorrections ) {
            list.add( toList( handleCorrection ) );
        }

        return list;
    }
}
