package com.correction.backend.modules.education.service;

import com.correction.backend.modules.education.controller.dto.*;
import com.correction.backend.modules.education.entity.EducationIdeology;
import com.baomidou.mybatisplus.extension.service.IService;
import com.correction.framework.common.pojo.PageResult;

import java.util.List;

/**
 * <p>
 * 思想汇报 服务类
 * </p>
 *
 * @author yao
 * @since 2022-12-12
 */
public interface EducationIdeologyService extends IService<EducationIdeology> {


    /**
     * 新增
     */
    void createEducationIdeology (EducationIdeologyCreateInputDTO createInputDTO);


    /**
     * 修改
     */
    void updateEducationIdeology (EducationIdeologyUpdateInputDTO updateInputDTO);

    /**
     * 获取详情
     */
    EducationIdeologyFileDTO getDetail (Long id );

    /**
     * 删除
     */
    void delete (Long id );


    /**
     * 获取列表
     */
    List<EducationIdeology> getList (EducationIdeologyListOutputDTO dto);

    /**
     * 分页获取列表
     */
    PageResult<EducationIdeology> getPageList (EducationIdeologySearchInputDTO dto);


}
