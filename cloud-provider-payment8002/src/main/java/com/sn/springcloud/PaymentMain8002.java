package com.sn.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: shinan
 * @Version: 1.8
 * @create: 2020/11/15 14:46
 * @Description: TODO
 */
@SpringBootApplication
@EnableEurekaClient
public class PaymentMain8002 {

    public static void main(String[] args) {

        SpringApplication.run(PaymentMain8002.class, args);
    }
}