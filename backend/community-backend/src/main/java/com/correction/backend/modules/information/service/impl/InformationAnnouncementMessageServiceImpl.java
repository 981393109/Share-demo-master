package com.correction.backend.modules.information.service.impl;


import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.correction.backend.modules.information.constant.InformationConstant;
import com.correction.backend.modules.information.controller.dto.InformationAnnouncementMessageDTO;
import com.correction.backend.modules.information.controller.dto.InformationAnnouncementMessageSearchInputDTO;
import com.correction.backend.modules.information.controller.dto.InformationMessageSearchInputDTO;
import com.correction.backend.modules.information.convert.MInformationAnnouncementMessageConvert;
import com.correction.backend.modules.information.entity.InformationMessage;
import com.correction.backend.modules.information.service.InformationAnnouncementMessageService;
import com.correction.backend.modules.information.entity.InformationAnnouncementMessage;
import com.correction.backend.modules.information.mapper.InformationAnnouncementMessageMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.correction.framework.common.pojo.PageResult;
import com.correction.framework.web.web.core.util.WebFrameworkUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 公告信息 服务实现类
 * </p>
 *
 * @author yao
 * @since 2022-12-04
 */
@Service
public class InformationAnnouncementMessageServiceImpl extends ServiceImpl<InformationAnnouncementMessageMapper, InformationAnnouncementMessage> implements InformationAnnouncementMessageService {


    @Override
    public InformationAnnouncementMessage createAnnouncement(InformationAnnouncementMessageDTO informationAnnouncementMessageDTO) {
        InformationAnnouncementMessage informationAnnouncementMessage = MInformationAnnouncementMessageConvert.INSTANCE.toEntity(informationAnnouncementMessageDTO);
        baseMapper.insert(informationAnnouncementMessage);
        return  informationAnnouncementMessage;
    }

    @Override
    public List<InformationAnnouncementMessage> getEnableAnnouncementMessage() {
       return  baseMapper.selectList(Wrappers.<InformationAnnouncementMessage>lambdaQuery().eq(InformationAnnouncementMessage::getStatus, InformationConstant.ENABLE));
    }

    @Override
    public PageResult<InformationAnnouncementMessage> pageListByEntity(InformationAnnouncementMessageSearchInputDTO informationMessage) {
        LambdaQueryWrapper<InformationAnnouncementMessage> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.like(StrUtil.isNotBlank(informationMessage.getMsgTitle()), InformationAnnouncementMessage::getMsgTitle, informationMessage.getMsgTitle());
        queryWrapper.like(StrUtil.isNotBlank(informationMessage.getMsgInfo()), InformationAnnouncementMessage::getMsgInfo, informationMessage.getMsgInfo());
        queryWrapper.like(StrUtil.isNotBlank(informationMessage.getOriginator()), InformationAnnouncementMessage::getOriginator, informationMessage.getOriginator());
        queryWrapper.like(StrUtil.isNotBlank(informationMessage.getCreator()), InformationAnnouncementMessage::getCreator, informationMessage.getCreator());
        queryWrapper.like(StrUtil.isNotBlank(informationMessage.getUpdater()), InformationAnnouncementMessage::getUpdater, informationMessage.getUpdater());
        queryWrapper.ge(StrUtil.isNotBlank(informationMessage.getStartDate()),InformationAnnouncementMessage::getCreateTime,informationMessage.getStartDate());
        queryWrapper.le(StrUtil.isNotBlank(informationMessage.getEndDate()),InformationAnnouncementMessage::getCreateTime,informationMessage.getEndDate());
        queryWrapper.orderByAsc(InformationAnnouncementMessage::getStatus);
        PageResult<InformationAnnouncementMessage> informationMessagePageResult = baseMapper.selectPage(informationMessage, queryWrapper);
        return informationMessagePageResult;
    }


}
