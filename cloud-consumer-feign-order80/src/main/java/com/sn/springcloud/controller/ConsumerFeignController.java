package com.sn.springcloud.controller;

import com.sn.springcloud.entities.CommonResult;
import com.sn.springcloud.entities.Payment;
import com.sn.springcloud.service.ProviderFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: shinan
 * @Version: 1.8
 * @create: 2020/11/17 13:20
 * @Description: TODO
 */
@RestController
public class ConsumerFeignController {

    @Resource
    private ProviderFeignService providerFeignService;

    @GetMapping("/consumer/feign/{id}")
    public CommonResult<Payment> testFeign(@PathVariable("id") Long id){

        return providerFeignService.get(id);
    }
}