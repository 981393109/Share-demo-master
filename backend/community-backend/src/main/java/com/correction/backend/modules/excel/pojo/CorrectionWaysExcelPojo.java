package com.correction.backend.modules.excel.pojo;

import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class CorrectionWaysExcelPojo {

    @ExcelProperty("矫正单位")
    private String correctionUnit;

    @ExcelProperty("服刑人员")
    private String sentenceUser;

    @ExcelProperty("方案日期")
    private String waysDate;

    @ExcelProperty("情况分析")
    private String analysisSituation;

    @ExcelProperty("矫正意见")
    private String correctionOpinion;

    @ExcelProperty("备注")
    private String remark;

}
