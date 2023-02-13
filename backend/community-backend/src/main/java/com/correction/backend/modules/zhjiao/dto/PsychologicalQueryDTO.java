package com.correction.backend.modules.zhjiao.dto;

import com.correction.framework.common.pojo.PageParam;
import lombok.Data;

/**
 * {"apperName":null,"streetId":null,"stage":null,"assessStatus":null,"apperStatus":null}
 */
@Data
public class PsychologicalQueryDTO extends PageParam {

    private String apperName;

    private Integer streetId;

    private String stage;

    private String assessStatus;

    private String apperStatus;

}
