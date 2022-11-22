package com.correction.backend.modules.flow.controller.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.util.Date;
/**
 * <p>
 *
 * </p>
 *
 * @author yao
 * @since 2022-11-16
 */
@Getter
@Setter
@ApiModel(value="FlowCenterListOutputDTO", description="列表")
public class FlowCenterListOutputDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    @ApiModelProperty(value = "流程类型")
    private String flowType;

    @ApiModelProperty(value = "流程状态 0 进行中 1 完成  2 拒绝 3 驳回 ")
    private Integer flowStatus;

    @ApiModelProperty(value = "申请时间")
    private Date flowApplyTime;

    @ApiModelProperty(value = "流程结束时间")
    private Date flowEndTime;

    @ApiModelProperty(value = "申请人code")
    private String flowApplyUser;

    @ApiModelProperty(value = "申请人名称")
    private String flowApplyName;

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
