package com.sn.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: shinan
 * @Version: 1.8
 * @create: 2020/11/21 10:44
 * @Description: TODO
 */
@RestController
public class NacosProviderController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/nacos/get/{id}")
    public String getId(@PathVariable("id") Integer id) {

        return "nacos本次访问服务端口为：" + serverPort + "   访问id：" + id;
    }
}