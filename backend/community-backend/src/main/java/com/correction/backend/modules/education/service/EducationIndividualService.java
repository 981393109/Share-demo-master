package com.correction.backend.modules.education.service;

import com.correction.backend.modules.education.controller.dto.EducationIndividualCreateInputDTO;
import com.correction.backend.modules.education.controller.dto.EducationIndividualSearchInputDTO;
import com.correction.backend.modules.education.controller.dto.EducationIndividualUpdateInputDTO;
import com.correction.backend.modules.education.entity.EducationIndividual;
import com.baomidou.mybatisplus.extension.service.IService;
import com.correction.framework.common.pojo.PageResult;

import java.util.List;

/**
 * <p>
 * 个别教育 服务类
 * </p>
 *
 * @author yao
 * @since 2022-12-06
 */
public interface EducationIndividualService extends IService<EducationIndividual> {

    void createEducationIndividua(EducationIndividualCreateInputDTO createInputDTO);

    void updateEducationIndividua(EducationIndividualUpdateInputDTO updateInputDTO);

    EducationIndividual getDetail (Long id );

    void delete (Long id );

    PageResult<EducationIndividual> getPageList (EducationIndividualSearchInputDTO searchInputDTO);

    List<EducationIndividual> getList (EducationIndividualUpdateInputDTO updateInputDTO);


}
