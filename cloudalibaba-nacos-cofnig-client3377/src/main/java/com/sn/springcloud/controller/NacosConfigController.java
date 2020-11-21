package com.sn.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: shinan
 * @Version: 1.8
 * @create: 2020/11/21 12:56
 * @Description: RefreshScope 实现配置自动刷新功能
 */
@RestController
@RefreshScope
public class NacosConfigController {

    @Value("${config.info}")
    private String configInfo;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/config")
    public String getConfig() {

        return "当前端口号：" + serverPort + "\t" + "配置文件信息：" + configInfo;
    }
}