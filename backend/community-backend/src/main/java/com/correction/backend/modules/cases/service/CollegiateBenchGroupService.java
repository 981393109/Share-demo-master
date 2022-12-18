package com.correction.backend.modules.cases.service;

import com.correction.backend.modules.cases.controller.dto.CollegiateBenchGroupCreateInputDTO;
import com.correction.backend.modules.cases.controller.dto.CollegiateBenchGroupUpdateInputDTO;
import com.correction.backend.modules.cases.entity.CollegiateBenchGroup;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 合议小组/评议小组/相关小组表 服务类
 * </p>
 *
 * @author yao
 * @since 2022-12-17
 */
public interface CollegiateBenchGroupService extends IService<CollegiateBenchGroup> {

    /**
     * 新增
     */
    CollegiateBenchGroup createCollegiateBenchGroup (CollegiateBenchGroupCreateInputDTO collegiateBenchGroupCreateInputDTO);

    /**
     * 新增合议小组
     */
    List<CollegiateBenchGroup> createCollegiateBenchGroup (List<CollegiateBenchGroup> result ,Long dataId,Integer type);

    /**
     * 修改
     */
    CollegiateBenchGroup updateCollegiateBenchGroup (CollegiateBenchGroupUpdateInputDTO updateInputDTO);

    /**
     * 获取列表
     */
    List<CollegiateBenchGroup> getList (Long dataId,Integer type);

    /**
     * 获取详情
     */
    CollegiateBenchGroup getDetail (Long id );

    /**
     * 删除
     */
    void delete (Long id );

}
