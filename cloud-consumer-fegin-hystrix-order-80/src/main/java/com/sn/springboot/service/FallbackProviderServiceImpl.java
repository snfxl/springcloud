package com.sn.springboot.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Author: shinan
 * @Version: 1.8
 * @create: 2020/11/18 11:02
 * @Description: ProviderService 为该接口中的方法设置fallback
 */
@Component
@Slf4j
public class FallbackProviderServiceImpl implements ProviderService {

    @Override
    public String ok(Integer id) {

        log.info("来处理异常了O(∩_∩)O哈哈~");
        return "ok在接口实现类中统一处理异常信息";
    }

    @Override
    public String timeout(Integer id) {

        return "timeout在接口实现类中统一处理异常信息";
    }
}