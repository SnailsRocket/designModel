package com.xubo.design.configuration;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import org.redisson.Redisson;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author xubo
 * @Date 2023/7/10 16:18
 * @Description：
 * @Version 1.0
 */
@Configuration
public class RedisConfiguration {

    @Value("${spring.redis.host}")
    private String redisAddress;

    @Value("${spring.redis.port}")
    private String redisPort;

    @Value("${spring.redis.password}")
    private String password;

    @Bean
    public Redisson redisson() {
        Config config = new Config();
        config.useSingleServer()
                .setAddress("redis://" + redisAddress + StringPool.COLON + redisPort)
//                .setPassword(password)
                .setDatabase(0);
        return (Redisson) Redisson.create(config);
    }
}