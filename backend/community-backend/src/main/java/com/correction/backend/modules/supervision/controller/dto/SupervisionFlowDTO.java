package com.correction.backend.modules.supervision.controller.dto;

import com.correction.framework.workflow.dto.FlowCompleteDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SupervisionFlowDTO {


    @ApiModelProperty(value = "详情信息")
    SupervisionOutApprovalUpdateInputDTO detail;

    @ApiModelProperty(value = "审批信息")
    FlowCompleteDTO flowInfo;

}
