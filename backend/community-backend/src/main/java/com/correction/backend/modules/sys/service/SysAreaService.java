package com.correction.backend.modules.sys.service;

import com.correction.backend.modules.sys.controller.dto.sys.AreaOutDTO;
import com.correction.backend.modules.sys.controller.dto.sys.SysAreaDTO;
import com.correction.backend.modules.sys.entity.SysArea;
import com.baomidou.mybatisplus.extension.service.IService;
import com.correction.framework.common.pojo.CommonResult;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yao
 * @since 2022-11-16
 */
public interface SysAreaService extends IService<SysArea> {


    List<SysArea> getSysArea (SysAreaDTO dto);


    List<AreaOutDTO> getHZArea();
}
