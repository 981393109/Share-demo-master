package com.correction.backend.modules.excel.pojo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class EducationIdeologyExcelPojo {

    /**
     * 矫正单位
     */
    @ExcelProperty("矫正单位")
    private String correctionUnit;

    /**
     * 姓名
     */
    @ExcelProperty("姓名")
    private String userName;


    /**
     * 汇报日期
     */
    @ExcelProperty("汇报日期")
    private String reportDate;

    /**
     * 表现情况
     */
    @ExcelProperty("表现情况")
    private String performanceInformation;

    /**
     * 分值
     */
    @ExcelProperty("分值")
    private String benchmarkScore;

    /**
     * 得分
     */
    @ExcelProperty("得分")
    private String score;



}
