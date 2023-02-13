package com.correction.backend.modules.zhjiao.dto;


import com.correction.framework.common.pojo.PageParam;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * {"apperName":null,"streetIds":[],"status":3,"endDate":null,"startDate":null,"types":[],"resultTypes":[2]}
 */
@Data
public class ViolationAlertQueryDTO extends PageParam {

    private String apperName;

    private List<Integer> streetIds = new ArrayList<>();

    private Integer status = 3;

    private String endDate;

    private String startDate;

    private List<Integer> types = new ArrayList<>();

    private List<Integer> resultTypes = Stream.of(2).collect(Collectors.toList());

}
