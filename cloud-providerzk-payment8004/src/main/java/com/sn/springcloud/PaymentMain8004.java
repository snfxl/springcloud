package com.sn.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.util.ArrayList;

/**
 * @Author: shinan
 * @Version: 1.8
 * @create: 2020/11/16 12:53
 * @Description:
 *      EnableDiscoveryClient作用：
 *          当以zookeeper或consul作为服务注册中心时，可以将微服务注册到服务注册中心中
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentMain8004 {

    public static void main(String[] args) {

        SpringApplication.run(PaymentMain8004.class, args);

    }
}