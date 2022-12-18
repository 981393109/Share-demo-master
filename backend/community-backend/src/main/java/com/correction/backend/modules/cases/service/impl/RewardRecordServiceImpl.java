package com.correction.backend.modules.cases.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.correction.backend.modules.cases.controller.dto.*;
import com.correction.backend.modules.cases.convert.MRewardRecordConvert;
import com.correction.backend.modules.cases.entity.CollegiateBenchGroup;
import com.correction.backend.modules.cases.service.CollegiateBenchGroupService;
import com.correction.backend.modules.cases.service.RewardRecordService;
import com.correction.backend.modules.survey.constant.SurveyConstant;
import com.correction.backend.modules.survey.controller.dto.SurveyDocumentsFilesDTO;
import com.correction.backend.modules.survey.controller.dto.SurveyDocumentsFilesQuery;
import com.correction.backend.modules.survey.service.SurveyDocumentsFilesService;
import com.correction.backend.modules.sys.entity.SysUserDO;
import com.correction.backend.modules.sys.mapper.SysUserMapper;
import com.correction.framework.common.pojo.PageResult;
import com.correction.backend.modules.cases.entity.RewardRecord;
import com.correction.backend.modules.cases.mapper.RewardRecordMapper;
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
 * 奖励记录 服务实现类
 * </p>
 *
 * @author yao
 * @since 2022-12-17
 */
@Service
public class RewardRecordServiceImpl extends ServiceImpl<RewardRecordMapper, RewardRecord> implements RewardRecordService {


    @Resource
    private SysUserMapper sysUserMapper;

    @Resource
    private CollegiateBenchGroupService collegiateBenchGroupService;

    @Resource
    private SurveyDocumentsFilesService surveyDocumentsFilesService;

    /**
     * 获取表格数据
     *
     * @param rewardRecord
     * @return
     */
    public PageResult<RewardRecord> pageListByEntity(RewardRecordSearchInputDTO rewardRecord) {
        LambdaQueryWrapper<RewardRecord> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.like(StrUtil.isNotBlank(rewardRecord.getCorrectionUnit()), RewardRecord::getCorrectionUnit, rewardRecord.getCorrectionUnit());
        queryWrapper.like(StrUtil.isNotBlank(rewardRecord.getUserName()), RewardRecord::getUserName, rewardRecord.getUserName());
        queryWrapper.like(StrUtil.isNotBlank(rewardRecord.getRelatedInformation()), RewardRecord::getRelatedInformation, rewardRecord.getRelatedInformation());
        queryWrapper.like(StrUtil.isNotBlank(rewardRecord.getBackInfo()), RewardRecord::getBackInfo, rewardRecord.getBackInfo());
        queryWrapper.like(StrUtil.isNotBlank(rewardRecord.getApplyName()), RewardRecord::getApplyName, rewardRecord.getApplyName());
        queryWrapper.like(StrUtil.isNotBlank(rewardRecord.getApplyTime()), RewardRecord::getApplyTime, rewardRecord.getApplyTime());
        queryWrapper.like(StrUtil.isNotBlank(rewardRecord.getRef()), RewardRecord::getRef, rewardRecord.getRef());
        queryWrapper.like(StrUtil.isNotBlank(rewardRecord.getProcessInstanceId()), RewardRecord::getProcessInstanceId, rewardRecord.getProcessInstanceId());
        queryWrapper.like(StrUtil.isNotBlank(rewardRecord.getNextRef()), RewardRecord::getNextRef, rewardRecord.getNextRef());
        queryWrapper.like(StrUtil.isNotBlank(rewardRecord.getNextProcessInstanceId()), RewardRecord::getNextProcessInstanceId, rewardRecord.getNextProcessInstanceId());
        queryWrapper.like(StrUtil.isNotBlank(rewardRecord.getCreator()), RewardRecord::getCreator, rewardRecord.getCreator());
        queryWrapper.like(StrUtil.isNotBlank(rewardRecord.getUpdater()), RewardRecord::getUpdater, rewardRecord.getUpdater());
        return baseMapper.selectPage(rewardRecord,queryWrapper);
    }

    @Override
    public RewardRecord createRewardRecord(RewardRecordCreateInputDTO createInputDTO) {
        RewardRecord rewardRecord = MRewardRecordConvert.INSTANCE.toRewardRecord(createInputDTO);
        rewardRecord.setApplyStatus(SurveyConstant.FLOW_STATUS_1);
        rewardRecord.setProgress(SurveyConstant.PROGRESS_1);
        rewardRecord.setOrgNum(WebFrameworkUtils.getLoginOrgId());
        rewardRecord.setRef(String.valueOf(System.currentTimeMillis()));
        baseMapper.insert(rewardRecord);
        return rewardRecord;
    }

    @Override
    public RewardRecord updateRewardRecord(RewardRecordUpdateInputDTO updateInputDTO) {
        RewardRecord rewardRecord = MRewardRecordConvert.INSTANCE.toRewardRecord(updateInputDTO);
        List<CollegiateBenchGroup> collegiateBenchGroups = updateInputDTO.getCollegiateBenchGroups();
        List<CollegiateBenchGroup> reviewGroups = updateInputDTO.getReviewGroups();
        if(!CollectionUtils.isEmpty(collegiateBenchGroups)) {
            collegiateBenchGroupService.createCollegiateBenchGroup(collegiateBenchGroups,updateInputDTO.getId(),3);
        }
        if(!CollectionUtils.isEmpty(reviewGroups)) {
            collegiateBenchGroupService.createCollegiateBenchGroup(collegiateBenchGroups,updateInputDTO.getId(),4);
        }
        baseMapper.updateById(rewardRecord);
        return getById(updateInputDTO.getId());
    }

    @Override
    public RewardRecord updateRewardRecord(RewardRecord rewardRecord) {
        baseMapper.updateById(rewardRecord);
        return baseMapper.selectById(rewardRecord.getId());
    }

    @Override
    public RewardRecordDetailDTO getDetail(Long id) {
        RewardRecordDetailDTO detailDTO = new RewardRecordDetailDTO();
        RewardRecord rewardRecord = baseMapper.selectById(id);
        detailDTO.setDetail(MRewardRecordConvert.INSTANCE.toList(rewardRecord));
        Integer rewardTypeAdvice = rewardRecord.getRewardTypeAdvice();
        //和议结果材料
        List<SurveyDocumentsFilesDTO> collegiateBenchFiles = surveyDocumentsFilesService
                .getSurveyDocumentList(SurveyDocumentsFilesQuery.builder().dictType(rewardTypeAdvice).dataId(id).build());
        //评议审核材料
        List<SurveyDocumentsFilesDTO> reviewFiles = surveyDocumentsFilesService
                .getSurveyDocumentList(SurveyDocumentsFilesQuery.builder().dictType(810).dataId(id).build());
        //评议审核签字材料
        List<SurveyDocumentsFilesDTO> reviewApplyFiles = surveyDocumentsFilesService
                .getSurveyDocumentList(SurveyDocumentsFilesQuery.builder().dictType(811).dataId(id).build());
        //文书制作材料
        List<SurveyDocumentsFilesDTO> docMakingFiles = surveyDocumentsFilesService
                .getSurveyDocumentList(SurveyDocumentsFilesQuery.builder().dictType(812).dataId(id).build());
        //文书送达材料
        List<SurveyDocumentsFilesDTO> docSendFiles = surveyDocumentsFilesService
                .getSurveyDocumentList(SurveyDocumentsFilesQuery.builder().dictType(813).dataId(id).build());
        //文书补全材料
        List<SurveyDocumentsFilesDTO> docAddFiles = surveyDocumentsFilesService
                .getSurveyDocumentList(SurveyDocumentsFilesQuery.builder().dictType(814).dataId(id).build());
        List<CollegiateBenchGroup> CollegiateBenchGroups = collegiateBenchGroupService.getList(id, 3);
        List<CollegiateBenchGroup> ReviewGroups = collegiateBenchGroupService.getList(id, 4);
        detailDTO.setCollegiateBenchGroups(CollegiateBenchGroups);
        detailDTO.setReviewGroups(ReviewGroups);
        detailDTO.setCollegiateBenchFiles(collegiateBenchFiles);
        detailDTO.setCollegiateBenchFiles(collegiateBenchFiles);
        detailDTO.setReviewFiles(reviewFiles);
        detailDTO.setReviewApplyFiles(reviewApplyFiles);
        detailDTO.setDocMakingFiles(docMakingFiles);
        detailDTO.setDocSendFiles(docSendFiles);
        detailDTO.setDocAddFiles(docAddFiles);
        return detailDTO;
    }

    @Override
    public void delete(Long id) {
        baseMapper.deleteById(id);
    }

    @Override
    public IPage<RewardRecordPageListDTO> getPageList(RewardRecordSearchInputDTO searchInputDTO) {
        IPage<RewardRecordPageListDTO> mpPage = MyBatisUtils.buildPage(searchInputDTO);
        searchInputDTO.setApplyUser(WebFrameworkUtils.getLoginUserId());
        mpPage = baseMapper.getPageListFlow(mpPage, searchInputDTO);
        List<RewardRecordPageListDTO> records = mpPage.getRecords();
        if(!CollectionUtils.isEmpty(records)) {
            for (RewardRecordPageListDTO record : records) {
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
