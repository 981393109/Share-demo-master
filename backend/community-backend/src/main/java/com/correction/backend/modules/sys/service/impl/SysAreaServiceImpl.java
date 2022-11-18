package com.correction.backend.modules.sys.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.correction.backend.modules.sys.controller.dto.sys.AreaOutDTO;
import com.correction.backend.modules.sys.controller.dto.sys.SysAreaDTO;
import com.correction.backend.modules.sys.service.SysAreaService;
import com.correction.backend.modules.sys.entity.SysArea;
import com.correction.backend.modules.sys.mapper.SysAreaMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.correction.backend.modules.sys.constant.SysConstant.DEFAULT_AREA_ID;
import static com.correction.backend.modules.sys.constant.SysConstant.DEFAULT_AREA_TYPE;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yao
 * @since 2022-11-16
 */
@Service
public class SysAreaServiceImpl extends ServiceImpl<SysAreaMapper, SysArea> implements SysAreaService {


    @Override
    public List<SysArea> getSysArea(SysAreaDTO dto) {
        if(dto.getAreaId() == null){
            dto.setAreaId(DEFAULT_AREA_ID);
            dto.setType(DEFAULT_AREA_TYPE);
            return Arrays.asList(baseMapper.selectById(dto.getAreaId()));
        }
        return baseMapper.selectList(Wrappers.<SysArea>lambdaQuery().eq(SysArea::getParentId,dto.getAreaId()).eq(SysArea::getLevel,dto.getType()));
    }

    @Override
    public List<AreaOutDTO> getHZArea() {
        //得到杭州区
        List<AreaOutDTO> result = new ArrayList<>();
        List<SysArea> sysAreas = baseMapper.selectList(Wrappers.<SysArea>lambdaQuery().eq(SysArea::getParentId, 921));
        sysAreas.forEach(e->{
            AreaOutDTO areaOutDTO = new AreaOutDTO();
            areaOutDTO.setAreaName(e.getAreaName());
            areaOutDTO.setParentId(e.getParentId());
            areaOutDTO.setAreaId(e.getAreaId());
            //得到子街道
            List<SysArea> sysAreaschi = baseMapper.selectList(Wrappers.<SysArea>lambdaQuery().eq(SysArea::getParentId, areaOutDTO.getAreaId()));
            List<AreaOutDTO> childen = new ArrayList<>();
            sysAreaschi.forEach(i->{
                AreaOutDTO childenDTO = new AreaOutDTO();
                childenDTO.setAreaName(i.getAreaName());
                childenDTO.setParentId(i.getParentId());
                childenDTO.setAreaId(i.getAreaId());
                childen.add(childenDTO);
            });
            areaOutDTO.setChilden(childen);
            result.add(areaOutDTO);
        });
        return result;
    }
}
