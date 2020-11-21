package com.sn.springcloud.controller;

import com.sn.springcloud.entities.CommonResult;
import com.sn.springcloud.entities.Payment;
import com.sn.springcloud.lb.MyLB;
import com.sn.springcloud.lb.MyLoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: shinan
 * @Version: 1.8
 * @create: 2020/11/14 16:06
 * @Description: TODO
 */
@RestController
@Slf4j
public class OrderController {

    /**
     * 单机版
     * public static final String PAYMENT_URL = "http://localhost:8001";
     * <p>
     * 集群版 要将消费者服务的访问地址写为 服务提供者的微服务名称
     */
    public static final String PAYMENT_SERVER_NAME = "http://CLOUD-PROVIDER-SERVICE";

    @Value("{server.port}")
    private String serverPort;

    /**
     * 实现微服务之间的横向调用
     */
    @Resource
    private RestTemplate restTemplate;

    @Resource
    private DiscoveryClient discoveryClient;

    /**
     * 获取自己注册的lb组件
     */
//    @Resource
//    private MyLoadBalancer myLoadBalancer;

//    @GetMapping("/consumer/lb")
//    public ServiceInstance testMyLB() {
//
//        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-provider-service".toUpperCase());
//
//        if (instances == null || instances.size() <= 0) {
//
//            return null;
//        }
//
//        ServiceInstance instance = myLoadBalancer.instance(instances);
//
//        System.out.println("第一个元素端口号" + instances.get(0).getPort() + "\t" + "url：" + instances.get(0).getUri());
//        System.out.println("第二个元素端口号" + instances.get(1).getPort() + "\t" + "url：" + instances.get(1).getUri());
//
//        return instance;
////        return instance.getPort() + "/t" + instance.getUri();
////        return "当前即将要调用的服务端口号为：" + instance.getPort() + "\t" + "调用的是：" +
////                restTemplate.getForObject(instance.getUri() + "/lb", String.class);
//    }

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment) {

        return restTemplate.postForObject(PAYMENT_SERVER_NAME + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {

        return restTemplate.getForObject(PAYMENT_SERVER_NAME + "/payment/get/" + id, CommonResult.class);
    }
}