package com.sn.springcloud.controller;

import com.sn.springcloud.entities.CommonResult;
import com.sn.springcloud.entities.Payment;
import com.sn.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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
     *
     * @return 测试自己写的轮询算法
     */
    @GetMapping("/lb")
    public String getServerPort(){

        return serverPort;
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