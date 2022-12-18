package com.correction.backend.modules.information.controller.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class InformationReadDTO {

    @ApiModelProperty(value = "消息id")
    List<Long> ids;

    @ApiModelProperty(value = "已读/未读  1未读 2已读")
    Integer status;
}
