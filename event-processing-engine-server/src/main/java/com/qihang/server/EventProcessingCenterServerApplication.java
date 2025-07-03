package com.qihang.server;

import com.qihang.common.log.annotation.EnableAopLog;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
* 主启动
* @author system
*/
@EnableAsync
@EnableCaching
@EnableScheduling
@EnableAopLog
@SpringBootApplication
@EnableConfigurationProperties
@EnableAspectJAutoProxy(proxyTargetClass = true)
@ComponentScan(basePackages = "com.qihang")
@EnableFeignClients(basePackages = "com.qihang")
@EnableDiscoveryClient
public class EventProcessingCenterServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(EventProcessingCenterServerApplication.class, args);
    }
}