package com.correction.backend.modules.supervision.convert;

import com.correction.backend.modules.supervision.controller.dto.SupervisionDailyReportCreateInputDTO;
import com.correction.backend.modules.supervision.controller.dto.SupervisionDailyReportListOutputDTO;
import com.correction.backend.modules.supervision.controller.dto.SupervisionDailyReportSearchInputDTO;
import com.correction.backend.modules.supervision.controller.dto.SupervisionDailyReportUpdateInputDTO;
import com.correction.backend.modules.supervision.entity.SupervisionDailyReport;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-13T01:51:15+0800",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 1.8.0_211 (Oracle Corporation)"
)
public class MSupervisionDailyReportConvertImpl implements MSupervisionDailyReportConvert {

    @Override
    public SupervisionDailyReport toSupervisionDailyReport(SupervisionDailyReportSearchInputDTO supervisionDailyReportSearchInputDTO) {
        if ( supervisionDailyReportSearchInputDTO == null ) {
            return null;
        }

        SupervisionDailyReport supervisionDailyReport = new SupervisionDailyReport();

        supervisionDailyReport.setCreateTime( supervisionDailyReportSearchInputDTO.getCreateTime() );
        supervisionDailyReport.setUpdateTime( supervisionDailyReportSearchInputDTO.getUpdateTime() );
        supervisionDailyReport.setCreator( supervisionDailyReportSearchInputDTO.getCreator() );
        supervisionDailyReport.setUpdater( supervisionDailyReportSearchInputDTO.getUpdater() );
        supervisionDailyReport.setDeleted( supervisionDailyReportSearchInputDTO.getDeleted() );
        supervisionDailyReport.setCorrectionUnit( supervisionDailyReportSearchInputDTO.getCorrectionUnit() );
        supervisionDailyReport.setCorrectionUnitId( supervisionDailyReportSearchInputDTO.getCorrectionUnitId() );
        supervisionDailyReport.setRegistrationDate( supervisionDailyReportSearchInputDTO.getRegistrationDate() );
        supervisionDailyReport.setRegistrationWay( supervisionDailyReportSearchInputDTO.getRegistrationWay() );
        supervisionDailyReport.setBenchmarkScore( supervisionDailyReportSearchInputDTO.getBenchmarkScore() );
        supervisionDailyReport.setUserId( supervisionDailyReportSearchInputDTO.getUserId() );
        supervisionDailyReport.setUserName( supervisionDailyReportSearchInputDTO.getUserName() );
        supervisionDailyReport.setRegistrationView( supervisionDailyReportSearchInputDTO.getRegistrationView() );
        supervisionDailyReport.setScore( supervisionDailyReportSearchInputDTO.getScore() );
        supervisionDailyReport.setRemark( supervisionDailyReportSearchInputDTO.getRemark() );
        supervisionDailyReport.setOrgNum( supervisionDailyReportSearchInputDTO.getOrgNum() );

        return supervisionDailyReport;
    }

    @Override
    public SupervisionDailyReport toSupervisionDailyReport(SupervisionDailyReportCreateInputDTO supervisionDailyReportCreateInputDTO) {
        if ( supervisionDailyReportCreateInputDTO == null ) {
            return null;
        }

        SupervisionDailyReport supervisionDailyReport = new SupervisionDailyReport();

        supervisionDailyReport.setCreateTime( supervisionDailyReportCreateInputDTO.getCreateTime() );
        supervisionDailyReport.setUpdateTime( supervisionDailyReportCreateInputDTO.getUpdateTime() );
        supervisionDailyReport.setCreator( supervisionDailyReportCreateInputDTO.getCreator() );
        supervisionDailyReport.setUpdater( supervisionDailyReportCreateInputDTO.getUpdater() );
        supervisionDailyReport.setDeleted( supervisionDailyReportCreateInputDTO.getDeleted() );
        supervisionDailyReport.setCorrectionUnit( supervisionDailyReportCreateInputDTO.getCorrectionUnit() );
        supervisionDailyReport.setCorrectionUnitId( supervisionDailyReportCreateInputDTO.getCorrectionUnitId() );
        supervisionDailyReport.setRegistrationDate( supervisionDailyReportCreateInputDTO.getRegistrationDate() );
        supervisionDailyReport.setRegistrationWay( supervisionDailyReportCreateInputDTO.getRegistrationWay() );
        supervisionDailyReport.setBenchmarkScore( supervisionDailyReportCreateInputDTO.getBenchmarkScore() );
        supervisionDailyReport.setUserId( supervisionDailyReportCreateInputDTO.getUserId() );
        supervisionDailyReport.setUserName( supervisionDailyReportCreateInputDTO.getUserName() );
        supervisionDailyReport.setRegistrationView( supervisionDailyReportCreateInputDTO.getRegistrationView() );
        supervisionDailyReport.setScore( supervisionDailyReportCreateInputDTO.getScore() );
        supervisionDailyReport.setRemark( supervisionDailyReportCreateInputDTO.getRemark() );

        return supervisionDailyReport;
    }

    @Override
    public SupervisionDailyReport toSupervisionDailyReport(SupervisionDailyReportUpdateInputDTO supervisionDailyReportUpdateInputDTO) {
        if ( supervisionDailyReportUpdateInputDTO == null ) {
            return null;
        }

        SupervisionDailyReport supervisionDailyReport = new SupervisionDailyReport();

        supervisionDailyReport.setCreateTime( supervisionDailyReportUpdateInputDTO.getCreateTime() );
        supervisionDailyReport.setUpdateTime( supervisionDailyReportUpdateInputDTO.getUpdateTime() );
        supervisionDailyReport.setCreator( supervisionDailyReportUpdateInputDTO.getCreator() );
        supervisionDailyReport.setUpdater( supervisionDailyReportUpdateInputDTO.getUpdater() );
        supervisionDailyReport.setDeleted( supervisionDailyReportUpdateInputDTO.getDeleted() );
        supervisionDailyReport.setId( supervisionDailyReportUpdateInputDTO.getId() );
        supervisionDailyReport.setCorrectionUnit( supervisionDailyReportUpdateInputDTO.getCorrectionUnit() );
        supervisionDailyReport.setCorrectionUnitId( supervisionDailyReportUpdateInputDTO.getCorrectionUnitId() );
        supervisionDailyReport.setRegistrationDate( supervisionDailyReportUpdateInputDTO.getRegistrationDate() );
        supervisionDailyReport.setRegistrationWay( supervisionDailyReportUpdateInputDTO.getRegistrationWay() );
        supervisionDailyReport.setBenchmarkScore( supervisionDailyReportUpdateInputDTO.getBenchmarkScore() );
        supervisionDailyReport.setUserId( supervisionDailyReportUpdateInputDTO.getUserId() );
        supervisionDailyReport.setUserName( supervisionDailyReportUpdateInputDTO.getUserName() );
        supervisionDailyReport.setRegistrationView( supervisionDailyReportUpdateInputDTO.getRegistrationView() );
        supervisionDailyReport.setScore( supervisionDailyReportUpdateInputDTO.getScore() );
        supervisionDailyReport.setRemark( supervisionDailyReportUpdateInputDTO.getRemark() );

        return supervisionDailyReport;
    }

    @Override
    public SupervisionDailyReportListOutputDTO toList(SupervisionDailyReport supervisionDailyReport) {
        if ( supervisionDailyReport == null ) {
            return null;
        }

        SupervisionDailyReportListOutputDTO supervisionDailyReportListOutputDTO = new SupervisionDailyReportListOutputDTO();

        supervisionDailyReportListOutputDTO.setId( supervisionDailyReport.getId() );
        supervisionDailyReportListOutputDTO.setCorrectionUnit( supervisionDailyReport.getCorrectionUnit() );
        supervisionDailyReportListOutputDTO.setCorrectionUnitId( supervisionDailyReport.getCorrectionUnitId() );
        supervisionDailyReportListOutputDTO.setRegistrationDate( supervisionDailyReport.getRegistrationDate() );
        supervisionDailyReportListOutputDTO.setRegistrationWay( supervisionDailyReport.getRegistrationWay() );
        supervisionDailyReportListOutputDTO.setBenchmarkScore( supervisionDailyReport.getBenchmarkScore() );
        supervisionDailyReportListOutputDTO.setUserId( supervisionDailyReport.getUserId() );
        supervisionDailyReportListOutputDTO.setUserName( supervisionDailyReport.getUserName() );
        supervisionDailyReportListOutputDTO.setRegistrationView( supervisionDailyReport.getRegistrationView() );
        supervisionDailyReportListOutputDTO.setScore( supervisionDailyReport.getScore() );
        supervisionDailyReportListOutputDTO.setRemark( supervisionDailyReport.getRemark() );
        supervisionDailyReportListOutputDTO.setCreateTime( supervisionDailyReport.getCreateTime() );
        supervisionDailyReportListOutputDTO.setUpdateTime( supervisionDailyReport.getUpdateTime() );
        supervisionDailyReportListOutputDTO.setCreator( supervisionDailyReport.getCreator() );
        supervisionDailyReportListOutputDTO.setUpdater( supervisionDailyReport.getUpdater() );
        supervisionDailyReportListOutputDTO.setDeleted( supervisionDailyReport.getDeleted() );

        return supervisionDailyReportListOutputDTO;
    }

    @Override
    public List<SupervisionDailyReportListOutputDTO> toList(List<SupervisionDailyReport> supervisionDailyReports) {
        if ( supervisionDailyReports == null ) {
            return null;
        }

        List<SupervisionDailyReportListOutputDTO> list = new ArrayList<SupervisionDailyReportListOutputDTO>( supervisionDailyReports.size() );
        for ( SupervisionDailyReport supervisionDailyReport : supervisionDailyReports ) {
            list.add( toList( supervisionDailyReport ) );
        }

        return list;
    }
}
