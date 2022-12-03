package com.correction.backend.modules.supervision.convert;

import com.correction.backend.modules.supervision.controller.dto.SupervisionVisitGroupCreateInputDTO;
import com.correction.backend.modules.supervision.controller.dto.SupervisionVisitGroupListOutputDTO;
import com.correction.backend.modules.supervision.controller.dto.SupervisionVisitGroupSearchInputDTO;
import com.correction.backend.modules.supervision.controller.dto.SupervisionVisitGroupUpdateInputDTO;
import com.correction.backend.modules.supervision.entity.SupervisionVisitGroup;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-03T15:42:12+0800",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 1.8.0_211 (Oracle Corporation)"
)
public class MSupervisionVisitGroupConvertImpl implements MSupervisionVisitGroupConvert {

    @Override
    public SupervisionVisitGroup toSupervisionVisitGroup(SupervisionVisitGroupSearchInputDTO supervisionVisitGroupSearchInputDTO) {
        if ( supervisionVisitGroupSearchInputDTO == null ) {
            return null;
        }

        SupervisionVisitGroup supervisionVisitGroup = new SupervisionVisitGroup();

        supervisionVisitGroup.setCorrectionUnit( supervisionVisitGroupSearchInputDTO.getCorrectionUnit() );
        supervisionVisitGroup.setUserName( supervisionVisitGroupSearchInputDTO.getUserName() );
        supervisionVisitGroup.setUserId( supervisionVisitGroupSearchInputDTO.getUserId() );
        supervisionVisitGroup.setUserType( supervisionVisitGroupSearchInputDTO.getUserType() );
        supervisionVisitGroup.setSex( supervisionVisitGroupSearchInputDTO.getSex() );
        supervisionVisitGroup.setIdCard( supervisionVisitGroupSearchInputDTO.getIdCard() );
        supervisionVisitGroup.setJob( supervisionVisitGroupSearchInputDTO.getJob() );
        supervisionVisitGroup.setDataId( supervisionVisitGroupSearchInputDTO.getDataId() );

        return supervisionVisitGroup;
    }

    @Override
    public SupervisionVisitGroup toSupervisionVisitGroup(SupervisionVisitGroupCreateInputDTO supervisionVisitGroupCreateInputDTO) {
        if ( supervisionVisitGroupCreateInputDTO == null ) {
            return null;
        }

        SupervisionVisitGroup supervisionVisitGroup = new SupervisionVisitGroup();

        supervisionVisitGroup.setCorrectionUnit( supervisionVisitGroupCreateInputDTO.getCorrectionUnit() );
        supervisionVisitGroup.setUserName( supervisionVisitGroupCreateInputDTO.getUserName() );
        supervisionVisitGroup.setUserId( supervisionVisitGroupCreateInputDTO.getUserId() );
        supervisionVisitGroup.setUserType( supervisionVisitGroupCreateInputDTO.getUserType() );
        supervisionVisitGroup.setSex( supervisionVisitGroupCreateInputDTO.getSex() );
        supervisionVisitGroup.setIdCard( supervisionVisitGroupCreateInputDTO.getIdCard() );
        supervisionVisitGroup.setJob( supervisionVisitGroupCreateInputDTO.getJob() );
        supervisionVisitGroup.setDataId( supervisionVisitGroupCreateInputDTO.getDataId() );

        return supervisionVisitGroup;
    }

    @Override
    public SupervisionVisitGroup toSupervisionVisitGroup(SupervisionVisitGroupUpdateInputDTO supervisionVisitGroupUpdateInputDTO) {
        if ( supervisionVisitGroupUpdateInputDTO == null ) {
            return null;
        }

        SupervisionVisitGroup supervisionVisitGroup = new SupervisionVisitGroup();

        supervisionVisitGroup.setId( supervisionVisitGroupUpdateInputDTO.getId() );
        supervisionVisitGroup.setCorrectionUnit( supervisionVisitGroupUpdateInputDTO.getCorrectionUnit() );
        supervisionVisitGroup.setUserName( supervisionVisitGroupUpdateInputDTO.getUserName() );
        supervisionVisitGroup.setUserId( supervisionVisitGroupUpdateInputDTO.getUserId() );
        supervisionVisitGroup.setUserType( supervisionVisitGroupUpdateInputDTO.getUserType() );
        supervisionVisitGroup.setSex( supervisionVisitGroupUpdateInputDTO.getSex() );
        supervisionVisitGroup.setIdCard( supervisionVisitGroupUpdateInputDTO.getIdCard() );
        supervisionVisitGroup.setJob( supervisionVisitGroupUpdateInputDTO.getJob() );
        supervisionVisitGroup.setDataId( supervisionVisitGroupUpdateInputDTO.getDataId() );

        return supervisionVisitGroup;
    }

    @Override
    public SupervisionVisitGroupListOutputDTO toList(SupervisionVisitGroup supervisionVisitGroup) {
        if ( supervisionVisitGroup == null ) {
            return null;
        }

        SupervisionVisitGroupListOutputDTO supervisionVisitGroupListOutputDTO = new SupervisionVisitGroupListOutputDTO();

        supervisionVisitGroupListOutputDTO.setId( supervisionVisitGroup.getId() );
        supervisionVisitGroupListOutputDTO.setCorrectionUnit( supervisionVisitGroup.getCorrectionUnit() );
        supervisionVisitGroupListOutputDTO.setUserName( supervisionVisitGroup.getUserName() );
        supervisionVisitGroupListOutputDTO.setUserId( supervisionVisitGroup.getUserId() );
        supervisionVisitGroupListOutputDTO.setUserType( supervisionVisitGroup.getUserType() );
        supervisionVisitGroupListOutputDTO.setSex( supervisionVisitGroup.getSex() );
        supervisionVisitGroupListOutputDTO.setIdCard( supervisionVisitGroup.getIdCard() );
        supervisionVisitGroupListOutputDTO.setJob( supervisionVisitGroup.getJob() );
        supervisionVisitGroupListOutputDTO.setDataId( supervisionVisitGroup.getDataId() );

        return supervisionVisitGroupListOutputDTO;
    }

    @Override
    public List<SupervisionVisitGroupListOutputDTO> toList(List<SupervisionVisitGroup> supervisionVisitGroups) {
        if ( supervisionVisitGroups == null ) {
            return null;
        }

        List<SupervisionVisitGroupListOutputDTO> list = new ArrayList<SupervisionVisitGroupListOutputDTO>( supervisionVisitGroups.size() );
        for ( SupervisionVisitGroup supervisionVisitGroup : supervisionVisitGroups ) {
            list.add( toList( supervisionVisitGroup ) );
        }

        return list;
    }

    @Override
    public List<SupervisionVisitGroup> toVisitGroup(List<SupervisionVisitGroupCreateInputDTO> createInputDTO) {
        if ( createInputDTO == null ) {
            return null;
        }

        List<SupervisionVisitGroup> list = new ArrayList<SupervisionVisitGroup>( createInputDTO.size() );
        for ( SupervisionVisitGroupCreateInputDTO supervisionVisitGroupCreateInputDTO : createInputDTO ) {
            list.add( toSupervisionVisitGroup( supervisionVisitGroupCreateInputDTO ) );
        }

        return list;
    }
}
