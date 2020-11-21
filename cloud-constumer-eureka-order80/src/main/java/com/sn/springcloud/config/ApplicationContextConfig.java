package com.sn.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: shinan
 * @Version: 1.8
 * @create: 2020/11/14 16:16
 * @Description: spring配置类
 */
@Configuration
public class ApplicationContextConfig {

    /**
     * 1.注册restTemplate组件
     * 实现微服务之间的横向调用
     * 2.loadBalanced注解 为restTemplate设置一个默认的负载均衡机制
     * @return 返回该对象
     */
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){

        return new RestTemplate();
    }
}