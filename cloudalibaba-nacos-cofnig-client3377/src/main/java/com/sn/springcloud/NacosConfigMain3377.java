package com.sn.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: shinan
 * @Version: 1.8
 * @create: 2020/11/21 12:55
 * @Description: TODO
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosConfigMain3377 {

    public static void main(String[] args) {

        SpringApplication.run(NacosConfigMain3377.class, args);
    }
}