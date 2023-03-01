package com.correction.backend.modules.cases.convert;

import com.correction.backend.modules.cases.controller.dto.CasesPunishmentCreateInputDTO;
import com.correction.backend.modules.cases.controller.dto.CasesPunishmentListOutputDTO;
import com.correction.backend.modules.cases.controller.dto.CasesPunishmentSearchInputDTO;
import com.correction.backend.modules.cases.controller.dto.CasesPunishmentUpdateInputDTO;
import com.correction.backend.modules.cases.entity.CasesPunishment;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-24T23:49:00+0800",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 1.8.0_211 (Oracle Corporation)"
)
public class MCasesPunishmentConvertImpl implements MCasesPunishmentConvert {

    @Override
    public CasesPunishment toCasesPunishment(CasesPunishmentSearchInputDTO casesPunishmentSearchInputDTO) {
        if ( casesPunishmentSearchInputDTO == null ) {
            return null;
        }

        CasesPunishment casesPunishment = new CasesPunishment();

        casesPunishment.setCreateTime( casesPunishmentSearchInputDTO.getCreateTime() );
        casesPunishment.setUpdateTime( casesPunishmentSearchInputDTO.getUpdateTime() );
        casesPunishment.setCreator( casesPunishmentSearchInputDTO.getCreator() );
        casesPunishment.setUpdater( casesPunishmentSearchInputDTO.getUpdater() );
        casesPunishment.setDeleted( casesPunishmentSearchInputDTO.getDeleted() );
        casesPunishment.setCorrectionUnit( casesPunishmentSearchInputDTO.getCorrectionUnit() );
        casesPunishment.setCorrectionUnitId( casesPunishmentSearchInputDTO.getCorrectionUnitId() );
        casesPunishment.setUserName( casesPunishmentSearchInputDTO.getUserName() );
        casesPunishment.setUserId( casesPunishmentSearchInputDTO.getUserId() );
        casesPunishment.setViolationsType( casesPunishmentSearchInputDTO.getViolationsType() );
        casesPunishment.setSevenDaysRecord( casesPunishmentSearchInputDTO.getSevenDaysRecord() );
        casesPunishment.setRelatedInformation( casesPunishmentSearchInputDTO.getRelatedInformation() );
        casesPunishment.setCollegiateBench( casesPunishmentSearchInputDTO.getCollegiateBench() );
        casesPunishment.setViolationsTypeAdvice( casesPunishmentSearchInputDTO.getViolationsTypeAdvice() );
        casesPunishment.setPushRequestComplete( casesPunishmentSearchInputDTO.getPushRequestComplete() );
        casesPunishment.setReInvestigationEvidence( casesPunishmentSearchInputDTO.getReInvestigationEvidence() );
        casesPunishment.setReOrganizeDiscuss( casesPunishmentSearchInputDTO.getReOrganizeDiscuss() );
        casesPunishment.setTrialResult( casesPunishmentSearchInputDTO.getTrialResult() );
        casesPunishment.setBackInfo( casesPunishmentSearchInputDTO.getBackInfo() );
        casesPunishment.setReviewComplete( casesPunishmentSearchInputDTO.getReviewComplete() );
        casesPunishment.setChargeApplyResult( casesPunishmentSearchInputDTO.getChargeApplyResult() );
        casesPunishment.setDraftingInstrumentComplete( casesPunishmentSearchInputDTO.getDraftingInstrumentComplete() );
        casesPunishment.setSendDraftingInstrumentComplete( casesPunishmentSearchInputDTO.getSendDraftingInstrumentComplete() );
        casesPunishment.setApplyDraftingInstrumentComplete( casesPunishmentSearchInputDTO.getApplyDraftingInstrumentComplete() );
        casesPunishment.setPrintDraftingInstrumentComplete( casesPunishmentSearchInputDTO.getPrintDraftingInstrumentComplete() );
        casesPunishment.setThreeDaysSendCorrection( casesPunishmentSearchInputDTO.getThreeDaysSendCorrection() );
        casesPunishment.setSendDuplicate( casesPunishmentSearchInputDTO.getSendDuplicate() );
        casesPunishment.setEducationComplete( casesPunishmentSearchInputDTO.getEducationComplete() );
        casesPunishment.setDeliveryComplete( casesPunishmentSearchInputDTO.getDeliveryComplete() );
        casesPunishment.setSendDuplicateComplete( casesPunishmentSearchInputDTO.getSendDuplicateComplete() );
        casesPunishment.setAllDraftingInstrumentUpload( casesPunishmentSearchInputDTO.getAllDraftingInstrumentUpload() );
        casesPunishment.setPutPrisonComplete( casesPunishmentSearchInputDTO.getPutPrisonComplete() );
        casesPunishment.setProgress( casesPunishmentSearchInputDTO.getProgress() );
        casesPunishment.setApplyStatus( casesPunishmentSearchInputDTO.getApplyStatus() );
        casesPunishment.setApplyUser( casesPunishmentSearchInputDTO.getApplyUser() );
        casesPunishment.setApplyName( casesPunishmentSearchInputDTO.getApplyName() );
        casesPunishment.setApplyTime( casesPunishmentSearchInputDTO.getApplyTime() );
        casesPunishment.setRef( casesPunishmentSearchInputDTO.getRef() );
        casesPunishment.setProcessInstanceId( casesPunishmentSearchInputDTO.getProcessInstanceId() );
        casesPunishment.setNextRef( casesPunishmentSearchInputDTO.getNextRef() );
        casesPunishment.setNextProcessInstanceId( casesPunishmentSearchInputDTO.getNextProcessInstanceId() );
        casesPunishment.setOrgNum( casesPunishmentSearchInputDTO.getOrgNum() );

        return casesPunishment;
    }

    @Override
    public CasesPunishment toCasesPunishment(CasesPunishmentCreateInputDTO casesPunishmentCreateInputDTO) {
        if ( casesPunishmentCreateInputDTO == null ) {
            return null;
        }

        CasesPunishment casesPunishment = new CasesPunishment();

        casesPunishment.setCreateTime( casesPunishmentCreateInputDTO.getCreateTime() );
        casesPunishment.setUpdateTime( casesPunishmentCreateInputDTO.getUpdateTime() );
        casesPunishment.setCreator( casesPunishmentCreateInputDTO.getCreator() );
        casesPunishment.setUpdater( casesPunishmentCreateInputDTO.getUpdater() );
        casesPunishment.setDeleted( casesPunishmentCreateInputDTO.getDeleted() );
        casesPunishment.setId( casesPunishmentCreateInputDTO.getId() );
        casesPunishment.setCorrectionUnit( casesPunishmentCreateInputDTO.getCorrectionUnit() );
        casesPunishment.setCorrectionUnitId( casesPunishmentCreateInputDTO.getCorrectionUnitId() );
        casesPunishment.setUserName( casesPunishmentCreateInputDTO.getUserName() );
        casesPunishment.setUserId( casesPunishmentCreateInputDTO.getUserId() );
        casesPunishment.setViolationsType( casesPunishmentCreateInputDTO.getViolationsType() );
        casesPunishment.setSevenDaysRecord( casesPunishmentCreateInputDTO.getSevenDaysRecord() );
        casesPunishment.setRelatedInformation( casesPunishmentCreateInputDTO.getRelatedInformation() );
        casesPunishment.setCollegiateBench( casesPunishmentCreateInputDTO.getCollegiateBench() );
        casesPunishment.setViolationsTypeAdvice( casesPunishmentCreateInputDTO.getViolationsTypeAdvice() );
        casesPunishment.setPushRequestComplete( casesPunishmentCreateInputDTO.getPushRequestComplete() );
        casesPunishment.setReInvestigationEvidence( casesPunishmentCreateInputDTO.getReInvestigationEvidence() );
        casesPunishment.setReOrganizeDiscuss( casesPunishmentCreateInputDTO.getReOrganizeDiscuss() );
        casesPunishment.setTrialResult( casesPunishmentCreateInputDTO.getTrialResult() );
        casesPunishment.setBackInfo( casesPunishmentCreateInputDTO.getBackInfo() );
        casesPunishment.setReviewComplete( casesPunishmentCreateInputDTO.getReviewComplete() );
        casesPunishment.setChargeApplyResult( casesPunishmentCreateInputDTO.getChargeApplyResult() );
        casesPunishment.setDraftingInstrumentComplete( casesPunishmentCreateInputDTO.getDraftingInstrumentComplete() );
        casesPunishment.setSendDraftingInstrumentComplete( casesPunishmentCreateInputDTO.getSendDraftingInstrumentComplete() );
        casesPunishment.setApplyDraftingInstrumentComplete( casesPunishmentCreateInputDTO.getApplyDraftingInstrumentComplete() );
        casesPunishment.setPrintDraftingInstrumentComplete( casesPunishmentCreateInputDTO.getPrintDraftingInstrumentComplete() );
        casesPunishment.setThreeDaysSendCorrection( casesPunishmentCreateInputDTO.getThreeDaysSendCorrection() );
        casesPunishment.setSendDuplicate( casesPunishmentCreateInputDTO.getSendDuplicate() );
        casesPunishment.setEducationComplete( casesPunishmentCreateInputDTO.getEducationComplete() );
        casesPunishment.setDeliveryComplete( casesPunishmentCreateInputDTO.getDeliveryComplete() );
        casesPunishment.setSendDuplicateComplete( casesPunishmentCreateInputDTO.getSendDuplicateComplete() );
        casesPunishment.setAllDraftingInstrumentUpload( casesPunishmentCreateInputDTO.getAllDraftingInstrumentUpload() );
        casesPunishment.setPutPrisonComplete( casesPunishmentCreateInputDTO.getPutPrisonComplete() );
        casesPunishment.setProgress( casesPunishmentCreateInputDTO.getProgress() );
        casesPunishment.setApplyStatus( casesPunishmentCreateInputDTO.getApplyStatus() );
        casesPunishment.setApplyUser( casesPunishmentCreateInputDTO.getApplyUser() );
        casesPunishment.setApplyName( casesPunishmentCreateInputDTO.getApplyName() );
        casesPunishment.setApplyTime( casesPunishmentCreateInputDTO.getApplyTime() );
        casesPunishment.setRef( casesPunishmentCreateInputDTO.getRef() );
        casesPunishment.setProcessInstanceId( casesPunishmentCreateInputDTO.getProcessInstanceId() );
        casesPunishment.setNextRef( casesPunishmentCreateInputDTO.getNextRef() );
        casesPunishment.setNextProcessInstanceId( casesPunishmentCreateInputDTO.getNextProcessInstanceId() );
        casesPunishment.setOrgNum( casesPunishmentCreateInputDTO.getOrgNum() );

        return casesPunishment;
    }

    @Override
    public CasesPunishment toCasesPunishment(CasesPunishmentUpdateInputDTO casesPunishmentUpdateInputDTO) {
        if ( casesPunishmentUpdateInputDTO == null ) {
            return null;
        }

        CasesPunishment casesPunishment = new CasesPunishment();

        casesPunishment.setCreateTime( casesPunishmentUpdateInputDTO.getCreateTime() );
        casesPunishment.setUpdateTime( casesPunishmentUpdateInputDTO.getUpdateTime() );
        casesPunishment.setCreator( casesPunishmentUpdateInputDTO.getCreator() );
        casesPunishment.setUpdater( casesPunishmentUpdateInputDTO.getUpdater() );
        casesPunishment.setDeleted( casesPunishmentUpdateInputDTO.getDeleted() );
        casesPunishment.setId( casesPunishmentUpdateInputDTO.getId() );
        casesPunishment.setCorrectionUnit( casesPunishmentUpdateInputDTO.getCorrectionUnit() );
        casesPunishment.setCorrectionUnitId( casesPunishmentUpdateInputDTO.getCorrectionUnitId() );
        casesPunishment.setUserName( casesPunishmentUpdateInputDTO.getUserName() );
        casesPunishment.setUserId( casesPunishmentUpdateInputDTO.getUserId() );
        casesPunishment.setViolationsType( casesPunishmentUpdateInputDTO.getViolationsType() );
        casesPunishment.setSevenDaysRecord( casesPunishmentUpdateInputDTO.getSevenDaysRecord() );
        casesPunishment.setRelatedInformation( casesPunishmentUpdateInputDTO.getRelatedInformation() );
        casesPunishment.setCollegiateBench( casesPunishmentUpdateInputDTO.getCollegiateBench() );
        casesPunishment.setViolationsTypeAdvice( casesPunishmentUpdateInputDTO.getViolationsTypeAdvice() );
        casesPunishment.setPushRequestComplete( casesPunishmentUpdateInputDTO.getPushRequestComplete() );
        casesPunishment.setReInvestigationEvidence( casesPunishmentUpdateInputDTO.getReInvestigationEvidence() );
        casesPunishment.setReOrganizeDiscuss( casesPunishmentUpdateInputDTO.getReOrganizeDiscuss() );
        casesPunishment.setTrialResult( casesPunishmentUpdateInputDTO.getTrialResult() );
        casesPunishment.setBackInfo( casesPunishmentUpdateInputDTO.getBackInfo() );
        casesPunishment.setReviewComplete( casesPunishmentUpdateInputDTO.getReviewComplete() );
        casesPunishment.setChargeApplyResult( casesPunishmentUpdateInputDTO.getChargeApplyResult() );
        casesPunishment.setDraftingInstrumentComplete( casesPunishmentUpdateInputDTO.getDraftingInstrumentComplete() );
        casesPunishment.setSendDraftingInstrumentComplete( casesPunishmentUpdateInputDTO.getSendDraftingInstrumentComplete() );
        casesPunishment.setApplyDraftingInstrumentComplete( casesPunishmentUpdateInputDTO.getApplyDraftingInstrumentComplete() );
        casesPunishment.setPrintDraftingInstrumentComplete( casesPunishmentUpdateInputDTO.getPrintDraftingInstrumentComplete() );
        casesPunishment.setThreeDaysSendCorrection( casesPunishmentUpdateInputDTO.getThreeDaysSendCorrection() );
        casesPunishment.setSendDuplicate( casesPunishmentUpdateInputDTO.getSendDuplicate() );
        casesPunishment.setEducationComplete( casesPunishmentUpdateInputDTO.getEducationComplete() );
        casesPunishment.setDeliveryComplete( casesPunishmentUpdateInputDTO.getDeliveryComplete() );
        casesPunishment.setSendDuplicateComplete( casesPunishmentUpdateInputDTO.getSendDuplicateComplete() );
        casesPunishment.setAllDraftingInstrumentUpload( casesPunishmentUpdateInputDTO.getAllDraftingInstrumentUpload() );
        casesPunishment.setPutPrisonComplete( casesPunishmentUpdateInputDTO.getPutPrisonComplete() );
        casesPunishment.setProgress( casesPunishmentUpdateInputDTO.getProgress() );
        casesPunishment.setApplyStatus( casesPunishmentUpdateInputDTO.getApplyStatus() );
        casesPunishment.setApplyUser( casesPunishmentUpdateInputDTO.getApplyUser() );
        casesPunishment.setApplyName( casesPunishmentUpdateInputDTO.getApplyName() );
        casesPunishment.setApplyTime( casesPunishmentUpdateInputDTO.getApplyTime() );
        casesPunishment.setRef( casesPunishmentUpdateInputDTO.getRef() );
        casesPunishment.setProcessInstanceId( casesPunishmentUpdateInputDTO.getProcessInstanceId() );
        casesPunishment.setNextRef( casesPunishmentUpdateInputDTO.getNextRef() );
        casesPunishment.setNextProcessInstanceId( casesPunishmentUpdateInputDTO.getNextProcessInstanceId() );
        casesPunishment.setOrgNum( casesPunishmentUpdateInputDTO.getOrgNum() );

        return casesPunishment;
    }

    @Override
    public CasesPunishmentListOutputDTO toList(CasesPunishment casesPunishment) {
        if ( casesPunishment == null ) {
            return null;
        }

        CasesPunishmentListOutputDTO casesPunishmentListOutputDTO = new CasesPunishmentListOutputDTO();

        casesPunishmentListOutputDTO.setId( casesPunishment.getId() );
        casesPunishmentListOutputDTO.setCorrectionUnit( casesPunishment.getCorrectionUnit() );
        casesPunishmentListOutputDTO.setCorrectionUnitId( casesPunishment.getCorrectionUnitId() );
        casesPunishmentListOutputDTO.setUserName( casesPunishment.getUserName() );
        casesPunishmentListOutputDTO.setUserId( casesPunishment.getUserId() );
        casesPunishmentListOutputDTO.setViolationsType( casesPunishment.getViolationsType() );
        casesPunishmentListOutputDTO.setSevenDaysRecord( casesPunishment.getSevenDaysRecord() );
        casesPunishmentListOutputDTO.setRelatedInformation( casesPunishment.getRelatedInformation() );
        casesPunishmentListOutputDTO.setCollegiateBench( casesPunishment.getCollegiateBench() );
        casesPunishmentListOutputDTO.setViolationsTypeAdvice( casesPunishment.getViolationsTypeAdvice() );
        casesPunishmentListOutputDTO.setPushRequestComplete( casesPunishment.getPushRequestComplete() );
        casesPunishmentListOutputDTO.setReInvestigationEvidence( casesPunishment.getReInvestigationEvidence() );
        casesPunishmentListOutputDTO.setReOrganizeDiscuss( casesPunishment.getReOrganizeDiscuss() );
        casesPunishmentListOutputDTO.setTrialResult( casesPunishment.getTrialResult() );
        casesPunishmentListOutputDTO.setBackInfo( casesPunishment.getBackInfo() );
        casesPunishmentListOutputDTO.setReviewComplete( casesPunishment.getReviewComplete() );
        casesPunishmentListOutputDTO.setChargeApplyResult( casesPunishment.getChargeApplyResult() );
        casesPunishmentListOutputDTO.setDraftingInstrumentComplete( casesPunishment.getDraftingInstrumentComplete() );
        casesPunishmentListOutputDTO.setSendDraftingInstrumentComplete( casesPunishment.getSendDraftingInstrumentComplete() );
        casesPunishmentListOutputDTO.setApplyDraftingInstrumentComplete( casesPunishment.getApplyDraftingInstrumentComplete() );
        casesPunishmentListOutputDTO.setPrintDraftingInstrumentComplete( casesPunishment.getPrintDraftingInstrumentComplete() );
        casesPunishmentListOutputDTO.setThreeDaysSendCorrection( casesPunishment.getThreeDaysSendCorrection() );
        casesPunishmentListOutputDTO.setSendDuplicate( casesPunishment.getSendDuplicate() );
        casesPunishmentListOutputDTO.setEducationComplete( casesPunishment.getEducationComplete() );
        casesPunishmentListOutputDTO.setDeliveryComplete( casesPunishment.getDeliveryComplete() );
        casesPunishmentListOutputDTO.setSendDuplicateComplete( casesPunishment.getSendDuplicateComplete() );
        casesPunishmentListOutputDTO.setAllDraftingInstrumentUpload( casesPunishment.getAllDraftingInstrumentUpload() );
        casesPunishmentListOutputDTO.setPutPrisonComplete( casesPunishment.getPutPrisonComplete() );
        casesPunishmentListOutputDTO.setProgress( casesPunishment.getProgress() );
        casesPunishmentListOutputDTO.setApplyStatus( casesPunishment.getApplyStatus() );
        casesPunishmentListOutputDTO.setApplyUser( casesPunishment.getApplyUser() );
        casesPunishmentListOutputDTO.setApplyName( casesPunishment.getApplyName() );
        casesPunishmentListOutputDTO.setApplyTime( casesPunishment.getApplyTime() );
        casesPunishmentListOutputDTO.setRef( casesPunishment.getRef() );
        casesPunishmentListOutputDTO.setProcessInstanceId( casesPunishment.getProcessInstanceId() );
        casesPunishmentListOutputDTO.setNextRef( casesPunishment.getNextRef() );
        casesPunishmentListOutputDTO.setNextProcessInstanceId( casesPunishment.getNextProcessInstanceId() );
        casesPunishmentListOutputDTO.setOrgNum( casesPunishment.getOrgNum() );
        casesPunishmentListOutputDTO.setCreateTime( casesPunishment.getCreateTime() );
        casesPunishmentListOutputDTO.setUpdateTime( casesPunishment.getUpdateTime() );
        casesPunishmentListOutputDTO.setCreator( casesPunishment.getCreator() );
        casesPunishmentListOutputDTO.setUpdater( casesPunishment.getUpdater() );
        casesPunishmentListOutputDTO.setDeleted( casesPunishment.getDeleted() );
        casesPunishmentListOutputDTO.setIsBack( casesPunishment.getIsBack() );

        return casesPunishmentListOutputDTO;
    }

    @Override
    public List<CasesPunishmentListOutputDTO> toList(List<CasesPunishment> casesPunishments) {
        if ( casesPunishments == null ) {
            return null;
        }

        List<CasesPunishmentListOutputDTO> list = new ArrayList<CasesPunishmentListOutputDTO>( casesPunishments.size() );
        for ( CasesPunishment casesPunishment : casesPunishments ) {
            list.add( toList( casesPunishment ) );
        }

        return list;
    }
}
