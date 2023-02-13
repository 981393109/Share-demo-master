package com.correction.backend;

import com.correction.framework.schedule.service.ScheduleCoreService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;


@MapperScan({"com.correction.*.*.*.mapper","com.correction.*.*.mapper"})
@SpringBootApplication(scanBasePackages = {"com.correction.backend","com.correction"})
public class CommunityBackendServerApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(CommunityBackendServerApplication.class, args);
    }

    @Autowired
    private ScheduleCoreService scheduleCoreService;
    
    @Override
    public void run(String... args) throws Exception {
        scheduleCoreService.initTask();
    }
}
