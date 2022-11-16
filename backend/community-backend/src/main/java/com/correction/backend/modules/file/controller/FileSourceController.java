package com.correction.backend.modules.file.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IoUtil;
import com.correction.backend.modules.file.entity.FileResouce;
import com.correction.backend.modules.file.service.FileResouceService;
import com.correction.framework.common.pojo.CommonResult;
import com.correction.framework.common.util.servlet.ServletUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import static com.correction.framework.common.pojo.CommonResult.success;


@Api(tags = "文件存储-文件上传下载")
@RestController
@RequestMapping("/file")
@Validated
@Slf4j
public class FileSourceController {


    @Resource
    private FileResouceService fileResouceService;

    @PostMapping("/upload")
    @ApiOperation("上传文件")
    public CommonResult<String> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        return success(fileResouceService.createFile(file));
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除文件")
    @ApiImplicitParam(name = "id", value = "编号", required = true)
    public CommonResult<Boolean> deleteFile(@RequestParam("id") String id) {
        fileResouceService.deleteFile(id);
        return success(true);
    }

    @GetMapping("/get/{path}")
    @ApiOperation("下载文件")
    @ApiImplicitParam(name = "path", value = "文件附件", required = true, dataTypeClass = MultipartFile.class)
    public void getFile(HttpServletResponse response, @PathVariable("path") String path) throws IOException {
        FileResouce file = fileResouceService.getFile(path);
        if (file == null) {
            log.warn("[getFile][path({}) 文件不存在]", path);
            response.setStatus(HttpStatus.NOT_FOUND.value());
            return;
        }
        ServletUtils.writeAttachment(response, path, file.getContent());
    }


    @GetMapping("/url")
    @ApiOperation("下载文件URL, urlencode一下哈")
    public void getFileurl(HttpServletResponse response, @RequestParam("path") String path)throws Exception {
        FileResouce file = fileResouceService.getFile(path);
        if (file == null) {
            log.warn("[getFile][path({}) 文件不存在]", path);
            response.setStatus(HttpStatus.NOT_FOUND.value());
            return;
        }
        ServletUtils.writeAttachment(response, file.getFileName(), file.getContent());
    }


}
