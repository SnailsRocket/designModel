package com.xubo.design;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author xubo
 * @Date 2023/7/13 15:24
 * @Description：
 * @Version 1.0
 */
@SpringBootApplication
@EnableFeignClients
public class DesignApplication {
    public static void main(String[] args) {
        SpringApplication.run(DesignApplication.class);
    }
}
