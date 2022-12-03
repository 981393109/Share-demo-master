package com.correction.backend.modules.supervision.service;

import com.correction.backend.modules.supervision.controller.dto.SupervisionVisitFieldCreateInputDTO;
import com.correction.backend.modules.supervision.controller.dto.SupervisionVisitFieldDTO;
import com.correction.backend.modules.supervision.controller.dto.SupervisionVisitFieldSearchInputDTO;
import com.correction.backend.modules.supervision.controller.dto.SupervisionVisitFieldUpdateInputDTO;
import com.correction.backend.modules.supervision.entity.SupervisionVisitField;
import com.baomidou.mybatisplus.extension.service.IService;
import com.correction.framework.common.pojo.PageResult;

/**
 * <p>
 * 查访登记 服务类
 * </p>
 *
 * @author yao
 * @since 2022-12-03
 */
public interface SupervisionVisitFieldService extends IService<SupervisionVisitField> {

    /**
     * 创建查访登记
     */
    SupervisionVisitField createSupervisionVisitField (SupervisionVisitFieldCreateInputDTO createInputDTO);

    /**
     * 修改查访登记
     */
    SupervisionVisitField updateSupervisionVisitField (SupervisionVisitFieldUpdateInputDTO updateInputDTO);

    /**
     * 获取详情
     */
    SupervisionVisitField getDetail (Long id);

    /**
     * 获取详情
     */
    SupervisionVisitFieldDTO getDetailDTO (Long id);

    /**
     * 删除
     */
    void delete (Long id );

    /**
     * 分页获取列表
     */
    PageResult<SupervisionVisitField> getPageList (SupervisionVisitFieldSearchInputDTO searchInputDTO);

}
