package com.correction.framework.schedule.service;

import com.correction.framework.schedule.entity.ScheduledTaskInstance;

import java.time.LocalDateTime;
import java.util.List;

public interface ScheduleService {

    //修改最后执行时间
    void updateLastRunningTime(Long id, LocalDateTime time);

    //得到详情：
    ScheduledTaskInstance findById(Long id);

    //删除
    void delById(Long id);

    void updateTask(ScheduledTaskInstance scheduledTaskInstance);
    void addTask(ScheduledTaskInstance scheduledTaskInstance);

    //获取任务列表
    List<ScheduledTaskInstance> getList (String status);




}
