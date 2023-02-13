package com.correction.framework.schedule.service;


import com.correction.framework.schedule.entity.ScheduledTaskInstance;

/**
 * 定时任务核心类
 */
public interface ScheduleCoreService {

    /**
     * 启动任务
     */
    void startTask(Long id) throws Exception;

    /**
     * 关闭任务
     */
    void stopTask(Long Long);


    /**
     * 删除任务
     */
    void delTask(Long Long);


    /**
     * 修改任务
     */
    void updateTask(ScheduledTaskInstance scheduledTaskInstance);

    /**
     * 新增任务
     */
    void addTask(ScheduledTaskInstance scheduledTaskInstance);


    /**
     * 初始化任务
     */
    void initTask();


}
