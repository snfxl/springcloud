package com.sn.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author: shinan
 * @Version: 1.8
 * @create: 2020/11/15 14:19
 * @Description: TODO
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaMain7002 {

    public static void main(String[] args) {

        SpringApplication.run(EurekaMain7002.class, args);
    }
}