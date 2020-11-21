package com.sn.springcloud.controller;

import com.sn.springcloud.entities.CommonResult;
import com.sn.springcloud.entities.Payment;
import com.sn.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: shinan
 * @Version: 1.8
 * @create: 2020/11/14 13:55
 * @Description: TODO
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    /**
     * 获取当前微服务的端口号
     * 以便在服务提供者为集群的情况下 知道是哪一个服务提供者提供的服务
     */
    @Value("${server.port}")
    private String serverPort;

    /**
     * 服务发现 对于注册进eureka中的微服务，可以通过服务发现来获得该服务的信息
     * discoveryClient中保存着当前服务中心注册的所有的服务的信息
     */
    @Resource
    private DiscoveryClient discoveryClient;

    /**
     *
     * @return 测试自己写的轮询算法
     */
    @GetMapping("/lb")
    public String getServerPort(){

        return serverPort;
    }

    /**
     * 获取当前服务注册中心所有微服务的信息
     * @return 返回当前服务注册中心所有的微服务信息
     */
    @GetMapping("/payment/discovery")
    public Object discovery(){

        //1.discoveryClient.getServices() 获取当前服务注册中心中的所有服务
        List<String> services = discoveryClient.getServices();
        for(String service: services){
            log.info("*****service: " + service);
        }

        //2.discoveryClient.getInstances("CLOUD-ORDER-SERVICE")
        // 获取服务名称为CLOUD-ORDER-SERVICE的所有信息 例如 服务id 本机ip 端口号 访问地址
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-ORDER-SERVICE");
        for(ServiceInstance serviceInstance:instances){
            log.info(serviceInstance.getServiceId() + "\t" + serviceInstance.getHost()
                    + "\t" + serviceInstance.getPort() + "\t" + serviceInstance.getUri());
        }
        return this.discoveryClient;
    }


    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment) {

        int result = paymentService.create(payment);
        log.info("**********插入结果" + result);

        if (result > 0) {

            return new CommonResult(200, "插入数据成功,serverPort: " + serverPort, result);
        }

        return new CommonResult(444, "插入失败", null);
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {

        Payment paymentById = paymentService.getPaymentById(id);

        log.info("查询信息O(∩_∩)O哈哈~" + paymentById);

        if (paymentById == null) {

            return new CommonResult<>(444, "没有对应记录，查询id是：" + id, null);
        }

        return new CommonResult<>(200, "查找成功,serverPort: " + serverPort, paymentById);
    }
}