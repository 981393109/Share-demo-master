package com.correction.backend.modules.sys.convert.auth;

import com.correction.backend.modules.sys.entity.SysUserDO;
import com.correction.framework.security.core.LoginUser;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-13T00:07:31+0800",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 1.8.0_211 (Oracle Corporation)"
)
public class SysAuthConvertImpl implements SysAuthConvert {

    @Override
    public LoginUser convert(SysUserDO bean) {
        if ( bean == null ) {
            return null;
        }

        LoginUser loginUser = new LoginUser();

        loginUser.setId( bean.getId() );
        loginUser.setPassword( bean.getPassword() );
        loginUser.setStatus( bean.getStatus() );

        return loginUser;
    }
}
