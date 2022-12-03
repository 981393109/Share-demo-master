package com.correction.backend.modules.supervision.controller.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@ApiModel(value="SupervisionDailyReportUserDTO", description="日常报道创建表单")
public class SupervisionDailyReportUserDTO {

    @ApiModelProperty(value = "矫正单位")
    private String correctionUnit;

    @ApiModelProperty(value = "矫正单位Id")
    private Long correctionUnitId;

    @ApiModelProperty(value = "报到日期")
    private String registrationDate;

    @ApiModelProperty(value = "报到方式 1 日常报到 2电话报到")
    private Integer registrationWay;

    @ApiModelProperty(value = "基准分值")
    private String benchmarkScore;

    @ApiModelProperty(value = "分值")
    private String score;


    @ApiModelProperty(value = "矫正人员集合")
    private List<SupervisionDailyReportUser> userList;


}
