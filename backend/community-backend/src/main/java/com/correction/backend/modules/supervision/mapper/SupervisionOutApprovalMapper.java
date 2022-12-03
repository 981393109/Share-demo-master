package com.correction.backend.modules.supervision.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.correction.backend.modules.supervision.controller.dto.SupervisionOutApprovalList;
import com.correction.backend.modules.supervision.controller.dto.SupervisionOutApprovalSearchInputDTO;
import com.correction.backend.modules.supervision.entity.SupervisionOutApproval;
import com.correction.frameworks.mybatis.mybatis.core.mapper.BaseMapperX;
import org.apache.ibatis.annotations.Param;
//import com.baomidou.mybatisplus.core.mapper.BaseMapperX;

/**
 * <p>
 * 外出审批流程 Mapper 接口
 * </p>
 *
 * @author yao
 * @since 2022-12-02
 */
public interface SupervisionOutApprovalMapper extends BaseMapperX<SupervisionOutApproval> {

    IPage<SupervisionOutApprovalList> getPageList(@Param("page") IPage page, @Param("query") SupervisionOutApprovalSearchInputDTO query);




}
