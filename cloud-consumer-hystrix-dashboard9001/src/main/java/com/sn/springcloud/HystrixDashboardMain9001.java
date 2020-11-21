package com.sn.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @Author: shinan
 * @Version: 1.8
 * @create: 2020/11/18 17:27
 * @Description: TODO
 */
@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashboardMain9001 {

    public static void main(String[] args) {

        SpringApplication.run(HystrixDashboardMain9001.class, args);
    }
}