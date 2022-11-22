package com.correction.backend.modules.flow.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.correction.backend.modules.file.config.FileProperties;
import com.correction.backend.modules.flow.constant.FlowConstant;
import com.correction.backend.modules.flow.controller.dto.FlowCenterDTO;
import com.correction.backend.modules.flow.controller.dto.FlowNodeDTO;
import com.correction.backend.modules.flow.convert.MFlowCenterConvert;
import com.correction.backend.modules.flow.entity.FlowCenter;
import com.correction.backend.modules.flow.entity.FlowNodeRelation;
import com.correction.backend.modules.flow.mapper.FlowCenterMapper;
import com.correction.backend.modules.flow.mapper.FlowNodeRelationMapper;
import com.correction.backend.modules.flow.service.FlowCenterService;
import com.correction.backend.modules.flow.service.FlowDeloyService;
import com.correction.backend.modules.flow.utils.FlowNodeUtils;
import com.correction.framework.workflow.service.FlowService;
import lombok.extern.slf4j.Slf4j;
import org.flowable.bpmn.converter.BpmnXMLConverter;
import org.flowable.bpmn.model.*;
import org.flowable.bpmn.model.Process;
import org.flowable.engine.ProcessEngine;
import org.flowable.engine.ProcessEngines;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.delegate.ExecutionListener;
import org.flowable.engine.repository.Deployment;
import org.flowable.engine.repository.ProcessDefinition;
import org.flowable.engine.repository.ProcessDefinitionQuery;
import org.flowable.task.service.delegate.TaskListener;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


@Service
@Slf4j
public class FlowDeloyServiceImpl implements FlowDeloyService {


    @Resource
    private FlowService flowService;

    @Resource
    private RepositoryService repositoryService;

    @Resource
    private FlowNodeRelationMapper flowNodeRelationMapper;

    @Resource
    private FileProperties fileProperties;

    @Resource
    private FlowCenterService flowCenterService;


    @Override
    public void saveFlowCenter(FlowCenterDTO flowCenterDTO) throws Exception {
        //得到该类型流程下最大版本号信息
        Integer version = getVersionByFlowKey(flowCenterDTO.getType());
        //删除原有流程节点：
        delFlowCenterByType(flowCenterDTO.getType());
        List<FlowNodeDTO> flowNodes = flowCenterDTO.getFlowNodes();
        if (CollUtil.isNotEmpty(flowNodes)) {
            List<FlowCenter> flowCenters = MFlowCenterConvert.INSTANCE.toFlowCenterList(flowNodes);
            //保存流程中心配置:
            flowCenterService.saveBatch(flowCenters);
            //开始启动配置
            deployment(flowCenterDTO.getType(), flowCenters, version);
        }
    }

    private Integer getVersionByFlowKey(String type) {
        //获取流程实例版本号信息
        ProcessDefinitionQuery processDefinitionQuery = repositoryService.createProcessDefinitionQuery().orderByProcessDefinitionId().orderByProcessDefinitionVersion().desc();
        processDefinitionQuery.processDefinitionKey(type);
        List<ProcessDefinition> processDefinitions = processDefinitionQuery.list();
        if(CollectionUtils.isEmpty(processDefinitions)){
            return 1;
        }
        ProcessDefinition processDefinition = processDefinitions.get(0);
        return processDefinition.getVersion()+1;
    }

    /**
     * 删除流程中心数据
     * @param type
     */
    public void delFlowCenterByType(String type){
        flowCenterService.remove(Wrappers.<FlowCenter>lambdaQuery().eq(FlowCenter::getFlowType,type));
    }

    public void deployment(String type, List<FlowCenter> flowCenters,Integer version) throws Exception {
        log.info("开始启动流程"+type+" , 版本号："+version+"************");
        //实例化流程XML
        String filePath = initFlow(type, flowCenters,version);
        log.info("生产XML路径************"+filePath);
        //部署流程：
        Deployment deployment = deployFlow(filePath, type);
        log.info("流程启动成功！************"+deployment.getId());
    }



    /**
     * 初始化流程生产xml文件
     * @param type
     * @param list
     * @return
     * @throws IOException
     */
    private String initFlow (String type, List<FlowCenter> list, Integer version) throws IOException {
        BpmnModel bpmnModel = new BpmnModel();
        // 2. 创建流程定义
        Process process = new Process();
        process.setId(type);
        process.setName(type+"流程审批");
        type = type+"_"+version;
        final AtomicInteger counter =  new AtomicInteger(0);
        StartEvent startEvent = FlowNodeUtils.startEventNode("开始", counter.get());
        //创建连线 开始 -》 发起人 串行
        SequenceFlow startSequenceFlow = FlowNodeUtils.connectSequenceFlow("", counter.getAndIncrement());
        List<SequenceFlow> startSequenceFlowList = new ArrayList<>();
        startSequenceFlowList.add(startSequenceFlow);
        //设置监听器：
        FlowableListener taskFlowListener = FlowNodeUtils.initFlowableListener(TaskListener.EVENTNAME_CREATE, FlowConstant.DEFAULT_TASK_LISTENER);
        FlowableListener executionFlowListener = FlowNodeUtils.initFlowableListener(ExecutionListener.EVENTNAME_END, FlowConstant.DEFAULT_EXECUTION_LISTENER);
        List<FlowableListener> taskFlowListenerList = new ArrayList<>();
        taskFlowListenerList.add(taskFlowListener);
        List<FlowableListener> executionFlowListenerList = new ArrayList<>();
        executionFlowListenerList.add(executionFlowListener);
        UserTask applyUserTask = FlowNodeUtils.userTaskNode(type,"提交审批", counter.get(), true, null, FlowConstant.DEFAULT_START_ASSIGNEE, taskFlowListenerList, executionFlowListenerList);
        //补充  开始 》 发起人 连线信息
        FlowNodeUtils.connectSequenceFlow(startSequenceFlow,startEvent.getId(),applyUserTask.getId(),null,new ArrayList<>());
        //创建连线 发起人 -》 下一审批人 串
        SequenceFlow nextSequenceFlow = FlowNodeUtils.connectSequenceFlow("提交", counter.getAndIncrement());
        List<SequenceFlow> nextSequenceFlowList = new ArrayList<>();
        nextSequenceFlowList.add(nextSequenceFlow);
        FlowNodeUtils.connectSequenceFlow(nextSequenceFlow,applyUserTask.getId(),FlowNodeUtils.formateId(type,FlowConstant.FLOW_NODE_USER,counter.get()),null,new ArrayList<>());
        //保存节点关联信息
        saveNodeRelation(applyUserTask.getId(),list.get(0));
        //连线信息关联：
        startEvent.setOutgoingFlows(startSequenceFlowList);
        applyUserTask.setOutgoingFlows(nextSequenceFlowList);
        process.addFlowElement(startEvent);
        process.addFlowElement(startSequenceFlow);
        process.addFlowElement(applyUserTask);
        process.addFlowElement(nextSequenceFlow);
        //配置流程节点：
        for (int i = 0; i < list.size(); i++) {
            FlowCenter flowCenter = list.get(i);
            //申明表达式：
            String completionCondition = FlowConstant.PASS_TYPE_ALL.equals(flowCenter.getPassType()) ? FlowConstant.FLOW_ALL_PASS : FlowConstant.FLOW_ONE_PASS;
            //创建变量
            UserTask userTask = FlowNodeUtils.userTaskNode(type,flowCenter.getName(), counter.get(), false, completionCondition, FlowConstant.ASSIGNEEMENT_ASSIGNEE, new ArrayList<>(), new ArrayList<>());
            //创建连线 审批人 -》 网关
            SequenceFlow toGateWaySequenceFlow = FlowNodeUtils.connectSequenceFlow("", counter.getAndIncrement());
            List<SequenceFlow> toGateWaySequenceFlowList = new ArrayList<>();
            toGateWaySequenceFlowList.add(toGateWaySequenceFlow);
            FlowNodeUtils.connectSequenceFlow(toGateWaySequenceFlow,userTask.getId(),FlowNodeUtils.formateId(FlowConstant.FLOW_NODE_GATEWAY,counter.get()),null,new ArrayList<>());
            int index = counter.get();
            AtomicInteger detailIndex =  new AtomicInteger(0);
            //配置网关：
            ExclusiveGateway exclusiveGateway = FlowNodeUtils.exclusiveGatewayNode("网关校验", index);
            counter.incrementAndGet();
            //判断当前节点是否是最后一级节点
            List<FlowableListener> executionListeneList = executionFlowListenerList;
            String toTarget = FlowConstant.FLOW_NODE_USER;
            if(i == list.size() -1){
                FlowableListener executionPassFlowListener = FlowNodeUtils.initFlowableListener(ExecutionListener.EVENTNAME_END, FlowConstant.DEFAULT_EXECUTION_PASS);
                executionListeneList = Arrays.asList(executionPassFlowListener);
                toTarget = FlowConstant.FLOW_NODE_END;
            }
            //创建连线: 网关 -》 通过 (  拒绝 、驳回) todo 后续补充驳回操作
            SequenceFlow gateWaySequencePassFlow = FlowNodeUtils.connectSequenceFlow(type,"通过", index,detailIndex.getAndIncrement());
            gateWaySequencePassFlow.setDocumentation(String.valueOf(flowCenter.getId()));
            List<SequenceFlow> gateWaySequenceFlowList= new ArrayList<>();
            gateWaySequenceFlowList.add(gateWaySequencePassFlow);
            //通过连线表达式:
            String completionConditionlink = FlowConstant.PASS_TYPE_ALL.equals(flowCenter.getPassType()) ? FlowConstant.FLOW_ALL_PASS_LINK : FlowConstant.FLOW_ONE_PASS_LINK;
            FlowNodeUtils.connectSequenceFlow(gateWaySequencePassFlow,exclusiveGateway.getId(),FlowConstant.FLOW_NODE_END.equals(toTarget) ? toTarget : FlowNodeUtils.formateId(type , toTarget , counter.get()),completionConditionlink,executionListeneList);
            //保存节点关联关系
            saveNodeRelation(gateWaySequencePassFlow.getId(),(i + 1 == list.size())?null:list.get(i + 1));
            // 创建连线：网关 -》 拒绝
            FlowableListener executionRefuseFlowListener = FlowNodeUtils.initFlowableListener(ExecutionListener.EVENTNAME_END, FlowConstant.DEFAULT_EXECUTION_REFUSED);
            List<FlowableListener> refuseListenerList = Arrays.asList(executionRefuseFlowListener);
            SequenceFlow gateWaySequenceRefuseFlow = FlowNodeUtils.connectSequenceFlow("拒绝", index,detailIndex.getAndIncrement());
            gateWaySequenceFlowList.add(gateWaySequenceRefuseFlow);
            FlowNodeUtils.connectSequenceFlow(gateWaySequenceRefuseFlow,exclusiveGateway.getId(),FlowConstant.FLOW_NODE_END,FlowConstant.FLOW_ONE_REFUSE,refuseListenerList);

            // 创建连线：网关 -》 驳回
            SequenceFlow gateWaySequenceRejectedFlow = FlowNodeUtils.connectSequenceFlow(type,"驳回", index,detailIndex.getAndIncrement());
            gateWaySequenceRejectedFlow.setDocumentation(String.valueOf(flowCenter.getId()));
            gateWaySequenceFlowList.add(gateWaySequenceRejectedFlow);
            //通过连线表达式:
            String completionConditionRejectedLink = FlowConstant.FLOW_ONE_REJECTED_LINK;
            FlowNodeUtils.connectSequenceFlow(gateWaySequenceRejectedFlow,exclusiveGateway.getId(),
                     FlowNodeUtils.formateId(type , FlowConstant.FLOW_NODE_USER , (list.size() == 1 || i == 0) ? 1 : (index -3))
                    ,completionConditionRejectedLink,executionListeneList);

            //设置走向
            userTask.setOutgoingFlows(toGateWaySequenceFlowList);
            exclusiveGateway.setOutgoingFlows(gateWaySequenceFlowList);
            process.addFlowElement(userTask);
            process.addFlowElement(toGateWaySequenceFlow);
            process.addFlowElement(exclusiveGateway);
            process.addFlowElement(gateWaySequencePassFlow);
            process.addFlowElement(gateWaySequenceRefuseFlow);
            process.addFlowElement(gateWaySequenceRejectedFlow);
        }
        //结束事件：
        EndEvent endEvent = FlowNodeUtils.endEventNode("结束");
        process.addFlowElement(endEvent);
        bpmnModel.addProcess(process);
        //流程保存
        String filePath = saveFile(bpmnModel,type);
        return  filePath;
    }

    private String saveFile(BpmnModel bpmnModel,String type) {
        String filePath = fileProperties.getLinuxpath()+ File.separator+"FLOW_BPMN_XML"+File.separator+type+".bpmn20.xml";
        try {
            //2. 生成的图形信息
            byte[] bytes = new BpmnXMLConverter().convertToXML(bpmnModel);
            File file = new File(filePath);
            if(!file.exists()){
                file.getParentFile().mkdirs();
            }
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
            bos.write(bytes);
            bos.flush();
            bos.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        return filePath;
    }

    private Deployment deployFlow(String path, String type) throws IOException {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        //2.得到RepositoryService实例
        RepositoryService repositoryService = processEngine.getRepositoryService();
        //3.进行部署
        FileInputStream fileInputStream = new FileInputStream(new File(path));
        Deployment deployment = repositoryService.createDeployment()
                .name(type)
                .category(type)
                .addInputStream(type+".bpmn20.xml", fileInputStream).deploy();
        return deployment;
    }

    private void saveNodeRelation(String nodeId,FlowCenter flowCenter){
        if(flowCenter!=null){
            FlowNodeRelation flowNodeRelation = new FlowNodeRelation();
            flowNodeRelation.setNodeId(nodeId);
            flowNodeRelation.setFlowId(flowCenter.getId());
            flowNodeRelationMapper.insert(flowNodeRelation);
        }
    }




}
