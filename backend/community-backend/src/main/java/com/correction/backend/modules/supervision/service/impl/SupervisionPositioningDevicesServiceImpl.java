package com.correction.backend.modules.supervision.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.correction.backend.modules.supervision.constant.SupervisionConstant;
import com.correction.backend.modules.supervision.controller.dto.*;
import com.correction.backend.modules.supervision.convert.MSupervisionOutApprovalConvert;
import com.correction.backend.modules.supervision.convert.MSupervisionPositioningDevicesConvert;
import com.correction.backend.modules.supervision.convert.MSupervisionVisitGroupConvert;
import com.correction.backend.modules.supervision.entity.SupervisionOutApproval;
import com.correction.backend.modules.supervision.entity.SupervisionVisitGroup;
import com.correction.backend.modules.supervision.service.SupervisionPositioningDevicesService;
import com.correction.backend.modules.supervision.entity.SupervisionPositioningDevices;
import com.correction.backend.modules.supervision.mapper.SupervisionPositioningDevicesMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.correction.backend.modules.supervision.service.SupervisionVisitGroupService;
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
import com.correction.frameworks.mybatis.mybatis.core.util.MyBatisUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 电子定位装置审批 服务实现类
 * </p>
 *
 * @author yao
 * @since 2022-12-03
 */
@Service
public class SupervisionPositioningDevicesServiceImpl extends ServiceImpl<SupervisionPositioningDevicesMapper, SupervisionPositioningDevices> implements SupervisionPositioningDevicesService {

    @Resource
    SysUserMapper sysUserMapper;

    @Resource
    private SurveyDocumentsFilesService surveyDocumentsFilesService;

    @Resource
    private SupervisionVisitGroupService supervisionVisitGroupService;


    @Override
    public SupervisionPositioningDevices createSupervisionPositiongDevices(SupervisionPositioningDevicesCreateInputDTO createInputDTO) throws Exception {
        checkSaveOrUpdate(createInputDTO.getType());
        SupervisionPositioningDevices supervisionPositioningDevices = MSupervisionPositioningDevicesConvert.INSTANCE.toSupervisionPositioningDevices(createInputDTO);
        LoginUser loginUser = WebFrameworkUtils.getLoginUser();
        supervisionPositioningDevices.setApplyName(loginUser.getUsername());
        supervisionPositioningDevices.setApplyUser(loginUser.getId());
        supervisionPositioningDevices.setApplyStatus(SurveyConstant.FLOW_STATUS_0);
        supervisionPositioningDevices.setProgress(SurveyConstant.PROGRESS_1);
        supervisionPositioningDevices.setOrgNum(WebFrameworkUtils.getLoginOrgNum());
        supervisionPositioningDevices.setRef(String.valueOf(System.currentTimeMillis()));
        baseMapper.insert(supervisionPositioningDevices);
        supervisionVisitGroupService.createSupervisionVisitGroupList(createInputDTO.getUserGroupList(),supervisionPositioningDevices.getId(),2);
        List<SurveyDocumentsFiles> surveyDocumentsFiles = createInputDTO.getSurveyDocumentsFiles();
        if (!CollectionUtils.isEmpty(surveyDocumentsFiles)){
            for (SurveyDocumentsFiles surveyDocumentsFile : surveyDocumentsFiles) {
                surveyDocumentsFile.setDataId(supervisionPositioningDevices.getId());
                surveyDocumentsFilesService.updateById(surveyDocumentsFile);
            }
        }
        return supervisionPositioningDevices;
    }


    @Override
    public SupervisionPositioningDevices updateSupervisionPositiongDevices(SupervisionPositioningDevicesUpdateInputDTO updateInputDTO) throws Exception {
        checkSaveOrUpdate(updateInputDTO.getType());
        SupervisionPositioningDevices supervisionPositioningDevices = MSupervisionPositioningDevicesConvert.INSTANCE.toSupervisionPositioningDevices(updateInputDTO);
        baseMapper.updateById(supervisionPositioningDevices);
        supervisionVisitGroupService.updateSupervisionVisitGroupList(updateInputDTO.getUserGroupList(), supervisionPositioningDevices.getId(),2);
        return baseMapper.selectById(updateInputDTO.getId());
    }

    @Override
    public SupervisionPositioningDevices updateSupervisionPositiongDevices(SupervisionPositioningDevices updateInputDTO) {
        updateById(updateInputDTO);
        return baseMapper.selectById(updateInputDTO.getId());
    }

    @Override
    public SupervisionPositioningDevices getDetail(Long id) {
        SupervisionPositioningDevices supervisionPositioningDevices = baseMapper.selectById(id);
        return supervisionPositioningDevices;
    }

    @Override
    public SupervisionPositioningDevicesDetailDTO getDetailById(Long id) {
        SupervisionPositioningDevices supervisionPositioningDevices = baseMapper.selectById(id);
        List<SupervisionVisitGroup> listByDataId = supervisionVisitGroupService.getListByDataId(id,2);
        Integer type = supervisionPositioningDevices.getType();
        SupervisionPositioningDevicesDetailDTO dto = new SupervisionPositioningDevicesDetailDTO();
        dto.setDetail(MSupervisionPositioningDevicesConvert.INSTANCE.toList(supervisionPositioningDevices));
        dto.setUserGroupList(MSupervisionVisitGroupConvert.INSTANCE.toList(listByDataId));
        if(1 == type){
            //使用电子定位装置审批申请材料
            List<SurveyDocumentsFilesDTO> DICT_TYPE_SUPERVISION_POSITIONING_1 = surveyDocumentsFilesService
                    .getSurveyDocumentList(SurveyDocumentsFilesQuery.builder().dictType(SupervisionConstant.DICT_TYPE_SUPERVISION_POSITIONING_1).dataId(id).build());
            List<SurveyDocumentsFilesDTO> DICT_TYPE_SUPERVISION_POSITIONING_2 = surveyDocumentsFilesService
                    .getSurveyDocumentList(SurveyDocumentsFilesQuery.builder().dictType(SupervisionConstant.DICT_TYPE_SUPERVISION_POSITIONING_2).dataId(id).build());
            List<SurveyDocumentsFilesDTO> DICT_TYPE_SUPERVISION_POSITIONING_3 = surveyDocumentsFilesService
                    .getSurveyDocumentList(SurveyDocumentsFilesQuery.builder().dictType(SupervisionConstant.DICT_TYPE_SUPERVISION_POSITIONING_3).dataId(id).build());
            dto.setApprovalMaterials(DICT_TYPE_SUPERVISION_POSITIONING_1);
            dto.setJusticeMaterials(DICT_TYPE_SUPERVISION_POSITIONING_2);
            dto.setInformMaterials(DICT_TYPE_SUPERVISION_POSITIONING_3);
        } else if (2 == type) {
            //延长电子定位装置审批申请材料
            List<SurveyDocumentsFilesDTO> DICT_TYPE_SUPERVISION_POSITIONING_4 = surveyDocumentsFilesService
                    .getSurveyDocumentList(SurveyDocumentsFilesQuery.builder().dictType(SupervisionConstant.DICT_TYPE_SUPERVISION_POSITIONING_4).dataId(id).build());
            List<SurveyDocumentsFilesDTO> DICT_TYPE_SUPERVISION_POSITIONING_5 = surveyDocumentsFilesService
                    .getSurveyDocumentList(SurveyDocumentsFilesQuery.builder().dictType(SupervisionConstant.DICT_TYPE_SUPERVISION_POSITIONING_5).dataId(id).build());
            List<SurveyDocumentsFilesDTO> DICT_TYPE_SUPERVISION_POSITIONING_6 = surveyDocumentsFilesService
                    .getSurveyDocumentList(SurveyDocumentsFilesQuery.builder().dictType(SupervisionConstant.DICT_TYPE_SUPERVISION_POSITIONING_6).dataId(id).build());
            dto.setDelayMaterials(DICT_TYPE_SUPERVISION_POSITIONING_4);
            dto.setDelayJusticeMaterials(DICT_TYPE_SUPERVISION_POSITIONING_5);
            dto.setDelayIformMaterials(DICT_TYPE_SUPERVISION_POSITIONING_6);
        } else if (3 == type) {
            //解除
            List<SurveyDocumentsFilesDTO> DICT_TYPE_SUPERVISION_POSITIONING_7 = surveyDocumentsFilesService
                    .getSurveyDocumentList(SurveyDocumentsFilesQuery.builder().dictType(SupervisionConstant.DICT_TYPE_SUPERVISION_POSITIONING_7).dataId(id).build());
            List<SurveyDocumentsFilesDTO> DICT_TYPE_SUPERVISION_POSITIONING_8 = surveyDocumentsFilesService
                    .getSurveyDocumentList(SurveyDocumentsFilesQuery.builder().dictType(SupervisionConstant.DICT_TYPE_SUPERVISION_POSITIONING_8).dataId(id).build());
            List<SurveyDocumentsFilesDTO> DICT_TYPE_SUPERVISION_POSITIONING_9 = surveyDocumentsFilesService
                    .getSurveyDocumentList(SurveyDocumentsFilesQuery.builder().dictType(SupervisionConstant.DICT_TYPE_SUPERVISION_POSITIONING_9).dataId(id).build());
            dto.setRemoveMaterials(DICT_TYPE_SUPERVISION_POSITIONING_7);
            dto.setRemoveJusticeMaterials(DICT_TYPE_SUPERVISION_POSITIONING_8);
            dto.setRemoveIformMaterials(DICT_TYPE_SUPERVISION_POSITIONING_9);
        } else {
            //from
            List<SurveyDocumentsFilesDTO> DICT_TYPE_SUPERVISION_POSITIONING_10 = surveyDocumentsFilesService
                    .getSurveyDocumentList(SurveyDocumentsFilesQuery.builder().dictType(SupervisionConstant.DICT_TYPE_SUPERVISION_POSITIONING_10).dataId(id).build());
            List<SurveyDocumentsFilesDTO> DICT_TYPE_SUPERVISION_POSITIONING_11 = surveyDocumentsFilesService
                    .getSurveyDocumentList(SurveyDocumentsFilesQuery.builder().dictType(SupervisionConstant.DICT_TYPE_SUPERVISION_POSITIONING_11).dataId(id).build());
            List<SurveyDocumentsFilesDTO> DICT_TYPE_SUPERVISION_POSITIONING_12 = surveyDocumentsFilesService
                    .getSurveyDocumentList(SurveyDocumentsFilesQuery.builder().dictType(SupervisionConstant.DICT_TYPE_SUPERVISION_POSITIONING_12).dataId(id).build());
            dto.setFromMaterials(DICT_TYPE_SUPERVISION_POSITIONING_10);
            dto.setFromJusticeMaterials(DICT_TYPE_SUPERVISION_POSITIONING_11);
            dto.setFromIformMaterials(DICT_TYPE_SUPERVISION_POSITIONING_12);
        }
        return dto;
    }

    @Override
    public void delete(Long id) {
        baseMapper.deleteById(id);
    }

    @Override
    public IPage<SupervisionPositioningDevicesFlowDTO> getPageList(SupervisionPositioningDevicesSearchInputDTO searchInputDTO) {
        IPage<SupervisionPositioningDevicesFlowDTO> mpPage = MyBatisUtils.buildPage(searchInputDTO);
        searchInputDTO.setApplyUser(WebFrameworkUtils.getLoginUserId());
        mpPage = baseMapper.getPageList(mpPage, searchInputDTO);
        List<SupervisionPositioningDevicesFlowDTO> records = mpPage.getRecords();
        if(!CollectionUtils.isEmpty(records)) {
            for (SupervisionPositioningDevicesFlowDTO record : records) {
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
                } else if (!String.valueOf(WebFrameworkUtils.getLoginUserId()).equals(record.getNextUser())  && StringUtils.isNotBlank(record.getTaskId())) {
                    record.setFlowStatus(1);
                } else {
                    record.setFlowStatus(2);
                }
            }
        }
        return mpPage;
    }


    private void checkSaveOrUpdate(Integer type) throws Exception {
        if (type == null) {
            throw new Exception("type is null");
        }
    }

}
