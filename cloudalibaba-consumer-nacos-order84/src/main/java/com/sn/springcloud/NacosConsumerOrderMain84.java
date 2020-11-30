package com.sn.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author: shinan
 * @Version: 1.8
 * @create: 2020/11/25 12:00
 * @Description: TODO
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class NacosConsumerOrderMain84 {

    public static void main(String[] args) {

        SpringApplication.run(NacosConsumerOrderMain84.class, args);
    }
}