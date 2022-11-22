package com.correction.backend.modules.flow.controller.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * 流程中心创建流程DTO
 */
@Getter
@Setter
public class FlowCenterDTO implements Serializable {

    @ApiModelProperty(value = "流程modelKey")
    private String type;

    List<FlowNodeDTO> flowNodes;

}
