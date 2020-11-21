package com.sn.springcloud;

import com.sn.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @Author: shinan
 * @Version: 1.8
 * @create: 2020/11/14 16:01
 * @Description: 服务消费者微服务主启动类
 *      RibbonClient注解：
 *          在微服务启动时，加载自定义的ribbon配置类
 *          > configuration = MySelfRule.class 加载哪个配置类
 *          > name = "CLOUD_PAYMENT_SERVICE" 指定哪个服务使用该配置类中的配置
 */
@SpringBootApplication
@EnableEurekaClient
//@RibbonClient(name = "CLOUD-PROVIDER-SERVICE",configuration = MySelfRule.class)
public class OrderMain80 {

    public static void main(String[] args) {

        SpringApplication.run(OrderMain80.class, args);
    }
}