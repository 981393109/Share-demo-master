package com.correction.backend.modules.sys.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.correction.backend.modules.sys.controller.dto.sys.OrgCreateInputDTO;
import com.correction.backend.modules.sys.controller.dto.sys.OrgSearchInputDTO;
import com.correction.backend.modules.sys.controller.dto.sys.OrgUpdateInputDTO;
import com.correction.backend.modules.sys.entity.OrgDO;
import com.correction.framework.common.pojo.PageResult;

import java.util.List;
import java.util.Set;

/**
 * <p>
 * 组织表 服务类
 * </p>
 *
 * @author yao
 * @since 2022-11-12
 */
public interface OrgService extends IService<OrgDO> {

    /**
     * 创建组织
     */
    Long createOrg(OrgCreateInputDTO reqDTO);

    /**
     * 修改组织
     */
    OrgDO updateOrg(OrgUpdateInputDTO reqDTO);


    /**
     * 获取详情
     */
    OrgDO detail(Long id);


    /**
     * 根据父id获取自身以及旗下所有子组织信息 (未分页)
     */
    List<OrgDO> getOrgChildsList(Long id);

    /**
     * 分页获取所有组织信息
     */
    PageResult<OrgDO> getPageList (OrgSearchInputDTO searchInputDTO);

    /**
     * 获取所有组织架构
     */
    List<OrgDO> getList();

    /**
     * 根据当前组织id,得到子集所有code
     */
    Set<String> getCodes (Long id );
}
