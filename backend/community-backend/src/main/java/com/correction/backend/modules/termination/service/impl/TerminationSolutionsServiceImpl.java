package com.correction.backend.modules.termination.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.correction.backend.modules.cases.controller.dto.CasesPunishmentPageListDTO;
import com.correction.backend.modules.handleCorrection.entity.CorrectionUser;
import com.correction.backend.modules.handleCorrection.mapper.CorrectionUserMapper;
import com.correction.backend.modules.survey.constant.SurveyConstant;
import com.correction.backend.modules.survey.controller.dto.SurveyDocumentsFilesDTO;
import com.correction.backend.modules.survey.controller.dto.SurveyDocumentsFilesQuery;
import com.correction.backend.modules.survey.entity.SurveyDocumentsFiles;
import com.correction.backend.modules.survey.service.SurveyDocumentsFilesService;
import com.correction.backend.modules.sys.entity.OrgDO;
import com.correction.backend.modules.sys.entity.SysUserDO;
import com.correction.backend.modules.sys.mapper.OrgMapper;
import com.correction.backend.modules.sys.mapper.SysUserMapper;
import com.correction.backend.modules.termination.controller.dto.*;
import com.correction.backend.modules.termination.convert.MTerminationSolutionsConvert;
import com.correction.backend.modules.termination.service.TerminationSolutionsService;
import com.correction.framework.common.pojo.PageResult;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.correction.backend.modules.termination.entity.TerminationSolutions;
import com.correction.backend.modules.termination.mapper.TerminationSolutionsMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.correction.framework.web.web.LoginUser;
import com.correction.framework.web.web.core.util.WebFrameworkUtils;
import com.correction.frameworks.mybatis.mybatis.core.util.MyBatisUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 期满解矫 服务实现类
 * </p>
 *
 * @author yao
 * @since 2022-12-18
 */
@Service
public class TerminationSolutionsServiceImpl extends ServiceImpl<TerminationSolutionsMapper, TerminationSolutions> implements TerminationSolutionsService {


    @Resource
    private SurveyDocumentsFilesService surveyDocumentsFilesService;

    @Resource
    private SysUserMapper sysUserMapper;

    @Resource
    private CorrectionUserMapper correctionUserMapper;

    @Resource
    private OrgMapper orgMapper;




    /**
     * 获取表格数据
     *
     * @param terminationSolutions
     * @return
     */
    public PageResult<TerminationSolutions> pageListByEntity(TerminationSolutionsSearchInputDTO terminationSolutions) {
        LambdaQueryWrapper<TerminationSolutions> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.like(StrUtil.isNotBlank(terminationSolutions.getCorrectionUnit()), TerminationSolutions::getCorrectionUnit, terminationSolutions.getCorrectionUnit());
        queryWrapper.like(StrUtil.isNotBlank(terminationSolutions.getUserName()), TerminationSolutions::getUserName, terminationSolutions.getUserName());
        queryWrapper.like(StrUtil.isNotBlank(terminationSolutions.getSupervisionLevel()), TerminationSolutions::getSupervisionLevel, terminationSolutions.getSupervisionLevel());
        queryWrapper.like(StrUtil.isNotBlank(terminationSolutions.getPerformType()), TerminationSolutions::getPerformType, terminationSolutions.getPerformType());
        queryWrapper.like(StrUtil.isNotBlank(terminationSolutions.getApplyName()), TerminationSolutions::getApplyName, terminationSolutions.getApplyName());
        queryWrapper.like(StrUtil.isNotBlank(terminationSolutions.getApplyTime()), TerminationSolutions::getApplyTime, terminationSolutions.getApplyTime());
        queryWrapper.like(StrUtil.isNotBlank(terminationSolutions.getRef()), TerminationSolutions::getRef, terminationSolutions.getRef());
        queryWrapper.like(StrUtil.isNotBlank(terminationSolutions.getProcessInstanceId()), TerminationSolutions::getProcessInstanceId, terminationSolutions.getProcessInstanceId());
        queryWrapper.like(StrUtil.isNotBlank(terminationSolutions.getCreator()), TerminationSolutions::getCreator, terminationSolutions.getCreator());
        queryWrapper.like(StrUtil.isNotBlank(terminationSolutions.getUpdater()), TerminationSolutions::getUpdater, terminationSolutions.getUpdater());
        return baseMapper.selectPage(terminationSolutions, queryWrapper);
    }

    @Override
    public TerminationSolutions create(TerminationSolutionsCreateInputDTO createInputDTO) {
        TerminationSolutions terminationSolutions = MTerminationSolutionsConvert.INSTANCE.toTerminationSolutions(createInputDTO);
        //新增：
        //得到矫正对象
        CorrectionUser correctionUser = correctionUserMapper.selectById(createInputDTO.getUserId());
        terminationSolutions.setCorrectionTime(correctionUser.getCorrectionStartDate());
        terminationSolutions.setSolutionsTime(correctionUser.getCorrectionEndDate());
        LoginUser loginUser = WebFrameworkUtils.getLoginUser();
        terminationSolutions.setApplyName(loginUser.getUsername());
        terminationSolutions.setApplyUser(loginUser.getId());
        terminationSolutions.setApplyStatus(SurveyConstant.FLOW_STATUS_0);
        terminationSolutions.setProgress(SurveyConstant.PROGRESS_1);
        terminationSolutions.setOrgNum(WebFrameworkUtils.getLoginOrgId());
        terminationSolutions.setRef(String.valueOf(System.currentTimeMillis()));
        baseMapper.insert(terminationSolutions);
        List<SurveyDocumentsFiles> surveyDocumentsFiles = createInputDTO.getSurveyDocumentsFiles();
        if(!CollectionUtils.isEmpty(surveyDocumentsFiles))
            for (SurveyDocumentsFiles surveyDocumentsFile : surveyDocumentsFiles) {
                surveyDocumentsFile.setDataId(terminationSolutions.getId());
                surveyDocumentsFilesService.updateById(surveyDocumentsFile);
            }
        return terminationSolutions;
    }

    @Override
    public TerminationSolutions update(TerminationSolutionsUpdateInputDTO updateInputDTO) {
        TerminationSolutions terminationSolutions = MTerminationSolutionsConvert.INSTANCE.toTerminationSolutions(updateInputDTO);
        baseMapper.updateById(terminationSolutions);
        return getById(updateInputDTO.getId());
    }

    @Override
    public TerminationSolutions update(TerminationSolutions updateInputDTO) {
        baseMapper.updateById(updateInputDTO);
        return getById(updateInputDTO.getId());
    }

    @Override
    public TerminationSolutionDetailDTO getDetail(Long id) {
        TerminationSolutionDetailDTO detailDTO = new TerminationSolutionDetailDTO();
        TerminationSolutions terminationSolutions = baseMapper.selectById(id);
        detailDTO.setDetail(MTerminationSolutionsConvert.INSTANCE.toList(terminationSolutions));
        //和议结果材料
        List<SurveyDocumentsFilesDTO> reportFiles = surveyDocumentsFilesService
                .getSurveyDocumentList(SurveyDocumentsFilesQuery.builder().dictType(901).dataId(id).build());
        List<SurveyDocumentsFilesDTO> signatureFiles = surveyDocumentsFilesService
                .getSurveyDocumentList(SurveyDocumentsFilesQuery.builder().dictType(902).dataId(id).build());
        detailDTO.setReportFiles(reportFiles);
        detailDTO.setSignatureFiles(signatureFiles);
        return detailDTO;
    }

    @Override
    public void delete(Long id) {
        baseMapper.deleteById(id);
    }

    @Override
    public IPage<TerminationSolutionsPageListDTO> getPageList(TerminationSolutionsSearchInputDTO solutionsSearchInputDTO) {
        IPage<TerminationSolutionsPageListDTO> mpPage = MyBatisUtils.buildPage(solutionsSearchInputDTO);
        solutionsSearchInputDTO.setApplyUser(WebFrameworkUtils.getLoginUserId());
        mpPage = baseMapper.getPageListFlow(mpPage, solutionsSearchInputDTO);
        List<TerminationSolutionsPageListDTO> records = mpPage.getRecords();
        if(!CollectionUtils.isEmpty(records)) {
            for (TerminationSolutionsPageListDTO record : records) {
                if(record.getNextUser()!=null){
                    SysUserDO userDO = sysUserMapper.selectById(Long.parseLong(record.getNextUser()));
                    record.setNextUserName(userDO.getUserName());
                } else {
                    if(SurveyConstant.FLOW_STATUS_0.equals(record.getApplyStatus())){
                        if(record.getApplyUser()!=null){
                            record.setNextUser(String.valueOf(record.getApplyUser()));
                            record.setNextUserName(sysUserMapper.selectById(record.getApplyUser()).getUserName());
                        }
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
    public IPage<TerminationSolutionsPageListDTO> getPageAllList(TerminationSolutionsSearchInputDTO solutionsSearchInputDTO) {
        IPage<TerminationSolutionsPageListDTO> mpPage = MyBatisUtils.buildPage(solutionsSearchInputDTO);
        solutionsSearchInputDTO.setOrgIds(WebFrameworkUtils.getLoginOrgIdsList());
        mpPage = baseMapper.getPageListFlow(mpPage, solutionsSearchInputDTO);
        List<TerminationSolutionsPageListDTO> records = mpPage.getRecords();
        if(!CollectionUtils.isEmpty(records)) {
            for (TerminationSolutionsPageListDTO record : records) {
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

    @Override
    public void autoCreateTerminationRecord() {
        //解矫 30天
        String  now = LocalDate.now().toString();
        List<CorrectionUser> correctionUsers = correctionUserMapper.selectList(Wrappers.<CorrectionUser>lambdaQuery()
                .eq(CorrectionUser::getIsHistory, 0).last(" and datediff(correction_end_date,'" + now + "') <= 30 and datediff(correction_end_date,'" + now + "' ) > 0 "));
        List<TerminationSolutions> list = list();
        List<Long> collect = list.stream().map(e -> e.getUserId()).collect(Collectors.toList());
        //生成解矫正记录
        if(!CollectionUtils.isEmpty(correctionUsers)){
            List<CorrectionUser> correctionUserList = correctionUsers.stream().filter(e -> !collect.contains(e.getId())).collect(Collectors.toList());
            for (CorrectionUser correctionUser : correctionUserList) {
                OrgDO orgDO = orgMapper.selectById(correctionUser.getHandleCorrectionId());
                if(orgDO == null){continue;}
                TerminationSolutions terminationSolutions = new TerminationSolutions();
                terminationSolutions.setUserId(correctionUser.getId());
                terminationSolutions.setUserName(correctionUser.getName());
                terminationSolutions.setCorrectionUnitId(orgDO.getId());
                terminationSolutions.setCorrectionUnit(orgDO.getOrgName());
                terminationSolutions.setCorrectionTime(correctionUser.getCorrectionStartDate());
                terminationSolutions.setSolutionsTime(correctionUser.getCorrectionEndDate());
                terminationSolutions.setApplyName("系统定时任务生成");
                terminationSolutions.setApplyStatus(SurveyConstant.FLOW_STATUS_0);
                terminationSolutions.setProgress(SurveyConstant.PROGRESS_1);
                terminationSolutions.setOrgNum(correctionUser.getHandleCorrectionId());
                terminationSolutions.setRef(String.valueOf(System.currentTimeMillis()));
                baseMapper.insert(terminationSolutions);
            }
        }
    }


}
