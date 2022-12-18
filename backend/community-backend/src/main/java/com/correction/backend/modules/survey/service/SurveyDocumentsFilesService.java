package com.correction.backend.modules.survey.service;

import com.correction.backend.modules.survey.controller.dto.SurveyDocumentsFilesDTO;
import com.correction.backend.modules.survey.controller.dto.SurveyDocumentsFilesListQuery;
import com.correction.backend.modules.survey.controller.dto.SurveyDocumentsFilesQuery;
import com.correction.backend.modules.survey.controller.dto.SurveyDocumentsFilesSearchInputDTO;
import com.correction.backend.modules.survey.entity.SurveyDocumentsFiles;
import com.baomidou.mybatisplus.extension.service.IService;
import com.correction.framework.common.pojo.PageResult;
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
    List<SurveyDocumentsFiles> initSurveyDocumentFile(Long dataId, Integer dictType, Integer doc_subject);

    /**
     * 删除文书记录
     */
    void deleteByDataId(Long dataId);

    SurveyDocumentsFiles saveFile(Long dataId, Integer dictType, String dictValue, MultipartFile file) throws IOException;

    PageResult<SurveyDocumentsFilesDTO> getSurveyDocumentPage(SurveyDocumentsFilesQuery query);

    List<SurveyDocumentsFilesDTO> getSurveyDocumentList(SurveyDocumentsFilesListQuery query);

    List<SurveyDocumentsFilesDTO> getSurveyDocumentList(SurveyDocumentsFilesQuery query);

    void deleteById(Long id);

    PageResult<SurveyDocumentsFilesDTO> surveyDocFilePage(SurveyDocumentsFilesQuery reqVO);

    List<SurveyDocumentsFiles> saveFiles(Long dataId, Integer dictType, String dictValue, MultipartFile[] files) throws IOException;
}
