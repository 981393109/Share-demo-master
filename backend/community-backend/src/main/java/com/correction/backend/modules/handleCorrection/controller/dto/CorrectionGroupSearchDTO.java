package com.correction.backend.modules.handleCorrection.controller.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.correction.framework.common.pojo.PageParam;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.util.Date;
/**
 * <p>
 * 矫正小组
 * </p>
 *
 * @author yao
 * @since 2022-11-23
 */
@Getter
@Setter
@ApiModel(value="CorrectionGroupSearchDTO", description="矫正小组查询表单")
public class CorrectionGroupSearchDTO  {


    @ApiModelProperty(value = "用户名")
    private String userName;

    @ApiModelProperty(value = "用户id")
    private Long userId;

    @ApiModelProperty(value = "矫正单位")
    private String correctionUnit;

    @ApiModelProperty(value = "用户类型")
    private String userType;

    @ApiModelProperty(value = "性别")
    private Integer sex;

    @ApiModelProperty(value = "身份证号")
    private String idCard;

    @ApiModelProperty(value = "职位")
    private String job;

    @ApiModelProperty(value = "矫正id")
    private Long handleCorrectionId;

}
