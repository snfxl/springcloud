package com.sn.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author: shinan
 * @Version: 1.8
 * @create: 2020/11/16 15:58
 * @Description: TODO
 */
@RestController
@Slf4j
public class ConsumerConsulController {

    private static final String PROVIDER_SERVER_URL = "http://cloud-providerConsul-Service";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/consul")
    public String testConsul(){

        return "consumer" + restTemplate.getForObject(PROVIDER_SERVER_URL + "/payment/consul", String.class);
    }
}