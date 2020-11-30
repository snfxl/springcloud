package com.sn.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.sn.springcloud.service.SentinelService;
import com.sun.deploy.security.BlockedException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: shinan
 * @Version: 1.8
 * @create: 2020/11/24 14:02
 * @Description: TODO
 */
@RestController()
public class FlowLimitController {

    @Resource
    private SentinelService sentinelService;

    @GetMapping("/test1")
    public String test1() {

        return sentinelService.get();
    }

    @GetMapping("/test2")
    @SentinelResource(value = "test2", blockHandler = "handle")
    public String test2(@RequestParam(value = "p1", required = false) String p1,
                        @RequestParam(value = "p2", required = false) String p2) {

        return "--------------test2";
    }

    public String handle(String p1, String p2, BlockException blockException) {

        return "o(╥﹏╥)o";
    }

}