package com.sn.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: shinan
 * @Version: 1.8
 * @create: 2020/11/16 20:18
 * @Description: 将该组件添加到容器中
 */
//@Component
public class MyLB implements MyLoadBalancer {

    /**
     * 初始化一个原子类
     */
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    /**
     * @return 获取当前访问的次数
     */
    public final int getCurrent() {

        //上一次访问是第几次
        int prev;
        //现在访问是第几次
        int current;

        do {
            //获取上一次访问是第几次
            prev = this.atomicInteger.get();
            current = prev >= Integer.MAX_VALUE ? 1 : prev + 1;
            //使用CAS和自旋锁
            //CAS 比较并设置  将current与内存中对应的值进行比较 如果相同再修改其的值为next
            //如果期望值与内存值不相同就返回false继续循环 相同返回true循环结束 自旋锁
            //循环结束后current的值 会变为next的值
        } while (!this.atomicInteger.compareAndSet(prev, current));

        System.out.println("当前访问次数：" + current);

        return current;
    }

    @Override
    public ServiceInstance instance(List<ServiceInstance> serviceInstances) {

        int index = getCurrent() % serviceInstances.size();

        System.out.println("当前索引：" + index);

        return serviceInstances.get(index);
    }

    public AtomicInteger getAtomicInteger() {
        return atomicInteger;
    }

    public void setAtomicInteger(AtomicInteger atomicInteger) {
        this.atomicInteger = atomicInteger;
    }
}