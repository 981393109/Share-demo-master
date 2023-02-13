package com.correction.backend.modules.zhjiao.dto;

import com.correction.framework.common.pojo.PageParam;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * {"apperName":null,"streetIds":[],"status":true}
 */
@Data
public class VideoUserDTO  extends PageParam {

    private String apperName;

    private List<Integer> streetIds = new ArrayList<>();

    private Boolean status = true;

}
