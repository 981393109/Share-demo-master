package com.correction.backend.modules.supervision.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.correction.backend.modules.handleCorrection.mapper.HandleCorrectionMapper;
import com.correction.backend.modules.supervision.controller.dto.*;
import com.correction.backend.modules.supervision.convert.MSupervisionDailyReportConvert;
import com.correction.backend.modules.supervision.service.SupervisionDailyReportService;
import com.correction.backend.modules.supervision.entity.SupervisionDailyReport;
import com.correction.backend.modules.supervision.mapper.SupervisionDailyReportMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.correction.framework.common.pojo.PageResult;
import com.correction.framework.web.web.core.util.WebFrameworkUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 日常报道 服务实现类
 * </p>
 *
 * @author yao
 * @since 2022-12-02
 */
@Service
public class SupervisionDailyReportServiceImpl extends ServiceImpl<SupervisionDailyReportMapper, SupervisionDailyReport> implements SupervisionDailyReportService {

    @Resource
    HandleCorrectionMapper handleCorrectionMapper;


    /**
     * 获取表格数据
     *
     * @return
     */
    public PageResult<SupervisionDailyReport> pageListByEntity(SupervisionDailyReportSearchInputDTO supervisionDailyReport) {
        LambdaQueryWrapper<SupervisionDailyReport> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.like(StrUtil.isNotBlank(supervisionDailyReport.getCorrectionUnit()), SupervisionDailyReport::getCorrectionUnit, supervisionDailyReport.getCorrectionUnit());
        queryWrapper.eq(supervisionDailyReport.getCorrectionUnitId()!=null, SupervisionDailyReport::getCorrectionUnitId, supervisionDailyReport.getCorrectionUnitId());
        queryWrapper.like(StrUtil.isNotBlank(supervisionDailyReport.getRegistrationDate()), SupervisionDailyReport::getRegistrationDate, supervisionDailyReport.getRegistrationDate());
        queryWrapper.like(StrUtil.isNotBlank(supervisionDailyReport.getBenchmarkScore()), SupervisionDailyReport::getBenchmarkScore, supervisionDailyReport.getBenchmarkScore());
        queryWrapper.like(supervisionDailyReport.getUserId()!=null, SupervisionDailyReport::getUserId, supervisionDailyReport.getUserId());
        queryWrapper.like(StrUtil.isNotBlank(supervisionDailyReport.getUserName()), SupervisionDailyReport::getUserName, supervisionDailyReport.getUserName());
        queryWrapper.like(StrUtil.isNotBlank(supervisionDailyReport.getRegistrationView()), SupervisionDailyReport::getRegistrationView, supervisionDailyReport.getRegistrationView());
        queryWrapper.like(StrUtil.isNotBlank(supervisionDailyReport.getScore()), SupervisionDailyReport::getScore, supervisionDailyReport.getScore());
        queryWrapper.like(StrUtil.isNotBlank(supervisionDailyReport.getRemark()), SupervisionDailyReport::getRemark, supervisionDailyReport.getRemark());
        queryWrapper.like(StrUtil.isNotBlank(supervisionDailyReport.getCreator()), SupervisionDailyReport::getCreator, supervisionDailyReport.getCreator());
        queryWrapper.like(StrUtil.isNotBlank(supervisionDailyReport.getUpdater()), SupervisionDailyReport::getUpdater, supervisionDailyReport.getUpdater());
        queryWrapper.in(!CollectionUtils.isEmpty(supervisionDailyReport.getOrgIds()),SupervisionDailyReport::getOrgNum,supervisionDailyReport.getOrgIds());
        PageResult<SupervisionDailyReport> supervisionDailyReportPageResult = baseMapper.selectPage(supervisionDailyReport, queryWrapper);
        return supervisionDailyReportPageResult;
    }


    @Override
    public void createSupervisionDailyReport(SupervisionDailyReportUserDTO supervisionDailyReportUserDTO) {
        SupervisionDailyReport supervisionDailyReport = new SupervisionDailyReport();
        supervisionDailyReport.setOrgNum(WebFrameworkUtils.getLoginOrgId());
        List<SupervisionDailyReportUser> userList = supervisionDailyReportUserDTO.getUserList();
        for (SupervisionDailyReportUser supervisionDailyReportUser : userList) {
            supervisionDailyReport.setUserId(supervisionDailyReportUser.getUserId());
            supervisionDailyReport.setUserName(supervisionDailyReportUser.getUserName());
            supervisionDailyReport.setCorrectionUnit(supervisionDailyReportUserDTO.getCorrectionUnit());
            supervisionDailyReport.setCorrectionUnitId(supervisionDailyReportUserDTO.getCorrectionUnitId());
            supervisionDailyReport.setScore(supervisionDailyReportUser.getScore());
            supervisionDailyReport.setBenchmarkScore(supervisionDailyReportUserDTO.getBenchmarkScore());
            supervisionDailyReport.setRegistrationView(supervisionDailyReportUser.getRegistrationView());
            supervisionDailyReport.setRegistrationDate(supervisionDailyReportUserDTO.getRegistrationDate());
            supervisionDailyReport.setRegistrationWay(supervisionDailyReportUserDTO.getRegistrationWay());
            supervisionDailyReport.setRemark(supervisionDailyReportUser.getRemark());
            baseMapper.insert(supervisionDailyReport);
        }
    }

    @Override
    public SupervisionDailyReport updateSupervisionDailyReport(SupervisionDailyReportUpdateInputDTO updateInputDTO) {
        SupervisionDailyReport supervisionDailyReport = MSupervisionDailyReportConvert.INSTANCE.toSupervisionDailyReport(updateInputDTO);
        updateById(supervisionDailyReport);
        return supervisionDailyReport;
    }

    @Override
    public SupervisionDailyReport getDetail(Long id) {
        return baseMapper.selectById(id);
    }

    @Override
    public void delete(Long id) {
        baseMapper.deleteById(id);
    }

    @Override
    public List<SupervisionDailyReport> getList(SupervisionDailyReportListDTO supervisionDailyReport) {
        LambdaQueryWrapper<SupervisionDailyReport> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.like(StrUtil.isNotBlank(supervisionDailyReport.getCorrectionUnit()), SupervisionDailyReport::getCorrectionUnit, supervisionDailyReport.getCorrectionUnit());
        queryWrapper.like(supervisionDailyReport.getCorrectionUnitId()!=null, SupervisionDailyReport::getCorrectionUnitId, supervisionDailyReport.getCorrectionUnitId());
        queryWrapper.like(StrUtil.isNotBlank(supervisionDailyReport.getRegistrationDate()), SupervisionDailyReport::getRegistrationDate, supervisionDailyReport.getRegistrationDate());
        queryWrapper.like(StrUtil.isNotBlank(supervisionDailyReport.getBenchmarkScore()), SupervisionDailyReport::getBenchmarkScore, supervisionDailyReport.getBenchmarkScore());
        queryWrapper.like(supervisionDailyReport.getUserId()!=null, SupervisionDailyReport::getUserId, supervisionDailyReport.getUserId());
        queryWrapper.like(StrUtil.isNotBlank(supervisionDailyReport.getUserName()), SupervisionDailyReport::getUserName, supervisionDailyReport.getUserName());
        queryWrapper.like(StrUtil.isNotBlank(supervisionDailyReport.getRegistrationView()), SupervisionDailyReport::getRegistrationView, supervisionDailyReport.getRegistrationView());
        queryWrapper.like(StrUtil.isNotBlank(supervisionDailyReport.getScore()), SupervisionDailyReport::getScore, supervisionDailyReport.getScore());
        queryWrapper.like(StrUtil.isNotBlank(supervisionDailyReport.getRemark()), SupervisionDailyReport::getRemark, supervisionDailyReport.getRemark());
        queryWrapper.like(StrUtil.isNotBlank(supervisionDailyReport.getCreator()), SupervisionDailyReport::getCreator, supervisionDailyReport.getCreator());
        queryWrapper.like(StrUtil.isNotBlank(supervisionDailyReport.getUpdater()), SupervisionDailyReport::getUpdater, supervisionDailyReport.getUpdater());
        return baseMapper.selectList(queryWrapper);
    }

    @Override
    public PageResult<SupervisionDailyReport> getPageList(SupervisionDailyReportSearchInputDTO searchInputDTO) {
        searchInputDTO.setOrgIds(WebFrameworkUtils.getLoginOrgIdsList());
        PageResult<SupervisionDailyReport> supervisionDailyReportPageResult = this.pageListByEntity(searchInputDTO);
        return supervisionDailyReportPageResult;
    }


}
