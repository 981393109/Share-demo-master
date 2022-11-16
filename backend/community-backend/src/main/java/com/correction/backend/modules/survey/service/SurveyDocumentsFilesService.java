package com.correction.backend.modules.survey.service;

import com.correction.backend.modules.survey.entity.SurveyDocumentsFiles;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * <p>
 * 文书附件上传 服务类
 * </p>
 *
 * @author yao
 * @since 2022-11-15
 */
public interface SurveyDocumentsFilesService extends IService<SurveyDocumentsFiles> {

    /**
     * 初始化文书附件
     * 源数据id.,
     * 字典类型
     * 文书大类
     */
    List<SurveyDocumentsFiles> initSurveyDocumentFile(Long dataId ,Integer dictType,Integer doc_subject);


    /**
     * 删除文书记录
     */
    void deleteByDataId (Long dataId);

    void saveFile(Long dataId, MultipartFile file) throws IOException;
}
