package com.sn.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author: shinan
 * @Version: 1.8
 * @create: 2020/11/17 13:01
 * @Description:
 *      EnableFeignClients注解：激活并开启feign相关功能
 */
@SpringBootApplication
@EnableFeignClients
public class ConsumerFeignMain80 {

    public static void main(String[] args) {

        SpringApplication.run(ConsumerFeignMain80.class, args);
    }
}