package com.correction.backend.modules.survey.controller;


import cn.hutool.core.collection.CollUtil;
import com.correction.backend.modules.file.config.FileProperties;
import com.correction.backend.modules.file.entity.FileResouce;
import com.correction.backend.modules.file.service.FileResouceService;
import com.correction.backend.modules.survey.controller.dto.*;
import com.correction.backend.modules.survey.convert.MSurveyDocumentsFilesConvert;
import com.correction.backend.modules.survey.convert.MSurveyEvaluationConvert;
import com.correction.backend.modules.survey.entity.SurveyDocumentsFiles;
import com.correction.backend.modules.survey.entity.SurveyEvaluation;
import com.correction.backend.modules.survey.service.SurveyDocumentsFilesService;
import com.correction.framework.common.pojo.CommonResult;
import com.correction.framework.common.pojo.PageResult;
import com.correction.framework.common.util.servlet.ServletUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.correction.framework.common.pojo.CommonResult.success;

@Api(tags = "文书管理-文书上传相关接口")
@RestController
@RequestMapping("/survey-files")
@Validated
public class SurveyDocumentsFIlesController {

    @Resource
    private SurveyDocumentsFilesService surveyDocumentsFilesService;

    @Resource
    private FileProperties fileProperties;


    @PostMapping("/upload")
    @ApiOperation("文书上传(单文件)")
    public CommonResult<Boolean> upload(Long dataId,Integer dictType,String  dictValue, MultipartFile file) throws IOException {
        surveyDocumentsFilesService.saveFile(dataId,dictType,dictValue,file);
        return success(true);
    }

    @PostMapping("/delete")
    @ApiOperation("删除文书附件")
    public CommonResult<Boolean> delete(Long id ) throws IOException {
        surveyDocumentsFilesService.deleteById(id);
        return success(true);
    }

    @PostMapping("/download")
    @ApiOperation("文书下载")
    public void download(HttpServletResponse response, @Valid Long id) throws IOException {
        SurveyDocumentsFiles byId = surveyDocumentsFilesService.getById(id);
        if (byId == null) {
            response.setStatus(HttpStatus.NOT_FOUND.value());
            return;
        }
        String linuxpath = fileProperties.getLinuxpath();
        File file = ServletUtils.downloadFileFromUrl(byId.getFileUrl(), linuxpath + File.separator + "TEMP" + File.separator + byId.getFileName());
        ServletUtils.writeAsFileDelStream(file,response);
    }

    @GetMapping("/getPageList")
    @ApiOperation("获取文书列表信息")
    public CommonResult<PageResult<SurveyDocumentsFilesDTO>> getUserPage(@Valid SurveyDocumentsFilesQuery reqVO) {
        // 获得用户分页列表
        PageResult<SurveyDocumentsFilesDTO> pageResult = surveyDocumentsFilesService.getSurveyDocumentPage(reqVO);
        if (CollUtil.isEmpty(pageResult.getList())) {
            return success(new PageResult<>(pageResult.getTotal())); // 返回空
        }
        return success(pageResult);
    }


}
