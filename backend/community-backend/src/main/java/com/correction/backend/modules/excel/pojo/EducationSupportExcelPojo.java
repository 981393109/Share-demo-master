package com.correction.backend.modules.excel.pojo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class EducationSupportExcelPojo {



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
     * 学习日期
     */
    @ExcelProperty("学习日期")
    private String learningDate;

    /**
     * 教育方式
     */
    @ExcelProperty("教育方式")
    private Integer educationWay;

    /**
     * 基准分值
     */
    @ExcelProperty("基准分值")
    private String benchmarkScore;

    /**
     * 学习内容
     */
    @ExcelProperty("学习内容")
    private String educationContent;

    /**
     * 附属单位
     */
    @ExcelProperty("附属单位")
    private String affiliatedUnit;

    /**
     * 报到表现
     */
    @ExcelProperty("报到表现")
    private String registrationView;

    /**
     * 得分
     */
    @ExcelProperty("得分")
    private String score;

    /**
     * 备注
     */
    @ExcelProperty("备注")
    private String remark;


}
