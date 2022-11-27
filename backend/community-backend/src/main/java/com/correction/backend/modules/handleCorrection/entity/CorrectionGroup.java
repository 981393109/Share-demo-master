package com.correction.backend.modules.handleCorrection.entity;

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
 * 矫正小组
 * </p>
 *
 * @author yao
 * @since 2022-11-23
 */
@Data
@Accessors(chain = true)
@TableName("correction_group")
public class CorrectionGroup {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 矫正单位
     */
    private String correctionUnit;

    /**
     * 用户类型
     */
    private String userType;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 身份证号
     */
    private String idCard;

    /**
     * 职位
     */
    private String job;

    /**
     * 矫正id
     */
    private Long handleCorrectionId;


    public static final String ID = "id";

    public static final String USER_NAME = "user_name";

    public static final String USER_ID = "user_id";

    public static final String CORRECTION_UNIT = "correction_unit";

    public static final String USER_TYPE = "user_type";

    public static final String SEX = "sex";

    public static final String ID_CARD = "id_card";

    public static final String JOB = "job";

    public static final String HANDLE_CORRECTION_ID = "handle_correction_id";

}
