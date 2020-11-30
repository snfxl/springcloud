package com.sn.springcloud.doman;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @Author: shinan
 * @Version: 1.8
 * @create: 2020/11/25 19:36
 * @Description: TODO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    private Long id;
    private Long userId;
    private Long productId;
    private Integer count;
    private BigDecimal money;

    /**
     * 0 未支付
     * 1 已支付
     */
    private Integer status;

}