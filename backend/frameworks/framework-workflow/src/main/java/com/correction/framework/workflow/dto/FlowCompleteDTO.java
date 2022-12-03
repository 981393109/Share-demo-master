package com.correction.framework.workflow.dto;


import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class FlowCompleteDTO {

    @ApiModelProperty(value = "userId")
    private Long userId;

    @ApiModelProperty(value = "任务节点id")
    private String taskId;

    @ApiModelProperty(value = "审批意见")
    private String comment = "";

    @ApiModelProperty(value = "是否通过: 1通过 2:拒绝 3:驳回")
    private Integer adopt;

    @ApiModelProperty(value = "下一流程步骤")
    private Integer progress;

}
