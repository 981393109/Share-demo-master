package com.correction.backend.modules.termination.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.correction.backend.modules.survey.constant.SurveyConstant;
import com.correction.backend.modules.survey.controller.dto.SurveyDocumentsFilesDTO;
import com.correction.backend.modules.survey.controller.dto.SurveyDocumentsFilesQuery;
import com.correction.backend.modules.survey.entity.SurveyDocumentsFiles;
import com.correction.backend.modules.survey.service.SurveyDocumentsFilesService;
import com.correction.backend.modules.sys.entity.SysUserDO;
import com.correction.backend.modules.sys.mapper.SysUserMapper;
import com.correction.backend.modules.termination.controller.dto.*;
import com.correction.backend.modules.termination.convert.MTerminationCorrectConvert;
import com.correction.backend.modules.termination.service.TerminationCorrectService;
import com.correction.framework.common.pojo.PageResult;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.correction.backend.modules.termination.entity.TerminationCorrect;
import com.correction.backend.modules.termination.mapper.TerminationCorrectMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.correction.framework.web.web.LoginUser;
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
 * 矫正终止 服务实现类
 * </p>
 *
 * @author yao
 * @since 2022-12-18
 */
@Service
public class TerminationCorrectServiceImpl extends ServiceImpl<TerminationCorrectMapper, TerminationCorrect> implements TerminationCorrectService {

    @Resource
    SurveyDocumentsFilesService surveyDocumentsFilesService;

    @Resource
    SysUserMapper sysUserMapper;

    /**
     * 获取表格数据
     *
     * @param terminationCorrect
     * @return
     */
    public PageResult<TerminationCorrect> pageListByEntity(TerminationCorrectSearchInputDTO terminationCorrect) {
        LambdaQueryWrapper<TerminationCorrect> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.like(StrUtil.isNotBlank(terminationCorrect.getCorrectionUnit()), TerminationCorrect::getCorrectionUnit, terminationCorrect.getCorrectionUnit());
        queryWrapper.like(StrUtil.isNotBlank(terminationCorrect.getUserName()), TerminationCorrect::getUserName, terminationCorrect.getUserName());
        queryWrapper.like(StrUtil.isNotBlank(terminationCorrect.getSupervisionLevel()), TerminationCorrect::getSupervisionLevel, terminationCorrect.getSupervisionLevel());
        queryWrapper.like(StrUtil.isNotBlank(terminationCorrect.getPerformType()), TerminationCorrect::getPerformType, terminationCorrect.getPerformType());
        queryWrapper.like(StrUtil.isNotBlank(terminationCorrect.getApplyName()), TerminationCorrect::getApplyName, terminationCorrect.getApplyName());
        queryWrapper.like(StrUtil.isNotBlank(terminationCorrect.getApplyTime()), TerminationCorrect::getApplyTime, terminationCorrect.getApplyTime());
        queryWrapper.like(StrUtil.isNotBlank(terminationCorrect.getRef()), TerminationCorrect::getRef, terminationCorrect.getRef());
        queryWrapper.like(StrUtil.isNotBlank(terminationCorrect.getProcessInstanceId()), TerminationCorrect::getProcessInstanceId, terminationCorrect.getProcessInstanceId());
        queryWrapper.like(StrUtil.isNotBlank(terminationCorrect.getCreator()), TerminationCorrect::getCreator, terminationCorrect.getCreator());
        queryWrapper.like(StrUtil.isNotBlank(terminationCorrect.getUpdater()), TerminationCorrect::getUpdater, terminationCorrect.getUpdater());
        return baseMapper.selectPage(terminationCorrect, queryWrapper);
    }

    @Override
    public TerminationCorrect create(TerminationCorrectCreateInputDTO createInputDTO) {
        TerminationCorrect terminationCorrect = MTerminationCorrectConvert.INSTANCE.toTerminationCorrect(createInputDTO);
        LoginUser loginUser = WebFrameworkUtils.getLoginUser();
        terminationCorrect.setApplyName(loginUser.getUsername());
        terminationCorrect.setApplyUser(loginUser.getId());
        terminationCorrect.setApplyStatus(SurveyConstant.FLOW_STATUS_1);
        terminationCorrect.setProgress(SurveyConstant.PROGRESS_1);
        terminationCorrect.setOrgNum(WebFrameworkUtils.getLoginOrgId());
        terminationCorrect.setRef(String.valueOf(System.currentTimeMillis()));
        baseMapper.insert(terminationCorrect);
        List<SurveyDocumentsFiles> surveyDocumentsFiles = createInputDTO.getSurveyDocumentsFiles();
        for (SurveyDocumentsFiles surveyDocumentsFile : surveyDocumentsFiles) {
            surveyDocumentsFile.setDataId(terminationCorrect.getId());
            surveyDocumentsFilesService.updateById(surveyDocumentsFile);
        }
        return terminationCorrect;
    }

    @Override
    public TerminationCorrect update(TerminationCorrectUpdateInputDTO updateInputDTO) {
        TerminationCorrect terminationCorrect = MTerminationCorrectConvert.INSTANCE.toTerminationCorrect(updateInputDTO);
        baseMapper.updateById(terminationCorrect);
        return getById(updateInputDTO.getId());
    }

    @Override
    public TerminationCorrect update(TerminationCorrect updateInputDTO) {
        baseMapper.updateById(updateInputDTO);
        return getById(updateInputDTO.getId());
    }

    @Override
    public TerminationCorrectDetailDTO getDetail(Long id) {
        TerminationCorrectDetailDTO terminationCorrectDetailDTO = new TerminationCorrectDetailDTO();
        TerminationCorrect terminationCorrect = baseMapper.selectById(id);
        terminationCorrectDetailDTO.setDetail(MTerminationCorrectConvert.INSTANCE.toList(terminationCorrect));
        List<SurveyDocumentsFilesDTO> reportFiles = surveyDocumentsFilesService
                .getSurveyDocumentList(SurveyDocumentsFilesQuery.builder().dictType(1001).dataId(id).build());
        terminationCorrectDetailDTO.setReportFiles(reportFiles);
        return terminationCorrectDetailDTO;
    }

    @Override
    public void delete(Long id) {
        baseMapper.deleteById(id);
    }

    @Override
    public IPage<TerminationCorrectPageListDTO> getPageList(TerminationCorrectSearchInputDTO searchInputDTO) {
        IPage<TerminationCorrectPageListDTO> mpPage = MyBatisUtils.buildPage(searchInputDTO);
        searchInputDTO.setApplyUser(WebFrameworkUtils.getLoginUserId());
        mpPage = baseMapper.getPageListFlow(mpPage, searchInputDTO);
        List<TerminationCorrectPageListDTO> records = mpPage.getRecords();
        if(!CollectionUtils.isEmpty(records)) {
            for (TerminationCorrectPageListDTO record : records) {
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
