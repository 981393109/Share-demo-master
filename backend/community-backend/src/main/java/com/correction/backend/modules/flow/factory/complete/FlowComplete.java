package com.correction.backend.modules.flow.factory.complete;


import com.correction.framework.workflow.dto.FlowCompleteDTO;
import com.correction.framework.workflow.dto.FlowStartDTO;
import com.correction.framework.workflow.factory.ActProcessInstance;

/**
 * 流程操作
 */
public interface FlowComplete {


    void doUpdateData(String dataId,String ref,String progress,String status);

    void doEnd(String dataId,String ref ,String progress,String status);

}
