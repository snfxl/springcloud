package com.sn.springcloud.doman;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: shinan
 * @Version: 1.8
 * @create: 2020/11/26 9:46
 * @Description: TODO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Storage {

    private Long id;
    /**
     * 产品id
     */
    private Long productId;
    /**
     * 总库存
     */
    private Integer total;
    /**
     * 已用库存
     */
    private Integer used;
    /**
     * 剩余库存
     */
    private Integer residue;
}