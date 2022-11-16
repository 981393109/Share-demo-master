package com.correction.backend.modules.file.entity;

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
 * 文件资源目录表
 * </p>
 *
 * @author yao
 * @since 2022-11-13
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("file_resouce")
public class FileResouce extends BaseDO {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 文件名称
     */
    private String fileName;

    /**
     * 相对路径
     */
    private String filePath;

    /**
     * 文件类型
     */
    private String fileType;

    /**
     * 文件路径
     */
    private String fileUrl;

    private byte [] content;


    public static final String ID = "id";

    public static final String FILE_NAME = "file_name";

    public static final String FILE_PATH = "file_path";

    public static final String FILE_TYPE = "file_type";

    public static final String FILE_URL = "file_url";

}
