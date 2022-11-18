package com.correction.backend.modules.sys.entity;

import com.correction.frameworks.mybatis.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author yao
 * @since 2022-11-16
 */
@Data
@Accessors(chain = true)
@TableName("sys_area")
public class SysArea  {

    private static final long serialVersionUID = 1L;

    private Long areaId;

    private String areaCode;

    private String areaName;

    private Integer level;

    private String cityCode;

    private String center;

    private Long parentId;


    public static final String AREA_ID = "area_id";

    public static final String AREA_CODE = "area_code";

    public static final String AREA_NAME = "area_name";

    public static final String LEVEL = "level";

    public static final String CITY_CODE = "city_code";

    public static final String CENTER = "center";

    public static final String PARENT_ID = "parent_id";

}
