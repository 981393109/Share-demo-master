package com.correction.backend.modules.sys.controller;


import cn.hutool.core.collection.CollUtil;
import com.correction.backend.modules.sys.controller.dto.sys.*;
import com.correction.backend.modules.sys.convert.sys.MDocumentCenterConvert;
import com.correction.backend.modules.sys.convert.sys.MRoleConvert;
import com.correction.backend.modules.sys.entity.DocumentCenter;
import com.correction.backend.modules.sys.entity.Role;
import com.correction.backend.modules.sys.service.DocumentCenterService;
import com.correction.framework.common.pojo.CommonResult;
import com.correction.framework.common.pojo.PageResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.validation.Valid;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.correction.framework.common.pojo.CommonResult.success;

/**
 * <p>
 * 文书参考 前端控制器
 * </p>
 *
 * @author yao
 * @since 2023-02-04
 */
@Api(tags = "系统模块-文书参考相关接口")
@RestController
@RequestMapping("/document-center")
public class DocumentCenterController {

    @Resource
    DocumentCenterService documentCenterService;


    @PostMapping(value = "/create" ,headers = "content-type=multipart/form-data")
    @ApiOperation("新增")
    public CommonResult<DocumentCenter> create(DocumentCenterCreateInputDTO createInputDTO,@RequestParam(value = "file",required = false) MultipartFile file) throws IOException {
        DocumentCenter save = documentCenterService.save(createInputDTO, file);
        return success(save);
    }

    @PostMapping(value = "/update" ,headers = "content-type=multipart/form-data")
    @ApiOperation("编辑")
    public CommonResult<DocumentCenter> update(DocumentCenterUpdateInputDTO updateInputDTO,@RequestParam(value = "file",required = false) MultipartFile file) throws IOException {
        DocumentCenter save = documentCenterService.update(updateInputDTO, file);
        return success(save);
    }

    @GetMapping("/get")
    @ApiOperation("获取详情")
    @ApiImplicitParam(name = "id", value = "id", required = true, example = "1024", dataTypeClass = Long.class)
    public CommonResult<DocumentCenterListOutputDTO> getInfo(@RequestParam("id") Long id) {
        return success(MDocumentCenterConvert.INSTANCE.toList(documentCenterService.getDetail(id)));
    }

    @GetMapping("/page")
    @ApiOperation("获得分页列表")
    public CommonResult<PageResult<DocumentCenterListOutputDTO>> getPageList(@Valid DocumentCenterSearchInputDTO reqVO) {
        // 获得用户分页列表
        PageResult<DocumentCenter> pageResult = documentCenterService.getPageList(reqVO);
        if (CollUtil.isEmpty(pageResult.getList())) {
            return success(new PageResult<>(pageResult.getTotal())); // 返回空
        }
        // 拼接结果返回
        List<DocumentCenterListOutputDTO> roleList = new ArrayList<>(pageResult.getList().size());
        pageResult.getList().forEach(role -> {
            DocumentCenterListOutputDTO respVO = MDocumentCenterConvert.INSTANCE.toList(role);
            roleList.add(respVO);
        });
        return success(new PageResult<>(roleList, pageResult.getTotal()));
    }

    @PostMapping("delete")
    @ApiOperation("删除 ids")
    public CommonResult<Boolean> delete(@Valid @RequestParam String  ids) {
        documentCenterService.delete(ids);
        return success(true);
    }


}
