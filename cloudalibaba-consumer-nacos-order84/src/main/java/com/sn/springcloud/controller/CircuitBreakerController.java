package com.sn.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.sn.springcloud.entities.CommonResult;
import com.sn.springcloud.service.ProviderService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author: shinan
 * @Version: 1.8
 * @create: 2020/11/25 12:01
 * @Description: TODO
 */
@RestController
public class CircuitBreakerController {

    @Value("${service-url.provider-service}")
    private String providerServiceName;

    @Resource
    private RestTemplate restTemplate;

    //    @SentinelResource(value = "circuitBreaker",fallback = "handler")
    //    @SentinelResource(value = "circuitBreaker")
    @GetMapping("/consumer/{id}")
    @SentinelResource(value = "circuitBreaker",blockHandler = "handler",fallback = "handlerFallback")
    public CommonResult<String> circuitBreaker(@PathVariable("id") Integer id){

        CommonResult<String> result = restTemplate.getForObject(providerServiceName + "/provider/" + id, CommonResult.class,id);
        if (id == 4) {

            throw new IllegalArgumentException("非法参数异常");
        } else if (result.getData() == null) {

            throw new NullPointerException("不存在");
        }

        return result;
    }

    public CommonResult<String> handler(Integer id, BlockException blockException){

        return new CommonResult<>(401, "发生错误", "没有获取到数据");
    }
    public CommonResult<String> handlerFallback(Integer id){

        return new CommonResult<>(400, "发生错误", "没有获取到数据");
    }

    //======================= 使用openfeign调用服务提供者
    @Resource
    private ProviderService providerService;

    @GetMapping("/consumer/feign/{id}")
    @SentinelResource(value = "circuitBreakerFeign",blockHandler = "handler",fallback = "handlerFallback")
    public CommonResult<String> circuitBreakerFeign(@PathVariable("id") Integer id){

        CommonResult<String> result = providerService.getById(id);

//        if (id == 4) {
//
//            throw new IllegalArgumentException("非法参数异常");
//        } else if (result.getData() == null) {
//
//            throw new NullPointerException("不存在");
//        }

        return result;
    }
}