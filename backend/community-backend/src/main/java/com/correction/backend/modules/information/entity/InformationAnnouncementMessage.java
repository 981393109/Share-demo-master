package com.correction.backend.modules.information.entity;

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
 * 公告信息
 * </p>
 *
 * @author yao
 * @since 2022-12-04
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("information_announcement_message")
public class InformationAnnouncementMessage extends BaseDO {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

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
     * 1 有效 2关闭
     */
    private Integer status;

    private String  msgDate;


    public static final String ID = "id";

    public static final String MSG_TITLE = "msg_title";

    public static final String MSG_INFO = "msg_info";

    public static final String ORIGINATOR = "originator";

    public static final String ORIGINATOR_ID = "originator_id";

    public static final String CREATE_TIME = "create_time";

    public static final String UPDATE_TIME = "update_time";

    public static final String CREATOR = "creator";

    public static final String UPDATER = "updater";

    public static final String DELETED = "deleted";

    public static final String STATUS = "status";

}
