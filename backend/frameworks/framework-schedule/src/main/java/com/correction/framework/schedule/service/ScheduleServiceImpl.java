package com.correction.framework.schedule.service;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.correction.framework.schedule.entity.ScheduledTaskInstance;
import com.correction.framework.schedule.mapper.ScheduleMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class ScheduleServiceImpl extends ServiceImpl<ScheduleMapper, ScheduledTaskInstance> implements ScheduleService {


    @Override
    public void updateLastRunningTime(Long id, LocalDateTime time) {
        update(Wrappers.<ScheduledTaskInstance>lambdaUpdate().set(ScheduledTaskInstance::getLastTime,time).eq(ScheduledTaskInstance::getId,id));
    }

    @Override
    public ScheduledTaskInstance findById(Long id) {
        ScheduledTaskInstance byId = (ScheduledTaskInstance) getById( id);
        return byId;
    }

    @Override
    public void delById(Long id) {
        removeById(id);
    }

    @Override
    public void updateTask(ScheduledTaskInstance scheduledTaskInstance) {
        scheduledTaskInstance.setUpdateTime(new Date());
        updateById(scheduledTaskInstance);
    }

    @Override
    public void addTask(ScheduledTaskInstance scheduledTaskInstance) {
        scheduledTaskInstance.setCreateTime(new Date());
        save(scheduledTaskInstance);
    }

    @Override
    public List<ScheduledTaskInstance> getList(String status) {
        return list(Wrappers.<ScheduledTaskInstance>lambdaQuery().eq(StringUtils.isNotBlank(status),ScheduledTaskInstance::getStatus,status));
    }


}
