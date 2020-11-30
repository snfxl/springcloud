package com.sn.springcloud.service.impl;

import com.sn.springcloud.mapper.AccountMapper;
import com.sn.springcloud.service.AccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @Author: shinan
 * @Version: 1.8
 * @create: 2020/11/26 10:27
 * @Description: TODO
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountMapper accountMapper;

    @Override
    public void decrease(Long userId, BigDecimal money) {

        accountMapper.decrease(userId, money);
    }
}