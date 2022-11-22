package com.correction.backend.modules.survey.controller.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@ApiModel(value="SurveyDocumentsFilesDTO", description="文书列表对象")
public class SurveyDocumentsFilesDTO {
    
    private Long id;

    @ApiModelProperty(value = "字典大类")
    private Integer dictType;

    @ApiModelProperty(value = "字典值")
    private Integer dictValue;

    @ApiModelProperty(value = "文书名称")
    private String  dictName;

    @ApiModelProperty(value = "文件名称")
    private String  fileName;

    @ApiModelProperty(value = "文件路径")
    private String  fileUrl;

    @ApiModelProperty(value = "上传状态 0 未上传 1 已上传")
    private String  fileStatus;

    @ApiModelProperty(value = "源数据id")
    private Long  dataId;

    private  List<Integer> dictTypeList;
}
