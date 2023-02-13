package com.correction.backend.modules.excel.pojo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class EducationIndividualExcelPojo {


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
     * 谈话日期
     */
    @ExcelProperty("谈话日期")
    private String talkDate;

    /**
     * 谈话人
     */
    @ExcelProperty("谈话人")
    private String talkUser;

    /**
     * 记录人
     */
    @ExcelProperty("记录人")
    private String recordUser;

    /**
     * 谈话地点
     */
    @ExcelProperty("谈话地点")
    private String talkAddress;



}
