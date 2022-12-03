package com.correction.backend.modules.documentmaking.factory.impl;

import com.correction.backend.modules.documentmaking.entity.DocumentMakeing;
import com.correction.backend.modules.documentmaking.factory.DocumentMakingFactory;
import com.correction.backend.modules.documentmaking.factory.DocumentService;
import com.correction.backend.modules.documentmaking.mapper.DocumentMakeingMapper;
import com.correction.backend.modules.documentmaking.service.DocumentMakeingService;
import com.correction.backend.modules.file.config.FileProperties;
import com.correction.backend.modules.flow.constant.FlowConstant;
import com.correction.backend.modules.flow.factory.complete.FlowCompleteFactory;
import com.correction.backend.modules.handleCorrection.entity.CorrectionUser;
import com.correction.backend.modules.handleCorrection.entity.HandleCorrection;
import com.correction.backend.modules.handleCorrection.service.CorrectionUserService;
import com.correction.backend.modules.handleCorrection.service.HandleCorrectionService;
import com.correction.backend.modules.survey.entity.SurveyEvaluation;
import com.correction.backend.modules.survey.service.SurveyEvaluationService;
import com.correction.framework.common.util.pdf.PdfUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import static com.correction.backend.modules.documentmaking.constant.DocumentMakingConstant.Correction_Making;
import static com.correction.backend.modules.survey.constant.SurveyConstant.PROGRESS_12;
import static com.correction.backend.modules.sys.enums.SysErrorCodeConstants.FLOW_DATA_STOP;
import static com.correction.backend.modules.sys.enums.SysErrorCodeConstants.USER_ROLE_IS_NOT_EXSIT;
import static com.correction.framework.common.exception.util.ServiceExceptionUtil.exception;

@Component
@Slf4j
public class HandleCorrectionMakingServiceImpl implements DocumentService {

    private static final String  FILE_NAME = "矫正对象基本信息表.pdf";

    @Resource
    DocumentMakeingMapper documentMakeingMapper;

    @Resource
    HandleCorrectionService handleCorrectionService;

    @Resource
    SurveyEvaluationService surveyEvaluationService;

    @Resource
    CorrectionUserService correctionUserService;

    @Resource
    FileProperties fileProperties;

    @Override
    public String makingDoc(Long dataId) throws Exception {
        HandleCorrection handleCorrection = handleCorrectionService.getById(dataId);
        if (!PROGRESS_12.equals(handleCorrection.getProgress())){
            throw exception(FLOW_DATA_STOP);
        }
        //得到默认模板位置
        ClassPathResource classPathResource = new ClassPathResource("documentTemplate/CorrectionBasicInformationTable.pdf");
        InputStream inputStream = classPathResource.getInputStream();
        String filePath = File.separator + "PDF_TEMP" + File.separator + System.currentTimeMillis() + File.separator + FILE_NAME;
        String outFilePath =  File.separator + "DOCUMENT_MAKING" + File.separator+ System.currentTimeMillis() + File.separator + FILE_NAME;
        File file = new File(fileProperties.getLinuxpath() + filePath);
        FileUtils.copyInputStreamToFile(inputStream, file);
        Map<String,String> map = initMap(handleCorrection);
        PdfUtil.initPdfText(map , file.getPath() ,fileProperties.getLinuxpath() + outFilePath);
        //保存
        DocumentMakeing documentMakeing = new DocumentMakeing();
        documentMakeing.setDataId(dataId);
        documentMakeing.setDataType(FlowConstant.HANDLE_CORRECTION_FLOW);
        documentMakeing.setFileName(FILE_NAME);
        documentMakeing.setFilePath(outFilePath);
        documentMakeing.setFileUrl(fileProperties.getBasePath() + outFilePath);
        documentMakeingMapper.insert(documentMakeing);
        return documentMakeing.getFileUrl();
    }


    private Map<String, String> initMap(HandleCorrection handleCorrection) {
        SurveyEvaluation surveyEvaluation = surveyEvaluationService.getById(handleCorrection.getSurveyEvaluationId());
        CorrectionUser correctionUser = correctionUserService.getByCorrectionId(handleCorrection.getId());
        Map<String,String > map = new HashMap<>();
        //编号
        map.put("num1","");
        //填表日期
        map.put("num2","");
        //姓名：
        map.put("num3",checkNum(handleCorrection.getName()));
        //曾用名
        map.put("num4","");
        //身份证号码
        map.put("num5",checkNum(surveyEvaluation.getIdCard()));
        //性别
        map.put("num3_1","1".equals(correctionUser.getSex())?"男":"女");
        //民族
        map.put("num3_2","");
        //出生年月日
        map.put("num3_3",checkNum(correctionUser.getBirthday()));
        //文化程度
        map.put("num7","");
        //健康状态
        map.put("num8","");
        //原政治面貌
        map.put("num9","");
        //婚姻
        map.put("num10","0".equals(correctionUser.getMaritalStatus())?"未婚":"已婚");
        //户籍地
        map.put("num11",checkNum(correctionUser.getHousehold()));
        //居住地
        map.put("num12",checkNum(correctionUser.getAddress()));
        //执行地
        map.put("num13",checkNum(surveyEvaluation.getJurisdictionOffice()));
        //现工作单位
        map.put("num14","");
        map.put("num15",checkNum(correctionUser.getMobile()));
        map.put("num16",checkNum(correctionUser.getMobile()));
        //案由
        map.put("num17",checkNum(surveyEvaluation.getCauseAction()));
        // 刑种
        map.put("num18","");
        //原判期刑
        map.put("num19","");
        //社区矫正决定机关
        map.put("num20",checkNum(handleCorrection.getJurisdictionOffice()));
        //原羁押场所
        map.put("num21","");
        //禁止令内容
        map.put("num22","");
        //禁止期限起止日
        map.put("num23","");
        //附加刑判项内容
        map.put("num24","");
        //矫正类别
        map.put("num25","");
        //矫正期限
        map.put("num26","");
        //起止日
        map.put("num27","");
        //法律文书收到时间及种类
        map.put("num28","");
        //接收方式及报到时间
        map.put("num29","");
        //在规定时间内报到
        map.put("num30","");
        //超出规定时限报到
        map.put("num31","");
        //未报到且下落不明
        map.put("num32","");
        //主要犯罪事实
        map.put("num33","");
        //本次犯罪前的违法犯罪记录
        map.put("num34","");
        //。。。。

        //备注
        return map;
    }

    private static String checkNum(String word){
        return StringUtils.isBlank(word)?"":word;
    }


    @PostConstruct
    public void afterPropertiesSet() throws Exception {
        // 注册到Map中
        DocumentMakingFactory.register(FlowConstant.HANDLE_CORRECTION_FLOW, this);
    }


}
