package com.correction.backend.modules.supervision.convert;

import com.correction.backend.modules.supervision.controller.dto.SupervisionDailyReportCreateInputDTO;
import com.correction.backend.modules.supervision.controller.dto.SupervisionDailyReportListOutputDTO;
import com.correction.backend.modules.supervision.controller.dto.SupervisionDailyReportSearchInputDTO;
import com.correction.backend.modules.supervision.controller.dto.SupervisionDailyReportUpdateInputDTO;
import com.correction.backend.modules.supervision.entity.SupervisionDailyReport;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Author：yao
 * @Description: 日常报道 转换类
 * @Date: 2022-12-02
 */

@Mapper
public interface MSupervisionDailyReportConvert {

    MSupervisionDailyReportConvert INSTANCE = Mappers.getMapper(MSupervisionDailyReportConvert.class);

    SupervisionDailyReport toSupervisionDailyReport(SupervisionDailyReportSearchInputDTO supervisionDailyReportSearchInputDTO);

    SupervisionDailyReport toSupervisionDailyReport(SupervisionDailyReportCreateInputDTO supervisionDailyReportCreateInputDTO);

    SupervisionDailyReport toSupervisionDailyReport(SupervisionDailyReportUpdateInputDTO supervisionDailyReportUpdateInputDTO);

    SupervisionDailyReportListOutputDTO toList(SupervisionDailyReport supervisionDailyReport);

    List<SupervisionDailyReportListOutputDTO> toList(List<SupervisionDailyReport> supervisionDailyReports);
}