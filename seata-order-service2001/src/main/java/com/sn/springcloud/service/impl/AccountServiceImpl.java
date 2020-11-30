package com.sn.springcloud.service.impl;

import com.sn.springcloud.entities.CommonResult;
import com.sn.springcloud.service.AccountService;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * @Author: shinan
 * @Version: 1.8
 * @create: 2020/11/25 19:48
 * @Description: TODO
 */
//@Component
public class AccountServiceImpl implements AccountService {

    @Override
    public CommonResult<String> decrease(Long userId, BigDecimal money) {

        return new CommonResult<>(400, "发生错误", "没有数据");
    }
}