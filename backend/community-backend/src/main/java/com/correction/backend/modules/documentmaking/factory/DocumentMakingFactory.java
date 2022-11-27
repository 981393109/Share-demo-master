package com.correction.backend.modules.documentmaking.factory;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


@Slf4j
public class DocumentMakingFactory {

    // 用map来保存使用的流程的策略类
    private static Map<String , DocumentService> strategyMap
            = new ConcurrentHashMap<>();

    // 通过模板名称查找对应的使用策略
    public static DocumentService getByMaking(String docType){
        return strategyMap.get(docType);
    }

    // 将模板和对应的使用策略注册到map里
    public static void register(String docType, DocumentService documentService) throws Exception {
        log.info("注入生成文书模板："+docType);
        if (!StringUtils.isBlank(docType)) {
            strategyMap.put(docType, documentService);
        } else {
            throw new Exception("生成文书模板不能为空");
        }
    }

}
