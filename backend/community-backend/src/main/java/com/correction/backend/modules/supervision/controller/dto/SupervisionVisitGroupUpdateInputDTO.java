package com.correction.backend.modules.supervision.controller.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.util.Date;
/**
 * <p>
 * 走访小组
 * </p>
 *
 * @author yao
 * @since 2022-12-03
 */
@Getter
@Setter
@ApiModel(value="SupervisionVisitGroupUpdateInputDTO", description="走访小组修改表单")
public class SupervisionVisitGroupUpdateInputDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    @ApiModelProperty(value = "矫正单位")
    private String correctionUnit;

    @ApiModelProperty(value = "姓名")
    private String userName;

    @ApiModelProperty(value = "用户id")
    private Long userId;

    @ApiModelProperty(value = "类型")
    private String userType;

    @ApiModelProperty(value = "性别")
    private Integer sex;

    @ApiModelProperty(value = "身份证号码")
    private String idCard;

    @ApiModelProperty(value = "职位")
    private String job;

    @ApiModelProperty(value = "实地查访ID")
    private Long dataId;

}
