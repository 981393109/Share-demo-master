package com.correction.backend.modules.flow.controller.dto;


import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Getter
@Setter
@Accessors(chain = true)
public class FlowNodeDTO implements Serializable {

    @ApiModelProperty(value = "节点名称")
    private String name;

    @ApiModelProperty(value = "关联id(用户id、角色id、部门id)")
    private Long relationId;

    @ApiModelProperty(value = "0:角色 1:部门 2:人员(暂且支持角色)")
    private String relationType;

    @ApiModelProperty(value = "通过方式 0：一人通过则通过  1：全部通过则通过")
    private String passType;

    @ApiModelProperty(value = "流程类型")
    private String flowType;

    @ApiModelProperty(value = "审批方式 平台 0: 否 1:是")
    private String applayPlatform;

    @ApiModelProperty(value = "审批方式 邮件 0: 否 1:是")
    private String applayEmail;

}
