package com.sn.springcloud.controller;

import com.sn.springcloud.entities.CommonResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: shinan
 * @Version: 1.8
 * @create: 2020/11/25 11:29
 * @Description: TODO
 */
@RestController
public class ProviderController {

    @Value("${server.port}")
    private String serverPort;

    private static Map<Integer,String> ids = new HashMap<>();

    static {

        ids.put(1, "aaaa");
        ids.put(2, "bbbb");
        ids.put(3, "cccc");
    }

    @GetMapping("/provider/{id}")
    public CommonResult<String> getById(@PathVariable("id") Integer id){

        return new CommonResult<>(200, "请求成功处理端口号：" + serverPort, ids.get(id));
    }
}