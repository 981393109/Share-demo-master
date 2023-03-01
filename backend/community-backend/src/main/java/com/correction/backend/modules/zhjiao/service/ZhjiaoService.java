package com.correction.backend.modules.zhjiao.service;

import com.correction.backend.modules.zhjiao.dto.BaseResponse;
import liquibase.pro.packaged.S;

import java.io.IOException;

/**
 * 智慧矫相关接口
 */
public interface ZhjiaoService {


    /**
     * 获取token
     */
    BaseResponse getAaccessToken (String userName ,String password);

    /**
     * 心理评估数据
     *{"apperName":null,"streetId":null,"stage":null,"assessStatus":null,"apperStatus":null}
     */
    BaseResponse getPsychological (Long districtId,Integer pageNo,Integer pageSize,String body) throws IOException, Exception;

    /**
     * 人员定位
     * {"apperName":null,"deviceType":null,"streetIds":[]}
     */
    BaseResponse getPositioningPersonnel (Long districtId, String body) throws Exception;

    /**
     * 电子围栏
     * {"name":null}
     */
    BaseResponse getElectronicFence (Long districtId,Integer pageNo,Integer pageSize,String body) throws Exception;

    /**
     * 签到记录
     * {"apperName":null,"signDate":"2022-12-19","streetIds":[],"isViolation":null}
     *
     */
    BaseResponse getSignRecord (Long districtId,Integer pageNo,Integer pageSize,String body) throws Exception;

    /**
     * 违规 Violation Alert
     * {"apperName":null,"streetIds":[],"status":3,"endDate":null,"startDate":null,"types":[],"resultTypes":[2]}
     */
    BaseResponse getViolationAlert (Long districtId,Integer pageNo,Integer pageSize,String body) throws Exception;

    /**
     * 获取动态定位人员详情信息
     * districtId:
     * 11
     * apperId:
     * 11453
     */
    BaseResponse baseInfoAndSign (Long districtId, Long apperId ) throws Exception;


    /**
     * 获取动态定位区列表
     */
    BaseResponse listStreetByPerson(Long districtId) throws Exception;

    /**
     * 视频抽查人员列表
     * @param extracted
     * @param pageNo
     * @param pageSize
     * @param toJSONString
     * @return
     */
    BaseResponse listApper(Long extracted, Integer pageNo, Integer pageSize, String toJSONString) throws Exception;

    /**
     * 获取电子围栏人员列表
     */
    BaseResponse getElectronicFenceUserList (Long districtId, Long apperId ) throws Exception;

    /**
     * 心理评估-查看报告
     * https://api.zhjiao.com/v1/apper/baseInfo/14212?districtId=22
     * @param extracted
     * @param apperId
     * @return
     */
    BaseResponse getPsychologicalAssmberReport(Long extracted, Long apperId) throws Exception;

    /**
     * 得到智慧矫正用户token
     * @param relationUserId
     * @return
     */
    BaseResponse getCurrUserToken(Long relationUserId) throws Exception;
}
