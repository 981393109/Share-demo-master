package com.correction.backend.modules.zhjiao.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseResponse {

    private Integer status;

    private String msg;

    private String data;

    private ResponsePage  page;

}
