package com.correction.backend.modules.survey.convert;

import com.correction.backend.modules.survey.controller.dto.SurveyDocumentsFilesCreateInputDTO;
import com.correction.backend.modules.survey.controller.dto.SurveyDocumentsFilesListOutputDTO;
import com.correction.backend.modules.survey.controller.dto.SurveyDocumentsFilesSearchInputDTO;
import com.correction.backend.modules.survey.controller.dto.SurveyDocumentsFilesUpdateInputDTO;
import com.correction.backend.modules.survey.entity.SurveyDocumentsFiles;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-19T02:18:58+0800",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 1.8.0_211 (Oracle Corporation)"
)
public class MSurveyDocumentsFilesConvertImpl implements MSurveyDocumentsFilesConvert {

    @Override
    public SurveyDocumentsFiles toSurveyDocumentsFiles(SurveyDocumentsFilesSearchInputDTO surveyDocumentsFilesSearchInputDTO) {
        if ( surveyDocumentsFilesSearchInputDTO == null ) {
            return null;
        }

        SurveyDocumentsFiles surveyDocumentsFiles = new SurveyDocumentsFiles();

        surveyDocumentsFiles.setCreateTime( surveyDocumentsFilesSearchInputDTO.getCreateTime() );
        surveyDocumentsFiles.setUpdateTime( surveyDocumentsFilesSearchInputDTO.getUpdateTime() );
        surveyDocumentsFiles.setCreator( surveyDocumentsFilesSearchInputDTO.getCreator() );
        surveyDocumentsFiles.setUpdater( surveyDocumentsFilesSearchInputDTO.getUpdater() );
        surveyDocumentsFiles.setDeleted( surveyDocumentsFilesSearchInputDTO.getDeleted() );
        surveyDocumentsFiles.setDataId( surveyDocumentsFilesSearchInputDTO.getDataId() );
        surveyDocumentsFiles.setFileStatus( surveyDocumentsFilesSearchInputDTO.getFileStatus() );
        surveyDocumentsFiles.setFilePath( surveyDocumentsFilesSearchInputDTO.getFilePath() );
        surveyDocumentsFiles.setFileUrl( surveyDocumentsFilesSearchInputDTO.getFileUrl() );
        surveyDocumentsFiles.setFileName( surveyDocumentsFilesSearchInputDTO.getFileName() );
        surveyDocumentsFiles.setFileType( surveyDocumentsFilesSearchInputDTO.getFileType() );
        surveyDocumentsFiles.setDictType( surveyDocumentsFilesSearchInputDTO.getDictType() );
        surveyDocumentsFiles.setDictValue( surveyDocumentsFilesSearchInputDTO.getDictValue() );

        return surveyDocumentsFiles;
    }

    @Override
    public SurveyDocumentsFiles toSurveyDocumentsFiles(SurveyDocumentsFilesCreateInputDTO surveyDocumentsFilesCreateInputDTO) {
        if ( surveyDocumentsFilesCreateInputDTO == null ) {
            return null;
        }

        SurveyDocumentsFiles surveyDocumentsFiles = new SurveyDocumentsFiles();

        surveyDocumentsFiles.setCreateTime( surveyDocumentsFilesCreateInputDTO.getCreateTime() );
        surveyDocumentsFiles.setUpdateTime( surveyDocumentsFilesCreateInputDTO.getUpdateTime() );
        surveyDocumentsFiles.setCreator( surveyDocumentsFilesCreateInputDTO.getCreator() );
        surveyDocumentsFiles.setUpdater( surveyDocumentsFilesCreateInputDTO.getUpdater() );
        surveyDocumentsFiles.setDeleted( surveyDocumentsFilesCreateInputDTO.getDeleted() );
        surveyDocumentsFiles.setDataId( surveyDocumentsFilesCreateInputDTO.getDataId() );
        surveyDocumentsFiles.setFileStatus( surveyDocumentsFilesCreateInputDTO.getFileStatus() );
        surveyDocumentsFiles.setFilePath( surveyDocumentsFilesCreateInputDTO.getFilePath() );
        surveyDocumentsFiles.setFileUrl( surveyDocumentsFilesCreateInputDTO.getFileUrl() );
        surveyDocumentsFiles.setFileName( surveyDocumentsFilesCreateInputDTO.getFileName() );
        surveyDocumentsFiles.setFileType( surveyDocumentsFilesCreateInputDTO.getFileType() );
        surveyDocumentsFiles.setDictType( surveyDocumentsFilesCreateInputDTO.getDictType() );
        surveyDocumentsFiles.setDictValue( surveyDocumentsFilesCreateInputDTO.getDictValue() );

        return surveyDocumentsFiles;
    }

    @Override
    public SurveyDocumentsFiles toSurveyDocumentsFiles(SurveyDocumentsFilesUpdateInputDTO surveyDocumentsFilesUpdateInputDTO) {
        if ( surveyDocumentsFilesUpdateInputDTO == null ) {
            return null;
        }

        SurveyDocumentsFiles surveyDocumentsFiles = new SurveyDocumentsFiles();

        surveyDocumentsFiles.setCreateTime( surveyDocumentsFilesUpdateInputDTO.getCreateTime() );
        surveyDocumentsFiles.setUpdateTime( surveyDocumentsFilesUpdateInputDTO.getUpdateTime() );
        surveyDocumentsFiles.setCreator( surveyDocumentsFilesUpdateInputDTO.getCreator() );
        surveyDocumentsFiles.setUpdater( surveyDocumentsFilesUpdateInputDTO.getUpdater() );
        surveyDocumentsFiles.setDeleted( surveyDocumentsFilesUpdateInputDTO.getDeleted() );
        surveyDocumentsFiles.setId( surveyDocumentsFilesUpdateInputDTO.getId() );
        surveyDocumentsFiles.setDataId( surveyDocumentsFilesUpdateInputDTO.getDataId() );
        surveyDocumentsFiles.setFileStatus( surveyDocumentsFilesUpdateInputDTO.getFileStatus() );
        surveyDocumentsFiles.setFilePath( surveyDocumentsFilesUpdateInputDTO.getFilePath() );
        surveyDocumentsFiles.setFileUrl( surveyDocumentsFilesUpdateInputDTO.getFileUrl() );
        surveyDocumentsFiles.setFileName( surveyDocumentsFilesUpdateInputDTO.getFileName() );
        surveyDocumentsFiles.setFileType( surveyDocumentsFilesUpdateInputDTO.getFileType() );
        surveyDocumentsFiles.setDictType( surveyDocumentsFilesUpdateInputDTO.getDictType() );
        surveyDocumentsFiles.setDictValue( surveyDocumentsFilesUpdateInputDTO.getDictValue() );

        return surveyDocumentsFiles;
    }

    @Override
    public SurveyDocumentsFilesListOutputDTO toList(SurveyDocumentsFiles surveyDocumentsFiles) {
        if ( surveyDocumentsFiles == null ) {
            return null;
        }

        SurveyDocumentsFilesListOutputDTO surveyDocumentsFilesListOutputDTO = new SurveyDocumentsFilesListOutputDTO();

        surveyDocumentsFilesListOutputDTO.setId( surveyDocumentsFiles.getId() );
        surveyDocumentsFilesListOutputDTO.setDataId( surveyDocumentsFiles.getDataId() );
        surveyDocumentsFilesListOutputDTO.setFileStatus( surveyDocumentsFiles.getFileStatus() );
        surveyDocumentsFilesListOutputDTO.setFilePath( surveyDocumentsFiles.getFilePath() );
        surveyDocumentsFilesListOutputDTO.setFileUrl( surveyDocumentsFiles.getFileUrl() );
        surveyDocumentsFilesListOutputDTO.setFileName( surveyDocumentsFiles.getFileName() );
        surveyDocumentsFilesListOutputDTO.setFileType( surveyDocumentsFiles.getFileType() );
        surveyDocumentsFilesListOutputDTO.setDictType( surveyDocumentsFiles.getDictType() );
        surveyDocumentsFilesListOutputDTO.setDictValue( surveyDocumentsFiles.getDictValue() );
        surveyDocumentsFilesListOutputDTO.setCreateTime( surveyDocumentsFiles.getCreateTime() );
        surveyDocumentsFilesListOutputDTO.setUpdateTime( surveyDocumentsFiles.getUpdateTime() );
        surveyDocumentsFilesListOutputDTO.setCreator( surveyDocumentsFiles.getCreator() );
        surveyDocumentsFilesListOutputDTO.setUpdater( surveyDocumentsFiles.getUpdater() );
        surveyDocumentsFilesListOutputDTO.setDeleted( surveyDocumentsFiles.getDeleted() );

        return surveyDocumentsFilesListOutputDTO;
    }

    @Override
    public List<SurveyDocumentsFilesListOutputDTO> toList(List<SurveyDocumentsFiles> surveyDocumentsFiless) {
        if ( surveyDocumentsFiless == null ) {
            return null;
        }

        List<SurveyDocumentsFilesListOutputDTO> list = new ArrayList<SurveyDocumentsFilesListOutputDTO>( surveyDocumentsFiless.size() );
        for ( SurveyDocumentsFiles surveyDocumentsFiles : surveyDocumentsFiless ) {
            list.add( toList( surveyDocumentsFiles ) );
        }

        return list;
    }
}
