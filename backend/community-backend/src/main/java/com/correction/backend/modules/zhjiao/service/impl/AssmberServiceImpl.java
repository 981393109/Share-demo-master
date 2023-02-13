package com.correction.backend.modules.zhjiao.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.correction.backend.modules.supervision.controller.dto.SupervisionPositioningDevicesFlowDTO;
import com.correction.backend.modules.sys.entity.OrgDO;
import com.correction.backend.modules.sys.mapper.OrgMapper;
import com.correction.backend.modules.zhjiao.constant.ZhihjiaoConstant;
import com.correction.backend.modules.zhjiao.dto.*;
import com.correction.backend.modules.zhjiao.service.AssmberService;
import com.correction.backend.modules.zhjiao.service.ZhjiaoService;
import com.correction.framework.common.pojo.PageResult;
import com.correction.framework.web.web.core.util.WebFrameworkUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import static com.correction.backend.modules.sys.enums.SysErrorCodeConstants.ORG_PARENT_IS_CITY;
import static com.correction.backend.modules.sys.enums.SysErrorCodeConstants.ORG_districtId;
import static com.correction.framework.common.exception.util.ServiceExceptionUtil.exception;

@Slf4j
@Service
public class AssmberServiceImpl implements AssmberService {

    @Autowired
    private ZhjiaoService zhjiaoService;

    @Resource
    private OrgMapper orgMapper;

    @Value("${zhihuijiao.username}")
    private String username;

    @Value("${zhihuijiao.password}")
    private String password;

    @Override
    public PageResult<JSONObject> getPsychologicalAssmber(PsychologicalQueryDTO queryDTO) throws Exception {
        Long extracted = extracted();
        BaseResponse psychological = zhjiaoService.getPsychological(extracted, queryDTO.getPageNo(), queryDTO.getPageSize(), com.alibaba.fastjson.JSONObject.toJSONString(queryDTO));
        //封装结果
        String data = psychological.getData();
        ResponsePage page = psychological.getPage();
        PageResult<JSONObject> result = new PageResult<>();
        if (StringUtils.isNotBlank(data)) {
            JSONArray jsonArray = JSONArray.parseArray(data);
            List<JSONObject> dataJSON = jsonArray.toJavaList(JSONObject.class);
            result = new PageResult<JSONObject>(dataJSON, page.getTotal());
        }
        return result;
    }


    @Override
    public JSONObject getPositioningPersonnel(PositioningPersonnelQueryDTO queryDTO) throws Exception {
        Long extracted = extracted();
        BaseResponse psychological = zhjiaoService.getPositioningPersonnel(extracted, com.alibaba.fastjson.JSONObject.toJSONString(queryDTO));
        //封装结果
        String data = psychological.getData();
        JSONObject jsonObject = new JSONObject();
        if (StringUtils.isNotBlank(data)) {
            jsonObject = JSONObject.parseObject(data);
        }
        return jsonObject;
    }

    @Override
    public PageResult<JSONObject> getElectronicFence(ElectronicFenceQueryDTO queryDTO) throws Exception {
        Long extracted = extracted();
        BaseResponse psychological = zhjiaoService.getElectronicFence(extracted, queryDTO.getPageNo(), queryDTO.getPageSize(), com.alibaba.fastjson.JSONObject.toJSONString(queryDTO));
        //封装结果
        String data = psychological.getData();
        ResponsePage page = psychological.getPage();
        PageResult<JSONObject> result = new PageResult<>();
        if (StringUtils.isNotBlank(data)) {
            JSONArray jsonArray = JSONArray.parseArray(data);
            List<JSONObject> dataJSON = jsonArray.toJavaList(JSONObject.class);
            result = new PageResult<JSONObject>(dataJSON, page.getTotal());
        }
        return result;
    }

    @Override
    public PageResult<JSONObject> getSignRecord(SignRecordDTO queryDTO) throws Exception {
        Long extracted = extracted();
        BaseResponse psychological = zhjiaoService.getSignRecord(extracted, queryDTO.getPageNo(), queryDTO.getPageSize(), com.alibaba.fastjson.JSONObject.toJSONString(queryDTO, SerializerFeature.PrettyFormat, SerializerFeature.WriteMapNullValue));
        //封装结果
        String data = psychological.getData();
        ResponsePage page = psychological.getPage();
        PageResult<JSONObject> result = new PageResult<>();
        if (StringUtils.isNotBlank(data)) {
            JSONArray jsonArray = JSONArray.parseArray(data);
            List<JSONObject> dataJSON = jsonArray.toJavaList(JSONObject.class);
            result = new PageResult<JSONObject>(dataJSON, page.getTotal());
        }
        return result;
    }

    @Override
    public PageResult<JSONObject> getViolationAlert(ViolationAlertQueryDTO queryDTO) throws Exception {
        Long extracted = extracted();
        BaseResponse psychological = zhjiaoService.getViolationAlert(extracted, queryDTO.getPageNo(), queryDTO.getPageSize(), com.alibaba.fastjson.JSONObject.toJSONString(queryDTO));
        //封装结果
        String data = psychological.getData();
        ResponsePage page = psychological.getPage();
        PageResult<JSONObject> result = new PageResult<>();
        if (StringUtils.isNotBlank(data)) {
            JSONArray jsonArray = JSONArray.parseArray(data);
            List<JSONObject> dataJSON = jsonArray.toJavaList(JSONObject.class);
            result = new PageResult<JSONObject>(dataJSON, page.getTotal());
        }
        return result;
    }

    @Override
    public JSONObject getPositioningUserDetail(Long apperId) throws Exception {
        Long extracted = extracted();
        BaseResponse baseResponse = zhjiaoService.baseInfoAndSign(extracted, apperId);
        //封装结果
        String data = baseResponse.getData();
        JSONObject jsonObject = new JSONObject();
        if (StringUtils.isNotBlank(data)) {
            jsonObject = JSONObject.parseObject(data);
        }
        return jsonObject;
    }

    @Override
    public List<JSONObject> listStreetByPerson() throws Exception {
        Long extracted = extracted();
        BaseResponse baseResponse = zhjiaoService.listStreetByPerson(extracted);
        //封装结果
        String data = baseResponse.getData();
        List<JSONObject> dataJSON = new ArrayList<>();
        if (StringUtils.isNotBlank(data)) {
            JSONArray jsonArray = JSONArray.parseArray(data);
            dataJSON = jsonArray.toJavaList(JSONObject.class);
        }
        return dataJSON;
    }

    @Override
    public JSONObject getToken() {
        BaseResponse aaccessToken = zhjiaoService.getAaccessToken(username, password);
        //封装结果
        String data = aaccessToken.getData();
        JSONObject jsonObject = new JSONObject();
        if (StringUtils.isNotBlank(data)) {
            jsonObject = JSONObject.parseObject(data);
        }
        return jsonObject;
    }

    @Override
    public PageResult<JSONObject> listApper(VideoUserDTO queryDTO) throws Exception {
        Long extracted = extracted();
        BaseResponse listApper = zhjiaoService.listApper(extracted, queryDTO.getPageNo(), queryDTO.getPageSize(), com.alibaba.fastjson.JSONObject.toJSONString(queryDTO));
        //封装结果
        String data = listApper.getData();
        ResponsePage page = listApper.getPage();
        PageResult<JSONObject> result = new PageResult<>();
        if (StringUtils.isNotBlank(data)) {
            JSONArray jsonArray = JSONArray.parseArray(data);
            List<JSONObject> dataJSON = jsonArray.toJavaList(JSONObject.class);
            for (JSONObject jsonObject : dataJSON) {
                String id = jsonObject.getString("id");
                jsonObject.put("videoLink", MessageFormat.format(ZhihjiaoConstant.VIEDO_URL,id,username));
            }
            result = new PageResult<JSONObject>(dataJSON, page.getTotal());
        }
        return result;
    }

    @Override
    public List<JSONObject> getElectronicFenceUserList(ElectronicFenceUserQueryDTO reqDTO) throws Exception {
        Long extracted = extracted();
        BaseResponse baseResponse = zhjiaoService.getElectronicFenceUserList(extracted, reqDTO.getAreaId());
        //封装结果
        String data = baseResponse.getData();
        List<JSONObject> dataJSON = new ArrayList<>();
        if (StringUtils.isNotBlank(data)) {
            JSONArray jsonArray = JSONArray.parseArray(data);
            dataJSON = jsonArray.toJavaList(JSONObject.class);
        }
        return dataJSON;
    }

    @Override
    public JSONObject getPsychologicalAssmberReport(PsychologicalAssmberReportQueryDTO reqDTO) throws Exception {
        Long extracted = extracted();
        BaseResponse baseResponse = zhjiaoService.getPsychologicalAssmberReport(extracted, reqDTO.getApperId());
        //封装结果
        String data = baseResponse.getData();
        JSONObject jsonObject = new JSONObject();
        if (StringUtils.isNotBlank(data)) {
            jsonObject = JSONObject.parseObject(data);
        }
        return jsonObject;
    }

    private OrgDO getOrgById (Long id ){
      return   orgMapper.selectById(id);
    }

    private Long extracted() throws Exception {
        OrgDO orgById = getOrgById(WebFrameworkUtils.getLoginOrgId());
        Long districtId = orgById.getDistrictId();
        if(districtId == null) {
            throw exception(ORG_districtId);
        }
        return districtId;
    }

}
