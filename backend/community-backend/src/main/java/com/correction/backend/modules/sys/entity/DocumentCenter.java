package com.correction.backend.modules.sys.entity;

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
 * 文书参考
 * </p>
 *
 * @author yao
 * @since 2023-02-04
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("document_center")
public class DocumentCenter extends BaseDO {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 文书用途
     */
    private String useType;

    /**
     * 1 可用 2 不可用
     */
    private Integer status;

    /**
     * 文件名称
     */
    private String fileName;

    /**
     * 文件路径
     */
    private String filePath;



    public static final String ID = "id";

    public static final String USE_TYPE = "use_type";

    public static final String STATUS = "status";

    public static final String FILE_NAME = "file_name";

    public static final String FILE_PATH = "file_path";

    public static final String CREATE_TIME = "create_time";

    public static final String UPDATE_TIME = "update_time";

    public static final String CREATOR = "creator";

    public static final String UPDATER = "updater";

    public static final String DELETED = "deleted";

}
