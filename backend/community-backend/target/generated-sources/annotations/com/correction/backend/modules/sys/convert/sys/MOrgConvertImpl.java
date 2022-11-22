package com.correction.backend.modules.sys.convert.sys;

import com.correction.backend.modules.sys.controller.dto.sys.OrgCreateInputDTO;
import com.correction.backend.modules.sys.controller.dto.sys.OrgListOutputDTO;
import com.correction.backend.modules.sys.controller.dto.sys.OrgSearchInputDTO;
import com.correction.backend.modules.sys.controller.dto.sys.OrgTreeDTO;
import com.correction.backend.modules.sys.controller.dto.sys.OrgTreeDTO.OrgTreeDTOBuilder;
import com.correction.backend.modules.sys.controller.dto.sys.OrgUpdateInputDTO;
import com.correction.backend.modules.sys.entity.OrgDO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-22T03:43:43+0800",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 1.8.0_211 (Oracle Corporation)"
)
public class MOrgConvertImpl implements MOrgConvert {

    @Override
    public OrgDO toOrg(OrgSearchInputDTO orgSearchInputDTO) {
        if ( orgSearchInputDTO == null ) {
            return null;
        }

        OrgDO orgDO = new OrgDO();

        orgDO.setCreateTime( orgSearchInputDTO.getCreateTime() );
        orgDO.setUpdateTime( orgSearchInputDTO.getUpdateTime() );
        orgDO.setCreator( orgSearchInputDTO.getCreator() );
        orgDO.setUpdater( orgSearchInputDTO.getUpdater() );
        orgDO.setDeleted( orgSearchInputDTO.getDeleted() );
        orgDO.setOrgName( orgSearchInputDTO.getOrgName() );
        orgDO.setOrgNum( orgSearchInputDTO.getOrgNum() );
        orgDO.setOrgCode( orgSearchInputDTO.getOrgCode() );
        orgDO.setEmployeeCount( orgSearchInputDTO.getEmployeeCount() );
        orgDO.setOrgType( orgSearchInputDTO.getOrgType() );
        orgDO.setInCharge( orgSearchInputDTO.getInCharge() );
        orgDO.setPid( orgSearchInputDTO.getPid() );
        orgDO.setCompileCount( orgSearchInputDTO.getCompileCount() );
        orgDO.setDescription( orgSearchInputDTO.getDescription() );

        return orgDO;
    }

    @Override
    public OrgDO toOrg(OrgCreateInputDTO orgCreateInputDTO) {
        if ( orgCreateInputDTO == null ) {
            return null;
        }

        OrgDO orgDO = new OrgDO();

        orgDO.setCreateTime( orgCreateInputDTO.getCreateTime() );
        orgDO.setUpdateTime( orgCreateInputDTO.getUpdateTime() );
        orgDO.setCreator( orgCreateInputDTO.getCreator() );
        orgDO.setUpdater( orgCreateInputDTO.getUpdater() );
        orgDO.setDeleted( orgCreateInputDTO.getDeleted() );
        orgDO.setOrgName( orgCreateInputDTO.getOrgName() );
        orgDO.setOrgNum( orgCreateInputDTO.getOrgNum() );
        orgDO.setOrgCode( orgCreateInputDTO.getOrgCode() );
        orgDO.setEmployeeCount( orgCreateInputDTO.getEmployeeCount() );
        orgDO.setOrgType( orgCreateInputDTO.getOrgType() );
        orgDO.setInCharge( orgCreateInputDTO.getInCharge() );
        orgDO.setPid( orgCreateInputDTO.getPid() );
        orgDO.setCompileCount( orgCreateInputDTO.getCompileCount() );
        orgDO.setDescription( orgCreateInputDTO.getDescription() );

        return orgDO;
    }

    @Override
    public OrgDO toOrg(OrgUpdateInputDTO orgUpdateInputDTO) {
        if ( orgUpdateInputDTO == null ) {
            return null;
        }

        OrgDO orgDO = new OrgDO();

        orgDO.setCreateTime( orgUpdateInputDTO.getCreateTime() );
        orgDO.setUpdateTime( orgUpdateInputDTO.getUpdateTime() );
        orgDO.setCreator( orgUpdateInputDTO.getCreator() );
        orgDO.setUpdater( orgUpdateInputDTO.getUpdater() );
        orgDO.setDeleted( orgUpdateInputDTO.getDeleted() );
        orgDO.setId( orgUpdateInputDTO.getId() );
        orgDO.setOrgName( orgUpdateInputDTO.getOrgName() );
        orgDO.setOrgNum( orgUpdateInputDTO.getOrgNum() );
        orgDO.setOrgCode( orgUpdateInputDTO.getOrgCode() );
        orgDO.setEmployeeCount( orgUpdateInputDTO.getEmployeeCount() );
        orgDO.setOrgType( orgUpdateInputDTO.getOrgType() );
        orgDO.setInCharge( orgUpdateInputDTO.getInCharge() );
        orgDO.setPid( orgUpdateInputDTO.getPid() );
        orgDO.setCompileCount( orgUpdateInputDTO.getCompileCount() );
        orgDO.setDescription( orgUpdateInputDTO.getDescription() );

        return orgDO;
    }

    @Override
    public OrgListOutputDTO toList(OrgDO org) {
        if ( org == null ) {
            return null;
        }

        OrgListOutputDTO orgListOutputDTO = new OrgListOutputDTO();

        orgListOutputDTO.setId( org.getId() );
        orgListOutputDTO.setOrgName( org.getOrgName() );
        orgListOutputDTO.setOrgNum( org.getOrgNum() );
        orgListOutputDTO.setOrgCode( org.getOrgCode() );
        orgListOutputDTO.setEmployeeCount( org.getEmployeeCount() );
        orgListOutputDTO.setOrgType( org.getOrgType() );
        orgListOutputDTO.setInCharge( org.getInCharge() );
        orgListOutputDTO.setPid( org.getPid() );
        orgListOutputDTO.setCompileCount( org.getCompileCount() );
        orgListOutputDTO.setDescription( org.getDescription() );
        orgListOutputDTO.setCreateTime( org.getCreateTime() );
        orgListOutputDTO.setUpdateTime( org.getUpdateTime() );
        orgListOutputDTO.setCreator( org.getCreator() );
        orgListOutputDTO.setUpdater( org.getUpdater() );
        orgListOutputDTO.setDeleted( org.getDeleted() );

        return orgListOutputDTO;
    }

    @Override
    public List<OrgListOutputDTO> toList(List<OrgDO> orgs) {
        if ( orgs == null ) {
            return null;
        }

        List<OrgListOutputDTO> list = new ArrayList<OrgListOutputDTO>( orgs.size() );
        for ( OrgDO orgDO : orgs ) {
            list.add( toList( orgDO ) );
        }

        return list;
    }

    @Override
    public OrgTreeDTO convertTreeNode(OrgDO orgDO) {
        if ( orgDO == null ) {
            return null;
        }

        OrgTreeDTOBuilder orgTreeDTO = OrgTreeDTO.builder();

        orgTreeDTO.id( orgDO.getId() );
        orgTreeDTO.pid( orgDO.getPid() );
        orgTreeDTO.orgName( orgDO.getOrgName() );

        return orgTreeDTO.build();
    }
}
