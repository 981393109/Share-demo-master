package com.correction.backend.modules.education.controller.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(value="EducationSupportUser", description="日常报道创建表单")
public class EducationSupportUser {

    @ApiModelProperty(value = "附属单位")
    private String affiliatedUnit;

    @ApiModelProperty(value = "报到表现")
    private String registrationView;

    @ApiModelProperty(value = "得分")
    private String score;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "姓名")
    private String userName;

    @ApiModelProperty(value = "用户id")
    private Long userId;

}
