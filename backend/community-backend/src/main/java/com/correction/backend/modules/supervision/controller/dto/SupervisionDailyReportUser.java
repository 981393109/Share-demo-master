package com.correction.backend.modules.supervision.controller.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SupervisionDailyReportUser {

    @ApiModelProperty(value = "userId")
    private Long userId;

    @ApiModelProperty(value = "姓名")
    private String userName;

    @ApiModelProperty(value = "报到表现")
    private String registrationView;

    @ApiModelProperty(value = "得分")
    private String score;

    @ApiModelProperty(value = "备注")
    private String remark;

}
