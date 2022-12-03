package com.correction.backend.modules.supervision.service;

import com.correction.backend.modules.supervision.controller.dto.SupervisionDailyReportListDTO;
import com.correction.backend.modules.supervision.controller.dto.SupervisionDailyReportSearchInputDTO;
import com.correction.backend.modules.supervision.controller.dto.SupervisionDailyReportUpdateInputDTO;
import com.correction.backend.modules.supervision.controller.dto.SupervisionDailyReportUserDTO;
import com.correction.backend.modules.supervision.entity.SupervisionDailyReport;
import com.baomidou.mybatisplus.extension.service.IService;
import com.correction.framework.common.pojo.PageResult;

import java.util.List;

/**
 * <p>
 * 日常报道 服务类
 * </p>
 *
 * @author yao
 * @since 2022-12-02
 */
public interface SupervisionDailyReportService extends IService<SupervisionDailyReport> {


    /**
     * 新增日常报到
     */
    void createSupervisionDailyReport (SupervisionDailyReportUserDTO supervisionDailyReportUserDTO);


    SupervisionDailyReport updateSupervisionDailyReport (SupervisionDailyReportUpdateInputDTO updateInputDTO);

    /**
     * 获取详情信息
     */
    SupervisionDailyReport getDetail (Long id );

    /**
     * 删除
     */
    void delete (Long id );


    /**
     * 获取列表数据
     */
    List<SupervisionDailyReport> getList(SupervisionDailyReportListDTO listDTO);


    PageResult<SupervisionDailyReport> getPageList (SupervisionDailyReportSearchInputDTO searchInputDTO);

}
