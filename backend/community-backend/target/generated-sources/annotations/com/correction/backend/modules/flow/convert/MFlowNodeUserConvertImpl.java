package com.correction.backend.modules.flow.convert;

import com.correction.backend.modules.flow.controller.dto.FlowNodeUserCreateInputDTO;
import com.correction.backend.modules.flow.controller.dto.FlowNodeUserListOutputDTO;
import com.correction.backend.modules.flow.entity.FlowNodeUser;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-13T01:51:15+0800",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 1.8.0_211 (Oracle Corporation)"
)
public class MFlowNodeUserConvertImpl implements MFlowNodeUserConvert {

    @Override
    public List<FlowNodeUser> toFlowNodeUser(List<FlowNodeUserCreateInputDTO> flowNodeUserCreateInputDTOList) {
        if ( flowNodeUserCreateInputDTOList == null ) {
            return null;
        }

        List<FlowNodeUser> list = new ArrayList<FlowNodeUser>( flowNodeUserCreateInputDTOList.size() );
        for ( FlowNodeUserCreateInputDTO flowNodeUserCreateInputDTO : flowNodeUserCreateInputDTOList ) {
            list.add( toFlowNodeUser( flowNodeUserCreateInputDTO ) );
        }

        return list;
    }

    @Override
    public FlowNodeUser toFlowNodeUser(FlowNodeUserCreateInputDTO flowNodeUserCreateInputDTO) {
        if ( flowNodeUserCreateInputDTO == null ) {
            return null;
        }

        FlowNodeUser flowNodeUser = new FlowNodeUser();

        flowNodeUser.setOrgId( flowNodeUserCreateInputDTO.getOrgId() );
        flowNodeUser.setRoleId( flowNodeUserCreateInputDTO.getRoleId() );
        flowNodeUser.setUserId( flowNodeUserCreateInputDTO.getUserId() );
        flowNodeUser.setNodeId( flowNodeUserCreateInputDTO.getNodeId() );
        flowNodeUser.setDataId( flowNodeUserCreateInputDTO.getDataId() );
        flowNodeUser.setFlowId( flowNodeUserCreateInputDTO.getFlowId() );
        flowNodeUser.setRef( flowNodeUserCreateInputDTO.getRef() );
        flowNodeUser.setNodeName( flowNodeUserCreateInputDTO.getNodeName() );

        return flowNodeUser;
    }

    @Override
    public FlowNodeUserListOutputDTO toList(FlowNodeUser flowNodeUser) {
        if ( flowNodeUser == null ) {
            return null;
        }

        FlowNodeUserListOutputDTO flowNodeUserListOutputDTO = new FlowNodeUserListOutputDTO();

        flowNodeUserListOutputDTO.setId( flowNodeUser.getId() );
        flowNodeUserListOutputDTO.setOrgId( flowNodeUser.getOrgId() );
        flowNodeUserListOutputDTO.setRoleId( flowNodeUser.getRoleId() );
        flowNodeUserListOutputDTO.setUserId( flowNodeUser.getUserId() );
        flowNodeUserListOutputDTO.setNodeId( flowNodeUser.getNodeId() );
        flowNodeUserListOutputDTO.setDataId( flowNodeUser.getDataId() );
        flowNodeUserListOutputDTO.setFlowId( flowNodeUser.getFlowId() );
        flowNodeUserListOutputDTO.setRef( flowNodeUser.getRef() );
        flowNodeUserListOutputDTO.setNodeName( flowNodeUser.getNodeName() );

        return flowNodeUserListOutputDTO;
    }

    @Override
    public List<FlowNodeUserListOutputDTO> toList(List<FlowNodeUser> flowNodeUsers) {
        if ( flowNodeUsers == null ) {
            return null;
        }

        List<FlowNodeUserListOutputDTO> list = new ArrayList<FlowNodeUserListOutputDTO>( flowNodeUsers.size() );
        for ( FlowNodeUser flowNodeUser : flowNodeUsers ) {
            list.add( toList( flowNodeUser ) );
        }

        return list;
    }
}
