package com.sn.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: shinan
 * @Version: 1.8
 * @create: 2020/11/16 18:52
 * @Description:
 *      Configuration注解：将该类作为一个配置类
 */
@Configuration
public class MySelfRule {

    /**
     *
     * @return 以随机方式来实现负载均衡
     */
    @Bean
    public IRule myRule(){

        return new RandomRule();
    }
}