package com.sn.springcloud.service;

/**
 * @Author: shinan
 * @Version: 1.8
 * @create: 2020/11/26 9:57
 * @Description: TODO
 */
public interface StorageService {

    void decrease(Long productId,Integer count);
}
