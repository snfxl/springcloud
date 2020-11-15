package com.sn.springcloud.service;

import com.sn.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: shinan
 * @Version: 1.8
 * @create: 2020/11/14 13:51
 * @Description: TODO
 */
public interface PaymentService {

    /**
     * 添加payment
     * @param payment payment对象
     * @return 返回影响行数
     */
    int create(Payment payment);

    /**
     * 根据id查询payment
     * @param id id
     * @return 返回查到的payment
     */
    Payment getPaymentById(@Param("id") Long id);
}
