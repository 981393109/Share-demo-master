package com.correction.backend.modules.excel.pojo;

import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
public class SurveyEvaluationExcelPojo {


    @ExcelProperty("委托单位")
    private String entrustUnit;

    @ExcelProperty("所属辖区")
    private String areaJurisdiction;

    @ExcelProperty("姓名")
    private String name;

    @ExcelProperty("委托时间")
    private String entrustDate;

    @ExcelProperty("最后意见")
    private Integer assessmentLastOpinion;

    @ExcelProperty("接收时间")
    private String receptionDate;

    @ExcelProperty("矫正机构")
    private String jurisdictionOffice;

    /**
     * 0:未提交，1登记备案，2上传文书附件，3调查指派，4调查实施，5调查评估，6文书寄送，7一人一档，8流程归档
     */
    @ExcelProperty(value = "进度",converter = com.correction.backend.modules.excel.converter.ExportExcelConverter.class)
    private Integer progress;

    @ExcelProperty("待操作人")
    private String nextUserName;

}
