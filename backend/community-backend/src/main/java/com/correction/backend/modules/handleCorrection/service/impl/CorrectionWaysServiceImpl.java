package com.correction.backend.modules.handleCorrection.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.correction.backend.modules.handleCorrection.controller.dto.*;
import com.correction.backend.modules.handleCorrection.convert.MCorrectionUserConvert;
import com.correction.backend.modules.handleCorrection.convert.MCorrectionWaysConvert;
import com.correction.backend.modules.handleCorrection.service.CorrectionGroupService;
import com.correction.backend.modules.handleCorrection.service.CorrectionUserService;
import com.correction.backend.modules.handleCorrection.service.CorrectionWaysService;
import com.correction.framework.common.pojo.PageResult;
import com.correction.framework.web.web.core.util.WebFrameworkUtils;
import com.correction.frameworks.mybatis.mybatis.core.util.MyBatisUtils;
import com.correction.backend.modules.handleCorrection.entity.CorrectionWays;
import com.correction.backend.modules.handleCorrection.mapper.CorrectionWaysMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

import static com.correction.backend.modules.sys.enums.SysErrorCodeConstants.FLOW_DATA_ISEXSIT;
import static com.correction.framework.common.exception.util.ServiceExceptionUtil.exception;

/**
 * <p>
 * 矫正方案 服务实现类
 * </p>
 *
 * @author yao
 * @since 2022-11-23
 */
@Service
public class CorrectionWaysServiceImpl extends ServiceImpl<CorrectionWaysMapper, CorrectionWays> implements CorrectionWaysService {

    @Resource
    private CorrectionGroupService correctionGroupService;

    /**
     * 获取表格数据
     *
     * @return
     */
    public IPage<CorrectionWays> pageListByEntity(CorrectionWaysSearchInputDTO correctionWays) {
        LambdaQueryWrapper<CorrectionWays> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.like(StrUtil.isNotBlank(correctionWays.getCorrectionUnit()), CorrectionWays::getCorrectionUnit, correctionWays.getCorrectionUnit());
        queryWrapper.like(StrUtil.isNotBlank(correctionWays.getSentenceUser()), CorrectionWays::getSentenceUser, correctionWays.getSentenceUser());
        queryWrapper.like(StrUtil.isNotBlank(correctionWays.getWaysDate()), CorrectionWays::getWaysDate, correctionWays.getWaysDate());
        queryWrapper.like(StrUtil.isNotBlank(correctionWays.getAnalysisSituation()), CorrectionWays::getAnalysisSituation, correctionWays.getAnalysisSituation());
        queryWrapper.like(StrUtil.isNotBlank(correctionWays.getCorrectionOpinion()), CorrectionWays::getCorrectionOpinion, correctionWays.getCorrectionOpinion());
        queryWrapper.like(StrUtil.isNotBlank(correctionWays.getRemark()), CorrectionWays::getRemark, correctionWays.getRemark());
        queryWrapper.like(StrUtil.isNotBlank(correctionWays.getOrgNum()), CorrectionWays::getOrgNum, correctionWays.getOrgNum());
        queryWrapper.like(StrUtil.isNotBlank(correctionWays.getCreator()), CorrectionWays::getCreator, correctionWays.getCreator());
        queryWrapper.like(StrUtil.isNotBlank(correctionWays.getUpdater()), CorrectionWays::getUpdater, correctionWays.getUpdater());
        IPage<CorrectionWays> mpPage = MyBatisUtils.buildPage(correctionWays);
        mpPage = page(mpPage,queryWrapper);
        return mpPage;
    }

    @Override
    public CorrectionWays createCorrectionWays(CorrectionWaysCreateInputDTO reqDTO) {
        checkCreateOrUpdate(reqDTO.getHandleCorrectionId(),null);
        CorrectionWays correctionWays = MCorrectionWaysConvert.INSTANCE.toCorrectionWays(reqDTO);
        correctionWays.setOrgNum(WebFrameworkUtils.getLoginOrgNum());
        baseMapper.insert(correctionWays);
        return correctionWays;
    }

    @Override
    public CorrectionWays updateCorrectionWays(CorrectionWaysUpdateInputDTO reqDTO) {
        checkCreateOrUpdate(reqDTO.getHandleCorrectionId(),reqDTO.getId());
        CorrectionWays correctionWays = MCorrectionWaysConvert.INSTANCE.toCorrectionWays(reqDTO);
        baseMapper.updateById(correctionWays);
        return correctionWays;
    }

    private void checkCreateOrUpdate(Long handleCorrectionId,Long id ) {
        CorrectionWays byCorrectionId = getByCorrectionId(handleCorrectionId);
        if(byCorrectionId == null){
            return;
        }
        if(!byCorrectionId.getId().equals(id)){
            throw exception(FLOW_DATA_ISEXSIT);
        }
    }

    @Override
    public CorrectionWays get(Long id) {
        CorrectionWays correctionWays = baseMapper.selectById(id);
        return correctionWays;
    }

    @Override
    public CorrectionWays getByCorrectionId(Long id) {
        List<CorrectionWays> correctionWays = baseMapper.selectList(Wrappers.<CorrectionWays>lambdaQuery().eq(CorrectionWays::getHandleCorrectionId, id));
        if(CollectionUtils.isEmpty(correctionWays)){
            return null;
        }
        return correctionWays.get(0);
    }

    @Override
    public void delete(Long id) {
        baseMapper.deleteById(id);
    }

    @Override
    public PageResult<CorrectionWays> getPageList(CorrectionWaysSearchInputDTO searchInputDTO) {
        IPage<CorrectionWays> correctionWaysIPage = this.pageListByEntity(searchInputDTO);
        return new PageResult<>(correctionWaysIPage.getRecords(), correctionWaysIPage.getTotal());
    }

    @Override
    public List<CorrectionWays> getList(CorrectionWaysSearchDTO correctionWays) {
        LambdaQueryWrapper<CorrectionWays> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.like(StrUtil.isNotBlank(correctionWays.getCorrectionUnit()), CorrectionWays::getCorrectionUnit, correctionWays.getCorrectionUnit());
        queryWrapper.like(StrUtil.isNotBlank(correctionWays.getSentenceUser()), CorrectionWays::getSentenceUser, correctionWays.getSentenceUser());
        queryWrapper.like(StrUtil.isNotBlank(correctionWays.getWaysDate()), CorrectionWays::getWaysDate, correctionWays.getWaysDate());
        queryWrapper.like(StrUtil.isNotBlank(correctionWays.getAnalysisSituation()), CorrectionWays::getAnalysisSituation, correctionWays.getAnalysisSituation());
        queryWrapper.like(StrUtil.isNotBlank(correctionWays.getCorrectionOpinion()), CorrectionWays::getCorrectionOpinion, correctionWays.getCorrectionOpinion());
        queryWrapper.like(StrUtil.isNotBlank(correctionWays.getRemark()), CorrectionWays::getRemark, correctionWays.getRemark());
        queryWrapper.like(StrUtil.isNotBlank(correctionWays.getOrgNum()), CorrectionWays::getOrgNum, correctionWays.getOrgNum());
        queryWrapper.like(StrUtil.isNotBlank(correctionWays.getCreator()), CorrectionWays::getCreator, correctionWays.getCreator());
        queryWrapper.like(StrUtil.isNotBlank(correctionWays.getUpdater()), CorrectionWays::getUpdater, correctionWays.getUpdater());
        List<CorrectionWays> correctionWaysList = baseMapper.selectList(queryWrapper);
        return correctionWaysList;
    }

    @Override
    public CorrectionWaysGroupOutDTO createAndGroup(CorrectionWaysAndGroupCreate reqDTO) {
        CorrectionWaysUpdateInputDTO correctionWays = reqDTO.getCorrectionWays();
        List<CorrectionGroupUpdateInputDTO> correctionUsers = reqDTO.getCorrectionUsers();
        CorrectionWays correctionWays1 = MCorrectionWaysConvert.INSTANCE.toCorrectionWays(correctionWays);
        if(correctionWays.getId()!=null){
            baseMapper.updateById(correctionWays1);
        } else {
            baseMapper.insert(correctionWays1);
        }
        List<Long> longs = correctionGroupService.batchCreate(correctionUsers);
        CorrectionWaysGroupOutDTO returnDTO = new CorrectionWaysGroupOutDTO();
        returnDTO.setCorrectionWays(MCorrectionWaysConvert.INSTANCE.toList(correctionWays1));
        returnDTO.setCorrectionGroupId(longs);
        return returnDTO;
    }
}
