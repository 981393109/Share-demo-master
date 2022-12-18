package com.correction.backend.modules.education.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.correction.backend.modules.education.controller.dto.*;
import com.correction.backend.modules.education.convert.MEducationIdeologyConvert;
import com.correction.backend.modules.education.convert.MEducationIndividualConvert;
import com.correction.backend.modules.education.service.EducationIdeologyService;
import com.correction.backend.modules.education.entity.EducationIdeology;
import com.correction.backend.modules.education.mapper.EducationIdeologyMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.correction.backend.modules.survey.constant.SurveyConstant;
import com.correction.backend.modules.survey.controller.dto.SurveyDocumentsFilesDTO;
import com.correction.backend.modules.survey.controller.dto.SurveyDocumentsFilesQuery;
import com.correction.backend.modules.survey.entity.SurveyDocumentsFiles;
import com.correction.backend.modules.survey.service.SurveyDocumentsFilesService;
import com.correction.framework.common.pojo.PageResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 思想汇报 服务实现类
 * </p>
 *
 * @author yao
 * @since 2022-12-12
 */
@Service
public class EducationIdeologyServiceImpl extends ServiceImpl<EducationIdeologyMapper, EducationIdeology> implements EducationIdeologyService {

    @Resource
    private SurveyDocumentsFilesService surveyDocumentsFilesService;


    /**
     * 获取表格数据
     *
     * @param educationIdeology
     * @return
     */
    public PageResult<EducationIdeology> pageListByEntity(EducationIdeologySearchInputDTO educationIdeology) {
        LambdaQueryWrapper<EducationIdeology> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.like(StrUtil.isNotBlank(educationIdeology.getCorrectionUnit()), EducationIdeology::getCorrectionUnit, educationIdeology.getCorrectionUnit());
        queryWrapper.like(StrUtil.isNotBlank(educationIdeology.getUserName()), EducationIdeology::getUserName, educationIdeology.getUserName());
        queryWrapper.like(StrUtil.isNotBlank(educationIdeology.getReportDate()), EducationIdeology::getReportDate, educationIdeology.getReportDate());
        queryWrapper.like(StrUtil.isNotBlank(educationIdeology.getPerformanceInformation()), EducationIdeology::getPerformanceInformation, educationIdeology.getPerformanceInformation());
        queryWrapper.like(StrUtil.isNotBlank(educationIdeology.getBenchmarkScore()), EducationIdeology::getBenchmarkScore, educationIdeology.getBenchmarkScore());
        queryWrapper.like(StrUtil.isNotBlank(educationIdeology.getScore()), EducationIdeology::getScore, educationIdeology.getScore());
        queryWrapper.like(StrUtil.isNotBlank(educationIdeology.getCreator()), EducationIdeology::getCreator, educationIdeology.getCreator());
        queryWrapper.like(StrUtil.isNotBlank(educationIdeology.getUpdater()), EducationIdeology::getUpdater, educationIdeology.getUpdater());
        return baseMapper.selectPage(educationIdeology, queryWrapper);
    }


    @Override
    public void createEducationIdeology(EducationIdeologyCreateInputDTO createInputDTO) {
        EducationIdeology educationIdeology = MEducationIdeologyConvert.INSTANCE.toEducationIdeology(createInputDTO);
        List<SurveyDocumentsFiles> documentsFiles = createInputDTO.getDocumentsFiles();
        baseMapper.insert(educationIdeology);
        for (SurveyDocumentsFiles surveyDocumentsFile : documentsFiles) {
            surveyDocumentsFile.setDataId(educationIdeology.getId());
            surveyDocumentsFilesService.updateById(surveyDocumentsFile);
        }
    }

    @Override
    public void updateEducationIdeology(EducationIdeologyUpdateInputDTO updateInputDTO) {
        EducationIdeology educationIdeology = MEducationIdeologyConvert.INSTANCE.toEducationIdeology(updateInputDTO);
        baseMapper.updateById(educationIdeology);
    }

    @Override
    public EducationIdeologyFileDTO getDetail(Long id) {
        EducationIdeologyFileDTO dto = new EducationIdeologyFileDTO();
        EducationIdeology educationIdeology = baseMapper.selectById(id);
        List<SurveyDocumentsFilesDTO> DICT_TYPE_SURVEY = surveyDocumentsFilesService.getSurveyDocumentList(SurveyDocumentsFilesQuery.builder().dictType(501).dataId(id).build());
        //得到文书附件列表：
        dto.setDetail(MEducationIdeologyConvert.INSTANCE.toList(educationIdeology));
        dto.setMaterials(DICT_TYPE_SURVEY);
        return dto;
    }

    @Override
    public void delete(Long id) {
        baseMapper.deleteById(id);
    }

    @Override
    public List<EducationIdeology> getList(EducationIdeologyListOutputDTO educationIdeology) {
        LambdaQueryWrapper<EducationIdeology> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.like(StrUtil.isNotBlank(educationIdeology.getCorrectionUnit()), EducationIdeology::getCorrectionUnit, educationIdeology.getCorrectionUnit());
        queryWrapper.like(StrUtil.isNotBlank(educationIdeology.getUserName()), EducationIdeology::getUserName, educationIdeology.getUserName());
        queryWrapper.like(StrUtil.isNotBlank(educationIdeology.getReportDate()), EducationIdeology::getReportDate, educationIdeology.getReportDate());
        queryWrapper.like(StrUtil.isNotBlank(educationIdeology.getPerformanceInformation()), EducationIdeology::getPerformanceInformation, educationIdeology.getPerformanceInformation());
        queryWrapper.like(StrUtil.isNotBlank(educationIdeology.getBenchmarkScore()), EducationIdeology::getBenchmarkScore, educationIdeology.getBenchmarkScore());
        queryWrapper.like(StrUtil.isNotBlank(educationIdeology.getScore()), EducationIdeology::getScore, educationIdeology.getScore());
        queryWrapper.like(StrUtil.isNotBlank(educationIdeology.getCreator()), EducationIdeology::getCreator, educationIdeology.getCreator());
        queryWrapper.like(StrUtil.isNotBlank(educationIdeology.getUpdater()), EducationIdeology::getUpdater, educationIdeology.getUpdater());
        return baseMapper.selectList(queryWrapper);
    }

    @Override
    public PageResult<EducationIdeology> getPageList(EducationIdeologySearchInputDTO dto) {
        return pageListByEntity(dto);
    }
}
