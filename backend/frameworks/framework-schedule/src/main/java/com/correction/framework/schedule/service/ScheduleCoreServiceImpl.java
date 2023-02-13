package com.correction.framework.schedule.service;

import com.correction.framework.schedule.entity.ScheduledTaskInstance;
import com.correction.framework.schedule.threads.ScheduleRunnable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.Constructor;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadPoolExecutor;

@Service
public class ScheduleCoreServiceImpl implements ScheduleCoreService {

    @Autowired
    private ScheduleService scheduleService;

    private static final Logger log = LoggerFactory.getLogger(ScheduleCoreServiceImpl.class);

    private ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();

    public ConcurrentHashMap<Long, ScheduledFuture<?>> runningTaskMap = new ConcurrentHashMap<>();

    public ScheduleCoreServiceImpl() {
        threadPoolTaskScheduler.setThreadNamePrefix("SODEXO-");
        threadPoolTaskScheduler.setPoolSize(50);
        threadPoolTaskScheduler.setAwaitTerminationSeconds(120);
        threadPoolTaskScheduler.setWaitForTasksToCompleteOnShutdown(true);
        //追加拒绝策略
        threadPoolTaskScheduler.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        threadPoolTaskScheduler.initialize();
    }


    @Override
    public void startTask(Long id) {
        ScheduledFuture<?> scheduledFuture = runningTaskMap.get(id);
        ScheduledTaskInstance scheduledTaskInstance = scheduleService.findById(id);
        scheduledTaskInstance.setStatus("0");
        scheduleService.updateTask(scheduledTaskInstance);
        if(scheduledFuture!=null){
            log.info("taskId : "+id+" is running ");
        } else {
            //启动任务：
            ScheduledFuture<?> schedule = threadPoolTaskScheduler.schedule(getScheduleInstance(scheduledTaskInstance)
                    , new CronTrigger(scheduledTaskInstance.getCron()));
            runningTaskMap.put(scheduledTaskInstance.getId(),schedule);
        }
    }

    @Override
    public void stopTask(Long id) {
        ScheduledFuture<?> scheduledFuture = runningTaskMap.get(id);
        ScheduledTaskInstance scheduledTaskInstance = scheduleService.findById(id);
        scheduledTaskInstance.setStatus("1");
        scheduleService.updateTask(scheduledTaskInstance);
        if(scheduledFuture!=null){
            scheduledFuture.cancel(true);
            runningTaskMap.remove(id);
            log.info("taskId "+id+" is stop success");
        } else {
            log.info("taskId : "+id+" is not running ");
        }
    }

    @Override
    public void delTask(Long id) {
        stopTask(id);
        scheduleService.delById(id);
    }

    @Override
    public void updateTask(ScheduledTaskInstance scheduledTaskInstance) {
        scheduleService.updateTask(scheduledTaskInstance);
        ScheduledFuture<?> scheduledFuture = runningTaskMap.get(scheduledTaskInstance.getId());
        if(scheduledFuture!=null){
            //停止后启动
            stopTask(scheduledTaskInstance.getId());
        } else{
            log.info(" task not runing ");
        }
        if("0".equals(scheduledTaskInstance.getStatus())){
            startTask(scheduledTaskInstance.getId());
        }
    }

    @Override
    public void addTask(ScheduledTaskInstance scheduledTaskInstance) {
        scheduleService.addTask(scheduledTaskInstance);
        if("0".equals(scheduledTaskInstance.getStatus())){
            startTask(scheduledTaskInstance.getId());
        }
    }

    @Override
    public void initTask() {
        List<ScheduledTaskInstance> list = scheduleService.getList("0");
        if(!CollectionUtils.isEmpty(list)){
            for (ScheduledTaskInstance scheduledTaskInstance : list) {
                stopTask(scheduledTaskInstance.getId());
                startTask(scheduledTaskInstance.getId());
                log.info(scheduledTaskInstance.getName()+" is start ");
            }
        }
    }

    public static ScheduleRunnable getScheduleInstance (ScheduledTaskInstance scheduledTaskInstance){
        ScheduleRunnable scheduleRunnable = null;
        try {
            Class<?> clazz = Class.forName(scheduledTaskInstance.getImplementation());
            Constructor<?> constructor = clazz.getConstructor(ScheduledTaskInstance.class);
            scheduleRunnable = (ScheduleRunnable) constructor.newInstance(scheduledTaskInstance);
        } catch (Exception e){
            log.info("获取ScheduleRunable 失败！");
        }
        return scheduleRunnable;
    }
}
