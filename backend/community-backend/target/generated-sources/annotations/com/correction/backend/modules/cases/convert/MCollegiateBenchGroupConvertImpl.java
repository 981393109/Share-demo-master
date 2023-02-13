package com.correction.backend.modules.cases.convert;

import com.correction.backend.modules.cases.controller.dto.CollegiateBenchGroupCreateInputDTO;
import com.correction.backend.modules.cases.controller.dto.CollegiateBenchGroupListOutputDTO;
import com.correction.backend.modules.cases.controller.dto.CollegiateBenchGroupSearchInputDTO;
import com.correction.backend.modules.cases.controller.dto.CollegiateBenchGroupUpdateInputDTO;
import com.correction.backend.modules.cases.entity.CollegiateBenchGroup;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-13T01:51:15+0800",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 1.8.0_211 (Oracle Corporation)"
)
public class MCollegiateBenchGroupConvertImpl implements MCollegiateBenchGroupConvert {

    @Override
    public CollegiateBenchGroup toCollegiateBenchGroup(CollegiateBenchGroupSearchInputDTO collegiateBenchGroupSearchInputDTO) {
        if ( collegiateBenchGroupSearchInputDTO == null ) {
            return null;
        }

        CollegiateBenchGroup collegiateBenchGroup = new CollegiateBenchGroup();

        collegiateBenchGroup.setCorrectionUnit( collegiateBenchGroupSearchInputDTO.getCorrectionUnit() );
        collegiateBenchGroup.setUserName( collegiateBenchGroupSearchInputDTO.getUserName() );
        collegiateBenchGroup.setUserId( collegiateBenchGroupSearchInputDTO.getUserId() );
        collegiateBenchGroup.setUserType( collegiateBenchGroupSearchInputDTO.getUserType() );
        collegiateBenchGroup.setSex( collegiateBenchGroupSearchInputDTO.getSex() );
        collegiateBenchGroup.setIdCard( collegiateBenchGroupSearchInputDTO.getIdCard() );
        collegiateBenchGroup.setJob( collegiateBenchGroupSearchInputDTO.getJob() );
        collegiateBenchGroup.setDataId( collegiateBenchGroupSearchInputDTO.getDataId() );
        collegiateBenchGroup.setType( collegiateBenchGroupSearchInputDTO.getType() );

        return collegiateBenchGroup;
    }

    @Override
    public CollegiateBenchGroup toCollegiateBenchGroup(CollegiateBenchGroupCreateInputDTO collegiateBenchGroupCreateInputDTO) {
        if ( collegiateBenchGroupCreateInputDTO == null ) {
            return null;
        }

        CollegiateBenchGroup collegiateBenchGroup = new CollegiateBenchGroup();

        collegiateBenchGroup.setCorrectionUnit( collegiateBenchGroupCreateInputDTO.getCorrectionUnit() );
        collegiateBenchGroup.setUserName( collegiateBenchGroupCreateInputDTO.getUserName() );
        collegiateBenchGroup.setUserId( collegiateBenchGroupCreateInputDTO.getUserId() );
        collegiateBenchGroup.setUserType( collegiateBenchGroupCreateInputDTO.getUserType() );
        collegiateBenchGroup.setSex( collegiateBenchGroupCreateInputDTO.getSex() );
        collegiateBenchGroup.setIdCard( collegiateBenchGroupCreateInputDTO.getIdCard() );
        collegiateBenchGroup.setJob( collegiateBenchGroupCreateInputDTO.getJob() );
        collegiateBenchGroup.setDataId( collegiateBenchGroupCreateInputDTO.getDataId() );
        collegiateBenchGroup.setType( collegiateBenchGroupCreateInputDTO.getType() );

        return collegiateBenchGroup;
    }

    @Override
    public CollegiateBenchGroup toCollegiateBenchGroup(CollegiateBenchGroupUpdateInputDTO collegiateBenchGroupUpdateInputDTO) {
        if ( collegiateBenchGroupUpdateInputDTO == null ) {
            return null;
        }

        CollegiateBenchGroup collegiateBenchGroup = new CollegiateBenchGroup();

        collegiateBenchGroup.setId( collegiateBenchGroupUpdateInputDTO.getId() );
        collegiateBenchGroup.setCorrectionUnit( collegiateBenchGroupUpdateInputDTO.getCorrectionUnit() );
        collegiateBenchGroup.setUserName( collegiateBenchGroupUpdateInputDTO.getUserName() );
        collegiateBenchGroup.setUserId( collegiateBenchGroupUpdateInputDTO.getUserId() );
        collegiateBenchGroup.setUserType( collegiateBenchGroupUpdateInputDTO.getUserType() );
        collegiateBenchGroup.setSex( collegiateBenchGroupUpdateInputDTO.getSex() );
        collegiateBenchGroup.setIdCard( collegiateBenchGroupUpdateInputDTO.getIdCard() );
        collegiateBenchGroup.setJob( collegiateBenchGroupUpdateInputDTO.getJob() );
        collegiateBenchGroup.setDataId( collegiateBenchGroupUpdateInputDTO.getDataId() );
        collegiateBenchGroup.setType( collegiateBenchGroupUpdateInputDTO.getType() );

        return collegiateBenchGroup;
    }

    @Override
    public CollegiateBenchGroupListOutputDTO toList(CollegiateBenchGroup collegiateBenchGroup) {
        if ( collegiateBenchGroup == null ) {
            return null;
        }

        CollegiateBenchGroupListOutputDTO collegiateBenchGroupListOutputDTO = new CollegiateBenchGroupListOutputDTO();

        collegiateBenchGroupListOutputDTO.setId( collegiateBenchGroup.getId() );
        collegiateBenchGroupListOutputDTO.setCorrectionUnit( collegiateBenchGroup.getCorrectionUnit() );
        collegiateBenchGroupListOutputDTO.setUserName( collegiateBenchGroup.getUserName() );
        collegiateBenchGroupListOutputDTO.setUserId( collegiateBenchGroup.getUserId() );
        collegiateBenchGroupListOutputDTO.setUserType( collegiateBenchGroup.getUserType() );
        collegiateBenchGroupListOutputDTO.setSex( collegiateBenchGroup.getSex() );
        collegiateBenchGroupListOutputDTO.setIdCard( collegiateBenchGroup.getIdCard() );
        collegiateBenchGroupListOutputDTO.setJob( collegiateBenchGroup.getJob() );
        collegiateBenchGroupListOutputDTO.setDataId( collegiateBenchGroup.getDataId() );
        collegiateBenchGroupListOutputDTO.setType( collegiateBenchGroup.getType() );

        return collegiateBenchGroupListOutputDTO;
    }

    @Override
    public List<CollegiateBenchGroupListOutputDTO> toList(List<CollegiateBenchGroup> collegiateBenchGroups) {
        if ( collegiateBenchGroups == null ) {
            return null;
        }

        List<CollegiateBenchGroupListOutputDTO> list = new ArrayList<CollegiateBenchGroupListOutputDTO>( collegiateBenchGroups.size() );
        for ( CollegiateBenchGroup collegiateBenchGroup : collegiateBenchGroups ) {
            list.add( toList( collegiateBenchGroup ) );
        }

        return list;
    }
}
