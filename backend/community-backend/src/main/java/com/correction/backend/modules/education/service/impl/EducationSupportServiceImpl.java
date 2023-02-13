package com.correction.backend.modules.education.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.correction.backend.modules.education.controller.dto.*;
import com.correction.backend.modules.education.convert.MEducationSupportConvert;
import com.correction.backend.modules.education.entity.EducationIdeology;
import com.correction.backend.modules.education.service.EducationSupportService;
import com.correction.backend.modules.education.entity.EducationSupport;
import com.correction.backend.modules.education.mapper.EducationSupportMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.correction.backend.modules.supervision.controller.dto.SupervisionDailyReportUser;
import com.correction.backend.modules.supervision.entity.SupervisionDailyReport;
import com.correction.framework.common.pojo.PageResult;
import com.correction.framework.web.web.core.util.WebFrameworkUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * <p>
 * 教育帮扶表 服务实现类
 * </p>
 *
 * @author yao
 * @since 2022-12-06
 */
@Service
public class EducationSupportServiceImpl extends ServiceImpl<EducationSupportMapper, EducationSupport> implements EducationSupportService {

    /**
     * 获取表格数据
     *
     * @param educationSupport
     * @return
     */
    public PageResult<EducationSupport> pageListByEntity(EducationSupportSearchInputDTO educationSupport) {
        LambdaQueryWrapper<EducationSupport> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.like(StrUtil.isNotBlank(educationSupport.getCorrectionUnit()), EducationSupport::getCorrectionUnit, educationSupport.getCorrectionUnit());
        queryWrapper.like(educationSupport.getCorrectionUnitId()!=null, EducationSupport::getCorrectionUnitId, educationSupport.getCorrectionUnitId());
        queryWrapper.like(StrUtil.isNotBlank(educationSupport.getUserName()), EducationSupport::getUserName, educationSupport.getUserName());
        queryWrapper.like(StrUtil.isNotBlank(educationSupport.getLearningDate()), EducationSupport::getLearningDate, educationSupport.getLearningDate());
        queryWrapper.like(StrUtil.isNotBlank(educationSupport.getBenchmarkScore()), EducationSupport::getBenchmarkScore, educationSupport.getBenchmarkScore());
        queryWrapper.like(StrUtil.isNotBlank(educationSupport.getEducationContent()), EducationSupport::getEducationContent, educationSupport.getEducationContent());
        queryWrapper.like(StrUtil.isNotBlank(educationSupport.getAffiliatedUnit()), EducationSupport::getAffiliatedUnit, educationSupport.getAffiliatedUnit());
        queryWrapper.like(StrUtil.isNotBlank(educationSupport.getRegistrationView()), EducationSupport::getRegistrationView, educationSupport.getRegistrationView());
        queryWrapper.like(StrUtil.isNotBlank(educationSupport.getScore()), EducationSupport::getScore, educationSupport.getScore());
        queryWrapper.like(StrUtil.isNotBlank(educationSupport.getRemark()), EducationSupport::getRemark, educationSupport.getRemark());
        queryWrapper.like(StrUtil.isNotBlank(educationSupport.getCreator()), EducationSupport::getCreator, educationSupport.getCreator());
        queryWrapper.like(StrUtil.isNotBlank(educationSupport.getUpdater()), EducationSupport::getUpdater, educationSupport.getUpdater());
        queryWrapper.in(!CollectionUtils.isEmpty(educationSupport.getOrgIds()), EducationSupport::getOrgNum,educationSupport.getOrgIds());
        return baseMapper.selectPage(educationSupport, queryWrapper);
    }


    @Override
    public void createEducationSupport(EducationSupportUserDTO educationSupportUserDTO) {
        EducationSupport educationSupport = new EducationSupport();
        educationSupport.setOrgNum(WebFrameworkUtils.getLoginOrgId());
        List<EducationSupportUser> userList = educationSupportUserDTO.getUserList();
        for (EducationSupportUser educationSupportUser : userList) {
            educationSupport.setUserId(educationSupportUser.getUserId());
            educationSupport.setUserName(educationSupportUser.getUserName());
            educationSupport.setCorrectionUnit(educationSupportUserDTO.getCorrectionUnit());
            educationSupport.setCorrectionUnitId(educationSupportUserDTO.getCorrectionUnitId());
            educationSupport.setScore(educationSupportUser.getScore());
            educationSupport.setBenchmarkScore(educationSupportUserDTO.getBenchmarkScore());
            educationSupport.setRegistrationView(educationSupportUser.getRegistrationView());
            educationSupport.setEducationWay(educationSupportUserDTO.getEducationWay());
            educationSupport.setEducationContent(educationSupportUserDTO.getEducationContent());
            educationSupport.setLearningDate(educationSupportUserDTO.getLearningDate());
            educationSupport.setRemark(educationSupportUser.getRemark());
            baseMapper.insert(educationSupport);
        }
    }

    @Override
    public void updateEducationSupport(EducationSupportUpdateInputDTO educationSupportUpdateInputDTO) {
        EducationSupport educationSupport = MEducationSupportConvert.INSTANCE.toEducationSupport(educationSupportUpdateInputDTO);
        updateById(educationSupport);
    }

    @Override
    public EducationSupportListOutputDTO getDetail(Long id) {
        EducationSupport educationSupport = baseMapper.selectById(id);
        EducationSupportListOutputDTO educationSupportListOutputDTO = MEducationSupportConvert.INSTANCE.toList(educationSupport);
        return educationSupportListOutputDTO;
    }

    @Override
    public void delete(Long id) {
        baseMapper.deleteById(id);
    }

    @Override
    public PageResult<EducationSupport> getPageList(EducationSupportSearchInputDTO educationSupportSearchInputDTO) {
        return pageListByEntity(educationSupportSearchInputDTO);
    }

    @Override
    public List<EducationSupport> getList(EducationSupportInputDTO educationSupport) {
        LambdaQueryWrapper<EducationSupport> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.like(StrUtil.isNotBlank(educationSupport.getCorrectionUnit()), EducationSupport::getCorrectionUnit, educationSupport.getCorrectionUnit());
        queryWrapper.like(educationSupport.getCorrectionUnitId()!=null, EducationSupport::getCorrectionUnitId, educationSupport.getCorrectionUnitId());
        queryWrapper.like(StrUtil.isNotBlank(educationSupport.getUserName()), EducationSupport::getUserName, educationSupport.getUserName());
        queryWrapper.like(StrUtil.isNotBlank(educationSupport.getLearningDate()), EducationSupport::getLearningDate, educationSupport.getLearningDate());
        queryWrapper.like(StrUtil.isNotBlank(educationSupport.getBenchmarkScore()), EducationSupport::getBenchmarkScore, educationSupport.getBenchmarkScore());
        queryWrapper.like(StrUtil.isNotBlank(educationSupport.getEducationContent()), EducationSupport::getEducationContent, educationSupport.getEducationContent());
        queryWrapper.like(StrUtil.isNotBlank(educationSupport.getAffiliatedUnit()), EducationSupport::getAffiliatedUnit, educationSupport.getAffiliatedUnit());
        queryWrapper.like(StrUtil.isNotBlank(educationSupport.getRegistrationView()), EducationSupport::getRegistrationView, educationSupport.getRegistrationView());
        queryWrapper.like(StrUtil.isNotBlank(educationSupport.getScore()), EducationSupport::getScore, educationSupport.getScore());
        queryWrapper.like(StrUtil.isNotBlank(educationSupport.getRemark()), EducationSupport::getRemark, educationSupport.getRemark());
        queryWrapper.like(StrUtil.isNotBlank(educationSupport.getCreator()), EducationSupport::getCreator, educationSupport.getCreator());
        queryWrapper.like(StrUtil.isNotBlank(educationSupport.getUpdater()), EducationSupport::getUpdater, educationSupport.getUpdater());
        return baseMapper.selectList(queryWrapper);
    }
}
