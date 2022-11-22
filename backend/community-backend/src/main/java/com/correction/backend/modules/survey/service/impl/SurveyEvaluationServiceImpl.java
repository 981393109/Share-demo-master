package com.correction.backend.modules.survey.service.impl;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.correction.backend.modules.survey.constant.SurveyConstant;
import com.correction.backend.modules.survey.controller.dto.*;
import com.correction.backend.modules.survey.convert.MSurveyEvaluationConvert;
import com.correction.backend.modules.survey.entity.SurveyEvaluation;
import com.correction.backend.modules.survey.mapper.SurveyEvaluationMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.correction.backend.modules.survey.service.SurveyDocumentsFilesService;
import com.correction.backend.modules.survey.service.SurveyEvaluationService;
import com.correction.backend.modules.sys.constant.SysConstant;
import com.correction.framework.common.pojo.PageResult;
import com.correction.framework.web.web.LoginUser;
import com.correction.framework.web.web.core.util.WebFrameworkUtils;
import com.correction.frameworks.mybatis.mybatis.core.util.MyBatisUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

import java.util.List;

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
    public SurveyEvaluation createSurveyEvaluation(SurveyEvaluationCreateInputDTO reqDTO) {
        this.checkCreateOrUpdate(null,reqDTO.getName(),reqDTO.getApplyStatus());
        SurveyEvaluation surveyEvaluation = MSurveyEvaluationConvert.INSTANCE.toSurveyEvaluation(reqDTO);
        LoginUser loginUser = WebFrameworkUtils.getLoginUser();
        surveyEvaluation.setApplyName(loginUser.getUsername());
        surveyEvaluation.setApplyUser(loginUser.getId());
        surveyEvaluation.setApplyStatus(SurveyConstant.FLOW_STATUS_0);
        surveyEvaluation.setProgress(SurveyConstant.PROGRESS_1);
        surveyEvaluation.setOrgNum(WebFrameworkUtils.getLoginOrgNum());
        surveyEvaluation.setRef(String.valueOf(System.currentTimeMillis()));
        baseMapper.insert(surveyEvaluation);
        return surveyEvaluation;
    }



    @Override
    public SurveyEvaluation updateSurveyEvaluation(SurveyEvaluationUpdateInputDTO reqDTO) {
        this.checkCreateOrUpdate(reqDTO.getId(),reqDTO.getName(),reqDTO.getApplyStatus());
        SurveyEvaluation surveyEvaluation = MSurveyEvaluationConvert.INSTANCE.toSurveyEvaluation(reqDTO);
        //surveyEvaluation.setApplyStatus(SurveyConstant.FLOW_STATUS_0);
        baseMapper.updateById(surveyEvaluation);
        return surveyEvaluation;
    }

    @Override
    public SurveyEvaluationFilesDTO get(Long id) {
        SurveyEvaluation surveyEvaluation = baseMapper.selectById(id);
        //得到委托检查材料
        List<SurveyDocumentsFilesDTO> DICT_TYPE_SURVEY = surveyDocumentsFilesService.getSurveyDocumentList(SurveyDocumentsFilesQuery.builder().dictType(SurveyConstant.DICT_TYPE_SURVEY).dataId(id).build());
        List<SurveyDocumentsFilesDTO> DICT_TYPE_SURVEY_IMPLEMENT = surveyDocumentsFilesService.getSurveyDocumentList(SurveyDocumentsFilesQuery.builder().dictType(SurveyConstant.DICT_TYPE_SURVEY_IMPLEMENT).dataId(id).build());
        List<SurveyDocumentsFilesDTO> DICT_TYPE_SURVEY_ASSESSMENT = surveyDocumentsFilesService.getSurveyDocumentList(SurveyDocumentsFilesQuery.builder().dictType(SurveyConstant.DICT_TYPE_SURVEY_ASSESSMENT).dataId(id).build());
        SurveyEvaluationFilesDTO surveyEvaluationFilesDTO = new SurveyEvaluationFilesDTO();
        surveyEvaluationFilesDTO.setDetail(MSurveyEvaluationConvert.INSTANCE.toList(surveyEvaluation));
        surveyEvaluationFilesDTO.setImplement(DICT_TYPE_SURVEY_IMPLEMENT);
        surveyEvaluationFilesDTO.setMaterials(DICT_TYPE_SURVEY);
        surveyEvaluationFilesDTO.setAssessment(DICT_TYPE_SURVEY_ASSESSMENT);
        return surveyEvaluationFilesDTO;
    }


    @Override
    public void delete(Long id) {
        baseMapper.deleteById(id);
    }

    @Override
    public PageResult<SurveyEvaluation> getPageList(SurveyEvaluationSearchInputDTO searchInputDTO) {
        PageResult<SurveyEvaluation> surveyEvaluationPageResult = this.baseMapper.selectPage(searchInputDTO);
        return surveyEvaluationPageResult;
    }

    @Override
    public IPage<SurveyEvaluationListDTO> getPageListFlow(SurveyEvaluationSearchInputDTO reqVO) {
        IPage<SurveyEvaluationListDTO> mpPage = MyBatisUtils.buildPage(reqVO);
        mpPage = baseMapper.getPageListFlow(mpPage, reqVO);
        return mpPage;
    }


    /**
     * 校验
     * @param name
     */
    private void checkCreateOrUpdate(Long  id ,String name,Integer applitStatus) {
        //判断审核状态
        /*if(id != null && !SurveyConstant.FLOW_STATUS_0.equals(applitStatus)){
            throw exception(SURVEY_FLOW_STATUS_EDIT);
        }*/
    }

}
