package com.correction.backend.modules.handleCorrection.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.correction.backend.modules.handleCorrection.controller.dto.CorrectionUserCreateInputDTO;
import com.correction.backend.modules.handleCorrection.controller.dto.CorrectionUserSearchDTO;
import com.correction.backend.modules.handleCorrection.controller.dto.CorrectionUserSearchInputDTO;
import com.correction.backend.modules.handleCorrection.controller.dto.CorrectionUserUpdateInputDTO;
import com.correction.backend.modules.handleCorrection.convert.MCorrectionUserConvert;
import com.correction.backend.modules.handleCorrection.service.CorrectionUserService;
import com.correction.framework.common.pojo.PageResult;
import com.correction.framework.web.web.core.util.WebFrameworkUtils;
import com.correction.frameworks.mybatis.mybatis.core.util.MyBatisUtils;
import com.correction.backend.modules.handleCorrection.entity.CorrectionUser;
import com.correction.backend.modules.handleCorrection.mapper.CorrectionUserMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

import static com.correction.backend.modules.sys.enums.SysErrorCodeConstants.FLOW_DATA_ISEXSIT;
import static com.correction.backend.modules.sys.enums.SysErrorCodeConstants.USER_USERNAME_EXISTS;
import static com.correction.framework.common.exception.util.ServiceExceptionUtil.exception;

/**
 * <p>
 * 矫正人员 服务实现类
 * </p>
 *
 * @author yao
 * @since 2022-11-23
 */
@Service
public class CorrectionUserServiceImpl extends ServiceImpl<CorrectionUserMapper, CorrectionUser> implements CorrectionUserService {


    /**
     * 获取表格数据
     *
     * @param correctionUser
     * @return
     */
    public IPage<CorrectionUser> pageListByEntity(CorrectionUserSearchInputDTO correctionUser) {
        LambdaQueryWrapper<CorrectionUser> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.like(StrUtil.isNotBlank(correctionUser.getName()), CorrectionUser::getName, correctionUser.getName());
        queryWrapper.like(StrUtil.isNotBlank(correctionUser.getBirthday()), CorrectionUser::getBirthday, correctionUser.getBirthday());
        queryWrapper.like(StrUtil.isNotBlank(correctionUser.getHousehold()), CorrectionUser::getHousehold, correctionUser.getHousehold());
        queryWrapper.like(StrUtil.isNotBlank(correctionUser.getNativePlace()), CorrectionUser::getNativePlace, correctionUser.getNativePlace());
        queryWrapper.like(StrUtil.isNotBlank(correctionUser.getAddress()), CorrectionUser::getAddress, correctionUser.getAddress());
        queryWrapper.like(StrUtil.isNotBlank(correctionUser.getMobile()), CorrectionUser::getMobile, correctionUser.getMobile());
        queryWrapper.like(StrUtil.isNotBlank(correctionUser.getMaritalStatus()), CorrectionUser::getMaritalStatus, correctionUser.getMaritalStatus());
        queryWrapper.like(StrUtil.isNotBlank(correctionUser.getProfessional()), CorrectionUser::getProfessional, correctionUser.getProfessional());
        queryWrapper.like(StrUtil.isNotBlank(correctionUser.getEconomyState()), CorrectionUser::getEconomyState, correctionUser.getEconomyState());
        queryWrapper.like(StrUtil.isNotBlank(correctionUser.getAreaJurisdiction()), CorrectionUser::getAreaJurisdiction, correctionUser.getAreaJurisdiction());
        queryWrapper.like(StrUtil.isNotBlank(correctionUser.getStreetJurisdiction()), CorrectionUser::getStreetJurisdiction, correctionUser.getStreetJurisdiction());
        queryWrapper.like(StrUtil.isNotBlank(correctionUser.getCauseAction()), CorrectionUser::getCauseAction, correctionUser.getCauseAction());
        queryWrapper.like(StrUtil.isNotBlank(correctionUser.getOrgNum()), CorrectionUser::getOrgNum, correctionUser.getOrgNum());
        queryWrapper.like(StrUtil.isNotBlank(correctionUser.getCreator()), CorrectionUser::getCreator, correctionUser.getCreator());
        queryWrapper.like(StrUtil.isNotBlank(correctionUser.getUpdater()), CorrectionUser::getUpdater, correctionUser.getUpdater());
        IPage<CorrectionUser> mpPage = MyBatisUtils.buildPage(correctionUser);
        mpPage = page(mpPage,queryWrapper);
        return mpPage;
    }


    @Override
    public CorrectionUser createCorrectionUser(CorrectionUserCreateInputDTO reqDTO) {
        //校验该矫正申请下是否存在矫正档案信息
        checkCreateOrUpdate(reqDTO.getHandleCorrectionId(),null);
        CorrectionUser correctionUser = MCorrectionUserConvert.INSTANCE.toCorrectionUser(reqDTO);
        correctionUser.setOrgNum(WebFrameworkUtils.getLoginOrgNum());
        correctionUser.setIsHistory(0);
        baseMapper.insert(correctionUser);
        return correctionUser;
    }

    private void checkCreateOrUpdate(Long handleCorrectionId,Long id ) {
        CorrectionUser byCorrectionId = getByCorrectionId(handleCorrectionId);
        if(byCorrectionId == null){
            return;
        }
        if(!byCorrectionId.getId().equals(id)){
            throw exception(FLOW_DATA_ISEXSIT);
        }
    }

    @Override
    public CorrectionUser updateCorrectionUser(CorrectionUserUpdateInputDTO reqDTO) {
        checkCreateOrUpdate(reqDTO.getHandleCorrectionId(),reqDTO.getId());
        CorrectionUser correctionUser = MCorrectionUserConvert.INSTANCE.toCorrectionUser(reqDTO);
        baseMapper.updateById(correctionUser);
        return correctionUser;
    }

    @Override
    public CorrectionUser get(Long id) {
        CorrectionUser correctionUser = baseMapper.selectById(id);
        return correctionUser;
    }

    @Override
    public CorrectionUser getByCorrectionId(Long id) {
        List<CorrectionUser> correctionUsers = baseMapper.selectList(Wrappers.<CorrectionUser>lambdaQuery().eq(CorrectionUser::getHandleCorrectionId, id));
        if(CollectionUtils.isEmpty(correctionUsers)){
            return null;
        }
        return correctionUsers.get(0);
    }

    @Override
    public void delete(Long id) {
        baseMapper.deleteById(id);
    }

    @Override
    public PageResult<CorrectionUser> getPageList(CorrectionUserSearchInputDTO searchInputDTO) {
        IPage<CorrectionUser> correctionUserIPage = this.pageListByEntity(searchInputDTO);
        return new PageResult<>(correctionUserIPage.getRecords(), correctionUserIPage.getTotal());
    }

    @Override
    public List<CorrectionUser> getList(CorrectionUserSearchDTO correctionUser) {
        LambdaQueryWrapper<CorrectionUser> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.like(StrUtil.isNotBlank(correctionUser.getName()), CorrectionUser::getName, correctionUser.getName());
        queryWrapper.like(StrUtil.isNotBlank(correctionUser.getBirthday()), CorrectionUser::getBirthday, correctionUser.getBirthday());
        queryWrapper.like(StrUtil.isNotBlank(correctionUser.getHousehold()), CorrectionUser::getHousehold, correctionUser.getHousehold());
        queryWrapper.like(StrUtil.isNotBlank(correctionUser.getNativePlace()), CorrectionUser::getNativePlace, correctionUser.getNativePlace());
        queryWrapper.like(StrUtil.isNotBlank(correctionUser.getAddress()), CorrectionUser::getAddress, correctionUser.getAddress());
        queryWrapper.like(StrUtil.isNotBlank(correctionUser.getMobile()), CorrectionUser::getMobile, correctionUser.getMobile());
        queryWrapper.like(StrUtil.isNotBlank(correctionUser.getMaritalStatus()), CorrectionUser::getMaritalStatus, correctionUser.getMaritalStatus());
        queryWrapper.like(StrUtil.isNotBlank(correctionUser.getProfessional()), CorrectionUser::getProfessional, correctionUser.getProfessional());
        queryWrapper.like(StrUtil.isNotBlank(correctionUser.getEconomyState()), CorrectionUser::getEconomyState, correctionUser.getEconomyState());
        queryWrapper.like(StrUtil.isNotBlank(correctionUser.getAreaJurisdiction()), CorrectionUser::getAreaJurisdiction, correctionUser.getAreaJurisdiction());
        queryWrapper.like(StrUtil.isNotBlank(correctionUser.getStreetJurisdiction()), CorrectionUser::getStreetJurisdiction, correctionUser.getStreetJurisdiction());
        queryWrapper.like(StrUtil.isNotBlank(correctionUser.getCauseAction()), CorrectionUser::getCauseAction, correctionUser.getCauseAction());
        queryWrapper.like(StrUtil.isNotBlank(correctionUser.getOrgNum()), CorrectionUser::getOrgNum, correctionUser.getOrgNum());
        queryWrapper.like(StrUtil.isNotBlank(correctionUser.getCreator()), CorrectionUser::getCreator, correctionUser.getCreator());
        queryWrapper.like(StrUtil.isNotBlank(correctionUser.getUpdater()), CorrectionUser::getUpdater, correctionUser.getUpdater());
        List<CorrectionUser> correctionUsers = baseMapper.selectList(queryWrapper);
        return correctionUsers;
    }


}
