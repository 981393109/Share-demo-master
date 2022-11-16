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
 * 文书附件上传
 * </p>
 *
 * @author yao
 * @since 2022-11-15
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("survey_documents_files")
public class SurveyDocumentsFiles extends BaseDO {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 文档源头id
     */
    private Long dataId;

    /**
     * 文档名称
     */
    private String docName;

    /**
     * 文档状态 1：已上传 2上传失败
     */
    private Integer docStatus;

    /**
     * 相对路径
     */
    private String filePath;

    /**
     * 文件路径
     */
    private String fileUrl;

    /**
     * 文件名称
     */
    private String fileName;

    /**
     * 文件类型
     */
    private String fileType;

    /**
     * 文书大类 1：调查评估
     */
    private Integer docSubject;

  
    public static final String ID = "id";

    public static final String DATA_ID = "data_id";

    public static final String DOC_NAME = "doc_name";

    public static final String DOC_STATUS = "doc_status";

    public static final String FILE_PATH = "file_path";

    public static final String FILE_URL = "file_url";

    public static final String FILE_NAME = "file_name";

    public static final String FILE_TYPE = "file_type";

    public static final String DOC_SUBJECT = "doc_subject";

    public static final String CREATE_TIME = "create_time";

    public static final String UPDATE_TIME = "update_time";

    public static final String CREATOR = "creator";

    public static final String UPDATER = "updater";

    public static final String DELETED = "deleted";

}
