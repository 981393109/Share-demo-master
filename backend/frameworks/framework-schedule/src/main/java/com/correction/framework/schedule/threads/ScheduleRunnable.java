package com.correction.framework.schedule.threads;

import cn.hutool.extra.spring.SpringUtil;
import com.correction.framework.schedule.service.ScheduleService;
import com.correction.framework.schedule.entity.ScheduledTaskInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;

import java.time.LocalDateTime;

/**
 * hxj、
 */
public  abstract class ScheduleRunnable implements Runnable{


    private static final Logger log = LoggerFactory.getLogger(ScheduleRunnable.class);

    private ScheduledTaskInstance scheduledTaskInstance;

    public ScheduleRunnable(ScheduledTaskInstance scheduledTaskInstance){
        this.scheduledTaskInstance = scheduledTaskInstance;
    }

    @Override
    public void run() {
        //定义计时器：
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        try {
            //处理任务：
            execute();
            ScheduleService bean =  SpringUtil.getBean(ScheduleService.class);
            bean.updateLastRunningTime(this.scheduledTaskInstance.getId(), LocalDateTime.now());
            stopWatch.stop();
            log.info("schedule ["+scheduledTaskInstance.getName()+"]  ending ,runningTime: ["+stopWatch.getLastTaskTimeMillis()+"]");
        } catch (Exception e){
            log.info("定时任务启动失败！ "+e.getMessage());
            e.printStackTrace();
        }
    }

    public abstract void execute();

}
