package com.correction.backend.modules.supervision.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.correction.backend.modules.supervision.controller.dto.*;
import com.correction.backend.modules.supervision.entity.SupervisionOutApproval;
import com.baomidou.mybatisplus.extension.service.IService;
import com.correction.framework.common.pojo.PageResult;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 * 外出审批流程 服务类
 * </p>
 *
 * @author yao
 * @since 2022-12-02
 */
public interface SupervisionOutApprovalService extends IService<SupervisionOutApproval> {


    /**
     * 新增外出审批
     */
    SupervisionOutApproval createSupervisionOutApproval (SupervisionOutApprovalCreateInputDTO createInputDTO);

    /**
     * 修改外出审批
     */
    SupervisionOutApproval updateSupervisionOutApproval (SupervisionOutApprovalUpdateInputDTO updateInputDTO);

    /**
     * 修改外出审批
     * @param updateInputDTO
     * @return
     */
    SupervisionOutApproval updateSupervisionOutApproval (SupervisionOutApproval updateInputDTO);

    /**
     * 获取详情
     */
    SupervisionOutApprovalDetailDTO getDetail (Long id );

    /**
     * 删除信息
     */
    void delete (Long id);


    /**
     * 分页查看列表
     */
    IPage<SupervisionOutApprovalList> getPageList (SupervisionOutApprovalSearchInputDTO queryDTO);

    /**
     * 获取近两个月请假天数
     * @param currUserId
     * @return
     */
    Integer getLeaveCount(Long currUserId);

    /**
     * 正常销假
     * @param reqDTO
     */
    void noneTerminate(TerminateLeaveDTO reqDTO) throws Exception;

    /**
     * 延期销假
     * @param reqDTO
     */
    void delayTerminate(TerminateLeaveDTO reqDTO, MultipartFile[] files) throws Exception;

    /**
     * 延期
     * @param reqDTO
     */
    void delay(TerminateLeaveDTO reqDTO) throws Exception;

    /**
     * 获取详情
     */
    TerminateLeaveDTO getTerinateLeaveDetail (Long id) throws Exception;
}
