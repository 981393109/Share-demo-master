package com.correction.backend.modules.flow.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.correction.frameworks.mybatis.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import java.io.Serializable;

/**
 * <p>
 * 审批流程节点与用户关联关系
 * </p>
 *
 * @author yao
 * @since 2022-11-19
 */
@Data
@Accessors(chain = true)
@TableName("flow_node_user")
public class FlowNodeUser{

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 部门id
     */
    private Long orgId;

    /**
     * 角色id
     */
    private Long roleId;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 流程节点id
     */
    private String nodeId;

    /**
     * 源数据id
     */
    private Long dataId;

    /**
     * flowid
     */
    private Long flowId;

    /**
     * ref
     */
    private String ref;

    /**
     * 节点名称
     */
    private String nodeName;


    public static final String ID = "id";

    public static final String ORG_ID = "org_id";

    public static final String ROLE_ID = "role_id";

    public static final String USER_ID = "user_id";

    public static final String NODE_ID = "node_id";

    public static final String DATA_ID = "data_id";

    public static final String FLOW_ID = "flow_id";

    public static final String REF = "ref";

    public static final String NODE_NAME = "node_name";

}
