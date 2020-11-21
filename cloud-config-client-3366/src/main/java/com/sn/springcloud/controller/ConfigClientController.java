package com.sn.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: shinan
 * @Version: 1.8
 * @create: 2020/11/19 16:05
 * @Description: RefreshScope注解 提供自动刷新功能
 */
@RestController
@RefreshScope
public class ConfigClientController {

    @Value("${config.info}")
    private String configInfo;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/configInfo")
    public String getConfigInfo() {

        return "当前端口号：" + serverPort + "配置文件信息：" + configInfo;
    }
}