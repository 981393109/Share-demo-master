package com.correction.backend.modules.survey.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.correction.backend.modules.file.config.FileProperties;
import com.correction.backend.modules.file.controller.dto.FilePathDTO;
import com.correction.backend.modules.file.service.FileResouceService;
import com.correction.backend.modules.survey.constant.SurveyConstant;
import com.correction.backend.modules.survey.controller.dto.SurveyDocumentsFilesDTO;
import com.correction.backend.modules.survey.controller.dto.SurveyDocumentsFilesListQuery;
import com.correction.backend.modules.survey.controller.dto.SurveyDocumentsFilesQuery;
import com.correction.backend.modules.survey.service.SurveyDocumentsFilesService;
import com.correction.backend.modules.survey.entity.SurveyDocumentsFiles;
import com.correction.backend.modules.survey.mapper.SurveyDocumentsFilesMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.correction.backend.modules.sys.entity.Dict;
import com.correction.backend.modules.sys.mapper.DictMapper;
import com.correction.framework.common.pojo.PageResult;
import com.correction.frameworks.mybatis.mybatis.core.util.MyBatisUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.regexp.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    @Resource
    private FileProperties fileProperties;


    @Override
    public List<SurveyDocumentsFiles> initSurveyDocumentFile(Long dataId, Integer dictType, Integer doc_subject) {
        //葛奴dictType查到对应的类型数据
        List<SurveyDocumentsFiles> result = new ArrayList<>();


        return result;
    }

    @Override
    public void deleteByDataId(Long dataId) {
        remove(Wrappers.<SurveyDocumentsFiles>lambdaQuery().eq(SurveyDocumentsFiles::getDataId,dataId));
    }

    /**
     * 保存数据
     * @param dataId
     * @param dictType
     * @param dictValue
     * @param file
     * @throws IOException
     */
    @Override
    public SurveyDocumentsFiles saveFile(Long dataId,Integer dictType,String  dictValue, MultipartFile file) throws IOException {
        FilePathDTO fileFilePath = fileResouceService.createFileFilePath(file);
        SurveyDocumentsFiles surveyDocumentsFiles  = new SurveyDocumentsFiles();
        surveyDocumentsFiles.setDictType(dictType);
        surveyDocumentsFiles.setDictValue(dictValue);
        surveyDocumentsFiles.setDataId(dataId);
        surveyDocumentsFiles.setFileStatus(SurveyConstant.DOC_SUC);
        surveyDocumentsFiles.setFileName(file.getOriginalFilename());
        surveyDocumentsFiles.setFilePath(fileFilePath.getLocalPath());
        surveyDocumentsFiles.setFileUrl(fileFilePath.getUrlPath());
        surveyDocumentsFiles.setFileType(fileFilePath.getFileType());
        baseMapper.insert(surveyDocumentsFiles);
        return surveyDocumentsFiles;
    }


    @Override
    public PageResult<SurveyDocumentsFilesDTO> getSurveyDocumentPage(SurveyDocumentsFilesQuery query) {
        IPage<SurveyDocumentsFilesDTO> mpPage = MyBatisUtils.buildPage(query);
        mpPage = baseMapper.getPageList(mpPage, query);
        return new PageResult<>(mpPage.getRecords(), mpPage.getTotal());
    }

    @Override
    public List<SurveyDocumentsFilesDTO> getSurveyDocumentList(SurveyDocumentsFilesListQuery query) {
        return baseMapper.getListInfo(query);
    }

    @Override
    public List<SurveyDocumentsFilesDTO> getSurveyDocumentList(SurveyDocumentsFilesQuery query) {
        List<Dict> dicts = dictMapper.selectList(Wrappers.<Dict>lambdaQuery().eq(Dict::getDictType, query.getDictType()));
        List<SurveyDocumentsFilesDTO> list = baseMapper.getList(query);
        List<Integer> collect = list.stream().map(e -> e.getDictValue()).collect(Collectors.toList());
        for (Dict dict : dicts) {
            if(!collect.contains(dict.getDictValue())){
                SurveyDocumentsFilesDTO newDto = new SurveyDocumentsFilesDTO();
                newDto.setDictType(dict.getDictType());
                newDto.setDictValue(dict.getDictValue());
                newDto.setDictName(dict.getDictName());
                newDto.setUseType(dict.getUseType());
                list.add(newDto);
            }
        }
        return list;
    }

    @Override
    public void deleteById(Long id) {
        //得到附件地址
        SurveyDocumentsFiles surveyDocumentsFiles = baseMapper.selectById(id);
        String filePath = surveyDocumentsFiles.getFilePath();
        String s = fileProperties.getLinuxpath() + filePath;
        File file = new File(s);
        if (file.exists()){
            file.delete();
        }
        baseMapper.deleteById(id);
    }

    @Override
    public PageResult<SurveyDocumentsFilesDTO> surveyDocFilePage(SurveyDocumentsFilesQuery query) {
        IPage<SurveyDocumentsFilesDTO> mpPage = MyBatisUtils.buildPage(query);
        mpPage = baseMapper.getAllFilePage(mpPage, query);
        return new PageResult<>(mpPage.getRecords(), mpPage.getTotal());
    }

    @Override
    public List<SurveyDocumentsFiles> saveFiles(Long dataId, Integer dictType, String dictValue, MultipartFile[] files) throws IOException {
        List<SurveyDocumentsFiles> list = new ArrayList<>();
        for (MultipartFile file : files) {
            list.add(this.saveFile(dataId,dictType,dictValue,file));
        }
        return list;
    }


}
