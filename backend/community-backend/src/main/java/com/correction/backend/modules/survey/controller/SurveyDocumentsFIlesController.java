package com.correction.backend.modules.survey.controller;


import com.correction.backend.modules.file.config.FileProperties;
import com.correction.backend.modules.file.entity.FileResouce;
import com.correction.backend.modules.file.service.FileResouceService;
import com.correction.backend.modules.survey.controller.dto.SurveyEvaluationCreateInputDTO;
import com.correction.backend.modules.survey.entity.SurveyDocumentsFiles;
import com.correction.backend.modules.survey.service.SurveyDocumentsFilesService;
import com.correction.framework.common.pojo.CommonResult;
import com.correction.framework.common.util.servlet.ServletUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import java.io.File;
import java.io.IOException;

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
    @ApiOperation("文书上传")
    public CommonResult<Boolean> upload(@Valid Long id, MultipartFile file) throws IOException {
        surveyDocumentsFilesService.saveFile(id,file);
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


}
