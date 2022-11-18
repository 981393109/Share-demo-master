package com.correction.backend.modules.survey.service;

import com.correction.backend.modules.survey.controller.dto.SurveyEntrustUnitCreateInputDTO;
import com.correction.backend.modules.survey.controller.dto.SurveyEntrustUnitSearchInputDTO;
import com.correction.backend.modules.survey.controller.dto.SurveyEntrustUnitUpdateInputDTO;
import com.correction.backend.modules.survey.entity.SurveyEntrustUnit;
import com.baomidou.mybatisplus.extension.service.IService;
import com.correction.framework.common.pojo.PageResult;

import java.util.List;

/**
 * <p>
 * 委托单位表 服务类
 * </p>
 *
 * @author yao
 * @since 2022-11-17
 */
public interface SurveyEntrustUnitService extends IService<SurveyEntrustUnit> {

    /**
     * 新增委托单位
     */
    Long createSurveyEntrustUnit (SurveyEntrustUnitCreateInputDTO dto);

    /**
     * 修改委托单位
     */
    SurveyEntrustUnit updateSurveyEntrustUnit (SurveyEntrustUnitUpdateInputDTO dto);

    /**
     * 查看详情：
     */
    SurveyEntrustUnit get (Long id);

    /**
     * 删除
     */
    void delete (Long id );

    /**
     * 分页获取委托单位
     */
    PageResult<SurveyEntrustUnit> getPageList (SurveyEntrustUnitSearchInputDTO searchInputDTO);

    /**
     * 获取魏国单位列表
     * @param searchInputDTO
     * @return
     */
    List<SurveyEntrustUnit>  getList (SurveyEntrustUnitSearchInputDTO searchInputDTO);

}
