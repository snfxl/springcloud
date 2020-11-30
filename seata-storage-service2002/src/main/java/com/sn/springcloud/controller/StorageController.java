package com.sn.springcloud.controller;

import com.sn.springcloud.entities.CommonResult;
import com.sn.springcloud.service.StorageService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: shinan
 * @Version: 1.8
 * @create: 2020/11/26 10:09
 * @Description: TODO
 */
@RestController
public class StorageController {

    @Resource
    private StorageService storageService;

    @PostMapping("/storage/decrease")
    public CommonResult<String> decrease(@RequestParam("productId") Long productId,
                                         @RequestParam("count") Integer count){

        storageService.decrease(productId, count);
        return new CommonResult<>(200, "库存修改成功" );
    }
}