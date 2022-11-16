package com.correction.backend.modules.survey.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.correction.backend.modules.file.controller.dto.FilePathDTO;
import com.correction.backend.modules.file.service.FileResouceService;
import com.correction.backend.modules.survey.constant.SurveyConstant;
import com.correction.backend.modules.survey.service.SurveyDocumentsFilesService;
import com.correction.backend.modules.survey.entity.SurveyDocumentsFiles;
import com.correction.backend.modules.survey.mapper.SurveyDocumentsFilesMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.correction.backend.modules.sys.entity.Dict;
import com.correction.backend.modules.sys.mapper.DictMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 文书附件上传 服务实现类
 * </p>
 *
 * @author yao
 * @since 2022-11-15
 */
@Service
@Slf4j
public class SurveyDocumentsFilesServiceImpl extends ServiceImpl<SurveyDocumentsFilesMapper, SurveyDocumentsFiles> implements SurveyDocumentsFilesService {

    @Resource
    private DictMapper dictMapper;

    @Resource
    private FileResouceService fileResouceService;


    @Override
    public List<SurveyDocumentsFiles> initSurveyDocumentFile(Long dataId, Integer dictType, Integer doc_subject) {
        //葛奴dictType查到对应的类型数据
        List<SurveyDocumentsFiles> result = new ArrayList<>();
        List<Dict> dicts = dictMapper.selectDictByType(dictType);
        if(CollectionUtil.isEmpty(dicts)){
            return result;
        }
        //保存结果：
        for (Dict dict : dicts) {
            SurveyDocumentsFiles surveyDocumentsFiles = new SurveyDocumentsFiles();
            surveyDocumentsFiles.setDataId(dataId);
            surveyDocumentsFiles.setDocSubject(doc_subject);
            surveyDocumentsFiles.setDocName(dict.getDictName());
            surveyDocumentsFiles.setDocStatus(SurveyConstant.DOC_NORMAL);
            baseMapper.insert(surveyDocumentsFiles);
            result.add(surveyDocumentsFiles);
        }
        return result;
    }

    @Override
    public void deleteByDataId(Long dataId) {
        remove(Wrappers.<SurveyDocumentsFiles>lambdaQuery().eq(SurveyDocumentsFiles::getDataId,dataId));
    }


    @Override
    public void saveFile(Long dataId, MultipartFile file) throws IOException {
        FilePathDTO fileFilePath = fileResouceService.createFileFilePath(file);
        SurveyDocumentsFiles surveyDocumentsFiles = baseMapper.selectById(dataId);
        surveyDocumentsFiles.setFileName(file.getName());
        surveyDocumentsFiles.setFilePath(fileFilePath.getLocalPath());
        surveyDocumentsFiles.setFileUrl(fileFilePath.getUrlPath());
        surveyDocumentsFiles.setFileType(fileFilePath.getFileType());
        baseMapper.updateById(surveyDocumentsFiles);
    }


}
