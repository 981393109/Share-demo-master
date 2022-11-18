package com.correction.framework.workflow.service;

/**
 * @Author：yao
 * @Description: 修改任务状态
 */
public interface ActCompleteTaskService {

    /**
     * 修改完成状态
     *
     * @param id 业务主键id
     */
    void updateCompleteStatusById(String id);

    /**
     * 修改驳回状态
     *
     * @param id 业务主键id
     */
    void updateRejectStatusById(String id);

}
