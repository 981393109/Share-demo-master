package com.correction.backend.modules.flow.convert;

import com.correction.backend.modules.flow.controller.vo.FlowCenterListOutputDTO;
import com.correction.backend.modules.flow.entity.FlowCenter;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-18T00:24:14+0800",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 1.8.0_211 (Oracle Corporation)"
)
public class MFlowCenterConvertImpl implements MFlowCenterConvert {

    @Override
    public List<FlowCenterListOutputDTO> toList(List<FlowCenter> flowCenters) {
        if ( flowCenters == null ) {
            return null;
        }

        List<FlowCenterListOutputDTO> list = new ArrayList<FlowCenterListOutputDTO>( flowCenters.size() );
        for ( FlowCenter flowCenter : flowCenters ) {
            list.add( flowCenterToFlowCenterListOutputDTO( flowCenter ) );
        }

        return list;
    }

    protected FlowCenterListOutputDTO flowCenterToFlowCenterListOutputDTO(FlowCenter flowCenter) {
        if ( flowCenter == null ) {
            return null;
        }

        FlowCenterListOutputDTO flowCenterListOutputDTO = new FlowCenterListOutputDTO();

        flowCenterListOutputDTO.setId( flowCenter.getId() );
        flowCenterListOutputDTO.setFlowType( flowCenter.getFlowType() );
        flowCenterListOutputDTO.setFlowStatus( flowCenter.getFlowStatus() );
        flowCenterListOutputDTO.setFlowApplyTime( flowCenter.getFlowApplyTime() );
        flowCenterListOutputDTO.setFlowEndTime( flowCenter.getFlowEndTime() );
        flowCenterListOutputDTO.setFlowApplyUser( flowCenter.getFlowApplyUser() );
        flowCenterListOutputDTO.setFlowApplyName( flowCenter.getFlowApplyName() );
        flowCenterListOutputDTO.setCreateTime( flowCenter.getCreateTime() );
        flowCenterListOutputDTO.setUpdateTime( flowCenter.getUpdateTime() );
        flowCenterListOutputDTO.setCreator( flowCenter.getCreator() );
        flowCenterListOutputDTO.setUpdater( flowCenter.getUpdater() );
        flowCenterListOutputDTO.setDeleted( flowCenter.getDeleted() );

        return flowCenterListOutputDTO;
    }
}
