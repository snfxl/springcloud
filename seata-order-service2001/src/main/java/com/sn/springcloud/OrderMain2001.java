package com.sn.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @Author: shinan
 * @Version: 1.8
 * @create: 2020/11/25 20:12
 * @Description:
 *      // @SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
 *      需要使用自定义的数据源  不自动加载数据源
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableFeignClients
@EnableDiscoveryClient
public class OrderMain2001 {

    public static void main(String[] args) {

        SpringApplication.run(OrderMain2001.class, args);
    }
}