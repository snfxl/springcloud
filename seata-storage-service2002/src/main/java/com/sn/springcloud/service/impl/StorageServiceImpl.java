package com.sn.springcloud.service.impl;

import com.sn.springcloud.mapper.StorageMapper;
import com.sn.springcloud.service.StorageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: shinan
 * @Version: 1.8
 * @create: 2020/11/26 9:58
 * @Description: TODO
 */
@Service
public class StorageServiceImpl implements StorageService {

    @Resource
    private StorageMapper storageMapper;

    @Override
    public void decrease(Long productId, Integer count) {

        storageMapper.decrease(productId, count);
    }
}