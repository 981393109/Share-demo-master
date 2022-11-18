package com.correction.framework.workflow.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Builder
@Accessors(chain = true)
public class FlowStartDTO {

    //流程类型
    private String  flowType;

    //业务id
    private Long dataId;

    //申请用户id
    private Long userId;

    //申请用户名称
    private String userName;
}
