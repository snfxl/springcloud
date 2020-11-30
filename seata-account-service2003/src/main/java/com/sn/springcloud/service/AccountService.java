package com.sn.springcloud.service;

import java.math.BigDecimal;

/**
 * @Author: shinan
 * @Version: 1.8
 * @create: 2020/11/26 10:27
 * @Description: TODO
 */
public interface AccountService {

    void decrease(Long userId, BigDecimal money);
}
