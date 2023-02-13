package com.correction.backend.modules.handleCorrection.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.correction.backend.modules.handleCorrection.controller.dto.*;
import com.correction.backend.modules.handleCorrection.convert.MHandleCorrectionConvert;
import com.correction.backend.modules.handleCorrection.entity.CorrectionGroup;
import com.correction.backend.modules.handleCorrection.entity.CorrectionUser;
import com.correction.backend.modules.handleCorrection.entity.CorrectionWays;
import com.correction.backend.modules.handleCorrection.mapper.CorrectionGroupMapper;
import com.correction.backend.modules.handleCorrection.mapper.CorrectionUserMapper;
import com.correction.backend.modules.handleCorrection.mapper.CorrectionWaysMapper;
import com.correction.backend.modules.handleCorrection.service.CorrectionGroupService;
import com.correction.backend.modules.handleCorrection.service.CorrectionUserService;
import com.correction.backend.modules.handleCorrection.service.CorrectionWaysService;
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
import com.correction.backend.modules.survey.mapper.SurveyEvaluationMapper;
import com.correction.backend.modules.survey.service.SurveyDocumentsFilesService;
import com.correction.backend.modules.sys.entity.SysUserDO;
import com.correction.backend.modules.sys.mapper.SysUserMapper;
import com.correction.framework.common.pojo.PageResult;
import com.correction.framework.web.web.core.util.WebFrameworkUtils;
import com.correction.frameworks.mybatis.mybatis.core.util.MyBatisUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    @Resource
    CorrectionUserService correctionUserService;

    @Resource
    CorrectionGroupService correctionGroupService;

    @Resource
    CorrectionWaysService correctionWaysService;

    @Resource
    SysUserMapper sysUserMapper;

    @Resource
    SurveyEvaluationMapper surveyEvaluationMapper;


    @Override
    public HandleCorrection createHandleCorrection(HandleCorrectionCreateInputDTO correctionCreateInputDTO) {
        //校验：
        HandleCorrection handleCorrection = MHandleCorrectionConvert.INSTANCE.toHandleCorrection(correctionCreateInputDTO);
        handleCorrection.setApplyStatus(SurveyConstant.FLOW_STATUS_0);
        handleCorrection.setProgress(SurveyConstant.PROGRESS_1);
        if(handleCorrection.getOrgNum() == null)
            handleCorrection.setOrgNum(WebFrameworkUtils.getLoginOrgId());
        handleCorrection.setRef(String.valueOf(System.currentTimeMillis()));
        baseMapper.insert(handleCorrection);
        return handleCorrection;
    }

    @Override
    public HandleCorrection updateHandleCorrection(HandleCorrectionUpdateInputDTO correctionUpdateInputDTO) {
        HandleCorrection handleCorrection = MHandleCorrectionConvert.INSTANCE.toHandleCorrection(correctionUpdateInputDTO);
        baseMapper.updateById(handleCorrection);
        handleCorrection = baseMapper.selectById(handleCorrection.getId());
        return handleCorrection;
    }

    @Override
    public HandleCorrection updateHandleCorrection(HandleCorrection correction) {
        updateById(correction);
        return baseMapper.selectById(correction.getId());
    }

    @Override
    public void delete(Long id) {
        int i = baseMapper.deleteById(id);
    }

    @Override
    public HandleCorrectionFilesDTO getDetail(Long id) {
        HandleCorrection handleCorrection = baseMapper.selectById(id);
        SurveyEvaluation surveyEvaluation = surveyEvaluationMapper.selectById(handleCorrection.getSurveyEvaluationId());
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
        List<SurveyDocumentsFilesDTO> DICT_TYPE_group = surveyDocumentsFilesService.getSurveyDocumentList(SurveyDocumentsFilesQuery.builder().dictType(SurveyConstant.DICT_TYPE_group).dataId(id).build());
        List<SurveyDocumentsFilesDTO> DICT_TYPE_ways = surveyDocumentsFilesService.getSurveyDocumentList(SurveyDocumentsFilesQuery.builder().dictType(SurveyConstant.DICT_TYPE_ways).dataId(id).build());
        List<SurveyDocumentsFilesDTO> DICT_TYPE_say = surveyDocumentsFilesService.getSurveyDocumentList(SurveyDocumentsFilesQuery.builder().dictType(SurveyConstant.DICT_TYPE_say).dataId(id).build());
        List<SurveyDocumentsFilesDTO> receiptMaterialsFiles = surveyDocumentsFilesService.getSurveyDocumentList(SurveyDocumentsFilesQuery.builder().dictType(1101).dataId(id).build());
        HandleCorrectionListOutputDTO handleCorrectionListOutputDTO = MHandleCorrectionConvert.INSTANCE.toList(handleCorrection);
        //矫正档案
        CorrectionUser correctionUser = correctionUserService.getByCorrectionId(handleCorrection.getId());
        //矫正小组
        List<CorrectionGroup> correctionGroup = correctionGroupService.getByCorrectionId(handleCorrection.getId());
        //矫正方案
        CorrectionWays correctionWays = correctionWaysService.getByCorrectionId(handleCorrection.getId());
        handleCorrectionListOutputDTO.setCorrectionGroupId(correctionGroup == null ? null:correctionGroup.stream().map(e->e.getId()).collect(Collectors.toList()));
        handleCorrectionListOutputDTO.setCorrectionUserId(correctionUser == null ? null:correctionUser.getId());
        handleCorrectionListOutputDTO.setCorrectionWaysId(correctionWays == null ? null:correctionWays.getId());
        HandleCorrectionFilesDTO handleCorrectionFilesDTO = new HandleCorrectionFilesDTO();
        handleCorrectionFilesDTO.setDetail(handleCorrectionListOutputDTO);
        handleCorrectionFilesDTO.setDocSupplementFiles(DICT_TYPE_docSupplement);
        handleCorrectionFilesDTO.setUserReportsFiles(DICT_TYPE_userReports);
        handleCorrectionFilesDTO.setInformationCollectionFiles(DICT_TYPE_informationCollection);
        handleCorrectionFilesDTO.setReportingFiles(DICT_TYPE_reporting);
        handleCorrectionFilesDTO.setLetterNoticeFiles(DICT_TYPE_letterNotice);
        handleCorrectionFilesDTO.setGroupFiles(DICT_TYPE_group);
        handleCorrectionFilesDTO.setWaysFiles(DICT_TYPE_ways);
        handleCorrectionFilesDTO.setSaysFiles(DICT_TYPE_say);
        handleCorrectionFilesDTO.setSurveyEvaluation(surveyEvaluation);
        handleCorrectionFilesDTO.setReceiptMaterialsFiles(receiptMaterialsFiles);
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
        queryWrapper.eq(handleCorrection.getOrgNum()!=null, HandleCorrection::getOrgNum, handleCorrection.getOrgNum());
        queryWrapper.like(StrUtil.isNotBlank(handleCorrection.getCreator()), HandleCorrection::getCreator, handleCorrection.getCreator());
        queryWrapper.like(StrUtil.isNotBlank(handleCorrection.getUpdater()), HandleCorrection::getUpdater, handleCorrection.getUpdater());
        return baseMapper.selectList(queryWrapper);
    }

    @Override
    public IPage<HandleCorrectionListDTO> getPageList(HandleCorrectionSearchInputDTO searchInputDTO) {
        IPage<HandleCorrectionListDTO> mpPage = MyBatisUtils.buildPage(searchInputDTO);
        searchInputDTO.setApplyUser(WebFrameworkUtils.getLoginUserId());
        initApplyStatus(searchInputDTO);
        mpPage = baseMapper.getPageListFlow(mpPage, searchInputDTO);
        List<HandleCorrectionListDTO> records = mpPage.getRecords();
        if(!CollectionUtils.isEmpty(records)) {
            for (HandleCorrectionListDTO record : records) {
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

    @Override
    public IPage<HandleCorrectionListDTO> getPageAllList(HandleCorrectionSearchInputDTO searchInputDTO) {
        IPage<HandleCorrectionListDTO> mpPage = MyBatisUtils.buildPage(searchInputDTO);
        searchInputDTO.setOrgIds(WebFrameworkUtils.getLoginOrgIdsList());
        initApplyStatus(searchInputDTO);
        mpPage = baseMapper.getPageAllListFlow(mpPage, searchInputDTO);
        List<HandleCorrectionListDTO> records = mpPage.getRecords();
        if(!CollectionUtils.isEmpty(records)) {
            for (HandleCorrectionListDTO record : records) {
                if(record.getNextUser()!=null){
                    SysUserDO userDO = sysUserMapper.selectById(Long.parseLong(record.getNextUser()));
                    record.setNextUserName(userDO.getUserName());
                } else {
                    if(SurveyConstant.FLOW_STATUS_0.equals(record.getApplyStatus())){
                        record.setNextUser(String.valueOf(record.getApplyUser()));
                        record.setNextUserName(sysUserMapper.selectById(record.getApplyUser()).getUserName());
                    }
                }
            }
        }
        return mpPage;
    }

    private void initApplyStatus(HandleCorrectionSearchInputDTO searchInputDTO) {
        List<Integer> list = new ArrayList<>();
        if(searchInputDTO.getApplyStatus()!=null){
            if(1 == searchInputDTO.getApplyStatus()){
                list.add(0);
            } else if (2 == searchInputDTO.getApplyStatus()) {
                list.add(1);
                list.add(2);
                list.add(3);
                list.add(4);
                list.add(5);
                list.add(6);
                list.add(7);
            } else if (4 == searchInputDTO.getApplyStatus()) {
                list.add(99);
            } else {
                list.add(8);
                list.add(9);
                list.add(10);
                list.add(11);
                list.add(12);
            }
        }
        searchInputDTO.setApplyStatusList(list.size() == 0?null:list);
    }
}
