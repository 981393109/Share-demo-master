package com.correction.backend.modules.information.controller.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.correction.framework.common.pojo.PageParam;
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
 * @since 2022-11-27
 */
@Getter
@Setter
@ApiModel(value="InformationMessageSearchInputDTO", description="查询表单")
public class InformationMessageSearchInputDTO  extends PageParam  {


    @ApiModelProperty(value = "接收用户id")
    private Long userId;

    @ApiModelProperty(value = "信息类型(1：审批 2：通告 3：其他)")
    private Integer msgType;

    @ApiModelProperty(value = "标题")
    private String msgTitle;

    @ApiModelProperty(value = "信息内容")
    private String msgInfo;

    @ApiModelProperty(value = "发起人名称")
    private String originator;

    @ApiModelProperty(value = "发起人id")
    private Long originatorId;

    @ApiModelProperty(value = "信息源id")
    private Long dataId;

    @ApiModelProperty(value = "信息类别 SURVEY_FLOW: 调查评估  HANDLE_CORRECTION_FLOW: 办理矫正    。。。")
    private String  dataType;

    @ApiModelProperty(value = "0未读 1已读")
    private Integer status;

    @ApiModelProperty(value = "流程任务id")
    private String taskId;

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
