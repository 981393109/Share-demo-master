package com.correction.backend.modules.excel.pojo;

import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class CasesPunishmentExcelPojo {


    @ExcelProperty(value = "矫正单位")
    private String correctionUnit;


    @ExcelProperty(value = "服刑人员")
    private String userName;


    @ExcelProperty(value = "违规类型 1:不按规定时间报到。。。2违反关于报告、会客、外出。。。3不按规定参加教育学习 4思保外就医无正当理由。。。5违反禁止令。。6其他违反有关法律。。。")
    private Integer violationsType;

    @ExcelProperty(value = "701-707 处罚类型建议")
    private Integer violationsTypeAdvice;

    @ExcelProperty(value = "待操作人")
    private String nextUserName;

    @ExcelProperty(value = "进度")
    private Integer progress;

    @ExcelProperty(value = "创建时间")
    private Date createTime;


}
