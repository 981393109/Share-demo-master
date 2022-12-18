package com.correction.backend.modules.termination.controller.dto;

import com.correction.backend.modules.flow.controller.dto.FlowNodeUserCreateInputDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class TerminationCorrectStartFlowDTO {

    @ApiModelProperty(value = "详情信息")
    TerminationCorrectCreateInputDTO detail;

    @ApiModelProperty(value = "流程信息")
    List<FlowNodeUserCreateInputDTO> flowInfo;

}
