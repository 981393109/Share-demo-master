package com.correction.backend.modules.information.entity;

import com.baomidou.mybatisplus.annotation.TableField;
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
 * @since 2022-11-27
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("information_message")
public class InformationMessage extends BaseDO {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 接收用户id
     */
    private Long userId;

    /**
     * 接收用户名称
     */
    @TableField(exist = false)
    private String  userName;

    /**
     * 信息类型(1：审批 2：通告 3：其他)
     */
    private Integer msgType;

    /**
     * 标题
     */
    private String msgTitle;

    /**
     * 信息内容
     */
    private String msgInfo;

    /**
     * 发起人名称
     */
    private String originator;

    /**
     * 发起人id
     */
    private Long originatorId;

    /**
     * 信息源id
     */
    private Long dataId;

    /**
     *  @ApiModelProperty(value = "信息类别 SURVEY_FLOW: 调查评估  HANDLE_CORRECTION_FLOW: 办理矫正    。。。")
     */
    private String  dataType;

    /**
     * 0未读 1已读
     */
    private Integer status;

    /**
     * 流程任务id
     */
    private String taskId;

    public static final String ID = "id";

    public static final String USER_ID = "user_id";

    public static final String MSG_TYPE = "msg_type";

    public static final String MSG_TITLE = "msg_title";

    public static final String MSG_INFO = "msg_info";

    public static final String ORIGINATOR = "originator";

    public static final String ORIGINATOR_ID = "originator_id";

    public static final String DATA_ID = "data_id";

    public static final String DATA_TYPE = "data_type";

    public static final String STATUS = "status";

    public static final String TASK_ID = "task_id";

    public static final String CREATE_TIME = "create_time";

    public static final String UPDATE_TIME = "update_time";

    public static final String CREATOR = "creator";

    public static final String UPDATER = "updater";

    public static final String DELETED = "deleted";

}
