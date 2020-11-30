package com.sn.springcloud.service.impl;

import com.sn.springcloud.doman.Order;
import com.sn.springcloud.mapper.OrderMapper;
import com.sn.springcloud.service.AccountService;
import com.sn.springcloud.service.Orderservice;
import com.sn.springcloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: shinan
 * @Version: 1.8
 * @create: 2020/11/25 19:57
 * @Description: TODO
 */
@Service
@Slf4j
public class OrderServiceImpl implements Orderservice {

    @Resource
    private OrderMapper orderMapper;

    @Resource
    private AccountService accountService;

    @Resource
    private StorageService storageService;

    @Override
    @GlobalTransactional(name = "tx-create-order",rollbackFor = Exception.class)
    public void create(Order order) {

        log.info("=========开始创建订单");
        orderMapper.create(order);

        log.info("订单微服务开始调用库存微服务减少库存");
        log.info(storageService.decrease(order.getProductId(), order.getCount()).getMessage());
        log.info("库存微服务调用结束");

        log.info("订单微服务开始调用账户微服务修改账户余额");
        log.info(accountService.decrease(order.getUserId(), order.getMoney()).getMessage());
        log.info("账户微服务调用结束");

        log.info("订单微服务开始修改订单状态");
        orderMapper.update(order.getUserId(), 1);
        log.info("订单微服务修改订单状态完毕");

    }
}