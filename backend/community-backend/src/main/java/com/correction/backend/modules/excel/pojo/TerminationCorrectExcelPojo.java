package com.correction.backend.modules.excel.pojo;

import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class TerminationCorrectExcelPojo {


    @ExcelProperty(value = "矫正单位")
    private String correctionUnit;


    @ExcelProperty(value = "服刑人员")
    private String userName;


    @ExcelProperty(value = "监管类型， 暂时默认普管")
    private String supervisionLevel;

    @ExcelProperty(value = "执行类别")
    private String performType;

    @ExcelProperty(value = "待操作人")
    private String nextUserName;


    @ExcelProperty(value = "进度")
    private Integer progress;


}
