package com.correction.backend.modules.flow.entity;

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
 * 
 * </p>
 *
 * @author yao
 * @since 2022-11-16
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("flow_center")
public class FlowCenter extends BaseDO {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 节点名称
     */
    private String name;

    /**
     * 流程类型
     */
    private String  flowType;

    /**
     * 0:角色 1:部门 2:人员(暂且支持角色)
     */
    private String relationType;

    /**
     * 流程状态 0 进行中 1 完成  2 拒绝 3 驳回 
     */
    private Integer flowStatus;

    /**
     * 申请时间
     */
    private Date flowApplyTime;

    /**
     * 流程结束时间
     */
    private Date flowEndTime;

    /**
     * 申请人code
     */
    private String flowApplyUser;

    /**
     * 申请人名称
     */
    private String flowApplyName;

    /**
     * 通过方式 0：一人通过则通过  1：全部通过则通过
     */
    private String passType;


    public static final String ID = "id";

    public static final String FLOW_TYPE = "flow_type";

    public static final String FLOW_STATUS = "flow_status";

    public static final String FLOW_APPLY_TIME = "flow_apply_time";

    public static final String FLOW_END_TIME = "flow_end_time";

    public static final String FLOW_APPLY_USER = "flow_apply_user";

    public static final String FLOW_APPLY_NAME = "flow_apply_name";


}
