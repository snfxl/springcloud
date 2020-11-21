package com.sn.springcloud.service;

import com.sn.springcloud.entities.CommonResult;
import com.sn.springcloud.entities.Payment;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author: shinan
 * @Version: 1.8
 * @create: 2020/11/17 13:06
 * @Description: 通过该接口来调用服务提供者微服务
 */
@Component
@FeignClient("CLOUD-PROVIDER-SERVICE")
public interface ProviderFeignService {

    /**
     * id
     * @param id id
     * @return 向页面返回值 使用commonResult
     */
    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> get(@PathVariable("id") Long id);
}
