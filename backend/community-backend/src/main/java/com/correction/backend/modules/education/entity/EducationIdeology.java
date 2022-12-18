package com.correction.backend.modules.education.entity;

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
 * 思想汇报
 * </p>
 *
 * @author yao
 * @since 2022-12-12
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("education_ideology")
public class EducationIdeology extends BaseDO {

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
     * 姓名
     */
    private String userName;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 汇报日期
     */
    private String reportDate;

    /**
     * 表现情况
     */
    private String performanceInformation;

    /**
     * 分值
     */
    private String benchmarkScore;

    /**
     * 得分
     */
    private String score;

    /**
     * 组织id
     */
    private Long orgNum;

    public static final String ID = "id";

    public static final String CORRECTION_UNIT = "correction_unit";

    public static final String CORRECTION_UNIT_ID = "correction_unit_id";

    public static final String USER_NAME = "user_name";

    public static final String USER_ID = "user_id";

    public static final String REPORT_DATE = "report_date";

    public static final String PERFORMANCE_INFORMATION = "performance_information";

    public static final String BENCHMARK_SCORE = "benchmark_score";

    public static final String SCORE = "score";

    public static final String ORG_NUM = "org_num";

    public static final String CREATE_TIME = "create_time";

    public static final String UPDATE_TIME = "update_time";

    public static final String CREATOR = "creator";

    public static final String UPDATER = "updater";

    public static final String DELETED = "deleted";

}
