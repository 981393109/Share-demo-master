package com.correction.backend.modules.supervision.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.correction.backend.modules.supervision.constant.SupervisionConstant;
import com.correction.backend.modules.supervision.controller.dto.*;
import com.correction.backend.modules.supervision.convert.MSupervisionVisitFieldConvert;
import com.correction.backend.modules.supervision.convert.MSupervisionVisitGroupConvert;
import com.correction.backend.modules.supervision.entity.SupervisionVisitGroup;
import com.correction.backend.modules.supervision.service.SupervisionVisitFieldService;
import com.correction.backend.modules.supervision.entity.SupervisionVisitField;
import com.correction.backend.modules.supervision.mapper.SupervisionVisitFieldMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.correction.backend.modules.supervision.service.SupervisionVisitGroupService;
import com.correction.backend.modules.survey.controller.dto.SurveyDocumentsFilesDTO;
import com.correction.backend.modules.survey.controller.dto.SurveyDocumentsFilesQuery;
import com.correction.backend.modules.survey.entity.SurveyDocumentsFiles;
import com.correction.backend.modules.survey.service.SurveyDocumentsFilesService;
import com.correction.framework.common.pojo.PageResult;
import com.correction.framework.web.web.core.util.WebFrameworkUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 查访登记 服务实现类
 * </p>
 *
 * @author yao
 * @since 2022-12-03
 */
@Service
public class SupervisionVisitFieldServiceImpl extends ServiceImpl<SupervisionVisitFieldMapper, SupervisionVisitField> implements SupervisionVisitFieldService {

    @Resource
    private SupervisionVisitGroupService supervisionVisitGroupService;

    @Resource
    private SurveyDocumentsFilesService surveyDocumentsFilesService;

    /**
     * 获取表格数据
     *
     * @param supervisionVisitField
     * @return
     */
    public PageResult<SupervisionVisitField> pageListByEntity(SupervisionVisitFieldSearchInputDTO supervisionVisitField) {
        LambdaQueryWrapper<SupervisionVisitField> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.like(StrUtil.isNotBlank(supervisionVisitField.getCorrectionUnit()), SupervisionVisitField::getCorrectionUnit, supervisionVisitField.getCorrectionUnit());
        queryWrapper.like(supervisionVisitField.getCorrectionUnitId()!=null, SupervisionVisitField::getCorrectionUnitId, supervisionVisitField.getCorrectionUnitId());
        queryWrapper.like(StrUtil.isNotBlank(supervisionVisitField.getUserName()), SupervisionVisitField::getUserName, supervisionVisitField.getUserName());
        queryWrapper.like(StrUtil.isNotBlank(supervisionVisitField.getVisitDate()), SupervisionVisitField::getVisitDate, supervisionVisitField.getVisitDate());
        queryWrapper.like(StrUtil.isNotBlank(supervisionVisitField.getVisitAddress()), SupervisionVisitField::getVisitAddress, supervisionVisitField.getVisitAddress());
        queryWrapper.like(StrUtil.isNotBlank(supervisionVisitField.getVisitPurpose()), SupervisionVisitField::getVisitPurpose, supervisionVisitField.getVisitPurpose());
        queryWrapper.like(StrUtil.isNotBlank(supervisionVisitField.getVisitOpinion()), SupervisionVisitField::getVisitOpinion, supervisionVisitField.getVisitOpinion());
        queryWrapper.like(supervisionVisitField.getOrgNum()!=null, SupervisionVisitField::getOrgNum, supervisionVisitField.getOrgNum());
        queryWrapper.like(StrUtil.isNotBlank(supervisionVisitField.getCreator()), SupervisionVisitField::getCreator, supervisionVisitField.getCreator());
        queryWrapper.like(StrUtil.isNotBlank(supervisionVisitField.getUpdater()), SupervisionVisitField::getUpdater, supervisionVisitField.getUpdater());
        PageResult<SupervisionVisitField> pageResult = baseMapper.selectPage(supervisionVisitField, queryWrapper);
        return pageResult;
    }


    @Override
    public SupervisionVisitField createSupervisionVisitField(SupervisionVisitFieldCreateInputDTO createInputDTO) {
        SupervisionVisitField supervisionVisitField = MSupervisionVisitFieldConvert.INSTANCE.toSupervisionVisitField(createInputDTO);
        List<SupervisionVisitGroupCreateInputDTO> userGroupList = createInputDTO.getUserGroupList();
        Long loginOrgId = WebFrameworkUtils.getLoginOrgId();
        supervisionVisitField.setOrgNum(loginOrgId);
        baseMapper.insert(supervisionVisitField);
        supervisionVisitGroupService.createSupervisionVisitGroupList(userGroupList,supervisionVisitField.getId(),1);
        List<SurveyDocumentsFiles> surveyDocumentsFiles = createInputDTO.getSurveyDocumentsFiles();
        for (SurveyDocumentsFiles surveyDocumentsFile : surveyDocumentsFiles) {
            surveyDocumentsFile.setDataId(supervisionVisitField.getId());
            surveyDocumentsFilesService.updateById(surveyDocumentsFile);
        }
        return supervisionVisitField;
    }

    @Override
    public SupervisionVisitField updateSupervisionVisitField(SupervisionVisitFieldUpdateInputDTO updateInputDTO) {
        SupervisionVisitField supervisionVisitField = MSupervisionVisitFieldConvert.INSTANCE.toSupervisionVisitField(updateInputDTO);
        baseMapper.updateById(supervisionVisitField);
        supervisionVisitGroupService.updateSupervisionVisitGroupList(updateInputDTO.getUserGroupList(), supervisionVisitField.getId(),1);
        return supervisionVisitField;
    }

    @Override
    public SupervisionVisitField getDetail(Long id) {
        SupervisionVisitField supervisionVisitField = baseMapper.selectById(id);
        return supervisionVisitField;
    }

    @Override
    public SupervisionVisitFieldDTO getDetailDTO(Long id) {
        SupervisionVisitField supervisionVisitField = baseMapper.selectById(id);
        List<SupervisionVisitGroup> listByDataId = supervisionVisitGroupService.getListByDataId(id,1);
        List<SurveyDocumentsFilesDTO> DICT_TYPE_SUPERVISION = surveyDocumentsFilesService.getSurveyDocumentList(SurveyDocumentsFilesQuery.builder()
                .dictType(SupervisionConstant.DICT_TYPE_SUPERVISION_401).dataId(id).build());
        SupervisionVisitFieldDTO supervisionVisitFieldDTO = new SupervisionVisitFieldDTO();
        supervisionVisitFieldDTO.setUserGroupList(MSupervisionVisitGroupConvert.INSTANCE.toList(listByDataId));
        supervisionVisitFieldDTO.setDetail(MSupervisionVisitFieldConvert.INSTANCE.toList(supervisionVisitField));
        supervisionVisitFieldDTO.setSurveyDocumentsFiles(DICT_TYPE_SUPERVISION);
        return supervisionVisitFieldDTO;
    }

    @Override
    public void delete(Long id) {
        baseMapper.deleteById(id);
        supervisionVisitGroupService.deleteByDataId(id);
    }

    @Override
    public PageResult<SupervisionVisitField> getPageList(SupervisionVisitFieldSearchInputDTO searchInputDTO) {
        return pageListByEntity(searchInputDTO);
    }
}
