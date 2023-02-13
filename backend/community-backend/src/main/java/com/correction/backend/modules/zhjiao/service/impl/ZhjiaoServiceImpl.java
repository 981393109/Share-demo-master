package com.correction.backend.modules.zhjiao.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.correction.backend.modules.zhjiao.constant.ZhihjiaoConstant;
import com.correction.backend.modules.zhjiao.dto.AccessTokenDTO;
import com.correction.backend.modules.zhjiao.dto.BaseResponse;
import com.correction.backend.modules.zhjiao.service.ZhjiaoService;
import com.correction.backend.modules.zhjiao.util.OkHttpUtil;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Response;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;

@Service
@Slf4j
public class ZhjiaoServiceImpl implements ZhjiaoService {

    private static ConcurrentHashMap<String, AccessTokenDTO> cacheHashMap = new ConcurrentHashMap<>();

    @Value("${zhihuijiao.username}")
    private String username;

    @Value("${zhihuijiao.password}")
    private String password;


    @Override
    public BaseResponse getAaccessToken(String userName, String password) {
        try {
            String accessToken = ZhihjiaoConstant.ACCESS_TOKEN;
            accessToken = MessageFormat.format(accessToken, userName , password);
            Map<String ,String> headerParams = new HashMap<>();
            Map<String ,String> bodyParams = new HashMap<>();
            Response response = OkHttpUtil.getInstance().postData(accessToken, headerParams, JSONObject.toJSONString(bodyParams));
            String result  = response.body().string();
            log.info("token请求URL:{}",accessToken);
            log.info("token请求json:{}", JSONObject.toJSONString(bodyParams));
            log.info("token请求结果:{}", result);
            return JSONObject.parseObject(result,BaseResponse.class);
        } catch ( Exception e ){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * 心理评估
     * @param districtId
     * @param pageNo
     * @param pageSize
     * @param body
     * @return
     */
    @Override
    public BaseResponse getPsychological(Long districtId, Integer pageNo, Integer pageSize, String body) throws Exception {
        String psychologicalEvluation = ZhihjiaoConstant.PSYCHOLOGICAL_EVLUATION;
        psychologicalEvluation = MessageFormat.format(psychologicalEvluation,districtId,pageNo,pageSize);
        AccessTokenDTO token = getToken();
        BaseResponse baseResponse = getBaseResponse(body, psychologicalEvluation, token);
        return baseResponse;
    }

    /**
     * 人员定位
     * @param districtId
     * @param body
     * @return
     */
    @Override
    public BaseResponse getPositioningPersonnel(Long districtId, String body) throws Exception {
        String positioningPersonnel = ZhihjiaoConstant.POSITIONING_PERSONNEL;
        positioningPersonnel = MessageFormat.format(positioningPersonnel,districtId);
        AccessTokenDTO token = getToken();
        BaseResponse baseResponse = getBaseResponse(body, positioningPersonnel, token);
        return baseResponse;
    }

    @Override
    public BaseResponse getElectronicFence(Long districtId, Integer pageNo, Integer pageSize, String body) throws Exception {
        String electronicFence = ZhihjiaoConstant.ELECTRONIC_FENCE;
        electronicFence = MessageFormat.format(electronicFence,districtId,pageNo,pageSize);
        AccessTokenDTO token = getToken();
        BaseResponse baseResponse = getBaseResponse(body, electronicFence, token);
        return baseResponse;
    }

    @Override
    public BaseResponse getSignRecord(Long districtId, Integer pageNo, Integer pageSize, String body) throws Exception {
        String signRecord = ZhihjiaoConstant.SIGN_RECORD;
        signRecord = MessageFormat.format(signRecord,districtId,pageNo,pageSize);
        AccessTokenDTO token = getToken();
        BaseResponse baseResponse = getBaseResponse(body, signRecord, token);
        return baseResponse;
    }

    @Override
    public BaseResponse getViolationAlert(Long districtId, Integer pageNo, Integer pageSize, String body) throws Exception {
        String violationAlert = ZhihjiaoConstant.VIOLATION_ALERT;
        violationAlert = MessageFormat.format(violationAlert,districtId,pageNo,pageSize);
        AccessTokenDTO token = getToken();
        BaseResponse baseResponse = getBaseResponse(body, violationAlert, token);
        return baseResponse;
    }

    @Override
    public BaseResponse baseInfoAndSign(Long districtId, Long apperId) throws Exception {
        String positioningUserDetail = ZhihjiaoConstant.POSITIONING_USER_DETAIL;
        positioningUserDetail = MessageFormat.format(positioningUserDetail,districtId,String.valueOf(apperId));
        AccessTokenDTO token = getToken();
        BaseResponse baseResponse = getBaseResponse("{}", positioningUserDetail, token);
        return baseResponse;
    }

    @Override
    public BaseResponse listStreetByPerson(Long districtId) throws Exception {
        String positioningStreeList = ZhihjiaoConstant.POSITIONING_STREE_LIST;
        positioningStreeList = MessageFormat.format(positioningStreeList,districtId);
        AccessTokenDTO token = getToken();
        BaseResponse baseResponse = getBaseResponse("{}", positioningStreeList, token);
        return baseResponse;
    }

    @Override
    public BaseResponse listApper(Long extracted, Integer pageNo, Integer pageSize, String body) throws Exception {
        String viedoUserUrl = ZhihjiaoConstant.VIEDO_USER_URL;
        viedoUserUrl = MessageFormat.format(viedoUserUrl,extracted,pageNo,pageSize);
        AccessTokenDTO token = getToken();
        BaseResponse baseResponse = getBaseResponse(body, viedoUserUrl, token);
        return baseResponse;
    }

    @Override
    public BaseResponse getElectronicFenceUserList(Long districtId, Long apperId) throws Exception {
        String viedoUserUrl = ZhihjiaoConstant.ELECTRONIC_FENCE_USERS_LIST;
        viedoUserUrl = MessageFormat.format(viedoUserUrl,districtId,apperId);
        AccessTokenDTO token = getToken();
        BaseResponse baseResponse = getBaseResponse("{}", viedoUserUrl, token);
        return baseResponse;
    }

    @Override
    public BaseResponse getPsychologicalAssmberReport(Long extracted, Long apperId) throws Exception {
        String viedoUserUrl = ZhihjiaoConstant.POSITIONING_PERSONNEL_REPORT;
        viedoUserUrl = MessageFormat.format(viedoUserUrl,extracted,apperId);
        AccessTokenDTO token = getToken();
        BaseResponse baseResponse = getBaseResponse("{}", viedoUserUrl, token);
        return baseResponse;
    }


    private BaseResponse getBaseResponse(String body, String url, AccessTokenDTO token) throws Exception {
        Map<String ,String> headerParams = new HashMap<>();
        headerParams.put("Content-Type","application/json");
        headerParams.put("Authorization","Bearer "+token.getAccessToken());
        Response response = OkHttpUtil.getInstance().postData(url, headerParams, body);
        String result  = response.body().string();
        log.info("token请求URL:{}","Bearer "+ token.getAccessToken());
        log.info("token请求URL:{}",url);
        log.info("token请求json:{}", body);
        log.info("token请求结果:{}", result);
        BaseResponse baseResponse = JSONObject.parseObject(result, BaseResponse.class);
        return baseResponse;
    }


    private AccessTokenDTO getToken(){
        AccessTokenDTO cacheAccess = cacheHashMap.get(username);
        if(cacheAccess == null){
            cacheAccess = getAccessToken();
            cacheHashMap.put(username,cacheAccess);
        } else {
            //判断是否已过期：
            Date date = new Date();
            long nowTime = date.getTime();
            long applyTime = cacheAccess.getApplyTime();
            if (nowTime-applyTime >= 7600000){
                cacheAccess = getAccessToken();
                cacheHashMap.put(username,cacheAccess);
            }
        }
        return cacheAccess;
    }

    private AccessTokenDTO getAccessToken() {
        AccessTokenDTO result = null;
        try {
            BaseResponse aaccessToken = getAaccessToken(username, password);
            String data = aaccessToken.getData();
            result = JSONObject.parseObject(data, AccessTokenDTO.class);
            result.setApplyTime(new Date().getTime());
        } catch (Exception e ){
            log.info("getAccessToken error :",e);
        }
        return result;
    }


    public static void main(String[] args) throws Exception {
        String accessToken = ZhihjiaoConstant.ACCESS_TOKEN;
        accessToken =  MessageFormat.format(accessToken, "system" , "WmhqaWFvQGhlZGE=**RSA");
        Map<String ,String> headerParams = new HashMap<>();
        Map<String ,String> bodyParams = new HashMap<>();
        Response response = OkHttpUtil.getInstance().postData(accessToken, headerParams, JSONObject.toJSONString(bodyParams));
        String result  = response.body().string();
        BaseResponse baseResponse = JSONObject.parseObject(result, BaseResponse.class);
        log.info("token请求URL:{}",accessToken);
        log.info("token请求json:{}", JSONObject.toJSONString(bodyParams));
        log.info("token请求结果:{}", result);
        String data = baseResponse.getData();
        AccessTokenDTO accessTokenDTO = JSONObject.parseObject(data, AccessTokenDTO.class);
        System.out.println(accessTokenDTO);

    }


}
