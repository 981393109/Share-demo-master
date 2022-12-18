package com.correction.backend.modules.information.service;

import com.correction.backend.modules.information.controller.dto.InformationAnnouncementMessageDTO;
import com.correction.backend.modules.information.controller.dto.InformationAnnouncementMessageSearchInputDTO;
import com.correction.backend.modules.information.controller.dto.InformationMessageSearchInputDTO;
import com.correction.backend.modules.information.entity.InformationAnnouncementMessage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.correction.framework.common.pojo.PageResult;

import java.util.List;

/**
 * <p>
 * 公告信息 服务类
 * </p>
 *
 * @author yao
 * @since 2022-12-04
 */
public interface InformationAnnouncementMessageService extends IService<InformationAnnouncementMessage> {


    InformationAnnouncementMessage createAnnouncement (InformationAnnouncementMessageDTO informationAnnouncementMessageDTO);

    List<InformationAnnouncementMessage> getEnableAnnouncementMessage ();

    PageResult<InformationAnnouncementMessage> pageListByEntity(InformationAnnouncementMessageSearchInputDTO reqVO);
}
