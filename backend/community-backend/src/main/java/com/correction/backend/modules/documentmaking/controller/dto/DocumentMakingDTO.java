package com.correction.backend.modules.documentmaking.controller.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class DocumentMakingDTO implements Serializable {

    @ApiModelProperty(value = "数据id")
    private Long dataId;

    @ApiModelProperty(value = "制作类型 办理矫正文书：HANDLE_CORRECTION_FLOW  ")
    private String dataType;

}
