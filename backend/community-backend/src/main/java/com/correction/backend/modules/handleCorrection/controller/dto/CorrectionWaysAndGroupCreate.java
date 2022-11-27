package com.correction.backend.modules.handleCorrection.controller.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CorrectionWaysAndGroupCreate {

    @ApiModelProperty(value = "矫正方案对象")
    CorrectionWaysUpdateInputDTO  correctionWays;

    @ApiModelProperty(value = "矫正小组集合")
    List<CorrectionGroupUpdateInputDTO> correctionUsers;

}
