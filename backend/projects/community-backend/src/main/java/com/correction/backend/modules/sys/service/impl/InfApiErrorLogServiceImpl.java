package com.correction.backend.modules.sys.service.impl;


import com.correction.backend.modules.sys.service.InfApiErrorLogService;
import com.correction.framework.web.apilog.core.service.dto.ApiErrorLogCreateDTO;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Future;


/**
 * API 错误日志 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class InfApiErrorLogServiceImpl implements InfApiErrorLogService {

  /*  @Resource
    private InfApiErrorLogMapper apiErrorLogMapper;*/


    @Override
    public Future<Boolean> createApiErrorLogAsync(ApiErrorLogCreateDTO createDTO) {

        return null;
    }
}
