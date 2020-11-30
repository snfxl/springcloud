package com.sn.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: shinan
 * @Version: 1.8
 * @create: 2020/11/25 11:28
 * @Description: TODO
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosProviderMain9003 {

    public static void main(String[] args) {

        SpringApplication.run(NacosProviderMain9003.class, args);
    }
}