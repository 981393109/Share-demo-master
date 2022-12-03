package com.correction.backend.modules.supervision.controller.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TerminateLeaveDTO {


    @ApiModelProperty("Id")
    private Long id ;

    @ApiModelProperty(value = "是否销假 2 否 1 是")
    private Integer terminateLeave;

    @ApiModelProperty(value = "是否延期  2 否  1 是")
    private Integer terminateDelay;

    @ApiModelProperty(value = "是否确认核实司法所相关材料")
    private Integer terminateCommit;

    @ApiModelProperty(value = "是否由于特殊原因无法按期返回")
    private Integer terminateDelayDeturn;

    @ApiModelProperty(value = "延期日期")
    private String terminateDelayDate;

    @ApiModelProperty(value = "矫正对象返回居住地后，在24小时内向区司法局或司法所报告")
    private Integer terminateReturnReport;

    @ApiModelProperty(value = "延期销假材料")
    private String terminateMaterials;

}
