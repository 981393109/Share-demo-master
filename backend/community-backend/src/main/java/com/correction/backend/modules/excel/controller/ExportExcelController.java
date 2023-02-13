package com.correction.backend.modules.excel.controller;


import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.correction.backend.modules.cases.controller.dto.*;
import com.correction.backend.modules.cases.entity.CasesPunishment;
import com.correction.backend.modules.cases.service.CasesPunishmentService;
import com.correction.backend.modules.cases.service.RewardRecordService;
import com.correction.backend.modules.education.controller.dto.EducationIdeologyListOutputDTO;
import com.correction.backend.modules.education.controller.dto.EducationIndividualUpdateInputDTO;
import com.correction.backend.modules.education.controller.dto.EducationSupportInputDTO;
import com.correction.backend.modules.education.entity.EducationIdeology;
import com.correction.backend.modules.education.entity.EducationIndividual;
import com.correction.backend.modules.education.entity.EducationSupport;
import com.correction.backend.modules.education.service.EducationIdeologyService;
import com.correction.backend.modules.education.service.EducationIndividualService;
import com.correction.backend.modules.education.service.EducationSupportService;
import com.correction.backend.modules.excel.pojo.*;
import com.correction.backend.modules.handleCorrection.controller.dto.CorrectionUserSearchDTO;
import com.correction.backend.modules.handleCorrection.controller.dto.CorrectionWaysSearchDTO;
import com.correction.backend.modules.handleCorrection.controller.dto.HandleCorrectionListDTO;
import com.correction.backend.modules.handleCorrection.controller.dto.HandleCorrectionSearchInputDTO;
import com.correction.backend.modules.handleCorrection.entity.CorrectionUser;
import com.correction.backend.modules.handleCorrection.entity.CorrectionWays;
import com.correction.backend.modules.handleCorrection.service.CorrectionUserService;
import com.correction.backend.modules.handleCorrection.service.CorrectionWaysService;
import com.correction.backend.modules.handleCorrection.service.HandleCorrectionService;
import com.correction.backend.modules.supervision.controller.dto.*;
import com.correction.backend.modules.supervision.entity.SupervisionDailyReport;
import com.correction.backend.modules.supervision.entity.SupervisionVisitField;
import com.correction.backend.modules.supervision.service.SupervisionDailyReportService;
import com.correction.backend.modules.supervision.service.SupervisionOutApprovalService;
import com.correction.backend.modules.supervision.service.SupervisionPositioningDevicesService;
import com.correction.backend.modules.supervision.service.SupervisionVisitFieldService;
import com.correction.backend.modules.survey.controller.dto.SurveyEvaluationCreateInputDTO;
import com.correction.backend.modules.survey.controller.dto.SurveyEvaluationListDTO;
import com.correction.backend.modules.survey.controller.dto.SurveyEvaluationSearchInputDTO;
import com.correction.backend.modules.survey.service.SurveyEvaluationService;
import com.correction.backend.modules.termination.controller.dto.TerminationCorrectPageListDTO;
import com.correction.backend.modules.termination.controller.dto.TerminationCorrectSearchInputDTO;
import com.correction.backend.modules.termination.controller.dto.TerminationSolutionsPageListDTO;
import com.correction.backend.modules.termination.controller.dto.TerminationSolutionsSearchInputDTO;
import com.correction.backend.modules.termination.service.TerminationCorrectService;
import com.correction.backend.modules.termination.service.TerminationSolutionsService;
import com.correction.framework.common.pojo.CommonResult;
import com.correction.framework.common.pojo.PageResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;
import java.util.stream.Collectors;

import static com.correction.framework.common.pojo.CommonResult.success;

@RestController
@RequestMapping("/export")
@Api(tags = "导出-各个界面导出相关接口")
public class ExportExcelController {

    @Resource
    SurveyEvaluationService surveyEvaluationService;

    @Resource
    private HandleCorrectionService handleCorrectionService;

    @Resource
    private CorrectionWaysService correctionWaysService;

    @Resource
    private CorrectionUserService correctionUserService;

    @Resource
    private SupervisionDailyReportService supervisionDailyReportService;

    @Resource
    private SupervisionOutApprovalService supervisionOutApprovalService;

    @Resource
    private SupervisionVisitFieldService supervisionVisitFieldService;

    @Resource
    SupervisionPositioningDevicesService supervisionPositioningDevicesService;

    @Resource
    EducationSupportService educationSupportService;

    @Resource
    EducationIndividualService educationIndividualService;

    @Resource
    EducationIdeologyService educationIdeologyService;

    @Resource
    private RewardRecordService rewardRecordService;

    @Resource
    CasesPunishmentService casesPunishmentService;

    @Resource
    TerminationCorrectService terminationCorrectService;

    @Resource
    TerminationSolutionsService terminationSolutionsService;

    @PostMapping("/survey-export")
    @ApiOperation("调查评估导出(0 看我自己  1 所有)")
    public void surveyExport(HttpServletResponse response,  SurveyEvaluationSearchInputDTO reqVO, @RequestParam("isAll") String isAll) throws IOException {
        reqVO.setPageSize(60000);
        IPage<SurveyEvaluationListDTO> pageListFlow = null;
        if("0".equals(isAll)){
            pageListFlow = surveyEvaluationService.getPageListFlow(reqVO);
        } else {
            pageListFlow = surveyEvaluationService.getPageAllListFlow(reqVO);
        }
        //封装导出Pojo
        List<SurveyEvaluationExcelPojo> collect = pageListFlow.getRecords().stream().map(e -> {
            SurveyEvaluationExcelPojo pojo = new SurveyEvaluationExcelPojo();
            BeanUtils.copyProperties(e, pojo);
            return pojo;
        }).collect(Collectors.toList());
        //导出：
        extracted(response, SurveyEvaluationExcelPojo.class,collect,"调查评估.xlsx");
    }



    @PostMapping("/handleCorrection-export")
    @ApiOperation("决定接收-办理入矫(0 看我自己  1 所有)")
    public void handleCorrectionExport(HttpServletResponse response, HandleCorrectionSearchInputDTO reqVO, @RequestParam("isAll") String isAll) throws IOException {
        reqVO.setPageSize(60000);
        IPage<HandleCorrectionListDTO> pageListFlow = null;
        if("0".equals(isAll)){
            pageListFlow = handleCorrectionService.getPageList(reqVO);
        } else {
            pageListFlow = handleCorrectionService.getPageAllList(reqVO);
        }
        //封装导出Pojo
        List<HandleCorrectionExcelPojo> collect = pageListFlow.getRecords().stream().map(e -> {
            HandleCorrectionExcelPojo pojo = new HandleCorrectionExcelPojo();
            BeanUtils.copyProperties(e, pojo);
            return pojo;
        }).collect(Collectors.toList());
        //导出：
        extracted(response, HandleCorrectionExcelPojo.class,collect,"办理入矫.xlsx");
    }



    @PostMapping("/handleCorrectionWay-export")
    @ApiOperation("决定接收-矫正方案登记")
    public void handleCorrectionWayExport(HttpServletResponse response, CorrectionWaysSearchDTO reqVO) throws IOException {
        List<CorrectionWays> list = correctionWaysService.getList(reqVO);
        //封装导出Pojo
        List<CorrectionWaysExcelPojo> collect = list.stream().map(e -> {
            CorrectionWaysExcelPojo pojo = new CorrectionWaysExcelPojo();
            BeanUtils.copyProperties(e, pojo);
            return pojo;
        }).collect(Collectors.toList());
        //导出：
        extracted(response, CorrectionWaysExcelPojo.class,collect,"矫正方案登记.xlsx");
    }



    @PostMapping("/correctionUser-export")
    @ApiOperation("矫正对象-矫正人员")
    public void correctionUserExport(HttpServletResponse response, CorrectionUserSearchDTO reqVO) throws IOException {
        List<CorrectionUser> list = correctionUserService.getList(reqVO);
        //封装导出Pojo
        List<CorrectionUserExcelPojo> collect = list.stream().map(e -> {
            CorrectionUserExcelPojo pojo = new CorrectionUserExcelPojo();
            BeanUtils.copyProperties(e, pojo);
            return pojo;
        }).collect(Collectors.toList());
        //导出：
        extracted(response, CorrectionUserExcelPojo.class,collect,"矫正人员.xlsx");
    }


    @PostMapping("/supervisionDaily-export")
    @ApiOperation("监督-日常报到导出")
    public void supervisionDailyExport(HttpServletResponse response, SupervisionDailyReportListDTO reqVO) throws IOException {
        List<SupervisionDailyReport> list = supervisionDailyReportService.getList(reqVO);
        //封装导出Pojo
        List<SupervisionDailyReportExcelPojo> collect = list.stream().map(e -> {
            SupervisionDailyReportExcelPojo pojo = new SupervisionDailyReportExcelPojo();
            BeanUtils.copyProperties(e, pojo);
            return pojo;
        }).collect(Collectors.toList());
        //导出：
        extracted(response, SupervisionDailyReportExcelPojo.class,collect,"日常报到.xlsx");
    }



    @PostMapping("/supervisionOutApproval-export")
    @ApiOperation("监督-外出审批(0 看我自己  1 所有)")
    public void supervisionOutApprovalExport(HttpServletResponse response, SupervisionOutApprovalSearchInputDTO reqVO, @RequestParam("isAll") String isAll) throws IOException {
        reqVO.setPageSize(60000);
        IPage<SupervisionOutApprovalList> pageListFlow = null;
        if("0".equals(isAll)){
            pageListFlow = supervisionOutApprovalService.getPageList(reqVO);
        } else {
            pageListFlow = supervisionOutApprovalService.getPageAllList(reqVO);
        }
        //封装导出Pojo
        List<SupervisionOutApprovalExcelPojo> collect = pageListFlow.getRecords().stream().map(e -> {
            SupervisionOutApprovalExcelPojo pojo = new SupervisionOutApprovalExcelPojo();
            BeanUtils.copyProperties(e, pojo);
            return pojo;
        }).collect(Collectors.toList());
        //导出：
        extracted(response, SupervisionOutApprovalExcelPojo.class,collect,"外出审批.xlsx");
    }


    @PostMapping("/supervisonVisitField-export")
    @ApiOperation("监督-实地查访")
    public void supervisonVisitFieldExport(HttpServletResponse response, SupervisionVisitFieldSearchInputDTO reqVO) throws IOException {
        reqVO.setPageSize(60000);
        PageResult<SupervisionVisitField> list = supervisionVisitFieldService.getPageList(reqVO);
        //封装导出Pojo
        List<SupervisionVisitFieldExcelPojo> collect = list.getList().stream().map(e -> {
            SupervisionVisitFieldExcelPojo pojo = new SupervisionVisitFieldExcelPojo();
            BeanUtils.copyProperties(e, pojo);
            return pojo;
        }).collect(Collectors.toList());
        //导出：
        extracted(response, SupervisionVisitFieldExcelPojo.class,collect,"实地查访.xlsx");
    }



    @PostMapping("/supervisionPositioningDevices-export")
    @ApiOperation("监督-电子设备申请(0 看我自己  1 所有)")
    public void supervisionPositioningDevicesExport(HttpServletResponse response, SupervisionPositioningDevicesSearchInputDTO reqVO, @RequestParam("isAll") String isAll) throws IOException {
        reqVO.setPageSize(60000);
        IPage<SupervisionPositioningDevicesFlowDTO> pageListFlow = null;
        if("0".equals(isAll)){
            pageListFlow = supervisionPositioningDevicesService.getPageList(reqVO);
        } else {
            pageListFlow = supervisionPositioningDevicesService.getPageAllList(reqVO);
        }
        //封装导出Pojo
        List<SupervisionPositioningDevicesExcelPojo> collect = pageListFlow.getRecords().stream().map(e -> {
            SupervisionPositioningDevicesExcelPojo pojo = new SupervisionPositioningDevicesExcelPojo();
            BeanUtils.copyProperties(e, pojo);
            return pojo;
        }).collect(Collectors.toList());
        //导出：
        extracted(response, SupervisionPositioningDevicesExcelPojo.class,collect,"电子设备申请.xlsx");
    }




    @PostMapping("/educationSupport-export")
    @ApiOperation("教育-集中教育")
    public void educationSupportExport(HttpServletResponse response, EducationSupportInputDTO reqVO) throws IOException {
        List<EducationSupport> list = educationSupportService.getList(reqVO);
        //封装导出Pojo
        List<EducationSupportExcelPojo> collect = list.stream().map(e -> {
            EducationSupportExcelPojo pojo = new EducationSupportExcelPojo();
            BeanUtils.copyProperties(e, pojo);
            return pojo;
        }).collect(Collectors.toList());
        //导出：
        extracted(response, EducationSupportExcelPojo.class,collect,"集中教育.xlsx");
    }



    @PostMapping("/educationIndividual-export")
    @ApiOperation("教育-个别教育")
    public void educationIndividualExport(HttpServletResponse response, EducationIndividualUpdateInputDTO reqVO) throws IOException {
        List<EducationIndividual> list = educationIndividualService.getList(reqVO);
        //封装导出Pojo
        List<EducationIndividualExcelPojo> collect = list.stream().map(e -> {
            EducationIndividualExcelPojo pojo = new EducationIndividualExcelPojo();
            BeanUtils.copyProperties(e, pojo);
            return pojo;
        }).collect(Collectors.toList());
        //导出：
        extracted(response, EducationIndividualExcelPojo.class,collect,"个别教育.xlsx");
    }


    @PostMapping("/educationIdeology-export")
    @ApiOperation("教育-思想汇报")
    public void educationIdeologyExport(HttpServletResponse response, EducationIdeologyListOutputDTO reqVO) throws IOException {
        List<EducationIdeology> list = educationIdeologyService.getList(reqVO);
        //封装导出Pojo
        List<EducationIdeologyExcelPojo> collect = list.stream().map(e -> {
            EducationIdeologyExcelPojo pojo = new EducationIdeologyExcelPojo();
            BeanUtils.copyProperties(e, pojo);
            return pojo;
        }).collect(Collectors.toList());
        //导出：
        extracted(response, EducationIdeologyExcelPojo.class,collect,"思想汇报.xlsx");
    }


    @PostMapping("/rewardRecord-export")
    @ApiOperation("奖罚-奖励记录(0 看我自己  1 所有)")
    public void rewardRecordExport(HttpServletResponse response, RewardRecordSearchInputDTO reqVO, @RequestParam("isAll") String isAll) throws IOException {
        reqVO.setPageSize(60000);
        IPage<RewardRecordPageListDTO> pageListFlow = null;
        if("0".equals(isAll)){
            pageListFlow = rewardRecordService.getPageList(reqVO);
        } else {
            pageListFlow = rewardRecordService.getPageAllList(reqVO);
        }
        //封装导出Pojo
        List<RewardRecordExcelPojo> collect = pageListFlow.getRecords().stream().map(e -> {
            RewardRecordExcelPojo pojo = new RewardRecordExcelPojo();
            BeanUtils.copyProperties(e, pojo);
            return pojo;
        }).collect(Collectors.toList());
        //导出：
        extracted(response, RewardRecordExcelPojo.class,collect,"奖励记录.xlsx");
    }


    @PostMapping("/casesPunishment-export")
    @ApiOperation("奖罚-惩罚记录(0 看我自己  1 所有)")
    public void casesPunishmentExport(HttpServletResponse response, CasesPunishmentSearchInputDTO reqVO, @RequestParam("isAll") String isAll) throws IOException {
        reqVO.setPageSize(60000);
        IPage<CasesPunishmentPageListDTO> pageListFlow = null;
        if("0".equals(isAll)){
            pageListFlow = casesPunishmentService.getPageList(reqVO);
        } else {
            pageListFlow = casesPunishmentService.getPageAllList(reqVO);
        }
        //封装导出Pojo
        List<CasesPunishmentExcelPojo> collect = pageListFlow.getRecords().stream().map(e -> {
            CasesPunishmentExcelPojo pojo = new CasesPunishmentExcelPojo();
            BeanUtils.copyProperties(e, pojo);
            return pojo;
        }).collect(Collectors.toList());
        //导出：
        extracted(response, CasesPunishmentExcelPojo.class,collect,"惩罚记录.xlsx");
    }

    @PostMapping("/terminationCorrect-export")
    @ApiOperation("解除与终止-矫正终止 (0 看我自己  1 所有)")
    public void terminationCorrectExport(HttpServletResponse response, TerminationCorrectSearchInputDTO reqVO, @RequestParam("isAll") String isAll) throws IOException {
        reqVO.setPageSize(60000);
        IPage<TerminationCorrectPageListDTO> pageListFlow = null;
        if("0".equals(isAll)){
            pageListFlow = terminationCorrectService.getPageList(reqVO);
        } else {
            pageListFlow = terminationCorrectService.getPageAllList(reqVO);
        }
        //封装导出Pojo
        List<TerminationCorrectExcelPojo> collect = pageListFlow.getRecords().stream().map(e -> {
            TerminationCorrectExcelPojo pojo = new TerminationCorrectExcelPojo();
            BeanUtils.copyProperties(e, pojo);
            return pojo;
        }).collect(Collectors.toList());
        //导出：
        extracted(response, TerminationCorrectExcelPojo.class,collect,"矫正终止.xlsx");
    }

    @PostMapping("/terminationSolutions-export")
    @ApiOperation("解除与终止-期满解矫 (0 看我自己  1 所有)")
    public void terminationSolutionsExport(HttpServletResponse response, TerminationSolutionsSearchInputDTO reqVO, @RequestParam("isAll") String isAll) throws IOException {
        reqVO.setPageSize(60000);
        IPage<TerminationSolutionsPageListDTO> pageListFlow = null;
        if("0".equals(isAll)){
            pageListFlow = terminationSolutionsService.getPageList(reqVO);
        } else {
            pageListFlow = terminationSolutionsService.getPageAllList(reqVO);
        }
        //封装导出Pojo
        List<TerminationSolutionExcelPojo> collect = pageListFlow.getRecords().stream().map(e -> {
            TerminationSolutionExcelPojo pojo = new TerminationSolutionExcelPojo();
            BeanUtils.copyProperties(e, pojo);
            return pojo;
        }).collect(Collectors.toList());
        //导出：
        extracted(response, TerminationSolutionExcelPojo.class,collect,"期满解矫.xlsx");
    }



    private void extracted(HttpServletResponse response,Class clazz, List collect,String fileName) throws IOException {
        ServletOutputStream out = response.getOutputStream();
        response.setHeader("Access-Control-Expose-Headers","*");
        response.setHeader("Content-Disposition", "attachment;fileName=" + URLEncoder.encode(fileName, "UTF-8"));
        EasyExcel.write(out, clazz).sheet().doWrite(collect);
        out.flush();
    }


}
