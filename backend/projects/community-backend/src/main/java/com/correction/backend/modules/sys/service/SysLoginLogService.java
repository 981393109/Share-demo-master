package com.correction.backend.modules.sys.service;

import com.correction.backend.modules.sys.controller.dto.logger.SysLoginLogCreateReqDTO;

/**
 * 登录日志相关接口
 */
public interface SysLoginLogService {

    /**
     * 创建登录日志
     * @param reqVO
     */
    void createLoginLog(SysLoginLogCreateReqDTO reqVO);


}
