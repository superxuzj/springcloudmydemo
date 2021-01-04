package com.atguigu.springcloud.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.atguigu.springcloud.dao.PaymentMapper;
import com.atguigu.springcloud.entities.Payment;
@Service
public class PaymentServiceImpl {

    @Resource
    private PaymentMapper paymentMapper;

    public int deleteByPrimaryKey(Long id) {
        return paymentMapper.deleteByPrimaryKey(id);
    }

    public int insert(Payment record) {
        return paymentMapper.insert(record);
    }

    public int insertSelective(Payment record) {
        return paymentMapper.insertSelective(record);
    }

    public Payment selectByPrimaryKey(Long id) {
        return paymentMapper.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(Payment record) {
        return paymentMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(Payment record) {
        return paymentMapper.updateByPrimaryKey(record);
    }

}
