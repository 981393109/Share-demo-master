package com.correction.backend.modules.flow.utils;

import cn.hutool.core.util.StrUtil;
import com.correction.backend.modules.flow.constant.FlowConstant;
import org.flowable.bpmn.model.*;

import java.util.List;

/**
 * 动态生产流程节点工具类
 */
public class FlowNodeUtils {

    /**
     * 设置启动流程
     * @param name
     * @return
     */
    public static StartEvent startEventNode(String name,Integer index){
        StartEvent startEvent = new StartEvent();
        startEvent.setId(formateId(FlowConstant.FLOW_NODE_START,index));
        startEvent.setName(name);
        return startEvent;
    }

    /**
     * 创建用户任务
     */
    public static UserTask userTaskNode (String type,String name,Integer index) {
        UserTask userTask = new UserTask();
        userTask.setId(formateId(type,FlowConstant.FLOW_NODE_USER,index));
        userTask.setName(name);
        userTask.setExclusive(true);
        return userTask;
    }


    /**
     * 创建用户任务，配置监听器
     */
    public static UserTask userTaskNode (String type,String name, Integer index, Boolean sequential, String completionCondition, String assignee, List<FlowableListener> taskListeners, List<FlowableListener> executionListeners){
        UserTask userTask = userTaskNode(type,name, index);
        if(!sequential){
            MultiInstanceLoopCharacteristics  multiInstanceLoopCharacteristics = new MultiInstanceLoopCharacteristics();
            //审批人集合参数
            multiInstanceLoopCharacteristics.setInputDataItem(FlowConstant.ASSIGNEELIST);
            //迭代集合
            multiInstanceLoopCharacteristics.setElementVariable(FlowConstant.ASSIGNEE);
            //完成条件 已完成数等于实例数
            multiInstanceLoopCharacteristics.setCompletionCondition(completionCondition);
            //并行
            multiInstanceLoopCharacteristics.setSequential(sequential);
            userTask.setLoopCharacteristics(multiInstanceLoopCharacteristics);
        }
        userTask.setAssignee(assignee);
        userTask.setTaskListeners(taskListeners);
        userTask.setExecutionListeners(executionListeners);
        return userTask;
    }




    /**
     * 创建网关:
     */
    public static ExclusiveGateway exclusiveGatewayNode(String name,Integer index){
        ExclusiveGateway exclusiveGateway = new ExclusiveGateway();
        exclusiveGateway.setName(name);
        exclusiveGateway.setId(formateId(FlowConstant.FLOW_NODE_GATEWAY,index));
        return exclusiveGateway;
    }

    /**
     * 节点之间的连接线
     */
    public static SequenceFlow connectSequenceFlow(String name, Integer index, String sourceRef, String targetRef, String conditionExpression, List<FlowableListener> executionListeners){
        SequenceFlow sequenceFlow = connectSequenceFlow(name, index);
        sequenceFlow.setSourceRef(sourceRef);
        sequenceFlow.setTargetRef(targetRef);
        sequenceFlow.setConditionExpression(conditionExpression);
        sequenceFlow.setExecutionListeners(executionListeners);
        return sequenceFlow;
    }

    public static SequenceFlow connectSequenceFlow(String name, Integer index){
        SequenceFlow sequenceFlow = new SequenceFlow();
        sequenceFlow.setName(name);
        sequenceFlow.setId(formateId(FlowConstant.FLOW_LINE,index));
        return sequenceFlow;
    }

    public static SequenceFlow connectSequenceFlow(String name, Integer parentIndex, Integer index){
        SequenceFlow sequenceFlow = new SequenceFlow();
        sequenceFlow.setName(name);
        sequenceFlow.setId(formateId(FlowConstant.FLOW_LINE,parentIndex,index));
        return sequenceFlow;
    }

    public static SequenceFlow connectSequenceFlow(String type,String name, Integer parentIndex, Integer index){
        SequenceFlow sequenceFlow = new SequenceFlow();
        sequenceFlow.setName(name);
        sequenceFlow.setId(formateId(type,FlowConstant.FLOW_LINE,parentIndex,index));
        return sequenceFlow;
    }

    public static void connectSequenceFlow(SequenceFlow sequenceFlow ,String sourceRef, String targetRef, String conditionExpression, List<FlowableListener> executionListeners){
        sequenceFlow.setSourceRef(sourceRef);
        sequenceFlow.setTargetRef(targetRef);
        sequenceFlow.setConditionExpression(conditionExpression);
        sequenceFlow.setExecutionListeners(executionListeners);
    }

    /**
     * init executionListeners or taskListeners
     */
    public static FlowableListener initFlowableListener(String event,String implementation){
        FlowableListener flowableListener = new FlowableListener();
        flowableListener.setEvent(event);
        flowableListener.setImplementationType(ImplementationType.IMPLEMENTATION_TYPE_CLASS);
        flowableListener.setImplementation(implementation);
        return flowableListener;
    }


    /**
     * END NODE
     */
    public static EndEvent endEventNode (String name ){
        EndEvent endEvent = new EndEvent();
        endEvent.setId(FlowConstant.FLOW_NODE_END);
        endEvent.setName(name);
        return endEvent;
    }

    /**
     * 格式化id
     * @param type
     * @param index
     * @return
     */
    public static String formateId(String type,Integer index){
        return StrUtil.builder().append(type).append("_").append(index).toString();
    }

    public static String formateId(String type,String nodeType,Integer index){
        return StrUtil.builder().append(type).append("_").append(nodeType).append("_").append(index).toString();
    }

    public static String formateId(String type,Integer parentId,Integer index){
        return StrUtil.builder().append(type).append("_").append(parentId).append("_").append(index).toString();
    }

    public static String formateId(String type,String nodeType,Integer parentId,Integer index){
        return StrUtil.builder().append(type).append("_").append(nodeType).append("_").append(parentId).append("_").append(index).toString();
    }
}
