package com.correction.backend.modules.excel.pojo;

import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class HandleCorrectionExcelPojo {

    @ExcelProperty("委托单位")
    private String entrustUnit;

    @ExcelProperty("姓名")
    private String name;

    @ExcelProperty("委托时间")
    private String entrustDate;

    @ExcelProperty("接收时间")
    private String receptionDate;

    /**
     * 矫正机关
     */
    @ApiModelProperty(value = "jurisdictionOffice")
    private String jurisdictionOffice;

    @ApiModelProperty(value = "进度")
    private Integer progress;

    @ExcelProperty("待操作人")
    private String nextUserName;



}
