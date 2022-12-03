package com.correction.backend.modules.supervision.service;

import com.correction.backend.modules.supervision.controller.dto.SupervisionVisitFieldUpdateInputDTO;
import com.correction.backend.modules.supervision.controller.dto.SupervisionVisitGroupCreateInputDTO;
import com.correction.backend.modules.supervision.entity.SupervisionVisitGroup;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 走访小组 服务类
 * </p>
 *
 * @author yao
 * @since 2022-12-03
 */
public interface SupervisionVisitGroupService extends IService<SupervisionVisitGroup> {

    /**
     * 新增调查小组
     * @param createInputDTO
     * @param dataId
     */
    void createSupervisionVisitGroupList(List<SupervisionVisitGroupCreateInputDTO> createInputDTO,Long dataId);

    /**
     * 修改调查小组
     * @return
     */
    List<SupervisionVisitGroup> updateSupervisionVisitGroupList (List<SupervisionVisitGroupCreateInputDTO> updateInputDTOS, Long dataId);


    /**
     * 删除调查小组
     */
    void deleteByDataId(Long id);

    /**
     * 根据dataId获取集合
     */
    List<SupervisionVisitGroup> getListByDataId (Long dataId);
}
