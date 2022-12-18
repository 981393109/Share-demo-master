package com.correction.backend.modules.education.service;

import com.correction.backend.modules.education.controller.dto.*;
import com.correction.backend.modules.education.entity.EducationSupport;
import com.baomidou.mybatisplus.extension.service.IService;
import com.correction.framework.common.pojo.PageResult;

import java.util.List;

/**
 * <p>
 * 教育帮扶表 服务类
 * </p>
 *
 * @author yao
 * @since 2022-12-06
 */
public interface EducationSupportService extends IService<EducationSupport> {


    /**
     * 新增集中教育
     */
    void createEducationSupport (EducationSupportUserDTO educationSupportCreateInputDTO);

    /**
     * 修改集中教育
     */
    void updateEducationSupport (EducationSupportUpdateInputDTO educationSupportUpdateInputDTO);

    /**
     * 获取详情信息
     */
    EducationSupportListOutputDTO getDetail (Long id);

    /**
     * 删除
     */
    void delete (Long id );

    /**
     * 分页获取列表
     */
    PageResult<EducationSupport> getPageList (EducationSupportSearchInputDTO educationSupportSearchInputDTO);

    /**
     * 获取列表
     */
    List<EducationSupport> getList (EducationSupportInputDTO educationSupportInputDTO);


}
