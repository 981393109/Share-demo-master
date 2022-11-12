package com.correction.backend.modules.sys.service.impl;

import com.correction.backend.modules.sys.service.InfApiAccessLogService;
import com.correction.framework.web.apilog.core.service.dto.ApiAccessLogCreateDTO;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.concurrent.Future;

/**
 * API 访问日志 Service 实现类
 *
 */
@Service
@Validated
public class InfApiAccessLogServiceImpl implements InfApiAccessLogService {

   /* @Resource
    private InfApiAccessLogMapper apiAccessLogMapper;*/

    @Override
    @Async
    public Future<Boolean> createApiAccessLogAsync(ApiAccessLogCreateDTO createDTO) {
       /* // 插入
        InfApiAccessLogDO apiAccessLog = InfApiAccessLogConvert.INSTANCE.convert(createDTO);
        int insert = apiAccessLogMapper.insert(apiAccessLog);
        return new AsyncResult<>(insert == 1);*/
        return new AsyncResult<>(true);
    }



}
