package com.correction.backend.modules.excel.pojo;

import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class RewardRecordExcelPojo {

    @ExcelProperty(value = "矫正单位")
    private String correctionUnit;

    @ExcelProperty(value = "服刑人员")
    private String userName;

    @ExcelProperty(value = "表现类型 1 -6")
    private Integer rewardType;

    @ExcelProperty(value = "801-802 表扬类型类型建议")
    private Integer rewardTypeAdvice;

    @ApiModelProperty(value = "待操作人")
    private String nextUserName;

    @ExcelProperty(value = "进度")
    private Integer progress;

    @ExcelProperty(value = "创建时间")
    private Date createTime;

}
