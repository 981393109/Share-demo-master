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
import com.correction.backend.modules.sys.controller.dto.sys.DictOutDTO;
import com.correction.backend.modules.sys.convert.sys.MDictConvert;
import com.correction.backend.modules.sys.entity.Dict;
import com.correction.backend.modules.sys.service.DictService;
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
    private DictService dictService;

    @Resource
    private FileProperties fileProperties;


    @PostMapping("/upload")
    @ApiOperation("文书上传(单文件)")
    public CommonResult<Boolean> upload(Long dataId,Integer dictType,String  dictValue, MultipartFile file) throws IOException {
        surveyDocumentsFilesService.saveFile(dataId,dictType,dictValue,file);
        return success(true);
    }

    @PostMapping("/uploadfiles")
    @ApiOperation("文书上传(多文件)")
    public CommonResult<Boolean> uploadfiles(@RequestParam("dataId")  Long dataId,@RequestParam("dictType") Integer dictType,@RequestParam("dictValue") String  dictValue,@RequestParam("files") MultipartFile[] files) throws IOException {
        surveyDocumentsFilesService.saveFiles(dataId,dictType,dictValue,files);
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
    @ApiOperation("获取文书列表信息(分页)")
    public CommonResult<PageResult<SurveyDocumentsFilesDTO>> getSurveyDocumentPage(@Valid SurveyDocumentsFilesQuery reqVO) {
        // 获得用户分页列表
        PageResult<SurveyDocumentsFilesDTO> pageResult = surveyDocumentsFilesService.getSurveyDocumentPage(reqVO);
        if (CollUtil.isEmpty(pageResult.getList())) {
            return success(new PageResult<>(pageResult.getTotal())); // 返回空
        }
        return success(pageResult);
    }

    @GetMapping("/getList")
    @ApiOperation("获取文书列表信息")
    public CommonResult<List<SurveyDocumentsFilesDTO>> getSurveyDocumentList(@Valid SurveyDocumentsFilesListQuery reqVO) {
        // 获得用户分页列表
        List<SurveyDocumentsFilesDTO> surveyDocumentList = surveyDocumentsFilesService.getSurveyDocumentList(reqVO);
        return success(surveyDocumentList);
    }



    @GetMapping("/getType")
    @ApiOperation("获取文档用途类型(2:委托检查材料; 3:调查实施材料;4:审核评估;  5:文书补充,6:人员报到,7:信息采集,8:报备手续材料,9:告知书,10:矫正小组,11:矫正方案;12:矫正宣言)")
    public CommonResult<List<DictOutDTO>> getType(@RequestParam("type") Integer type) {
        // 获得用户分页列表
        List<Dict> list = dictService.selectDictByType(type);
        List<DictOutDTO> result = MDictConvert.INSTANCE.convertList(list);
        return success(result);
    }


}
