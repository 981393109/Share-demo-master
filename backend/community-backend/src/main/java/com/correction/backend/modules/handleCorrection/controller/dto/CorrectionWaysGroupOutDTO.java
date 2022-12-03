package com.correction.backend.modules.handleCorrection.controller.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CorrectionWaysGroupOutDTO {

    @ApiModelProperty(value = "矫正方案")
    CorrectionWaysListOutputDTO correctionWays;

    @ApiModelProperty(value = "矫正小组id集合")
    List<Long> correctionGroupId;
}
