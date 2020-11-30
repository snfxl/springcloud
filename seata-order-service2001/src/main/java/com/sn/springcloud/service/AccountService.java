package com.sn.springcloud.service;

import com.sn.springcloud.entities.CommonResult;
import com.sn.springcloud.service.impl.AccountServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @Author: shinan
 * @Version: 1.8
 * @create: 2020/11/25 19:47
 * @Description: TODO
 */
@Component
@FeignClient(value = "account-service")
public interface AccountService {

    @PostMapping("/account/decrease")
    CommonResult<String> decrease(@RequestParam("userId") Long userId, @RequestParam("money")BigDecimal money);
}
