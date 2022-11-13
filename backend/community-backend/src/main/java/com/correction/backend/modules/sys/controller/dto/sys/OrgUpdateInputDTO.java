package com.correction.backend.modules.sys.controller.dto.sys;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.util.Date;
/**
 * <p>
 * 组织表
 * </p>
 *
 * @author yao
 * @since 2022-11-12
 */
@Getter
@Setter
@ApiModel(value="OrgUpdateInputDTO", description="组织表修改表单")
public class OrgUpdateInputDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    @ApiModelProperty(value = "组织名称")
    private String orgName;

    @ApiModelProperty(value = "组织编码")
    private String orgNum;

    @ApiModelProperty(value = "组织代码")
    private String orgCode;

    @ApiModelProperty(value = "员工数")
    private Integer employeeCount;

    @ApiModelProperty(value = "组织类型: 0:市司法局（第1级）1：区司法局（第2级）2：司法所（第3级） 数据来源字典表")
    private Integer orgType;

    @ApiModelProperty(value = "负责人")
    private String inCharge;

    @ApiModelProperty(value = "父组织id")
    private Long pid;

    @ApiModelProperty(value = "编制人数")
    private Integer compileCount;

    @ApiModelProperty(value = "组织描述")
    private String description;

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
