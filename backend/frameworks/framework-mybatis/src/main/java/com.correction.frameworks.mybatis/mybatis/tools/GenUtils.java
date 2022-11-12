package com.correction.frameworks.mybatis.mybatis.tools;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.setting.dialect.Props;

public class GenUtils {
    private static final Props PROPS;

    static {
        PROPS = new Props("db.properties", CharsetUtil.UTF_8);
    }

    public static GenerModel getGenerByProps() {
        GenerModel generModel = new GenerModel();
        generModel.setPack(PROPS.getStr("db.pack"));
        generModel.setDbUrl(PROPS.getStr("db.url"));
        generModel.setDriverName(PROPS.getStr("db.driverName"));
        generModel.setUsername(PROPS.getStr("db.username"));
        generModel.setPassword(PROPS.getStr("db.password"));
        generModel.setTableName(PROPS.getStr("table.tableName"));
        generModel.setModules(PROPS.getStr("table.modules"));
        generModel.setPrefix(PROPS.getStr("table.prefix"));
        return generModel;
    }
}
