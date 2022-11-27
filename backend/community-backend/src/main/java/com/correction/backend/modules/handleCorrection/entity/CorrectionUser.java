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
 * 矫正人员
 * </p>
 *
 * @author yao
 * @since 2022-11-23
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("correction_user")
public class CorrectionUser extends BaseDO {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 出生日期
     */
    private String birthday;

    /**
     * 户籍
     */
    private String household;

    /**
     * 籍贯
     */
    private String nativePlace;

    /**
     * 居住地
     */
    private String address;

    /**
     * 联系电话
     */
    private String mobile;

    /**
     * 婚姻状况
     */
    private String maritalStatus;

    /**
     * 职业
     */
    private String professional;

    /**
     * 经济状况
     */
    private String economyState;

    /**
     * 所属辖区
     */
    private String areaJurisdiction;

    /**
     * 所属街道
     */
    private String streetJurisdiction;

    /**
     * 案由
     */
    private String causeAction;

    /**
     * 办理入矫id
     */
    private Long handleCorrectionId;

    /**
     * 组织架构num
     */
    private String orgNum;

    /**
     * 是否历史
     */
    private Integer isHistory;

    public static final String ID = "id";

    public static final String NAME = "name";

    public static final String SEX = "sex";

    public static final String BIRTHDAY = "birthday";

    public static final String HOUSEHOLD = "household";

    public static final String NATIVE_PLACE = "native_place";

    public static final String ADDRESS = "address";

    public static final String MOBILE = "mobile";

    public static final String MARITAL_STATUS = "marital_status";

    public static final String PROFESSIONAL = "professional";

    public static final String ECONOMY_STATE = "economy_state";

    public static final String AREA_JURISDICTION = "area_jurisdiction";

    public static final String STREET_JURISDICTION = "street_jurisdiction";

    public static final String CAUSE_ACTION = "cause_action";

    public static final String HANDLE_CORRECTION_ID = "handle_correction_id";

    public static final String ORG_NUM = "org_num";

    public static final String CREATE_TIME = "create_time";

    public static final String UPDATE_TIME = "update_time";

    public static final String CREATOR = "creator";

    public static final String UPDATER = "updater";

    public static final String DELETED = "deleted";

}
