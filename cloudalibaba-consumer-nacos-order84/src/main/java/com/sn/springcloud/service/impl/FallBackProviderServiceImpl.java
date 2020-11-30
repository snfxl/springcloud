package com.sn.springcloud.service.impl;

import com.sn.springcloud.entities.CommonResult;
import com.sn.springcloud.service.ProviderService;
import org.springframework.stereotype.Component;

/**
 * @Author: shinan
 * @Version: 1.8
 * @create: 2020/11/25 13:56
 * @Description: TODO
 */
@Component
public class FallBackProviderServiceImpl implements ProviderService {

    @Override
    public CommonResult<String> getById(Integer id) {

        return new CommonResult<>(555, "错误了feign兜底", "没有数据");
    }
}