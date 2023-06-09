package com.correction.backend.modules.flow.controller.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FlowNodeListDTO {

    @ApiModelProperty(value = "节点名称")
    private String nodeName;

    /*节点id*/
    @ApiModelProperty(value = "节点ID")
    private String nodeId;

    /*流程id*/
    @ApiModelProperty(value = "流程id")
    private Long flowId;

    @ApiModelProperty(value = "节点用户以及组")
    private List<FlowOrgRoleDTO> nodeUserGroup;

}
