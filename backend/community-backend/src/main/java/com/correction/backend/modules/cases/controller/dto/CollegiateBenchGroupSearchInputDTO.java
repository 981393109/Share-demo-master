package com.correction.backend.modules.cases.controller.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.correction.framework.common.pojo.PageParam;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.util.Date;
/**
 * <p>
 * 合议小组/评议小组/相关小组表
 * </p>
 *
 * @author yao
 * @since 2022-12-17
 */
@Getter
@Setter
@ApiModel(value="CollegiateBenchGroupSearchInputDTO", description="合议小组/评议小组/相关小组表查询表单")
public class CollegiateBenchGroupSearchInputDTO  extends PageParam  {


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

    @ApiModelProperty(value = "源数据id")
    private Long dataId;

    @ApiModelProperty(value = "小组类型：1 （处罚案件）合议小组 2（处罚案件） 评议小组")
    private Integer type;

}
