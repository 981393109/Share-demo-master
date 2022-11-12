package com.correction.backend.modules.sys.controller.dto.auth;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel("账号密码登陆 Response VO")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SysAuthLoginRespDTO {

    @ApiModelProperty(value = "token", required = true, example = "tokenne")
    private String token;

}
