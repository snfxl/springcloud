package com.sn.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: shinan
 * @Version: 1.8
 * @create: 2020/11/25 20:04
 * @Description:
 *      mybatis配置文件
 *      MapperScan注解 指定mapper接口的位置
 */
@Configuration
@MapperScan("com.sn.springcloud.mapper")
public class MybatisConfig {
}