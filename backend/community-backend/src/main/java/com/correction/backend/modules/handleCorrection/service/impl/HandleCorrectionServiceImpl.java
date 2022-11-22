package com.correction.backend.modules.handleCorrection.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.correction.backend.modules.handleCorrection.controller.dto.*;
import com.correction.backend.modules.handleCorrection.convert.MHandleCorrectionConvert;
import com.correction.backend.modules.handleCorrection.service.HandleCorrectionService;
import com.correction.backend.modules.handleCorrection.entity.HandleCorrection;
import com.correction.backend.modules.handleCorrection.mapper.HandleCorrectionMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.correction.backend.modules.survey.constant.SurveyConstant;
import com.correction.backend.modules.survey.controller.dto.SurveyDocumentsFilesDTO;
import com.correction.backend.modules.survey.controller.dto.SurveyDocumentsFilesQuery;
import com.correction.backend.modules.survey.controller.dto.SurveyEvaluationFilesDTO;
import com.correction.backend.modules.survey.controller.dto.SurveyEvaluationListDTO;
import com.correction.backend.modules.survey.convert.MSurveyEvaluationConvert;
import com.correction.backend.modules.survey.entity.SurveyEvaluation;
import com.correction.backend.modules.survey.service.SurveyDocumentsFilesService;
import com.correction.framework.common.pojo.PageResult;
import com.correction.framework.web.web.core.util.WebFrameworkUtils;
import com.correction.frameworks.mybatis.mybatis.core.util.MyBatisUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 办理入矫表 服务实现类
 * </p>
 *
 * @author yao
 * @since 2022-11-21
 */
@Service
public class HandleCorrectionServiceImpl extends ServiceImpl<HandleCorrectionMapper, HandleCorrection> implements HandleCorrectionService {

    @Resource
    SurveyDocumentsFilesService surveyDocumentsFilesService;


    @Override
    public HandleCorrection createHandleCorrection(HandleCorrectionCreateInputDTO correctionCreateInputDTO) {
        //校验：
        HandleCorrection handleCorrection = MHandleCorrectionConvert.INSTANCE.toHandleCorrection(correctionCreateInputDTO);
        handleCorrection.setApplyStatus(SurveyConstant.FLOW_STATUS_0);
        handleCorrection.setProgress(SurveyConstant.PROGRESS_1);
        handleCorrection.setOrgNum(WebFrameworkUtils.getLoginOrgNum());
        handleCorrection.setRef(String.valueOf(System.currentTimeMillis()));
        baseMapper.insert(handleCorrection);
        return handleCorrection;
    }

    @Override
    public HandleCorrection updateHandleCorrection(HandleCorrectionUpdateInputDTO correctionUpdateInputDTO) {
        HandleCorrection handleCorrection = MHandleCorrectionConvert.INSTANCE.toHandleCorrection(correctionUpdateInputDTO);
        baseMapper.updateById(handleCorrection);
        return handleCorrection;
    }

    @Override
    public void delete(Long id) {
        int i = baseMapper.deleteById(id);
    }

    @Override
    public HandleCorrectionFilesDTO getDetail(Long id) {
        HandleCorrection handleCorrection = baseMapper.selectById(id);
        //文书补充
        List<SurveyDocumentsFilesDTO> DICT_TYPE_docSupplement = surveyDocumentsFilesService.getSurveyDocumentList(SurveyDocumentsFilesQuery.builder().dictType(SurveyConstant.DICT_TYPE_docSupplement).dataId(id).build());
        //人员报到
        List<SurveyDocumentsFilesDTO> DICT_TYPE_userReports = surveyDocumentsFilesService.getSurveyDocumentList(SurveyDocumentsFilesQuery.builder().dictType(SurveyConstant.DICT_TYPE_userReports).dataId(id).build());
        //信息采集
        List<SurveyDocumentsFilesDTO> DICT_TYPE_informationCollection = surveyDocumentsFilesService.getSurveyDocumentList(SurveyDocumentsFilesQuery.builder().dictType(SurveyConstant.DICT_TYPE_informationCollection).dataId(id).build());
        //报备手续材料
        List<SurveyDocumentsFilesDTO> DICT_TYPE_reporting = surveyDocumentsFilesService.getSurveyDocumentList(SurveyDocumentsFilesQuery.builder().dictType(SurveyConstant.DICT_TYPE_reporting).dataId(id).build());
        //告知书
        List<SurveyDocumentsFilesDTO> DICT_TYPE_letterNotice = surveyDocumentsFilesService.getSurveyDocumentList(SurveyDocumentsFilesQuery.builder().dictType(SurveyConstant.DICT_TYPE_letterNotice).dataId(id).build());
        //报备手续材料
        List<SurveyDocumentsFilesDTO> DICT_TYPE_materials = surveyDocumentsFilesService.getSurveyDocumentList(SurveyDocumentsFilesQuery.builder().dictType(SurveyConstant.DICT_TYPE_materials).dataId(id).build());
        HandleCorrectionFilesDTO handleCorrectionFilesDTO = new HandleCorrectionFilesDTO();
        handleCorrectionFilesDTO.setDetail(MHandleCorrectionConvert.INSTANCE.toList(handleCorrection));
        handleCorrectionFilesDTO.setDocSupplementFiles(DICT_TYPE_docSupplement);
        handleCorrectionFilesDTO.setUserReportsFiles(DICT_TYPE_userReports);
        handleCorrectionFilesDTO.setInformationCollectionFiles(DICT_TYPE_informationCollection);
        handleCorrectionFilesDTO.setReportingFiles(DICT_TYPE_reporting);
        handleCorrectionFilesDTO.setLetterNoticeFiles(DICT_TYPE_letterNotice);
        handleCorrectionFilesDTO.setMaterialsFiles(DICT_TYPE_materials);
        return handleCorrectionFilesDTO;
    }

    @Override
    public List<HandleCorrection> getList(HandleCorrectionSearchInputDTO handleCorrection) {
        //获取集合
        LambdaQueryWrapper<HandleCorrection> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.like(StrUtil.isNotBlank(handleCorrection.getEntrustUnit()), HandleCorrection::getEntrustUnit, handleCorrection.getEntrustUnit());
        queryWrapper.like(StrUtil.isNotBlank(handleCorrection.getName()), HandleCorrection::getName, handleCorrection.getName());
        queryWrapper.like(StrUtil.isNotBlank(handleCorrection.getEntrustDate()), HandleCorrection::getEntrustDate, handleCorrection.getEntrustDate());
        queryWrapper.like(StrUtil.isNotBlank(handleCorrection.getReceptionDate()), HandleCorrection::getReceptionDate, handleCorrection.getReceptionDate());
        queryWrapper.like(StrUtil.isNotBlank(handleCorrection.getFactSheet()), HandleCorrection::getFactSheet, handleCorrection.getFactSheet());
        queryWrapper.like(StrUtil.isNotBlank(handleCorrection.getReportsRemark()), HandleCorrection::getReportsRemark, handleCorrection.getReportsRemark());
        queryWrapper.like(StrUtil.isNotBlank(handleCorrection.getCheckSysRemark()), HandleCorrection::getCheckSysRemark, handleCorrection.getCheckSysRemark());
        queryWrapper.like(handleCorrection.getApplyUser() !=null, HandleCorrection::getApplyUser, handleCorrection.getApplyUser());
        queryWrapper.like(StrUtil.isNotBlank(handleCorrection.getApplyName()), HandleCorrection::getApplyName, handleCorrection.getApplyName());
        queryWrapper.like(StrUtil.isNotBlank(handleCorrection.getApplyTime()), HandleCorrection::getApplyTime, handleCorrection.getApplyTime());
        queryWrapper.like(StrUtil.isNotBlank(handleCorrection.getOrgNum()), HandleCorrection::getOrgNum, handleCorrection.getOrgNum());
        queryWrapper.like(StrUtil.isNotBlank(handleCorrection.getCreator()), HandleCorrection::getCreator, handleCorrection.getCreator());
        queryWrapper.like(StrUtil.isNotBlank(handleCorrection.getUpdater()), HandleCorrection::getUpdater, handleCorrection.getUpdater());
        return baseMapper.selectList(queryWrapper);
    }

    @Override
    public IPage<HandleCorrectionListDTO> getPageList(HandleCorrectionSearchInputDTO searchInputDTO) {
        IPage<HandleCorrectionListDTO> mpPage = MyBatisUtils.buildPage(searchInputDTO);
        mpPage = baseMapper.getPageListFlow(mpPage, searchInputDTO);
        return mpPage;
    }
}
