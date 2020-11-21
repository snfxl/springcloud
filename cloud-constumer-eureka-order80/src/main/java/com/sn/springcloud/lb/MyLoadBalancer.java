package com.sn.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @Author: shinan
 * @Version: 1.8
 * @create: 2020/11/16 20:14
 * @Description: TODO
 */
public interface MyLoadBalancer {

    /**
     * 获取当前访问选择到的服务提供者微服务
     * @param serviceInstances  所有服务提供者微服务的总数
     * @return 返回选择到的服务
     */
    ServiceInstance instance(List<ServiceInstance> serviceInstances);
}
