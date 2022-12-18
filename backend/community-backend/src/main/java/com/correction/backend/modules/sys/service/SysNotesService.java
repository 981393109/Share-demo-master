package com.correction.backend.modules.sys.service;

import com.correction.backend.modules.sys.controller.dto.notes.SysNotesCreateInputDTO;
import com.correction.backend.modules.sys.entity.SysNotes;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yao
 * @since 2022-12-18
 */
public interface SysNotesService extends IService<SysNotes> {

    /**
     * 新增
     */
    SysNotes createNotes (SysNotesCreateInputDTO createInputDTO);

    /**
     * 修改状态
     */
    SysNotes updateStatus (Long id ,Integer status);

    /**
     * 删除
     */
    void delete(Long id );

    /**
     * 获取列表
     */
    List<SysNotes> getList (Long userId,String date);

}
