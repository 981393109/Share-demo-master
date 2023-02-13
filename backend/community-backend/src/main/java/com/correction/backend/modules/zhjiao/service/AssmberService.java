package com.correction.backend.modules.zhjiao.service;

import com.alibaba.fastjson.JSONObject;
import com.correction.backend.modules.zhjiao.dto.*;
import com.correction.framework.common.pojo.PageResult;

import java.io.IOException;
import java.util.List;

/**
 * 智慧矫组装接口
 */
public interface AssmberService {

    /**
     * 获取心理评估列表
     * {"apperName":null,"streetId":null,"stage":null,"assessStatus":null,"apperStatus":null}
     */
    PageResult<JSONObject> getPsychologicalAssmber (PsychologicalQueryDTO queryDTO) throws Exception;

    /**
     * 人员定位
     * {"apperName":null,"deviceType":null,"streetIds":[]}
     */
    JSONObject getPositioningPersonnel (PositioningPersonnelQueryDTO queryDTO) throws Exception;

    /**
     * 电子围栏
     * {"name":null}
     */
    PageResult<JSONObject> getElectronicFence (ElectronicFenceQueryDTO queryDTO) throws Exception;

    /**
     * 签到记录
     * {"apperName":null,"signDate":"2022-12-19","streetIds":[],"isViolation":null}
     *
     */
    PageResult<JSONObject> getSignRecord (SignRecordDTO queryDTO) throws Exception;

    /**
     * 违规 Violation Alert
     * {"apperName":null,"streetIds":[],"status":3,"endDate":null,"startDate":null,"types":[],"resultTypes":[2]}
     */
    PageResult<JSONObject> getViolationAlert (ViolationAlertQueryDTO queryDTO) throws Exception;

    /**
     * 动态定位获取人员详情
     */
    JSONObject getPositioningUserDetail (Long apperId) throws Exception;

    /**
     * 动态定位获取街道列表
     */
    List<JSONObject> listStreetByPerson () throws Exception;

    /**
     * 获取智慧矫正token
     * @return
     */
    JSONObject getToken();

    /**
     * 视频抽查人员列表
     * @param reqVO
     * @return
     */
    PageResult<JSONObject> listApper(VideoUserDTO reqVO) throws Exception;

    /**
     * 电子围栏-人员列表
     */
    List<JSONObject> getElectronicFenceUserList (ElectronicFenceUserQueryDTO reqDTO) throws Exception;

    /**
     * 心理评估-查看报告
     */
    JSONObject getPsychologicalAssmberReport (PsychologicalAssmberReportQueryDTO reqDTO) throws Exception;
}
