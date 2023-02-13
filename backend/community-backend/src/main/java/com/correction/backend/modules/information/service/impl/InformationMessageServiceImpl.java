package com.correction.backend.modules.information.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.correction.backend.modules.information.constant.InformationConstant;
import com.correction.backend.modules.information.controller.dto.*;
import com.correction.backend.modules.information.convert.MInformationMessageConvert;
import com.correction.backend.modules.information.entity.InformationAnnouncementMessage;
import com.correction.backend.modules.information.service.InformationAnnouncementMessageService;
import com.correction.backend.modules.information.service.InformationMessageService;
import com.correction.backend.modules.information.entity.InformationMessage;
import com.correction.backend.modules.information.mapper.InformationMessageMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.correction.backend.modules.sys.entity.SysUserDO;
import com.correction.backend.modules.sys.mapper.SysUserMapper;
import com.correction.framework.common.pojo.PageResult;
import com.correction.framework.web.web.core.util.WebFrameworkUtils;
import liquibase.pro.packaged.I;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yao
 * @since 2022-11-27
 */
@Service
public class InformationMessageServiceImpl extends ServiceImpl<InformationMessageMapper, InformationMessage> implements InformationMessageService {

    @Resource
    private InformationAnnouncementMessageService informationAnnouncementMessageService;

    @Resource
    private SysUserMapper sysUserMapper;

    /**
     * 获取表格数据
     * @param informationMessage
     * @return
     */
    @Override
    public PageResult<InformationMessage> pageListByEntity(InformationMessageSearchInputDTO informationMessage) {
        informationMessage.setUserId(WebFrameworkUtils.getLoginUserId());
        LambdaQueryWrapper<InformationMessage> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.like(StrUtil.isNotBlank(informationMessage.getMsgTitle()), InformationMessage::getMsgTitle, informationMessage.getMsgTitle());
        queryWrapper.like(StrUtil.isNotBlank(informationMessage.getMsgInfo()), InformationMessage::getMsgInfo, informationMessage.getMsgInfo());
        queryWrapper.like(StrUtil.isNotBlank(informationMessage.getOriginator()), InformationMessage::getOriginator, informationMessage.getOriginator());
        queryWrapper.like(StrUtil.isNotBlank(informationMessage.getTaskId()), InformationMessage::getTaskId, informationMessage.getTaskId());
        queryWrapper.like(StrUtil.isNotBlank(informationMessage.getCreator()), InformationMessage::getCreator, informationMessage.getCreator());
        queryWrapper.like(StrUtil.isNotBlank(informationMessage.getUpdater()), InformationMessage::getUpdater, informationMessage.getUpdater());
        queryWrapper.eq(informationMessage.getUserId()!=null,InformationMessage::getUserId,informationMessage.getUserId());
        queryWrapper.orderByAsc(InformationMessage::getStatus).orderByDesc(InformationMessage::getCreateTime);
        PageResult<InformationMessage> informationMessagePageResult = baseMapper.selectPage(informationMessage, queryWrapper);
        List<InformationMessage> list = informationMessagePageResult.getList();
        if(!CollectionUtils.isEmpty(list)) {
            list.forEach(e->{
                Long userId = e.getUserId();
                e.setUserName(sysUserMapper.selectById(userId).getUserName());
            });
        }
        return informationMessagePageResult;
    }

    @Override
    public void doRead(InformationReadDTO dto) {
        List<Long> ids = dto.getIds();
        List<InformationMessage> informationMessages = baseMapper.selectList(Wrappers.<InformationMessage>lambdaQuery().in(InformationMessage::getId, ids));
        for (InformationMessage informationMessage : informationMessages) {
            informationMessage.setStatus(dto.getStatus());
            baseMapper.updateById(informationMessage);
        }
    }

    @Override
    public void doRead(Long userId) {
        LambdaUpdateWrapper<InformationMessage> updateWrapper = Wrappers.<InformationMessage>lambdaUpdate().eq(InformationMessage::getUserId, userId).set(InformationMessage::getStatus, InformationConstant.READ);
        update(updateWrapper);
    }

    @Override
    public Integer getUnReadCount(Long userId) {
        LambdaQueryWrapper<InformationMessage> queryWrapper = Wrappers.<InformationMessage>lambdaQuery().eq(InformationMessage::getUserId,userId).eq(InformationMessage::getStatus, InformationConstant.UN_READ);
        List<InformationMessage> informationMessages = baseMapper.selectList(queryWrapper);
        return informationMessages.size();
    }

    @Override
    public InformationMessage createInformation(InformationMessage message) {
        baseMapper.insert(message);
        return message;
    }

    @Override
    public void sendMsg(InformationMessageCreateInputDTO reqDto) {
        InformationMessage informationMessage = MInformationMessageConvert.INSTANCE.toInformationMessage(reqDto);
        baseMapper.insert(informationMessage);
    }

    @Override
    public void sendAnnouncement(InformationAnnouncementMessageDTO reqDTO) {
        InformationAnnouncementMessage announcement = informationAnnouncementMessageService.createAnnouncement(reqDTO);
        //给用户发送公共消息：
        List<SysUserDO> sysUserDOS = sysUserMapper.selectList();
        for (SysUserDO sysUserDO : sysUserDOS) {
            InformationMessage informationMessage = new InformationMessage();
            informationMessage.setStatus(InformationConstant.UN_READ);
            informationMessage.setMsgInfo(reqDTO.getMsgInfo());
            informationMessage.setMsgType(InformationConstant.INFO);
            informationMessage.setUserId(sysUserDO.getId());
            informationMessage.setMsgTitle(reqDTO.getMsgTitle());
            informationMessage.setDataId(announcement.getId());
            informationMessage.setOriginator(reqDTO.getOriginator());
            informationMessage.setOriginatorId(reqDTO.getOriginatorId());
            save(informationMessage);
        }
    }

    @Override
    public void setEnable(InformationAnnouncementMessageDTO reqDTO) {
        InformationAnnouncementMessage byId = informationAnnouncementMessageService.getById(reqDTO.getId());
        byId.setStatus(reqDTO.getStatus());
        informationAnnouncementMessageService.updateById(byId);
    }

    @Override
    public void delete(Long id) {
        InformationAnnouncementMessage byId = informationAnnouncementMessageService.getById(id);
        informationAnnouncementMessageService.removeById(byId);
    }

    @Override
    public void initUserInfoMessage(Long id) {
        //得到所有启动的公告
        List<InformationAnnouncementMessage> list = informationAnnouncementMessageService
                .list(Wrappers.<InformationAnnouncementMessage>lambdaQuery()
                        .eq(InformationAnnouncementMessage::getStatus, InformationConstant.ENABLE));
        for (InformationAnnouncementMessage informationAnnouncementMessage : list) {
            //判断用户是否存在该公告
            List<InformationMessage> informationMessages = baseMapper.selectList(Wrappers.<InformationMessage>lambdaQuery().eq(InformationMessage::getUserId, id)
                    .eq(InformationMessage::getMsgType, InformationConstant.INFO)
                    .eq(InformationMessage::getDataId, informationAnnouncementMessage.getId()));
            if(CollectionUtils.isEmpty(informationMessages)){
                InformationMessage informationMessage = new InformationMessage();
                informationMessage.setStatus(InformationConstant.UN_READ);
                informationMessage.setMsgInfo(informationAnnouncementMessage.getMsgInfo());
                informationMessage.setMsgType(InformationConstant.INFO);
                informationMessage.setUserId(informationAnnouncementMessage.getId());
                informationMessage.setMsgTitle(informationAnnouncementMessage.getMsgTitle());
                informationMessage.setDataId(informationAnnouncementMessage.getId());
                informationMessage.setOriginator(informationAnnouncementMessage.getOriginator());
                informationMessage.setOriginatorId(informationAnnouncementMessage.getOriginatorId());
                save(informationMessage);
            }
        }
    }


}
