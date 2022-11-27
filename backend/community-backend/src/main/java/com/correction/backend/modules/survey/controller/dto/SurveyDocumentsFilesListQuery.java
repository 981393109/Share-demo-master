package com.correction.backend.modules.survey.controller.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.List;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value="SurveyDocumentsFilesListQuery", description="文书列表查询对象")
public class SurveyDocumentsFilesListQuery {

    private String id;

    @ApiModelProperty(value = "字典大类：2:委托检查材料 3调查实施材料，4审核评估材料 ")
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

    private List<Integer> dictTypeList;


}
