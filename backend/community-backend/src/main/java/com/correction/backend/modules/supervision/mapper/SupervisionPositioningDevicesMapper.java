package com.correction.backend.modules.supervision.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.correction.backend.modules.supervision.controller.dto.SupervisionPositioningDevicesFlowDTO;
import com.correction.backend.modules.supervision.controller.dto.SupervisionPositioningDevicesSearchInputDTO;
import com.correction.backend.modules.supervision.entity.SupervisionPositioningDevices;
import com.correction.frameworks.mybatis.mybatis.core.mapper.BaseMapperX;
import org.apache.ibatis.annotations.Param;
//import com.baomidou.mybatisplus.core.mapper.BaseMapperX;

/**
 * <p>
 * 电子定位装置审批 Mapper 接口
 * </p>
 *
 * @author yao
 * @since 2022-12-03
 */
public interface SupervisionPositioningDevicesMapper extends BaseMapperX<SupervisionPositioningDevices> {

    IPage<SupervisionPositioningDevicesFlowDTO> getPageList(@Param("page") IPage<SupervisionPositioningDevicesFlowDTO> page,@Param("query") SupervisionPositioningDevicesSearchInputDTO query);

    IPage<SupervisionPositioningDevicesFlowDTO> getPageAllList(@Param("page") IPage<SupervisionPositioningDevicesFlowDTO> page,@Param("query") SupervisionPositioningDevicesSearchInputDTO query);
}
