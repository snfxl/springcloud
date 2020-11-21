package com.sn.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: shinan
 * @Version: 1.8
 * @create: 2020/11/16 15:33
 * @Description: TODO
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentConsulMain8006 {

    public static void main(String[] args) {

        SpringApplication.run(PaymentConsulMain8006.class, args);
    }
}