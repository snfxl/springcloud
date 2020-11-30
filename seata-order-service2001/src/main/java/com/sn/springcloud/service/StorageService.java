package com.sn.springcloud.service;

import com.sn.springcloud.entities.CommonResult;
import com.sn.springcloud.service.impl.StorageServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: shinan
 * @Version: 1.8
 * @create: 2020/11/25 19:47
 * @Description: TODO
 */
@Component
@FeignClient(value = "storage-service")
public interface StorageService {

    @PostMapping("/storage/decrease")
    CommonResult<String> decrease(@RequestParam("productId") Long productId,
                                  @RequestParam("count") Integer count);
}
