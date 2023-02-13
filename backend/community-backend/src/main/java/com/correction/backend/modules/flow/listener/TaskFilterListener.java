package com.correction.backend.modules.flow.listener;

import cn.hutool.extra.spring.SpringUtil;
import com.correction.backend.modules.information.constant.InformationConstant;
import com.correction.backend.modules.information.controller.dto.InformationMessageCreateInputDTO;
import com.correction.backend.modules.information.service.InformationMessageService;
import com.correction.backend.modules.sys.entity.SysUserDO;
import com.correction.backend.modules.sys.mapper.SysUserMapper;
import com.correction.framework.common.util.date.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.task.service.delegate.DelegateTask;
import org.flowable.task.service.delegate.TaskListener;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * 任务监听，判断流程节点是单人通过还是多人通过
 */
@Slf4j
public class TaskFilterListener implements TaskListener {


    @Override
    public void notify(DelegateTask delegateTask) {
        Long userId = Long.valueOf(String.valueOf(delegateTask.getVariable("userId")));
        Object businessKey = delegateTask.getVariable("businessKey");
        Object nextAssignee = delegateTask.getVariable("nextAssignee");
        Object flowStartTime = delegateTask.getVariable("flowStartTime");
        delegateTask.setVariable("nextAssignee", delegateTask.getAssignee());
        System.out.println("得到下一执行人："+delegateTask.getAssignee());
        log.info("nextAssignee",delegateTask.getAssignee());
        // TODO 发送消息
        InformationMessageService bean = SpringUtil.getBean(InformationMessageService.class);
        SysUserMapper userMapper = SpringUtil.getBean(SysUserMapper.class);
        SysUserDO userDO = userMapper.selectById(userId);
        String[] split = String.valueOf(businessKey).split(":");
        if(nextAssignee!=null){
            SysUserDO sender = userMapper.selectById(Long.valueOf(String.valueOf(nextAssignee)));
            bean.sendMsg(InformationMessageCreateInputDTO.builder()
                    .userId(Long.parseLong(delegateTask.getAssignee()))
                    .taskId(delegateTask.getId())
                    .dataId(Long.parseLong(split[1]))
                    .dataType(split[0])
                    .originatorId(sender.getId())
                    .originator(sender.getUserName())
                    .msgType(InformationConstant.FLOW)
                    .status(InformationConstant.UN_READ)
                    .msgTitle(userDO.getUserName() + "在" + flowStartTime + InformationConstant.flowTitle.get(split[0]))
                    .msgInfo("当前节点：" + delegateTask.getName() + ", 需您进行审批！")
                    .createTime(new Date())
                    .build());
        } else {
            bean.sendMsg(InformationMessageCreateInputDTO.builder()
                    .userId(Long.parseLong(delegateTask.getAssignee()))
                    .taskId(delegateTask.getId())
                    .dataId(Long.parseLong(split[1]))
                    .dataType(split[0])
                    .originatorId(userId)
                    .originator(userDO.getUserName())
                    .msgType(InformationConstant.FLOW)
                    .status(InformationConstant.UN_READ)
                    .msgTitle(userDO.getUserName() + "在" + flowStartTime + InformationConstant.flowTitle.get(split[0]))
                    .msgInfo("当前节点：" + delegateTask.getName() + ", 需您进行审批！")
                    .createTime(new Date())
                    .build());
        }

    }

}
