package com.sn.springcloud.doman;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @Author: shinan
 * @Version: 1.8
 * @create: 2020/11/26 10:21
 * @Description: TODO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    private Long id;
    private Long userId;
    /**
     * 总金额
     */
    private BigDecimal total;

    /**
     * 已用金额
     */
    private BigDecimal used;

    /**
     * 剩余金额
     */
    private BigDecimal residue;
}