package com.correction.backend.modules.supervision.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.correction.backend.modules.file.controller.dto.FilePathDTO;
import com.correction.backend.modules.file.service.FileResouceService;
import com.correction.backend.modules.handleCorrection.controller.dto.HandleCorrectionListDTO;
import com.correction.backend.modules.supervision.constant.SupervisionConstant;
import com.correction.backend.modules.supervision.controller.dto.*;
import com.correction.backend.modules.supervision.convert.MSupervisionOutApprovalConvert;
import com.correction.backend.modules.supervision.service.SupervisionOutApprovalService;
import com.correction.backend.modules.survey.constant.SurveyConstant;
import com.correction.backend.modules.survey.controller.dto.SurveyDocumentsFilesDTO;
import com.correction.backend.modules.survey.controller.dto.SurveyDocumentsFilesQuery;
import com.correction.backend.modules.survey.entity.SurveyDocumentsFiles;
import com.correction.backend.modules.survey.service.SurveyDocumentsFilesService;
import com.correction.backend.modules.sys.entity.SysUserDO;
import com.correction.backend.modules.sys.mapper.SysUserMapper;
import com.correction.framework.common.pojo.PageResult;
import com.correction.framework.web.web.LoginUser;
import com.correction.framework.web.web.core.util.WebFrameworkUtils;
import com.correction.backend.modules.supervision.entity.SupervisionOutApproval;
import com.correction.backend.modules.supervision.mapper.SupervisionOutApprovalMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.correction.frameworks.mybatis.mybatis.core.util.MyBatisUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.correction.backend.modules.sys.enums.SysErrorCodeConstants.FLOW_TYPE_ISNULL;
import static com.correction.backend.modules.sys.enums.SysErrorCodeConstants.SURVEY_FLOW_STATUS_EDIT;
import static com.correction.framework.common.exception.util.ServiceExceptionUtil.exception;

/**
 * <p>
 * 外出审批流程 服务实现类
 * </p>
 *
 * @author yao
 * @since 2022-12-02
 */
@Service
public class SupervisionOutApprovalServiceImpl extends ServiceImpl<SupervisionOutApprovalMapper, SupervisionOutApproval> implements SupervisionOutApprovalService {

    @Resource
    private SurveyDocumentsFilesService surveyDocumentsFilesService;

    @Resource
    private SysUserMapper sysUserMapper;

    @Resource
    private FileResouceService fileResouceService;

    /**
     * 获取表格数据
     *
     * @param supervisionOutApproval
     * @return
     */
    public PageResult<SupervisionOutApproval> pageListByEntity(SupervisionOutApprovalSearchInputDTO supervisionOutApproval) {
        LambdaQueryWrapper<SupervisionOutApproval> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.like(StrUtil.isNotBlank(supervisionOutApproval.getCorrectionUnit()), SupervisionOutApproval::getCorrectionUnit, supervisionOutApproval.getCorrectionUnit());
        queryWrapper.like(supervisionOutApproval.getCorrectionUnitId()!=null, SupervisionOutApproval::getCorrectionUnitId, supervisionOutApproval.getCorrectionUnitId());
        queryWrapper.like(StrUtil.isNotBlank(supervisionOutApproval.getUserName()), SupervisionOutApproval::getUserName, supervisionOutApproval.getUserName());
        queryWrapper.like(StrUtil.isNotBlank(supervisionOutApproval.getDestination()), SupervisionOutApproval::getDestination, supervisionOutApproval.getDestination());
        queryWrapper.like(StrUtil.isNotBlank(supervisionOutApproval.getDeparture()), SupervisionOutApproval::getDeparture, supervisionOutApproval.getDeparture());
        queryWrapper.like(StrUtil.isNotBlank(supervisionOutApproval.getReasonsForLeave()), SupervisionOutApproval::getReasonsForLeave, supervisionOutApproval.getReasonsForLeave());
        queryWrapper.like(StrUtil.isNotBlank(supervisionOutApproval.getStartDate()), SupervisionOutApproval::getStartDate, supervisionOutApproval.getStartDate());
        queryWrapper.like(StrUtil.isNotBlank(supervisionOutApproval.getEndDate()), SupervisionOutApproval::getEndDate, supervisionOutApproval.getEndDate());
        queryWrapper.like(StrUtil.isNotBlank(supervisionOutApproval.getLeaveDay()), SupervisionOutApproval::getLeaveDay, supervisionOutApproval.getLeaveDay());
        queryWrapper.like(StrUtil.isNotBlank(supervisionOutApproval.getProcuratorateName()), SupervisionOutApproval::getProcuratorateName, supervisionOutApproval.getProcuratorateName());
        queryWrapper.like(supervisionOutApproval.getApplyUser() !=null , SupervisionOutApproval::getApplyUser, supervisionOutApproval.getApplyUser());
        queryWrapper.like(StrUtil.isNotBlank(supervisionOutApproval.getApplyName()), SupervisionOutApproval::getApplyName, supervisionOutApproval.getApplyName());
        queryWrapper.like(StrUtil.isNotBlank(supervisionOutApproval.getApplyTime()), SupervisionOutApproval::getApplyTime, supervisionOutApproval.getApplyTime());
        PageResult<SupervisionOutApproval> pageResult = baseMapper.selectPage(supervisionOutApproval, queryWrapper);
        return pageResult;
    }

    @Override
    public SupervisionOutApproval createSupervisionOutApproval(SupervisionOutApprovalCreateInputDTO createInputDTO) {
        checkSaveOrUpdate(createInputDTO.getLeaveType());
        SupervisionOutApproval supervisionOutApproval = MSupervisionOutApprovalConvert.INSTANCE.toSupervisionOutApproval(createInputDTO);
        LoginUser loginUser = WebFrameworkUtils.getLoginUser();
        supervisionOutApproval.setApplyName(loginUser.getUsername());
        supervisionOutApproval.setApplyUser(loginUser.getId());
        supervisionOutApproval.setApplyStatus(SurveyConstant.FLOW_STATUS_0);
        supervisionOutApproval.setProgress(SurveyConstant.PROGRESS_1);
        supervisionOutApproval.setOrgNum(WebFrameworkUtils.getLoginOrgId());
        supervisionOutApproval.setRef(String.valueOf(System.currentTimeMillis()));
        baseMapper.insert(supervisionOutApproval);
        List<SurveyDocumentsFiles> surveyDocumentsFiles = createInputDTO.getSurveyDocumentsFiles();
        for (SurveyDocumentsFiles surveyDocumentsFile : surveyDocumentsFiles) {
            surveyDocumentsFile.setDataId(supervisionOutApproval.getId());
            surveyDocumentsFilesService.updateById(surveyDocumentsFile);
        }
        return supervisionOutApproval;
    }

    private void checkSaveOrUpdate(Integer leaveType) {
        if(leaveType == null){
            throw exception(FLOW_TYPE_ISNULL);
        }
    }

    @Override
    public SupervisionOutApproval updateSupervisionOutApproval(SupervisionOutApprovalUpdateInputDTO updateInputDTO) {
        SupervisionOutApproval supervisionOutApproval = MSupervisionOutApprovalConvert.INSTANCE.toSupervisionOutApproval(updateInputDTO);
        baseMapper.updateById(supervisionOutApproval);
        return baseMapper.selectById(updateInputDTO.getId());
    }

    @Override
    public SupervisionOutApproval updateSupervisionOutApproval(SupervisionOutApproval updateInputDTO) {
        updateById(updateInputDTO);
        return baseMapper.selectById(updateInputDTO.getId());
    }

    @Override
    public SupervisionOutApprovalDetailDTO getDetail(Long id) {
        SupervisionOutApproval supervisionOutApproval = baseMapper.selectById(id);
        SupervisionOutApprovalDetailDTO result = new SupervisionOutApprovalDetailDTO();
        List<SurveyDocumentsFilesDTO> DICT_TYPE_SUPERVISION = surveyDocumentsFilesService.getSurveyDocumentList(SurveyDocumentsFilesQuery.builder()
                .dictType(SupervisionConstant.DICT_TYPE_SUPERVISION).dataId(id).build());
        List<SurveyDocumentsFilesDTO> DICT_TYPE_SUPERVISION_2 = surveyDocumentsFilesService.getSurveyDocumentList(SurveyDocumentsFilesQuery.builder()
                .dictType(SupervisionConstant.DICT_TYPE_SUPERVISION_2).dataId(id).build());
        List<SurveyDocumentsFilesDTO> DICT_TYPE_SUPERVISION_3 = surveyDocumentsFilesService.getSurveyDocumentList(SurveyDocumentsFilesQuery.builder()
                .dictType(SupervisionConstant.DICT_TYPE_SUPERVISION_3).dataId(id).build());
        List<SurveyDocumentsFilesDTO> DICT_TYPE_SUPERVISION_4 = surveyDocumentsFilesService.getSurveyDocumentList(SurveyDocumentsFilesQuery.builder()
                .dictType(SupervisionConstant.DICT_TYPE_SUPERVISION_4).dataId(id).build());
        result.setCityApplyMaterials(DICT_TYPE_SUPERVISION_4);
        result.setAreaApplyMaterials(DICT_TYPE_SUPERVISION_3);
        result.setNoticeMaterials(DICT_TYPE_SUPERVISION_2);
        result.setApprovalMaterials(DICT_TYPE_SUPERVISION);
        result.setDetail(MSupervisionOutApprovalConvert.INSTANCE.toList(supervisionOutApproval));
        return result;
    }

    @Override
    public void delete(Long id) {
        delete(id);
    }

    @Override
    public IPage<SupervisionOutApprovalList> getPageList(SupervisionOutApprovalSearchInputDTO queryDTO) {
        IPage<SupervisionOutApprovalList> mpPage = MyBatisUtils.buildPage(queryDTO);
        queryDTO.setApplyUser(WebFrameworkUtils.getLoginUserId());
        mpPage = baseMapper.getPageList(mpPage, queryDTO);
        List<SupervisionOutApprovalList> records = mpPage.getRecords();
        if(!CollectionUtils.isEmpty(records)) {
            for (SupervisionOutApprovalList record : records) {
                //判断flowStatus为2 flowStatus 0:代办 1 已办 2 办结

                if(record.getNextUser()!=null){
                    SysUserDO userDO = sysUserMapper.selectById(Long.parseLong(record.getNextUser()));
                    record.setNextUserName(userDO.getUserName());
                } else {
                    if(SurveyConstant.FLOW_STATUS_0.equals(record.getApplyStatus())){
                        record.setNextUser(String.valueOf(record.getApplyUser()));
                        record.setNextUserName(sysUserMapper.selectById(record.getApplyUser()).getUserName());
                    }
                }
                if (String.valueOf(WebFrameworkUtils.getLoginUserId()).equals(record.getNextUser())){
                    record.setFlowStatus(0);
                } else if (!String.valueOf(WebFrameworkUtils.getLoginUserId()).equals(record.getNextUser())  && org.apache.commons.lang3.StringUtils.isNotBlank(record.getTaskId())) {
                    record.setFlowStatus(1);
                } else {
                    record.setFlowStatus(2);
                }
            }
        }
        return mpPage;
    }

    @Override
    public IPage<SupervisionOutApprovalList> getPageAllList(SupervisionOutApprovalSearchInputDTO queryDTO) {
        IPage<SupervisionOutApprovalList> mpPage = MyBatisUtils.buildPage(queryDTO);
        queryDTO.setOrgIds(WebFrameworkUtils.getLoginOrgIdsList());
        mpPage = baseMapper.getPageAllList(mpPage, queryDTO);
        List<SupervisionOutApprovalList> records = mpPage.getRecords();
        if(!CollectionUtils.isEmpty(records)) {
            for (SupervisionOutApprovalList record : records) {
                if(record.getNextUser()!=null){
                    SysUserDO userDO = sysUserMapper.selectById(Long.parseLong(record.getNextUser()));
                    record.setNextUserName(userDO.getUserName());
                } else {
                    if(SurveyConstant.FLOW_STATUS_0.equals(record.getApplyStatus())){
                        record.setNextUser(String.valueOf(record.getApplyUser()));
                        record.setNextUserName(sysUserMapper.selectById(record.getApplyUser()).getUserName());
                    }
                }
            }
        }
        return mpPage;
    }

    @Override
    public Integer getLeaveCount(Long currUserId) {
        LocalDate now = LocalDate.now();
        LocalDate localDate = now.minusDays(60);
        List<SupervisionOutApproval> supervisionOutApprovals = baseMapper.selectList(Wrappers.<SupervisionOutApproval>lambdaQuery()
                .eq(SupervisionOutApproval::getUserId, currUserId)
                .gt(SupervisionOutApproval::getStartDate, localDate.toString()));
        if(CollectionUtils.isEmpty(supervisionOutApprovals)) {
            return 0;
        }
        BigDecimal reduce = supervisionOutApprovals.stream().filter(e -> StringUtils.isNotBlank(e.getLeaveDay())).map(e -> new BigDecimal(e.getLeaveDay())).reduce(BigDecimal.ZERO, BigDecimal::add);
        return Integer.valueOf(reduce.toString());
    }

    @Override
    public void noneTerminate(TerminateLeaveDTO reqDTO) throws Exception {
        checkDataId(reqDTO.getId());
        SupervisionOutApproval supervisionOutApproval = baseMapper.selectById(reqDTO.getId());
        supervisionOutApproval.setTerminateDelay(reqDTO.getTerminateDelay());
        supervisionOutApproval.setTerminateReturnReport(reqDTO.getTerminateReturnReport());
        supervisionOutApproval.setTerminateCommit(reqDTO.getTerminateCommit());
        updateById(supervisionOutApproval);
    }

    @Override
    public void delayTerminate(TerminateLeaveDTO reqDTO , MultipartFile[] files) throws Exception {
        checkDataId(reqDTO.getId());
        SupervisionOutApproval supervisionOutApproval = baseMapper.selectById(reqDTO.getId());
        List<String> fileList = new ArrayList<>();
        for (MultipartFile file : files) {
            FilePathDTO fileFilePath = fileResouceService.createFileFilePath(file);
            fileList.add(fileFilePath.getUrlPath());
        }
        supervisionOutApproval.setTerminateMaterials(org.apache.commons.lang3.StringUtils.join(fileList,","));
        supervisionOutApproval.setTerminateDelay(reqDTO.getTerminateDelay());
        supervisionOutApproval.setTerminateReturnReport(reqDTO.getTerminateReturnReport());
        supervisionOutApproval.setTerminateCommit(reqDTO.getTerminateCommit());
        updateById(supervisionOutApproval);
    }

    @Override
    public void delay(TerminateLeaveDTO reqDTO) throws Exception {
        checkDataId(reqDTO.getId());
        SupervisionOutApproval supervisionOutApproval = baseMapper.selectById(reqDTO.getId());
        supervisionOutApproval.setTerminateDelay(supervisionOutApproval.getTerminateDelay());
        supervisionOutApproval.setTerminateDelayDate(supervisionOutApproval.getTerminateDelayDate());
        supervisionOutApproval.setTerminateDelayDeturn(supervisionOutApproval.getTerminateDelayDeturn());
        updateById(supervisionOutApproval);
    }

    @Override
    public TerminateLeaveDTO getTerinateLeaveDetail(Long id) throws Exception {
        checkDataId(id);
        SupervisionOutApproval supervisionOutApproval = baseMapper.selectById(id);
        TerminateLeaveDTO terminateLeaveDTO = MSupervisionOutApprovalConvert.INSTANCE.toTerminateLeaveDTO(supervisionOutApproval);
        return terminateLeaveDTO;
    }

    private void checkDataId (Long id) throws Exception {
        if( id == null ){
            throw new Exception("请假ID为空");
        }
    }

}
