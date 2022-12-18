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
 * 个别教育
 * </p>
 *
 * @author yao
 * @since 2022-12-06
 */
@Getter
@Setter
@ApiModel(value="EducationIndividualSearchInputDTO", description="个别教育查询表单")
public class EducationIndividualSearchInputDTO  extends PageParam  {


    @ApiModelProperty(value = "矫正单位")
    private String correctionUnit;

    @ApiModelProperty(value = "矫正单位Id")
    private Long correctionUnitId;

    @ApiModelProperty(value = "姓名")
    private String userName;

    @ApiModelProperty(value = "用户id")
    private Long userId;

    @ApiModelProperty(value = "谈话日期")
    private String talkDate;

    @ApiModelProperty(value = "谈话人")
    private String talkUser;

    @ApiModelProperty(value = "记录人")
    private String recordUser;

    @ApiModelProperty(value = "谈话地点")
    private String talkAddress;

    @ApiModelProperty(value = "谈话内容")
    private String talkContent;

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
