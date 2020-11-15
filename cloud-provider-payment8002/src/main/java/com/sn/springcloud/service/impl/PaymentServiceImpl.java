package com.sn.springcloud.service.impl;

import com.sn.springcloud.entities.Payment;
import com.sn.springcloud.mapper.PaymentMapper;
import com.sn.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: shinan
 * @Version: 1.8
 * @create: 2020/11/14 13:52
 * @Description: TODO
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentMapper paymentMapper;

    @Override
    public int create(Payment payment) {

        return paymentMapper.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {

        return paymentMapper.getPaymentById(id);
    }
}