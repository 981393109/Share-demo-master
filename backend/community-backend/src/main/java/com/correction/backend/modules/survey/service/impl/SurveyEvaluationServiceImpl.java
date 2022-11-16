package com.correction.backend.modules.survey.service.impl;


import com.correction.backend.modules.survey.constant.SurveyConstant;
import com.correction.backend.modules.survey.controller.dto.SurveyEvaluationCreateInputDTO;
import com.correction.backend.modules.survey.controller.dto.SurveyEvaluationSearchInputDTO;
import com.correction.backend.modules.survey.controller.dto.SurveyEvaluationUpdateInputDTO;
import com.correction.backend.modules.survey.convert.MSurveyEvaluationConvert;
import com.correction.backend.modules.survey.entity.SurveyEvaluation;
import com.correction.backend.modules.survey.mapper.SurveyEvaluationMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.correction.backend.modules.survey.service.SurveyDocumentsFilesService;
import com.correction.backend.modules.survey.service.SurveyEvaluationService;
import com.correction.backend.modules.sys.constant.SysConstant;
import com.correction.framework.common.pojo.PageResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

import static com.correction.backend.modules.sys.enums.SysErrorCodeConstants.SURVEY_FLOW_STATUS_EDIT;
import static com.correction.backend.modules.sys.enums.SysErrorCodeConstants.USER_USERNAME_EXISTS;
import static com.correction.framework.common.exception.util.ServiceExceptionUtil.exception;

/**
 * <p>
 * 调查评估记录 服务实现类
 * </p>
 *
 * @author yao
 * @since 2022-11-15
 */
@Service
@Slf4j
public class SurveyEvaluationServiceImpl extends ServiceImpl<SurveyEvaluationMapper, SurveyEvaluation> implements SurveyEvaluationService {

    @Resource
    private SurveyDocumentsFilesService surveyDocumentsFilesService;


    @Override
    public Long createSurveyEvaluation(SurveyEvaluationCreateInputDTO reqDTO) {
        this.checkCreateOrUpdate(null,reqDTO.getName(),reqDTO.getApplyStatus());
        SurveyEvaluation surveyEvaluation = MSurveyEvaluationConvert.INSTANCE.toSurveyEvaluation(reqDTO);
        surveyEvaluation.setApplyStatus(SurveyConstant.FLOW_STATUS_0);
        baseMapper.insert(surveyEvaluation);
        //初始化文书附件记录：
        surveyDocumentsFilesService.initSurveyDocumentFile(surveyEvaluation.getId(), SysConstant.DICT_SURVEY,SurveyConstant.DOC_SUBJECT_SURVEY);
        return surveyEvaluation.getId();
    }



    @Override
    public SurveyEvaluation updateSurveyEvaluation(SurveyEvaluationUpdateInputDTO reqDTO) {
        this.checkCreateOrUpdate(reqDTO.getId(),reqDTO.getName(),reqDTO.getApplyStatus());
        SurveyEvaluation surveyEvaluation = MSurveyEvaluationConvert.INSTANCE.toSurveyEvaluation(reqDTO);
        surveyEvaluation.setApplyStatus(SurveyConstant.FLOW_STATUS_0);
        baseMapper.updateById(surveyEvaluation);
        return surveyEvaluation;
    }

    @Override
    public SurveyEvaluation get(Long id) {
        SurveyEvaluation surveyEvaluation = baseMapper.selectById(id);
        return surveyEvaluation;
    }


    @Override
    public void delete(Long id) {
        int delete = baseMapper.deleteById(id);
        //删除文书记录
        surveyDocumentsFilesService.deleteByDataId(id);
    }

    @Override
    public PageResult<SurveyEvaluation> getPageList(SurveyEvaluationSearchInputDTO searchInputDTO) {
        PageResult<SurveyEvaluation> surveyEvaluationPageResult = this.baseMapper.selectPage(searchInputDTO);
        return surveyEvaluationPageResult;
    }


    /**
     * 校验
     * @param name
     */
    private void checkCreateOrUpdate(Long  id ,String name,Integer applitStatus) {
        //判断审核状态
        if(id != null && !SurveyConstant.FLOW_STATUS_0.equals(applitStatus)){
            throw exception(SURVEY_FLOW_STATUS_EDIT);
        }
    }

}
