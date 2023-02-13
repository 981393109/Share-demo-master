package com.correction.backend.modules.excel.pojo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class SupervisionVisitFieldExcelPojo {


    @ExcelProperty("矫正单位")
    private String correctionUnit;


    @ExcelProperty("服刑人员")
    private String userName;

    @ExcelProperty("查访日期")
    private String visitDate;

    @ExcelProperty("查访场所")
    private String visitAddress;

    @ExcelProperty("走访事由")
    private String visitPurpose;

    @ExcelProperty("走访意见")
    private String visitOpinion;

}
