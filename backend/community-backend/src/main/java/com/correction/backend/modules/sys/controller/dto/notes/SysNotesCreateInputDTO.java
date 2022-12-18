package com.correction.backend.modules.sys.controller.dto.notes;

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
 * @since 2022-12-18
 */
@Getter
@Setter
@ApiModel(value="SysNotesCreateInputDTO", description="创建表单")
public class SysNotesCreateInputDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "作用日期")
    private String useDate;

    @ApiModelProperty(value = "用户id")
    private Long userId;

    @ApiModelProperty(value = "便签内容")
    private String content;

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

    @ApiModelProperty(value = "是否完成 1 是  2否")
    private Integer status;

}
