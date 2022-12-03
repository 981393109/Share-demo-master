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
 * 日常报道
 * </p>
 *
 * @author yao
 * @since 2022-12-02
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("supervision_daily_report")
public class SupervisionDailyReport extends BaseDO {

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
    private Long correctionUnitId;

    /**
     * 报到日期
     */
    private String registrationDate;

    /**
     * 报到方式 1 日常报到 2电话报到
     */
    private Integer registrationWay;

    /**
     * 基准分值
     */
    private String benchmarkScore;

    /**
     * 矫正人员id
     */
    private Long userId;

    /**
     * 姓名
     */
    private String userName;

    /**
     * 报到表现
     */
    private String registrationView;

    /**
     * 得分
     */
    private String score;

    /**
     * 备注
     */
    private String remark;


    public static final String ID = "id";

    public static final String CORRECTION_UNIT = "correction_unit";

    public static final String CORRECTION_UNIT_ID = "correction_unit_id";

    public static final String REGISTRATION_DATE = "registration_date";

    public static final String REGISTRATION_WAY = "registration_way";

    public static final String BENCHMARK_SCORE = "benchmark_score";

    public static final String USER_ID = "user_id";

    public static final String USER_NAME = "user_name";

    public static final String REGISTRATION_VIEW = "registration_view";

    public static final String SCORE = "score";

    public static final String REMARK = "remark";

    public static final String CREATE_TIME = "create_time";

    public static final String UPDATE_TIME = "update_time";

    public static final String CREATOR = "creator";

    public static final String UPDATER = "updater";

    public static final String DELETED = "deleted";

}
