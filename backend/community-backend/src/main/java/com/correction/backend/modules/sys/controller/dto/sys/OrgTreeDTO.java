package com.correction.backend.modules.sys.controller.dto.sys;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@ApiModel("组织架构树 Response VO")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrgTreeDTO {

    @ApiModelProperty(value = "组织id")
    private Long id;

    @ApiModelProperty(value = "父组织 ID")
    private Long pid;

    @ApiModelProperty(value = "组织名称")
    private String orgName;

    /**
     * 子路由
     */
    private List<OrgTreeDTO> children;

}
