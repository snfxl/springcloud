package com.sn.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author: shinan
 * @Version: 1.8
 * @create: 2020/11/21 11:18
 * @Description: TODO
 */
@RestController
public class NacosConsumerController {

    @Resource
    private RestTemplate restTemplate;

    @Value("${service-url.nacos-user-service}")
    private String nacosUserService;

    @GetMapping("/consumer/get/{id}")
    public String getProvider(@PathVariable("id") Integer id){

        return restTemplate.getForObject(nacosUserService + "/nacos/get/" + id, String.class);
    }
}