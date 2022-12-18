package com.correction.backend.modules.education.controller.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.util.Date;
/**
 * <p>
 * 教育帮扶表
 * </p>
 *
 * @author yao
 * @since 2022-12-06
 */
@Getter
@Setter
@ApiModel(value="EducationSupportUpdateInputDTO", description="教育帮扶表修改表单")
public class EducationSupportUpdateInputDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    @ApiModelProperty(value = "矫正单位")
    private String correctionUnit;

    @ApiModelProperty(value = "矫正单位Id")
    private Long correctionUnitId;

    @ApiModelProperty(value = "姓名")
    private String userName;

    private Long userId;

    @ApiModelProperty(value = "学习日期")
    private String learningDate;

    @ApiModelProperty(value = "教育方式")
    private Integer educationWay;

    @ApiModelProperty(value = "基准分值")
    private String benchmarkScore;

    @ApiModelProperty(value = "学习内容")
    private String educationContent;

    @ApiModelProperty(value = "附属单位")
    private String affiliatedUnit;

    @ApiModelProperty(value = "报到表现")
    private String registrationView;

    @ApiModelProperty(value = "得分")
    private String score;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "组织id")
    private Long orgNum;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "修改时间")
    private Date updateTime;

    @ApiModelProperty(value = "创建人")
    private String creator;

    @ApiModelProperty(value = "修改人")
    private String updater;

    @ApiModelProperty(value = "是否删除")
    private Boolean deleted;

}
