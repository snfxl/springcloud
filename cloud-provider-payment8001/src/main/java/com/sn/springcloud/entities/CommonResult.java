package com.sn.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: shinan
 * @Version: 1.8
 * @create: 2020/11/14 13:06
 * @Description: json封装体 用来向前端返回信息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {

    /**
     * 响应状态码
     */
    private Integer code;

    /**
     * 响应信息
     */
    private String message;

    /**
     * 响应数据
     */
    private T data;

    /**
     * 响应数据为null时的构造器
     * @param code 响应状态码
     * @param message 响应信息
     */
    public CommonResult(Integer code, String message) {
        this(code, message, null);
    }
}