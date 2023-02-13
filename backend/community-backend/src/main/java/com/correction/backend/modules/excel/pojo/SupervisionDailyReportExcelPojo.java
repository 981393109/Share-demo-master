package com.correction.backend.modules.excel.pojo;


import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class SupervisionDailyReportExcelPojo {


    @ExcelProperty("委托单位")
    private String correctionUnit;

    @ExcelProperty("报到日期")
    private String registrationDate;

    @ExcelProperty("报到方式")
    private Integer registrationWay;

    @ExcelProperty("基准分值")
    private String benchmarkScore;

    @ExcelProperty("姓名")
    private String userName;

    @ExcelProperty("报到表现")
    private String registrationView;

    @ExcelProperty("得分")
    private String score;

    @ExcelProperty("备注")
    private String remark;

}
