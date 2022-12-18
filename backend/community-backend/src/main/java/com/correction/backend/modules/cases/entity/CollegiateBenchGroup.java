package com.correction.backend.modules.cases.entity;

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
 * 合议小组/评议小组/相关小组表
 * </p>
 *
 * @author yao
 * @since 2022-12-17
 */
@Data
@Accessors(chain = true)
@TableName("collegiate_bench_group")
public class CollegiateBenchGroup{

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 矫正单位
     */
    private String correctionUnit;

    /**
     * 姓名
     */
    private String userName;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 类型
     */
    private String userType;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 身份证号码
     */
    private String idCard;

    /**
     * 职位
     */
    private String job;

    /**
     * 源数据id
     */
    private Long dataId;

    /**
     * 小组类型：1 （处罚案件）合议小组 2（处罚案件） 评议小组
     */
    private Integer type;


    public static final String ID = "id";

    public static final String CORRECTION_UNIT = "correction_unit";

    public static final String USER_NAME = "user_name";

    public static final String USER_ID = "user_id";

    public static final String USER_TYPE = "user_type";

    public static final String SEX = "sex";

    public static final String ID_CARD = "id_card";

    public static final String JOB = "job";

    public static final String DATA_ID = "data_id";

    public static final String TYPE = "type";

}
