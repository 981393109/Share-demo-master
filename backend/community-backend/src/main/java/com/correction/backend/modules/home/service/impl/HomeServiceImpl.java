package com.correction.backend.modules.home.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.PageUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.correction.backend.modules.flow.constant.FlowConstant;
import com.correction.backend.modules.flow.controller.dto.TaskListOutputDTO;
import com.correction.backend.modules.handleCorrection.entity.CorrectionUser;
import com.correction.backend.modules.handleCorrection.entity.HandleCorrection;
import com.correction.backend.modules.handleCorrection.mapper.CorrectionUserMapper;
import com.correction.backend.modules.handleCorrection.mapper.HandleCorrectionMapper;
import com.correction.backend.modules.handleCorrection.service.CorrectionUserService;
import com.correction.backend.modules.handleCorrection.service.HandleCorrectionService;
import com.correction.backend.modules.home.controller.dto.HomeReportDTO;
import com.correction.backend.modules.home.controller.dto.ReportDTO;
import com.correction.backend.modules.home.controller.dto.ReportRecordDTO;
import com.correction.backend.modules.home.controller.dto.UserRunTaskDTO;
import com.correction.backend.modules.home.service.HomeService;
import com.correction.backend.modules.survey.entity.SurveyEvaluation;
import com.correction.backend.modules.survey.mapper.SurveyEvaluationMapper;
import com.correction.backend.modules.survey.service.SurveyEvaluationService;
import com.correction.backend.modules.sys.controller.dto.notes.SysNotesCreateInputDTO;
import com.correction.backend.modules.sys.controller.dto.notes.SysNotesStatusUpdateDTO;
import com.correction.backend.modules.sys.entity.SysNotes;
import com.correction.backend.modules.sys.entity.SysUserDO;
import com.correction.backend.modules.sys.mapper.SysUserMapper;
import com.correction.backend.modules.sys.service.SysNotesService;
import com.correction.backend.modules.termination.entity.TerminationSolutions;
import com.correction.backend.modules.termination.mapper.TerminationSolutionsMapper;
import com.correction.framework.common.pojo.CommonResult;
import com.correction.framework.web.web.core.util.WebFrameworkUtils;
import com.correction.framework.workflow.service.impl.ActTaskService;
import org.flowable.engine.HistoryService;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.engine.repository.ProcessDefinition;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.task.api.Task;
import org.flowable.task.api.TaskQuery;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.correction.framework.common.pojo.CommonResult.success;

@Service
public class HomeServiceImpl implements HomeService {

    @Resource
    RuntimeService runtimeService;

    @Resource
    TaskService taskService;

    @Resource
    RepositoryService repositoryService;

    @Resource
    HistoryService historyService;

    @Resource
    ActTaskService actTaskService;

    @Resource
    SysUserMapper sysUserMapper;

    @Resource
    SysNotesService sysNotesService;

    @Resource
    SurveyEvaluationMapper surveyEvaluationMapper;

    @Resource
    HandleCorrectionMapper handleCorrectionMapper;

    @Resource
    CorrectionUserMapper correctionUserMapper;

    @Resource
    TerminationSolutionsMapper terminationSolutionsMapper;


    @Override
    public List<UserRunTaskDTO> getUserRunTask(Long userId) {
        List<UserRunTaskDTO> resultList = new ArrayList<>();
        // 查看user的所有组
        final TaskQuery taskQuery = taskService.createTaskQuery()
                // 候选用户 or Assigned
                .taskCandidateOrAssigned(String.valueOf(userId))
                .orderByTaskCreateTime().desc()
                .active();
        // 查询总数
        final long count = taskQuery.count();
        if (count <= 0) {
            return new ArrayList<>();
        }
        final List<Task> list = taskQuery.list();
        list.forEach(task -> {
            final ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery()
                    .processDefinitionId(task.getProcessDefinitionId())
                    .singleResult();
            final ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId(task.getProcessInstanceId()).singleResult();
            final UserRunTaskDTO userRunTaskDTO = new UserRunTaskDTO();
            String startUserName = null;
            if (StrUtil.isNotBlank(processInstance.getStartUserId())) {
                SysUserDO userDO = sysUserMapper.selectById(Long.parseLong(processInstance.getStartUserId()));
                if(userDO!=null)
                startUserName = userDO.getUserName();
            }
            final String businessKey = taskService.getVariable(task.getId(), "businessKey", String.class);
            if (StrUtil.isNotBlank(businessKey)) {
                userRunTaskDTO.setBusinessKey(businessKey);
                final List<String> businessKeyAsList = Arrays.asList(StrUtil.split(businessKey, ":"));
                userRunTaskDTO.setFlowType(businessKeyAsList.get(0));
                userRunTaskDTO.setDataId(Long.parseLong(businessKeyAsList.get(1)));
            }
            resultList.add(userRunTaskDTO
                    .setTaskId(task.getId())
                    .setProcessInstanceId(task.getProcessInstanceId())
                    .setStartUserId(Long.parseLong(processInstance.getStartUserId()))
                    .setStartUserName(startUserName)
                    .setStartTime(processInstance.getStartTime().toLocaleString())
                    .setTaskName(task.getName())
            );
        });
        return resultList;
    }

    @Override
    public List<SysNotes> getNotes(Long loginUserId) {
        List<SysNotes> list = sysNotesService.getList(loginUserId, LocalDate.now().toString());
        return list;
    }

    @Override
    public SysNotes createNotes(SysNotesCreateInputDTO createInputDTO) {
        SysNotes notes = sysNotesService.createNotes(createInputDTO);
        return notes;
    }

    @Override
    public SysNotes updateStatus(SysNotesStatusUpdateDTO updateDTO) {
        SysNotes sysNotes = sysNotesService.updateStatus(updateDTO.getId(), updateDTO.getStatus());
        return sysNotes;
    }

    @Override
    public HomeReportDTO getReports() {
        HomeReportDTO result = new HomeReportDTO();
        String date  = LocalDate.now().toString();
        Long loginUserId = WebFrameworkUtils.getLoginUserId();
        String monthDate  = LocalDate.now().toString().substring(0,7);
        //获取调查评估数据 applystatus != 7 && != -1
        Integer count = surveyEvaluationMapper.selectCount(Wrappers.<SurveyEvaluation>lambdaQuery().ne(SurveyEvaluation::getApplyStatus, 7).ne(SurveyEvaluation::getApplyStatus, -1).eq(SurveyEvaluation::getDeleted, 0));
        Integer monthCount = surveyEvaluationMapper.selectCount(Wrappers.<SurveyEvaluation>lambdaQuery().eq(SurveyEvaluation::getApplyStatus, 7).like(SurveyEvaluation::getEndFlowTime,monthDate)
                .eq(SurveyEvaluation::getDeleted, 0));
        List<UserRunTaskDTO> userTaskByFlow = getUserTaskByFlow(loginUserId, FlowConstant.SURVEY_FLOW);
        ReportDTO reportDTO =new ReportDTO();
        reportDTO.setWaitCount(count);
        reportDTO.setEdCount(monthCount);
        reportDTO.setRunTaskList(userTaskByFlow);
        result.setSurveyEvaluation(reportDTO);
        //获取办理入矫  applystatus  applystatus != 11 && !=-1
        Integer HandleCorrectionCount = handleCorrectionMapper.selectCount(Wrappers.<HandleCorrection>lambdaQuery().ne(HandleCorrection::getApplyStatus, 11).ne(HandleCorrection::getApplyStatus, -1).eq(HandleCorrection::getDeleted, 0));
        Integer HandleCorrectionMonthCount = handleCorrectionMapper.selectCount(Wrappers.<HandleCorrection>lambdaQuery().eq(HandleCorrection::getApplyStatus, 7).like(HandleCorrection::getEndFlowTime,monthDate)
                .eq(HandleCorrection::getDeleted, 0));
        List<UserRunTaskDTO> handleUserTaskByFlow = getUserTaskByFlow(loginUserId, FlowConstant.HANDLE_CORRECTION_FLOW);
        ReportDTO handleReportDTO =new ReportDTO();
        handleReportDTO.setWaitCount(HandleCorrectionCount);
        handleReportDTO.setEdCount(HandleCorrectionMonthCount);
        handleReportDTO.setRunTaskList(handleUserTaskByFlow);
        result.setHandleCorrection(handleReportDTO);

        //矫正对象 isHistory = 0
        Integer correctionCount = correctionUserMapper.selectCount(Wrappers.<CorrectionUser>lambdaQuery().eq(CorrectionUser::getIsHistory, 0).eq(CorrectionUser::getDeleted, 0));
        Integer correctionHisCount = correctionUserMapper.selectCount(Wrappers.<CorrectionUser>lambdaQuery().eq(CorrectionUser::getIsHistory, 1).eq(CorrectionUser::getDeleted, 0));
        List<CorrectionUser> correctionUsers = correctionUserMapper.selectList(Wrappers.<CorrectionUser>lambdaQuery().eq(CorrectionUser::getIsHistory, 0).eq(CorrectionUser::getDeleted, 0));
        ReportDTO correctReportDTO =new ReportDTO();
        correctReportDTO.setWaitCount(correctionCount);
        correctReportDTO.setEdCount(correctionHisCount);
        List<ReportRecordDTO> recordDTOS = new ArrayList<>();
        for (CorrectionUser correctionUser : correctionUsers) {
            HandleCorrection handleCorrection = handleCorrectionMapper.selectById(correctionUser.getHandleCorrectionId());
            ReportRecordDTO recordDTO = new ReportRecordDTO();
            recordDTO.setInfo(handleCorrection.getEntrustUnit()+"-"+correctionUser.getName());
            recordDTO.setDataId(correctionUser.getId());
            recordDTOS.add(recordDTO);
        }
        correctReportDTO.setReportRecordList(recordDTOS);
        result.setCorrectionUser(correctReportDTO);

        // 期满解矫
        Integer count1 = terminationSolutionsMapper.selectCount(Wrappers.<TerminationSolutions>lambdaQuery().eq(TerminationSolutions::getApplyStatus, 99).like(TerminationSolutions::getEndFlowTime, monthDate)
                .eq(TerminationSolutions::getDeleted, 0));
        List<UserRunTaskDTO> termination = getUserTaskByFlow(loginUserId, FlowConstant.TERMINATION_SOLUTIONS_FLOW);

        ReportDTO terminationReportDto = new ReportDTO();
        terminationReportDto.setWaitCount(correctionCount);
        terminationReportDto.setEdCount(count1);
        terminationReportDto.setRunTaskList(termination);
        result.setTerminationSolutions(terminationReportDto);
        return result;
    }


    private List<UserRunTaskDTO> getUserTaskByFlow (Long userId,String flowType){
        List<UserRunTaskDTO> resultList = new ArrayList<>();
        // 查看user的所有组
        final TaskQuery taskQuery = taskService.createTaskQuery()
                // 候选用户 or Assigned
                .taskCandidateOrAssigned(String.valueOf(userId))
                .orderByTaskCreateTime().desc()
                .active();
        // 查询总数
        final long count = taskQuery.count();
        if (count <= 0) {
            return new ArrayList<>();
        }
        final List<Task> list = taskQuery.list();
        list.forEach(task -> {
            final ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery()
                    .processDefinitionId(task.getProcessDefinitionId())
                    .singleResult();
            if (flowType.equals(processDefinition.getKey())){
                final ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId(task.getProcessInstanceId()).singleResult();
                final UserRunTaskDTO userRunTaskDTO = new UserRunTaskDTO();
                String startUserName = null;
                if (StrUtil.isNotBlank(processInstance.getStartUserId())) {
                    SysUserDO userDO = sysUserMapper.selectById(Long.parseLong(processInstance.getStartUserId()));
                    if(userDO!=null)
                        startUserName = userDO.getUserName();
                }
                final String businessKey = taskService.getVariable(task.getId(), "businessKey", String.class);
                if (StrUtil.isNotBlank(businessKey)) {
                    userRunTaskDTO.setBusinessKey(businessKey);
                    final List<String> businessKeyAsList = Arrays.asList(StrUtil.split(businessKey, ":"));
                    userRunTaskDTO.setFlowType(businessKeyAsList.get(0));
                    userRunTaskDTO.setDataId(Long.parseLong(businessKeyAsList.get(1)));
                }
                resultList.add(userRunTaskDTO
                        .setTaskId(task.getId())
                        .setProcessInstanceId(task.getProcessInstanceId())
                        .setStartUserId(Long.parseLong(processInstance.getStartUserId()))
                        .setStartUserName(startUserName)
                        .setStartTime(processInstance.getStartTime().toLocaleString())
                        .setTaskName(task.getName())
                );
            }
        });
        return resultList;
    }


}
