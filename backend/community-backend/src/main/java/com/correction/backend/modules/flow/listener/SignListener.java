package com.correction.backend.modules.flow.listener;

import cn.hutool.extra.spring.SpringUtil;
import com.correction.backend.modules.flow.constant.FlowConstant;
import com.correction.backend.modules.flow.entity.FlowCenter;
import com.correction.backend.modules.flow.factory.complete.FlowComplete;
import com.correction.backend.modules.flow.factory.complete.FlowCompleteFactory;
import com.correction.backend.modules.flow.service.FlowCenterService;
import com.correction.backend.modules.information.constant.InformationConstant;
import com.correction.backend.modules.information.controller.dto.InformationMessageCreateInputDTO;
import com.correction.backend.modules.information.service.InformationMessageService;
import com.correction.backend.modules.sys.entity.SysUserDO;
import com.correction.backend.modules.sys.mapper.SysUserMapper;
import com.correction.framework.workflow.constant.WorkFlowConstant;
import lombok.extern.slf4j.Slf4j;
import org.flowable.engine.TaskService;
import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.ExecutionListener;
import org.flowable.task.api.Task;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 会签监听器 流程任务分发
 */
@Slf4j
public class SignListener implements ExecutionListener {


    @Override
    public void notify(DelegateExecution delegateExecution) {
        log.info("进入SignListener");
        String processInstanceBusinessKey = delegateExecution.getProcessInstanceBusinessKey();
        String currentActivityId = delegateExecution.getCurrentActivityId();
        FlowCenterService flowCenterService = SpringUtil.getBean(FlowCenterService.class);
        Object completeStatus = delegateExecution.getVariable("completeStatus");
        Object progress = delegateExecution.getVariable("progress");
        String documentation = delegateExecution.getCurrentFlowElement().getDocumentation();
        log.info("documentation:"+documentation);
        //如果包含驳回标识
        FlowCenter flowCenter = null;
        List<String> userIdList = null;
        if(currentActivityId.contains(WorkFlowConstant.TASK_REJECTED)) {
            //驳回
            flowCenter = flowCenterService.getFlowRejectedFlowCenter(documentation);
            userIdList = flowCenterService.getUserIdListByFlow(processInstanceBusinessKey,flowCenter);
        } else {
            //正常流程：
            flowCenter =  flowCenterService.getFlowCenterByActivityId(currentActivityId);
            userIdList = flowCenterService.getUserIdListByFlow(currentActivityId, processInstanceBusinessKey,flowCenter);
        }
        //根据activityId 得到关联节点信息
        delegateExecution.setVariable("assigneeList",userIdList);
        delegateExecution.setVariable("totalCount",userIdList.size());
        //将通过人数，未通过人数，总数，重新置为0，退回的时候才能重新计算
        delegateExecution.setVariable("passCount", "0");
        delegateExecution.setVariable("refusedCount", "0");
        delegateExecution.setVariable("rejectedCount", "0");
        String [] split = processInstanceBusinessKey.split(":");
        FlowComplete byFlowType = FlowCompleteFactory.getByFlowType(split[0]);
        byFlowType.doUpdateData(split[1],split[2],String.valueOf(progress),completeStatus==null?"success":String.valueOf(completeStatus));
        Object nextAssigneeObj = delegateExecution.getVariable("nextAssignee");
        Long userId = Long.valueOf(String.valueOf(delegateExecution.getVariable("userId")));
        String flowStartTime = String.valueOf(delegateExecution.getVariable("flowStartTime"));
        // todo 通过推送消息
        if(nextAssigneeObj != null ){
            Long nextAssignee = Long.parseLong(String.valueOf(nextAssigneeObj));
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
                    .msgInfo(sendUser.getUserName()+"同意通过！")
                    .build());
        }
    }


}
