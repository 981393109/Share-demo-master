package com.correction.backend.modules.supervision.controller.dto;

import com.correction.backend.modules.flow.controller.dto.FlowNodeUserCreateInputDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SupervisionPositioningStartFlowDTO {

    @ApiModelProperty(value = "详情信息")
    SupervisionPositioningDevicesCreateInputDTO detail;

    @ApiModelProperty(value = "流程信息")
    List<FlowNodeUserCreateInputDTO> flowInfo;

}
