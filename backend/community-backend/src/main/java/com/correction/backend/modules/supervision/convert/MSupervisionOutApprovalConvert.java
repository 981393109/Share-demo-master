package com.correction.backend.modules.supervision.convert;

import com.correction.backend.modules.supervision.controller.dto.*;
import com.correction.backend.modules.supervision.entity.SupervisionOutApproval;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Author：yao
 * @Description: 外出审批流程 转换类
 * @Date: 2022-12-02
 */

@Mapper
public interface MSupervisionOutApprovalConvert {

    MSupervisionOutApprovalConvert INSTANCE = Mappers.getMapper(MSupervisionOutApprovalConvert.class);

    SupervisionOutApproval toSupervisionOutApproval(SupervisionOutApprovalSearchInputDTO supervisionOutApprovalSearchInputDTO);

    SupervisionOutApproval toSupervisionOutApproval(SupervisionOutApprovalCreateInputDTO supervisionOutApprovalCreateInputDTO);

    SupervisionOutApproval toSupervisionOutApproval(SupervisionOutApprovalUpdateInputDTO supervisionOutApprovalUpdateInputDTO);

    SupervisionOutApprovalListOutputDTO toList(SupervisionOutApproval supervisionOutApproval);

    List<SupervisionOutApprovalListOutputDTO> toList(List<SupervisionOutApproval> supervisionOutApprovals);

    TerminateLeaveDTO toTerminateLeaveDTO (SupervisionOutApproval supervisionOutApproval);
}