package com.correction.backend.modules.handleCorrection.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.correction.backend.modules.handleCorrection.controller.dto.CorrectionGroupCreateInputDTO;
import com.correction.backend.modules.handleCorrection.controller.dto.CorrectionGroupSearchDTO;
import com.correction.backend.modules.handleCorrection.controller.dto.CorrectionGroupSearchInputDTO;
import com.correction.backend.modules.handleCorrection.controller.dto.CorrectionGroupUpdateInputDTO;
import com.correction.backend.modules.handleCorrection.convert.MCorrectionGroupConvert;
import com.correction.backend.modules.handleCorrection.entity.CorrectionUser;
import com.correction.backend.modules.handleCorrection.service.CorrectionGroupService;
import com.correction.framework.common.pojo.PageResult;
import com.correction.frameworks.mybatis.mybatis.core.util.MyBatisUtils;
import com.correction.backend.modules.handleCorrection.entity.CorrectionGroup;
import com.correction.backend.modules.handleCorrection.mapper.CorrectionGroupMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

import static com.correction.backend.modules.sys.enums.SysErrorCodeConstants.FLOW_DATA_ISEXSIT;
import static com.correction.framework.common.exception.util.ServiceExceptionUtil.exception;

/**
 * <p>
 * 矫正小组 服务实现类
 * </p>
 *
 * @author yao
 * @since 2022-11-23
 */
@Service
public class CorrectionGroupServiceImpl extends ServiceImpl<CorrectionGroupMapper, CorrectionGroup> implements CorrectionGroupService {

    /**
     * 获取表格数据
     *
     * @return
     */
    public IPage<CorrectionGroup> pageListByEntity(CorrectionGroupSearchInputDTO correctionGroup) {
        LambdaQueryWrapper<CorrectionGroup> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.like(StrUtil.isNotBlank(correctionGroup.getUserName()), CorrectionGroup::getUserName, correctionGroup.getUserName());
        queryWrapper.like(StrUtil.isNotBlank(correctionGroup.getCorrectionUnit()), CorrectionGroup::getCorrectionUnit, correctionGroup.getCorrectionUnit());
        queryWrapper.like(StrUtil.isNotBlank(correctionGroup.getUserType()), CorrectionGroup::getUserType, correctionGroup.getUserType());
        queryWrapper.like(StrUtil.isNotBlank(correctionGroup.getIdCard()), CorrectionGroup::getIdCard, correctionGroup.getIdCard());
        queryWrapper.like(StrUtil.isNotBlank(correctionGroup.getJob()), CorrectionGroup::getJob, correctionGroup.getJob());
        IPage<CorrectionGroup> mpPage = MyBatisUtils.buildPage(correctionGroup);
        mpPage = page(mpPage,queryWrapper);
        return mpPage;
    }

    @Override
    public CorrectionGroup createCorrectionGroup(CorrectionGroupCreateInputDTO reqDTO) {
        //校验该矫正申请下是否存在矫正档案信息
        //checkCreateOrUpdate(reqDTO.getHandleCorrectionId(),null);
        CorrectionGroup correctionGroup = MCorrectionGroupConvert.INSTANCE.toCorrectionGroup(reqDTO);
        baseMapper.insert(correctionGroup);
        return correctionGroup;
    }

    @Override
    public CorrectionGroup updateCorrectionGroup(CorrectionGroupUpdateInputDTO reqDTO) {
        //校验该矫正申请下是否存在矫正档案信息
        //checkCreateOrUpdate(reqDTO.getHandleCorrectionId(),reqDTO.getId());
        CorrectionGroup correctionGroup = MCorrectionGroupConvert.INSTANCE.toCorrectionGroup(reqDTO);
        baseMapper.updateById(correctionGroup);
        return correctionGroup;
    }

    private void checkCreateOrUpdate(Long handleCorrectionId,Long id ) {
        List<CorrectionGroup> byCorrectionId = getByCorrectionId(handleCorrectionId);
        if(byCorrectionId == null){
            return;
        }
        /*if(!byCorrectionId.getId().equals(id)){
            throw exception(FLOW_DATA_ISEXSIT);
        }*/
    }

    @Override
    public CorrectionGroup get(Long id) {
        CorrectionGroup correctionGroup = baseMapper.selectById(id);
        return correctionGroup;
    }

    @Override
    public List<CorrectionGroup> getByCorrectionId(Long id) {
        List<CorrectionGroup> correctionUsers = baseMapper.selectList(Wrappers.<CorrectionGroup>lambdaQuery().eq(CorrectionGroup::getHandleCorrectionId, id));
        if(CollectionUtils.isEmpty(correctionUsers)){
            return null;
        }
        return correctionUsers;
    }

    @Override
    public void delete(Long id) {
        baseMapper.deleteById(id);
    }

    @Override
    public PageResult<CorrectionGroup> getPageList(CorrectionGroupSearchInputDTO searchInputDTO) {
        IPage<CorrectionGroup> correctionGroupIPage = this.pageListByEntity(searchInputDTO);
        return new PageResult<>(correctionGroupIPage.getRecords(), correctionGroupIPage.getTotal());
    }

    @Override
    public List<CorrectionGroup> getList(CorrectionGroupSearchDTO correctionGroup) {
        LambdaQueryWrapper<CorrectionGroup> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.like(StrUtil.isNotBlank(correctionGroup.getUserName()), CorrectionGroup::getUserName, correctionGroup.getUserName());
        queryWrapper.like(StrUtil.isNotBlank(correctionGroup.getCorrectionUnit()), CorrectionGroup::getCorrectionUnit, correctionGroup.getCorrectionUnit());
        queryWrapper.like(StrUtil.isNotBlank(correctionGroup.getUserType()), CorrectionGroup::getUserType, correctionGroup.getUserType());
        queryWrapper.like(StrUtil.isNotBlank(correctionGroup.getIdCard()), CorrectionGroup::getIdCard, correctionGroup.getIdCard());
        queryWrapper.like(StrUtil.isNotBlank(correctionGroup.getJob()), CorrectionGroup::getJob, correctionGroup.getJob());
        return baseMapper.selectList(queryWrapper);
    }

    @Override
    public List<Long> batchCreate(List<CorrectionGroupUpdateInputDTO> reqDTO) {
        List<Long> idList = new ArrayList<>();
        for (CorrectionGroupUpdateInputDTO correctionGroupUpdateInputDTO : reqDTO) {
            CorrectionGroup correctionGroup = MCorrectionGroupConvert.INSTANCE.toCorrectionGroup(correctionGroupUpdateInputDTO);
            if(correctionGroupUpdateInputDTO.getId()!=null){
                baseMapper.updateById(correctionGroup);
            }else {
                baseMapper.insert(correctionGroup);
            }
            idList.add(correctionGroup.getId());
        }
        return idList;
    }
}
