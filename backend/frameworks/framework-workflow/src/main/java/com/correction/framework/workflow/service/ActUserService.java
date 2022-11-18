package com.correction.framework.workflow.service;


import java.util.List;

/**
 * @Author：yao
 * @Description: 工作流获取用户service
 */
public interface ActUserService {


    /**
     * 根据用户id查询昵称
     *
     * @param userId 用户id
     * @return
     */
    String getNickNameByUserId(String userId);


    /**
     * 根据用户id查询角色id和部门id
     *
     * @param userId 用户id
     * @return
     */
    List<String> getRoleIdsAndDeptId(String userId);

}
