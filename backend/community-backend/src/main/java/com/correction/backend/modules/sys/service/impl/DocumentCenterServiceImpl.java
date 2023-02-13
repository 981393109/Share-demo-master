package com.correction.backend.modules.sys.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.correction.backend.modules.file.service.FileResouceService;
import com.correction.backend.modules.sys.controller.dto.sys.DocumentCenterCreateInputDTO;
import com.correction.backend.modules.sys.controller.dto.sys.DocumentCenterListOutputDTO;
import com.correction.backend.modules.sys.controller.dto.sys.DocumentCenterSearchInputDTO;
import com.correction.backend.modules.sys.controller.dto.sys.DocumentCenterUpdateInputDTO;
import com.correction.backend.modules.sys.convert.sys.MDocumentCenterConvert;
import com.correction.backend.modules.sys.service.DocumentCenterService;
import com.correction.framework.common.pojo.PageResult;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.correction.backend.modules.sys.entity.DocumentCenter;
import com.correction.backend.modules.sys.mapper.DocumentCenterMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 文书参考 服务实现类
 * </p>
 *
 * @author yao
 * @since 2023-02-04
 */
@Service
public class DocumentCenterServiceImpl extends ServiceImpl<DocumentCenterMapper, DocumentCenter> implements DocumentCenterService {


    @Resource
    private FileResouceService fileResouceService;


    /**
     * 获取表格数据
     *
     * @param documentCenter
     * @return
     */
    public PageResult<DocumentCenter> pageListByEntity(DocumentCenterSearchInputDTO documentCenter) {
        LambdaQueryWrapper<DocumentCenter> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.like(StrUtil.isNotBlank(documentCenter.getUseType()), DocumentCenter::getUseType, documentCenter.getUseType());
        queryWrapper.like(StrUtil.isNotBlank(documentCenter.getFileName()), DocumentCenter::getFileName, documentCenter.getFileName());
        queryWrapper.like(StrUtil.isNotBlank(documentCenter.getFilePath()), DocumentCenter::getFilePath, documentCenter.getFilePath());
        queryWrapper.like(StrUtil.isNotBlank(documentCenter.getCreator()), DocumentCenter::getCreator, documentCenter.getCreator());
        queryWrapper.like(StrUtil.isNotBlank(documentCenter.getUpdater()), DocumentCenter::getUpdater, documentCenter.getUpdater());
        return baseMapper.selectPage(documentCenter, queryWrapper);
    }


    @Override
    public DocumentCenter save(DocumentCenterCreateInputDTO createInputDTO, MultipartFile file) throws IOException {
        DocumentCenter documentCenter = MDocumentCenterConvert.INSTANCE.toDocumentCenter(createInputDTO);
        //存贮file
        String localFile = fileResouceService.createFile(file);
        documentCenter.setFilePath(localFile);
        documentCenter.setFileName(file.getName());
        save(documentCenter);
        return documentCenter;
    }

    @Override
    public DocumentCenter update(DocumentCenterUpdateInputDTO updateInputDTO, MultipartFile file) throws IOException {
        DocumentCenter documentCenter = MDocumentCenterConvert.INSTANCE.toDocumentCenter(updateInputDTO);
        if(file!=null){
            //存贮file
            String localFile = fileResouceService.createFile(file);
            documentCenter.setFilePath(localFile);
            documentCenter.setFileName(file.getName());
            updateById(documentCenter);
        }
        return documentCenter;
    }

    @Override
    public DocumentCenter getDetail(Long id) {
        DocumentCenter byId = getById(id);
        return byId;
    }

    @Override
    public List<DocumentCenter> getList(DocumentCenterListOutputDTO documentCenter) {
        LambdaQueryWrapper<DocumentCenter> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.like(StrUtil.isNotBlank(documentCenter.getUseType()), DocumentCenter::getUseType, documentCenter.getUseType());
        queryWrapper.like(StrUtil.isNotBlank(documentCenter.getFileName()), DocumentCenter::getFileName, documentCenter.getFileName());
        queryWrapper.like(StrUtil.isNotBlank(documentCenter.getFilePath()), DocumentCenter::getFilePath, documentCenter.getFilePath());
        queryWrapper.like(StrUtil.isNotBlank(documentCenter.getCreator()), DocumentCenter::getCreator, documentCenter.getCreator());
        queryWrapper.like(StrUtil.isNotBlank(documentCenter.getUpdater()), DocumentCenter::getUpdater, documentCenter.getUpdater());
        List<DocumentCenter> list = list(queryWrapper);
        return list;
    }

    @Override
    public PageResult<DocumentCenter> getPageList(DocumentCenterSearchInputDTO searchInputDTO) {
        return pageListByEntity(searchInputDTO);
    }

    @Override
    public void delete(String ids) {
        List<Long> collect = Arrays.stream(ids.split(",")).map(e -> Long.parseLong(e)).collect(Collectors.toList());
        removeByIds(collect);
    }
}
