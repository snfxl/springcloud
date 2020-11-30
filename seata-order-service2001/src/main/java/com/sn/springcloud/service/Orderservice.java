package com.sn.springcloud.service;

import com.sn.springcloud.doman.Order;
import com.sn.springcloud.mapper.OrderMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.security.PrivateKey;

/**
 * @Author: shinan
 * @Version: 1.8
 * @create: 2020/11/25 19:46
 * @Description: TODO
 */
public interface Orderservice {

    void create(Order order);
}
