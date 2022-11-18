package com.correction.backend.modules.survey.entity;

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
 * 委托单位表
 * </p>
 *
 * @author yao
 * @since 2022-11-17
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("survey_entrust_unit")
public class SurveyEntrustUnit extends BaseDO {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 单位类型,人民法院、人民检察院、公安机关、监狱/看守所
     */
    private Integer unitType;

    /**
     * 单位名称
     */
    private String unitName;

    /**
     * 联系方式
     */
    private String mobile;

    /**
     * 单位地址
     */
    private String unitAddress;

    /**
     * 组织架构num
     */
    private String orgNum;

    public static final String ID = "id";

    public static final String UNIT_TYPE = "unit_type";

    public static final String UNIT_NAME = "unit_name";

    public static final String MOBILE = "mobile";

    public static final String UNIT_ADDRESS = "unit_address";

    public static final String ORG_NUM = "org_num";

    public static final String CREATE_TIME = "create_time";

    public static final String UPDATE_TIME = "update_time";

    public static final String CREATOR = "creator";

    public static final String UPDATER = "updater";

    public static final String DELETED = "deleted";

}
