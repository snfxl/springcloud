package com.sn.springcloud.controller;

import com.sn.springcloud.entities.CommonResult;
import com.sn.springcloud.service.AccountService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @Author: shinan
 * @Version: 1.8
 * @create: 2020/11/26 10:29
 * @Description: TODO
 */
@RestController
public class AccountController {

    @Resource
    private AccountService accountService;

    @PostMapping("/account/decrease")
    public CommonResult<String> decrease(@RequestParam("userId") Long userId,
                                         @RequestParam("money") BigDecimal money){

        int i = 10/0;

        accountService.decrease(userId, money);

        return new CommonResult<>(200, "扣除余额成功");
    }
}