package com.correction.backend.modules.sys.service.impl;

import com.correction.backend.modules.sys.controller.dto.logger.SysLoginLogCreateReqDTO;
import com.correction.backend.modules.sys.convert.logger.SysLoginLogConvert;
import com.correction.backend.modules.sys.entity.SysLoginLogDO;
import com.correction.backend.modules.sys.mapper.SysLoginLogMapper;
import com.correction.backend.modules.sys.service.SysLoginLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class SysLoginLogServiceImpl implements SysLoginLogService {

    @Resource
    private SysLoginLogMapper loginLogMapper;


    @Override
    public void createLoginLog(SysLoginLogCreateReqDTO reqVO) {
        SysLoginLogDO convert = SysLoginLogConvert.INSTANCE.convert(reqVO);
        loginLogMapper.insert(convert);
    }



}
