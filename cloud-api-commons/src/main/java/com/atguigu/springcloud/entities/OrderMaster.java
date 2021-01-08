package com.atguigu.springcloud.entities;

import lombok.Data;

/**
 * @author zhijian.xu
 * @date 2021/1/8
 **/
@Data
public class OrderMaster {
    private Integer orderStatus;
    private Integer payStatus;

    private String buyerName;
    private String buyerAddress;
    private String buyerPhone;
    private String orderId;
}
