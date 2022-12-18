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
 * 个别教育
 * </p>
 *
 * @author yao
 * @since 2022-12-06
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("education_individual")
public class EducationIndividual extends BaseDO {

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
     * 谈话日期
     */
    private String talkDate;

    /**
     * 谈话人
     */
    private String talkUser;

    /**
     * 记录人
     */
    private String recordUser;

    /**
     * 谈话地点
     */
    private String talkAddress;

    /**
     * 谈话内容
     */
    private String talkContent;

    /**
     * 备注
     */
    private String remark;

    /**
     * 组织id
     */
    private Long orgNum;


    public static final String ID = "id";

    public static final String CORRECTION_UNIT = "correction_unit";

    public static final String CORRECTION_UNIT_ID = "correction_unit_id";

    public static final String USER_NAME = "user_name";

    public static final String USER_ID = "user_id";

    public static final String TALK_DATE = "talk_date";

    public static final String TALK_USER = "talk_user";

    public static final String RECORD_USER = "record_user";

    public static final String TALK_ADDRESS = "talk_address";

    public static final String TALK_CONTENT = "talk_content";

    public static final String REMARK = "remark";

    public static final String ORG_NUM = "org_num";

    public static final String CREATE_TIME = "create_time";

    public static final String UPDATE_TIME = "update_time";

    public static final String CREATOR = "creator";

    public static final String UPDATER = "updater";

    public static final String DELETED = "deleted";

}
