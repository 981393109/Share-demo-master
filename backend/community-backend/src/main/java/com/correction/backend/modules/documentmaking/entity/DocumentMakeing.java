package com.correction.backend.modules.documentmaking.entity;

import com.correction.frameworks.mybatis.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import java.io.Serializable;

/**
 * <p>
 * 制作文书
 * </p>
 *
 * @author yao
 * @since 2022-11-26
 */
@Data
@Accessors(chain = true)
@TableName("document_makeing")
public class DocumentMakeing {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 数据id
     */
    private Long dataId;

    /**
     * 类型
     */
    private Integer dataType;

    /**
     * 文件名称
     */
    private String fileName;

    /**
     * 文件路径
     */
    private String filePath;

    private String fileUrl;


    public static final String ID = "id";

    public static final String DATA_ID = "data_id";

    public static final String DATA_TYPE = "data_type";

    public static final String FILE_NAME = "file_name";

    public static final String FILE_PATH = "file_path";

}
