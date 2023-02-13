package com.correction.backend.modules.excel.pojo;

import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SupervisionOutApprovalExcelPojo {


    @ExcelProperty(value = "矫正单位")
    private String correctionUnit;

    @ExcelProperty(value = "用户名")
    private String userName;

    @ExcelProperty(value = "请假事由")
    private String reasonsForLeave;

    @ExcelProperty(value = "目的地")
    private String destination;

    @ExcelProperty(value = "出发地")
    private String departure;

    @ExcelProperty(value = "起始日期")
    private String startDate;

    @ExcelProperty(value = "截至日期")
    private String endDate;

    @ExcelProperty(value = "请假天数")
    private String leaveDay;

    @ExcelProperty(value = "请假程序(审批程序) 0：所级审批  1：区级审批  2 市级审批  请假程序不同对应的进度也有所差别")
    private Integer leaveType;


    @ExcelProperty(value =  " 司法所审批意见 1通过 2 不通过")
    private Integer placeApplyOpinion;

    @ExcelProperty(value = "待操作人")
    private String nextUserName;

    @ExcelProperty(value = "进度")
    private Integer progress;

}
