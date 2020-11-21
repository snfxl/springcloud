package com.sn.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: shinan
 * @Version: 1.8
 * @create: 2020/11/21 10:42
 * @Description: TODO
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosProviderMain9001 {

    public static void main(String[] args) {

        SpringApplication.run(NacosProviderMain9001.class, args);
    }
}