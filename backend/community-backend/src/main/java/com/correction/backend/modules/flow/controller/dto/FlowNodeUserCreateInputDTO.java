package com.correction.backend.modules.flow.controller.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.util.Date;
/**
 * <p>
 * 审批流程节点与用户关联关系
 * </p>
 *
 * @author yao
 * @since 2022-11-19
 */
@Getter
@Setter
@ApiModel(value="FlowNodeUserCreateInputDTO", description="审批流程节点与用户关联关系创建表单")
public class FlowNodeUserCreateInputDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "部门id")
    private Long orgId;

    @ApiModelProperty(value = "角色id")
    private Long roleId;

    @ApiModelProperty(value = "用户id")
    private Long userId;

    @ApiModelProperty(value = "流程节点id")
    private String nodeId;

    @ApiModelProperty(value = "源数据id")
    private Long dataId;

    @ApiModelProperty(value = "flowid")
    private Long flowId;

    private String ref;

    @ApiModelProperty(value = "节点名称")
    private String nodeName;

}
