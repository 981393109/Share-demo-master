package com.correction.backend.modules.flow.listener;

import cn.hutool.extra.spring.SpringUtil;
import com.correction.backend.modules.information.constant.InformationConstant;
import com.correction.backend.modules.information.controller.dto.InformationMessageCreateInputDTO;
import com.correction.backend.modules.information.service.InformationMessageService;
import com.correction.backend.modules.sys.entity.SysUserDO;
import com.correction.backend.modules.sys.mapper.SysUserMapper;
import lombok.extern.slf4j.Slf4j;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.task.service.delegate.DelegateTask;
import org.flowable.task.service.delegate.TaskListener;

import java.time.LocalDateTime;

/**
 * 任务监听，判断流程节点是单人通过还是多人通过
 */
@Slf4j
public class TaskFilterListener implements TaskListener {


    @Override
    public void notify(DelegateTask delegateTask) {
        Long userId = Long.valueOf(String.valueOf(delegateTask.getVariable("userId")));
        Object businessKey = delegateTask.getVariable("businessKey");
        Object flowStartTime = delegateTask.getVariable("flowStartTime");
        delegateTask.setVariable("nextAssignee", delegateTask.getAssignee());
        // TODO 发送消息
        InformationMessageService bean = SpringUtil.getBean(InformationMessageService.class);
        SysUserMapper userMapper = SpringUtil.getBean(SysUserMapper.class);
        SysUserDO userDO = userMapper.selectById(userId);
        String[] split = String.valueOf(businessKey).split(":");
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
                .build());
    }


}
