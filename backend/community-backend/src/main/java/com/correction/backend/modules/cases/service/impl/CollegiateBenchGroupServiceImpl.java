package com.correction.backend.modules.cases.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.correction.backend.modules.cases.controller.dto.CollegiateBenchGroupCreateInputDTO;
import com.correction.backend.modules.cases.controller.dto.CollegiateBenchGroupSearchInputDTO;
import com.correction.backend.modules.cases.controller.dto.CollegiateBenchGroupUpdateInputDTO;
import com.correction.backend.modules.cases.convert.MCollegiateBenchGroupConvert;
import com.correction.backend.modules.cases.service.CollegiateBenchGroupService;
import com.correction.framework.common.pojo.PageResult;
import com.correction.backend.modules.cases.entity.CollegiateBenchGroup;
import com.correction.backend.modules.cases.mapper.CollegiateBenchGroupMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.bcel.generic.DADD;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * <p>
 * 合议小组/评议小组/相关小组表 服务实现类
 * </p>
 *
 * @author yao
 * @since 2022-12-17
 */
@Service
public class CollegiateBenchGroupServiceImpl extends ServiceImpl<CollegiateBenchGroupMapper, CollegiateBenchGroup> implements CollegiateBenchGroupService {

    /**
     * 获取表格数据
     *
     * @param collegiateBenchGroup
     * @return
     */
    public PageResult<CollegiateBenchGroup> pageListByEntity(CollegiateBenchGroupSearchInputDTO collegiateBenchGroup) {
        LambdaQueryWrapper<CollegiateBenchGroup> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.like(StrUtil.isNotBlank(collegiateBenchGroup.getCorrectionUnit()), CollegiateBenchGroup::getCorrectionUnit, collegiateBenchGroup.getCorrectionUnit());
        queryWrapper.like(StrUtil.isNotBlank(collegiateBenchGroup.getUserName()), CollegiateBenchGroup::getUserName, collegiateBenchGroup.getUserName());
        queryWrapper.like(StrUtil.isNotBlank(collegiateBenchGroup.getUserType()), CollegiateBenchGroup::getUserType, collegiateBenchGroup.getUserType());
        queryWrapper.like(StrUtil.isNotBlank(collegiateBenchGroup.getIdCard()), CollegiateBenchGroup::getIdCard, collegiateBenchGroup.getIdCard());
        queryWrapper.like(StrUtil.isNotBlank(collegiateBenchGroup.getJob()), CollegiateBenchGroup::getJob, collegiateBenchGroup.getJob());
        return baseMapper.selectPage(collegiateBenchGroup,queryWrapper);
    }

    @Override
    public CollegiateBenchGroup createCollegiateBenchGroup(CollegiateBenchGroupCreateInputDTO collegiateBenchGroupCreateInputDTO) {
        CollegiateBenchGroup collegiateBenchGroup = MCollegiateBenchGroupConvert.INSTANCE.toCollegiateBenchGroup(collegiateBenchGroupCreateInputDTO);
        baseMapper.insert(collegiateBenchGroup);
        return collegiateBenchGroup;
    }

    @Override
    public List<CollegiateBenchGroup> createCollegiateBenchGroup(List<CollegiateBenchGroup> result, Long dataId, Integer type) {
        //删除：
        List<CollegiateBenchGroup> list = getList(dataId, type);
        if(!CollectionUtils.isEmpty(list)){
            list.forEach(e-> {
                baseMapper.deleteById(e.getId());
            });
        }
        //新增
        result.forEach(e -> {
            e.setDataId(dataId);
            e.setType(type);
            baseMapper.insert(e);
        });
        return result;
    }

    @Override
    public CollegiateBenchGroup updateCollegiateBenchGroup(CollegiateBenchGroupUpdateInputDTO updateInputDTO) {
        CollegiateBenchGroup collegiateBenchGroup = MCollegiateBenchGroupConvert.INSTANCE.toCollegiateBenchGroup(updateInputDTO);
        baseMapper.updateById(collegiateBenchGroup);
        return collegiateBenchGroup;
    }

    @Override
    public List<CollegiateBenchGroup> getList(Long dataId, Integer type) {
        List<CollegiateBenchGroup> collegiateBenchGroups = baseMapper.selectList(Wrappers.<CollegiateBenchGroup>lambdaQuery().eq(CollegiateBenchGroup::getDataId, dataId).eq(CollegiateBenchGroup::getType, type));
        return collegiateBenchGroups;
    }

    @Override
    public CollegiateBenchGroup getDetail(Long id) {
        CollegiateBenchGroup collegiateBenchGroup = baseMapper.selectById(id);
        return collegiateBenchGroup;
    }

    @Override
    public void delete(Long id) {
        baseMapper.deleteById(id);
    }

}
