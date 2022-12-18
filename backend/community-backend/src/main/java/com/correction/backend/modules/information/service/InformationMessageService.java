package com.correction.backend.modules.information.service;

import com.correction.backend.modules.information.controller.dto.*;
import com.correction.backend.modules.information.entity.InformationMessage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.correction.framework.common.pojo.PageResult;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yao
 * @since 2022-11-27
 */
public interface InformationMessageService extends IService<InformationMessage> {

    /**
     * 分页获取列表数据
     * @param informationMessage
     * @return
     */
    PageResult<InformationMessage> pageListByEntity(InformationMessageSearchInputDTO informationMessage);

    /**
     * 已读/未读
     */
    void doRead (InformationReadDTO dto);

    /**
     * 一键已读
     */
    void doRead (Long userId);

    /**
     * 获取未读消息数量
     */
    Integer getUnReadCount (Long userId);

    /**
     * 创建消息
     */
    InformationMessage createInformation (InformationMessage message);

    /**
     * 推送消息
     */
    void sendMsg (InformationMessageCreateInputDTO reqDto);

    /**
     * 发送公告消息
     * @param reqDTO
     */
    void sendAnnouncement(InformationAnnouncementMessageDTO reqDTO);

    void setEnable(InformationAnnouncementMessageDTO reqDTO);

    void delete (Long id);

    void initUserInfoMessage(Long id);
}
