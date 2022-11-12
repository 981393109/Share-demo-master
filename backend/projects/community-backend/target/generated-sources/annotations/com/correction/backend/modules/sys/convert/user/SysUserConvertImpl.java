package com.correction.backend.modules.sys.convert.user;

import com.correction.backend.modules.sys.controller.dto.user.SysUserCreateReqDTO;
import com.correction.backend.modules.sys.controller.dto.user.SysUserUpdateReqDTO;
import com.correction.backend.modules.sys.controller.vo.user.SysUserInfoVO;
import com.correction.backend.modules.sys.controller.vo.user.SysUserPageVO;
import com.correction.backend.modules.sys.entity.SysUserDO;
import com.correction.backend.modules.sys.entity.SysUserDO.SysUserDOBuilder;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-13T00:07:31+0800",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 1.8.0_211 (Oracle Corporation)"
)
public class SysUserConvertImpl implements SysUserConvert {

    @Override
    public SysUserDO convert(SysUserCreateReqDTO bean) {
        if ( bean == null ) {
            return null;
        }

        SysUserDOBuilder sysUserDO = SysUserDO.builder();

        sysUserDO.userNumber( bean.getUserNumber() );
        sysUserDO.userName( bean.getUserName() );
        if ( bean.getStatus() != null ) {
            sysUserDO.status( Integer.parseInt( bean.getStatus() ) );
        }
        sysUserDO.userJobs( bean.getUserJobs() );
        sysUserDO.contactInformation( bean.getContactInformation() );
        sysUserDO.orgInfo( bean.getOrgInfo() );
        sysUserDO.orgId( bean.getOrgId() );
        sysUserDO.password( bean.getPassword() );

        return sysUserDO.build();
    }

    @Override
    public SysUserDO convert(SysUserUpdateReqDTO bean) {
        if ( bean == null ) {
            return null;
        }

        SysUserDOBuilder sysUserDO = SysUserDO.builder();

        sysUserDO.id( bean.getId() );
        sysUserDO.userNumber( bean.getUserNumber() );
        sysUserDO.userName( bean.getUserName() );
        if ( bean.getStatus() != null ) {
            sysUserDO.status( Integer.parseInt( bean.getStatus() ) );
        }
        sysUserDO.userJobs( bean.getUserJobs() );
        sysUserDO.contactInformation( bean.getContactInformation() );
        sysUserDO.orgInfo( bean.getOrgInfo() );
        sysUserDO.orgId( bean.getOrgId() );

        return sysUserDO.build();
    }

    @Override
    public SysUserPageVO convertPage(SysUserDO bean) {
        if ( bean == null ) {
            return null;
        }

        SysUserPageVO sysUserPageVO = new SysUserPageVO();

        sysUserPageVO.setId( bean.getId() );
        sysUserPageVO.setUserNumber( bean.getUserNumber() );
        sysUserPageVO.setUserName( bean.getUserName() );
        if ( bean.getStatus() != null ) {
            sysUserPageVO.setStatus( String.valueOf( bean.getStatus() ) );
        }
        sysUserPageVO.setUserJobs( bean.getUserJobs() );
        sysUserPageVO.setContactInformation( bean.getContactInformation() );
        sysUserPageVO.setOrgInfo( bean.getOrgInfo() );
        sysUserPageVO.setOrgId( bean.getOrgId() );

        return sysUserPageVO;
    }

    @Override
    public SysUserInfoVO convertInfo(SysUserDO bean) {
        if ( bean == null ) {
            return null;
        }

        SysUserInfoVO sysUserInfoVO = new SysUserInfoVO();

        sysUserInfoVO.setId( bean.getId() );
        sysUserInfoVO.setUserNumber( bean.getUserNumber() );
        sysUserInfoVO.setUserName( bean.getUserName() );
        if ( bean.getStatus() != null ) {
            sysUserInfoVO.setStatus( String.valueOf( bean.getStatus() ) );
        }
        sysUserInfoVO.setUserJobs( bean.getUserJobs() );
        sysUserInfoVO.setContactInformation( bean.getContactInformation() );
        sysUserInfoVO.setOrgInfo( bean.getOrgInfo() );
        sysUserInfoVO.setOrgId( bean.getOrgId() );
        sysUserInfoVO.setPassword( bean.getPassword() );

        return sysUserInfoVO;
    }
}
