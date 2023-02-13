package com.correction.backend.modules.home.service;

import com.correction.backend.modules.home.controller.dto.HomeReportDTO;
import com.correction.backend.modules.home.controller.dto.UserRunTaskDTO;
import com.correction.backend.modules.sys.controller.dto.notes.SysNotesCreateInputDTO;
import com.correction.backend.modules.sys.controller.dto.notes.SysNotesStatusUpdateDTO;
import com.correction.backend.modules.sys.entity.SysNotes;

import java.util.List;

public interface HomeService {

    /**
     * 获取用户代办信息
     */
    List<UserRunTaskDTO> getUserRunTask(Long userId);

    /**
     * 获取便签
     * @param loginUserId
     * @return
     */
    List<SysNotes> getNotes(Long loginUserId ,String  date);

    SysNotes createNotes(SysNotesCreateInputDTO createInputDTO);

    SysNotes updateStatus(SysNotesStatusUpdateDTO updateDTO);

    HomeReportDTO getReports();
}
