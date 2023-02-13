package com.correction.backend.modules.sys.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.correction.backend.modules.sys.entity.Dict;
import com.correction.backend.modules.sys.mapper.DictMapper;
import com.correction.backend.modules.sys.service.DictService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 全局字典表 服务实现类
 * </p>
 *
 * @author yao
 * @since 2022-11-12
 */
@Service
public class DictServiceImpl extends ServiceImpl<DictMapper, Dict> implements DictService {


    @Override
    public List<Dict> selectDictByType(String  type) {
        String[] split = type.split(",");
        List<Dict> result  = new ArrayList<>();
        for (String s : split) {
            result.addAll(baseMapper.selectDictByType(Integer.parseInt(s)));
        }
        return result;
    }
}
