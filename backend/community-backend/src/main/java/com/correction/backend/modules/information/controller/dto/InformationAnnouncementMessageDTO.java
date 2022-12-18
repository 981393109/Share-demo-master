package com.correction.backend.modules.information.controller.dto;


import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class InformationAnnouncementMessageDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    @ApiModelProperty(value = "标题")
    private String msgTitle;

    @ApiModelProperty(value = "信息内容")
    private String msgInfo;

    @ApiModelProperty(value = "发起人名称")
    private String originator;

    @ApiModelProperty(value = "发起人id")
    private Long originatorId;

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

    @ApiModelProperty(value = "1 有效 2关闭")
    private Integer status;

    @ApiModelProperty(value = "日期")
    private String  msgDate;


}
