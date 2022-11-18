package com.correction.backend.modules.sys.convert.logger;

import com.correction.backend.modules.sys.controller.dto.logger.SysLoginLogCreateReqDTO;
import com.correction.backend.modules.sys.entity.SysLoginLogDO;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-18T00:24:14+0800",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 1.8.0_211 (Oracle Corporation)"
)
public class SysLoginLogConvertImpl implements SysLoginLogConvert {

    @Override
    public SysLoginLogDO convert(SysLoginLogCreateReqDTO bean) {
        if ( bean == null ) {
            return null;
        }

        SysLoginLogDO sysLoginLogDO = new SysLoginLogDO();

        sysLoginLogDO.setLogType( bean.getLogType() );
        sysLoginLogDO.setTraceId( bean.getTraceId() );
        sysLoginLogDO.setResult( bean.getResult() );
        sysLoginLogDO.setUserIp( bean.getUserIp() );
        sysLoginLogDO.setUserAgent( bean.getUserAgent() );

        return sysLoginLogDO;
    }
}
