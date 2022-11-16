package com.correction.backend.modules.survey.convert;

import com.correction.backend.modules.survey.controller.dto.SurveyEvaluationCreateInputDTO;
import com.correction.backend.modules.survey.controller.dto.SurveyEvaluationListOutputDTO;
import com.correction.backend.modules.survey.controller.dto.SurveyEvaluationSearchInputDTO;
import com.correction.backend.modules.survey.controller.dto.SurveyEvaluationUpdateInputDTO;
import com.correction.backend.modules.survey.entity.SurveyEvaluation;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-15T21:33:24+0800",
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
        surveyEvaluation.setSex( surveyEvaluationSearchInputDTO.getSex() );
        surveyEvaluation.setName( surveyEvaluationSearchInputDTO.getName() );
        surveyEvaluation.setBirthday( surveyEvaluationSearchInputDTO.getBirthday() );
        surveyEvaluation.setIdCard( surveyEvaluationSearchInputDTO.getIdCard() );
        surveyEvaluation.setAreaJurisdiction( surveyEvaluationSearchInputDTO.getAreaJurisdiction() );
        surveyEvaluation.setEntrustDate( surveyEvaluationSearchInputDTO.getEntrustDate() );
        surveyEvaluation.setMechanismExecution( surveyEvaluationSearchInputDTO.getMechanismExecution() );
        surveyEvaluation.setOpinion( surveyEvaluationSearchInputDTO.getOpinion() );
        surveyEvaluation.setReceptionDate( surveyEvaluationSearchInputDTO.getReceptionDate() );
        surveyEvaluation.setJurisdictionOffice( surveyEvaluationSearchInputDTO.getJurisdictionOffice() );
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
        surveyEvaluation.setProgress( surveyEvaluationSearchInputDTO.getProgress() );
        surveyEvaluation.setApplyStatus( surveyEvaluationSearchInputDTO.getApplyStatus() );
        surveyEvaluation.setApplyUser( surveyEvaluationSearchInputDTO.getApplyUser() );
        surveyEvaluation.setApplyName( surveyEvaluationSearchInputDTO.getApplyName() );
        surveyEvaluation.setApplyTime( surveyEvaluationSearchInputDTO.getApplyTime() );

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
        surveyEvaluation.setEntrustType( surveyEvaluationCreateInputDTO.getEntrustType() );
        surveyEvaluation.setEntrustUnit( surveyEvaluationCreateInputDTO.getEntrustUnit() );
        surveyEvaluation.setSex( surveyEvaluationCreateInputDTO.getSex() );
        surveyEvaluation.setName( surveyEvaluationCreateInputDTO.getName() );
        surveyEvaluation.setBirthday( surveyEvaluationCreateInputDTO.getBirthday() );
        surveyEvaluation.setIdCard( surveyEvaluationCreateInputDTO.getIdCard() );
        surveyEvaluation.setAreaJurisdiction( surveyEvaluationCreateInputDTO.getAreaJurisdiction() );
        surveyEvaluation.setEntrustDate( surveyEvaluationCreateInputDTO.getEntrustDate() );
        surveyEvaluation.setMechanismExecution( surveyEvaluationCreateInputDTO.getMechanismExecution() );
        surveyEvaluation.setOpinion( surveyEvaluationCreateInputDTO.getOpinion() );
        surveyEvaluation.setReceptionDate( surveyEvaluationCreateInputDTO.getReceptionDate() );
        surveyEvaluation.setJurisdictionOffice( surveyEvaluationCreateInputDTO.getJurisdictionOffice() );
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
        surveyEvaluation.setProgress( surveyEvaluationCreateInputDTO.getProgress() );
        surveyEvaluation.setApplyStatus( surveyEvaluationCreateInputDTO.getApplyStatus() );
        surveyEvaluation.setApplyUser( surveyEvaluationCreateInputDTO.getApplyUser() );
        surveyEvaluation.setApplyName( surveyEvaluationCreateInputDTO.getApplyName() );
        surveyEvaluation.setApplyTime( surveyEvaluationCreateInputDTO.getApplyTime() );

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
        surveyEvaluation.setSex( surveyEvaluationUpdateInputDTO.getSex() );
        surveyEvaluation.setName( surveyEvaluationUpdateInputDTO.getName() );
        surveyEvaluation.setBirthday( surveyEvaluationUpdateInputDTO.getBirthday() );
        surveyEvaluation.setIdCard( surveyEvaluationUpdateInputDTO.getIdCard() );
        surveyEvaluation.setAreaJurisdiction( surveyEvaluationUpdateInputDTO.getAreaJurisdiction() );
        surveyEvaluation.setEntrustDate( surveyEvaluationUpdateInputDTO.getEntrustDate() );
        surveyEvaluation.setMechanismExecution( surveyEvaluationUpdateInputDTO.getMechanismExecution() );
        surveyEvaluation.setOpinion( surveyEvaluationUpdateInputDTO.getOpinion() );
        surveyEvaluation.setReceptionDate( surveyEvaluationUpdateInputDTO.getReceptionDate() );
        surveyEvaluation.setJurisdictionOffice( surveyEvaluationUpdateInputDTO.getJurisdictionOffice() );
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
        surveyEvaluation.setProgress( surveyEvaluationUpdateInputDTO.getProgress() );
        surveyEvaluation.setApplyStatus( surveyEvaluationUpdateInputDTO.getApplyStatus() );
        surveyEvaluation.setApplyUser( surveyEvaluationUpdateInputDTO.getApplyUser() );
        surveyEvaluation.setApplyName( surveyEvaluationUpdateInputDTO.getApplyName() );
        surveyEvaluation.setApplyTime( surveyEvaluationUpdateInputDTO.getApplyTime() );

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
        surveyEvaluationListOutputDTO.setSex( surveyEvaluation.getSex() );
        surveyEvaluationListOutputDTO.setName( surveyEvaluation.getName() );
        surveyEvaluationListOutputDTO.setBirthday( surveyEvaluation.getBirthday() );
        surveyEvaluationListOutputDTO.setIdCard( surveyEvaluation.getIdCard() );
        surveyEvaluationListOutputDTO.setAreaJurisdiction( surveyEvaluation.getAreaJurisdiction() );
        surveyEvaluationListOutputDTO.setEntrustDate( surveyEvaluation.getEntrustDate() );
        surveyEvaluationListOutputDTO.setMechanismExecution( surveyEvaluation.getMechanismExecution() );
        surveyEvaluationListOutputDTO.setOpinion( surveyEvaluation.getOpinion() );
        surveyEvaluationListOutputDTO.setReceptionDate( surveyEvaluation.getReceptionDate() );
        surveyEvaluationListOutputDTO.setJurisdictionOffice( surveyEvaluation.getJurisdictionOffice() );
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
        surveyEvaluationListOutputDTO.setProgress( surveyEvaluation.getProgress() );
        surveyEvaluationListOutputDTO.setApplyStatus( surveyEvaluation.getApplyStatus() );
        surveyEvaluationListOutputDTO.setApplyUser( surveyEvaluation.getApplyUser() );
        surveyEvaluationListOutputDTO.setApplyName( surveyEvaluation.getApplyName() );
        surveyEvaluationListOutputDTO.setApplyTime( surveyEvaluation.getApplyTime() );
        surveyEvaluationListOutputDTO.setCreateTime( surveyEvaluation.getCreateTime() );
        surveyEvaluationListOutputDTO.setUpdateTime( surveyEvaluation.getUpdateTime() );
        surveyEvaluationListOutputDTO.setCreator( surveyEvaluation.getCreator() );
        surveyEvaluationListOutputDTO.setUpdater( surveyEvaluation.getUpdater() );
        surveyEvaluationListOutputDTO.setDeleted( surveyEvaluation.getDeleted() );

        return surveyEvaluationListOutputDTO;
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
