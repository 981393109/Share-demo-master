package com.correction.backend.modules.home.controller.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class ReportDTO {

    /**
     * 待操作 人数
     */
    @ApiModelProperty("待XXX人数")
    private Integer waitCount;

    @ApiModelProperty("已XXX人数")
    private Integer edCount;

    @ApiModelProperty("代办列表")
    private List<UserRunTaskDTO> runTaskList;

    @ApiModelProperty("记录列表")
    private List<ReportRecordDTO> reportRecordList;

}
