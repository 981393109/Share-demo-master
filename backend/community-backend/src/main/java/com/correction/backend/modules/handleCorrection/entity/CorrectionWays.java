package com.correction.backend.modules.handleCorrection.entity;

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
 * 矫正方案
 * </p>
 *
 * @author yao
 * @since 2022-11-23
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("correction_ways")
public class CorrectionWays extends BaseDO {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 矫正单位
     */
    private String correctionUnit;

    /**
     * 服刑人员
     */
    private String sentenceUser;

    /**
     * 服刑人员id
     */
    private Long sentenceUserId;

    /**
     * 方案日期
     */
    private String waysDate;

    /**
     * 情况分析
     */
    private String analysisSituation;

    /**
     * 矫正意见
     */
    private String correctionOpinion;

    /**
     * 备注
     */
    private String remark;

    /**
     * 矫正id
     */
    private Long handleCorrectionId;

    /**
     * 组织架构num
     */
    private String orgNum;

    public static final String ID = "id";

    public static final String CORRECTION_UNIT = "correction_unit";

    public static final String SENTENCE_USER = "sentence_user";

    public static final String SENTENCE_USER_ID = "sentence_user_id";

    public static final String WAYS_DATE = "ways_date";

    public static final String ANALYSIS_SITUATION = "analysis_situation";

    public static final String CORRECTION_OPINION = "correction_opinion";

    public static final String REMARK = "remark";

    public static final String HANDLE_CORRECTION_ID = "handle_correction_id";

    public static final String ORG_NUM = "org_num";

    public static final String CREATE_TIME = "create_time";

    public static final String UPDATE_TIME = "update_time";

    public static final String CREATOR = "creator";

    public static final String UPDATER = "updater";

    public static final String DELETED = "deleted";

}
