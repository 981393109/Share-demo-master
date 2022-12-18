package com.correction.backend.modules.home.controller.dto;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ReportRecordDTO {

    @ApiModelProperty("dataId")
    private Long dataId;

    @ApiModelProperty("描述信息")
    private String info;

}
