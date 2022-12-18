package com.correction.backend.modules.termination.controller.dto;

import com.correction.backend.modules.flow.controller.dto.FlowNodeUserCreateInputDTO;
import com.correction.backend.modules.supervision.controller.dto.SupervisionOutApprovalCreateInputDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class TerminationSolutionsStartFlowDTO {

    @ApiModelProperty(value = "详情信息")
    TerminationSolutionsCreateInputDTO detail;

    @ApiModelProperty(value = "流程信息")
    List<FlowNodeUserCreateInputDTO> flowInfo;


}
