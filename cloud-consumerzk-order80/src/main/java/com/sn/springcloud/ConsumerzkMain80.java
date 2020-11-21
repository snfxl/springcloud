package com.sn.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: shinan
 * @Version: 1.8
 * @create: 2020/11/16 14:10
 * @Description: TODO
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerzkMain80 {

    public static void main(String[] args) {

        SpringApplication.run(ConsumerzkMain80.class, args);
    }
}