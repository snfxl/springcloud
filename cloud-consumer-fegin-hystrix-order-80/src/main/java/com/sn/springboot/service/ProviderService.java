package com.sn.springboot.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author: shinan
 * @Version: 1.8
 * @create: 2020/11/17 17:14
 * @Description: TODO
 */
@Component
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX",fallback = FallbackProviderServiceImpl.class)
public interface ProviderService {

    @GetMapping("/payment/hystrix/ok/{id}")
    public String ok(@PathVariable("id") Integer id);

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String timeout(@PathVariable("id") Integer id);

}
