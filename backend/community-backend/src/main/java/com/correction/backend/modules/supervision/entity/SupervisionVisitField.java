package com.correction.backend.modules.supervision.entity;

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
 * 查访登记
 * </p>
 *
 * @author yao
 * @since 2022-12-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("supervision_visit_field")
public class SupervisionVisitField extends BaseDO {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 矫正单位
     */
    private String correctionUnit;

    /**
     * 矫正单位Id
     */
    private String correctionUnitId;

    /**
     * 服刑人员
     */
    private String userName;

    /**
     * 服刑人员id
     */
    private Long userId;

    /**
     * 查访日期
     */
    private String visitDate;

    /**
     * 查访场所
     */
    private String visitAddress;

    /**
     * 走访事由
     */
    private String visitPurpose;

    /**
     * 走访意见
     */
    private String visitOpinion;

    /**
     * 组织id
     */
    private Long orgNum;


    public static final String ID = "id";

    public static final String CORRECTION_UNIT = "correction_unit";

    public static final String CORRECTION_UNIT_ID = "correction_unit_id";

    public static final String USER_NAME = "user_name";

    public static final String USER_ID = "user_id";

    public static final String VISIT_DATE = "visit_date";

    public static final String VISIT_ADDRESS = "visit_address";

    public static final String VISIT_PURPOSE = "visit_purpose";

    public static final String VISIT_OPINION = "visit_opinion";

    public static final String ORG_NUM = "org_num";

    public static final String CREATE_TIME = "create_time";

    public static final String UPDATE_TIME = "update_time";

    public static final String CREATOR = "creator";

    public static final String UPDATER = "updater";

    public static final String DELETED = "deleted";

}
