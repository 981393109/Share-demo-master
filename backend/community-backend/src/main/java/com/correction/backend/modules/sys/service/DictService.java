package com.correction.backend.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.correction.backend.modules.sys.entity.Dict;

import java.util.List;

/**
 * <p>
 * 全局字典表 服务类
 * </p>
 *
 * @author yao
 * @since 2022-11-12
 */
public interface DictService extends IService<Dict> {

    List<Dict> selectDictByType(Integer type);

}
