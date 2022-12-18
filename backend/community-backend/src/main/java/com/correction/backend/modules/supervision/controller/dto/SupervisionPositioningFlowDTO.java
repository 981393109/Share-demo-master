package com.correction.backend.modules.supervision.controller.dto;

import com.correction.backend.modules.flow.controller.dto.FlowNodeUserCreateInputDTO;
import com.correction.framework.workflow.dto.FlowCompleteDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SupervisionPositioningFlowDTO {

    @ApiModelProperty(value = "详情信息")
    SupervisionPositioningDevicesUpdateInputDTO detail;

    @ApiModelProperty(value = "审批信息")
    FlowCompleteDTO flowInfo;


}
