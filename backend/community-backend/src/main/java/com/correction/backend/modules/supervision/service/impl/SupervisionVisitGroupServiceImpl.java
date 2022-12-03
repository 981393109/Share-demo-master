package com.correction.backend.modules.supervision.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.correction.backend.modules.supervision.controller.dto.SupervisionVisitFieldUpdateInputDTO;
import com.correction.backend.modules.supervision.controller.dto.SupervisionVisitGroupCreateInputDTO;
import com.correction.backend.modules.supervision.convert.MSupervisionVisitGroupConvert;
import com.correction.backend.modules.supervision.service.SupervisionVisitGroupService;
import com.correction.backend.modules.supervision.entity.SupervisionVisitGroup;
import com.correction.backend.modules.supervision.mapper.SupervisionVisitGroupMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 走访小组 服务实现类
 * </p>
 *
 * @author yao
 * @since 2022-12-03
 */
@Service
public class SupervisionVisitGroupServiceImpl extends ServiceImpl<SupervisionVisitGroupMapper, SupervisionVisitGroup> implements SupervisionVisitGroupService {



    @Override
    public void createSupervisionVisitGroupList(List<SupervisionVisitGroupCreateInputDTO> createInputDTO, Long dataId) {
        List<SupervisionVisitGroup> supervisionVisitGroups = MSupervisionVisitGroupConvert.INSTANCE.toVisitGroup(createInputDTO);
        for (SupervisionVisitGroup supervisionVisitGroup : supervisionVisitGroups) {
            supervisionVisitGroup.setDataId(dataId);
            baseMapper.insert(supervisionVisitGroup);
        }
    }

    @Override
    public List<SupervisionVisitGroup> updateSupervisionVisitGroupList(List<SupervisionVisitGroupCreateInputDTO> createInputDTO, Long dataId) {
        this.deleteByDataId(dataId);
        List<SupervisionVisitGroup> supervisionVisitGroups = MSupervisionVisitGroupConvert.INSTANCE.toVisitGroup(createInputDTO);
        for (SupervisionVisitGroup supervisionVisitGroup : supervisionVisitGroups) {
            supervisionVisitGroup.setDataId(dataId);
            baseMapper.insert(supervisionVisitGroup);
        }
        return supervisionVisitGroups;
    }

    @Override
    public void deleteByDataId(Long id) {
        baseMapper.deleteByDataId(id);
    }

    @Override
    public List<SupervisionVisitGroup> getListByDataId(Long dataId) {
        List<SupervisionVisitGroup> supervisionVisitGroups = baseMapper.selectList(Wrappers.<SupervisionVisitGroup>lambdaQuery().eq(SupervisionVisitGroup::getDataId, dataId));
        return supervisionVisitGroups;
    }


    /**
     * 获取表格数据
     *
     * @param supervisionVisitGroup
     * @param pageModel
     * @return
     */
    /*public IPage<SupervisionVisitGroup> pageListByEntity(SupervisionVisitGroup supervisionVisitGroup, PageModel pageModel) {
        LambdaQueryWrapper<SupervisionVisitGroup> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.like(StrUtil.isNotBlank(supervisionVisitGroup.getCorrectionUnit()), SupervisionVisitGroup::getCorrectionUnit, supervisionVisitGroup.getCorrectionUnit());
        queryWrapper.like(StrUtil.isNotBlank(supervisionVisitGroup.getUserName()), SupervisionVisitGroup::getUserName, supervisionVisitGroup.getUserName());
        queryWrapper.like(StrUtil.isNotBlank(supervisionVisitGroup.getUserType()), SupervisionVisitGroup::getUserType, supervisionVisitGroup.getUserType());
        queryWrapper.like(StrUtil.isNotBlank(supervisionVisitGroup.getIdCard()), SupervisionVisitGroup::getIdCard, supervisionVisitGroup.getIdCard());
        queryWrapper.like(StrUtil.isNotBlank(supervisionVisitGroup.getJob()), SupervisionVisitGroup::getJob, supervisionVisitGroup.getJob());
        return super.page(pageModel, queryWrapper);
    }*/





}
