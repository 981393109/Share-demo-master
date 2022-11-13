package com.correction.backend.modules.sys.entity;

import com.correction.frameworks.mybatis.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import java.io.Serializable;

/**
 * <p>
 * 全局字典表
 * </p>
 *
 * @author yao
 * @since 2022-11-12
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("sys_dict")
public class Dict extends BaseDO {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 名称
     */
    private String dictName;

    /**
     * code
     */
    private String dictCode;

    /**
     * 类别
     */
    private Integer dictType;


    public static final String ID = "id";

    public static final String DICT_NAME = "dict_name";

    public static final String DICT_CODE = "dict_code";

    public static final String DICT_TYPE = "dict_type";

}
