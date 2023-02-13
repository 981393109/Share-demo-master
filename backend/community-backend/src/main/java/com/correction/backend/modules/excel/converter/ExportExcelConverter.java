package com.correction.backend.modules.excel.converter;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.property.ExcelContentProperty;
import liquibase.pro.packaged.S;

public class ExportExcelConverter implements Converter<Integer > {


    @Override
    public Class supportJavaTypeKey() {
        return String.class;
    }

    @Override
    public CellDataTypeEnum supportExcelTypeKey() {
        return CellDataTypeEnum.STRING;
    }

    @Override
    public Integer convertToJavaData(CellData cellData, ExcelContentProperty excelContentProperty, GlobalConfiguration globalConfiguration) throws Exception {
        return (Integer) cellData.getData();
    }

    @Override
    public CellData convertToExcelData(Integer str, ExcelContentProperty excelContentProperty, GlobalConfiguration globalConfiguration) throws Exception {
        return new CellData(switchProgress(str));
    }

    private static String  switchProgress (Integer str){
        String result = "";
        switch (str) {
            case 0:
                result =  "待提交";
                break;
            case 1:
                result =  "待指派";
                break;
            case 2:
                result =  "待指派";
                break;
            case 3:
                result =  "待调查";
                break;
            case 4:
                result =  "调查中";
                break;
            case 5:
                result =  "待评估";
                break;
            case 6:
                result =  "评估中";
                break;
            case 7:
                result =  "已评估";
                break;
            case 99:
                result =  "已结束";
                break;
            case -1:
                result =  "驳回";
                break;
        }
        return result;
    }

}
