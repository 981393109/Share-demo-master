package com.correction.backend.modules.supervision.controller.dto;

import com.correction.backend.modules.flow.controller.dto.FlowNodeUserCreateInputDTO;
import com.correction.backend.modules.handleCorrection.controller.dto.HandleCorrectionCreateInputDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 流程启动
 */
@Getter
@Setter
public class SupervisionStartFlowDTO {

    @ApiModelProperty(value = "详情信息")
    SupervisionOutApprovalCreateInputDTO detail;

    @ApiModelProperty(value = "流程信息")
    List<FlowNodeUserCreateInputDTO> flowInfo;

}
