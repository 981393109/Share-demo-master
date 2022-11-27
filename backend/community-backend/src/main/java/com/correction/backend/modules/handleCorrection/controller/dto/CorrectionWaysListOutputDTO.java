package com.correction.backend.modules.handleCorrection.controller.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.util.Date;
/**
 * <p>
 * 矫正方案
 * </p>
 *
 * @author yao
 * @since 2022-11-23
 */
@Getter
@Setter
@ApiModel(value="CorrectionWaysListOutputDTO", description="矫正方案列表")
public class CorrectionWaysListOutputDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    @ApiModelProperty(value = "矫正单位")
    private String correctionUnit;

    @ApiModelProperty(value = "服刑人员")
    private String sentenceUser;

    @ApiModelProperty(value = "服刑人员id")
    private Long sentenceUserId;

    @ApiModelProperty(value = "方案日期")
    private String waysDate;

    @ApiModelProperty(value = "情况分析")
    private String analysisSituation;

    @ApiModelProperty(value = "矫正意见")
    private String correctionOpinion;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "矫正id")
    private Long handleCorrectionId;

    @ApiModelProperty(value = "组织架构num")
    private String orgNum;

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
