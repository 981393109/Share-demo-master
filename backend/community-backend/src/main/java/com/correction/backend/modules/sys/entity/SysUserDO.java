package com.correction.backend.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.correction.frameworks.mybatis.mybatis.core.dataobject.BaseDO;
import lombok.*;

@TableName(value = "sys_user", autoResultMap = true)
@Data
@EqualsAndHashCode(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SysUserDO extends BaseDO {

    /**
     * 用户ID
     */
    @TableId
    private Long id;

    /**
     * 员工号
     */
    private String userNumber;

    /**
     * 名称
     */
    private String userName;

    /**
     * 用户状态
     */
    private Integer status;

    /**
     * 岗位
     */
    private String userJobs;

    /**
     * 联系方式
     */
    private String contactInformation;

    /**
     * 组织信息
     */
    private String orgInfo;

    /**
     * 组织信息
     */
    private String orgParentInfo;

    /**
     * 所属组织
     */
    private Long orgId;

    private String orgNum;

    private Long roleId;

    /**
     * 密码
     */
    private String  password;

    private Integer userType;


}
