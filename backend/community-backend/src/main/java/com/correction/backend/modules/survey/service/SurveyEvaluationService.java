package com.correction.backend.modules.survey.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.correction.backend.modules.survey.controller.dto.*;
import com.correction.backend.modules.survey.entity.SurveyEvaluation;
import com.baomidou.mybatisplus.extension.service.IService;
import com.correction.framework.common.pojo.PageResult;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 * 调查评估记录 服务类
 * </p>
 *
 * @author yao
 * @since 2022-11-15
 */
public interface SurveyEvaluationService extends IService<SurveyEvaluation> {


    /**
     * 新增调查评估
     */
    SurveyEvaluation createSurveyEvaluation (SurveyEvaluationCreateInputDTO reqDTO);

    /**
     * 修改调查评估
     */
    SurveyEvaluation updateSurveyEvaluation (SurveyEvaluationUpdateInputDTO reqDTO);

    SurveyEvaluation updateSurveyEvaluation (SurveyEvaluation surveyEvaluation);

    /**
     * 获取详情
     */
    SurveyEvaluationFilesDTO get (Long id );


    /**
     * 删除调查评估记录
     */
    void delete (Long id);


    /**
     * 分页获取调查评估列表
     */
    PageResult<SurveyEvaluation> getPageList (SurveyEvaluationSearchInputDTO searchInputDTO);


    IPage<SurveyEvaluationListDTO> getPageListFlow(SurveyEvaluationSearchInputDTO reqVO);
}
