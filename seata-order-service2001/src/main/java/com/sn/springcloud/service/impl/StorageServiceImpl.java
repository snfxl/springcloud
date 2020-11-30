package com.sn.springcloud.service.impl;

import com.sn.springcloud.entities.CommonResult;
import com.sn.springcloud.service.StorageService;
import org.springframework.stereotype.Component;

/**
 * @Author: shinan
 * @Version: 1.8
 * @create: 2020/11/25 19:53
 * @Description: TODO
 */
//@Component
public class StorageServiceImpl implements StorageService {
    @Override
    public CommonResult<String> decrease(Long productId, Integer count) {
        return new CommonResult<>(400, "发生错误", "没有数据");
    }
}