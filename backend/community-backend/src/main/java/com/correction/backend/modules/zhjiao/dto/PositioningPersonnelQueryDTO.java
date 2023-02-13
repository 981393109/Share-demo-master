package com.correction.backend.modules.zhjiao.dto;

import com.correction.framework.common.pojo.PageParam;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * {"apperName":null,"deviceType":null,"streetIds":[]}
 */
@Data
public class PositioningPersonnelQueryDTO extends PageParam {

    private String apperName;

    private String deviceType;

    private List<Integer> streetIds = new ArrayList<>();

}
