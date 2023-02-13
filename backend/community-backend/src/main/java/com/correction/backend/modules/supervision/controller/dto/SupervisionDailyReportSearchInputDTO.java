package com.correction.backend.modules.supervision.controller.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.correction.framework.common.pojo.PageParam;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.util.Date;
/**
 * <p>
 * 日常报道
 * </p>
 *
 * @author yao
 * @since 2022-12-02
 */
@Getter
@Setter
@ApiModel(value="SupervisionDailyReportSearchInputDTO", description="日常报道查询表单")
public class SupervisionDailyReportSearchInputDTO  extends PageParam  {


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

    @ApiModelProperty(value = "矫正人员id")
    private Long userId;

    @ApiModelProperty(value = "姓名")
    private String userName;

    @ApiModelProperty(value = "报到表现")
    private String registrationView;

    @ApiModelProperty(value = "得分")
    private String score;

    @ApiModelProperty(value = "备注")
    private String remark;

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

    private Long orgNum;

}
