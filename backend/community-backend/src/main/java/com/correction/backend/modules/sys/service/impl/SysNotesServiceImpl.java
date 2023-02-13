package com.correction.backend.modules.sys.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.correction.backend.modules.sys.controller.dto.notes.SysNotesCreateInputDTO;
import com.correction.backend.modules.sys.convert.notes.MSysNotesConvert;
import com.correction.backend.modules.sys.service.SysNotesService;
import com.correction.framework.common.pojo.PageResult;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.correction.backend.modules.sys.entity.SysNotes;
import com.correction.backend.modules.sys.mapper.SysNotesMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.correction.framework.web.web.core.util.WebFrameworkUtils;
import org.mapstruct.ap.internal.model.assignment.UpdateWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yao
 * @since 2022-12-18
 */
@Service
public class SysNotesServiceImpl extends ServiceImpl<SysNotesMapper, SysNotes> implements SysNotesService {


    @Override
    public SysNotes createNotes(SysNotesCreateInputDTO createInputDTO) {
        SysNotes sysNotes = MSysNotesConvert.INSTANCE.toSysNotes(createInputDTO);
        sysNotes.setStatus(2);
        sysNotes.setUserId(WebFrameworkUtils.getLoginUserId());
        sysNotes.setUseDate(LocalDate.now().toString());
        baseMapper.insert(sysNotes);
        return sysNotes;
    }

    @Override
    public SysNotes updateStatus(Long id, Integer status) {
        LambdaUpdateWrapper<SysNotes> eq = Wrappers.<SysNotes>lambdaUpdate().set(SysNotes::getStatus, status).eq(SysNotes::getId, id);
        update(eq);
        return null;
    }

    @Override
    public void delete(Long id) {
        baseMapper.deleteById(id);
    }

    @Override
    public List<SysNotes> getList(Long userId, String date) {
        if(StringUtils.isNotBlank(date)){
            date = LocalDate.now().toString();
        }
        List<SysNotes> sysNotes = baseMapper.selectList(Wrappers.<SysNotes>lambdaQuery().eq(SysNotes::getUserId, userId).eq(SysNotes::getUseDate, date).eq(SysNotes::getDeleted, 0).orderByDesc(SysNotes::getStatus));
        return sysNotes;
    }
}
