package com.correction.backend.modules.zhjiao.dto;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AccessTokenDTO {

    @JSONField(name = "access_token")
    private String accessToken;

    private long applyTime;

}
