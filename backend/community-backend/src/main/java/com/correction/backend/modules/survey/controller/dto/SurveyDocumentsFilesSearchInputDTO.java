package com.correction.backend.modules.survey.controller.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.correction.framework.common.pojo.PageParam;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.util.Date;
/**
 * <p>
 * 文书附件上传
 * </p>
 *
 * @author yao
 * @since 2022-11-15
 */
@Getter
@Setter
@ApiModel(value="SurveyDocumentsFilesSearchInputDTO", description="文书附件上传查询表单")
public class SurveyDocumentsFilesSearchInputDTO  extends PageParam  {


    @ApiModelProperty(value = "文档源头id")
    private Long dataId;

    @ApiModelProperty(value = "文档名称")
    private String docName;

    @ApiModelProperty(value = "文档状态 1：已上传 2上传失败")
    private Integer docStatus;

    @ApiModelProperty(value = "相对路径")
    private String filePath;

    @ApiModelProperty(value = "文件路径")
    private String fileUrl;

    @ApiModelProperty(value = "文件名称")
    private String fileName;

    @ApiModelProperty(value = "文件类型")
    private String fileType;

    @ApiModelProperty(value = "文书大类 1：调查评估")
    private Integer docSubject;

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
