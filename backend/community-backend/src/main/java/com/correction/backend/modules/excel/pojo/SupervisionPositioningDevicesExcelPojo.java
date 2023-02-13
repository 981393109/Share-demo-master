package com.correction.backend.modules.excel.pojo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class SupervisionPositioningDevicesExcelPojo {

    @ExcelProperty(value = "矫正单位")
    private String correctionUnit;


    @ExcelProperty(value = "姓名")
    private String userName;

    @ExcelProperty(value = "1 提出建议  2延长流程 3 解除流程  4免除流程")
    private Integer type;


    @ExcelProperty(value = "使用情形")
    private Integer caseUse;

    @ExcelProperty(value = "待操作人")
    private String nextUserName;


    @ExcelProperty(value = "进度")
    private Integer progress;

    @ExcelProperty(value = "申请日期")
    private String applyTime;

    @ExcelProperty(value = "司法区审批意见 1通过 2 不通过")
    private Integer areaApplyOpinion;

    @ExcelProperty(value = "司法行政审批结果 1通过 2 不通过")
    private Integer justiceApplyOpinion;


}
