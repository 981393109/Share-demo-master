package com.correction.backend.modules.zhjiao.dto;

import com.correction.framework.common.pojo.PageParam;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * {"apperName":null,"signDate":"2022-12-19","streetIds":[],"isViolation":null}
 */
@Data
public class SignRecordDTO extends PageParam {

    private String apperName;

    private String signDate = LocalDate.now().toString();

    private List<Integer> streetIds = new ArrayList<>();

    private String isViolation;

}
