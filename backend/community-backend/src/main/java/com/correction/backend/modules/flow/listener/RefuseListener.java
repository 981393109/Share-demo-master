package com.correction.backend.modules.flow.listener;


import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.spring.SpringUtil;
import com.correction.backend.modules.flow.factory.complete.FlowComplete;
import com.correction.backend.modules.flow.factory.complete.FlowCompleteFactory;
import com.correction.backend.modules.information.constant.InformationConstant;
import com.correction.backend.modules.information.controller.dto.InformationMessageCreateInputDTO;
import com.correction.backend.modules.information.service.InformationMessageService;
import com.correction.backend.modules.sys.entity.SysUserDO;
import com.correction.backend.modules.sys.mapper.SysUserMapper;
import lombok.extern.slf4j.Slf4j;
import org.flowable.engine.TaskService;
import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.ExecutionListener;
import org.flowable.task.api.Task;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.*;

/**
 * 拒绝任务监听器
 */
@Slf4j
@Component
public class RefuseListener implements ExecutionListener {


    @Override
    public void notify(DelegateExecution execution) {
        String processInstanceBusinessKey = execution.getProcessInstanceBusinessKey();
        String[] split = processInstanceBusinessKey.split(":");
        Object completeStatus = execution.getVariable("completeStatus");
        Object progress = execution.getVariable("progress");
        Long userId = Long.valueOf(String.valueOf(execution.getVariable("userId")));
        Long nextAssignee =  Long.valueOf(String.valueOf(execution.getVariable("nextAssignee")));
        String flowStartTime = String.valueOf(execution.getVariable("flowStartTime"));
        FlowComplete byFlowType = FlowCompleteFactory.getByFlowType(split[0]);
        byFlowType.doEnd(split[1],split[2],String.valueOf(progress),String.valueOf(completeStatus));
        //todo 发送消息给申请人
        InformationMessageService bean = SpringUtil.getBean(InformationMessageService.class);
        SysUserMapper userMapper = SpringUtil.getBean(SysUserMapper.class);
        SysUserDO userDO = userMapper.selectById(userId);
        SysUserDO sendUser = userMapper.selectById(nextAssignee);
        bean.sendMsg(InformationMessageCreateInputDTO.builder()
                .userId(userId)
                .dataId(Long.parseLong(split[1]))
                .dataType(split[0])
                .originatorId(nextAssignee)
                .originator(sendUser.getUserName())
                .msgType(InformationConstant.FLOW)
                .status(InformationConstant.UN_READ)
                .msgTitle(userDO.getUserName()+ "在"+ flowStartTime + InformationConstant.flowTitle.get(split[0]))
                .msgInfo(sendUser.getUserName()+"拒绝了审批！")
                .createTime(new Date())
                .build());
    }


}
