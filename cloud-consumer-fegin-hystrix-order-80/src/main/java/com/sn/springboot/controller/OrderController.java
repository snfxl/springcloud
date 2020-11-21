package com.sn.springboot.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.sn.springboot.service.ProviderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: shinan
 * @Version: 1.8
 * @create: 2020/11/17 17:17
 * @Description: TODO
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "global")
public class OrderController {

    @Resource
    private ProviderService providerService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String ok(@PathVariable("id") Integer id) {

        return providerService.ok(id);
    }

//    @HystrixCommand(fallbackMethod = "errorHandler",
//            commandProperties = {
//                    @HystrixProperty(
//                            name = "execution.isolation.thread.timeoutInMilliseconds",
//                            value = "2000")
//            })
//    @HystrixCommand
    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    public String timeout(@PathVariable("id") Integer id) {

        log.info("aaaa");
        return providerService.timeout(id);
    }

    public String errorHandler(Integer id) {

        return "80服务不想等了O(∩_∩)O哈哈~";
    }

    public String global() {

        return "80服务不想等了O(∩_∩)O哈哈~全局配置";
    }
}