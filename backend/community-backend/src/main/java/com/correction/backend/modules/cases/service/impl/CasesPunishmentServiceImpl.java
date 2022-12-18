package com.correction.backend.modules.cases.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.correction.backend.modules.cases.controller.dto.*;
import com.correction.backend.modules.cases.convert.MCasesPunishmentConvert;
import com.correction.backend.modules.cases.entity.CollegiateBenchGroup;
import com.correction.backend.modules.cases.service.CasesPunishmentService;
import com.correction.backend.modules.cases.service.CollegiateBenchGroupService;
import com.correction.backend.modules.handleCorrection.controller.dto.HandleCorrectionListDTO;
import com.correction.backend.modules.handleCorrection.entity.HandleCorrection;
import com.correction.backend.modules.supervision.constant.SupervisionConstant;
import com.correction.backend.modules.survey.constant.SurveyConstant;
import com.correction.backend.modules.survey.controller.dto.SurveyDocumentsFilesDTO;
import com.correction.backend.modules.survey.controller.dto.SurveyDocumentsFilesQuery;
import com.correction.backend.modules.survey.service.SurveyDocumentsFilesService;
import com.correction.backend.modules.sys.entity.SysUserDO;
import com.correction.backend.modules.sys.mapper.SysUserMapper;
import com.correction.backend.modules.sys.service.SysUserService;
import com.correction.framework.common.pojo.PageResult;
import com.correction.backend.modules.cases.entity.CasesPunishment;
import com.correction.backend.modules.cases.mapper.CasesPunishmentMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.correction.framework.web.web.core.util.WebFrameworkUtils;
import com.correction.frameworks.mybatis.mybatis.core.util.MyBatisUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 处罚案件 服务实现类
 * </p>
 *
 * @author yao
 * @since 2022-12-17
 */
@Service
public class CasesPunishmentServiceImpl extends ServiceImpl<CasesPunishmentMapper, CasesPunishment> implements CasesPunishmentService {

    @Resource
    private SysUserMapper sysUserMapper;

    @Resource
    private CollegiateBenchGroupService collegiateBenchGroupService;

    @Resource
    private SurveyDocumentsFilesService surveyDocumentsFilesService;

    /**
     * 获取表格数据
     *
     * @param casesPunishment
     * @return
     */
    public PageResult<CasesPunishment> pageListByEntity(CasesPunishmentSearchInputDTO casesPunishment) {
        LambdaQueryWrapper<CasesPunishment> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.like(StrUtil.isNotBlank(casesPunishment.getCorrectionUnit()), CasesPunishment::getCorrectionUnit, casesPunishment.getCorrectionUnit());
        queryWrapper.like(StrUtil.isNotBlank(casesPunishment.getUserName()), CasesPunishment::getUserName, casesPunishment.getUserName());
        queryWrapper.like(StrUtil.isNotBlank(casesPunishment.getRelatedInformation()), CasesPunishment::getRelatedInformation, casesPunishment.getRelatedInformation());
        queryWrapper.like(StrUtil.isNotBlank(casesPunishment.getBackInfo()), CasesPunishment::getBackInfo, casesPunishment.getBackInfo());
        queryWrapper.like(StrUtil.isNotBlank(casesPunishment.getApplyName()), CasesPunishment::getApplyName, casesPunishment.getApplyName());
        queryWrapper.like(StrUtil.isNotBlank(casesPunishment.getApplyTime()), CasesPunishment::getApplyTime, casesPunishment.getApplyTime());
        queryWrapper.like(StrUtil.isNotBlank(casesPunishment.getRef()), CasesPunishment::getRef, casesPunishment.getRef());
        queryWrapper.like(StrUtil.isNotBlank(casesPunishment.getProcessInstanceId()), CasesPunishment::getProcessInstanceId, casesPunishment.getProcessInstanceId());
        queryWrapper.like(StrUtil.isNotBlank(casesPunishment.getNextRef()), CasesPunishment::getNextRef, casesPunishment.getNextRef());
        queryWrapper.like(StrUtil.isNotBlank(casesPunishment.getNextProcessInstanceId()), CasesPunishment::getNextProcessInstanceId, casesPunishment.getNextProcessInstanceId());
        queryWrapper.like(StrUtil.isNotBlank(casesPunishment.getCreator()), CasesPunishment::getCreator, casesPunishment.getCreator());
        queryWrapper.like(StrUtil.isNotBlank(casesPunishment.getUpdater()), CasesPunishment::getUpdater, casesPunishment.getUpdater());
        return baseMapper.selectPage(casesPunishment,queryWrapper);
    }


    @Override
    public CasesPunishment createCasesPunishment(CasesPunishmentCreateInputDTO casesPunishmentCreateInputDTO) {
        //校验：
        CasesPunishment casesPunishment = MCasesPunishmentConvert.INSTANCE.toCasesPunishment(casesPunishmentCreateInputDTO);
        casesPunishment.setApplyStatus(SurveyConstant.FLOW_STATUS_1);
        casesPunishment.setProgress(SurveyConstant.PROGRESS_1);
        casesPunishment.setOrgNum(WebFrameworkUtils.getLoginOrgId());
        casesPunishment.setRef(String.valueOf(System.currentTimeMillis()));
        baseMapper.insert(casesPunishment);
        return casesPunishment;
    }

    @Override
    public CasesPunishment updatePunishment(CasesPunishmentUpdateInputDTO updateInputDTO) {
        CasesPunishment casesPunishment = MCasesPunishmentConvert.INSTANCE.toCasesPunishment(updateInputDTO);
        List<CollegiateBenchGroup> collegiateBenchGroups = updateInputDTO.getCollegiateBenchGroups();
        List<CollegiateBenchGroup> reviewGroups = updateInputDTO.getReviewGroups();
        if(!CollectionUtils.isEmpty(collegiateBenchGroups)) {
            collegiateBenchGroupService.createCollegiateBenchGroup(collegiateBenchGroups,updateInputDTO.getId(),1);
        }
        if(!CollectionUtils.isEmpty(reviewGroups)) {
            collegiateBenchGroupService.createCollegiateBenchGroup(collegiateBenchGroups,updateInputDTO.getId(),2);
        }
        baseMapper.updateById(casesPunishment);
        return getById(updateInputDTO.getId());
    }

    @Override
    public CasesPunishment updatePunishment(CasesPunishment casesPunishment) {
        baseMapper.updateById(casesPunishment);
        return baseMapper.selectById(casesPunishment.getId());
    }

    @Override
    public CasesPunishmentDetailDTO getDetail(Long id) {
        CasesPunishmentDetailDTO detailDTO = new CasesPunishmentDetailDTO();
        CasesPunishment casesPunishment = baseMapper.selectById(id);
        detailDTO.setDetail(MCasesPunishmentConvert.INSTANCE.toList(casesPunishment));
        Integer violationsTypeAdvice = casesPunishment.getViolationsTypeAdvice();
        //和议结果材料
        List<SurveyDocumentsFilesDTO> collegiateBenchFiles = surveyDocumentsFilesService
                .getSurveyDocumentList(SurveyDocumentsFilesQuery.builder().dictType(violationsTypeAdvice).dataId(id).build());
        //评议审核材料
        List<SurveyDocumentsFilesDTO> reviewFiles = surveyDocumentsFilesService
                .getSurveyDocumentList(SurveyDocumentsFilesQuery.builder().dictType(710).dataId(id).build());
        //评议审核签字材料
        List<SurveyDocumentsFilesDTO> reviewApplyFiles = surveyDocumentsFilesService
                .getSurveyDocumentList(SurveyDocumentsFilesQuery.builder().dictType(711).dataId(id).build());
        //文书制作材料
        List<SurveyDocumentsFilesDTO> docMakingFiles = surveyDocumentsFilesService
                .getSurveyDocumentList(SurveyDocumentsFilesQuery.builder().dictType(712).dataId(id).build());
        //文书送达材料
        List<SurveyDocumentsFilesDTO> docSendFiles = surveyDocumentsFilesService
                .getSurveyDocumentList(SurveyDocumentsFilesQuery.builder().dictType(713).dataId(id).build());
        //教育
        List<SurveyDocumentsFilesDTO> educa = surveyDocumentsFilesService
                .getSurveyDocumentList(SurveyDocumentsFilesQuery.builder().dictType(714).dataId(id).build());
        //文书补全材料
        List<SurveyDocumentsFilesDTO> docAddFiles = surveyDocumentsFilesService
                .getSurveyDocumentList(SurveyDocumentsFilesQuery.builder().dictType(715).dataId(id).build());
        List<CollegiateBenchGroup> CollegiateBenchGroups = collegiateBenchGroupService.getList(id, 1);
        List<CollegiateBenchGroup> ReviewGroups = collegiateBenchGroupService.getList(id, 2);
        detailDTO.setCollegiateBenchGroups(CollegiateBenchGroups);
        detailDTO.setReviewGroups(ReviewGroups);
        detailDTO.setCollegiateBenchFiles(collegiateBenchFiles);
        detailDTO.setReviewFiles(reviewFiles);
        detailDTO.setReviewApplyFiles(reviewApplyFiles);
        detailDTO.setDocMakingFiles(docMakingFiles);
        detailDTO.setDocSendFiles(docSendFiles);
        detailDTO.setDocAddFiles(docAddFiles);
        detailDTO.setEducationFiles(educa);
        return detailDTO;
    }

    @Override
    public void delete(Long id) {
        baseMapper.deleteById(id);
    }

    @Override
    public IPage<CasesPunishmentPageListDTO> getPageList(CasesPunishmentSearchInputDTO searchInputDTO) {
        IPage<CasesPunishmentPageListDTO> mpPage = MyBatisUtils.buildPage(searchInputDTO);
        searchInputDTO.setApplyUser(WebFrameworkUtils.getLoginUserId());
        mpPage = baseMapper.getPageListFlow(mpPage, searchInputDTO);
        List<CasesPunishmentPageListDTO> records = mpPage.getRecords();
        if(!CollectionUtils.isEmpty(records)) {
            for (CasesPunishmentPageListDTO record : records) {
                if(record.getNextUser()!=null){
                    SysUserDO userDO = sysUserMapper.selectById(Long.parseLong(record.getNextUser()));
                    record.setNextUserName(userDO.getUserName());
                } else {
                    if(SurveyConstant.FLOW_STATUS_0.equals(record.getApplyStatus())){
                        record.setNextUser(String.valueOf(record.getApplyUser()));
                        record.setNextUserName(sysUserMapper.selectById(record.getApplyUser()).getUserName());
                    }
                }
                if (String.valueOf(WebFrameworkUtils.getLoginUserId()).equals(record.getNextUser())){
                    record.setFlowStatus(0);
                } else if (!String.valueOf(WebFrameworkUtils.getLoginUserId()).equals(record.getNextUser())  && StringUtils.isNotBlank(record.getTaskId())) {
                    record.setFlowStatus(1);
                } else {
                    record.setFlowStatus(2);
                }
            }
        }
        return mpPage;
    }



}
