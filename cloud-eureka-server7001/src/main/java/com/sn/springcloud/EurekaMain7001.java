package com.sn.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author: shinan
 * @Version: 1.8
 * @create: 2020/11/15 12:22
 * @Description: eureka server主启动类  EnableEurekaServer注解  表示当前服务为eureka的服务注册中心
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaMain7001 {

    public static void main(String[] args) {

        SpringApplication.run(EurekaMain7001.class, args);
    }
}