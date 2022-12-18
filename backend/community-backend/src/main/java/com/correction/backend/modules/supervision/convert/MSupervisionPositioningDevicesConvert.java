package com.correction.backend.modules.supervision.convert;

import com.correction.backend.modules.supervision.controller.dto.SupervisionPositioningDevicesCreateInputDTO;
import com.correction.backend.modules.supervision.controller.dto.SupervisionPositioningDevicesListOutputDTO;
import com.correction.backend.modules.supervision.controller.dto.SupervisionPositioningDevicesSearchInputDTO;
import com.correction.backend.modules.supervision.controller.dto.SupervisionPositioningDevicesUpdateInputDTO;
import com.correction.backend.modules.supervision.entity.SupervisionPositioningDevices;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Author：yao
 * @Description: 电子定位装置审批 转换类
 * @Date: 2022-12-03
 */

@Mapper
public interface MSupervisionPositioningDevicesConvert {

    MSupervisionPositioningDevicesConvert INSTANCE = Mappers.getMapper(MSupervisionPositioningDevicesConvert.class);

    SupervisionPositioningDevices toSupervisionPositioningDevices(SupervisionPositioningDevicesSearchInputDTO supervisionPositioningDevicesSearchInputDTO);

    SupervisionPositioningDevices toSupervisionPositioningDevices(SupervisionPositioningDevicesCreateInputDTO supervisionPositioningDevicesCreateInputDTO);

    SupervisionPositioningDevices toSupervisionPositioningDevices(SupervisionPositioningDevicesUpdateInputDTO supervisionPositioningDevicesUpdateInputDTO);

    SupervisionPositioningDevicesListOutputDTO toList(SupervisionPositioningDevices supervisionPositioningDevices);

    List<SupervisionPositioningDevicesListOutputDTO> toList(List<SupervisionPositioningDevices> supervisionPositioningDevicess);
}