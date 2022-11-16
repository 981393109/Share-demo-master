package com.correction.backend.modules.file.service;

import com.correction.backend.modules.file.controller.dto.FilePathDTO;
import com.correction.backend.modules.file.entity.FileResouce;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * <p>
 * 文件资源目录表 服务类
 * </p>
 *
 * @author yao
 * @since 2022-11-13
 */
public interface FileResouceService extends IService<FileResouce> {

    String createFile(MultipartFile file) throws IOException;

    FilePathDTO createFileFilePath(MultipartFile file) throws IOException;

    void deleteFile(String id);

    FileResouce getFile(String path);
}
