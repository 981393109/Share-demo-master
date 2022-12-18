package com.correction.backend.modules.supervision.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.correction.backend.modules.supervision.controller.dto.*;
import com.correction.backend.modules.supervision.entity.SupervisionPositioningDevices;
import com.baomidou.mybatisplus.extension.service.IService;
import com.correction.framework.common.pojo.PageResult;

/**
 * <p>
 * 电子定位装置审批 服务类
 * </p>
 *
 * @author yao
 * @since 2022-12-03
 */
public interface SupervisionPositioningDevicesService extends IService<SupervisionPositioningDevices> {

    /**
     * 新增电子定位装置审批
     */
    SupervisionPositioningDevices createSupervisionPositiongDevices (SupervisionPositioningDevicesCreateInputDTO createInputDTO) throws Exception;


    /**
     * 修改电子定位装置审批
     */
    SupervisionPositioningDevices updateSupervisionPositiongDevices (SupervisionPositioningDevicesUpdateInputDTO updateInputDTO) throws Exception;


    /**
     * 修改电子定位装置审批
     */
    SupervisionPositioningDevices updateSupervisionPositiongDevices (SupervisionPositioningDevices supervisionPositioningDevices);


    /**
     * 获取电子定位装置审批详情
     */
    SupervisionPositioningDevices getDetail (Long id);

    /**
     * 获取详情
     */
    SupervisionPositioningDevicesDetailDTO getDetailById (Long id );



    /**
     * 删除
     */
    void delete (Long id );


    /**
     * 分页获取列表
     */
    IPage<SupervisionPositioningDevicesFlowDTO> getPageList (SupervisionPositioningDevicesSearchInputDTO searchInputDTO);

}
