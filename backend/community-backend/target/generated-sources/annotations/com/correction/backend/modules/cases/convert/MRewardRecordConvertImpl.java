package com.correction.backend.modules.cases.convert;

import com.correction.backend.modules.cases.controller.dto.RewardRecordCreateInputDTO;
import com.correction.backend.modules.cases.controller.dto.RewardRecordListOutputDTO;
import com.correction.backend.modules.cases.controller.dto.RewardRecordSearchInputDTO;
import com.correction.backend.modules.cases.controller.dto.RewardRecordUpdateInputDTO;
import com.correction.backend.modules.cases.entity.RewardRecord;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-24T23:49:00+0800",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 1.8.0_211 (Oracle Corporation)"
)
public class MRewardRecordConvertImpl implements MRewardRecordConvert {

    @Override
    public RewardRecord toRewardRecord(RewardRecordSearchInputDTO rewardRecordSearchInputDTO) {
        if ( rewardRecordSearchInputDTO == null ) {
            return null;
        }

        RewardRecord rewardRecord = new RewardRecord();

        rewardRecord.setCreateTime( rewardRecordSearchInputDTO.getCreateTime() );
        rewardRecord.setUpdateTime( rewardRecordSearchInputDTO.getUpdateTime() );
        rewardRecord.setCreator( rewardRecordSearchInputDTO.getCreator() );
        rewardRecord.setUpdater( rewardRecordSearchInputDTO.getUpdater() );
        rewardRecord.setDeleted( rewardRecordSearchInputDTO.getDeleted() );
        rewardRecord.setCorrectionUnit( rewardRecordSearchInputDTO.getCorrectionUnit() );
        rewardRecord.setCorrectionUnitId( rewardRecordSearchInputDTO.getCorrectionUnitId() );
        rewardRecord.setUserName( rewardRecordSearchInputDTO.getUserName() );
        rewardRecord.setUserId( rewardRecordSearchInputDTO.getUserId() );
        rewardRecord.setRewardType( rewardRecordSearchInputDTO.getRewardType() );
        rewardRecord.setSevenDaysRecord( rewardRecordSearchInputDTO.getSevenDaysRecord() );
        rewardRecord.setRelatedInformation( rewardRecordSearchInputDTO.getRelatedInformation() );
        rewardRecord.setCollegiateBench( rewardRecordSearchInputDTO.getCollegiateBench() );
        rewardRecord.setRewardTypeAdvice( rewardRecordSearchInputDTO.getRewardTypeAdvice() );
        rewardRecord.setPushRequestComplete( rewardRecordSearchInputDTO.getPushRequestComplete() );
        rewardRecord.setReInvestigationEvidence( rewardRecordSearchInputDTO.getReInvestigationEvidence() );
        rewardRecord.setReOrganizeDiscuss( rewardRecordSearchInputDTO.getReOrganizeDiscuss() );
        rewardRecord.setTrialResult( rewardRecordSearchInputDTO.getTrialResult() );
        rewardRecord.setBackInfo( rewardRecordSearchInputDTO.getBackInfo() );
        rewardRecord.setReviewComplete( rewardRecordSearchInputDTO.getReviewComplete() );
        rewardRecord.setPublicCoplete( rewardRecordSearchInputDTO.getPublicCoplete() );
        rewardRecord.setChargeApplyResult( rewardRecordSearchInputDTO.getChargeApplyResult() );
        rewardRecord.setDraftingInstrumentComplete( rewardRecordSearchInputDTO.getDraftingInstrumentComplete() );
        rewardRecord.setSendDraftingInstrumentComplete( rewardRecordSearchInputDTO.getSendDraftingInstrumentComplete() );
        rewardRecord.setApplyDraftingInstrumentComplete( rewardRecordSearchInputDTO.getApplyDraftingInstrumentComplete() );
        rewardRecord.setPrintDraftingInstrumentComplete( rewardRecordSearchInputDTO.getPrintDraftingInstrumentComplete() );
        rewardRecord.setThreeDaysSendCorrection( rewardRecordSearchInputDTO.getThreeDaysSendCorrection() );
        rewardRecord.setSendDuplicate( rewardRecordSearchInputDTO.getSendDuplicate() );
        rewardRecord.setAllDraftingInstrumentUpload( rewardRecordSearchInputDTO.getAllDraftingInstrumentUpload() );
        rewardRecord.setDeliveryComplete( rewardRecordSearchInputDTO.getDeliveryComplete() );
        rewardRecord.setSendDuplicateComplete( rewardRecordSearchInputDTO.getSendDuplicateComplete() );
        rewardRecord.setProgress( rewardRecordSearchInputDTO.getProgress() );
        rewardRecord.setApplyStatus( rewardRecordSearchInputDTO.getApplyStatus() );
        rewardRecord.setApplyUser( rewardRecordSearchInputDTO.getApplyUser() );
        rewardRecord.setApplyName( rewardRecordSearchInputDTO.getApplyName() );
        rewardRecord.setApplyTime( rewardRecordSearchInputDTO.getApplyTime() );
        rewardRecord.setRef( rewardRecordSearchInputDTO.getRef() );
        rewardRecord.setProcessInstanceId( rewardRecordSearchInputDTO.getProcessInstanceId() );
        rewardRecord.setNextRef( rewardRecordSearchInputDTO.getNextRef() );
        rewardRecord.setNextProcessInstanceId( rewardRecordSearchInputDTO.getNextProcessInstanceId() );
        rewardRecord.setOrgNum( rewardRecordSearchInputDTO.getOrgNum() );

        return rewardRecord;
    }

    @Override
    public RewardRecord toRewardRecord(RewardRecordCreateInputDTO rewardRecordCreateInputDTO) {
        if ( rewardRecordCreateInputDTO == null ) {
            return null;
        }

        RewardRecord rewardRecord = new RewardRecord();

        rewardRecord.setCreateTime( rewardRecordCreateInputDTO.getCreateTime() );
        rewardRecord.setUpdateTime( rewardRecordCreateInputDTO.getUpdateTime() );
        rewardRecord.setCreator( rewardRecordCreateInputDTO.getCreator() );
        rewardRecord.setUpdater( rewardRecordCreateInputDTO.getUpdater() );
        rewardRecord.setDeleted( rewardRecordCreateInputDTO.getDeleted() );
        rewardRecord.setId( rewardRecordCreateInputDTO.getId() );
        rewardRecord.setCorrectionUnit( rewardRecordCreateInputDTO.getCorrectionUnit() );
        rewardRecord.setCorrectionUnitId( rewardRecordCreateInputDTO.getCorrectionUnitId() );
        rewardRecord.setUserName( rewardRecordCreateInputDTO.getUserName() );
        rewardRecord.setUserId( rewardRecordCreateInputDTO.getUserId() );
        rewardRecord.setRewardType( rewardRecordCreateInputDTO.getRewardType() );
        rewardRecord.setSevenDaysRecord( rewardRecordCreateInputDTO.getSevenDaysRecord() );
        rewardRecord.setRelatedInformation( rewardRecordCreateInputDTO.getRelatedInformation() );
        rewardRecord.setCollegiateBench( rewardRecordCreateInputDTO.getCollegiateBench() );
        rewardRecord.setRewardTypeAdvice( rewardRecordCreateInputDTO.getRewardTypeAdvice() );
        rewardRecord.setPushRequestComplete( rewardRecordCreateInputDTO.getPushRequestComplete() );
        rewardRecord.setReInvestigationEvidence( rewardRecordCreateInputDTO.getReInvestigationEvidence() );
        rewardRecord.setReOrganizeDiscuss( rewardRecordCreateInputDTO.getReOrganizeDiscuss() );
        rewardRecord.setTrialResult( rewardRecordCreateInputDTO.getTrialResult() );
        rewardRecord.setBackInfo( rewardRecordCreateInputDTO.getBackInfo() );
        rewardRecord.setReviewComplete( rewardRecordCreateInputDTO.getReviewComplete() );
        rewardRecord.setPublicCoplete( rewardRecordCreateInputDTO.getPublicCoplete() );
        rewardRecord.setChargeApplyResult( rewardRecordCreateInputDTO.getChargeApplyResult() );
        rewardRecord.setDraftingInstrumentComplete( rewardRecordCreateInputDTO.getDraftingInstrumentComplete() );
        rewardRecord.setSendDraftingInstrumentComplete( rewardRecordCreateInputDTO.getSendDraftingInstrumentComplete() );
        rewardRecord.setApplyDraftingInstrumentComplete( rewardRecordCreateInputDTO.getApplyDraftingInstrumentComplete() );
        rewardRecord.setPrintDraftingInstrumentComplete( rewardRecordCreateInputDTO.getPrintDraftingInstrumentComplete() );
        rewardRecord.setThreeDaysSendCorrection( rewardRecordCreateInputDTO.getThreeDaysSendCorrection() );
        rewardRecord.setSendDuplicate( rewardRecordCreateInputDTO.getSendDuplicate() );
        rewardRecord.setAllDraftingInstrumentUpload( rewardRecordCreateInputDTO.getAllDraftingInstrumentUpload() );
        rewardRecord.setDeliveryComplete( rewardRecordCreateInputDTO.getDeliveryComplete() );
        rewardRecord.setSendDuplicateComplete( rewardRecordCreateInputDTO.getSendDuplicateComplete() );
        rewardRecord.setProgress( rewardRecordCreateInputDTO.getProgress() );
        rewardRecord.setApplyStatus( rewardRecordCreateInputDTO.getApplyStatus() );
        rewardRecord.setApplyUser( rewardRecordCreateInputDTO.getApplyUser() );
        rewardRecord.setApplyName( rewardRecordCreateInputDTO.getApplyName() );
        rewardRecord.setApplyTime( rewardRecordCreateInputDTO.getApplyTime() );
        rewardRecord.setRef( rewardRecordCreateInputDTO.getRef() );
        rewardRecord.setProcessInstanceId( rewardRecordCreateInputDTO.getProcessInstanceId() );
        rewardRecord.setNextFlowType( rewardRecordCreateInputDTO.getNextFlowType() );
        rewardRecord.setNextRef( rewardRecordCreateInputDTO.getNextRef() );
        rewardRecord.setNextProcessInstanceId( rewardRecordCreateInputDTO.getNextProcessInstanceId() );
        rewardRecord.setOrgNum( rewardRecordCreateInputDTO.getOrgNum() );

        return rewardRecord;
    }

    @Override
    public RewardRecord toRewardRecord(RewardRecordUpdateInputDTO rewardRecordUpdateInputDTO) {
        if ( rewardRecordUpdateInputDTO == null ) {
            return null;
        }

        RewardRecord rewardRecord = new RewardRecord();

        rewardRecord.setCreateTime( rewardRecordUpdateInputDTO.getCreateTime() );
        rewardRecord.setUpdateTime( rewardRecordUpdateInputDTO.getUpdateTime() );
        rewardRecord.setCreator( rewardRecordUpdateInputDTO.getCreator() );
        rewardRecord.setUpdater( rewardRecordUpdateInputDTO.getUpdater() );
        rewardRecord.setDeleted( rewardRecordUpdateInputDTO.getDeleted() );
        rewardRecord.setId( rewardRecordUpdateInputDTO.getId() );
        rewardRecord.setCorrectionUnit( rewardRecordUpdateInputDTO.getCorrectionUnit() );
        rewardRecord.setCorrectionUnitId( rewardRecordUpdateInputDTO.getCorrectionUnitId() );
        rewardRecord.setUserName( rewardRecordUpdateInputDTO.getUserName() );
        rewardRecord.setUserId( rewardRecordUpdateInputDTO.getUserId() );
        rewardRecord.setRewardType( rewardRecordUpdateInputDTO.getRewardType() );
        rewardRecord.setSevenDaysRecord( rewardRecordUpdateInputDTO.getSevenDaysRecord() );
        rewardRecord.setRelatedInformation( rewardRecordUpdateInputDTO.getRelatedInformation() );
        rewardRecord.setCollegiateBench( rewardRecordUpdateInputDTO.getCollegiateBench() );
        rewardRecord.setRewardTypeAdvice( rewardRecordUpdateInputDTO.getRewardTypeAdvice() );
        rewardRecord.setPushRequestComplete( rewardRecordUpdateInputDTO.getPushRequestComplete() );
        rewardRecord.setReInvestigationEvidence( rewardRecordUpdateInputDTO.getReInvestigationEvidence() );
        rewardRecord.setReOrganizeDiscuss( rewardRecordUpdateInputDTO.getReOrganizeDiscuss() );
        rewardRecord.setTrialResult( rewardRecordUpdateInputDTO.getTrialResult() );
        rewardRecord.setBackInfo( rewardRecordUpdateInputDTO.getBackInfo() );
        rewardRecord.setReviewComplete( rewardRecordUpdateInputDTO.getReviewComplete() );
        rewardRecord.setPublicCoplete( rewardRecordUpdateInputDTO.getPublicCoplete() );
        rewardRecord.setChargeApplyResult( rewardRecordUpdateInputDTO.getChargeApplyResult() );
        rewardRecord.setDraftingInstrumentComplete( rewardRecordUpdateInputDTO.getDraftingInstrumentComplete() );
        rewardRecord.setSendDraftingInstrumentComplete( rewardRecordUpdateInputDTO.getSendDraftingInstrumentComplete() );
        rewardRecord.setApplyDraftingInstrumentComplete( rewardRecordUpdateInputDTO.getApplyDraftingInstrumentComplete() );
        rewardRecord.setPrintDraftingInstrumentComplete( rewardRecordUpdateInputDTO.getPrintDraftingInstrumentComplete() );
        rewardRecord.setThreeDaysSendCorrection( rewardRecordUpdateInputDTO.getThreeDaysSendCorrection() );
        rewardRecord.setSendDuplicate( rewardRecordUpdateInputDTO.getSendDuplicate() );
        rewardRecord.setAllDraftingInstrumentUpload( rewardRecordUpdateInputDTO.getAllDraftingInstrumentUpload() );
        rewardRecord.setDeliveryComplete( rewardRecordUpdateInputDTO.getDeliveryComplete() );
        rewardRecord.setSendDuplicateComplete( rewardRecordUpdateInputDTO.getSendDuplicateComplete() );
        rewardRecord.setProgress( rewardRecordUpdateInputDTO.getProgress() );
        rewardRecord.setApplyStatus( rewardRecordUpdateInputDTO.getApplyStatus() );
        rewardRecord.setApplyUser( rewardRecordUpdateInputDTO.getApplyUser() );
        rewardRecord.setApplyName( rewardRecordUpdateInputDTO.getApplyName() );
        rewardRecord.setApplyTime( rewardRecordUpdateInputDTO.getApplyTime() );
        rewardRecord.setRef( rewardRecordUpdateInputDTO.getRef() );
        rewardRecord.setProcessInstanceId( rewardRecordUpdateInputDTO.getProcessInstanceId() );
        rewardRecord.setNextFlowType( rewardRecordUpdateInputDTO.getNextFlowType() );
        rewardRecord.setNextRef( rewardRecordUpdateInputDTO.getNextRef() );
        rewardRecord.setNextProcessInstanceId( rewardRecordUpdateInputDTO.getNextProcessInstanceId() );
        rewardRecord.setOrgNum( rewardRecordUpdateInputDTO.getOrgNum() );

        return rewardRecord;
    }

    @Override
    public RewardRecordListOutputDTO toList(RewardRecord rewardRecord) {
        if ( rewardRecord == null ) {
            return null;
        }

        RewardRecordListOutputDTO rewardRecordListOutputDTO = new RewardRecordListOutputDTO();

        rewardRecordListOutputDTO.setId( rewardRecord.getId() );
        rewardRecordListOutputDTO.setCorrectionUnit( rewardRecord.getCorrectionUnit() );
        rewardRecordListOutputDTO.setCorrectionUnitId( rewardRecord.getCorrectionUnitId() );
        rewardRecordListOutputDTO.setUserName( rewardRecord.getUserName() );
        rewardRecordListOutputDTO.setUserId( rewardRecord.getUserId() );
        rewardRecordListOutputDTO.setRewardType( rewardRecord.getRewardType() );
        rewardRecordListOutputDTO.setSevenDaysRecord( rewardRecord.getSevenDaysRecord() );
        rewardRecordListOutputDTO.setRelatedInformation( rewardRecord.getRelatedInformation() );
        rewardRecordListOutputDTO.setCollegiateBench( rewardRecord.getCollegiateBench() );
        rewardRecordListOutputDTO.setRewardTypeAdvice( rewardRecord.getRewardTypeAdvice() );
        rewardRecordListOutputDTO.setPushRequestComplete( rewardRecord.getPushRequestComplete() );
        rewardRecordListOutputDTO.setReInvestigationEvidence( rewardRecord.getReInvestigationEvidence() );
        rewardRecordListOutputDTO.setReOrganizeDiscuss( rewardRecord.getReOrganizeDiscuss() );
        rewardRecordListOutputDTO.setTrialResult( rewardRecord.getTrialResult() );
        rewardRecordListOutputDTO.setBackInfo( rewardRecord.getBackInfo() );
        rewardRecordListOutputDTO.setReviewComplete( rewardRecord.getReviewComplete() );
        rewardRecordListOutputDTO.setPublicCoplete( rewardRecord.getPublicCoplete() );
        rewardRecordListOutputDTO.setChargeApplyResult( rewardRecord.getChargeApplyResult() );
        rewardRecordListOutputDTO.setDraftingInstrumentComplete( rewardRecord.getDraftingInstrumentComplete() );
        rewardRecordListOutputDTO.setSendDraftingInstrumentComplete( rewardRecord.getSendDraftingInstrumentComplete() );
        rewardRecordListOutputDTO.setApplyDraftingInstrumentComplete( rewardRecord.getApplyDraftingInstrumentComplete() );
        rewardRecordListOutputDTO.setPrintDraftingInstrumentComplete( rewardRecord.getPrintDraftingInstrumentComplete() );
        rewardRecordListOutputDTO.setThreeDaysSendCorrection( rewardRecord.getThreeDaysSendCorrection() );
        rewardRecordListOutputDTO.setSendDuplicate( rewardRecord.getSendDuplicate() );
        rewardRecordListOutputDTO.setAllDraftingInstrumentUpload( rewardRecord.getAllDraftingInstrumentUpload() );
        rewardRecordListOutputDTO.setDeliveryComplete( rewardRecord.getDeliveryComplete() );
        rewardRecordListOutputDTO.setSendDuplicateComplete( rewardRecord.getSendDuplicateComplete() );
        rewardRecordListOutputDTO.setProgress( rewardRecord.getProgress() );
        rewardRecordListOutputDTO.setApplyStatus( rewardRecord.getApplyStatus() );
        rewardRecordListOutputDTO.setApplyUser( rewardRecord.getApplyUser() );
        rewardRecordListOutputDTO.setApplyName( rewardRecord.getApplyName() );
        rewardRecordListOutputDTO.setApplyTime( rewardRecord.getApplyTime() );
        rewardRecordListOutputDTO.setRef( rewardRecord.getRef() );
        rewardRecordListOutputDTO.setProcessInstanceId( rewardRecord.getProcessInstanceId() );
        rewardRecordListOutputDTO.setNextRef( rewardRecord.getNextRef() );
        rewardRecordListOutputDTO.setNextProcessInstanceId( rewardRecord.getNextProcessInstanceId() );
        rewardRecordListOutputDTO.setOrgNum( rewardRecord.getOrgNum() );
        rewardRecordListOutputDTO.setCreateTime( rewardRecord.getCreateTime() );
        rewardRecordListOutputDTO.setUpdateTime( rewardRecord.getUpdateTime() );
        rewardRecordListOutputDTO.setCreator( rewardRecord.getCreator() );
        rewardRecordListOutputDTO.setUpdater( rewardRecord.getUpdater() );
        rewardRecordListOutputDTO.setDeleted( rewardRecord.getDeleted() );
        rewardRecordListOutputDTO.setIsBack( rewardRecord.getIsBack() );

        return rewardRecordListOutputDTO;
    }

    @Override
    public List<RewardRecordListOutputDTO> toList(List<RewardRecord> rewardRecords) {
        if ( rewardRecords == null ) {
            return null;
        }

        List<RewardRecordListOutputDTO> list = new ArrayList<RewardRecordListOutputDTO>( rewardRecords.size() );
        for ( RewardRecord rewardRecord : rewardRecords ) {
            list.add( toList( rewardRecord ) );
        }

        return list;
    }
}
