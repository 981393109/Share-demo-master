package com.correction.backend.modules.zhjiao.dto;

import com.correction.framework.common.pojo.PageParam;
import lombok.Data;

@Data
public class ElectronicFenceUserQueryDTO extends PageParam {

    private Long districtId;

    private Long areaId;

}
