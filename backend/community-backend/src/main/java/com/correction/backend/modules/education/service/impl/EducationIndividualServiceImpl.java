package com.correction.backend.modules.education.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.correction.backend.modules.education.controller.dto.EducationIndividualCreateInputDTO;
import com.correction.backend.modules.education.controller.dto.EducationIndividualSearchInputDTO;
import com.correction.backend.modules.education.controller.dto.EducationIndividualUpdateInputDTO;
import com.correction.backend.modules.education.convert.MEducationIndividualConvert;
import com.correction.backend.modules.education.service.EducationIndividualService;
import com.correction.framework.common.pojo.PageResult;
import com.correction.backend.modules.education.entity.EducationIndividual;
import com.correction.backend.modules.education.mapper.EducationIndividualMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.correction.framework.web.web.core.util.WebFrameworkUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 个别教育 服务实现类
 * </p>
 *
 * @author yao
 * @since 2022-12-06
 */
@Service
public class EducationIndividualServiceImpl extends ServiceImpl<EducationIndividualMapper, EducationIndividual> implements EducationIndividualService {

    /**
     * 获取表格数据
     *
     * @param educationIndividual
     * @return
     */
    public PageResult<EducationIndividual> pageListByEntity(EducationIndividualSearchInputDTO educationIndividual) {
        LambdaQueryWrapper<EducationIndividual> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.like(StrUtil.isNotBlank(educationIndividual.getCorrectionUnit()), EducationIndividual::getCorrectionUnit, educationIndividual.getCorrectionUnit());
        queryWrapper.like(educationIndividual.getCorrectionUnitId()!=null, EducationIndividual::getCorrectionUnitId, educationIndividual.getCorrectionUnitId());
        queryWrapper.like(StrUtil.isNotBlank(educationIndividual.getUserName()), EducationIndividual::getUserName, educationIndividual.getUserName());
        queryWrapper.like(StrUtil.isNotBlank(educationIndividual.getTalkDate()), EducationIndividual::getTalkDate, educationIndividual.getTalkDate());
        queryWrapper.like(StrUtil.isNotBlank(educationIndividual.getTalkUser()), EducationIndividual::getTalkUser, educationIndividual.getTalkUser());
        queryWrapper.like(StrUtil.isNotBlank(educationIndividual.getRecordUser()), EducationIndividual::getRecordUser, educationIndividual.getRecordUser());
        queryWrapper.like(StrUtil.isNotBlank(educationIndividual.getTalkAddress()), EducationIndividual::getTalkAddress, educationIndividual.getTalkAddress());
        queryWrapper.like(StrUtil.isNotBlank(educationIndividual.getTalkContent()), EducationIndividual::getTalkContent, educationIndividual.getTalkContent());
        queryWrapper.like(StrUtil.isNotBlank(educationIndividual.getRemark()), EducationIndividual::getRemark, educationIndividual.getRemark());
        queryWrapper.like(StrUtil.isNotBlank(educationIndividual.getCreator()), EducationIndividual::getCreator, educationIndividual.getCreator());
        queryWrapper.like(StrUtil.isNotBlank(educationIndividual.getUpdater()), EducationIndividual::getUpdater, educationIndividual.getUpdater());
        return baseMapper.selectPage(educationIndividual, queryWrapper);
    }

    @Override
    public void createEducationIndividua(EducationIndividualCreateInputDTO createInputDTO) {
        EducationIndividual educationIndividual = MEducationIndividualConvert.INSTANCE.toEducationIndividual(createInputDTO);
        educationIndividual.setOrgNum(WebFrameworkUtils.getLoginOrgId());
        baseMapper.insert(educationIndividual);
    }

    @Override
    public void updateEducationIndividua(EducationIndividualUpdateInputDTO updateInputDTO) {
        EducationIndividual educationIndividual = MEducationIndividualConvert.INSTANCE.toEducationIndividual(updateInputDTO);
        baseMapper.updateById(educationIndividual);
    }

    @Override
    public EducationIndividual getDetail(Long id) {
        EducationIndividual educationIndividual = baseMapper.selectById(id);
        return educationIndividual;
    }

    @Override
    public void delete(Long id) {
        baseMapper.deleteById(id);
    }

    @Override
    public PageResult<EducationIndividual> getPageList(EducationIndividualSearchInputDTO searchInputDTO) {
        return pageListByEntity(searchInputDTO);
    }

    @Override
    public List<EducationIndividual> getList(EducationIndividualUpdateInputDTO educationIndividual) {
        LambdaQueryWrapper<EducationIndividual> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.like(StrUtil.isNotBlank(educationIndividual.getCorrectionUnit()), EducationIndividual::getCorrectionUnit, educationIndividual.getCorrectionUnit());
        queryWrapper.like(educationIndividual.getCorrectionUnitId() != null, EducationIndividual::getCorrectionUnitId, educationIndividual.getCorrectionUnitId());
        queryWrapper.like(StrUtil.isNotBlank(educationIndividual.getUserName()), EducationIndividual::getUserName, educationIndividual.getUserName());
        queryWrapper.like(StrUtil.isNotBlank(educationIndividual.getTalkDate()), EducationIndividual::getTalkDate, educationIndividual.getTalkDate());
        queryWrapper.like(StrUtil.isNotBlank(educationIndividual.getTalkUser()), EducationIndividual::getTalkUser, educationIndividual.getTalkUser());
        queryWrapper.like(StrUtil.isNotBlank(educationIndividual.getRecordUser()), EducationIndividual::getRecordUser, educationIndividual.getRecordUser());
        queryWrapper.like(StrUtil.isNotBlank(educationIndividual.getTalkAddress()), EducationIndividual::getTalkAddress, educationIndividual.getTalkAddress());
        queryWrapper.like(StrUtil.isNotBlank(educationIndividual.getTalkContent()), EducationIndividual::getTalkContent, educationIndividual.getTalkContent());
        queryWrapper.like(StrUtil.isNotBlank(educationIndividual.getRemark()), EducationIndividual::getRemark, educationIndividual.getRemark());
        queryWrapper.like(StrUtil.isNotBlank(educationIndividual.getCreator()), EducationIndividual::getCreator, educationIndividual.getCreator());
        queryWrapper.like(StrUtil.isNotBlank(educationIndividual.getUpdater()), EducationIndividual::getUpdater, educationIndividual.getUpdater());
        return baseMapper.selectList(queryWrapper);
    }
}
