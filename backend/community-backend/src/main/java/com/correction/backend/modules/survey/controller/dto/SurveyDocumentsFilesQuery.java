package com.correction.backend.modules.survey.controller.dto;

import com.correction.framework.common.pojo.PageParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;


@Getter
@Setter
@Builder
@ApiModel(value="SurveyDocumentsFilesQuery", description="文书列表查询对象")
public class SurveyDocumentsFilesQuery extends PageParam {

    private String id;

    @ApiModelProperty(value = "字典大类：2 ")
    private Integer dictType;

    @ApiModelProperty(value = "字典值")
    private Integer dictValue;

    @ApiModelProperty(value = "文书名称")
    private String  dictName;

    @ApiModelProperty(value = "文件名称")
    private String  fileName;

    @ApiModelProperty(value = "文件路径")
    private String  fileUrl;

    @ApiModelProperty(value = "上传状态")
    private String  fileStatus;

    @ApiModelProperty(value = "源数据id")
    private Long  dataId;

}
