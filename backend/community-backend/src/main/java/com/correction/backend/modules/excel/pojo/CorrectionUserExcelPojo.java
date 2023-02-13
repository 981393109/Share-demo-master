package com.correction.backend.modules.excel.pojo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class CorrectionUserExcelPojo {


    @ExcelProperty("姓名")
    private String name;

    @ExcelProperty("性别")
    private Integer sex;

    @ExcelProperty("出生日期")
    private String birthday;

}
