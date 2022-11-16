package com.correction.backend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;


@MapperScan({"com.correction.backend.modules.*.mapper"})
@SpringBootApplication(scanBasePackages = {"com.correction.backend","com.correction"})
public class CommunityBackendServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommunityBackendServerApplication.class, args);
    }

}
