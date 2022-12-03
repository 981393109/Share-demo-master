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
 * 查访登记
 * </p>
 *
 * @author yao
 * @since 2022-12-03
 */
@Getter
@Setter
@ApiModel(value="SupervisionVisitFieldSearchInputDTO", description="查访登记查询表单")
public class SupervisionVisitFieldSearchInputDTO  extends PageParam  {


    @ApiModelProperty(value = "矫正单位")
    private String correctionUnit;

    @ApiModelProperty(value = "矫正单位Id")
    private String correctionUnitId;

    @ApiModelProperty(value = "服刑人员")
    private String userName;

    @ApiModelProperty(value = "服刑人员id")
    private Long userId;

    @ApiModelProperty(value = "查访日期")
    private String visitDate;

    @ApiModelProperty(value = "查访场所")
    private String visitAddress;

    @ApiModelProperty(value = "走访事由")
    private String visitPurpose;

    @ApiModelProperty(value = "走访意见")
    private String visitOpinion;

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
