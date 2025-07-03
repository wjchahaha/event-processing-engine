package com.qihang.config;

import lombok.Data;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.config.SingleServerConfig;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

/**
 * @author qihang
 * @description redisson配置
 * @date 2025/06/30 19:53
 */
@Configuration
@Data
@ConfigurationProperties("spring.redis")
public class RedissonConfig {

    /**
     * redis 地址 redis://ip:port
     */
    private String address;
    /**
     * 密码
     */
    private String password;
    /**
     * db
     */
    private int database = 0;

    /**
     * 功能描述: 获取redssionClient对象
     * @param:
     * @auther: XuZhao
     * @date: 20/08/20 上午 10:22
     * @return:
     */
    @Bean
    public RedissonClient redissonClient() {
        Config config = new Config();
        SingleServerConfig singleServerConfig = config.useSingleServer().setAddress(address);

        if (!StringUtils.isEmpty(password)) {
            singleServerConfig.setPassword(password);
        }
        singleServerConfig.setDatabase(database);
//        config.setCodec(new org.redisson.client.codec.StringCodec());
        config.setCodec(new org.redisson.codec.JsonJacksonCodec());
        config.setNettyThreads(4);
        return Redisson.create(config);
    }
}