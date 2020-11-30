package com.sn.springcloud.service;

import com.sn.springcloud.entities.CommonResult;
import com.sn.springcloud.service.impl.FallBackProviderServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author: shinan
 * @Version: 1.8
 * @create: 2020/11/25 13:39
 * @Description: TODO
 */
@Component
@FeignClient(value = "${service-url.provider-service}",fallback = FallBackProviderServiceImpl.class)
public interface ProviderService {

    @GetMapping("/provider/{id}")
    public CommonResult<String> getById(@PathVariable("id") Integer id);
}
