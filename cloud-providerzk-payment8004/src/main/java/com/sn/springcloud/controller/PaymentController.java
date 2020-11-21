package com.sn.springcloud.controller;

import com.sn.springcloud.entities.CommonResult;
import com.sn.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * @Author: shinan
 * @Version: 1.8
 * @create: 2020/11/14 13:55
 * @Description: TODO
 */
@RestController
@Slf4j
public class PaymentController {

    /**
     * 获取当前微服务的端口号
     * 以便在服务提供者为集群的情况下 知道是哪一个服务提供者提供的服务
     */
    @Value("${server.port}")
    private String serverPort;

    /**
     *
     * @return 测试是否可以访问
     */
    @GetMapping("/payment/zk")
    public String paymentZookeeper(){

        return "springcloud with zookeeper：" + serverPort + UUID.randomUUID().toString();
    }

}