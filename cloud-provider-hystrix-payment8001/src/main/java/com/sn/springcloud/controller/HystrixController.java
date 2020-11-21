package com.sn.springcloud.controller;

import com.sn.springcloud.service.HystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @Author: shinan
 * @Version: 1.8
 * @create: 2020/11/17 15:37
 * @Description: TODO
 */
@RestController
@Slf4j
public class HystrixController {

    @Resource
    private HystrixService hystrixService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String ok(@PathVariable("id") Integer id) {

        return hystrixService.ok(id);
    }

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String timeout(@PathVariable("id") Integer id) {

        log.info("aaaa");
        return hystrixService.timeout(id);
    }

    //=========================服务熔断

    @GetMapping("/payment/circuit/{id}")
    public String circuitBreaker(@PathVariable("id") Integer id) {

        return hystrixService.circuitBreaker(id);
    }

}