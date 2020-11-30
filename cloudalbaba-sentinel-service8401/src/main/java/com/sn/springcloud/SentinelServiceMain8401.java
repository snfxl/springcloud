package com.sn.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: shinan
 * @Version: 1.8
 * @create: 2020/11/24 14:01
 * @Description: TODO
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SentinelServiceMain8401 {

    public static void main(String[] args) {

        SpringApplication.run(SentinelServiceMain8401.class, args);
    }
}