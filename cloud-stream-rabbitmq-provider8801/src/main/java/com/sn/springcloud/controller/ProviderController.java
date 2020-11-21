package com.sn.springcloud.controller;

import com.sn.springcloud.service.MessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: shinan
 * @Version: 1.8
 * @create: 2020/11/20 14:29
 * @Description: TODO
 */
@RestController
public class ProviderController {

    @Resource
    private MessageProvider messageProvider;

    @GetMapping("/sendMessage")
    public String send(){

        return messageProvider.send();
    }
}