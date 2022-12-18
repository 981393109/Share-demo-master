package com.correction.backend.modules.sys.controller.dto.notes;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.annotation.Resource;

@Data
public class SysNotesStatusUpdateDTO {

    @ApiModelProperty("id")
    private Long id ;

    @ApiModelProperty("status 1完成  2未完成")
    private Integer status;


}
