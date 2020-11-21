package com.sn.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @Author: shinan
 * @Version: 1.8
 * @create: 2020/11/17 15:31
 * @Description: TODO
 */
@Service
@DefaultProperties(defaultFallback = "globalHandler")
public class HystrixService {

    /**
     * 正常执行
     *
     * @return
     */
    @HystrixCommand
    public String ok(Integer id) {

        int i = 10 / 0;

        return "线程池：" + Thread.currentThread().getName()
                + "执行的方法是：ok   id:" + id + "O(∩_∩)O哈哈";
    }

    /**
     * 设定 3秒以内正常执行
     * 超过3秒报错
     *
     * @return
     */
    @HystrixCommand(fallbackMethod = "timeoutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",
                    value = "5000")
    })
    public String timeout(Integer id) {

        int time = 3;

        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "线程池：" + Thread.currentThread().getName()
                + "执行的方法是： no  id:" + id;
    }

    public String timeoutHandler(Integer id) {

        return "8001服务报错：请求超时请重试";
    }

    public String globalHandler() {

        return "使用全局处理：8001，请求超时";
    }

    //======================================================服务熔断相关

    @HystrixCommand(fallbackMethod = "circuitBreakerFallback",
            commandProperties = {
                    @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "2000"),
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "30")
            })
    public String circuitBreaker(Integer id) {

        if (id < 2) {

            throw new RuntimeException("********id太小");
        }

        return "服务熔断相关调用成功O(∩_∩)O哈哈~" + System.currentTimeMillis();
    }

    public String circuitBreakerFallback(Integer id) {

        return "******id：" + id + "太小了，请重试";
    }
}