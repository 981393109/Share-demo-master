package com.correction.backend.modules.schedule;

import cn.hutool.extra.spring.SpringUtil;
import com.correction.backend.modules.termination.service.TerminationSolutionsService;
import com.correction.framework.schedule.entity.ScheduledTaskInstance;
import com.correction.framework.schedule.threads.ScheduleRunnable;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;

/**
 * 矫正人员预定解矫日期前30天自动生成一条【待审核】的期满解矫流程（待提交，只不过此时的流程进度名称为待审核，详情看这个图里面的流程进度）
 */
@Slf4j
public class TerminationScheduleTask extends ScheduleRunnable {

    public TerminationScheduleTask(ScheduledTaskInstance scheduledTaskInstance) {
        super(scheduledTaskInstance);
    }


    @Override
    public void execute() {
        try {
            log.info("*******************开始生成解矫记录*****************");
            TerminationSolutionsService bean = SpringUtil.getBean(TerminationSolutionsService.class);
            bean.autoCreateTerminationRecord();
        } catch (Exception e ){
            e.printStackTrace();
            log.info("生成解矫记录失败！"+e      );
        }
    }


}
