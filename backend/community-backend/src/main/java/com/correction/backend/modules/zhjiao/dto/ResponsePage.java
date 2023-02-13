package com.correction.backend.modules.zhjiao.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResponsePage {

    private Long pageNo;
    private Long pageSize;
    private Long total;
    private Long offset;

}
