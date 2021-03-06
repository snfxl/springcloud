package com.sn.springcloud.controller;

import com.sn.springcloud.entities.CommonResult;
import com.sn.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author: shinan
 * @Version: 1.8
 * @create: 2020/11/14 16:06
 * @Description: TODO
 */
@RestController
@Slf4j
public class OrderZKController {

    /**
     * 单机版
     * public static final String PAYMENT_URL = "http://localhost:8001";
     *
     * 集群版 要将消费者服务的访问地址写为 服务提供者的微服务名称
     */
    public static final String PAYMENT_SERVER_NAME = "http://cloud-provider-service";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/zk")
    public String testZk(){

        return restTemplate.getForObject(PAYMENT_SERVER_NAME + "/payment/zk", String.class);
    }
}