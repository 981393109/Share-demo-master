package com.correction.backend.modules.handleCorrection.controller.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.util.Date;
/**
 * <p>
 * 矫正人员
 * </p>
 *
 * @author yao
 * @since 2022-11-23
 */
@Getter
@Setter
@ApiModel(value="CorrectionUserCreateInputDTO", description="矫正人员创建表单")
public class CorrectionUserCreateInputDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "性别")
    private Integer sex;

    @ApiModelProperty(value = "出生日期")
    private String birthday;

    @ApiModelProperty(value = "户籍")
    private String household;

    @ApiModelProperty(value = "籍贯")
    private String nativePlace;

    @ApiModelProperty(value = "居住地")
    private String address;

    @ApiModelProperty(value = "联系电话")
    private String mobile;

    @ApiModelProperty(value = "婚姻状况")
    private String maritalStatus;

    @ApiModelProperty(value = "职业")
    private String professional;

    @ApiModelProperty(value = "经济状况")
    private String economyState;

    @ApiModelProperty(value = "所属辖区")
    private String areaJurisdiction;

    @ApiModelProperty(value = "所属街道")
    private String streetJurisdiction;

    @ApiModelProperty(value = "案由")
    private String causeAction;

    @ApiModelProperty(value = "办理入矫id")
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
