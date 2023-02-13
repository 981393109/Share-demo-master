package com.correction.backend.modules.sys.controller.dto.sys;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.util.Date;
/**
 * <p>
 * 文书参考
 * </p>
 *
 * @author yao
 * @since 2023-02-04
 */
@Getter
@Setter
@ApiModel(value="DocumentCenterListOutputDTO", description="文书参考列表")
public class DocumentCenterListOutputDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    @ApiModelProperty(value = "文书用途")
    private String useType;

    @ApiModelProperty(value = "1 可用 2 不可用")
    private Integer status;

    @ApiModelProperty(value = "文件名称")
    private String fileName;

    @ApiModelProperty(value = "文件路径")
    private String filePath;

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
