package com.sn.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: shinan
 * @Version: 1.8
 * @create: 2020/11/16 15:53
 * @Description: TODO
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerConsulMain80 {

    public static void main(String[] args) {

        SpringApplication.run(ConsumerConsulMain80.class, args);
    }
}

