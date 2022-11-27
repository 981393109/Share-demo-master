package com.correction.backend.modules.survey.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.correction.backend.modules.survey.controller.dto.SurveyDocumentsFilesDTO;
import com.correction.backend.modules.survey.controller.dto.SurveyDocumentsFilesListQuery;
import com.correction.backend.modules.survey.controller.dto.SurveyDocumentsFilesQuery;
import com.correction.backend.modules.survey.entity.SurveyDocumentsFiles;
import com.correction.framework.common.pojo.PageResult;
import com.correction.frameworks.mybatis.mybatis.core.mapper.BaseMapperX;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
//import com.baomidou.mybatisplus.core.mapper.BaseMapperX;

/**
 * <p>
 * 文书附件上传 Mapper 接口
 * </p>
 *
 * @author yao
 * @since 2022-11-17
 */
@Mapper
public interface SurveyDocumentsFilesMapper extends BaseMapperX<SurveyDocumentsFiles> {

    IPage<SurveyDocumentsFilesDTO> getPageList (@Param("page") IPage page,@Param("query") SurveyDocumentsFilesQuery query);


    List<SurveyDocumentsFilesDTO> getList (@Param("query") SurveyDocumentsFilesQuery query);

    List<SurveyDocumentsFilesDTO> getListInfo (@Param("query") SurveyDocumentsFilesListQuery query);

    IPage<SurveyDocumentsFilesDTO> getAllFilePage (@Param("page")IPage page,@Param("query") SurveyDocumentsFilesQuery query );

}
