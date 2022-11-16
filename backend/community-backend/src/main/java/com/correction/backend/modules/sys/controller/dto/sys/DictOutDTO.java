package com.correction.backend.modules.sys.controller.dto.sys;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(value="DictOutDTO", description="字典对象")
public class DictOutDTO {

    /**
     * 名称
     */
    @ApiModelProperty(value = "名称")
    private String dictName;

    /**
     * code
     */
    @ApiModelProperty(value = "code")
    private String dictCode;

    /**
     * 类别
     */
    @ApiModelProperty(value = "类别")
    private Integer dictType;


    @ApiModelProperty(value = "值")
    private Integer dictValue;

}
