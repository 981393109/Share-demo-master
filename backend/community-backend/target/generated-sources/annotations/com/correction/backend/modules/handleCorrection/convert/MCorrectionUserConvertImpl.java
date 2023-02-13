package com.correction.backend.modules.handleCorrection.convert;

import com.correction.backend.modules.handleCorrection.controller.dto.CorrectionUserCreateInputDTO;
import com.correction.backend.modules.handleCorrection.controller.dto.CorrectionUserListOutputDTO;
import com.correction.backend.modules.handleCorrection.controller.dto.CorrectionUserSearchInputDTO;
import com.correction.backend.modules.handleCorrection.controller.dto.CorrectionUserUpdateInputDTO;
import com.correction.backend.modules.handleCorrection.entity.CorrectionUser;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-13T01:51:15+0800",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 1.8.0_211 (Oracle Corporation)"
)
public class MCorrectionUserConvertImpl implements MCorrectionUserConvert {

    @Override
    public CorrectionUser toCorrectionUser(CorrectionUserSearchInputDTO correctionUserSearchInputDTO) {
        if ( correctionUserSearchInputDTO == null ) {
            return null;
        }

        CorrectionUser correctionUser = new CorrectionUser();

        correctionUser.setCreateTime( correctionUserSearchInputDTO.getCreateTime() );
        correctionUser.setUpdateTime( correctionUserSearchInputDTO.getUpdateTime() );
        correctionUser.setCreator( correctionUserSearchInputDTO.getCreator() );
        correctionUser.setUpdater( correctionUserSearchInputDTO.getUpdater() );
        correctionUser.setDeleted( correctionUserSearchInputDTO.getDeleted() );
        correctionUser.setName( correctionUserSearchInputDTO.getName() );
        correctionUser.setSex( correctionUserSearchInputDTO.getSex() );
        correctionUser.setBirthday( correctionUserSearchInputDTO.getBirthday() );
        correctionUser.setHousehold( correctionUserSearchInputDTO.getHousehold() );
        correctionUser.setNativePlace( correctionUserSearchInputDTO.getNativePlace() );
        correctionUser.setAddress( correctionUserSearchInputDTO.getAddress() );
        correctionUser.setMobile( correctionUserSearchInputDTO.getMobile() );
        correctionUser.setMaritalStatus( correctionUserSearchInputDTO.getMaritalStatus() );
        correctionUser.setProfessional( correctionUserSearchInputDTO.getProfessional() );
        correctionUser.setEconomyState( correctionUserSearchInputDTO.getEconomyState() );
        correctionUser.setAreaJurisdiction( correctionUserSearchInputDTO.getAreaJurisdiction() );
        correctionUser.setStreetJurisdiction( correctionUserSearchInputDTO.getStreetJurisdiction() );
        correctionUser.setCauseAction( correctionUserSearchInputDTO.getCauseAction() );
        correctionUser.setHandleCorrectionId( correctionUserSearchInputDTO.getHandleCorrectionId() );
        correctionUser.setOrgNum( correctionUserSearchInputDTO.getOrgNum() );
        correctionUser.setCorrectionStartDate( correctionUserSearchInputDTO.getCorrectionStartDate() );
        correctionUser.setCorrectionEndDate( correctionUserSearchInputDTO.getCorrectionEndDate() );
        correctionUser.setManagementLevel( correctionUserSearchInputDTO.getManagementLevel() );
        correctionUser.setIsHistory( correctionUserSearchInputDTO.getIsHistory() );

        return correctionUser;
    }

    @Override
    public CorrectionUser toCorrectionUser(CorrectionUserCreateInputDTO correctionUserCreateInputDTO) {
        if ( correctionUserCreateInputDTO == null ) {
            return null;
        }

        CorrectionUser correctionUser = new CorrectionUser();

        correctionUser.setCreateTime( correctionUserCreateInputDTO.getCreateTime() );
        correctionUser.setUpdateTime( correctionUserCreateInputDTO.getUpdateTime() );
        correctionUser.setCreator( correctionUserCreateInputDTO.getCreator() );
        correctionUser.setUpdater( correctionUserCreateInputDTO.getUpdater() );
        correctionUser.setDeleted( correctionUserCreateInputDTO.getDeleted() );
        correctionUser.setName( correctionUserCreateInputDTO.getName() );
        correctionUser.setSex( correctionUserCreateInputDTO.getSex() );
        correctionUser.setBirthday( correctionUserCreateInputDTO.getBirthday() );
        correctionUser.setHousehold( correctionUserCreateInputDTO.getHousehold() );
        correctionUser.setNativePlace( correctionUserCreateInputDTO.getNativePlace() );
        correctionUser.setAddress( correctionUserCreateInputDTO.getAddress() );
        correctionUser.setMobile( correctionUserCreateInputDTO.getMobile() );
        correctionUser.setMaritalStatus( correctionUserCreateInputDTO.getMaritalStatus() );
        correctionUser.setProfessional( correctionUserCreateInputDTO.getProfessional() );
        correctionUser.setEconomyState( correctionUserCreateInputDTO.getEconomyState() );
        correctionUser.setAreaJurisdiction( correctionUserCreateInputDTO.getAreaJurisdiction() );
        correctionUser.setStreetJurisdiction( correctionUserCreateInputDTO.getStreetJurisdiction() );
        correctionUser.setCauseAction( correctionUserCreateInputDTO.getCauseAction() );
        correctionUser.setHandleCorrectionId( correctionUserCreateInputDTO.getHandleCorrectionId() );
        correctionUser.setOrgNum( correctionUserCreateInputDTO.getOrgNum() );
        correctionUser.setCorrectionStartDate( correctionUserCreateInputDTO.getCorrectionStartDate() );
        correctionUser.setCorrectionEndDate( correctionUserCreateInputDTO.getCorrectionEndDate() );
        correctionUser.setManagementLevel( correctionUserCreateInputDTO.getManagementLevel() );

        return correctionUser;
    }

    @Override
    public CorrectionUser toCorrectionUser(CorrectionUserUpdateInputDTO correctionUserUpdateInputDTO) {
        if ( correctionUserUpdateInputDTO == null ) {
            return null;
        }

        CorrectionUser correctionUser = new CorrectionUser();

        correctionUser.setCreateTime( correctionUserUpdateInputDTO.getCreateTime() );
        correctionUser.setUpdateTime( correctionUserUpdateInputDTO.getUpdateTime() );
        correctionUser.setCreator( correctionUserUpdateInputDTO.getCreator() );
        correctionUser.setUpdater( correctionUserUpdateInputDTO.getUpdater() );
        correctionUser.setDeleted( correctionUserUpdateInputDTO.getDeleted() );
        correctionUser.setId( correctionUserUpdateInputDTO.getId() );
        correctionUser.setName( correctionUserUpdateInputDTO.getName() );
        correctionUser.setSex( correctionUserUpdateInputDTO.getSex() );
        correctionUser.setBirthday( correctionUserUpdateInputDTO.getBirthday() );
        correctionUser.setHousehold( correctionUserUpdateInputDTO.getHousehold() );
        correctionUser.setNativePlace( correctionUserUpdateInputDTO.getNativePlace() );
        correctionUser.setAddress( correctionUserUpdateInputDTO.getAddress() );
        correctionUser.setMobile( correctionUserUpdateInputDTO.getMobile() );
        correctionUser.setMaritalStatus( correctionUserUpdateInputDTO.getMaritalStatus() );
        correctionUser.setProfessional( correctionUserUpdateInputDTO.getProfessional() );
        correctionUser.setEconomyState( correctionUserUpdateInputDTO.getEconomyState() );
        correctionUser.setAreaJurisdiction( correctionUserUpdateInputDTO.getAreaJurisdiction() );
        correctionUser.setStreetJurisdiction( correctionUserUpdateInputDTO.getStreetJurisdiction() );
        correctionUser.setCauseAction( correctionUserUpdateInputDTO.getCauseAction() );
        correctionUser.setHandleCorrectionId( correctionUserUpdateInputDTO.getHandleCorrectionId() );
        correctionUser.setOrgNum( correctionUserUpdateInputDTO.getOrgNum() );
        correctionUser.setCorrectionStartDate( correctionUserUpdateInputDTO.getCorrectionStartDate() );
        correctionUser.setCorrectionEndDate( correctionUserUpdateInputDTO.getCorrectionEndDate() );
        correctionUser.setManagementLevel( correctionUserUpdateInputDTO.getManagementLevel() );

        return correctionUser;
    }

    @Override
    public CorrectionUserListOutputDTO toList(CorrectionUser correctionUser) {
        if ( correctionUser == null ) {
            return null;
        }

        CorrectionUserListOutputDTO correctionUserListOutputDTO = new CorrectionUserListOutputDTO();

        correctionUserListOutputDTO.setId( correctionUser.getId() );
        correctionUserListOutputDTO.setName( correctionUser.getName() );
        correctionUserListOutputDTO.setSex( correctionUser.getSex() );
        correctionUserListOutputDTO.setBirthday( correctionUser.getBirthday() );
        correctionUserListOutputDTO.setHousehold( correctionUser.getHousehold() );
        correctionUserListOutputDTO.setNativePlace( correctionUser.getNativePlace() );
        correctionUserListOutputDTO.setAddress( correctionUser.getAddress() );
        correctionUserListOutputDTO.setMobile( correctionUser.getMobile() );
        correctionUserListOutputDTO.setMaritalStatus( correctionUser.getMaritalStatus() );
        correctionUserListOutputDTO.setProfessional( correctionUser.getProfessional() );
        correctionUserListOutputDTO.setEconomyState( correctionUser.getEconomyState() );
        correctionUserListOutputDTO.setAreaJurisdiction( correctionUser.getAreaJurisdiction() );
        correctionUserListOutputDTO.setStreetJurisdiction( correctionUser.getStreetJurisdiction() );
        correctionUserListOutputDTO.setCauseAction( correctionUser.getCauseAction() );
        correctionUserListOutputDTO.setHandleCorrectionId( correctionUser.getHandleCorrectionId() );
        correctionUserListOutputDTO.setOrgNum( correctionUser.getOrgNum() );
        correctionUserListOutputDTO.setCreateTime( correctionUser.getCreateTime() );
        correctionUserListOutputDTO.setUpdateTime( correctionUser.getUpdateTime() );
        correctionUserListOutputDTO.setCreator( correctionUser.getCreator() );
        correctionUserListOutputDTO.setUpdater( correctionUser.getUpdater() );
        correctionUserListOutputDTO.setDeleted( correctionUser.getDeleted() );
        correctionUserListOutputDTO.setCorrectionStartDate( correctionUser.getCorrectionStartDate() );
        correctionUserListOutputDTO.setCorrectionEndDate( correctionUser.getCorrectionEndDate() );
        correctionUserListOutputDTO.setManagementLevel( correctionUser.getManagementLevel() );

        return correctionUserListOutputDTO;
    }

    @Override
    public List<CorrectionUserListOutputDTO> toList(List<CorrectionUser> correctionUsers) {
        if ( correctionUsers == null ) {
            return null;
        }

        List<CorrectionUserListOutputDTO> list = new ArrayList<CorrectionUserListOutputDTO>( correctionUsers.size() );
        for ( CorrectionUser correctionUser : correctionUsers ) {
            list.add( toList( correctionUser ) );
        }

        return list;
    }
}
