package com.correction.backend.modules.sys.entity;

import com.correction.frameworks.mybatis.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import java.io.Serializable;

/**
 * <p>
 * 组织表
 * </p>
 *
 * @author yao
 * @since 2022-11-12
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("sys_org")
public class OrgDO extends BaseDO {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 组织名称
     */
    private String orgName;

    /**
     * 组织编码
     */
    private String orgNum;

    /**
     * 组织代码
     */
    private String orgCode;

    /**
     * 员工数
     */
    private Integer employeeCount;

    /**
     * 组织类型: 0:市司法局（第1级）1：区司法局（第2级）2：司法所（第3级） 数据来源字典表
     */
    private Integer orgType;

    /**
     * 负责人
     */
    private String inCharge;

    /**
     * 父组织id
     */
    private Long pid;

    /**
     * 编制人数
     */
    private Integer compileCount;

    /**
     * 组织描述
     */
    private String description;


    public static final String ID = "id";

    public static final String ORG_NAME = "org_name";

    public static final String ORG_NUM = "org_num";

    public static final String ORG_CODE = "org_code";

    public static final String EMPLOYEE_COUNT = "employee_count";

    public static final String ORG_TYPE = "org_type";

    public static final String IN_CHARGE = "in_charge";

    public static final String PID = "pid";

    public static final String COMPILE_COUNT = "compile_count";

    public static final String DESCRIPTION = "description";


}
