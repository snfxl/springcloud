package com.sn.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author: shinan
 * @Version: 1.8
 * @create: 2020/11/17 17:13
 * @Description: TODO
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableCircuitBreaker
public class ConsumerFeignHystrixMain80 {

    public static void main(String[] args) {

        SpringApplication.run(ConsumerFeignHystrixMain80.class, args);
    }
}