package com.sn.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: shinan
 * @Version: 1.8
 * @create: 2020/11/19 15:55
 * @Description: TODO
 */
@SpringBootApplication
@EnableEurekaClient
public class ConfigClientMain3355 {

    public static void main(String[] args) {

        SpringApplication.run(ConfigClientMain3355.class, args);
    }
}