package com.correction.backend.modules.survey.convert;

import com.correction.backend.modules.survey.controller.dto.SurveyEvaluationCreateInputDTO;
import com.correction.backend.modules.survey.controller.dto.SurveyEvaluationListDTO;
import com.correction.backend.modules.survey.controller.dto.SurveyEvaluationListOutputDTO;
import com.correction.backend.modules.survey.controller.dto.SurveyEvaluationSearchInputDTO;
import com.correction.backend.modules.survey.controller.dto.SurveyEvaluationUpdateInputDTO;
import com.correction.backend.modules.survey.entity.SurveyEvaluation;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-03T15:42:13+0800",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 1.8.0_211 (Oracle Corporation)"
)
public class MSurveyEvaluationConvertImpl implements MSurveyEvaluationConvert {

    @Override
    public SurveyEvaluation toSurveyEvaluation(SurveyEvaluationSearchInputDTO surveyEvaluationSearchInputDTO) {
        if ( surveyEvaluationSearchInputDTO == null ) {
            return null;
        }

        SurveyEvaluation surveyEvaluation = new SurveyEvaluation();

        surveyEvaluation.setCreateTime( surveyEvaluationSearchInputDTO.getCreateTime() );
        surveyEvaluation.setUpdateTime( surveyEvaluationSearchInputDTO.getUpdateTime() );
        surveyEvaluation.setCreator( surveyEvaluationSearchInputDTO.getCreator() );
        surveyEvaluation.setUpdater( surveyEvaluationSearchInputDTO.getUpdater() );
        surveyEvaluation.setDeleted( surveyEvaluationSearchInputDTO.getDeleted() );
        surveyEvaluation.setEntrustType( surveyEvaluationSearchInputDTO.getEntrustType() );
        surveyEvaluation.setEntrustUnit( surveyEvaluationSearchInputDTO.getEntrustUnit() );
        surveyEvaluation.setAreaJurisdiction( surveyEvaluationSearchInputDTO.getAreaJurisdiction() );
        surveyEvaluation.setStreetJurisdiction( surveyEvaluationSearchInputDTO.getStreetJurisdiction() );
        surveyEvaluation.setEntrustDate( surveyEvaluationSearchInputDTO.getEntrustDate() );
        surveyEvaluation.setCauseAction( surveyEvaluationSearchInputDTO.getCauseAction() );
        surveyEvaluation.setSex( surveyEvaluationSearchInputDTO.getSex() );
        surveyEvaluation.setName( surveyEvaluationSearchInputDTO.getName() );
        surveyEvaluation.setBirthday( surveyEvaluationSearchInputDTO.getBirthday() );
        surveyEvaluation.setIdCard( surveyEvaluationSearchInputDTO.getIdCard() );
        surveyEvaluation.setHousehold( surveyEvaluationSearchInputDTO.getHousehold() );
        surveyEvaluation.setNativePlace( surveyEvaluationSearchInputDTO.getNativePlace() );
        surveyEvaluation.setMobile( surveyEvaluationSearchInputDTO.getMobile() );
        surveyEvaluation.setPlaceResidence( surveyEvaluationSearchInputDTO.getPlaceResidence() );
        surveyEvaluation.setMaritalStatus( surveyEvaluationSearchInputDTO.getMaritalStatus() );
        surveyEvaluation.setProfessional( surveyEvaluationSearchInputDTO.getProfessional() );
        surveyEvaluation.setEconomyState( surveyEvaluationSearchInputDTO.getEconomyState() );
        surveyEvaluation.setOrtherInfo( surveyEvaluationSearchInputDTO.getOrtherInfo() );
        surveyEvaluation.setEntrustLinkman( surveyEvaluationSearchInputDTO.getEntrustLinkman() );
        surveyEvaluation.setEntrustMobile( surveyEvaluationSearchInputDTO.getEntrustMobile() );
        surveyEvaluation.setIsNotice( surveyEvaluationSearchInputDTO.getIsNotice() );
        surveyEvaluation.setIsJurisdictionOffice( surveyEvaluationSearchInputDTO.getIsJurisdictionOffice() );
        surveyEvaluation.setJurisdictionOffice( surveyEvaluationSearchInputDTO.getJurisdictionOffice() );
        surveyEvaluation.setJurisdictionOfficeId( surveyEvaluationSearchInputDTO.getJurisdictionOfficeId() );
        surveyEvaluation.setJurisdictionUser( surveyEvaluationSearchInputDTO.getJurisdictionUser() );
        surveyEvaluation.setImplementStatus( surveyEvaluationSearchInputDTO.getImplementStatus() );
        surveyEvaluation.setImplementUserGroup( surveyEvaluationSearchInputDTO.getImplementUserGroup() );
        surveyEvaluation.setImplementType( surveyEvaluationSearchInputDTO.getImplementType() );
        surveyEvaluation.setImplementFileRecord( surveyEvaluationSearchInputDTO.getImplementFileRecord() );
        surveyEvaluation.setImplementFileBench( surveyEvaluationSearchInputDTO.getImplementFileBench() );
        surveyEvaluation.setImplementFileReport( surveyEvaluationSearchInputDTO.getImplementFileReport() );
        surveyEvaluation.setImplementUser( surveyEvaluationSearchInputDTO.getImplementUser() );
        surveyEvaluation.setAssessmentStatus( surveyEvaluationSearchInputDTO.getAssessmentStatus() );
        surveyEvaluation.setAssessmentMeeting( surveyEvaluationSearchInputDTO.getAssessmentMeeting() );
        surveyEvaluation.setAssessmentFileBench( surveyEvaluationSearchInputDTO.getAssessmentFileBench() );
        surveyEvaluation.setAssessmentFileOpinion( surveyEvaluationSearchInputDTO.getAssessmentFileOpinion() );
        surveyEvaluation.setAssessmentFileSurvey( surveyEvaluationSearchInputDTO.getAssessmentFileSurvey() );
        surveyEvaluation.setAssessmentLastOpinion( surveyEvaluationSearchInputDTO.getAssessmentLastOpinion() );
        surveyEvaluation.setAssessmentUser( surveyEvaluationSearchInputDTO.getAssessmentUser() );
        surveyEvaluation.setSurveySendStatus( surveyEvaluationSearchInputDTO.getSurveySendStatus() );
        surveyEvaluation.setSurveySendUser( surveyEvaluationSearchInputDTO.getSurveySendUser() );
        surveyEvaluation.setSurveyNoticeStatus( surveyEvaluationSearchInputDTO.getSurveyNoticeStatus() );
        surveyEvaluation.setSurveyNoticeUser( surveyEvaluationSearchInputDTO.getSurveyNoticeUser() );
        surveyEvaluation.setProgress( surveyEvaluationSearchInputDTO.getProgress() );
        surveyEvaluation.setApplyStatus( surveyEvaluationSearchInputDTO.getApplyStatus() );
        surveyEvaluation.setApplyUser( surveyEvaluationSearchInputDTO.getApplyUser() );
        surveyEvaluation.setApplyName( surveyEvaluationSearchInputDTO.getApplyName() );
        surveyEvaluation.setApplyTime( surveyEvaluationSearchInputDTO.getApplyTime() );
        surveyEvaluation.setOrgNum( surveyEvaluationSearchInputDTO.getOrgNum() );

        return surveyEvaluation;
    }

    @Override
    public SurveyEvaluation toSurveyEvaluation(SurveyEvaluationCreateInputDTO surveyEvaluationCreateInputDTO) {
        if ( surveyEvaluationCreateInputDTO == null ) {
            return null;
        }

        SurveyEvaluation surveyEvaluation = new SurveyEvaluation();

        surveyEvaluation.setCreateTime( surveyEvaluationCreateInputDTO.getCreateTime() );
        surveyEvaluation.setUpdateTime( surveyEvaluationCreateInputDTO.getUpdateTime() );
        surveyEvaluation.setCreator( surveyEvaluationCreateInputDTO.getCreator() );
        surveyEvaluation.setUpdater( surveyEvaluationCreateInputDTO.getUpdater() );
        surveyEvaluation.setDeleted( surveyEvaluationCreateInputDTO.getDeleted() );
        surveyEvaluation.setId( surveyEvaluationCreateInputDTO.getId() );
        surveyEvaluation.setEntrustType( surveyEvaluationCreateInputDTO.getEntrustType() );
        surveyEvaluation.setEntrustUnit( surveyEvaluationCreateInputDTO.getEntrustUnit() );
        surveyEvaluation.setAreaJurisdiction( surveyEvaluationCreateInputDTO.getAreaJurisdiction() );
        surveyEvaluation.setStreetJurisdiction( surveyEvaluationCreateInputDTO.getStreetJurisdiction() );
        surveyEvaluation.setEntrustDate( surveyEvaluationCreateInputDTO.getEntrustDate() );
        surveyEvaluation.setCauseAction( surveyEvaluationCreateInputDTO.getCauseAction() );
        surveyEvaluation.setSex( surveyEvaluationCreateInputDTO.getSex() );
        surveyEvaluation.setName( surveyEvaluationCreateInputDTO.getName() );
        surveyEvaluation.setBirthday( surveyEvaluationCreateInputDTO.getBirthday() );
        surveyEvaluation.setIdCard( surveyEvaluationCreateInputDTO.getIdCard() );
        surveyEvaluation.setHousehold( surveyEvaluationCreateInputDTO.getHousehold() );
        surveyEvaluation.setNativePlace( surveyEvaluationCreateInputDTO.getNativePlace() );
        surveyEvaluation.setMobile( surveyEvaluationCreateInputDTO.getMobile() );
        surveyEvaluation.setPlaceResidence( surveyEvaluationCreateInputDTO.getPlaceResidence() );
        surveyEvaluation.setMaritalStatus( surveyEvaluationCreateInputDTO.getMaritalStatus() );
        surveyEvaluation.setProfessional( surveyEvaluationCreateInputDTO.getProfessional() );
        surveyEvaluation.setEconomyState( surveyEvaluationCreateInputDTO.getEconomyState() );
        surveyEvaluation.setOrtherInfo( surveyEvaluationCreateInputDTO.getOrtherInfo() );
        surveyEvaluation.setEntrustLinkman( surveyEvaluationCreateInputDTO.getEntrustLinkman() );
        surveyEvaluation.setEntrustMobile( surveyEvaluationCreateInputDTO.getEntrustMobile() );
        surveyEvaluation.setIsNotice( surveyEvaluationCreateInputDTO.getIsNotice() );
        surveyEvaluation.setIsJurisdictionOffice( surveyEvaluationCreateInputDTO.getIsJurisdictionOffice() );
        surveyEvaluation.setJurisdictionUser( surveyEvaluationCreateInputDTO.getJurisdictionUser() );
        surveyEvaluation.setImplementStatus( surveyEvaluationCreateInputDTO.getImplementStatus() );
        surveyEvaluation.setImplementUserGroup( surveyEvaluationCreateInputDTO.getImplementUserGroup() );
        surveyEvaluation.setImplementType( surveyEvaluationCreateInputDTO.getImplementType() );
        surveyEvaluation.setImplementFileRecord( surveyEvaluationCreateInputDTO.getImplementFileRecord() );
        surveyEvaluation.setImplementFileBench( surveyEvaluationCreateInputDTO.getImplementFileBench() );
        surveyEvaluation.setImplementFileReport( surveyEvaluationCreateInputDTO.getImplementFileReport() );
        surveyEvaluation.setImplementUser( surveyEvaluationCreateInputDTO.getImplementUser() );
        surveyEvaluation.setAssessmentStatus( surveyEvaluationCreateInputDTO.getAssessmentStatus() );
        surveyEvaluation.setAssessmentMeeting( surveyEvaluationCreateInputDTO.getAssessmentMeeting() );
        surveyEvaluation.setAssessmentFileBench( surveyEvaluationCreateInputDTO.getAssessmentFileBench() );
        surveyEvaluation.setAssessmentFileOpinion( surveyEvaluationCreateInputDTO.getAssessmentFileOpinion() );
        surveyEvaluation.setAssessmentFileSurvey( surveyEvaluationCreateInputDTO.getAssessmentFileSurvey() );
        surveyEvaluation.setAssessmentLastOpinion( surveyEvaluationCreateInputDTO.getAssessmentLastOpinion() );
        surveyEvaluation.setAssessmentUser( surveyEvaluationCreateInputDTO.getAssessmentUser() );
        surveyEvaluation.setSurveySendStatus( surveyEvaluationCreateInputDTO.getSurveySendStatus() );
        surveyEvaluation.setSurveySendUser( surveyEvaluationCreateInputDTO.getSurveySendUser() );
        surveyEvaluation.setSurveyNoticeStatus( surveyEvaluationCreateInputDTO.getSurveyNoticeStatus() );
        surveyEvaluation.setSurveyNoticeUser( surveyEvaluationCreateInputDTO.getSurveyNoticeUser() );
        surveyEvaluation.setProgress( surveyEvaluationCreateInputDTO.getProgress() );
        surveyEvaluation.setApplyStatus( surveyEvaluationCreateInputDTO.getApplyStatus() );
        surveyEvaluation.setApplyUser( surveyEvaluationCreateInputDTO.getApplyUser() );
        surveyEvaluation.setApplyName( surveyEvaluationCreateInputDTO.getApplyName() );
        surveyEvaluation.setApplyTime( surveyEvaluationCreateInputDTO.getApplyTime() );
        surveyEvaluation.setOrgNum( surveyEvaluationCreateInputDTO.getOrgNum() );
        surveyEvaluation.setOpinion( surveyEvaluationCreateInputDTO.getOpinion() );
        surveyEvaluation.setReceptionDate( surveyEvaluationCreateInputDTO.getReceptionDate() );

        return surveyEvaluation;
    }

    @Override
    public SurveyEvaluation toSurveyEvaluation(SurveyEvaluationUpdateInputDTO surveyEvaluationUpdateInputDTO) {
        if ( surveyEvaluationUpdateInputDTO == null ) {
            return null;
        }

        SurveyEvaluation surveyEvaluation = new SurveyEvaluation();

        surveyEvaluation.setCreateTime( surveyEvaluationUpdateInputDTO.getCreateTime() );
        surveyEvaluation.setUpdateTime( surveyEvaluationUpdateInputDTO.getUpdateTime() );
        surveyEvaluation.setCreator( surveyEvaluationUpdateInputDTO.getCreator() );
        surveyEvaluation.setUpdater( surveyEvaluationUpdateInputDTO.getUpdater() );
        surveyEvaluation.setDeleted( surveyEvaluationUpdateInputDTO.getDeleted() );
        surveyEvaluation.setId( surveyEvaluationUpdateInputDTO.getId() );
        surveyEvaluation.setEntrustType( surveyEvaluationUpdateInputDTO.getEntrustType() );
        surveyEvaluation.setEntrustUnit( surveyEvaluationUpdateInputDTO.getEntrustUnit() );
        surveyEvaluation.setAreaJurisdiction( surveyEvaluationUpdateInputDTO.getAreaJurisdiction() );
        surveyEvaluation.setStreetJurisdiction( surveyEvaluationUpdateInputDTO.getStreetJurisdiction() );
        surveyEvaluation.setEntrustDate( surveyEvaluationUpdateInputDTO.getEntrustDate() );
        surveyEvaluation.setCauseAction( surveyEvaluationUpdateInputDTO.getCauseAction() );
        surveyEvaluation.setSex( surveyEvaluationUpdateInputDTO.getSex() );
        surveyEvaluation.setName( surveyEvaluationUpdateInputDTO.getName() );
        surveyEvaluation.setBirthday( surveyEvaluationUpdateInputDTO.getBirthday() );
        surveyEvaluation.setIdCard( surveyEvaluationUpdateInputDTO.getIdCard() );
        surveyEvaluation.setHousehold( surveyEvaluationUpdateInputDTO.getHousehold() );
        surveyEvaluation.setNativePlace( surveyEvaluationUpdateInputDTO.getNativePlace() );
        surveyEvaluation.setMobile( surveyEvaluationUpdateInputDTO.getMobile() );
        surveyEvaluation.setPlaceResidence( surveyEvaluationUpdateInputDTO.getPlaceResidence() );
        surveyEvaluation.setMaritalStatus( surveyEvaluationUpdateInputDTO.getMaritalStatus() );
        surveyEvaluation.setProfessional( surveyEvaluationUpdateInputDTO.getProfessional() );
        surveyEvaluation.setEconomyState( surveyEvaluationUpdateInputDTO.getEconomyState() );
        surveyEvaluation.setOrtherInfo( surveyEvaluationUpdateInputDTO.getOrtherInfo() );
        surveyEvaluation.setEntrustLinkman( surveyEvaluationUpdateInputDTO.getEntrustLinkman() );
        surveyEvaluation.setEntrustMobile( surveyEvaluationUpdateInputDTO.getEntrustMobile() );
        surveyEvaluation.setIsNotice( surveyEvaluationUpdateInputDTO.getIsNotice() );
        surveyEvaluation.setIsJurisdictionOffice( surveyEvaluationUpdateInputDTO.getIsJurisdictionOffice() );
        surveyEvaluation.setJurisdictionOffice( surveyEvaluationUpdateInputDTO.getJurisdictionOffice() );
        if ( surveyEvaluationUpdateInputDTO.getJurisdictionOfficeId() != null ) {
            surveyEvaluation.setJurisdictionOfficeId( Long.parseLong( surveyEvaluationUpdateInputDTO.getJurisdictionOfficeId() ) );
        }
        surveyEvaluation.setJurisdictionUser( surveyEvaluationUpdateInputDTO.getJurisdictionUser() );
        surveyEvaluation.setImplementStatus( surveyEvaluationUpdateInputDTO.getImplementStatus() );
        surveyEvaluation.setImplementUserGroup( surveyEvaluationUpdateInputDTO.getImplementUserGroup() );
        surveyEvaluation.setImplementType( surveyEvaluationUpdateInputDTO.getImplementType() );
        surveyEvaluation.setImplementFileRecord( surveyEvaluationUpdateInputDTO.getImplementFileRecord() );
        surveyEvaluation.setImplementFileBench( surveyEvaluationUpdateInputDTO.getImplementFileBench() );
        surveyEvaluation.setImplementFileReport( surveyEvaluationUpdateInputDTO.getImplementFileReport() );
        surveyEvaluation.setImplementUser( surveyEvaluationUpdateInputDTO.getImplementUser() );
        surveyEvaluation.setAssessmentStatus( surveyEvaluationUpdateInputDTO.getAssessmentStatus() );
        surveyEvaluation.setAssessmentMeeting( surveyEvaluationUpdateInputDTO.getAssessmentMeeting() );
        surveyEvaluation.setAssessmentFileBench( surveyEvaluationUpdateInputDTO.getAssessmentFileBench() );
        surveyEvaluation.setAssessmentFileOpinion( surveyEvaluationUpdateInputDTO.getAssessmentFileOpinion() );
        surveyEvaluation.setAssessmentFileSurvey( surveyEvaluationUpdateInputDTO.getAssessmentFileSurvey() );
        surveyEvaluation.setAssessmentLastOpinion( surveyEvaluationUpdateInputDTO.getAssessmentLastOpinion() );
        surveyEvaluation.setAssessmentUser( surveyEvaluationUpdateInputDTO.getAssessmentUser() );
        surveyEvaluation.setSurveySendStatus( surveyEvaluationUpdateInputDTO.getSurveySendStatus() );
        surveyEvaluation.setSurveySendUser( surveyEvaluationUpdateInputDTO.getSurveySendUser() );
        surveyEvaluation.setSurveyNoticeStatus( surveyEvaluationUpdateInputDTO.getSurveyNoticeStatus() );
        surveyEvaluation.setSurveyNoticeUser( surveyEvaluationUpdateInputDTO.getSurveyNoticeUser() );
        surveyEvaluation.setProgress( surveyEvaluationUpdateInputDTO.getProgress() );
        surveyEvaluation.setApplyStatus( surveyEvaluationUpdateInputDTO.getApplyStatus() );
        surveyEvaluation.setApplyUser( surveyEvaluationUpdateInputDTO.getApplyUser() );
        surveyEvaluation.setApplyName( surveyEvaluationUpdateInputDTO.getApplyName() );
        surveyEvaluation.setApplyTime( surveyEvaluationUpdateInputDTO.getApplyTime() );
        surveyEvaluation.setOrgNum( surveyEvaluationUpdateInputDTO.getOrgNum() );
        surveyEvaluation.setOpinion( surveyEvaluationUpdateInputDTO.getOpinion() );
        surveyEvaluation.setReceptionDate( surveyEvaluationUpdateInputDTO.getReceptionDate() );
        surveyEvaluation.setHandleCorrectionUserId( surveyEvaluationUpdateInputDTO.getHandleCorrectionUserId() );
        surveyEvaluation.setHandleCorrectionOrgId( surveyEvaluationUpdateInputDTO.getHandleCorrectionOrgId() );
        surveyEvaluation.setHandleCorrectionRoleId( surveyEvaluationUpdateInputDTO.getHandleCorrectionRoleId() );

        return surveyEvaluation;
    }

    @Override
    public SurveyEvaluationListOutputDTO toList(SurveyEvaluation surveyEvaluation) {
        if ( surveyEvaluation == null ) {
            return null;
        }

        SurveyEvaluationListOutputDTO surveyEvaluationListOutputDTO = new SurveyEvaluationListOutputDTO();

        surveyEvaluationListOutputDTO.setId( surveyEvaluation.getId() );
        surveyEvaluationListOutputDTO.setEntrustType( surveyEvaluation.getEntrustType() );
        surveyEvaluationListOutputDTO.setEntrustUnit( surveyEvaluation.getEntrustUnit() );
        surveyEvaluationListOutputDTO.setAreaJurisdiction( surveyEvaluation.getAreaJurisdiction() );
        surveyEvaluationListOutputDTO.setStreetJurisdiction( surveyEvaluation.getStreetJurisdiction() );
        surveyEvaluationListOutputDTO.setEntrustDate( surveyEvaluation.getEntrustDate() );
        surveyEvaluationListOutputDTO.setCauseAction( surveyEvaluation.getCauseAction() );
        surveyEvaluationListOutputDTO.setSex( surveyEvaluation.getSex() );
        surveyEvaluationListOutputDTO.setName( surveyEvaluation.getName() );
        surveyEvaluationListOutputDTO.setBirthday( surveyEvaluation.getBirthday() );
        surveyEvaluationListOutputDTO.setIdCard( surveyEvaluation.getIdCard() );
        surveyEvaluationListOutputDTO.setHousehold( surveyEvaluation.getHousehold() );
        surveyEvaluationListOutputDTO.setNativePlace( surveyEvaluation.getNativePlace() );
        surveyEvaluationListOutputDTO.setMobile( surveyEvaluation.getMobile() );
        surveyEvaluationListOutputDTO.setPlaceResidence( surveyEvaluation.getPlaceResidence() );
        surveyEvaluationListOutputDTO.setMaritalStatus( surveyEvaluation.getMaritalStatus() );
        surveyEvaluationListOutputDTO.setProfessional( surveyEvaluation.getProfessional() );
        surveyEvaluationListOutputDTO.setEconomyState( surveyEvaluation.getEconomyState() );
        surveyEvaluationListOutputDTO.setOrtherInfo( surveyEvaluation.getOrtherInfo() );
        surveyEvaluationListOutputDTO.setEntrustLinkman( surveyEvaluation.getEntrustLinkman() );
        surveyEvaluationListOutputDTO.setEntrustMobile( surveyEvaluation.getEntrustMobile() );
        surveyEvaluationListOutputDTO.setIsNotice( surveyEvaluation.getIsNotice() );
        surveyEvaluationListOutputDTO.setIsJurisdictionOffice( surveyEvaluation.getIsJurisdictionOffice() );
        surveyEvaluationListOutputDTO.setJurisdictionOffice( surveyEvaluation.getJurisdictionOffice() );
        surveyEvaluationListOutputDTO.setJurisdictionOfficeId( surveyEvaluation.getJurisdictionOfficeId() );
        surveyEvaluationListOutputDTO.setJurisdictionUser( surveyEvaluation.getJurisdictionUser() );
        surveyEvaluationListOutputDTO.setImplementStatus( surveyEvaluation.getImplementStatus() );
        surveyEvaluationListOutputDTO.setImplementUserGroup( surveyEvaluation.getImplementUserGroup() );
        surveyEvaluationListOutputDTO.setImplementType( surveyEvaluation.getImplementType() );
        surveyEvaluationListOutputDTO.setImplementFileRecord( surveyEvaluation.getImplementFileRecord() );
        surveyEvaluationListOutputDTO.setImplementFileBench( surveyEvaluation.getImplementFileBench() );
        surveyEvaluationListOutputDTO.setImplementFileReport( surveyEvaluation.getImplementFileReport() );
        surveyEvaluationListOutputDTO.setImplementUser( surveyEvaluation.getImplementUser() );
        surveyEvaluationListOutputDTO.setAssessmentStatus( surveyEvaluation.getAssessmentStatus() );
        surveyEvaluationListOutputDTO.setAssessmentMeeting( surveyEvaluation.getAssessmentMeeting() );
        surveyEvaluationListOutputDTO.setAssessmentFileBench( surveyEvaluation.getAssessmentFileBench() );
        surveyEvaluationListOutputDTO.setAssessmentFileOpinion( surveyEvaluation.getAssessmentFileOpinion() );
        surveyEvaluationListOutputDTO.setAssessmentFileSurvey( surveyEvaluation.getAssessmentFileSurvey() );
        surveyEvaluationListOutputDTO.setAssessmentLastOpinion( surveyEvaluation.getAssessmentLastOpinion() );
        surveyEvaluationListOutputDTO.setAssessmentUser( surveyEvaluation.getAssessmentUser() );
        surveyEvaluationListOutputDTO.setSurveySendStatus( surveyEvaluation.getSurveySendStatus() );
        surveyEvaluationListOutputDTO.setSurveySendUser( surveyEvaluation.getSurveySendUser() );
        surveyEvaluationListOutputDTO.setSurveyNoticeStatus( surveyEvaluation.getSurveyNoticeStatus() );
        surveyEvaluationListOutputDTO.setSurveyNoticeUser( surveyEvaluation.getSurveyNoticeUser() );
        surveyEvaluationListOutputDTO.setProgress( surveyEvaluation.getProgress() );
        surveyEvaluationListOutputDTO.setApplyStatus( surveyEvaluation.getApplyStatus() );
        surveyEvaluationListOutputDTO.setApplyUser( surveyEvaluation.getApplyUser() );
        surveyEvaluationListOutputDTO.setApplyName( surveyEvaluation.getApplyName() );
        surveyEvaluationListOutputDTO.setApplyTime( surveyEvaluation.getApplyTime() );
        surveyEvaluationListOutputDTO.setOrgNum( surveyEvaluation.getOrgNum() );
        surveyEvaluationListOutputDTO.setCreateTime( surveyEvaluation.getCreateTime() );
        surveyEvaluationListOutputDTO.setUpdateTime( surveyEvaluation.getUpdateTime() );
        surveyEvaluationListOutputDTO.setCreator( surveyEvaluation.getCreator() );
        surveyEvaluationListOutputDTO.setUpdater( surveyEvaluation.getUpdater() );
        surveyEvaluationListOutputDTO.setDeleted( surveyEvaluation.getDeleted() );
        surveyEvaluationListOutputDTO.setOpinion( surveyEvaluation.getOpinion() );
        surveyEvaluationListOutputDTO.setReceptionDate( surveyEvaluation.getReceptionDate() );
        surveyEvaluationListOutputDTO.setRef( surveyEvaluation.getRef() );
        surveyEvaluationListOutputDTO.setProcessInstanceId( surveyEvaluation.getProcessInstanceId() );
        surveyEvaluationListOutputDTO.setHandleCorrectionUserId( surveyEvaluation.getHandleCorrectionUserId() );
        surveyEvaluationListOutputDTO.setHandleCorrectionOrgId( surveyEvaluation.getHandleCorrectionOrgId() );
        surveyEvaluationListOutputDTO.setHandleCorrectionRoleId( surveyEvaluation.getHandleCorrectionRoleId() );

        return surveyEvaluationListOutputDTO;
    }

    @Override
    public SurveyEvaluationListDTO toEsyList(SurveyEvaluation surveyEvaluation) {
        if ( surveyEvaluation == null ) {
            return null;
        }

        SurveyEvaluationListDTO surveyEvaluationListDTO = new SurveyEvaluationListDTO();

        surveyEvaluationListDTO.setId( surveyEvaluation.getId() );
        surveyEvaluationListDTO.setEntrustType( surveyEvaluation.getEntrustType() );
        surveyEvaluationListDTO.setEntrustUnit( surveyEvaluation.getEntrustUnit() );
        surveyEvaluationListDTO.setAreaJurisdiction( surveyEvaluation.getAreaJurisdiction() );
        surveyEvaluationListDTO.setName( surveyEvaluation.getName() );
        surveyEvaluationListDTO.setEntrustDate( surveyEvaluation.getEntrustDate() );
        surveyEvaluationListDTO.setAssessmentLastOpinion( surveyEvaluation.getAssessmentLastOpinion() );
        surveyEvaluationListDTO.setReceptionDate( surveyEvaluation.getReceptionDate() );
        surveyEvaluationListDTO.setProgress( surveyEvaluation.getProgress() );
        surveyEvaluationListDTO.setApplyStatus( surveyEvaluation.getApplyStatus() );
        surveyEvaluationListDTO.setApplyUser( surveyEvaluation.getApplyUser() );
        surveyEvaluationListDTO.setJurisdictionOffice( surveyEvaluation.getJurisdictionOffice() );

        return surveyEvaluationListDTO;
    }

    @Override
    public List<SurveyEvaluationListOutputDTO> toList(List<SurveyEvaluation> surveyEvaluations) {
        if ( surveyEvaluations == null ) {
            return null;
        }

        List<SurveyEvaluationListOutputDTO> list = new ArrayList<SurveyEvaluationListOutputDTO>( surveyEvaluations.size() );
        for ( SurveyEvaluation surveyEvaluation : surveyEvaluations ) {
            list.add( toList( surveyEvaluation ) );
        }

        return list;
    }
}
