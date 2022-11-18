package com.correction.backend.modules.file.service.impl;

import cn.hutool.core.io.FileTypeUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IoUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.correction.backend.modules.file.config.FileProperties;
import com.correction.backend.modules.file.controller.dto.FilePathDTO;
import com.correction.backend.modules.file.entity.FileResouce;
import com.correction.backend.modules.file.mapper.FileResouceMapper;
import com.correction.backend.modules.file.service.FileResouceService;
import com.correction.backend.modules.sys.entity.Dict;
import com.correction.backend.modules.sys.mapper.DictMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

@Service
public class FileResouceServiceImpl extends ServiceImpl<FileResouceMapper, FileResouce> implements FileResouceService {

    @Resource
    FileProperties fileProperties;


    @Override
    public synchronized String createFile(MultipartFile file) throws IOException {
        InputStream inputStream = file.getInputStream();
        String time = String.valueOf(System.currentTimeMillis());
        String filePath = time + File.separator + time.concat(file.getOriginalFilename());
        File tempFile = new File(fileProperties.getLinuxpath().concat(filePath));
        if(!tempFile.getParentFile().exists()){
            tempFile.getParentFile().mkdirs();
        }
        file.transferTo(tempFile.getAbsoluteFile());
        byte[] content = IoUtil.readBytes(inputStream);
        String originalFilename = file.getOriginalFilename();
        String fileUrl = fileProperties.getBasePath() + filePath;
        FileResouce fileResouce = new FileResouce();
        fileResouce.setFileName(originalFilename);
        fileResouce.setFileType(FileTypeUtil.getType(new ByteArrayInputStream(content)));
        fileResouce.setFilePath(filePath); // 相对路径
        fileResouce.setFileUrl(fileUrl);
        fileResouce.setContent(content);
        baseMapper.insert(fileResouce);
        return fileUrl;
    }

    @Override
    public FilePathDTO createFileFilePath(MultipartFile file) throws IOException {
        InputStream inputStream = file.getInputStream();
        String time = String.valueOf(System.currentTimeMillis());
        String originalFilename = file.getOriginalFilename();
        String fileType = originalFilename.substring(originalFilename.lastIndexOf("."));
        String filePath = time + File.separator + originalFilename;
        File tempFile = new File(fileProperties.getLinuxpath().concat(filePath));
        if(!tempFile.getParentFile().exists()){
            tempFile.getParentFile().mkdirs();
        }
        file.transferTo(tempFile.getAbsoluteFile());
        byte[] content = IoUtil.readBytes(inputStream);
        String filename = file.getOriginalFilename();
        String fileUrl = fileProperties.getBasePath() + filePath;
        FileResouce fileResouce = new FileResouce();
        fileResouce.setFileName(filename);
        fileResouce.setFileType(fileType);
        fileResouce.setFilePath(filePath); // 相对路径
        fileResouce.setFileUrl(fileUrl);
        fileResouce.setContent(content);
        baseMapper.insert(fileResouce);
        FilePathDTO filePathDTO = new FilePathDTO();
        filePathDTO.setUrlPath(fileUrl);
        filePathDTO.setLocalPath(filePath);
        filePathDTO.setFileType(fileType);
        return filePathDTO;
    }

    private String getFilePath(String originalFilename,String time) {
        return fileProperties.getLinuxpath() + File.separator + time + File.separator + time + originalFilename;
    }

    @Override
    public void deleteFile(String id) {

    }

    @Override
    public FileResouce getFile(String path) {
        FileResouce fileResouce = baseMapper.selectOne(Wrappers.<FileResouce>lambdaQuery().eq(FileResouce::getFileUrl, path));
        return fileResouce;
    }
}
