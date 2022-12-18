package com.correction.backend.modules.education.controller.dto;

import com.correction.backend.modules.supervision.controller.dto.SupervisionDailyReportUser;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@ApiModel(value="EducationSupportUserDTO", description="集中")
public class EducationSupportUserDTO {

    @ApiModelProperty(value = "矫正单位")
    private String correctionUnit;

    @ApiModelProperty(value = "矫正单位Id")
    private Long correctionUnitId;

    @ApiModelProperty(value = "学习日期")
    private String learningDate;

    @ApiModelProperty(value = "教育方式")
    private Integer educationWay;

    @ApiModelProperty(value = "基准分值")
    private String benchmarkScore;

    @ApiModelProperty(value = "学习内容")
    private String educationContent;

    @ApiModelProperty(value = "矫正人员集合")
    private List<EducationSupportUser> userList;


}
