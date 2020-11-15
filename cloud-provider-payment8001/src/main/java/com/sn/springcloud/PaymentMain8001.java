package com.sn.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: shinan
 * @Version: 1.8
 * @create: 2020/11/14 11:48
 * @Description:
 *      支付模块微服务主启动类
 *      EnableEurekaClient注解 表示当前服务为eureka的客户端
 *      EnableDiscoveryClient 开启服务发现功能
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class PaymentMain8001 {
    public static void main(String[] args) {

        SpringApplication.run(PaymentMain8001.class, args);
    }
}