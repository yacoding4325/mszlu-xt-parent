package com.mszlu.xt.pojo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Order {

    private Long id;

    private Long userId;

    private String orderId;

    private String payOrderId;

    private Long courseId;

    private BigDecimal orderAmount;

    private Integer orderStatus;

    private Integer payType;

    private Integer payStatus;

    private Long createTime;

    private Integer expireTime;

    private Long payTime;

    private Long couponId;

}
