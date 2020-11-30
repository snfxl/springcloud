package com.sn.springcloud.controller;

import com.sn.springcloud.doman.Order;
import com.sn.springcloud.entities.CommonResult;
import com.sn.springcloud.service.Orderservice;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: shinan
 * @Version: 1.8
 * @create: 2020/11/26 9:18
 * @Description: TODO
 */
@RestController
@Slf4j
public class OrderController {

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private Orderservice orderservice;

    @GetMapping("/order")
    public CommonResult<String> createOrder(Order order){

        orderservice.create(order);
        return new CommonResult<>(200, "创建成功" , "成功");
    }
}