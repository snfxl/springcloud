package com.sn.springcloud.mapper;

import com.sn.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: shinan
 * @Version: 1.8
 * @create: 2020/11/14 13:25
 * @Description: TODO
 */
@Mapper
public interface PaymentMapper {

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