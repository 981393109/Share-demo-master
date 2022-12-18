package com.correction.backend.modules.education.controller.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.correction.framework.common.pojo.PageParam;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.util.Date;
/**
 * <p>
 * 思想汇报
 * </p>
 *
 * @author yao
 * @since 2022-12-12
 */
@Getter
@Setter
@ApiModel(value="EducationIdeologySearchInputDTO", description="思想汇报查询表单")
public class EducationIdeologySearchInputDTO  extends PageParam  {


    @ApiModelProperty(value = "矫正单位")
    private String correctionUnit;

    @ApiModelProperty(value = "矫正单位Id")
    private Long correctionUnitId;

    @ApiModelProperty(value = "姓名")
    private String userName;

    @ApiModelProperty(value = "用户id")
    private Long userId;

    @ApiModelProperty(value = "汇报日期")
    private String reportDate;

    @ApiModelProperty(value = "表现情况")
    private String performanceInformation;

    @ApiModelProperty(value = "分值")
    private String benchmarkScore;

    @ApiModelProperty(value = "得分")
    private String score;

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
