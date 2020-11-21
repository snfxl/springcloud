package com.sn.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: shinan
 * @Version: 1.8
 * @create: 2020/11/18 20:16
 * @Description: TODO
 */
@SpringBootApplication
@EnableEurekaClient
public class GatewayMain9527 {

    public static void main(String[] args) {

        SpringApplication.run(GatewayMain9527.class, args);
    }
}