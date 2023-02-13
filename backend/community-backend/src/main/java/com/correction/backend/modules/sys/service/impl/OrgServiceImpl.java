package com.correction.backend.modules.sys.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.correction.backend.modules.sys.constant.SysConstant;
import com.correction.backend.modules.sys.controller.dto.sys.OrgCreateInputDTO;
import com.correction.backend.modules.sys.controller.dto.sys.OrgSearchInputDTO;
import com.correction.backend.modules.sys.controller.dto.sys.OrgUpdateInputDTO;
import com.correction.backend.modules.sys.convert.sys.MOrgConvert;
import com.correction.backend.modules.sys.entity.OrgDO;
import com.correction.backend.modules.sys.mapper.OrgMapper;
import com.correction.backend.modules.sys.service.OrgService;
import com.correction.framework.common.enums.CommonStatusEnum;
import com.correction.framework.common.pojo.PageResult;
import com.google.common.annotations.VisibleForTesting;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

import static com.correction.backend.modules.sys.enums.SysErrorCodeConstants.*;
import static com.correction.framework.common.exception.util.ServiceExceptionUtil.exception;

/**
 * <p>
 * 组织表 服务实现类
 * </p>
 *
 * @author yao
 * @since 2022-11-12
 */
@Service
@Slf4j
public class OrgServiceImpl extends ServiceImpl<OrgMapper, OrgDO> implements OrgService {

    @Resource
    private OrgMapper orgMapper;

    @Override
    public Long createOrg(OrgCreateInputDTO reqDTO) {
        reqDTO.setOrgNum(String.valueOf(System.currentTimeMillis()));
        //校验
        this.checkCreateOrUpdate(null,reqDTO.getPid(),reqDTO.getOrgNum(),reqDTO.getOrgCode(),reqDTO.getOrgType());
        //新增
        OrgDO orgDO = MOrgConvert.INSTANCE.toOrg(reqDTO);
        assmberParentName(orgDO);
        orgMapper.insert(orgDO);
        return orgDO.getId();
    }


    @Override
    public OrgDO updateOrg(OrgUpdateInputDTO reqDTO) {
        //校验
        this.checkCreateOrUpdate(reqDTO.getId(),reqDTO.getPid(),reqDTO.getOrgNum(),reqDTO.getOrgCode(),reqDTO.getOrgType());
        OrgDO orgDO = MOrgConvert.INSTANCE.toOrg(reqDTO);
        assmberParentName(orgDO);
        orgMapper.updateById(orgDO);
        return orgDO;
    }

    @Override
    public void delete(Long id) {
        baseMapper.deleteById(id);
        //todo 是否该组织下的用户的orgId 和角色给取消掉
    }

    @Override
    public OrgDO detail(Long id) {
        OrgDO orgDO = orgMapper.selectById(id);
        return orgDO;
    }

    /**
     * 得到当前列表下所有组织集合（未分页）
     * @param id
     * @return
     */
    @Override
    public List<OrgDO> getOrgChildsList(Long id) {
        List<OrgDO> orgDOS = new ArrayList<>();
        orgDOS = recursiveOrgList(orgDOS,id);
        return orgDOS;
    }

    @Override
    public List<OrgDO> getOrgParentList(Long id) {
        List<OrgDO> orgDOS = new ArrayList<>();
        OrgDO orgDO = orgMapper.selectById(id);
        orgDOS = recursiveAssmberParents(orgDO, orgDOS);
        return orgDOS;
    }

    @Override
    public PageResult<OrgDO> getPageList(OrgSearchInputDTO searchInputDTO) {
        PageResult<OrgDO> orgDOPageResult = baseMapper.selectPage(searchInputDTO);
        return orgDOPageResult;
    }

    @Override
    public List<OrgDO> getList() {
        List<OrgDO> orgDOS = baseMapper.selectList(Wrappers.<OrgDO>lambdaQuery().eq(OrgDO::getDeleted, CommonStatusEnum.ENABLE).orderByAsc(OrgDO::getId));
        return orgDOS;
    }

    @Override
    public Set<String> getCodes(Long id) {
        List<OrgDO> result = new ArrayList<>();
        result =  recursiveOrgList(result,id);
        Set<String> collect = result.stream().map(e -> e.getOrgCode()).collect(Collectors.toSet());
        return collect;
    }

    @Override
    public Set<OrgDO> getTreeByUserOrgId(Long orgId) {
        Set<OrgDO> orgSet = new HashSet<>();
        List<OrgDO> orgParentList = getOrgParentList(orgId);
        List<OrgDO> orgChildsList = getOrgChildsList(orgId);
        orgSet.addAll(orgParentList);
        orgSet.addAll(orgChildsList);
        return orgSet;
    }


    private void assmberParentName(OrgDO orgDO){
        //处理层级关系聚合
        List<String> parentNames = new ArrayList<>();
        parentNames =  recursiveAssmberParentNames(orgDO,parentNames);
        Collections.reverse(parentNames);
        orgDO.setParentNames(StringUtils.join(parentNames,"-"));
    }


    /**
     * 递归获取组织信息
     */
    private List<OrgDO>  recursiveOrgList (List<OrgDO> result,Long pid) {
        List<OrgDO> orgDOS = orgMapper.selectList(Wrappers.<OrgDO>lambdaQuery().eq(OrgDO::getPid, pid).eq(OrgDO::getDeleted, CommonStatusEnum.ENABLE));
        if(!CollectionUtil.isEmpty(orgDOS)){
            for (OrgDO orgDO : orgDOS) {
                result.add(orgDO);
                result = recursiveOrgList(result,orgDO.getId()) ;
            }

        }
        return result;
    }

    /**
     * 递归聚合层级关系
     * @param orgDO
     */
    private List<String> recursiveAssmberParentNames(OrgDO orgDO,List<String> parentNameList) {
        parentNameList.add(orgDO.getOrgName());
        //得到父级组织
        if (!orgDO.getPid().equals(SysConstant.ROOT_TOP)){
            OrgDO pOrg = orgMapper.selectOne("id", orgDO.getPid());
            if(pOrg != null){
                parentNameList = recursiveAssmberParentNames(pOrg,parentNameList);
            }
        }
        return parentNameList;
    }

    /**
     * 递归获取父组织信息
     * @param orgDO
     */
    private List<OrgDO> recursiveAssmberParents(OrgDO orgDO,List<OrgDO> parentList) {
        parentList.add(orgDO);
        //得到父级组织
        if (!orgDO.getPid().equals(SysConstant.ROOT_TOP)){
            OrgDO pOrg = orgMapper.selectOne("id", orgDO.getPid());
            if(pOrg != null){
                parentList = recursiveAssmberParents(pOrg,parentList);
            }
        }
        return parentList;
    }



    /**
     * 校验必填项
     * @param orgNum
     * @param orgCode
     */
    private void checkCreateOrUpdate(Long id ,Long pid,String orgNum, String orgCode,Integer orgType) {
        //校验父组织是否存在
        checkOrgParentExsit(pid);
        // 校验组织Code是否唯一
        this.checkOrgNumUnique(id, orgCode);
        //校验是否是市级机构、只能存在一个市级机构
        if(0 == orgType){
            List<OrgDO> orgDOS = baseMapper.selectList(Wrappers.<OrgDO>lambdaQuery().eq(OrgDO::getOrgType, 0));
            if(!CollectionUtil.isEmpty(orgDOS)){
                if(id == null){
                    throw exception(ORG_PARENT_IS_CITY);
                }
                //判断id是否一致
                for (OrgDO orgDO : orgDOS) {
                    if(!orgDO.getId().equals(id)){
                        throw exception(ORG_PARENT_IS_CITY);
                    }
                }
            }
        }
    }

    @VisibleForTesting
    void checkOrgNumUnique(Long id, String orgCode) {
        if (StrUtil.isBlank(orgCode)) {
            return;
        }
        OrgDO orgDO = orgMapper.selectOne("org_code",orgCode);
        if (orgDO == null) {
            return;
        }
        // 如果 id 为空，说明不用比较是否为相同 id 的用户
        if (id == null) {
            throw exception(USER_USERNAME_EXISTS);
        }
        if (!orgDO.getId().equals(id)) {
            throw exception(USER_USERNAME_EXISTS);
        }
    }

    @VisibleForTesting
    void checkOrgParentExsit(Long pid) {
        if(pid == null) {
            throw exception(ORG_PARENT_ID_NULL);
        }
        if(SysConstant.ROOT_TOP.equals(pid)){
            return;
        }
        OrgDO orgDO = orgMapper.selectById(pid);
        if(orgDO == null) {
            throw exception(ORG_PARENT_NOT_EXITS);
        }
    }


}
