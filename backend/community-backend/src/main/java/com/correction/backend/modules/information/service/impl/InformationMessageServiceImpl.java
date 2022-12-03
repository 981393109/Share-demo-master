package com.correction.backend.modules.information.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.correction.backend.modules.information.constant.InformationConstant;
import com.correction.backend.modules.information.controller.dto.InformationMessageCreateInputDTO;
import com.correction.backend.modules.information.controller.dto.InformationMessageSearchInputDTO;
import com.correction.backend.modules.information.controller.dto.InformationReadDTO;
import com.correction.backend.modules.information.service.InformationMessageService;
import com.correction.backend.modules.information.entity.InformationMessage;
import com.correction.backend.modules.information.mapper.InformationMessageMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.correction.framework.common.pojo.PageResult;
import com.correction.framework.web.web.core.util.WebFrameworkUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    /**
     * 获取表格数据
     *
     * @param informationMessage
     * @return
     */
    @Override
    public PageResult<InformationMessage> pageListByEntity(InformationMessageSearchInputDTO informationMessage) {
        LambdaQueryWrapper<InformationMessage> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.like(StrUtil.isNotBlank(informationMessage.getMsgTitle()), InformationMessage::getMsgTitle, informationMessage.getMsgTitle());
        queryWrapper.like(StrUtil.isNotBlank(informationMessage.getMsgInfo()), InformationMessage::getMsgInfo, informationMessage.getMsgInfo());
        queryWrapper.like(StrUtil.isNotBlank(informationMessage.getOriginator()), InformationMessage::getOriginator, informationMessage.getOriginator());
        queryWrapper.like(StrUtil.isNotBlank(informationMessage.getTaskId()), InformationMessage::getTaskId, informationMessage.getTaskId());
        queryWrapper.like(StrUtil.isNotBlank(informationMessage.getCreator()), InformationMessage::getCreator, informationMessage.getCreator());
        queryWrapper.like(StrUtil.isNotBlank(informationMessage.getUpdater()), InformationMessage::getUpdater, informationMessage.getUpdater());
        queryWrapper.orderByAsc(InformationMessage::getStatus);
        PageResult<InformationMessage> informationMessagePageResult = baseMapper.selectPage(informationMessage, queryWrapper);
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

    }


}
