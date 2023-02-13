package com.correction.backend.modules.survey.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.correction.backend.modules.survey.controller.dto.SurveyEntrustUnitCreateInputDTO;
import com.correction.backend.modules.survey.controller.dto.SurveyEntrustUnitSearchInputDTO;
import com.correction.backend.modules.survey.controller.dto.SurveyEntrustUnitUpdateInputDTO;
import com.correction.backend.modules.survey.convert.MSurveyEntrustUnitConvert;
import com.correction.backend.modules.survey.service.SurveyEntrustUnitService;
import com.correction.backend.modules.survey.entity.SurveyEntrustUnit;
import com.correction.backend.modules.survey.mapper.SurveyEntrustUnitMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.correction.backend.modules.sys.entity.SysUserDO;
import com.correction.framework.common.pojo.PageResult;
import com.correction.framework.web.web.core.util.WebFrameworkUtils;
import com.google.common.annotations.VisibleForTesting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

import static com.correction.backend.modules.sys.enums.SysErrorCodeConstants.SURVEY_UNIT_NAME_UNITQUE;
import static com.correction.backend.modules.sys.enums.SysErrorCodeConstants.USER_USERNAME_EXISTS;
import static com.correction.framework.common.exception.util.ServiceExceptionUtil.exception;

/**
 * <p>
 * 委托单位表 服务实现类
 * </p>
 *
 * @author yao
 * @since 2022-11-17
 */
@Service
public class SurveyEntrustUnitServiceImpl extends ServiceImpl<SurveyEntrustUnitMapper, SurveyEntrustUnit> implements SurveyEntrustUnitService {


    @Override
    public Long createSurveyEntrustUnit(SurveyEntrustUnitCreateInputDTO dto) {
        //校验
        checkCreateOrUpdate(null,dto.getUnitName());
        SurveyEntrustUnit surveyEntrustUnit = MSurveyEntrustUnitConvert.INSTANCE.toSurveyEntrustUnit(dto);
        surveyEntrustUnit.setOrgNum(WebFrameworkUtils.getLoginOrgId());
        surveyEntrustUnit.setUnitName(surveyEntrustUnit.getUnitName().trim());
        surveyEntrustUnit.setUnitAddress(surveyEntrustUnit.getUnitAddress().trim());
        baseMapper.insert(surveyEntrustUnit);
        return surveyEntrustUnit.getId();
    }

    @Override
    public SurveyEntrustUnit updateSurveyEntrustUnit(SurveyEntrustUnitUpdateInputDTO dto) {
        checkCreateOrUpdate(dto.getId(),dto.getUnitName());
        SurveyEntrustUnit surveyEntrustUnit = MSurveyEntrustUnitConvert.INSTANCE.toSurveyEntrustUnit(dto);
        baseMapper.updateById(surveyEntrustUnit);
        return surveyEntrustUnit;
    }

    @Override
    public SurveyEntrustUnit get(Long id) {
        SurveyEntrustUnit surveyEntrustUnit = baseMapper.selectById(id);
        return surveyEntrustUnit;
    }

    @Override
    public void delete(Long id) {
        int i = baseMapper.deleteById(id);
    }

    @Override
    public PageResult<SurveyEntrustUnit> getPageList(SurveyEntrustUnitSearchInputDTO searchInputDTO) {
        searchInputDTO.setOrgIds(WebFrameworkUtils.getLoginOrgIdsList());
        return baseMapper.getPageList(searchInputDTO);
    }

    @Override
    public List<SurveyEntrustUnit> getList(SurveyEntrustUnitSearchInputDTO searchInputDTO) {
        searchInputDTO.setOrgIds(WebFrameworkUtils.getLoginOrgIdsList());
        return baseMapper.selectList(Wrappers.<SurveyEntrustUnit>lambdaQuery()
                .eq(searchInputDTO.getOrgNum()!=null ,SurveyEntrustUnit::getOrgNum,searchInputDTO.getOrgNum())
                .eq(searchInputDTO.getUnitType() !=null,SurveyEntrustUnit::getUnitType,searchInputDTO.getUnitType())
                .eq(SurveyEntrustUnit::getDeleted,0)
                .like(StringUtils.isNotBlank(searchInputDTO.getUnitName()),SurveyEntrustUnit::getUnitName,searchInputDTO.getUnitName())
                .in(!CollectionUtils.isEmpty(searchInputDTO.getOrgIds()),SurveyEntrustUnit::getOrgNum,searchInputDTO.getOrgIds())
                .orderByDesc(SurveyEntrustUnit::getId));
    }

    private void checkCreateOrUpdate(Long id, String name) {
        checkNameUnique(id,name);
    }

    @VisibleForTesting
    void checkNameUnique(Long id, String name) {
        if (StrUtil.isBlank(name)) {
            return;
        }
        SurveyEntrustUnit surveyEntrustUnit = baseMapper.selectOne("unit_name",name.trim());
        if (surveyEntrustUnit == null) {
            return;
        }
        // 如果 id 为空，说明不用比较是否为相同 id 的用户
        if (id == null) {
            throw exception(SURVEY_UNIT_NAME_UNITQUE);
        }
        if (!surveyEntrustUnit.getId().equals(id)) {
            throw exception(SURVEY_UNIT_NAME_UNITQUE);
        }
    }


}
